/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.caseprofile.actions;

import com.exigen.istf.data.TestData;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.caseprofile.tabs.*;

public class CaseProfileUpdateAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(CaseProfileDetailsTab.class)
            .registerTab(ProductAndPlanManagementTab.class)
            .registerTab(ClassificationManagementTab.class)
            .registerTab(LocationManagementTab.class)
            .registerTab(FileIntakeManagementTab.class)
            .build();

    @Override
    public String getName() {
        return "Update";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action perform(TestData td) {
        start();
        getWorkspace().fill(td);
        return this;
    }
}
