/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.commission.commissiontemplate.actions;

import com.exigen.istf.data.TestData;
import com.exigen.ren.admin.modules.commission.commissiontemplate.pages.CommissionTemplatePage;
import com.exigen.ren.common.AbstractAction;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.enums.ActionConstants;
import com.exigen.ren.main.enums.CommissionConstants;

public class CommissionTemplateEditAction implements Action {
    @Override
    public String getName() {
        return "Commission Template Edit Action";
    }

    @Override
    public Workspace getWorkspace() {
        return AutomationContext.getAction(CommissionTemplateCreateAction.class).getWorkspace();
    }

    public Action start(int rowNumber) {
        CommissionTemplatePage.tableCommissionTemplate.getRow(rowNumber).getCell(CommissionConstants.CommissionTemplateTable.ACTIONS).controls.links.get(ActionConstants.EDIT).click();
        return this;
    }

    public Action perform(TestData td, int rowNumber) {
        start(rowNumber);
        getWorkspace().fill(td);
        return submit();
    }

    @Override
    public Action submit() {
        CommissionTemplatePage.buttonOK.click();
        return this;
    }

    @Override
    public AbstractAction perform(TestData td) {
        throw new UnsupportedOperationException("perform(TestData td) method without rowNumber is not supported. Use perform(int rowNumber, TestData td)");
    }
}
