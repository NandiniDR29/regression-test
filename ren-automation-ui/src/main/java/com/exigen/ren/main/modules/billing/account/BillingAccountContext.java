/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.billing.account;

import com.exigen.ipb.eisa.utils.Currency;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.billing.account.tabs.ReverseWriteOffActionTab;
import com.exigen.ren.main.pages.summary.billing.BillingSummaryPage;

import java.util.stream.IntStream;

import static com.exigen.ren.common.enums.NavigationEnum.AppMainTabs.BILLING;
import static com.exigen.ren.main.enums.TableConstants.BillingBillsAndStatementsGB.TOTAL_DUE;

public interface BillingAccountContext {
    BillingAccount billingAccount = AutomationContext.getService(BillingAccount.class);
    ReverseWriteOffActionTab reverseWriteOffActionTab = billingAccount.getPaymentsAdjustmentsDefaultWorkspace().getTab(ReverseWriteOffActionTab.class);

    default void payPolicy() {
        NavigationPage.toMainTab(BILLING);
        generateAndPayPayment();
    }

    default void payPolicy(int paymentsCount) {
        NavigationPage.toMainTab(BILLING);
        IntStream.range(0, paymentsCount)
                .forEach(payment -> generateAndPayPayment());
    }

    default void generateAndPayPayment() {
        billingAccount.generateFutureStatement().perform();
        Currency policyTotalDue = new Currency(BillingSummaryPage.tableBillsAndStatements.getRow(1).getCell(TOTAL_DUE.getName()).getValue());
        billingAccount.acceptPayment().perform(billingAccount.getDefaultTestData("AcceptPayment", "TestData_Cash"), new Currency(policyTotalDue).toString());
    }

}
