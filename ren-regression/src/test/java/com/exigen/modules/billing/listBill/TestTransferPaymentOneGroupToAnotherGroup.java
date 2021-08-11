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

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.TableConstants.BillingPaymentsAndTransactionsGB.POLICY_NUMBER;

public class TestTransferPaymentOneGroupToAnotherGroup extends GroupBenefitsBillingBaseTest implements BillingAccountContext {
    private String fromBillingAccountNumber, toBillingAccountNumber;

    @Test(priority = 24)
    public void testTransferPaymentOneGroupToAnotherGroup() throws IOException {
        logger = extent.startTest(groupNo + " Transfer Payment One Group To Another Group");
        toBillingAccountNumber = getBillingAccount(getToBillingAccountGroup(groupNo));
        LOGGER.info("Transfer Payment to other group Billing Account number #" + toBillingAccountNumber);
        fromBillingAccountNumber = getBillingAccount(groupNo);
        LOGGER.info("Transfer Payment From Billing Account number #" + fromBillingAccountNumber);
        reportLog("Performing Transfer payment from Billing # " + fromBillingAccountNumber + " to Billing #" + toBillingAccountNumber, 1);
        reportLog("Navigate to Billing Account to perform transfer payment in Billing Account " + fromBillingAccountNumber, 1);
        search(fromBillingAccountNumber);
        LOGGER.info("Search for Billing Account Number From #" +fromBillingAccountNumber);
        Currency suspenseAmount = new Currency(100);
        reportLog("Adding Suspense Amount to perform refund", 1);
        billingAccount.acceptPayment().perform(billingAccount.getDefaultTestData("SuspendePayment", "TestData_Check_Suspense"), suspenseAmount.toString());
        billingAccount.transferPaymentBenefits().perform(
                billingAccount.getDefaultTestData("TransferPayment", "TestData_Benefits")
                        .adjust(TestData.makeKeyPath(TransferPaymentBenefitsActionTab.class.getSimpleName(),
                                TransferPaymentBenefitsActionTabMetaData.BILLING_ACCOUNT.getLabel(),
                                TransferPaymentBenefitsActionTabMetaData.BillingAccountSingleSelector.BILLING_ACCOUNT_NUMBER.getLabel()),
                                toBillingAccountNumber)
                        .adjust(TestData.makeKeyPath(TransferPaymentBenefitsActionTab.class.getSimpleName(),
                                TransferPaymentBenefitsActionTabMetaData.TRANSFER_AMOUNT.getLabel()), suspenseAmount.toString()));
        reportLog("Navigate to other group Billing Account for transfer payment verification Billing # " + toBillingAccountNumber, 1);
        LOGGER.info("Navigate to other group Billing Account for transfer payment verification Billing # " + toBillingAccountNumber);
        search(toBillingAccountNumber);
        LOGGER.info("Verification of transfer payment in Payment & Other Transactions");
        reportLog("Verification of transfer payment in Payment & Other Transactions", 1);
        accountSuspenseVerification(suspenseAmount);
        reportLog("=============================", 1);
    }

    public String getBillingAccount(String group) throws IOException {
        String path = CommonGenericMethods.inputOutputFileSelectionForGroup(group);
        fileInput = new FileInputStream(path);
        prop.load(fileInput);
        String billingAccountNumber = "";
        for (Map.Entry<String, String> BillingAccountAndProduct : CommonGenericMethods.getBillingAccount(groupNo).entrySet()) {
            billingAccountNumber = BillingAccountAndProduct.getValue();
            reportLog("First Billing Account Number # " + billingAccountNumber, 0);
            break;
        }
        return billingAccountNumber;
    }

    public String getToBillingAccountGroup(String group) {
        switch (group.toLowerCase()) {
            case "group2":
                return "group12";
            case "group3":
                return "group1";
            case "group4":
                return "group3";
            case "group5":
                return "group4";
            case "group6":
                return "group5";
            case "group7":
                return "group6";
            case "group8":
                return "group7";
            case "group9":
                return "group8";
            case "group10":
                return "group9";
            case "group11":
                return "group10";
            case "group12":
                return "group11";
            default:
                return "";
        }
    }

    private void accountSuspenseVerification(Currency amount) {
        assertThat(BillingSummaryPage.tablePaymentsOtherTransactions)
                .with(POLICY_NUMBER, "")
                .with(TableConstants.BillingPaymentsAndTransactionsGB.TYPE, "Account Suspense")
                .with(TableConstants.BillingPaymentsAndTransactionsGB.AMOUNT, String.format("(%s)", amount.toString()))
                .hasMatchingRows();
    }
}
