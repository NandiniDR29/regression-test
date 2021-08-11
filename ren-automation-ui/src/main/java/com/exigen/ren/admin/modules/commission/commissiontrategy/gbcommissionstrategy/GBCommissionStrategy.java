/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.BaseElement;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.commission.commissiontrategy.ICommissionStrategy;
import com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy.actions.GBCommissionExpireAction;
import com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy.actions.GBCommissionStrategyCreateAction;
import com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy.actions.GBCommissionStrategyEditAction;
import com.exigen.ren.admin.modules.commission.commissiontrategy.pages.CommissionPage;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;

public class GBCommissionStrategy implements ICommissionStrategy {

    @Override
    public Workspace getDefaultWorkspace() {
        return AutomationContext.getAction(GBCommissionStrategyCreateAction.class).getWorkspace();
    }

    @Override
    public void create(TestData td) {
        navigate();
        initiate();
        getDefaultWorkspace().fill(td);
        submit();
    }

    public void submit() {
        Tab.buttonSave.waitFor(BaseElement::isEnabled);
        Tab.buttonSave.click();
    }

    @Override
    public void initiate() {
        CommissionPage.buttonAddNewCommissionStrategy.click();
    }

    @Override
    public void navigate() {
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.COMMISSION);
        NavigationPage.toLeftMenuTab(NavigationEnum.CommissionLeftMenu.GB_COMMISSION_STRATEGY);
    }

    @Override
    public GBCommissionExpireAction expire() {
        return AutomationContext.getAction(GBCommissionExpireAction.class);
    }

    @Override
    public Action copy() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Action delete() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public GBCommissionStrategyEditAction edit() {
        return AutomationContext.getAction(GBCommissionStrategyEditAction.class);
    }

    @Override
    public TestData defaultTestData() {
        return TestDataProvider.getDefaultTestDataProvider().get("modules/commission/commissionstrategy");
    }
}
