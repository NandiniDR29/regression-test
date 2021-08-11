/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.commission.bulkadjustment;

import com.exigen.istf.data.TestData;
import com.exigen.ren.EntityLogger;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.commission.ICommission;
import com.exigen.ren.admin.modules.commission.bulkadjustment.actions.AddBulkAdjustmentRuleAction;
import com.exigen.ren.admin.modules.commission.bulkadjustment.actions.BulkAdjustmentCreateAction;
import com.exigen.ren.admin.modules.commission.bulkadjustment.actions.BulkAdjustmentDeleteAction;
import com.exigen.ren.admin.modules.commission.bulkadjustment.actions.BulkAdjustmentEditAction;
import com.exigen.ren.admin.modules.commission.commissiontrategy.pages.CommissionPage;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;

public class BulkAdjustment implements ICommission {

    @Override
    public void submit() {

    }

    @Override
    public boolean searched(TestData td) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Action expire() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Action copy() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void navigate() {
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.COMMISSION);
        NavigationPage.toLeftMenuTab(NavigationEnum.CommissionLeftMenu.BULK_ADJUSTMENT);
    }

    @Override
    public Workspace getDefaultWorkspace() {
        return AutomationContext.getAction(BulkAdjustmentCreateAction.class).getWorkspace();
    }

    @Override
    public void create(TestData td) {
        navigate();
        initiate();
        getDefaultWorkspace().fill(td);
        String entity = EntityLogger.getEntityHeader(EntityLogger.EntityType.BULK_ADJUSTMENT);
        Tab.buttonSave.click();
    }

    @Override
    public void initiate() {
        CommissionPage.buttonAddBulkAdjustment.click();
    }

    @Override
    public BulkAdjustmentEditAction edit() {
        return AutomationContext.getAction(BulkAdjustmentEditAction.class);
    }

    public AddBulkAdjustmentRuleAction addBulkAdjustmentRule() {
        return AutomationContext.getAction(AddBulkAdjustmentRuleAction.class);
    }

    @Override
    public BulkAdjustmentDeleteAction delete() {
        return AutomationContext.getAction(BulkAdjustmentDeleteAction.class);
    }

    @Override
    public TestData defaultTestData() {
        return TestDataProvider.getDefaultTestDataProvider().get("modules/commission/bulkadjustment");
    }
}
