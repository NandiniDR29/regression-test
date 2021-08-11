/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package com.exigen.modules.policy.gb_dn.masterpolicy.actions;

import com.exigen.modules.billing.account.tabs.BillingAccountTab;
import com.exigen.modules.policy.common.actions.master.MasterPolicyIssueAction;
import com.exigen.modules.policy.common.tabs.master.BillingGroupsActionTab;
import com.exigen.modules.policy.common.tabs.master.IssueActionTab;
import com.exigen.modules.policy.common.tabs.master.PolicyInformationIssueActionTab;
import com.exigen.modules.policy.common.tabs.master.PremiumSummaryIssueActionTab;
import com.exigen.modules.policy.gb_dn.masterpolicy.tabs.CaseInstallationIssueActionTab;
import com.exigen.modules.policy.gb_dn.masterpolicy.tabs.PlanDefinitionIssueActionTab;
import com.exigen.ren.common.Workspace;

public class DentalMasterPolicyIssueAction extends MasterPolicyIssueAction {


    private Workspace workspace = new Workspace.Builder()
            .registerTab(PolicyInformationIssueActionTab.class)
            .registerTab(CaseInstallationIssueActionTab.class)
            .registerTab(PlanDefinitionIssueActionTab.class)
            .registerTab(PremiumSummaryIssueActionTab.class)
            .registerTab(BillingGroupsActionTab.class)
            .registerTab(IssueActionTab.class)
            .registerTab(BillingAccountTab.class)
            .build();


    @Override
    public Workspace getWorkspace() {
        return workspace;
    }
}
