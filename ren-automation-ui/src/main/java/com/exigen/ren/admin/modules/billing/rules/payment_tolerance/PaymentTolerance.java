/* Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent. */
package com.exigen.ren.admin.modules.billing.rules.payment_tolerance;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.billing.rules.IRules;
import com.exigen.ren.admin.modules.billing.rules.payment_tolerance.actions.PaymentToleranceCreateAction;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;

import static com.exigen.ren.common.enums.NavigationEnum.BillingRulesSubTab.PAYMENT_TOLERANCE;

public class PaymentTolerance implements IRules {
    private TestData defaultTesData = TestDataProvider.getDefaultTestDataProvider().get("modules/platform/admin/billing/rules/write_off/payment_tolerance");

    @Override
    public TestData defaultTestData() {
        return defaultTesData;
    }

    @Override
    public Workspace getDefaultWorkspace() {
        return AutomationContext.getAction(PaymentToleranceCreateAction.class).getWorkspace();
    }

    @Override
    public void create(TestData td) {
        navigate();
        getDefaultWorkspace().fill(td);
    }

    @Override
    public void navigate() {
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.BILLING);
        NavigationPage.toLeftMenuTab(NavigationEnum.BillingLeftMenu.RULES);
        NavigationPage.toSubTab(PAYMENT_TOLERANCE);
    }
}
