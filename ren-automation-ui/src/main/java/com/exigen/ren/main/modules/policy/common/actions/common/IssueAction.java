/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.policy.common.actions.common;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.policy.common.tabs.common.AuthorityActionTab;
import com.exigen.ren.main.modules.policy.common.tabs.common.IssueActionTab;

public class IssueAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(AuthorityActionTab.class)
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
