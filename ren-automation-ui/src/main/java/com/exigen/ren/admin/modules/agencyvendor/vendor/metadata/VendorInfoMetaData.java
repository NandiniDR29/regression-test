/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.vendor.metadata;

import com.exigen.ipb.eisa.controls.dialog.DialogSingleSelector;
import com.exigen.ipb.eisa.controls.dialog.type.AbstractDialog;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;

public class VendorInfoMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> NAME = declare("Name", TextBox.class);
    public static final AssetDescriptor<TextBox> TAX_ID = declare("Tax ID", TextBox.class,
            By.id("vendorProfileForm:taxID"));
    public static final AssetDescriptor<ComboBox> COUNTRY = declare("Country", ComboBox.class,
            By.id("vendorProfileForm:countryCd"));
    public static final AssetDescriptor<ComboBox> VENDOR_RATING = declare("Vendor Rating", ComboBox.class);
    public static final AssetDescriptor<DialogSingleSelector> ADD_CHILD_VENOR = declare("Add Child Vendor", DialogSingleSelector.class, AddChildMetaData.class,
            By.id("vendorSearchPopup_container"));
    public static final AssetDescriptor<RadioGroup> FRAUD = declare("Fraud", RadioGroup.class);
    public static final AssetDescriptor<TextBox> FRAUD_TYPE = declare("Fraud Type", TextBox.class);
    public static final AssetDescriptor<TextBox> DETAILS = declare("Details", TextBox.class);
    public static final AssetDescriptor<DialogSingleSelector> ADD_SETTLEMENT_METHOD = declare("Add Settlement Method", DialogSingleSelector.class, AddFinancialInfo.class,
            By.id("settlementMethodPopup_container"));


    public static final class AddFinancialInfo extends MetaData {
        public static final AssetDescriptor<RadioGroup> BULK_PAYMENTS = declare("Bulk Payments", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> BULK_PAYMENT_FREQUENCY = declare("Bulk Payment Frequency", ComboBox.class);
        public static final AssetDescriptor<ComboBox> BULK_PAYMENT_PROCESSING_DAY = declare("Bulk Payment Processing Day", ComboBox.class);
        public static final AssetDescriptor<ComboBox> BULK_PAYMENT_PROCESSING_WEEK = declare("Bulk Payment Processing Week", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SECOND_BULK_PAYMENT_PROCESSING_DAY = declare("Second Bulk Payment Processing Day", ComboBox.class);
        public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class, Waiters.DEFAULT, false,
                By.id("vendorProfileForm:addPaymentMethod"));
        public static final AssetDescriptor<Button> BUTTON_SUBMIT_POPUP = declare(AbstractDialog.getDefaultPopupSubmitterName(), Button.class, Waiters.DEFAULT, false,
                By.id("vendorFinInfoFormPopup:saveBtn"));
    }

    public static final class AddChildMetaData extends MetaData {
        public static final AssetDescriptor<TextBox> VENDOR_NAME = declare("Vendor Name", TextBox.class);
        public static final AssetDescriptor<TextBox> TAX_ID = declare("Tax ID", TextBox.class);
        public static final AssetDescriptor<ComboBox> STATUS = declare("Status", ComboBox.class);

        public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class, Waiters.DEFAULT, false,
                By.id("vendorProfileForm:addVendorChild"));
        public static final AssetDescriptor<Button> BUTTON_SUBMIT_POPUP = declare(AbstractDialog.getDefaultPopupSubmitterName(), Button.class, Waiters.DEFAULT, false,
                By.id("vendorSearch:addBtn"));
    }
}
