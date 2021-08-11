package com.exigen.modules.claim.gb_pfl;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.ipb.eisa.base.application.ApplicationFactory;
import com.exigen.ipb.eisa.utils.Currency;
import com.exigen.istf.data.TestData;
import com.exigen.modules.claim.ClaimGroupBenefitsPFLBaseTest;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.common.pages.MainPage;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.modules.claim.common.metadata.PaymentPaymentPaymentAllocationTabMetaData;
import com.exigen.ren.main.modules.claim.common.tabs.BenefitReservesActionTab;
import com.exigen.ren.main.modules.claim.common.tabs.PaymentPaymentPaymentAllocationTab;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.helpers.CommonGenericMethods.statProductMasterPolicy;
import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestPFLClaimIssuePayment extends ClaimGroupBenefitsPFLBaseTest {
    private TestData paymentData = tdClaim.getTestData("ClaimPayment", "TestData_PartialPayment");
    private String reverseType = paymentData.getValue(
            PaymentPaymentPaymentAllocationTab.class.getSimpleName(), PaymentPaymentPaymentAllocationTabMetaData.RESERVE_TYPE.getLabel());
    private Currency reverseAmount = new Currency(tdClaim.getTestData("BenefitReserves", "TestData").getValue(
            BenefitReservesActionTab.class.getSimpleName(), reverseType + " Reserve"));
    @Test(priority = 28)
    public void testClaimIssuePayment1_PFL() throws IOException {
        logger = extent.startTest(groupNo + "PFL claim IssuePayment");
        prop.load(fileInput);
        reportLog("Searching for certificate policy...", 0);
        search(prop.getProperty("CustomerNumber"));
        String pflMp = statProductMasterPolicy("Paid Family Leave");
        search(pflMp);
        disabilityClaim.create(disabilityClaim.getPFLTestData().getTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.INITIAL);
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog(claimNumber + " status: " + ClaimSummaryPage.labelClaimStatus.getValue(), 1);
        claim.claimOpen().perform();
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.OPEN);
       reportLog("Calculate Single Benefit",1);
        claim.calculateSingleBenefitAmount().perform(tdClaim.getTestData("CalculateASingleBenefitAmount", TestDataKey.DEFAULT_TEST_DATA_KEY), 1);
        reportLog("Calculate Benefit Reverse",1);
        claim.addBenefitReserves().perform(tdClaim.getTestData("BenefitReserves", "TestData"), 1);
        reportLog("TEST: Post Partial Payment for Claim #" + claimNumber,1);
        Currency paymentAmount = reverseAmount.subtract(new Currency("1.0"));
        claim.addPayment().perform(paymentData
                .adjust(TestData.makeKeyPath(PaymentPaymentPaymentAllocationTab.class.getSimpleName(), PaymentPaymentPaymentAllocationTabMetaData.ALLOCATION_AMOUNT.getLabel()),
                        paymentAmount.toPlainString())
                .resolveLinks());
        reportLog("TEST: Issue Payment for Claim #" + claimNumber,1);

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
