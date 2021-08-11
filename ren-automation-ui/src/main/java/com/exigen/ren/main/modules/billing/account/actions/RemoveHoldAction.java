/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.billing.account.actions;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import org.openqa.selenium.By;

public class RemoveHoldAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .build();

    @Override
    public String getName() {
        return "Remove Billing Account Hold";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action submit() {
        new Button(By.id("holdForm:removeButton_footer")).click();
        return this;
    }

}
