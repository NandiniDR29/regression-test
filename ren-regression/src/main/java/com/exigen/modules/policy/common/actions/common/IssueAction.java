/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.policy.common.actions.common;

import com.exigen.modules.policy.common.tabs.master.IssueActionTab;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;

public class IssueAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(IssueActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Issue";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }
}
