/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.general.catastrophe.action;

import com.exigen.ren.admin.modules.general.catastrophe.pages.CatastrophePage;
import com.exigen.ren.admin.modules.general.catastrophe.tabs.CatastropheTab;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;

public class CatastropheCreateAction implements Action {
    private Workspace workspace = new Workspace.Builder()
            .registerTab(CatastropheTab.class)
            .build();

    @Override
    public String getName() {
        return "Catastrophe Create Action";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action start() {
        CatastrophePage.addCatastrophe.click();
        return this;
    }

    @Override
    public Action submit() {
        Tab.buttonSave.click();
        return this;
    }
}
