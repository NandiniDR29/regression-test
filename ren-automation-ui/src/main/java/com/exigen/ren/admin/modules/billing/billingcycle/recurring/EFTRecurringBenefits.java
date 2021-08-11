/* Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent. */
package com.exigen.ren.admin.modules.billing.billingcycle.recurring;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.billing.billingcycle.cancellations.benefits.actions.BillingCancellationsBenefitsCreateAction;
import com.exigen.ren.admin.modules.billing.billingcycle.recurring.actions.EFTRecurringBenefitsCreateAction;
import com.exigen.ren.admin.modules.billing.billingcycle.recurring.tabs.EFTRecurringBenefitsTab;
import com.exigen.ren.admin.modules.billing.rules.IRules;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ActionConstants;

import static com.exigen.ren.admin.modules.billing.billingcycle.recurring.tabs.EFTRecurringBenefitsTab.tableEFTRecurring;

public class EFTRecurringBenefits implements IRules {
    private TestData defaultTesData = TestDataProvider.getDefaultTestDataProvider().get("modules/platform/admin/billing/billingcycle/eft_recurring");

    @Override
    public void navigate() {
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.BILLING);
        NavigationPage.toLeftMenuTab(NavigationEnum.BillingLeftMenu.BILLING_CYCLE);
        NavigationPage.toSubTab(NavigationEnum.BillingBillingCycleSubTab.EFT_RECURRING);
    }

    @Override
    public Workspace getDefaultWorkspace() {
        return AutomationContext.getAction(EFTRecurringBenefitsCreateAction.class).getWorkspace();
    }

    @Override
    public void create(TestData td) {
        navigate();
        getDefaultWorkspace().fill(td);
    }
    public void removeEFTRecurringValues(){
        navigate();
        tableEFTRecurring.getRows().forEach(i -> {
            tableEFTRecurring.getRow(1).getCell(EFTRecurringBenefitsTab.EFTRecurring.ACTIONS.getName()).controls.links.get(ActionConstants.DELETE).click();
            Page.dialogConfirmation.confirm();
        });
    }

    @Override
    public TestData defaultTestData() {
        return defaultTesData;
    }

}
