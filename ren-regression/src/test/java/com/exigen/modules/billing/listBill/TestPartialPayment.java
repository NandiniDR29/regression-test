package com.exigen.modules.billing.listBill;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.modules.billing.GroupBenefitsBillingBaseTest;
import com.exigen.modules.billing.account.BillingAccountContext;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.pages.summary.billing.BillingSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestPartialPayment extends GroupBenefitsBillingBaseTest implements BillingAccountContext {
    @Test(priority = 18)
    public void testPartialPayment() throws IOException {
        logger = extent.startTest(groupNo + " Perform Partial Payment");
        prop.load(fileInput);
        reportLog("Navigating to Billing Account: ", 0);
        for (Map.Entry<String, String> BillingAccountAndProduct : CommonGenericMethods.getBillingAccount(groupNo).entrySet()) {
            reportLog("Searching for Billing Account: " + BillingAccountAndProduct.getValue(), 1);
            search(BillingAccountAndProduct.getValue());
            reportLog("Performing Partial Payment for the Product ::: " + BillingAccountAndProduct.getKey() + ":::", 1);
            BillingSummaryPage.tableBillingGeneralInformation.getRow(1)
                    .getCell(TableConstants.BillingGeneralInformationGB.TOTAL_DUE.getName()).waitFor(cell -> !cell.getValue().equals("Calculating..."));
            String partialPaymentAmount = "10";
            reportLog("Partial Payment amount is ::: " + partialPaymentAmount, 1);
            billingAccount.acceptPayment().perform(billingAccount.getDefaultTestData("AcceptPayment", "TestData_EFT_PartialPayment"), partialPaymentAmount);
            validatePartialPayment();
            break;
        }
        reportLog("========================================", 1);
    }

    private void validatePartialPayment() {
        BillingSummaryPage.tableBillingGeneralInformation.getRow(1)
                .getCell("Suspense Amount").waitFor(cell -> !cell.getValue().equals("Calculating..."));
        BillingSummaryPage.tableBillingGeneralInformation.getRow(1)
                .getCell("Suspense Amount").getValue().equals("$10.00");
    }
}
