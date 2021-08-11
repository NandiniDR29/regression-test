/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.account.metadata;

import com.exigen.ipb.eisa.controls.dialog.DialogSingleSelector;
import com.exigen.ipb.eisa.controls.dialog.type.AbstractDialog;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;

public class DesignatedContactsTabMetaData extends MetaData {
    public static final AssetDescriptor<Button> ADD_DESIGNATED_CONTACT = declare("Add Designated Contact", Button.class,
            By.id("crmForm:addContactBtn"));
    public static final AssetDescriptor<DialogSingleSelector> SELECT_CONTACT = declare("Select Contact", DialogSingleSelector.class,
            SelectContactMetaData.class);
    public static final AssetDescriptor<TextBox> CONTACT_PHONE = declare("Contact Phone", TextBox.class);

    public static class SelectContactMetaData extends MetaData {
        public static final AssetDescriptor<TextBox> FIRST_NAME = declare("First Name", TextBox.class);
        public static final AssetDescriptor<TextBox> LAST_NAME = declare("Last Name", TextBox.class);
        public static final AssetDescriptor<ComboBox> CATEGORY = declare("Category", ComboBox.class);
        public static final AssetDescriptor<ComboBox> CHANNEL = declare("Channel", ComboBox.class);

        public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class,
                Waiters.DEFAULT, false, By.xpath("//input[contains(@id, 'selectContact')]"));
        public static final AssetDescriptor<Button> BUTTON_SEARCH = declare("Search", Button.class, Waiters.DEFAULT,
                false, By.id("contactSearchPopupForm:search"));
    }
}
