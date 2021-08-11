/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.ren.main.modules.account.actions;

import com.exigen.istf.data.TestData;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.account.tabs.CommunicationActionTab;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;

public class AddCommunicationAction implements Action {
    private Workspace workspace = new Workspace.Builder()
            .registerTab(CommunicationActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Add Communication";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action start() {
        CustomerSummaryPage.buttonStartNewCommunication.click();
        return this;
    }

    @Override
    public Action submit() {
        CommunicationActionTab.buttonSave.click();
        return this;
    }

    public Action start(int index) {
        CustomerSummaryPage.buttonStartNewCommunication.click();
        CustomerSummaryPage.tableCustomerListAccount.getColumn("Customer Name").getCell(index).click();
        return this;
    }

    /**
     * Allow to select a necessary customer. Use if account have more than one customer.
     * @param td
     * @param index of customer in the table
     */
    public Action perform(TestData td, int index) {
        start(index);
        getWorkspace().fill(td);
        return submit();
    }

}
