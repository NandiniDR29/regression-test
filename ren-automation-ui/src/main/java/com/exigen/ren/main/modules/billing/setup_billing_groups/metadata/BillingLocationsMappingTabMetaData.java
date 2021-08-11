package com.exigen.ren.main.modules.billing.setup_billing_groups.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class BillingLocationsMappingTabMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> CLASSIFICATION_GROUP = declare("Classification Group", ComboBox.class);
    public static final AssetDescriptor<AdvancedSelector> BILLING_LOCATION = declare("Billing Location", AdvancedSelector.class);
}
