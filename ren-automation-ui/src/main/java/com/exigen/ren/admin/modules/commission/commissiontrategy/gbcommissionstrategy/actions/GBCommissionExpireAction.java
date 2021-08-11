/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy.actions;

import com.exigen.istf.data.TestData;
import com.exigen.ren.admin.modules.commission.commissiontrategy.pages.CommissionPage;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.CommissionConstants;

public class GBCommissionExpireAction implements Action {
    @Override
    public String getName() {
        return "Expire Commission Strategy";
    }

    @Override
    public Workspace getWorkspace() {
        throw new UnsupportedOperationException("perform(TestData td) method with testData is not supported for this action. Use perform() instead.");
    }

    @Override
    public Action start() {
        CommissionPage.tableCommissionStrategies.getRow(CommissionConstants.CommissionStrategyTable.STATUS, "Active").getCell(1).controls.checkBoxes.getFirst().setValue(true);
        CommissionPage.buttonExpireCommissionStrategy.click();
        return this;
    }

    public Action start(String product) {
        CommissionPage.tableCommissionStrategies.getRow(CommissionConstants.CommissionStrategyTable.COMMISSION_STRATEGY_FOR_PRODUCT, product).getCell(1).controls.checkBoxes.getFirst().setValue(true);
        CommissionPage.buttonExpireCommissionStrategy.click();
        return this;
    }

    @Override
    public Action perform(TestData testData) {
        throw new UnsupportedOperationException("perform(TestData td) method with testData is not supported for this action. Use perform() instead.");
    }

    @Override
    public Action perform() {
        start();
        return submit();
    }

    public Action perform(String effectiveDate) {
        start();
        CommissionPage.textBoxExpirationDate.setValue(effectiveDate);
        return submit();
    }

    public Action perform(String product, String effectiveDate) {
        start(product);
        CommissionPage.textBoxExpirationDate.setValue(effectiveDate);
        return submit();
    }

    @Override
    public Action submit() {
        Page.dialogConfirmation.confirm();
        return this;
    }
}
