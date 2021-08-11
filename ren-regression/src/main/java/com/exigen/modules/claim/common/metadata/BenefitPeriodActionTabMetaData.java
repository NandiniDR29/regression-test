package com.exigen.modules.claim.common.metadata;

import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class BenefitPeriodActionTabMetaData extends MetaData {

    public static final AssetDescriptor<TextBox> BENEFIT_PERIOD_START_DATE = declare("Benefit Period Start Date", TextBox.class);
    public static final AssetDescriptor<TextBox> BENEFIT_PERIOD_END_DATE = declare("Benefit Period End Date", TextBox.class);
    public static final AssetDescriptor<TextBox> OVERRIDE_REASON = declare("Override Reason", TextBox.class);
}
