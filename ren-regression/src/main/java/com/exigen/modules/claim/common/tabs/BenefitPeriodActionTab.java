package com.exigen.modules.claim.common.tabs;

import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.claim.common.metadata.BenefitPeriodActionTabMetaData;

public class BenefitPeriodActionTab extends ActionTab {
    public BenefitPeriodActionTab() {
        super(BenefitPeriodActionTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        buttonSaveAndExit.click();
        return this;
    }
}