/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.ren.main.modules.account.actions;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.account.tabs.AddAffinityGroupActionTab;
import com.exigen.ren.main.modules.account.tabs.AffinityGroupsTab;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;

public class AddAffinityGroupAction implements Action {
    private Workspace workspace = new Workspace.Builder()
            .registerTab(AddAffinityGroupActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Add Affinity Group";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action start() {
        CustomerSummaryPage.buttonAddAffinityGroup.click();
        return this;
    }

    @Override
    public Action submit() {
        AffinityGroupsTab.buttonDone.click();
        return this;
    }

}
