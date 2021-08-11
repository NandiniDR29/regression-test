package com.exigen.ren.main.modules.claim.common.actions;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;

import static com.exigen.ren.main.enums.ActionConstants.ClaimAction.READJUDICATE;

public class ClaimReadjudicateAction implements Action {
    private Workspace workspace = new Workspace.Builder()
            .build();

    @Override
    public String getName() {
        return READJUDICATE;
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action submit() {
        return null;
    }
}