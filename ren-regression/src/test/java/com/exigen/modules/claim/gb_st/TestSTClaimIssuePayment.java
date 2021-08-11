package com.exigen.modules.claim.gb_st;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.ipb.eisa.base.application.ApplicationFactory;
import com.exigen.ipb.eisa.utils.Currency;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.modules.claim.ClaimGroupBenefitsSTBaseTest;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.pages.MainPage;
import com.exigen.ren.main.modules.claim.common.metadata.PaymentPaymentPaymentAllocationTabMetaData;
import com.exigen.ren.main.modules.claim.common.tabs.BenefitReservesActionTab;
import com.exigen.ren.main.modules.claim.common.tabs.PaymentPaymentPaymentAllocationTab;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestSTClaimIssuePayment extends ClaimGroupBenefitsSTBaseTest {

    private TestData paymentData = tdClaim.getTestData("ClaimPayment", "TestData_PartialPayment");
    private String reverseType = paymentData.getValue(
            PaymentPaymentPaymentAllocationTab.class.getSimpleName(), PaymentPaymentPaymentAllocationTabMetaData.RESERVE_TYPE.getLabel());
    private Currency reverseAmount = new Currency(tdClaim.getTestData("BenefitReserves", "TestData").getValue(
            BenefitReservesActionTab.class.getSimpleName(), reverseType + " Reserve"));

    @Test(priority = 31)
    public void testClaimIssuePayment_STAT1() throws IOException {
        logger = extent.startTest(groupNo + "STAT claim IssuePayment");
        prop.load(fileInput);
        reportLog("Searching for Claim", 0);
        search(prop.getProperty("ClaimNumberFotStat"));
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Calculate Single Benefit Amount",1);
        claim.calculateSingleBenefitAmount().perform(tdClaim.getTestData("CalculateASingleBenefitAmount", "TestData_ST"), 1);
        reportLog("Benefit Reverse Amount",1);
        claim.addBenefitReserves().perform(tdClaim.getTestData("BenefitReserves", "TestData"), 1);
        reportLog("Post Partial Payment for Claim #" + claimNumber,1);
        Currency paymentAmount = reverseAmount.subtract(new Currency("1.0"));
        claim.addPayment().perform(paymentData
                .adjust(TestData.makeKeyPath(PaymentPaymentPaymentAllocationTab.class.getSimpleName(), PaymentPaymentPaymentAllocationTabMetaData.ALLOCATION_AMOUNT.getLabel()),
                        paymentAmount.toPlainString())
                .resolveLinks());
        reportLog("Issue Payment for Claim #" + claimNumber,1);
        int i=0;
        if(checkApprovedStatus()==false) {
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
        if(i==1){
            ApplicationFactory.getInstance().getMainApplication().close();
            initializeDriverAndApp();
        }
        reportLog("===============================================", 1);

    }


}
