/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.actions;

import com.exigen.istf.data.TestData;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.CustomerConstants;
import com.exigen.ren.main.modules.customer.tabs.OpportunityActionTab;

public class RemoveOpportunityAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(OpportunityActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Remove Opportunity";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    public Action start(int rowNumber) {
        OpportunityActionTab.tableOpportunity.getRow(rowNumber).getCell(CustomerConstants.CustomerOpportunityTable.ID).controls.links.getFirst().click();
        NavigationPage.setActionAndGo("Close");
        Page.dialogConfirmation.confirm();
        return this;
    }

    public Action perform(int rowNumber) {
        start(rowNumber);
        return submit();
    }

    @Override
    public Action start() {
        throw new UnsupportedOperationException("start() method without parameters is not supported for this action. Use start(int rowNumber) instead.");
    }

    @Override
    public Action perform(TestData td) {
        throw new UnsupportedOperationException("perform(TestData td) method with testData is not supported for this action. Use perform(int rowNumber) instead.");
    }

    @Override
    public Action submit() {
        OpportunityActionTab.buttonDone.click();
        return this;
    }
}
