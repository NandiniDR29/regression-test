package com.exigen.modules.claim.gb_ac.certificate;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.ipb.eisa.utils.Currency;
import com.exigen.istf.data.TestData;
import com.exigen.modules.claim.ClaimGroupBenefitsACBaseTest;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.modules.claim.common.metadata.PaymentPaymentPaymentAllocationTabMetaData;
import com.exigen.ren.main.modules.claim.common.metadata.PaymentPaymentPaymentDetailsTabMetaData;
import com.exigen.ren.main.modules.claim.common.tabs.BenefitReservesActionTab;
import com.exigen.ren.main.modules.claim.common.tabs.PaymentPaymentPaymentAllocationTab;
import com.exigen.ren.main.modules.claim.common.tabs.PaymentPaymentPaymentDetailsTab;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.istf.verification.CustomSoftAssertions.assertSoftly;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestACClaimPending extends ClaimGroupBenefitsACBaseTest {
    private String reverseType = tdClaim.getTestData("ClaimPayment", "TestData_FinalPayment").getValue(
            PaymentPaymentPaymentAllocationTab.class.getSimpleName(), PaymentPaymentPaymentAllocationTabMetaData.RESERVE_TYPE.getLabel());
    private Currency reverseAmount = new Currency(tdClaim.getTestData("BenefitReserves", "TestData").getValue(
            BenefitReservesActionTab.class.getSimpleName(), reverseType + " Reserve"));

    @Test(priority = 28)
    public void testClaimPendAC1() throws IOException {
        logger = extent.startTest(groupNo + " Group Accident claim Adjudication");
        prop.load(fileInput);
        reportLog("Searching for customer ", 0);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnACCCp();
        search(cpNumber);
        reportLog("Create Claim : "+cpNumber, 1);
        accHealthClaim.create(accHealthClaim.getGbACTestData().getTestData("DataGatherPendClaim1", TestDataKey.DEFAULT_TEST_DATA_KEY));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.INITIAL);
        reportLog("Open claim", 1);
        claim.claimOpen().perform();
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.OPEN);
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog(claimNumber + " status: " + ClaimSummaryPage.labelClaimStatus.getValue(), 1);
        reportLog("Calculate Benefit amount", 1);
        claim.calculateSingleBenefitAmount().perform(tdClaim.getTestData("CalculateASingleBenefitAmount_Adjudication1", "TestData_AccidentalDeath"), 1);
        reportLog("Calculate Benefit Reverse",1);
        claim.addBenefitReserves().perform(tdClaim.getTestData("BenefitReserves", "TestData"), 1);
        reportLog("Closing the Claim", 1);
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
    public String returnACCCp(){
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Group Accident')]/..//td[1]")).click();
        PolicySummaryPage.labelPolicyStatus.waitForPageUpdate();
        WebElement cpList = CommonBaseTest.driver.findElements(By.xpath("(//span[.='Policy Active']/../..//td//a[contains(@id,'productConsolidatedViewForm:rootInstancesTable_certificate:')])")).get(0);
        return cpList.getText();

    }
}
