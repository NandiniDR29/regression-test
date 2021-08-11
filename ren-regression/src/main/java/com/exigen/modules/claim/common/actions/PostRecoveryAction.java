/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.modules.claim.common.actions;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.claim.common.tabs.RecoveryRecoveredFromActionTab;
import com.exigen.ren.main.modules.claim.common.tabs.RecoveryRecoveryAllocationActionTab;
import com.exigen.ren.main.modules.claim.common.tabs.RecoveryRecoveryDetailsActionTab;
import org.openqa.selenium.By;

import static com.exigen.ren.common.enums.NavigationEnum.ClaimRecoveryTab.RECOVERED_FROM;

public class PostRecoveryAction implements Action {
    private Workspace workspace = new Workspace.Builder()
            .registerTab(RecoveryRecoveryDetailsActionTab.class)
            .registerTab(RecoveryRecoveryAllocationActionTab.class)
            .registerTab(RecoveryRecoveredFromActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Post Recovery";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action start() {
        NavigationPage.toSubTab(NavigationEnum.ClaimTab.PAYMENTS.get());
        new Button(By.id("productConsolidatedViewForm:postRecoveryClaimsPaymentRoot")).click();
        return this;
    }

    @Override
    public Action submit() {
        NavigationPage.toLeftMenuTab(RECOVERED_FROM.get());
        new Button(By.id("policyDataGatherForm:postRecoveryBtn_ClaimsRecoveryPostAction")).click();
        if (Page.dialogConfirmation.isPresent()) {
            Page.dialogConfirmation.confirm();
        }
        return this;
    }
}
