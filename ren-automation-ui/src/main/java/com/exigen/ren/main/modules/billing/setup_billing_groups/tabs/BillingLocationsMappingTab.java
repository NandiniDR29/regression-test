package com.exigen.ren.main.modules.billing.setup_billing_groups.tabs;

import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.billing.setup_billing_groups.metadata.BillingLocationsMappingTabMetaData;

public class BillingLocationsMappingTab extends ActionTab {

    public BillingLocationsMappingTab() {
        super(BillingLocationsMappingTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        buttonTopSave.click();
        Tab.buttonNext.click();
        return this;
    }
}
