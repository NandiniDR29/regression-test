/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.ren.main.modules.mywork.actions;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.mywork.tabs.CreateTaskActionTab;

public class CreateTaskAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(CreateTaskActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Create Task";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action start() {
        CreateTaskActionTab.buttonCreateTask.click();
        return this;
    }

    @Override
    public Action submit() {
        CreateTaskActionTab.buttonCreate.click();
        return this;
    }
}
