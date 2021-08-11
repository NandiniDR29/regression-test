package com.exigen.modules.billing.account.actions;

import com.exigen.istf.data.TestData;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.billing.account.tabs.ConsolidatedStatementDetailsActionTab;

public class SetUpConsolidatedStatementAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(ConsolidatedStatementDetailsActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Set Up Consolidated Statement";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action submit() {
        Tab.buttonSetUpUpdate.click();
        return this;
    }

    public Action perform(TestData td) {
        start();
        getWorkspace().fill(td);
        return submit();
    }
}