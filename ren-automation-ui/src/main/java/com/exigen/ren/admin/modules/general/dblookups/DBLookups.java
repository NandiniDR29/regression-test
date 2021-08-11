/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.general.dblookups;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.general.IGeneral;
import com.exigen.ren.admin.modules.general.dblookups.action.DBLookupCreateAction;
import com.exigen.ren.admin.modules.general.dblookups.pages.DBLookupsPage;
import com.exigen.ren.admin.modules.general.dblookups.tabs.DBLookupsTab;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;

import static com.exigen.ren.admin.modules.general.dblookups.pages.DBLookupsPage.DBLookupsSearchTab.LOOKUPLIST_NAME;
import static com.exigen.ren.admin.modules.general.dblookups.pages.DBLookupsPage.assetListSearchForm;
import static com.exigen.ren.main.enums.AdminConstants.AdminDBLookupsSearchResultsTable.NAME;

public class DBLookups implements IGeneral {
    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/platform/admin/general/dblookups");

    @Override
    public Workspace getDefaultWorkspace() {
        return AutomationContext.getAction(DBLookupCreateAction.class).getWorkspace();
    }

    @Override
    public void initiate() {
        throw new UnsupportedOperationException("Method is not realesed");
    }

    public void initiate(TestData td) {
        navigate();
        DBLookupsPage.search(td);
    }

    public void initiate(String lookupListName) {
        navigate();
        DBLookupsPage.search(lookupListName);
    }

    public void navigate() {
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.GENERAL);
        NavigationPage.toLeftMenuTab(NavigationEnum.GeneralTabLeftMenu.DB_LOOKUPS);
    }

    @Override
    public void create(TestData td) {
        initiate(td);
        DBLookupsPage.tableSearchResults.getRowContains(NAME, td.getValue(assetListSearchForm.getName(), LOOKUPLIST_NAME.getLabel()))
                .getCell(NAME).controls.links.getFirst().click();
        DBLookupsPage.buttonAddNewLookup.click();
        getDefaultWorkspace().fill(td);
        DBLookupsTab.buttonSave.click();
    }

    public void update(TestData td) {
        getDefaultWorkspace().fill(td);
        DBLookupsTab.buttonUpdate.click();
    }

    public void search(TestData td) {
        DBLookupsPage.search(td);
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }
}
