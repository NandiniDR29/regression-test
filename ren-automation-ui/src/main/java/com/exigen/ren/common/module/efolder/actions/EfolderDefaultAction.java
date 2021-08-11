package com.exigen.ren.common.module.efolder.actions;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.module.efolder.defaulttabs.AddExtFileTab;
import com.exigen.ren.common.module.efolder.defaulttabs.AddFileTab;
import com.exigen.ren.common.module.efolder.defaulttabs.ReindexFileTab;
import com.exigen.ren.common.module.efolder.defaulttabs.RenameFileTab;

public class EfolderDefaultAction implements Action {

    private Workspace workspace = new Workspace.Builder()
    .registerTab(AddFileTab.class)
    .registerTab(AddExtFileTab.class)
    .registerTab(RenameFileTab.class)
    .registerTab(ReindexFileTab.class).build();

    @Override
    public String getName() {
        return "Default Efolder Action";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

}
