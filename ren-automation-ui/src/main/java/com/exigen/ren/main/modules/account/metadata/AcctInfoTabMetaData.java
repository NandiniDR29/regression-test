/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.account.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class AcctInfoTabMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> ACCOUNT_NAME = declare("Account Name", TextBox.class);
    public static final AssetDescriptor<ComboBox> SPECIAL_HANDLING = declare("Special Handling", ComboBox.class);
    public static final AssetDescriptor<RadioGroup> CONFIDENTIAL_ACCOUNT = declare("Confidential Account", RadioGroup.class);
}
