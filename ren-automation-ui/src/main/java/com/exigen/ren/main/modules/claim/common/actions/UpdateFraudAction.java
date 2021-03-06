/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.common.actions;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.claim.common.tabs.SIUFNOLActionTab;
import com.exigen.ren.main.modules.claim.common.tabs.SIURulesActionTab;
import com.exigen.ren.main.modules.claim.common.tabs.SIUTheftActionTab;

public class UpdateFraudAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(SIURulesActionTab.class)
            .registerTab(SIUFNOLActionTab.class)
            .registerTab(SIUTheftActionTab.class)
            .build();

    @Override
    public String getName() {
        return "SIU Update";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

}
