package com.exigen.ren.main.modules.policy.gb_eap.masterpolicy.actions;

import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.billing.account.tabs.BillingAccountTab;
import com.exigen.ren.main.modules.policy.common.actions.master.MasterPolicyIssueAction;
import com.exigen.ren.main.modules.policy.common.tabs.master.BillingGroupsActionTab;
import com.exigen.ren.main.modules.policy.common.tabs.master.IssueActionTab;
import com.exigen.ren.main.modules.policy.common.tabs.master.PolicyInformationIssueActionTab;
import com.exigen.ren.main.modules.policy.common.tabs.master.PremiumSummaryIssueActionTab;
import com.exigen.ren.main.modules.policy.gb_eap.masterpolicy.tabs.PlanDefinitionIssueActionTab;

public class EmployeeAssistanceProgramMasterPolicyIssueAction extends MasterPolicyIssueAction {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(PolicyInformationIssueActionTab.class)
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
