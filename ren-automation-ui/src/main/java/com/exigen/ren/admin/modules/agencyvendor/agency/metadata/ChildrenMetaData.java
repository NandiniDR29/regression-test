/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.agency.metadata;

import com.exigen.ipb.eisa.controls.dialog.DialogSingleSelector;
import com.exigen.ipb.eisa.controls.dialog.type.AbstractDialog;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;

public class ChildrenMetaData extends MetaData {
    public static final AssetDescriptor<DialogSingleSelector> ADD_CHILD_AGENCY = declare("Add Child Agency", DialogSingleSelector.class, AddChildAgencyMetaData.class);

    public static final class AddChildAgencyMetaData extends MetaData {
        public static final AssetDescriptor<TextBox> AGENCY_NAME = declare("Agency Name", TextBox.class);
        public static final AssetDescriptor<TextBox> AGENCY_CODE = declare("Agency Code", TextBox.class);
        public static final AssetDescriptor<ComboBox> COUNTRY = declare("Country", ComboBox.class);
        public static final AssetDescriptor<TextBox> ZIP_POSTAL_CODE = declare("Zip / Postal Code", TextBox.class);
        public static final AssetDescriptor<TextBox> CITY = declare("City", TextBox.class);
        public static final AssetDescriptor<TextBox> STATE_PROVINCE = declare("State / Province", TextBox.class);

        public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class, Waiters.DEFAULT, false,
                By.id("brokerChildrenForm:addUnderwriter"));
        public static final AssetDescriptor<Button> BUTTON_SUBMIT_POPUP = declare(AbstractDialog.getDefaultPopupSubmitterName(), Button.class, Waiters.DEFAULT, false,
                By.id("childAgencySearch:addBtn"));
    }
}
