package com.exigen.modules.claim.gb_tl.certificate;

import com.exigen.ipb.eisa.utils.Currency;
import com.exigen.istf.data.TestData;
import com.exigen.modules.claim.ClaimGroupBenefitsTLBaseTest;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.modules.claim.common.metadata.PaymentPaymentPaymentAllocationTabMetaData;
import com.exigen.ren.main.modules.claim.common.metadata.PaymentPaymentPaymentDetailsTabMetaData;
import com.exigen.ren.main.modules.claim.common.tabs.BenefitReservesActionTab;
import com.exigen.ren.main.modules.claim.common.tabs.PaymentPaymentPaymentAllocationTab;
import com.exigen.ren.main.modules.claim.common.tabs.PaymentPaymentPaymentDetailsTab;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomSoftAssertions.assertSoftly;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestTLClaimPending extends ClaimGroupBenefitsTLBaseTest {
    private String reverseType = tdClaim.getTestData("ClaimPayment", "TestData_FinalPayment").getValue(
            PaymentPaymentPaymentAllocationTab.class.getSimpleName(), PaymentPaymentPaymentAllocationTabMetaData.RESERVE_TYPE.getLabel());
    private Currency reverseAmount = new Currency(tdClaim.getTestData("BenefitReserves", "TestData").getValue(
            BenefitReservesActionTab.class.getSimpleName(), reverseType + " Reserve"));

    @Test(priority = 28)
    public void testClaimPendTL1() throws IOException {
        logger = extent.startTest(groupNo + " TermLife claim Adjudication");
        prop.load(fileInput);
        pName = "other";
        reportLog("Searching for Customer", 0);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnTLCp();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        termLifeClaim.create(termLifeClaim.getDefaultTestData("DataGatherCertificatePendClaim1", TestDataKey.DEFAULT_TEST_DATA_KEY));
        reportLog("Creating Claim...", 1);
        claim.claimOpen().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Add Single Benefit Calculations for Benefit to Claim #" + claimNumber, 1);
        claim.calculateSingleBenefitAmount().perform(tdClaim.getTestData("CalculateASingleBenefitAmountAdjudication1", "TestData"), 1);
        claim.addBenefitReserves().perform(tdClaim.getTestData("BenefitReserves", "TestData"), 1);
        reportLog("Adding BenefitReserves", 1);
        claim.changeSingleBenefitCalculationStatus().perform(tdClaim.getTestData("FeatureClose", "TestData"), 1);
        reportLog("TEST: Post Supplemental Payment for Claim #"+claimNumber, 1);
        Currency supplementalAmount = reverseAmount.subtract(new Currency("1.0"));

        claim.addPayment().perform(tdClaim.getTestData("ClaimPayment", "TestData_SupplementalPayment")
                .adjust(TestData.makeKeyPath(PaymentPaymentPaymentDetailsTab.class.getSimpleName(), PaymentPaymentPaymentDetailsTabMetaData.GROSS_AMOUNT.getLabel()),
                        supplementalAmount.toPlainString())
                .resolveLinks()
                .adjust(TestData.makeKeyPath(PaymentPaymentPaymentAllocationTab.class.getSimpleName(), PaymentPaymentPaymentAllocationTabMetaData.ALLOCATION_AMOUNT.getLabel()),
                        supplementalAmount.toPlainString())
                .resolveLinks());
        reportLog("Pending Claim", 1);
        assertSoftly(softly -> {
            softly.assertThat(ClaimSummaryPage.tableSummaryOfClaimPaymentsAndRecoveries).hasRows(1);
            softly.assertThat(ClaimSummaryPage.tableSummaryOfClaimPaymentsAndRecoveries.getRow(1).getCell(ClaimConstants.ClaimSummaryOfPaymentsAndRecoveriesTable.TRANSACTION_STATUS)).hasValue("Pending");
        });

        claim.viewSingleBenefitCalculation().perform(1);

        assertSoftly(softly -> {
            softly.assertThat(ClaimSummaryPage.tableBeneficiaryPayments).hasRows(1);
            softly.assertThat(ClaimSummaryPage.tableBeneficiaryPayments.getRow(1).getCell(ClaimConstants.ClaimBeneficiaryPaymentsTable.TRANSACTION_STATUS)).hasValue("Pending");
            softly.assertThat(ClaimSummaryPage.tableBeneficiaryPayments.getRow(1).getCell(ClaimConstants.ClaimBeneficiaryPaymentsTable.TOTAL_PAYMENT_AMOUNT)).hasValue(supplementalAmount.toString());
        });
        reportLog("==========================================", 1);

    }
}
