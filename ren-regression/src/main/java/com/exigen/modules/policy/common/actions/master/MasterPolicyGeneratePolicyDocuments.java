package com.exigen.modules.policy.common.actions.master;

import com.exigen.modules.policy.common.tabs.master.GeneratePolicyDocumentsTab;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;

public class MasterPolicyGeneratePolicyDocuments implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(GeneratePolicyDocumentsTab.class)
            .build();

    @Override
    public String getName() {
        return "Generate Policy Documents";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }
}
