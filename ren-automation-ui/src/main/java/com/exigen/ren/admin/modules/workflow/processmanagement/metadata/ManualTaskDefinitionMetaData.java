/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.workflow.processmanagement.metadata;

import com.exigen.ipb.eisa.controls.ClickComboBox;
import com.exigen.istf.webdriver.controls.CheckBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;

public class ManualTaskDefinitionMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> DEFINITION_KEY = declare("Definition Key", TextBox.class, Waiters.DEFAULT);
    public static final AssetDescriptor<ClickComboBox> ENTITY_TYPE = declare("Entity Type", ClickComboBox.class, Waiters.DEFAULT);
    public static final AssetDescriptor<TextBox> TASK_NAME = declare("Task Name", TextBox.class);
    public static final AssetDescriptor<TextBox> EFFECTIVE_DATE = declare("Effective Date", TextBox.class);
    public static final AssetDescriptor<TextBox> EXPIRATION_DATE = declare("Expiration Date", TextBox.class);
    public static final AssetDescriptor<CheckBox> GENERATE_PRIVILEGE = declare("Generate Privilege", CheckBox.class);
    public static final AssetDescriptor<TextBox> WARNING_DATE_DELAY = declare("Warning Date Delay", TextBox.class);
    public static final AssetDescriptor<TextBox> DUE_DATE_DELAY = declare("Due Date Delay", TextBox.class);
    public static final AssetDescriptor<TextBox> DESCRIPTION = declare("Description", TextBox.class,
            By.id("manualTaskDefinitionForm:taskDescription_input"));
    public static final AssetDescriptor<ClickComboBox> PREFERRED_QUEUE = declare("Preferred Queue", ClickComboBox.class);
    public static final AssetDescriptor<ClickComboBox> PRIORITY = declare("Priority", ClickComboBox.class);
    public static final AssetDescriptor<RadioGroup> ALLOW_TASK_PROCESS_SUSPENSE = declare("Allow Task Process Suspense",
            RadioGroup.class);
}
