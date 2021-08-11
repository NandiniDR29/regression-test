/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.common.actions;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.claim.common.tabs.SubmitClaimActionTab;
import org.openqa.selenium.By;

import static com.exigen.ren.main.enums.ActionConstants.ClaimAction.CLAIM_SUBMIT;

public class ClaimSubmitAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(SubmitClaimActionTab.class)
            .build();

    @Override
    public String getName() {
        return CLAIM_SUBMIT;
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action submit() {
        new Button(By.xpath("//input[@value='Submit Claim' and not(contains(@style, 'none'))]")).click();
        return this;
    }

}
