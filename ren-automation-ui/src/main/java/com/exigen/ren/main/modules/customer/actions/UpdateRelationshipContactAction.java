/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.actions;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.customer.tabs.RelationshipTab;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;

public class UpdateRelationshipContactAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(RelationshipTab.class)
            .build();

    @Override
    public String getName() {
        return "Update Relationship Contact";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action start() {
        CustomerSummaryPage.linkEditThisRelationship.click();
        return this;
    }

    @Override
    public Action submit() {
        return this;
    }
}
