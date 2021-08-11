/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.commission.commissionbonus.actions;

import com.exigen.istf.data.TestData;
import com.exigen.ren.admin.modules.commission.commissiontrategy.pages.CommissionPage;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ActionConstants;
import com.exigen.ren.main.enums.CommissionConstants;

public class CommissionBonusDeleteAction implements Action {

    @Override
    public String getName() {
        return "Delete Commission Bonus";
    }

    @Override
    public Workspace getWorkspace() {
        throw new UnsupportedOperationException("Not Supported");
    }

    public Action start(int rowNumber) {
        CommissionPage.tableCommissionBonus.getRow(rowNumber).getCell(CommissionConstants.CommissionBonusTable.ACTION).controls.links.get(ActionConstants.DELETE).click();
        return this;
    }

    public Action perform(int rowNumber) {
        start(rowNumber);
        return submit();
    }

    @Override
    public Action submit() {
        Page.dialogConfirmation.confirm();
        return this;
    }

    @Override
    public Action start() {
        throw new UnsupportedOperationException("start() method is not supported for this action. Use start(int rowNumber) instead");
    }

    @Override
    public Action perform(TestData td) {
        throw new UnsupportedOperationException("perform(TestData td) method without rowNumber is not supported. Use perform(int rowNumber) instead");
    }
}
