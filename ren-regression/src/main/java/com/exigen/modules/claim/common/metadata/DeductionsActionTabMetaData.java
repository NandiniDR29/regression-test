/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.common.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class DeductionsActionTabMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> TYPE_OF_DEDUCTION = declare("Type of Deduction", ComboBox.class);
    public static final AssetDescriptor<ComboBox> PARTY = declare("Party", ComboBox.class);
    public static final AssetDescriptor<ComboBox> NON_PROVIDER_PAYMENT_TYPE = declare("Non Provider Payment Type", ComboBox.class);
    public static final AssetDescriptor<ComboBox> STATE_SERVICES_PROVIDED_IN = declare("State Services Provided In", ComboBox.class);
    public static final AssetDescriptor<TextBox> BEGINNING_DATE = declare("Beginning Date", TextBox.class);
    public static final AssetDescriptor<TextBox> DEDUCTION_AMOUNT = declare("Deduction Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> MEMO = declare("Memo", TextBox.class);
    public static final AssetDescriptor<TextBox> CODE = declare("Code", TextBox.class);
    public static final AssetDescriptor<TextBox> PRIORITY = declare("Priority", TextBox.class);
    public static final AssetDescriptor<TextBox> THROUGH_DATE = declare("Through Date", TextBox.class);
    public static final AssetDescriptor<TextBox> REQUIRED_MONTHLY_401K_CONTRIBUTION_AMOUNT = declare("Required Monthly 401K Contribution Amount", TextBox.class);
    public static final AssetDescriptor<RadioGroup> APPLY_PRE_TAX = declare("Apply Pre-tax", RadioGroup.class);
}
