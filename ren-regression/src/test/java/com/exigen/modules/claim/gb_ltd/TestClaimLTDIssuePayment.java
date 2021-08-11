package com.exigen.modules.claim.gb_ltd;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.ipb.eisa.base.application.ApplicationFactory;
import com.exigen.ipb.eisa.utils.Currency;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.Browser;
import com.exigen.istf.webdriver.BrowserController;
import com.exigen.modules.claim.ClaimGroupBenefitsLTDBaseTest;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.MainPage;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.modules.claim.common.metadata.PaymentPaymentPaymentAllocationTabMetaData;
import com.exigen.ren.main.modules.claim.common.tabs.BenefitReservesActionTab;
import com.exigen.ren.main.modules.claim.common.tabs.PaymentPaymentPaymentAllocationTab;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.helpers.CommonGenericMethods.saveParticipantInfoForDXPBilling;
import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestClaimLTDIssuePayment extends ClaimGroupBenefitsLTDBaseTest {
    private TestData paymentData = tdClaim.getTestData("ClaimPayment", "TestData_PartialPayment");
    private String reverseType = paymentData.getValue(
            PaymentPaymentPaymentAllocationTab.class.getSimpleName(), PaymentPaymentPaymentAllocationTabMetaData.RESERVE_TYPE.getLabel());
    private Currency reverseAmount = new Currency(tdClaim.getTestData("BenefitReserves", "TestData").getValue(
            BenefitReservesActionTab.class.getSimpleName(), reverseType + " Reserve"));

    @Test(priority = 45)
    public void testClaimIssuePayment1() throws IOException {
        logger = extent.startTest(groupNo + "STAT claim IssuePayment");
        prop.load(fileInput);
        reportLog("Searching for certificate policy...", 0);
        //To Test DXP
        CommonGenericMethods.searchSpecificParticipant("Kristan","9055");
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Long Term Disability')]/..//td[1]")).click();
        PolicySummaryPage.labelPolicyStatus.waitForPageUpdate();
        saveParticipantInfoForDXPBilling("Kristan", prop.getProperty("lastName"),PolicySummaryPage.linkMasterPolicy.getValue());
        String cpNumber = returnLTDCPForSpecifiedParticipant();
        reportLog("Searching for Cp : " + cpNumber, 1);
        search(cpNumber);
        reportLog("Create Claim : " + cpNumber, 1);

        disabilityClaim.create(disabilityClaim.getLTDTestData().getTestData("DataGatherCertificate", TestDataKey.DEFAULT_TEST_DATA_KEY));
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Created Claim Number : " + claimNumber, 1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.INITIAL);
        reportLog(claimNumber + " status: " + ClaimSummaryPage.labelClaimStatus.getValue(), 1);
        reportLog(claimNumber + " Created for: " + ClaimSummaryPage.labelInsuredName.getValue(), 1);
        reportLog(" Open Claim: " + claimNumber, 1);
        claim.claimOpen().perform();
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.OPEN);
        reportLog(claimNumber + " status: " + ClaimSummaryPage.labelClaimStatus.getValue(), 1);
        reportLog(" Calculate Single Benefit Amount" , 1);
        claim.calculateSingleBenefitAmount().perform(tdClaim.getTestData("CalculateASingleBenefitAmount", "TestData_LTD"), 1);
        reportLog("Calculate Benefit Reverse",1);
        claim.addBenefitReserves().perform(tdClaim.getTestData("BenefitReserves", "TestData"), 1);
        reportLog("Post Partial Payment for Claim #" + claimNumber,1);
        Currency paymentAmount = reverseAmount.subtract(new Currency("1.0"));
        reportLog("Add Payment",1);
        claim.addPayment().perform(paymentData.adjust(TestData.makeKeyPath(PaymentPaymentPaymentAllocationTab.class.getSimpleName(), PaymentPaymentPaymentAllocationTabMetaData.ALLOCATION_AMOUNT.getLabel()),
                paymentAmount.toPlainString()).resolveLinks());
        reportLog("Issue Payment for Claim #" + claimNumber,1);
        ApplicationFactory.getInstance().getMainApplication().close();
        ApplicationFactory.getInstance().getMainApplication().reopen(approvalUsername, approvalPassword);
        MainPage.QuickSearch.search(claimNumber);
        reportLog("Approve Payment",1);
        claim.approvePayment().perform(tdClaim.getTestData("ClaimPayment", "TestData_ApprovePayment"), 1);
        reportLog("Issue Payment",1);
        claim.issuePayment().perform(tdClaim.getTestData("ClaimPayment", "TestData_IssuePayment"), 1);
        assertThat(ClaimSummaryPage.tableSummaryOfClaimPaymentsAndRecoveries.getRow(1).getCell(ClaimConstants.ClaimSummaryOfPaymentsAndRecoveriesTable.TRANSACTION_STATUS)).hasValue("Issued");
        ApplicationFactory.getInstance().getMainApplication().close();
        initializeDriverAndApp();
    }
}
