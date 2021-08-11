package com.exigen.modules.claim.gb_ac.certificate;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.ipb.eisa.utils.Currency;
import com.exigen.istf.data.TestData;
import com.exigen.modules.claim.ClaimGroupBenefitsACBaseTest;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.modules.claim.common.metadata.PaymentPaymentPaymentAllocationTabMetaData;
import com.exigen.ren.main.modules.claim.common.tabs.BenefitReservesActionTab;
import com.exigen.ren.main.modules.claim.common.tabs.PaymentPaymentPaymentAllocationTab;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.modules.claim.gb_ac.certificate.TestClaimACAdjudication1.returnACCPForSpecifiedParticipant;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestClaimACIssuePaymentG1 extends ClaimGroupBenefitsACBaseTest {

    private TestData paymentData = tdClaim.getTestData("ClaimPayment", "TestData_PartialPayment");
    private String reverseType = paymentData.getValue(
            PaymentPaymentPaymentAllocationTab.class.getSimpleName(), PaymentPaymentPaymentAllocationTabMetaData.RESERVE_TYPE.getLabel());
    private Currency reverseAmount = new Currency(tdClaim.getTestData("BenefitReserves", "TestData").getValue(
            BenefitReservesActionTab.class.getSimpleName(), reverseType + " Reserve"));

    @Test(priority = 134)
    public void testClaimIssuePayment1_ACC() throws IOException {
        logger = extent.startTest(groupNo + "Group Accident claim IssuePayment");
        prop.load(fileInput);
        reportLog("Searching for Cp ", 0);
        //To Test DXP
        CommonGenericMethods.searchSpecificParticipant("Kristan","9055");
        String cpNumber = returnACCPForSpecifiedParticipant();
        search(cpNumber);
        reportLog("Create Claim : "+cpNumber, 1);
        accHealthClaim.create(accHealthClaim.getGbACTestData().getTestData("DataGatherCertificate_Adjudication1", TestDataKey.DEFAULT_TEST_DATA_KEY));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.INITIAL);
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog(claimNumber + " status: " + ClaimSummaryPage.labelClaimStatus.getValue(), 1);
        claim.claimOpen().perform();
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.OPEN);
        reportLog(claimNumber + " status: " + ClaimSummaryPage.labelClaimStatus.getValue(), 1);
        reportLog("Calculate Single Benefit Account",1);
        claim.calculateSingleBenefitAmount().perform(tdClaim.getTestData("CalculateASingleBenefitAmount", "TestData_AccidentalDeath"), 1);
        reportLog("Post Partial Payment for Claim #" + claimNumber,1);
        claim.addPayment().perform(tdClaim.getTestData("ClaimPayment", "TestData_PartialPaymentG1"));
        reportLog("Issue Payment for Claim #" + claimNumber,1);
        claim.issuePayment().perform(tdClaim.getTestData("ClaimPayment", "TestData_IssuePayment"), 1);
        assertThat(ClaimSummaryPage.tableSummaryOfClaimPaymentsAndRecoveries.getRow(1)
                .getCell(ClaimConstants.ClaimSummaryOfPaymentsAndRecoveriesTable.TRANSACTION_STATUS)).hasValue("Issued");
        reportLog("=============================",1);

    }
    public String returnACCCp(){
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Group Accident')]/..//td[1]")).click();
        PolicySummaryPage.labelPolicyStatus.waitForPageUpdate();
        WebElement cpList = CommonBaseTest.driver.findElements(By.xpath("(//span[.='Policy Active']/../..//td//a[contains(@id,'productConsolidatedViewForm:rootInstancesTable_certificate:')])")).get(0);
        return cpList.getText();
    }

}
