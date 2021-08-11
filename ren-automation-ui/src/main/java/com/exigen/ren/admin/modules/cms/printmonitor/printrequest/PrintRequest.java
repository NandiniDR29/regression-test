/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.cms.printmonitor.printrequest;

import com.exigen.ipb.eisa.utils.RetryService;
import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.cms.printmonitor.IPrintMonitor;
import com.exigen.ren.admin.modules.cms.printmonitor.pages.PrintMonitorPage;
import com.exigen.ren.admin.modules.cms.printmonitor.printrequest.actions.PrintRequestRefreshAction;
import com.exigen.ren.admin.modules.cms.printmonitor.printrequest.tabs.PrintRequestTab;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class PrintRequest implements IPrintMonitor {

    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/platform/admin/cms/printmonitor/printrequest");

    @Override
    public Workspace getDefaultWorkspace() {
        return AutomationContext.getAction(PrintRequestRefreshAction.class).getWorkspace();
    }

    @Override
    public void create(TestData td) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void initiate() {
        throw new UnsupportedOperationException("Initiate is not implemented in this entity");
    }

    @Override
    public void navigate() {
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.CMS);
        NavigationPage.toLeftMenuTab(NavigationEnum.CMSLeftMenu.PRINT_MONITOR);
        NavigationPage.toSubTab(NavigationEnum.CMSPrintMonitorSubTab.PRINT_REQS);
    }

    @Override
    public void refresh(TestData testData) {
        navigate();
        getDefaultWorkspace().fill(testData);
        refreshResult(10);
    }

    public void cancel(Integer... rowNumber) {
        Arrays.asList(rowNumber).forEach(
                row -> PrintMonitorPage.tableRefreshResult.getRow(row).getCell(1).controls.checkBoxes.getFirst().setValue(true)
        );
        PrintRequestTab.buttonCancelSelected.click();
    }

    public void reschedule(TestData testData, Integer... rowNumber) {
        Arrays.asList(rowNumber).forEach(
                row -> PrintMonitorPage.tableRefreshResult.getRow(row).getCell(1).controls.checkBoxes.getFirst().setValue(true)
        );
        PrintRequestTab.buttonRescheduleSelected.click();
        PrintRequestTab.rescheduleTime.fill(testData);
        PrintRequestTab.buttonConfirmRescheduleDialog.click();
    }

    public void pause(Integer... rowNumber) {
        Arrays.asList(rowNumber).forEach(
                row -> PrintMonitorPage.tableRefreshResult.getRow(row).getCell(1).controls.checkBoxes.getFirst().setValue(true)
        );
        PrintRequestTab.buttonPauseSelected.click();
    }

    private void refreshResult(int attempt) {
        RetryService.run(predicate -> PrintMonitorPage.tableRefreshResult.isPresent() &&
                PrintMonitorPage.tableRefreshResult.getRowsCount() != 0, () -> {
            PrintRequestTab.buttonRefresh.click();
            return null;
        }, StopStrategies.stopAfterAttempt(attempt), WaitStrategies.fixedWait(10, TimeUnit.SECONDS));
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }
}
