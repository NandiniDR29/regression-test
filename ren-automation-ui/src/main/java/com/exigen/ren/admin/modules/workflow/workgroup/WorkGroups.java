/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.workflow.workgroup;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.workflow.workgroup.pages.WorkGroupPage;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.AdminConstants;

public class WorkGroups implements IWorkGroups {

    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/platform/admin/workflow/workgroup");

    @Override
    public Workspace getDefaultWorkspace() {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void navigate() {
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.WORK_FLOW);
        NavigationPage.toLeftMenuTab(NavigationEnum.WorkFlowLeftMenu.WORK_GROUPS);
    }

    @Override
    public void create(TestData td) {
        navigate();
        WorkGroupPage.buttonAddWorkGroup.click();
        WorkGroupPage.fillDialog(td);
        WorkGroupPage.buttonSaveUpdate.click();
    }

    @Override
    public void update(TestData td, String updatedGroupCode) {
        WorkGroupPage.tableAllWorkGroup.getRow(AdminConstants.AdminWorkGroupTable.CODE, updatedGroupCode).getCell(AdminConstants.AdminWorkGroupTable.ACTIONS)
                .controls.links.get(AdminConstants.AdminWorkGroupTable.EDIT).click();
        WorkGroupPage.fillDialog(td);
        WorkGroupPage.buttonSaveUpdate.click();


    }

    @Override
    public void delete(String deletedElement) {
        WorkGroupPage.tableAllWorkGroup.getRow(AdminConstants.AdminWorkGroupTable.CODE, deletedElement).getCell(AdminConstants.AdminWorkGroupTable.ACTIONS)
                .controls.links.get(AdminConstants.AdminWorkGroupTable.REMOVE).click();
        Page.dialogConfirmation.confirm();
    }


    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }
}
