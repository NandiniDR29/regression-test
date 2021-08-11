package com.exigen.ren.main.modules.caseprofile.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class LocationManagementTabMetaData extends MetaData {

    public static final AssetDescriptor<AssetList> LOCATION_DETAILS = declare("Add Billing Location",
            AssetList.class, BillingLocationDetails.class);

    public static final class BillingLocationDetails extends MetaData {
        public static final AssetDescriptor<TextBox> LOCATION_NAME = declare("Location Name", TextBox.class);
        public static final AssetDescriptor<TextBox> LOCATION_NUMBER = declare("Location Number", TextBox.class);
        public static final AssetDescriptor<RadioGroup> PRIMARY_LOCATION = declare("Primary Location", RadioGroup.class);
        public static final AssetDescriptor<TextBox> TAX_IDENTIFICATION = declare("Tax Identification", TextBox.class);
        public static final AssetDescriptor<ComboBox> COUNTRY = declare("Country", ComboBox.class);
        public static final AssetDescriptor<TextBox> ZIP_POST_CODE = declare("ZIP / Post Code", TextBox.class);
        public static final AssetDescriptor<TextBox> CITY = declare("City", TextBox.class);
        public static final AssetDescriptor<ComboBox> STATE_PROVINCE = declare("State/Province", ComboBox.class);
        public static final AssetDescriptor<TextBox> ADDRESS_LINE_1 = declare("Address Line 1", TextBox.class);
        public static final AssetDescriptor<TextBox> ADDRESS_LINE_2 = declare("Address Line 2", TextBox.class);
        public static final AssetDescriptor<TextBox> ADDRESS_LINE_3 = declare("Address Line 3", TextBox.class);
    }

}
