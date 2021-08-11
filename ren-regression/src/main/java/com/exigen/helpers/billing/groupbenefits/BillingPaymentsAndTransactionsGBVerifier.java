/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.helpers.billing.groupbenefits;

import com.exigen.helpers.TableVerifier;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.main.pages.summary.billing.BillingSummaryPage;


public class BillingPaymentsAndTransactionsGBVerifier extends TableVerifier {

    public BillingPaymentsAndTransactionsGBVerifier setType(String value) {
        setValue("Type", value);
        return this;
    }

    public BillingPaymentsAndTransactionsGBVerifier setPolicyNumber(String value) {
        setValue("Policy #", value);
        return this;
    }

    public BillingPaymentsAndTransactionsGBVerifier setAmount(String value) {
        setValue("Amount", value);
        return this;
    }

    @Override
    protected Table getTable() {
        return BillingSummaryPage.tablePaymentsOtherTransactions;
    }

    @Override
    protected String getTableName() {
        return "Payments Other Transactions";
    }
}
