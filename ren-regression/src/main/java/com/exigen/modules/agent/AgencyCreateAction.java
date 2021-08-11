package com.exigen.modules.agent;

import com.exigen.ren.admin.modules.agencyvendor.agency.tabs.*;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;

public class AgencyCreateAction implements Action {
    private Workspace workspace = new Workspace.Builder()
            .registerTab(AgencyInfoTab.class)
            .registerTab(ContactInfoTab.class)
            .registerTab(BankingDetailsTab.class)
            .registerTab(SupportTeamTab.class)
            .registerTab(UsersTab.class)
            .registerTab(ChildrenTab.class)
            .registerTab(CommissionsInfoTab.class)
            .registerTab(LicenseInfoTab.class)
            .build();

    @Override
    public String getName() {
        return "Create Agency Action";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }
}
