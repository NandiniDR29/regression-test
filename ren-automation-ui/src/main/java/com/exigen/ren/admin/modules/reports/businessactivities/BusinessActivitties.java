/* Copyright © 2018 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.reports.businessactivities;

import com.exigen.ipb.eisa.utils.RetryService;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.BrowserController;
import com.exigen.istf.webdriver.Downloads;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.reports.businessactivities.actions.BusinessActivitiesCreateAction;
import com.exigen.ren.admin.modules.reports.businessactivities.tabs.BusinessActivitiesTab;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class BusinessActivitties implements IBusinessActivity {

    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/platform/admin/reports/businessactivities");

    public void navigate() {
        if (!NavigationPage.isMainTabSelected(NavigationEnum.AppMainTabs.REPORTS)) {
            NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.REPORTS);
        }
        NavigationPage.toSubTab(NavigationEnum.ReportsTab.BUSINESS_ACTIVITIES.get());
    }

    public Workspace getDefaultWorkspace() {
        return AutomationContext.getAction(BusinessActivitiesCreateAction.class).getWorkspace();
    }

    @Override
    public void create(TestData td) {
        throw new UnsupportedOperationException("Not Supported");
    }

    @Override
    public void change(TestData td) {
        BusinessActivitiesTab.buttonChangeCriteria.click();
        getDefaultWorkspace().fill(td);
    }

    @Override
    public File saveReportToFile(TestData td, String fileName) {
        getDefaultWorkspace().getTab(BusinessActivitiesTab.class).fillTab(td);
        AtomicReference<File> report = new AtomicReference<>();
        RetryService.run(fileExist -> !fileExist.equals(false), () -> report.getAndSet(Downloads.getFile(fileName).get()).exists(),
                StopStrategies.stopAfterAttempt(5), WaitStrategies.fixedWait(5, TimeUnit.SECONDS));
        String defaultWindowHandler = BrowserController.get().driver().getWindowHandle();
        String popUpWindowHandler = BrowserController.get().driver().getWindowHandles()
                .stream().filter(window -> !window.equalsIgnoreCase(defaultWindowHandler)).findFirst().get();
        BrowserController.get().driver().switchTo().window(popUpWindowHandler).close();
        BrowserController.get().driver().switchTo().window(defaultWindowHandler);
        return report.get();
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }
}
