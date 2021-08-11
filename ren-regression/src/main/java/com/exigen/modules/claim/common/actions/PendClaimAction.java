package com.exigen.modules.claim.common.actions;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.claim.common.actions.ClaimUpdateAction;
import com.exigen.ren.main.modules.claim.common.tabs.ClaimPendClaimActionTab;

import static com.exigen.ren.main.modules.claim.common.tabs.ClaimPendClaimActionTab.buttonPendClaim;

public class PendClaimAction extends ClaimUpdateAction {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(ClaimPendClaimActionTab.class)
            .build();

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public String getName() {
        return "Pend Claim";
    }

    @Override
    public Action submit() {
        buttonPendClaim.click();
        return this;
    }

    @Override
    public Action start() {
        NavigationPage.toSubTab(NavigationEnum.ClaimTab.ADJUDICATION.get());
        super.start();
        return this;
    }
}
