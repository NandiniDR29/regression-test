/* Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent. */
package com.exigen.ren.admin.modules.billing.rules.paymentdeficiency;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.billing.rules.IRules;
import com.exigen.ren.admin.modules.billing.rules.paymentdeficiency.pages.PaymentDeficiencyPage;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;

import java.util.stream.IntStream;

public class PaymentDeficiency implements IRules {
    private TestData defaultTesData = TestDataProvider.getDefaultTestDataProvider().get("modules/platform/admin/billing/rules/paymentdeficiency");

    public void navigate() {
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.BILLING);
        NavigationPage.toLeftMenuTab(NavigationEnum.BillingLeftMenu.RULES);
        NavigationPage.toSubTab(NavigationEnum.BillingRulesSubTab.PAYMENT_DEFICIENCY.get());
    }

    @Override
    public Workspace getDefaultWorkspace() {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void create(TestData td) {
        navigate();
        PaymentDeficiencyPage.createPaymentDeficiency(td);
        PaymentDeficiencyPage.buttonAddUpdate.click();
    }

    public void createIfNotExist(TestData td) {
        navigate();
        if(PaymentDeficiencyPage.tableBillingPaymentDeficiency.getRows().size() == 0) {
            PaymentDeficiencyPage.createPaymentDeficiency(td);
            PaymentDeficiencyPage.buttonAddUpdate.click();
        }
    }

    public void deletePaymentDeficiency() {
        navigate();

        IntStream.range(0, PaymentDeficiencyPage.tableBillingPaymentDeficiency.getRowsCount()).forEach(row -> {
            PaymentDeficiencyPage.tableBillingPaymentDeficiency.getRow(1).getCell("Actions").controls.links.get("Delete").click();
            Page.dialogConfirmation.confirm();
        });
    }

    @Override
    public TestData defaultTestData() {
        return defaultTesData;
    }
}
