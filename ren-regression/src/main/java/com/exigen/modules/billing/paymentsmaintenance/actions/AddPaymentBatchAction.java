/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.billing.paymentsmaintenance.actions;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.BaseElement;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.billing.paymentsmaintenance.tabs.AddPaymentBatchActionTab;
import com.exigen.ren.main.pages.summary.billing.BillingSummaryPage;
import org.openqa.selenium.By;

import static com.exigen.ren.main.enums.ActionConstants.BillingAction.PAYMENTS_AND_BILLING_MAINTENANCE;
import static com.exigen.ren.main.pages.summary.billing.PaymentsAndBillingMaintenancePage.buttonAddPaymentBatch;

public class AddPaymentBatchAction implements Action {

    public static final Button buttonSaveAndExit = new Button(By.id("paymentBatchForm:save_footer"));
    public static final Button buttonSchedule = new Button(By.id("paymentBatchForm:scheduleBtn_footer"));
    public static final Button buttonOk = new Button(By.id("paymentBatchForm:okBtn_footer"));
    private Workspace workspace = new Workspace.Builder()
            .registerTab(AddPaymentBatchActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Add Payment Batch";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action start() {
        if (BillingSummaryPage.buttonPaymentsBillingMaintenance.isPresent()) {
            BillingSummaryPage.buttonPaymentsBillingMaintenance.click();
        }
        else {
            NavigationPage.comboBoxListAction.setValue(PAYMENTS_AND_BILLING_MAINTENANCE);
        }
        buttonAddPaymentBatch.waitFor(BaseElement::isVisible);
        buttonAddPaymentBatch.click();
        return this;
    }
    @Override
    public Action perform(TestData td) {
        start();
        getWorkspace().fill(td);
        return this;
    }

    @Override
    public Action submit() {
        if (buttonOk.isPresent()) {
            buttonOk.click();
        } else {
            if (AddPaymentBatchActionTab.buttonStartAllocations.isPresent()) {
                AddPaymentBatchActionTab.buttonStartAllocations.click();
                Page.dialogConfirmation.confirm();
            } else {
                if (buttonSaveAndExit.isPresent()) {
                    buttonSaveAndExit.click();
                }
            }
        }
        return this;
    }

    public Action scheduleSubmit() {
        buttonSchedule.click();
        Page.dialogConfirmation.confirm();
        return this;
    }

}
