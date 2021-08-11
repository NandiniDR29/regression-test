/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.gb_ltd_st_std.metadata;

import com.exigen.istf.webdriver.controls.CheckBox;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class BenefitsStatutorySTDIncidentTabMetaData extends MetaData {
    public static final AssetDescriptor<RadioGroup> ACCIDENT = declare("Accident?", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> HOSPITAL = declare("Hospital", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> SURGERY = declare("Surgery", RadioGroup.class);
    public static final AssetDescriptor<TextBox> DATE_OF_HIRE = declare("Date of Hire", TextBox.class);
    public static final AssetDescriptor<TextBox> WEEK_NO = declare("Week no.", TextBox.class);
    public static final AssetDescriptor<TextBox> GROSS_AMOUNT_PAID = declare("Gross amount paid", TextBox.class);

    public static final AssetDescriptor<AssetList> DISABILITY_DATE =
            declare("Disability Date", AssetList.class, BenefitsLTDIncidentTabMetaData.DisabilityDateMetaData.class);

    public static final class DisabilityDateMetaData extends MetaData {
        public static final AssetDescriptor<TextBox> ID = declare("ID", TextBox.class);
        public static final AssetDescriptor<ComboBox> TYPE = declare("Type", ComboBox.class);
        public static final AssetDescriptor<TextBox> DATE = declare("Date", TextBox.class);
        public static final AssetDescriptor<CheckBox> SUCCESSIVE_DISABILITY = declare("Successive Disability", CheckBox.class);
    }
}