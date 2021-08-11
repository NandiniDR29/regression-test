package com.exigen.modules.claim.gb_dn.actions;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.claim.common.actions.ClaimUpdateAction;
import com.exigen.ren.main.modules.claim.gb_dn.tabs.ClaimAdjustActionTab;

import static com.exigen.ren.main.modules.claim.gb_dn.tabs.ClaimAdjustActionTab.buttonAdjustClaim;

public class DentalClaimAdjustAction extends ClaimUpdateAction {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(ClaimAdjustActionTab.class)
            .build();

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public String getName() {
        return "Adjust Claim";
    }

    @Override
    public Action submit() {
        buttonAdjustClaim.click();
        return this;
    }
}
