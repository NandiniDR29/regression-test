package com.exigen.ren.main.modules.claim.common.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class ApprovalPeriodsActionTabMetaData extends MetaData {

    public static final AssetDescriptor<ComboBox> APPROVAL_FREQUENCY = declare("Approval Frequency", ComboBox.class);
    public static final AssetDescriptor<TextBox> APPROVAL_PERIOD_START_DATE = declare("Approval Period Start Date", TextBox.class);
    public static final AssetDescriptor<TextBox> APPROVAL_PERIOD_END_DATE = declare("Approval Period End Date", TextBox.class);
    public static final AssetDescriptor<ComboBox> APPROVAL_STATUS = declare("Approval Status", ComboBox.class);
}