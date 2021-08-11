/* Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent. */
package com.exigen.ren.admin.modules.billing.rules.paymentplans;

import com.exigen.istf.data.TestData;
import com.exigen.ren.admin.modules.billing.rules.IRules;
import com.exigen.ren.admin.modules.billing.rules.paymentplans.pages.PaymentPlansPage;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;

public class PaymentPlans implements IRules {
    private static final Object LOCK = new Object();

    @Override
    public TestData defaultTestData() {
        throw new UnsupportedOperationException("Not implemented");
    }

    public void refreshAdminAppCode() {
        synchronized (LOCK) {
            navigate();
            PaymentPlansPage.buttonSearch.click();
            PaymentPlansPage.tablePaymentPlans.getRow("Code", "TwicePerYear").getCell("Actions")
                    .controls.links.get("Edit").click();
            PaymentPlansPage.buttonAddUpdate.click();
            if (Page.dialogConfirmationWithoutHeader.isPresent()) {
                Page.dialogConfirmationWithoutHeader.confirm();
            }
        }
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
        NavigationPage.toLeftMenuTab(NavigationEnum.BillingLeftMenu.RULES);
        NavigationPage.toSubTab(NavigationEnum.BillingRulesSubTab.PAYMENT_PLANS);
    }
}
