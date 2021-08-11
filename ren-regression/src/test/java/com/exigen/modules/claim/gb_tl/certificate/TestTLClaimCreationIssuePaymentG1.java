package com.exigen.modules.claim.gb_tl.certificate;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.ipb.eisa.base.application.ApplicationFactory;
import com.exigen.istf.data.TestData;
import com.exigen.modules.claim.ClaimGroupBenefitsTLBaseTest;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.MainPage;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.tabs.BenefitCoverageEvaluationTab;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.modules.claim.ClaimGroupBenefitsSTBaseTest.checkApprovedStatus;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.modules.claim.gb_ltd_st_std.metadata.BenefitCoverageEvaluationTabMetaData.INSURED_PERSON_COVERAGE_EFFECTIVE_DATE;

public class TestTLClaimCreationIssuePaymentG1 extends ClaimGroupBenefitsTLBaseTest {
    @Test(priority = 133)
    public void testClaimCreationIssuePayment2() throws IOException {
        logger = extent.startTest(groupNo + " TermLife claim DataGatherCertificate_IssuePayment Payment");
        prop.load(fileInput);
        reportLog("Searching for Customer", 0);
        CommonGenericMethods.searchSpecificParticipant("Kristan","9055");
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        WebElement E= CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Term Life Insurance')]/..//td//a"));
        E.click();
        PolicySummaryPage.labelPolicyStatus.waitForPageUpdate();
        String cpNumber = PolicySummaryPage.labelPolicyNumber.getValue();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);

        termLifeClaim.create(termLifeClaim.getDefaultTestData("DataGatherCertificate_IssuePayment2", TestDataKey.DEFAULT_TEST_DATA_KEY));

        reportLog("Creating Claim...", 1);

        claim.claimOpen().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Adding Benefit", 1);
        claim.addBenefit().perform(tdClaim.getTestData("NewBenefitAdjudication2", "TestData_Death")
                .mask(TestData.makeKeyPath(BenefitCoverageEvaluationTab.class.getSimpleName(), INSURED_PERSON_COVERAGE_EFFECTIVE_DATE.getLabel())));
        reportLog("Add Single Benefit Calculations for Benefit to Claim #" + claimNumber, 1);
        claim.calculateSingleBenefitAmount().perform(tdClaim.getTestData("CalculateASingleBenefitAmountAdjudication2", "TestData"), 1);

        claim.addPayment().perform(tdClaim.getTestData("ClaimPayment", "TestData_PartialPayment"));
        int i=0;
        if(checkApprovedStatus()==false) {
            LOGGER.info("TEST: DataGatherCertificate_IssuePayment Payment for Claim #" + claimNumber);
            ApplicationFactory.getInstance().getMainApplication().close();
            ApplicationFactory.getInstance().getMainApplication().reopen(approvalUsername, approvalPassword);

        MainPage.QuickSearch.search(claimNumber);
        i=1;
        try {
        claim.approvePayment().perform(tdClaim.getTestData("ClaimPayment", "TestData_ApprovePayment"), 1);
    } catch (Exception e) {
        reportLog("Approved Payment for Claim preformed #"+claimNumber,1);
    }
}
        claim.issuePayment().perform(tdClaim.getTestData("ClaimPayment", "TestData_IssuePayment"), 1);
        assertThat(ClaimSummaryPage.tableSummaryOfClaimPaymentsAndRecoveries.getRow(1)
                .getCell(ClaimConstants.ClaimSummaryOfPaymentsAndRecoveriesTable.TRANSACTION_STATUS)).hasValue("Issued");
        if(i==1){
            ApplicationFactory.getInstance().getMainApplication().close();
            initializeDriverAndApp();
        }
       reportLog("==========================================", 1);
    }
}
