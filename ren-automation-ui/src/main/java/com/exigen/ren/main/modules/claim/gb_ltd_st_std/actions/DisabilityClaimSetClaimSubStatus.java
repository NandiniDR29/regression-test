package com.exigen.ren.main.modules.claim.gb_ltd_st_std.actions;

import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.claim.common.actions.SetClaimSubStatusAction;
import com.exigen.ren.main.modules.claim.common.tabs.ClaimSubStatusTab;

public class DisabilityClaimSetClaimSubStatus extends SetClaimSubStatusAction {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(ClaimSubStatusTab.class)
            .build();

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

}
