/* Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent. */
package com.exigen.ren.admin.modules.billing.billingcycle.cancellations.benefits;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.billing.billingcycle.IBillingCycle;
import com.exigen.ren.admin.modules.billing.billingcycle.cancellations.benefits.actions.BillingCancellationsBenefitsCreateAction;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;

import java.util.Map;

import static com.exigen.ren.admin.modules.billing.billingcycle.cancellations.benefits.tabs.CancellationsBenefitsTab.tableBenefits;

public class CancellationsBenefits implements IBillingCycle {
    private TestData defaultTesData = TestDataProvider.getDefaultTestDataProvider().get("modules/platform/admin/billing/billingcycle/cancellationbenefit");

    @Override
    public void navigate() {
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.BILLING);
        NavigationPage.toLeftMenuTab(NavigationEnum.BillingLeftMenu.BILLING_CYCLE);
        NavigationPage.toSubTab(NavigationEnum.BillingBillingCycleSubTab.CANCELLATIONS);
        NavigationPage.toSubTab(NavigationEnum.BillingBillingCycleCancellationsSubTab.BENEFITS);
    }

    @Override
    public Workspace getDefaultWorkspace() {
        return AutomationContext.getAction(BillingCancellationsBenefitsCreateAction.class).getWorkspace();
    }

    @Override
    public void create(TestData td) {
        navigate();
        getDefaultWorkspace().fill(td);
    }

    @Override
    public TestData defaultTestData() {
        return defaultTesData;
    }

    public void deleteCancellation(Map<String, String> cancellation) {
        navigate();
        tableBenefits.getRow(cancellation).getCell("Actions").controls.links.get("Delete").click();
        Page.dialogConfirmation.confirm();
    }

    public void deleteAllCancellation() {
        navigate();
        tableBenefits.getRows().forEach(row -> {
            tableBenefits.getRow(1).getCell("Actions").controls.links.get("Delete").click();
            Page.dialogConfirmation.confirm();
        });
    }
}