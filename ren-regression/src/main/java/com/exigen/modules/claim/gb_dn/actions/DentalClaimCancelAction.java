package com.exigen.modules.claim.gb_dn.actions;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.claim.gb_dn.tabs.ClaimCancelActionTab;

import static com.exigen.ren.main.modules.claim.gb_dn.tabs.ClaimCancelActionTab.buttonCancelClaim;

public class DentalClaimCancelAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(ClaimCancelActionTab.class)
            .build();

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public String getName() {
        return "Cancel Claim";
    }

    @Override
    public Action submit() {
        buttonCancelClaim.click();
        return this;
    }
}
