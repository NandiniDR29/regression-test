/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.billing.paymentsmaintenance.actions;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.CheckBox;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.metadata.PaymentsMaintenanceMetaData;
import com.exigen.ren.main.modules.billing.paymentsmaintenance.tabs.AddSuspenseActionTab;
import com.exigen.ren.main.pages.summary.billing.BillingSummaryPage;
import com.exigen.ren.main.pages.summary.billing.PaymentsAndBillingMaintenancePage;
import org.openqa.selenium.By;

import java.util.List;

import static com.exigen.ren.main.modules.billing.paymentsmaintenance.tabs.AddSuspenseActionTab.buttonSearch;
import static com.exigen.ren.main.modules.billing.paymentsmaintenance.tabs.AddSuspenseActionTab.buttonSelectBusinessName;

public class AddSuspenseAction implements Action {



    private Workspace workspace = new Workspace.Builder()
            .registerTab(AddSuspenseActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Add Suspense";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action start() {
        BillingSummaryPage.buttonPaymentsBillingMaintenance.click();
        PaymentsAndBillingMaintenancePage.buttonAddSuspense.click();
        return this;
    }

    public Action perform(TestData td, String amount, String reference) {
        td.adjust(TestData.makeKeyPath(PaymentsMaintenanceMetaData.AddSuspenseActionTab.class.getSimpleName(), PaymentsMaintenanceMetaData.AddSuspenseActionTab.SUSPENSE_AMOUNT.getLabel()), amount).adjust(TestData.makeKeyPath(PaymentsMaintenanceMetaData.AddSuspenseActionTab.class.getSimpleName(), PaymentsMaintenanceMetaData.AddSuspenseActionTab.SUSPENSE_REFERENCE.getLabel()), reference);
        return perform(td);
    }

    //Add Suspense to #BA
    public void perform(TestData td, String billingAccount, List<String> associatedAmount) {
        perform(td);

        if (buttonSelectBusinessName.isPresent()) {
            buttonSelectBusinessName.click();
            //Enter Billing Account name in Search PopUp
            new TextBox(By.id("customerSearch:billingAccountNo")).setValue(billingAccount);
            //Search Customer
            buttonSearch.click();
            //Select Customer in Search Results
            new Link(By.id("customerSearch:payorSearchResults:0:selectBusinessCustomerLink")).click();
            searchBillingAccountAndSetAssociationResults(billingAccount, associatedAmount);
        }
        submit();
    }

    public static void searchBillingAccountAndSetAssociationResults(String billingAccount, List<String> associatedAmount) {
        //Search BA
        new Button(By.id("suspenseForm:showBillingAccountSearchPopupLnk")).waitFor(button -> button.isPresent());
        new Button(By.id("suspenseForm:showBillingAccountSearchPopupLnk")).click();
        //Enter Billing Account name in Search PopUp
        new TextBox(By.id("billingAccountSearch:accountNumber")).setValue(billingAccount);
        new Button(By.id("billingAccountSearch:searchBtn")).click();
        //Select BA
        new CheckBox(By.id("billingAccountSearch:accountSearchResults:0:selectedCbk")).setValue(true);
        new Button(By.id("billingAccountSearch:addBtn")).click();

        int i = 0;
        for (String value : associatedAmount) {
            new TextBox(By.id(String.format("suspenseForm:accountAssociationResults:%d:amountInput", i))).setValue(value);
            i++;
        }
    }

    @Override
    public Action perform(TestData td) {
        start();
        getWorkspace().fill(td);
        return this;
    }

    @Override
    public Action submit() {
        AddSuspenseActionTab.buttonOk.click();
        return this;
    }

}
