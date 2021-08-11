/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.reports.dashboard;

import com.exigen.ipb.eisa.base.application.ApplicationFactory;
import com.exigen.istf.data.TestData;
import com.exigen.ren.admin.modules.IAdmin;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;

public class Dashboard implements IAdmin {

    @Override
    public Workspace getDefaultWorkspace() {
        throw new UnsupportedOperationException("Not Supported");
    }

    @Override
    public void create(TestData td) {
        throw new UnsupportedOperationException("Not Supported");
    }

    public void navigate() {
        if (!NavigationPage.isMainTabSelected(NavigationEnum.AdminAppMainTabs.REPORTS)) {
            NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.REPORTS);
            loginToReports();
        }
        NavigationPage.toSubTab(NavigationEnum.ReportsTab.DASHBOARD.get());
    }

    private void loginToReports() {
        if (!Tab.labelLoggedUser.isPresent()) {
            ApplicationFactory.getInstance().getAdminApplication().getLogin().login();
        }
    }

    @Override
    public TestData defaultTestData() {
        throw new UnsupportedOperationException("Not Supported");
    }
}
