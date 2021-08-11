package com.exigen.ren.main.modules.policy.common.tabs.master;

import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.policy.common.metadata.master.StartRateGuaranteeRenewTabMetaData;

public class StartRateGuaranteeRenewTab extends ActionTab {

    public StartRateGuaranteeRenewTab() {
        super(StartRateGuaranteeRenewTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        buttonOk.click();
        return this;
    }
}
