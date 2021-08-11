package com.exigen.ren.admin.modules.commission.commissioncorrection;

import com.exigen.istf.data.TestData;
import com.exigen.ren.admin.modules.commission.ICommission;
import com.exigen.ren.admin.modules.commission.commissioncorrection.pages.CommissionCorrectionPage;

public interface ICommissionCorrection extends ICommission {

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
        return CommissionCorrectionPage.tableCommissionCorrection.isPresent();
    }
}
