/* Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent. */
package com.exigen.ren.admin.modules.billing.rules.write_off.benefits.actions;

import com.exigen.ren.admin.modules.billing.rules.write_off.benefits.tabs.WriteOffBenefitsSearchTab;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;

public class WriteOffBenefitSearchAction implements Action {
    private Workspace workspace = new Workspace.Builder()
            .registerTab(WriteOffBenefitsSearchTab.class)
            .build();

    @Override
    public String getName() {
        return "Benefits Search Action";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    public void search() {

    }
}
