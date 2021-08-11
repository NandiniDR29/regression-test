/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.billing.account.metadata;

import com.exigen.istf.webdriver.controls.CheckBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import org.openqa.selenium.By;

public class AddHoldActionTabMetaData extends MetaData {
    public static final AssetDescriptor<CheckBox> INVOICE = declare("Invoice", CheckBox.class, By.id("holdForm:holdType:0"));
    public static final AssetDescriptor<CheckBox> CANCELLATION = declare("Cancellation", CheckBox.class, By.id("holdForm:holdType:1"));
    public static final AssetDescriptor<CheckBox> CANCEL_NOTICE = declare("Cancel Notice", CheckBox.class, By.id("holdForm:holdType:1"));
    public static final AssetDescriptor<TextBox> HOLD_EFFECTIVE_DATE = declare("Hold Effective Date", TextBox.class);
    public static final AssetDescriptor<TextBox> HOLD_EXPIRATION_DATE = declare("Hold Expiration Date", TextBox.class);
}
