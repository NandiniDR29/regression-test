/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.metadata;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import org.openqa.selenium.By;

public class SearchOwnerMetaData extends MetaData {

    public static final AssetDescriptor<RadioGroup> SEARCH_FOR = declare("Search For", RadioGroup.class,
            By.id("ownerSearchForm:internalIndRadio"));
    public static final AssetDescriptor<ComboBox> WORK_QUEUE = declare("Work Queue", ComboBox.class);
    public static final AssetDescriptor<ComboBox> ROLE = declare("Role", ComboBox.class);
    public static final AssetDescriptor<TextBox> FIRST_NAME = declare("First Name", TextBox.class);
    public static final AssetDescriptor<TextBox> LAST_NAME = declare("Last Name", TextBox.class);
    public static final AssetDescriptor<ComboBox> CATEGORY = declare("Category", ComboBox.class);
    public static final AssetDescriptor<ComboBox> CHANNEL = declare("Channel", ComboBox.class);
    public static final AssetDescriptor<Button> SEARCH = declare("Search", Button.class, By.id("ownerSearchForm:search"));
    public static final AssetDescriptor<Button> OK = declare("OK", Button.class, By.id("ownerSearchForm:queueOk"));

}
