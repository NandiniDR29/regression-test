/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.billing.paymentsmaintenance.actions;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.metadata.PaymentsMaintenanceMetaData;
import com.exigen.ren.main.modules.billing.paymentsmaintenance.tabs.SearchSuspenseActionTab;
import com.exigen.ren.main.pages.summary.billing.PaymentsAndBillingMaintenancePage;
import org.openqa.selenium.By;

import java.util.List;

import static com.exigen.ren.main.modules.billing.paymentsmaintenance.tabs.SearchSuspenseActionTab.buttonSearchSuspense;

public class ClearSuspenseGBAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(SearchSuspenseActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Clear Suspense";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action start() {
        PaymentsAndBillingMaintenancePage.buttonClearSuspense.click();
        return this;
    }

    @Override
    public Action submit() {
        SearchSuspenseActionTab.buttonOk.click();
        return this;
    }

    public void perform(TestData td, String suspenseReference, List<String> paymentAmount, String billingAccountNumber) {
        td.adjust(TestData.makeKeyPath(PaymentsMaintenanceMetaData.SearchSuspenseActionTab.class.getSimpleName(), PaymentsMaintenanceMetaData.SearchSuspenseActionTab.SUSPENSE_REFERENCE.getLabel()), suspenseReference).adjust(TestData.makeKeyPath(PaymentsMaintenanceMetaData.SearchSuspenseActionTab.class.getSimpleName(), PaymentsMaintenanceMetaData.SearchSuspenseActionTab.BILLING_ACCOUNT.getLabel()), billingAccountNumber);

        start();
        getWorkspace().fill(td);

        Table tableAssociatedAmount = new Table(By.xpath("//div[@id='suspenseForm:accountAssociationResults']/div/table"));
        if (tableAssociatedAmount.isPresent()) {
            int i = 0;
            for (String value : paymentAmount) {
                new TextBox(By.id(String.format("suspenseForm:accountAssociationResults:%d:amountInput", i))).setValue(value);
                i++;
            }
            submit();
        }
    }

    public void perform(TestData td, String suspenseReference, String billingAccountNumber) {
        td.adjust(TestData.makeKeyPath(PaymentsMaintenanceMetaData.SearchSuspenseActionTab.class.getSimpleName(), PaymentsMaintenanceMetaData.SearchSuspenseActionTab.SUSPENSE_REFERENCE.getLabel()), suspenseReference).adjust(TestData.makeKeyPath(PaymentsMaintenanceMetaData.SearchSuspenseActionTab.class.getSimpleName(), PaymentsMaintenanceMetaData.SearchSuspenseActionTab.BILLING_ACCOUNT.getLabel()), billingAccountNumber);
        start();
        getWorkspace().fill(td);
    }

    // search Suspense
    public void perform(TestData td, String billingAccountNumber) {
        td.adjust(TestData.makeKeyPath(PaymentsMaintenanceMetaData.SearchSuspenseActionTab.class.getSimpleName(), PaymentsMaintenanceMetaData.SearchSuspenseActionTab.BILLING_ACCOUNT.getLabel()), billingAccountNumber);
        start();
        getWorkspace().getTab(SearchSuspenseActionTab.class).fillTab(td);
        buttonSearchSuspense.click();
    }


    @Override
    public Action perform(TestData td) {
        throw new UnsupportedOperationException("perform(TestData td) method with testData is not supported for this action. Use perform(int rowNumber) instead.");
    }

}
