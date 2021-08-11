/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.common.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class SubrogationTabMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> COUNTRY = declare("Country", ComboBox.class);
    public static final AssetDescriptor<ComboBox> STATE_PROVINCE = declare("State / Province", ComboBox.class);
    public static final AssetDescriptor<TextBox> INDEMNITY_PAYMENTS = declare("Indemnity payments", TextBox.class);
    public static final AssetDescriptor<TextBox> BODILY_INJURY_STATUTE = declare("Bodily Injury Statute", TextBox.class);
    public static final AssetDescriptor<TextBox> PROPERTY_DAMAGE_STATUTE = declare("Property Damage Statute", TextBox.class);
    public static final AssetDescriptor<TextBox> SUBROGATION_TOTAL_INCLUDING_INCURREDS_DEDUCTIBLES_AND_EXPENSES =
            declare("Subrogation total including incurreds, deductibles and expenses", TextBox.class);
    public static final AssetDescriptor<TextBox> INSURED_EXPENSES_DESCRIPTION = declare("Insured expenses description", TextBox.class);
    public static final AssetDescriptor<ComboBox> SUBROGATION_STATUS = declare("Subrogation Status", ComboBox.class);
}
