/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.actions;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.customer.tabs.MergeCustomerActionTab;
import com.exigen.ren.main.modules.customer.tabs.SearchMergeCustomerActionTab;

public class MergeCustomerAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(SearchMergeCustomerActionTab.class)
            .registerTab(MergeCustomerActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Merge Customers";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action submit() {
        Tab.buttonSaveAndExit.click();
        return this;
    }
}
