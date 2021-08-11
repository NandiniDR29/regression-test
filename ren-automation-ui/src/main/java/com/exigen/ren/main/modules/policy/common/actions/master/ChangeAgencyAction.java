package com.exigen.ren.main.modules.policy.common.actions.master;

import com.exigen.istf.data.TestData;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.policy.common.tabs.master.ChangeAgencyTab;

public class ChangeAgencyAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(ChangeAgencyTab.class)
            .build();

    @Override
    public String getName() {
        return "Change Agency";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action perform(TestData td) {
        start();
        getWorkspace().fill(td);
        return this;
    }
}
