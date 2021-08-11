/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package com.exigen.ren.main.modules.policy.common.actions.master;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.policy.common.tabs.master.PolicyInformationBindActionTab;
import com.exigen.ren.main.modules.policy.common.tabs.master.PremiumSummaryBindActionTab;

public class MasterPolicyAcceptContractAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(PolicyInformationBindActionTab.class)
            .registerTab(PremiumSummaryBindActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Contract Acceptance";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action submit() {
        Tab.buttonNext.click();
        return this;
    }
}
