/* Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent. */
package com.exigen.ren.admin.modules.billing.global.billingholdmoratoriumreasons;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.billing.global.IGlobal;
import com.exigen.ren.admin.modules.billing.global.billingholdmoratoriumreasons.pages.BillingHoldAndMoratoriumReasonsPage;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;

public class BillingHoldMoratoriumReasons implements IGlobal {
    private TestData defaultTesData = TestDataProvider.getDefaultTestDataProvider().get("modules/platform/admin/billing/global/billingholdandmoratoriumreasons");

    public void search(TestData td) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void navigate() {
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.BILLING);
        NavigationPage.toLeftMenuTab(NavigationEnum.BillingLeftMenu.GLOBAL);
        NavigationPage.toSubTab(NavigationEnum.BillingGlobalSubTab.BILLING_HOLD_MORATORIUM_REASONS);
    }

    @Override
    public Workspace getDefaultWorkspace() {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void create(TestData td) {
        navigate();
        BillingHoldAndMoratoriumReasonsPage.createBillingHold(td);
        BillingHoldAndMoratoriumReasonsPage.buttonAddUpdate.click();
    }

    public void createIfNotExist(TestData td) {
        navigate();
        if(!BillingHoldAndMoratoriumReasonsPage.tableBillingHoldAndMoratoriumReasons.getRow("Category", "Moratorium").isPresent()) {
            BillingHoldAndMoratoriumReasonsPage.createBillingHold(td);
            BillingHoldAndMoratoriumReasonsPage.buttonAddUpdate.click();
        }
    }

    @Override
    public TestData defaultTestData() {
        return defaultTesData;
    }
}
