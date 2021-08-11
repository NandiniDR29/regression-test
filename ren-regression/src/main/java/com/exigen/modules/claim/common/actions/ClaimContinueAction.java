package com.exigen.modules.claim.common.actions;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.claim.common.tabs.ClaimContinueActionTab;

import static com.exigen.ren.main.enums.ActionConstants.ClaimAction.CONTINUE_CLAIM;

public class ClaimContinueAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(ClaimContinueActionTab.class)
            .build();

    @Override
    public String getName() {
        return CONTINUE_CLAIM;
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action submit() {
        ClaimContinueActionTab.buttonContinueClaim.click();
        return this;
    }
}