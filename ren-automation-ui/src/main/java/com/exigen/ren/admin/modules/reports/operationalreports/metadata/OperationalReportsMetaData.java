/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.reports.operationalreports.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
import com.exigen.istf.webdriver.controls.CheckBox;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import org.openqa.selenium.By;

public class OperationalReportsMetaData extends MetaData {
    public static final AssetDescriptor<RadioGroup> CATEGORY = declare("Category", RadioGroup.class);
    public static final AssetDescriptor<ComboBox> TYPE = declare("Type", ComboBox.class);
    public static final AssetDescriptor<ComboBox> NAME = declare("Name", ComboBox.class);
    public static final AssetDescriptor<ComboBox> LANGUAGE = declare("Name", ComboBox.class);
    public static final AssetDescriptor<TextBox> ACTIVITY_DATE_FROM = declare("Activity Date From", TextBox.class);
    public static final AssetDescriptor<TextBox> ACTIVITY_DATE_TO = declare("Activity Date To", TextBox.class);
    public static final AssetDescriptor<AdvancedSelector> CHANNEL = declare("Channel", AdvancedSelector.class);
    public static final AssetDescriptor<AdvancedSelector> LOCATION_TYPE = declare("Location Type", AdvancedSelector.class);
    public static final AssetDescriptor<AdvancedSelector> LOCATION = declare("Location", AdvancedSelector.class);
    public static final AssetDescriptor<TextBox> POLICY_NUMBER = declare("Policy", TextBox.class);
    public static final AssetDescriptor<RadioGroup> DELIVERY_TYPE = declare("Delivery type", RadioGroup.class);
    public static final AssetDescriptor<CheckBox> MULTIPLE_OUTPUT_FORMATS = declare("Multiple Output Formats",
            CheckBox.class);
    public static final AssetDescriptor<RadioGroup> REPORT_FORMAT = declare("Report Format", RadioGroup.class);
    public static final AssetDescriptor<AdvancedSelector> EMAIL_ADDRESS = declare("E-mail address", AdvancedSelector.class, By.id("jobsForm:select_email"));
    public static final AssetDescriptor<TextBox> ADDITIONAL_EMAIL = declare("Additional E-mail address", TextBox.class);
    public static final AssetDescriptor<CheckBox> SCHEDULE = declare("Do you want to schedule?", CheckBox.class, By.id("jobsForm:showSchedulingPanel"));
    public static final AssetDescriptor<TextBox> REPORT_NAME = declare("Report Name", TextBox.class);
    public static final AssetDescriptor<ComboBox> SCHEDULE_TYPE = declare("Schedule Type", ComboBox.class);
    public static final AssetDescriptor<TextBox> SCHEDULE_INTERVAL = declare("Schedule Interval", TextBox.class, By.id("jobsForm:interval"));
    public static final AssetDescriptor<ComboBox> SCHEDULE_INTERVAL_TYPE = declare("Schedule Interval Type", ComboBox.class, By.id("jobsForm:repeatingType2"));
}
