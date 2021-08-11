/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.ren.main.modules.claim.common.actions;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.claim.common.tabs.*;
import org.openqa.selenium.By;

public class CreatePaymentSeriesAction implements Action {
    private Workspace workspace = new Workspace.Builder()
            .registerTab(PaymentSeriesPaymentDetailsActionTab.class)
            .registerTab(PaymentSeriesPaymentAllocationActionTab.class)
            .registerTab(PaymentSeriesAdditionalPayeeTab.class)
            .registerTab(PaymentSeriesPaymentSeriesProfileActionTab.class)
            .registerTab(PaymentSeriesCalculatorActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Create Payment Series";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action start() {
        NavigationPage.toSubTab(NavigationEnum.ClaimTab.PAYMENTS.get());
        new Button(By.id("productConsolidatedViewForm:createPaymentSeriesClaimsPaymentRoot")).click();
        return this;
    }

    @Override
    public Action submit() {
        new Button(By.id("policyDataGatherForm:paymentValidateBtn_ClaimsPaymentSeriesCreateAction")).click();
        if (Page.dialogConfirmation.isPresent()) {
            Page.dialogConfirmation.confirm();
        }
        return this;
    }
}
