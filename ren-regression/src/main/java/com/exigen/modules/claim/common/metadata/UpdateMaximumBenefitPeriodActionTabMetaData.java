package com.exigen.modules.claim.common.metadata;

import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class UpdateMaximumBenefitPeriodActionTabMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> MAXIMUM_BENEFIT_PERIOD_THROUGH_DATE = declare("Maximum Benefit Period Through Date", TextBox.class);
    public static final AssetDescriptor<TextBox> OVERRIDE_REASON = declare("Override Reason", TextBox.class);
}
