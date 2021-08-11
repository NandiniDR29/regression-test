/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.security.par.actions;

import com.exigen.istf.data.TestData;
import com.exigen.ren.admin.modules.security.par.tabs.PARGeneralTab;
import com.exigen.ren.admin.modules.security.par.tabs.PARSearchTab;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.enums.ActionConstants;
import com.exigen.ren.main.enums.AdminConstants;

public class PARUpdateAction implements Action {

    @Override
    public String getName() {
        return "Update PAR Action";
    }

    @Override
    public Workspace getWorkspace() {
        return AutomationContext.getAction(PARCreateAction.class).getWorkspace();
    }


    public Action start(int i) {
        PARSearchTab.tableSearchResults.getRow(i).getCell(AdminConstants.AdminSearchResultsTable.ACTION).controls.links.get(ActionConstants.CHANGE).click();
        return this;
    }

    public Action start(String roleCode) {
        PARSearchTab.tableRoles.getRow(AdminConstants.AdminPARTable.CODE, roleCode).
                getCell(AdminConstants.AdminPARTable.ACTION).controls.links.get(AdminConstants.AdminPARTable.CHANGE).click();
        return this;
    }

    @Override
    public Action submit() {
        PARGeneralTab.buttonUpdate.click();
        return this;
    }

    public Action perform(String roleCode, TestData td) {
        start(roleCode);
        getWorkspace().fill(td);
        return submit();
    }

    public Action perform(int rowNumber, TestData td) {
        start(rowNumber);
        getWorkspace().fill(td);
        return submit();
    }
}
