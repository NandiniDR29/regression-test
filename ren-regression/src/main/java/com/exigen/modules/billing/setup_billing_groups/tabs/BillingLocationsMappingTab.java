package com.exigen.modules.billing.setup_billing_groups.tabs;

import com.exigen.modules.billing.setup_billing_groups.metadata.BillingLocationsMappingTabMetaData;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;

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
