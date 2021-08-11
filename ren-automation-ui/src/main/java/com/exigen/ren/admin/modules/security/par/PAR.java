/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.security.par;

import com.exigen.istf.data.TestData;
import com.exigen.ren.EntityLogger;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.security.ISecurity;
import com.exigen.ren.admin.modules.security.par.actions.PARCreateAction;
import com.exigen.ren.admin.modules.security.par.actions.PARSearchAction;
import com.exigen.ren.admin.modules.security.par.actions.PARUpdateAction;
import com.exigen.ren.admin.modules.security.par.tabs.PARGeneralTab;
import com.exigen.ren.admin.modules.security.par.tabs.PARSearchTab;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.enums.NavigationEnum.AdminAppMainTabs;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.AdminConstants;

import java.util.ArrayList;
import java.util.List;

public class PAR implements ISecurity {

    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/platform/admin/security/productaccesrole");

    @Override
    public Workspace getDefaultWorkspace() {
        return AutomationContext.getAction(PARCreateAction.class).getWorkspace();
    }

    @Override
    public void initiate() {
        navigate();
        PARGeneralTab.buttonAddPAR.click();
    }


    public void search(TestData td) {
        search().perform(td);
    }

    public PARSearchAction search() {
        return AutomationContext.getAction(PARSearchAction.class);
    }

    @Override
    public void navigate() {
        NavigationPage.toMainTab(AdminAppMainTabs.SECURITY);
        NavigationPage.toLeftMenuTab(NavigationEnum.SecurityLeftMenu.PRODUCT_ACCESS_ROLE);
    }

    @Override
    public void create(TestData td) {
        initiate();
        getDefaultWorkspace().fill(td);
        String entity = EntityLogger.getEntityHeader(EntityLogger.EntityType.PAR);
        PARGeneralTab.buttonSave.click();
        LOGGER.info("Created PAR " + entity);
    }

    public PARUpdateAction update() {
        return AutomationContext.getAction(PARUpdateAction.class);
    }

    public void update(TestData td, int rowNumber) {
        update().start(rowNumber);
        update().getWorkspace().fill(td);
        update().submit();
    }

    public void update(String roleCode, TestData td) {
        update().perform(roleCode, td);
    }

    public void update(int rowNumber, TestData td) {
        update().perform(rowNumber, td);
    }

    public List<String> searchForRoles() {
        navigate();
        List<String> roles = new ArrayList<>();
        PARGeneralTab.buttonSearch.click();
        if (PARSearchTab.tableSearchResults.isPresent()) {
            PARSearchTab.tableSearchResults.getRows().forEach(row -> {
                String par = String.format("%s (%s)", row.getCell(AdminConstants.AdminSearchResultsTable.NAME).getValue(), row.getCell(AdminConstants.AdminSearchResultsTable.CODE).getValue());
                roles.add(par);
            });
        }
        return roles;
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }

    public void delete(String roleCode) {
        PARSearchTab.tableRoles.getRow(AdminConstants.AdminPARTable.CODE, roleCode).
                getCell(AdminConstants.AdminPARTable.ACTION).controls.links.get(AdminConstants.AdminPARTable.DELETE).click();
        Page.dialogConfirmation.confirm();
    }

}
