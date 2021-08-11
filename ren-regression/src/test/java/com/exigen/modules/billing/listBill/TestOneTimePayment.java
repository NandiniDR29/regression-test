package com.exigen.modules.billing.listBill;
import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.modules.billing.GroupBenefitsBillingBaseTest;
import com.exigen.modules.billing.account.BillingAccountContext;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.pages.summary.billing.BillingSummaryPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Map;
import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.BillingConstants.BillsAndStatementsStatusGB.PAID_IN_FULL;
import static com.exigen.ren.main.enums.BillingConstants.PaymentsAndOtherTransactionTypeGB.PAYMENT;
import static com.exigen.ren.main.enums.TableConstants.BillingPaymentsAndTransactionsGB.TYPE;
public class TestOneTimePayment extends GroupBenefitsBillingBaseTest implements BillingAccountContext {
    @Test(priority = 19)
    public void testPerformOneTimePayment() throws IOException {
        logger = extent.startTest(groupNo+" Perform One Time Payment");
        prop.load(fileInput);
        for(Map.Entry<String, String> BillingAccountAndProduct : CommonGenericMethods.getBillingAccount(groupNo).entrySet()){
            reportLog("Searching for Billing Account: " + BillingAccountAndProduct.getValue(), 0);
            search(BillingAccountAndProduct.getValue());
            reportLog("Performing Payment for the Product ::: " + BillingAccountAndProduct.getKey() +":::", 1);
            BillingSummaryPage.tableBillingGeneralInformation.getRow(1)
                    .getCell(TableConstants.BillingGeneralInformationGB.TOTAL_DUE.getName()).waitFor(cell -> !cell.getValue().equals("Calculating..."));
            String totalDueAmount = BillingSummaryPage.tableBillingGeneralInformation.getRow(1).getCell(TableConstants.BillingGeneralInformationGB.TOTAL_DUE.getName()).getValue();
            System.out.println("Total due amount is ::: "+ totalDueAmount);
            if(!(totalDueAmount.equals("$0.00"))) {
                if(groupNo.equalsIgnoreCase("Group16")||groupNo.equalsIgnoreCase("Group6")||groupNo.equalsIgnoreCase("Group14")||groupNo.equalsIgnoreCase("Group11")||groupNo.equalsIgnoreCase("Group2")){
                    billingAccount.acceptPayment().perform(billingAccount.getDefaultTestData("AcceptPayment", "TestData_EFT_Invoice_SuspendAmount"), totalDueAmount.replace("$", ""));

                }
                else {
                    billingAccount.acceptPayment().perform(billingAccount.getDefaultTestData("AcceptPayment", "TestData_EFT_Invoice"), totalDueAmount.replace("$", ""));
                }
                validatePayment(totalDueAmount);
            }else{
                logger.log(LogStatus.WARNING, "Total Due Amount for the Billing Account is $0.00, Billing Account# is " + BillingAccountAndProduct.getValue());
            }
        }
    }
    private void validatePayment(String totalDueAmount){
        //wait for calculation is finished
        try{
            BillingSummaryPage.tableBillingGeneralInformation.getRow(1)
                    .getCell("Current Due").waitFor(cell -> !cell.getValue().equals("Calculating..."));
        }catch (Exception e){
            driver.navigate().refresh();
            BillingSummaryPage.tableBillingGeneralInformation.getRow(1)
                    .getCell("Current Due").waitFor(cell -> !cell.getValue().equals("Calculating..."));
        }
//        assertThat(BillingSummaryPage.tableBillingGeneralInformation.getRow(1))
//                .hasCellWithValue("Current Due", BillingHelper.DZERO.toString())
//                .hasCellWithValue("Total Due", BillingHelper.DZERO.toString())
//                .hasCellWithValue("Total Paid", totalDueAmount);
        assertThat(BillingSummaryPage.tableBillsAndStatements.getRow(1).getCell("Status")).valueContains(PAID_IN_FULL);
        assertThat(BillingSummaryPage.tablePaymentsOtherTransactions)
                .with(TYPE, PAYMENT)
                .with(TableConstants.BillingPaymentsAndTransactionsGB.AMOUNT, String.format("(%s)", totalDueAmount))
                .containsMatchingRow(1);
    }
}