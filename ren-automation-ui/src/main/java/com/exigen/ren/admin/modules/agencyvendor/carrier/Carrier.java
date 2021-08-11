/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.carrier;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.agencyvendor.IAgencyVendor;
import com.exigen.ren.admin.modules.agencyvendor.carrier.actions.CreateCarrierAction;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;

public class Carrier implements IAgencyVendor {

    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/platform/admin/agencyvendor/carrier");


    @Override
    public Workspace getDefaultWorkspace() {
        return AutomationContext.getAction(CreateCarrierAction.class).getWorkspace();
    }

    @Override
    public void create(TestData td) {
        navigate();
        getDefaultWorkspace().fill(td);
    }

    @Override
    public void initiate() {
        throw new UnsupportedOperationException("Method is not released");
    }

    @Override
    public Action update() {
        throw new UnsupportedOperationException("Method is not released");
    }

    @Override
    public void search(TestData td) {
        throw new UnsupportedOperationException("Method is not released");
    }

    @Override
    public void navigate() {
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.AGENCY_VENDOR);
        NavigationPage.toLeftMenuTab(NavigationEnum.AgencyVendorLeftMenu.CARRIER_INFO);
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }
}
