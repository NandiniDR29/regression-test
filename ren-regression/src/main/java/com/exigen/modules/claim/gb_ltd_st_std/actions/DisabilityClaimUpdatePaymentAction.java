/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.gb_ltd_st_std.actions;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.claim.common.actions.UpdatePaymentAction;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.actions.DisabilityClaimAddPaymentAction;
import org.openqa.selenium.By;

public class DisabilityClaimUpdatePaymentAction extends UpdatePaymentAction {

    @Override
    public Workspace getWorkspace() {
        return AutomationContext.getAction(DisabilityClaimAddPaymentAction.class).getWorkspace();
    }

    @Override
    public Action submit() {
        NavigationPage.toLeftMenuTab("Payment Allocation");
        new Button(By.id("policyDataGatherForm:paymentValidateBtn_ClaimsPaymentUpdateAction")).click();
        if (Page.dialogConfirmation.isPresent()) {
            Page.dialogConfirmation.confirm();
        }
        return this;
    }

}
