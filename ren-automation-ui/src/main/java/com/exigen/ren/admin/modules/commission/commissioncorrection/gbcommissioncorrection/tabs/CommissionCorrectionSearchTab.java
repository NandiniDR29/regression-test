package com.exigen.ren.admin.modules.commission.commissioncorrection.gbcommissioncorrection.tabs;

import com.exigen.ren.admin.modules.commission.commissioncorrection.gbcommissioncorrection.metadata.ComCorrectionMetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;

public class CommissionCorrectionSearchTab extends DefaultTab {
    public CommissionCorrectionSearchTab() {
        super(ComCorrectionMetaData.class);
    }

    @Override
    public Tab submitTab() {
        return this;
    }
}
