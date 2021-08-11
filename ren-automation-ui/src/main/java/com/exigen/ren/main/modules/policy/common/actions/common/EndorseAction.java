/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.policy.common.actions.common;

import com.exigen.istf.data.TestData;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.policy.common.PolicyType;
import com.exigen.ren.main.modules.policy.common.tabs.common.StartEndorsementActionTab;

public class EndorseAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(StartEndorsementActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Endorse";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action submit() {
        Tab.buttonOk.click();
        Page.dialogConfirmation.confirm();
        NavigationPage.PolicyNavigation.leftMenu(NavigationEnum.GroupBenefitsTab.PREMIUM_SUMMARY.get(), Tab.doubleWaiter);
        Tab.buttonRate.click();
        Tab.buttonSaveAndExit.click();
        return this;
    }

     public static void startEndorsementForPolicy(PolicyType policyType, TestData td){
        policyType.get().endorse().start();
        policyType.get().endorse().getWorkspace().fill(td);
        Tab.buttonOk.click();
        Page.dialogConfirmation.confirm();
    }
}
