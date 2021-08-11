package com.exigen.ren.main.modules.policy.gb_dn.masterpolicy.actions;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.policy.gb_dn.masterpolicy.tabs.StartUpdateProcedureCodeTab;
import com.exigen.ren.main.modules.policy.gb_dn.masterpolicy.tabs.UpdateProcedureCodePlanDefinitionTab;

public class GroupDentalMasterPolicyUpdateProcedureCodeAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(StartUpdateProcedureCodeTab.class)
            .registerTab(UpdateProcedureCodePlanDefinitionTab.class)
            .build();

    @Override
    public String getName() {
        return "Update Procedure Code";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action submit() {
        Tab.buttonOk.click();
        Tab.buttonOk.click();
        return this;
    }

}
