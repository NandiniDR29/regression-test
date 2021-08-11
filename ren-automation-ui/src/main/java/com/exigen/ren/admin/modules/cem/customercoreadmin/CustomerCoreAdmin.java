/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.cem.customercoreadmin;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.cem.customercoreadmin.pages.CustomerCoreAdminPage;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;

public class CustomerCoreAdmin implements ICustomerCoreAdmin {

    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/cem/cem/customercoreadmin");


    @Override
    public Workspace getDefaultWorkspace() {
        throw new UnsupportedOperationException("Not Supported");
    }

    @Override
    public void create(TestData td) {
        navigate();
        CustomerCoreAdminPage.createConfig(td);
    }

    @Override
    public void initiate() {
    }

    public void navigate() {
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.CEM.get());
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }
}
