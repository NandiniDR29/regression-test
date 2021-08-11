/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.common.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class PolicyInformationInsurableRiskRiskItemActionTabMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> REPORTED_RISK_ITEM_NAME = declare("Reported Risk Item Name", TextBox.class);
    public static final AssetDescriptor<ComboBox> YEAR = declare("Year", ComboBox.class);
    public static final AssetDescriptor<ComboBox> MAKE = declare("Make", ComboBox.class);
    public static final AssetDescriptor<ComboBox> MODEL = declare("Model", ComboBox.class);
    public static final AssetDescriptor<TextBox> VIN = declare("VIN", TextBox.class);
    public static final AssetDescriptor<ComboBox> BODY_TYPE = declare("Body Type", ComboBox.class);
    public static final AssetDescriptor<TextBox> COLOR = declare("Color", TextBox.class);
    public static final AssetDescriptor<TextBox> LICENSE_PLATE_NUMBER = declare("License Plate Number", TextBox.class);
    public static final AssetDescriptor<ComboBox> LICENSE_PLATE_STATE = declare("License Plate State", ComboBox.class);
    public static final AssetDescriptor<ComboBox> LICENSE_PLATE_COUNTRY = declare("License Plate Country", ComboBox.class);
    public static final AssetDescriptor<ComboBox> COVERAGE = declare("Coverage", ComboBox.class);
    public static final AssetDescriptor<TextBox> DEDUCTIBLE_AMOUNT = declare("Deductible Amount", TextBox.class);
    public static final AssetDescriptor<ComboBox> LIMIT_LEVEL = declare("Limit Level", ComboBox.class);
    public static final AssetDescriptor<TextBox> LIMIT_AMOUNT = declare("Limit Amount", TextBox.class);
}
