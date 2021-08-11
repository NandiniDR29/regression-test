/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.modules.claim.common.actions;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.claim.common.tabs.ClaimsCreationResultTab;
import com.exigen.ren.main.modules.claim.common.tabs.LossContextTab;
import com.exigen.ren.main.modules.claim.common.tabs.LossEventTab;

public class InitiateClaimAction implements Action {

    private Workspace initializationView = new Workspace.Builder()
            .registerTab(LossEventTab.class)
            .registerTab(LossContextTab.class)
            .registerTab(ClaimsCreationResultTab.class)
            .build();

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Workspace getWorkspace() {
        return initializationView;
    }
}
