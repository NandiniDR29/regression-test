/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package com.exigen.ren.main.modules.policy.common.actions.master;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.policy.common.tabs.master.ClassificationManagementActionTab;
import com.exigen.ren.main.modules.policy.common.tabs.master.PremiumSummaryActionTab;
import com.exigen.ren.main.modules.policy.common.tabs.master.StartPremiumAdjustmentActionTab;
import org.openqa.selenium.By;

public class MasterPolicyPremiumAdjustmentAction implements Action {
    public static Button buttonAdjustPremium = new Button(By.id("policyDataGatherForm:processPolicyAdjustPremiumActionButton_GroupMasterPolicyAdjustPremiumAction_footer"));

    private Workspace workspace = new Workspace.Builder()
            .registerTab(StartPremiumAdjustmentActionTab.class)
            .registerTab(ClassificationManagementActionTab.class)
            .registerTab(PremiumSummaryActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Premium Adjustment";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action submit() {
        PremiumSummaryActionTab.buttonRate.click();
        buttonAdjustPremium.click();
        if (Page.dialogConfirmation.isPresent()) {
            Page.dialogConfirmation.confirm();
        }
        return this;
    }
}
