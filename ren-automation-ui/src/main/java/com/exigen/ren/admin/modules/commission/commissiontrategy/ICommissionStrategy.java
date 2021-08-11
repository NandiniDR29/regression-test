/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.commission.commissiontrategy;

import com.exigen.istf.data.TestData;
import com.exigen.ren.admin.modules.commission.ICommission;
import com.exigen.ren.admin.modules.commission.commissiontrategy.pages.CommissionPage;

public interface ICommissionStrategy extends ICommission {

    @Override
    default void create(TestData td) {
        navigate();
        initiate();
        getDefaultWorkspace().fill(td);
        submit();
    }

    @Override
    default boolean searched(TestData td) {
        search(td);
        return CommissionPage.tableCommissionStrategies.isPresent();
    }

    default boolean searched(TestData td, String product) {
        search(td);
        return CommissionPage.tableCommissionStrategies.getRow(CommissionPage.CommissionStrategies.COMMISSION_STRATEGY_FOR_PRODUCT.getName(), product).isPresent();
    }


}
