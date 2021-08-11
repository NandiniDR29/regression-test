package com.exigen.ren.main.modules.policy.gb_dn.masterpolicy.metadata;

import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class StartUpdateProcedureCodeTabMetaData extends MetaData {

    public static final AssetDescriptor<TextBox> EFFECTIVE_DATE = declare("Effective Date", TextBox.class);
}
