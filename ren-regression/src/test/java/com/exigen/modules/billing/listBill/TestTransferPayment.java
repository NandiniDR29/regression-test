package com.exigen.modules.billing.listBill;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.ipb.eisa.utils.Currency;
import com.exigen.istf.data.TestData;
import com.exigen.modules.billing.GroupBenefitsBillingBaseTest;
import com.exigen.modules.billing.account.BillingAccountContext;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.modules.billing.account.metadata.TransferPaymentBenefitsActionTabMetaData;
import com.exigen.ren.main.modules.billing.account.tabs.TransferPaymentBenefitsActionTab;
import com.exigen.ren.main.pages.summary.billing.BillingSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.TableConstants.BillingPaymentsAndTransactionsGB.POLICY_NUMBER;

public class TestTransferPayment extends GroupBenefitsBillingBaseTest implements BillingAccountContext {
    private String firstBillingAccountNumber, secondBillingAccountNumber;

    @Test(priority = 23)
    public void testTransferPayment() throws IOException {
        logger = extent.startTest(groupNo+" Perform Transfer Payment");
        prop.load(fileInput);
        boolean firstAccount = true;
        for(Map.Entry<String, String> BillingAccountAndProduct : CommonGenericMethods.getBillingAccount(groupNo).entrySet()){
            if(firstAccount){
                firstBillingAccountNumber = BillingAccountAndProduct.getValue();
                reportLog("First Billing Account Number # "+ firstBillingAccountNumber, 0);
                firstAccount = false;
            }else if(!firstAccount){
                secondBillingAccountNumber = BillingAccountAndProduct.getValue();
                reportLog("Second Billing Account Number # "+ secondBillingAccountNumber, 1);
                firstAccount = true;
                break;
            }
        }
        reportLog("Performing Transfer payment from Billing # "+ firstBillingAccountNumber +" to Billing #" + secondBillingAccountNumber, 1);
        reportLog("Navigate to Billing Account to perform transfer payment in Billing Account "+ firstBillingAccountNumber, 1);
        search(firstBillingAccountNumber);
        Currency suspenseAmount =  new Currency(100);
        reportLog("Adding Suspence Amount to perform refund", 1);
        billingAccount.acceptPayment().perform(billingAccount.getDefaultTestData("SuspendePayment", "TestData_Check_Suspense"), suspenseAmount.toString());
        billingAccount.transferPaymentBenefits().perform(
                billingAccount.getDefaultTestData("TransferPayment", "TestData_Benefits")
                        .adjust(TestData.makeKeyPath(TransferPaymentBenefitsActionTab.class.getSimpleName(),
                                TransferPaymentBenefitsActionTabMetaData.BILLING_ACCOUNT.getLabel(),
                                TransferPaymentBenefitsActionTabMetaData.BillingAccountSingleSelector.BILLING_ACCOUNT_NUMBER.getLabel()),
                                secondBillingAccountNumber)
                        .adjust(TestData.makeKeyPath(TransferPaymentBenefitsActionTab.class.getSimpleName(),
                                TransferPaymentBenefitsActionTabMetaData.TRANSFER_AMOUNT.getLabel()), suspenseAmount.toString()));
        reportLog("Navigate to second Billing Account for transfer payment verification Billing # " + secondBillingAccountNumber, 1);
        search(secondBillingAccountNumber);
        reportLog("Verification of transfer payment in Payment & Other Transactions", 1);
        accontSuspenseVerification(suspenseAmount);
        reportLog("=============================", 1);
    }

    private void accontSuspenseVerification(Currency amount){
        assertThat(BillingSummaryPage.tablePaymentsOtherTransactions)
                .with(POLICY_NUMBER, "")
                .with(TableConstants.BillingPaymentsAndTransactionsGB.TYPE, "Account Suspense")
                .with(TableConstants.BillingPaymentsAndTransactionsGB.AMOUNT, String.format("(%s)", amount.toString()))
                .hasMatchingRows();
    }
}
