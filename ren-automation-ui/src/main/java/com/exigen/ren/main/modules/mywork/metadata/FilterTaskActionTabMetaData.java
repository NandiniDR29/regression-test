/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.ren.main.modules.mywork.metadata;

import com.exigen.ipb.eisa.controls.ClickComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import org.openqa.selenium.By;

public class FilterTaskActionTabMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> REFERENCE_ID = declare("Reference ID:", TextBox.class, By.id("filterContainerForm:refNoFilter"));
    public static final AssetDescriptor<ClickComboBox> PRIORITY = declare("Priority:", ClickComboBox.class);
    public static final AssetDescriptor<TextBox> TASK_ID = declare("Task ID:", TextBox.class, By.id("filterContainerForm:taskId"));
    public static final AssetDescriptor<ClickComboBox> TYPE = declare("Type:", ClickComboBox.class);
    public static final AssetDescriptor<ClickComboBox> STATUS = declare("Status:", ClickComboBox.class);
    public static final AssetDescriptor<TextBox> TASK_CREATION_DATE_RANGE_FROM = declare("Task Creation Date Range From:", TextBox.class);
    public static final AssetDescriptor<TextBox> TASK_NAME = declare("Task Name:", TextBox.class, By.id("filterContainerForm:taskName"));
}
