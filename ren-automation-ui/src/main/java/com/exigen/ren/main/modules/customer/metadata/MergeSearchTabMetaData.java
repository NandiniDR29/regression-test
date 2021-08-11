/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.metadata;

import com.exigen.ipb.eisa.controls.dialog.DialogSingleSelector;
import com.exigen.ipb.eisa.controls.productfactory.DatePicker;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class MergeSearchTabMetaData extends MetaData {
    public static final AssetDescriptor<DialogSingleSelector> MERGE_SEARCH_DIALOG = declare("Search Customer", DialogSingleSelector.class, SearchMergeCustomerMetaData.class);

    public static final class SearchMergeCustomerMetaData extends MetaData {
        public static final AssetDescriptor<TextBox> FIRST_NAME = declare("First Name", TextBox.class);
        public static final AssetDescriptor<TextBox> LAST_NAME = declare("Last Name", TextBox.class);
        public static final AssetDescriptor<TextBox> CUSTOMER_NUMBER = declare("Customer Number", TextBox.class);
        public static final AssetDescriptor<DatePicker> DATE_OF_BIRTH = declare("Date of Birth", DatePicker.class);
        public static final AssetDescriptor<ComboBox> STATUS = declare("Status", ComboBox.class);
        public static final AssetDescriptor<TextBox> PHONE_NUMBER = declare("Phone Number", TextBox.class);
        public static final AssetDescriptor<TextBox> ADDRESS_LINE = declare("Address Line", TextBox.class);
        public static final AssetDescriptor<TextBox> CITY = declare("City", TextBox.class);
        public static final AssetDescriptor<TextBox> STATE_PROVINCE = declare("State/Province", TextBox.class);
        public static final AssetDescriptor<TextBox> ZIP_POST_CODE = declare("ZIP/Post Code", TextBox.class);
        public static final AssetDescriptor<TextBox> COUNTRY = declare("Country", TextBox.class);
    }
}
