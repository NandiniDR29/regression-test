/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.partner;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.agencyvendor.IAgencyVendor;
import com.exigen.ren.admin.modules.agencyvendor.partner.actions.CreatePartnerAction;
import com.exigen.ren.admin.modules.agencyvendor.partner.actions.SearchPartnerAction;
import com.exigen.ren.admin.modules.agencyvendor.partner.pages.PartnerPage;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;

public class Partner implements IAgencyVendor {
    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/platform/admin/agencyvendor/partner");

    @Override
    public void search(TestData td) {
        navigate();
        search().getWorkspace().fill(td);
        search().submit();
    }

    @Override
    public void navigate() {
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.AGENCY_VENDOR);
        NavigationPage.toLeftMenuTab(NavigationEnum.AgencyVendorLeftMenu.PARTNER);
    }

    @Override
    public Workspace getDefaultWorkspace() {
        return AutomationContext.getAction(CreatePartnerAction.class).getWorkspace();
    }

    @Override
    public void create(TestData td) {
        initiate();
        getDefaultWorkspace().fill(td);
    }

    @Override
    public void initiate() {
        navigate();
        PartnerPage.buttonAddPartner.click();
    }

    public void update(TestData testData, int rowNumber) {
        PartnerPage.tableSearchResult.getRow(rowNumber).getCell("Change").controls.links.getFirst().click();
        getDefaultWorkspace().fill(testData);
    }

    @Override
    public Action search() {
        return AutomationContext.getAction(SearchPartnerAction.class);
    }

    @Override
    public Action update() {
        throw new UnsupportedOperationException("Method is nor realised");
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }
}
