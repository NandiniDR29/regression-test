/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy.actions;

import com.exigen.istf.data.TestData;
import com.exigen.ren.admin.modules.commission.commissiontrategy.pages.CommissionPage;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.enums.ActionConstants;
import com.exigen.ren.main.enums.CommissionConstants;

public class GBCommissionStrategyEditAction implements Action {
    @Override
    public String getName() {
        return "Edit Commission Action";
    }

    @Override
    public Workspace getWorkspace() {
        return AutomationContext.getAction(GBCommissionStrategyCreateAction.class).getWorkspace();
    }

    public Action start(String product) {
        CommissionPage.tableCommissionStrategies
                .getRow(CommissionPage.CommissionStrategies.COMMISSION_STRATEGY_FOR_PRODUCT.getName(), product)
                .getCell(CommissionConstants.CommissionStrategyTable.ACTION).controls.links.get(ActionConstants.EDIT).click();
        return this;
    }


    public Action perform(TestData td, String product) {
        start(product);
        getWorkspace().fill(td);
        return submit();
    }

    @Override
    public Action submit() {
        Tab.buttonSave.click();
        return this;
    }

}
