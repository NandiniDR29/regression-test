/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.policy.gb_tl.masterpolicy.actions;

import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.policy.common.actions.master.MasterPolicyAcceptContractAction;
import com.exigen.ren.main.modules.policy.gb_tl.masterpolicy.tabs.MasterPolicyBindActionTab;
import com.exigen.ren.main.modules.policy.gb_tl.masterpolicy.tabs.PremiumSummaryBindActionTab;

public class TermLifeInsuranceMasterPolicyAcceptContractAction extends MasterPolicyAcceptContractAction {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(MasterPolicyBindActionTab.class)
            .registerTab(PremiumSummaryBindActionTab.class)
            .build();

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }
}
