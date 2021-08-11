package com.exigen.ren.main.modules.claim.common.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class ClaimSubStatusTabMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> CLAIM_SUB_STATUS = declare("Claim Sub Status", ComboBox.class);
}
