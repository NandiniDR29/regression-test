package com.exigen.ren.main.modules.claim.common.tabs;

import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.claim.common.metadata.PaymentSeriesAdditionalPayeeTabMetaData;

public class PaymentSeriesAdditionalPayeeTab extends ActionTab {
    public PaymentSeriesAdditionalPayeeTab() {
        super(PaymentSeriesAdditionalPayeeTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        buttonNext.click();
        return this;
    }
}
