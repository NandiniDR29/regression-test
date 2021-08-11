/* Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent. */
package com.exigen.ren.admin.modules.billing.global.write_off_reasons;

import com.exigen.istf.data.TestData;
import com.exigen.ren.admin.modules.billing.rules.IRules;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;

public class WriteOffReasons implements IRules {

    @Override
    public TestData defaultTestData() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Workspace getDefaultWorkspace() {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void create(TestData td) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void navigate() {
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.BILLING);
        NavigationPage.toLeftMenuTab(NavigationEnum.BillingLeftMenu.GLOBAL);
        NavigationPage.toSubTab(NavigationEnum.BillingGlobalSubTab.WRITE_OFF_REASONS);
    }
}