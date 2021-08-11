/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy.actions;

import com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy.tabs.GBCommissionRuleTab;
import com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy.tabs.GBCommissionStrategyTab;
import com.exigen.ren.admin.modules.commission.common.tabs.CommissionSearchTab;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;

public class GBCommissionStrategyCreateAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(CommissionSearchTab.class)
            .registerTab(GBCommissionStrategyTab.class)
            .registerTab(GBCommissionRuleTab.class)
            .build();

    @Override
    public String getName() {
        return "Create Commission Strategy";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }
}
