/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.caseprofile.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
import com.exigen.istf.webdriver.controls.CheckBox;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class CaseProfileDetailsTabMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> CASE_PROFILE_NAME = declare("Case Profile Name", TextBox.class);
    public static final AssetDescriptor<TextBox> EFFECTIVE_DATE = declare("Effective Date", TextBox.class);
    public static final AssetDescriptor<TextBox> EXPIRATION_DATE = declare("Expiration Date", TextBox.class);
    public static final AssetDescriptor<ComboBox> GROUP_DOMICILE_STATE = declare("Group Domicile State", ComboBox.class);
    public static final AssetDescriptor<AdvancedSelector> APPLICABLE_PAYMENT_MODES = declare("Applicable Payment Modes", AdvancedSelector.class);
    public static final AssetDescriptor<AdvancedSelector> AGENCY_PRODUCER = declare("Agency / Producer", AdvancedSelector.class);
    public static final AssetDescriptor<CheckBox> INTAKE_PROFILE_REQUIRED = declare("Intake Profile Required?", CheckBox.class);
}
