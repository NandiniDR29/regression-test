/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class EmploymentTabMetaData extends MetaData{
    public static final AssetDescriptor<TextBox> EMPLOYER_NAME = declare("Employer Name", TextBox.class);
    public static final AssetDescriptor<ComboBox> OCCUPATION = declare("Occupation", ComboBox.class);
    public static final AssetDescriptor<TextBox> OCCUPATION_DESCRIPTION = declare("Occupation-Description", TextBox.class);
    public static final AssetDescriptor<ComboBox> OCCUPATION_STATUS = declare("Occupation Status", ComboBox.class);
    public static final AssetDescriptor<ComboBox> JOB_TITLE = declare("Job Title", ComboBox.class);
    public static final AssetDescriptor<TextBox> AS_OF_DATE = declare("As of Date", TextBox.class);
    public static final AssetDescriptor<TextBox> JOB_TITLE_DESCRIPTION = declare("Job Title-Description", TextBox.class);
}
