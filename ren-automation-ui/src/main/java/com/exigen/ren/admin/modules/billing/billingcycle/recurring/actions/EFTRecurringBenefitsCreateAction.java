/* Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent. */
package com.exigen.ren.admin.modules.billing.billingcycle.recurring.actions;

import com.exigen.ren.admin.modules.billing.billingcycle.recurring.tabs.EFTRecurringBenefitsTab;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;

public class EFTRecurringBenefitsCreateAction implements Action {
    private Workspace workspace = new Workspace.Builder()
            .registerTab(EFTRecurringBenefitsTab.class)
            .build();

    @Override
    public String getName() {
        return "Benefits Create Action";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }
}
