/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.commission.commissiongroup;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.commission.ICommission;
import com.exigen.ren.admin.modules.commission.commissiongroup.actions.CommissionGroupCreateAction;
import com.exigen.ren.admin.modules.commission.commissiongroup.actions.CommissionGroupDeleteAction;
import com.exigen.ren.admin.modules.commission.commissiongroup.actions.CommissionGroupEditAction;
import com.exigen.ren.admin.modules.commission.commissiongroup.actions.CommissionGroupExpireAction;
import com.exigen.ren.admin.modules.commission.commissiongroup.metadata.CommissionGroupMetaData;
import com.exigen.ren.admin.modules.commission.commissiongroup.tabs.CommissionGroupTab;
import com.exigen.ren.admin.modules.commission.commissiontrategy.pages.CommissionPage;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.google.common.collect.ImmutableMap;

public class CommissionGroup implements ICommission {

    @Override
    public Workspace getDefaultWorkspace() {
        return AutomationContext.getAction(CommissionGroupCreateAction.class).getWorkspace();
    }

    @Override
    public void initiate() {
        CommissionPage.buttonAddNewCommissionGroup.click();
    }

    @Override
    public void create(TestData td) {
        navigate();
        initiate();
        getDefaultWorkspace().fill(td);
    }

    public ImmutableMap<String, String> createGroup(TestData td) {
        String commissionGroupTabName = getDefaultWorkspace().getTab(CommissionGroupTab.class).getMetaKey();
        String commissionGroupName = td.getTestData(commissionGroupTabName).getValue(CommissionGroupMetaData.GROUP_NAME.getLabel());
        create(td.adjust(TestData.makeKeyPath(commissionGroupTabName, CommissionGroupMetaData.GROUP_NAME.getLabel()), commissionGroupName));
        return ImmutableMap.of("Group Name", commissionGroupName);
    }

    @Override
    public void navigate() {
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.COMMISSION);
        NavigationPage.toLeftMenuTab(NavigationEnum.CommissionLeftMenu.COMMISSION_GROUP);
    }

    @Override
    public void submit() {}

    @Override
    public boolean searched(TestData td) {
        throw new UnsupportedOperationException("Not Supported");
    }

    @Override
    public CommissionGroupEditAction edit() {
        return AutomationContext.getAction(CommissionGroupEditAction.class);
    }

    @Override
    public CommissionGroupExpireAction expire() {
        return AutomationContext.getAction(CommissionGroupExpireAction.class);
    }

    @Override
    public Action copy() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public CommissionGroupDeleteAction delete() {
        return AutomationContext.getAction(CommissionGroupDeleteAction.class);
    }

    @Override
    public TestData defaultTestData() {
        return TestDataProvider.getDefaultTestDataProvider().get("modules/commission/commissiongroup");
    }
}
