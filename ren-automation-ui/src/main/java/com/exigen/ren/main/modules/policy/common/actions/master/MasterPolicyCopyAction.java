/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package com.exigen.ren.main.modules.policy.common.actions.master;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.policy.common.tabs.master.CopyPolicyActionTab;

public class MasterPolicyCopyAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(CopyPolicyActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Copy from Policy";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }
}
