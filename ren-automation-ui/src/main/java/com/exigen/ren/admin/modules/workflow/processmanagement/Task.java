/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.workflow.processmanagement;

import com.exigen.istf.data.TestData;
import com.exigen.ren.EntityLogger;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.workflow.processmanagement.actions.ProcessManagementCreateAction;
import com.exigen.ren.admin.modules.workflow.processmanagement.pages.ProcessManagementPage;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.ActionConstants;
import com.exigen.ren.main.enums.AdminConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Task similar with Process Management
public class Task implements ITask {

    protected static final Logger LOGGER = LoggerFactory.getLogger(Task.class);
    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/platform/admin/workflow/processmanagement");

    @Override
    public Workspace getDefaultWorkspace() {
        return AutomationContext.getAction(ProcessManagementCreateAction.class).getWorkspace();
    }

    public void initiate() {
        navigate();
        ProcessManagementPage.buttonAddManualTaskDefinition.click();
    }

    public void navigate() {
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.WORK_FLOW);
        NavigationPage.toLeftMenuTab(NavigationEnum.WorkFlowLeftMenu.PROCESS_MANAGEMENT);
    }

    @Override
    public void create(TestData td) {
        initiate();
        getDefaultWorkspace().fill(td);
        String entity = EntityLogger.getEntityHeader(EntityLogger.EntityType.TASK);
        ProcessManagementPage.buttonSave.click();
        LOGGER.info("Created 'Manual Task Definition' " + entity);
    }

    @Override
    public void update(TestData td) {
        ProcessManagementPage.tableSearchResults.getRow(1).getCell(AdminConstants.AdminSearchResultsTable.ACTION).controls.links.get(ActionConstants.CHANGE).click();
        getDefaultWorkspace().fill(td);
        ProcessManagementPage.buttonSave.click();
    }

    public void search(TestData td) {
        ProcessManagementPage.search(td);
        ProcessManagementPage.buttonSearch.click();
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }
}
