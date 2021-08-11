package com.exigen.modules.claim.gb_std.certificate;

import com.exigen.helpers.CommonGenericMethods;
import com.exigen.ipb.eisa.base.application.ApplicationFactory;
import com.exigen.ipb.eisa.utils.Currency;
import com.exigen.istf.data.TestData;
import com.exigen.modules.claim.ClaimGroupBenefitsSTDBaseTest;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.common.pages.MainPage;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.modules.claim.common.metadata.PaymentPaymentPaymentAllocationTabMetaData;
import com.exigen.ren.main.modules.claim.common.tabs.BenefitReservesActionTab;
import com.exigen.ren.main.modules.claim.common.tabs.PaymentPaymentPaymentAllocationTab;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestSTDClaimIssuePayment extends ClaimGroupBenefitsSTDBaseTest {
    private TestData paymentData = tdClaim.getTestData("ClaimPayment", "TestData_PartialPayment");
    private String reverseType = paymentData.getValue(
            PaymentPaymentPaymentAllocationTab.class.getSimpleName(), PaymentPaymentPaymentAllocationTabMetaData.RESERVE_TYPE.getLabel());
    private Currency reverseAmount = new Currency(tdClaim.getTestData("BenefitReserves", "TestData").getValue(
            BenefitReservesActionTab.class.getSimpleName(), reverseType + " Reserve"));

    @Test(priority = 40)
    public void testClaimIssuePayment1_STD() throws IOException {
        logger = extent.startTest(groupNo + "TestSTDClaimIssuePayment");
        prop.load(fileInput);
        pName = "other";
        reportLog("Searching for Customer", 0);
        //To Test DXP
        CommonGenericMethods.searchSpecificParticipant("Kristan","9055");
        String cpNumber = returnSTDCPForSpecifiedParticipant();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        disabilityClaim.create(disabilityClaim.getSTDTestData().getTestData("DataGatherCertificate", TestDataKey.DEFAULT_TEST_DATA_KEY));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.INITIAL);
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog(claimNumber + " status: " + ClaimSummaryPage.labelClaimStatus.getValue(), 1);
        reportLog("Open Claim",1);
        claim.claimOpen().perform();
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.OPEN);
        reportLog(claimNumber + " status: " + ClaimSummaryPage.labelClaimStatus.getValue(), 1);
        reportLog("Calculate Single Benefit Amount",1);
        claim.calculateSingleBenefitAmount().perform(tdClaim.getTestData("CalculateASingleBenefitAmount", "TestDataWithDeductions"), 1);
        reportLog("Add Benefit Reverse",1);
        claim.addBenefitReserves().perform(tdClaim.getTestData("BenefitReserves", "TestData"), 1);

        reportLog("Post Partial Payment for Claim #" + claimNumber,1);
        Currency paymentAmount = reverseAmount.subtract(new Currency("1.0"));
        claim.addPayment().perform(paymentData
                .adjust(TestData.makeKeyPath(PaymentPaymentPaymentAllocationTab.class.getSimpleName(), PaymentPaymentPaymentAllocationTabMetaData.ALLOCATION_AMOUNT.getLabel()),
                        paymentAmount.toPlainString())
                .resolveLinks());

        reportLog("TEST: Issue Payment for Claim #" + claimNumber,1);
        ApplicationFactory.getInstance().getMainApplication().close();
        ApplicationFactory.getInstance().getMainApplication().reopen(approvalUsername, approvalPassword);
        MainPage.QuickSearch.search(claimNumber);
        claim.approvePayment().perform(tdClaim.getTestData("ClaimPayment", "TestData_ApprovePayment"), 1);

        claim.issuePayment().perform(tdClaim.getTestData("ClaimPayment", "TestData_IssuePayment"), 1);

        assertThat(ClaimSummaryPage.tableSummaryOfClaimPaymentsAndRecoveries.getRow(1).getCell(ClaimConstants.ClaimSummaryOfPaymentsAndRecoveriesTable.TRANSACTION_STATUS)).hasValue("Issued");
        ApplicationFactory.getInstance().getMainApplication().close();
        initializeDriverAndApp();
    }

}
