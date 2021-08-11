package com.exigen.ren.main.modules.claim.common.metadata;

import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class BalanceActionMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> AMOUNT = declare("Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> COMMENTS = declare("Comments", TextBox.class);
}