package com.exigen.modules.policy.gb_ac.masterpolicy;

import com.exigen.istf.data.TestData;
import com.exigen.modules.billing.account.tabs.BillingAccountTab;
import com.exigen.modules.policy.common.actions.common.IssueAction;
import com.exigen.modules.policy.common.tabs.master.BillingGroupsActionTab;
import com.exigen.modules.policy.common.tabs.master.IssueActionTab;
import com.exigen.modules.policy.common.tabs.master.PolicyInformationIssueActionTab;
import com.exigen.modules.policy.common.tabs.master.PremiumSummaryIssueActionTab;
import com.exigen.modules.policy.gb_ac.masterpolicy.tabs.PlanDefinitionIssueActionTab;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;

public class AccidentMasterPolicyIssueAction extends IssueAction {
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

    @Override
    public Action start() {
        NavigationPage.setActionAndGo(getName());
        if (Page.dialogConfirmation.isPresent()) {
            Page.dialogConfirmation.confirm();
        }
        return this;
    }

    @Override
    public Action perform(TestData td) {
        start();
        getWorkspace().fill(td);
        return this;
    }
}
