package com.exigen.modules.billing.listBill;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.helpers.billing.BillingHelper;
import com.exigen.modules.billing.GroupBenefitsBillingBaseTest;
import com.exigen.modules.billing.account.BillingAccountContext;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.pages.summary.billing.BillingSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.BillingConstants.BillsAndStatementsStatusGB.PAID_IN_FULL;
import static com.exigen.ren.main.enums.BillingConstants.PaymentsAndOtherTransactionTypeGB.PAYMENT;
import static com.exigen.ren.main.enums.TableConstants.BillingGeneralInformationGB.TOTAL_PAID;
import static com.exigen.ren.main.enums.TableConstants.BillingPaymentsAndTransactionsGB.TYPE;

public class TestDeclinePayment extends GroupBenefitsBillingBaseTest implements BillingAccountContext {
    @Test(priority = 20)
    public void testDeclinePayment() throws IOException {
        logger = extent.startTest(groupNo+" Perform Decline Payment");
        prop.load(fileInput);
        for(Map.Entry<String, String> BillingAccountAndProduct : CommonGenericMethods.getBillingAccount(groupNo).entrySet()){
            reportLog("Searching for Billing Account: " + BillingAccountAndProduct.getValue(), 0);
            search(BillingAccountAndProduct.getValue());
            reportLog("Performing Decline Payment for the Product ::: " + BillingAccountAndProduct.getKey() +":::", 1);
            BillingSummaryPage.tableBillingGeneralInformation.getRow(1)
                    .getCell(TableConstants.BillingGeneralInformationGB.TOTAL_PAID.getName()).waitFor(cell -> !cell.getValue().equals("Calculating..."));
            String totalPaidDue = BillingSummaryPage.tableBillingGeneralInformation.getRow(1).getCell(TOTAL_PAID.getName()).getValue();
            reportLog("Decline Payment for Billing Account # " + BillingAccountAndProduct.getValue(), 1);
            billingAccount.declinePayment().perform(billingAccount.getDefaultTestData("DeclinePayment", "TestData"), 1);
            search(BillingAccountAndProduct.getValue());
            reportLog("Verify Decline Payment", 1);
            declinePaymentVerification(totalPaidDue);
            reportLog("Performing Payment for Billing Account # " + BillingAccountAndProduct.getValue(), 1);
            BillingSummaryPage.tableBillingGeneralInformation.getRow(1)
                    .getCell(TableConstants.BillingGeneralInformationGB.TOTAL_DUE.getName()).waitFor(cell -> !cell.getValue().equals("Calculating..."));
            String totalDueAmount = BillingSummaryPage.tableBillingGeneralInformation.getRow(1).getCell(TableConstants.BillingGeneralInformationGB.TOTAL_DUE.getName()).getValue();
            System.out.println("Total due amount is ::: "+ totalDueAmount);
            billingAccount.acceptPayment().perform(billingAccount.getDefaultTestData("AcceptPayment", "TestData_EFT_Invoice"), totalDueAmount.replace("$","")  );
            reportLog("Validating Payment for Billing Account # " + BillingAccountAndProduct.getValue(), 1);
            validatePayment(totalDueAmount);
            break;
        }

    }

    protected void declinePaymentVerification(String totalPaidDue) {
        assertThat(BillingSummaryPage.tableBillingGeneralInformation).isPresent().hasRows(1);
        BillingSummaryPage.tableBillingGeneralInformation.getRow(1)
                .getCell(TableConstants.BillingGeneralInformationGB.TOTAL_PAID.getName()).waitFor(cell -> !cell.getValue().equals("Calculating..."));
        assertThat(BillingSummaryPage.tableBillingGeneralInformation)
                .with(TOTAL_PAID, BillingHelper.ZERO)
                .containsMatchingRow(1);

        assertThat(BillingSummaryPage.tablePaymentsOtherTransactions)
                .with(TYPE, "Decline Payment")
                .with(TableConstants.BillingPaymentsAndTransactionsGB.AMOUNT, totalPaidDue)
                .containsMatchingRow(1);
    }

    private void validatePayment(String totalDueAmount){
        //wait for calculation is finished
        BillingSummaryPage.tableBillingGeneralInformation.getRow(1)
                .getCell("Current Due").waitFor(cell -> !cell.getValue().equals("Calculating..."));

        assertThat(BillingSummaryPage.tableBillingGeneralInformation.getRow(1))
                .hasCellWithValue("Current Due", BillingHelper.DZERO.toString())
                .hasCellWithValue("Total Due", BillingHelper.DZERO.toString())
                .hasCellWithValue("Total Paid", totalDueAmount);

        assertThat(BillingSummaryPage.tableBillsAndStatements.getRow(1).getCell("Status")).valueContains(PAID_IN_FULL);

        assertThat(BillingSummaryPage.tablePaymentsOtherTransactions)
                .with(TYPE, PAYMENT)
                .with(TableConstants.BillingPaymentsAndTransactionsGB.AMOUNT, String.format("(%s)", totalDueAmount))
                .containsMatchingRow(1);
    }
}
