/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.product.scheme.actions;

import com.exigen.istf.data.TestData;
import com.exigen.ren.admin.modules.product.scheme.tabs.CloseSchemeTab;
import com.exigen.ren.admin.modules.product.scheme.tabs.DisapproveSchemeTab;
import com.exigen.ren.admin.modules.product.scheme.tabs.SetRunOffTab;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;

public class SchemeDisapproveAction implements Action {
    private Workspace workspace = new Workspace.Builder()
            .registerTab(DisapproveSchemeTab.class)
            .registerTab(CloseSchemeTab.class)
            .registerTab(SetRunOffTab.class)
            .build();

    @Override
    public String getName() {
        return "Disapprove";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action start() {
        NavigationPage.setActionAndGo(getName());
        Page.dialogConfirmation.confirm();
        return this;
    }

    @Override
    public Action perform(TestData td) {
        start();
        getWorkspace().fill(td);
        return this;
    }
}
