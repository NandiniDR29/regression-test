package com.exigen.ren.main.modules.policy.common.actions.common;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ActionConstants;
import com.exigen.ren.main.modules.policy.common.tabs.common.FaxBackPolicyInfoCoveragesTab;

public class FaxBackPolicyInformationAction implements Action {

    @Override
    public String getName() {
        return ActionConstants.ProductAction.FAX_BACK_POLICY_INFORMATION;
    }

    private Workspace workspace = new Workspace.Builder()
            .registerTab(FaxBackPolicyInfoCoveragesTab.class)
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
