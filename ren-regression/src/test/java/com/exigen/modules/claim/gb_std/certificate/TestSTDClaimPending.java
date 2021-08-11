package com.exigen.modules.claim.gb_std.certificate;

import com.exigen.ipb.eisa.utils.Currency;
import com.exigen.istf.data.TestData;
import com.exigen.modules.claim.ClaimGroupBenefitsSTDBaseTest;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.modules.claim.common.metadata.PaymentPaymentPaymentAllocationTabMetaData;
import com.exigen.ren.main.modules.claim.common.tabs.BenefitReservesActionTab;
import com.exigen.ren.main.modules.claim.common.tabs.PaymentPaymentPaymentAllocationTab;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.tabs.BenefitCoverageEvaluationTab;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomSoftAssertions.assertSoftly;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.modules.claim.gb_ltd_st_std.metadata.BenefitCoverageEvaluationTabMetaData.INSURED_PERSON_COVERAGE_EFFECTIVE_DATE;

public class TestSTDClaimPending extends ClaimGroupBenefitsSTDBaseTest {
    private String reverseType = tdClaim.getTestData("ClaimPayment", "TestData_FinalPayment").getValue(
            PaymentPaymentPaymentAllocationTab.class.getSimpleName(), PaymentPaymentPaymentAllocationTabMetaData.RESERVE_TYPE.getLabel());
    private Currency reverseAmount = new Currency(tdClaim.getTestData("BenefitReserves", "TestData").getValue(
            BenefitReservesActionTab.class.getSimpleName(), reverseType + " Reserve"));

    @Test(priority = 43)
    public void testClaimAddBenefit() throws IOException {
        logger = extent.startTest(groupNo + " TestSTDClaimPending");
        prop.load(fileInput);
        pName = "other";
        reportLog("Searching for customer", 0);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnSTDCp();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Creating Claim", 1);
        disabilityClaim.create(disabilityClaim.getSTDTestData().getTestData("DataGatherCertificatePendClaim1", "TestData"));
        reportLog("Open Claim", 1);
        claim.claimOpen().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Adding Benefit", 1);
        claim.addBenefit().perform(tdClaim.getTestData("NewBenefitAdjudication1", "TestData_STD_OtherValues")
                .mask(TestData.makeKeyPath(BenefitCoverageEvaluationTab.class.getSimpleName(), INSURED_PERSON_COVERAGE_EFFECTIVE_DATE.getLabel())));
        reportLog("Add Single Benefit Calculations for Benefit to Claim #" + claimNumber, 1);
        claim.calculateSingleBenefitAmount().perform(tdClaim.getTestData("CalculateASingleBenefitAmountAdjudication1", "TestData_STD"), 1);

        claim.addBenefitReserves().perform(tdClaim.getTestData("BenefitReserves", "TestData"), 1);
        reportLog("Added Benefit Reserves...", 1);
        claim.changeSingleBenefitCalculationStatus().perform(tdClaim.getTestData("FeatureClose", "TestData"), 1);
        reportLog("Close Claim...", 1);
        reportLog("TEST: Post Supplemental Payment for Claim #" + claimNumber, 1);
        Currency supplementalAmount = reverseAmount.subtract(new Currency("1.0"));
        reportLog("Claim Payment done...", 1);
        claim.addPayment().perform(tdClaim.getTestData("ClaimPayment", "TestData_SupplementalPayment_Pending")
                .adjust(TestData.makeKeyPath(PaymentPaymentPaymentAllocationTab.class.getSimpleName(), PaymentPaymentPaymentAllocationTabMetaData.ALLOCATION_AMOUNT.getLabel()),
                        supplementalAmount.toPlainString())
                .resolveLinks());
        reportLog("Claim Pending...", 1);
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
