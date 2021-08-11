package com.exigen.ren.main.modules.claim.common.actions;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;

import static com.exigen.ren.main.modules.claim.common.tabs.ClaimSubStatusTab.setClaimSubStatusButton;

public class SetClaimSubStatusAction implements Action {

    @Override
    public String getName() {
        return "Set Claim Sub-status";
    }

    @Override
    public Workspace getWorkspace() {
        return AutomationContext.getAction(SetClaimSubStatusAction.class).getWorkspace();
    }

    @Override
    public Action submit() {
        setClaimSubStatusButton.click();
        return this;
    }
}
