package com.exigen.modules.claim.common.metadata;

import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class ApprovalPeriodsCancelActionTabMetaData extends MetaData {

    public static final AssetDescriptor<TextBox> CANCEL_REASON = declare("Cancel Reason", TextBox.class);
}