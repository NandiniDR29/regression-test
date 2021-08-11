/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.billing.account.actions;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.enums.ActionConstants;
import com.exigen.ren.main.enums.BillingConstants;
import com.exigen.ren.main.modules.billing.account.metadata.TransferPaymentActionTabMetaData;
import com.exigen.ren.main.modules.billing.account.tabs.TransferPaymentActionTab;
import com.exigen.ren.main.pages.summary.billing.BillingSummaryPage;
import org.openqa.selenium.By;

public class TransferPaymentAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(TransferPaymentActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Transfer Payment";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    //FIXME(vmarkouski) - magic number
    @Override
    public Action start() {
        return start(1);
    }

    public Action start(int rowNumber) {
        BillingSummaryPage.tablePaymentsOtherTransactions.getRow(rowNumber).getCell(BillingConstants.BillingPaymentsAndOtherTransactionsTable.ACTION).controls.links.get(
                ActionConstants.BillingPaymentsAndOtherTransactionAction.TRANSFER).click();
        return this;
    }

    public Action perform(TestData td, int rowNumber) {
        start(rowNumber);
        getWorkspace().fill(td);
        return submit();
    }

    public Action perform(TestData td, String policy, String allocatedAmount) {
        td.adjust(
                TestData.makeKeyPath(TransferPaymentActionTab.class.getSimpleName(), TransferPaymentActionTabMetaData.ALLOCATION.getLabel(),
                        TransferPaymentActionTabMetaData.AllocationMultiSelector.POLICY_NUMBER.getLabel()),
                policy)
                .adjust(TestData.makeKeyPath(TransferPaymentActionTab.class.getSimpleName(), TransferPaymentActionTabMetaData.ALLOCATED_AMOUNT.getLabel()),
                        allocatedAmount);
        return perform(td);
    }

    @Override
    public Action submit() {
        new Button(By.xpath("//input[contains(@id, 'transferPaymentForm:ok') and not(contains(@style, 'none'))]")).click();
        return this;
    }

}
