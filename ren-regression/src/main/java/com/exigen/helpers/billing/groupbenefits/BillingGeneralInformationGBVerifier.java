/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.helpers.billing.groupbenefits;

import com.exigen.helpers.TableVerifier;
import com.exigen.helpers.billing.BillingHelper;
import com.exigen.ipb.eisa.utils.Currency;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.main.pages.summary.billing.BillingSummaryPage;


public class BillingGeneralInformationGBVerifier extends TableVerifier {

    public BillingGeneralInformationGBVerifier setSuspenseAmount(Currency value) {
        setValue("Suspense Amount", value.toString());
        return this;
    }

    public BillingGeneralInformationGBVerifier setSuspenseAmountZero() {
        setValue("Suspense Amount", BillingHelper.DZERO.toString());
        return this;
    }

    public BillingGeneralInformationGBVerifier setCurrentDue(Currency value) {
        setValue("Current Due", value.toString());
        return this;
    }

    public BillingGeneralInformationGBVerifier setCurrentDueZero() {
        setValue("Current Due", BillingHelper.DZERO.toString());
        return this;
    }

    public BillingGeneralInformationGBVerifier setTotalDue(Currency value) {
        setValue("Total Due", value.toString());
        return this;
    }

    public BillingGeneralInformationGBVerifier setTotalDueZero() {
        setValue("Total Due", BillingHelper.DZERO.toString());
        return this;
    }

    public BillingGeneralInformationGBVerifier setTotalPaid(Currency value) {
        setValue("Total Paid", value.toString());
        return this;
    }

    public BillingGeneralInformationGBVerifier setTotalPaidZero() {
        setValue("Total Paid", BillingHelper.DZERO.toString());
        return this;
    }

    public BillingGeneralInformationGBVerifier setUnallocatedInvoicePremium(Currency value) {
        setValue("Unallocated Invoice Premium", value.toString());
        return this;
    }

    public BillingGeneralInformationGBVerifier setUnallocatedInvoicePremiumZero() {
        setValue("Unallocated Invoice Premium", BillingHelper.DZERO.toString());
        return this;
    }

    public BillingGeneralInformationGBVerifier setPriorDue(Currency value) {
        setValue("Prior Due", value.toString());
        return this;
    }

    public BillingGeneralInformationGBVerifier setPriorDueZero() {
        setValue("Prior Due", BillingHelper.DZERO.toString());
        return this;
    }

    @Override
    protected Table getTable() {
        return BillingSummaryPage.tableBillingGeneralInformation;
    }

    @Override
    protected String getTableName() {
        return "Billing General Information";
    }
}
