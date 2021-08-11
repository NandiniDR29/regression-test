package com.exigen.modules.policy.gb_vs.masterpolicy.actions;

import com.exigen.modules.policy.common.actions.master.MasterPolicyDataGatherAction;
import com.exigen.modules.policy.gb_vs.masterpolicy.tabs.*;
import com.exigen.ren.common.Workspace;

public class GroupVisionMasterPolicyDataGatherAction extends MasterPolicyDataGatherAction {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(PolicyInformationTab.class)
            .registerTab(CaseInstallationTab.class)
            .registerTab(EnrollmentTab.class)
            .registerTab(PlanDefinitionTab.class)
            .registerTab(ClassificationManagementTab.class)
            .registerTab(PremiumSummaryTab.class)
            .build();

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }
}
