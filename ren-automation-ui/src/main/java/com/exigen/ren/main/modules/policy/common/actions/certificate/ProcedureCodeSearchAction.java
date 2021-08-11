package com.exigen.ren.main.modules.policy.common.actions.certificate;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ActionConstants;
import com.exigen.ren.main.modules.policy.common.tabs.certificate.ProcedureCodeSearchTab;

public class ProcedureCodeSearchAction implements Action{

    @Override
    public String getName() {
        return ActionConstants.ProductAction.PROCEDURE_CODE_SEARCH;
    }

    private Workspace workspace = new Workspace.Builder()
            .registerTab(ProcedureCodeSearchTab.class)
            .build();

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    public Action exit() {
        Tab.buttonCancel.click();
        Page.dialogConfirmation.confirm();
        return this;
    }
}
