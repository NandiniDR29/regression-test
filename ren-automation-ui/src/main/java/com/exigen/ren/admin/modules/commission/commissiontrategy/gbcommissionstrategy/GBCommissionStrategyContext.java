/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy;

import com.exigen.istf.data.TestData;
import com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy.tabs.GBCommissionRuleTab;
import com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy.tabs.GBCommissionStrategyTab;
import com.exigen.ren.admin.modules.commission.common.tabs.CommissionSearchTab;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.main.modules.policy.common.GroupBenefitsMasterPolicy;

public interface GBCommissionStrategyContext {

    GBCommissionStrategy gbCommissionStrategy = AutomationContext.getService(GBCommissionStrategy.class);
    CommissionSearchTab gbCommissionSearchTab = gbCommissionStrategy.getDefaultWorkspace().getTab(CommissionSearchTab.class);
    GBCommissionStrategyTab gbCommissionStrategyTab = gbCommissionStrategy.getDefaultWorkspace().getTab(GBCommissionStrategyTab.class);
    GBCommissionRuleTab gbCommissionRuleTab = gbCommissionStrategy.getDefaultWorkspace().getTab(GBCommissionRuleTab.class);

    default GroupBenefitsMasterPolicy getPolicy() {
        throw new UnsupportedOperationException("Not implemented");
    }

    default TestData getPolicyTestData() {
        throw new UnsupportedOperationException("Not implemented");
    }

    default TestData getCommissionTestData() {
        throw new UnsupportedOperationException("Not implemented");
    }
}
