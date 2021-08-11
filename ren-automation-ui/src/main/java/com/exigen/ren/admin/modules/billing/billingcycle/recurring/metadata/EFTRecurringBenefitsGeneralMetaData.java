/* Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.billing.billingcycle.recurring.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
import com.exigen.ipb.eisa.controls.AdvancedSelector2;
import com.exigen.ipb.eisa.controls.ListBox2;
import com.exigen.ipb.eisa.controls.dialog.DialogAssetList;
import com.exigen.istf.webdriver.controls.*;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.common.pages.Page;
import org.openqa.selenium.By;

public class EFTRecurringBenefitsGeneralMetaData extends MetaData {

    public static final AssetDescriptor<ComboBox> BROAD_LINE_OF_BUSINESS = declare("Broad Line of Business", ComboBox.class);
    public static final AssetDescriptor<AdvancedSelector> PRODUCTS = declare("Products", AdvancedSelector.class);
    public static final AssetDescriptor<AdvancedSelector> BRANDS = declare("Brands", AdvancedSelector.class);
    public static final AssetDescriptor<DialogAssetList> GEOGRAPHY = declare("Geography", DialogAssetList.class, GeographyMetaData.class, false, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));


    public static final AssetDescriptor<ListBox2> PAYMENT_METHOD_TYPE = declare("Payment Method Type", ListBox2.class, By.id("eftRecurringEditForm:paymentTypes"));
    public static final AssetDescriptor<ComboBox> BILLING_CALENDAR = declare("Billing Calendar", ComboBox.class);
    public static final AssetDescriptor<TextBox> WITHDRAW_RECURRING = declare("Withdraw recurring payments X days in advance of invoice due date", TextBox.class, By.id("eftRecurringEditForm:recurringPaymentDays"));
    public static final AssetDescriptor<AdvancedSelector2> INVOICE_TYPE = declare("Invoice Type", AdvancedSelector2.class);


    public static class GeographyMetaData extends MetaData {
        public static final AssetDescriptor<Button> OPEN_POPUP = declare("Open Popup", Button.class, Waiters.AJAX, By.xpath(".//*[@id='cancelForm:selectGeographyBtn']"));
        public static final AssetDescriptor<ListBox> COUNTRIES = declare("Countries", ListBox.class, Waiters.AJAX, false, By.xpath(".//*[@id='gForm_geographyPanel:countries']"));
        public static final AssetDescriptor<ListBox> STATES = declare("States", ListBox.class, Waiters.AJAX, false, By.xpath(".//*[@id='gForm_geographyPanel:states']"));
        public static final AssetDescriptor<Button> SUBMIT_POPUP = declare("Submit Popup", Button.class, Waiters.AJAX, false, By.xpath(".//*[@id='gForm_geographyPanel:okBtn_geographyPanel']"));
        public static final AssetDescriptor<Button> CLOSE_POPUP = declare("Close Popup", Button.class, Waiters.AJAX, false, By.xpath(".//*[@id='gForm_geographyPanel:cancelBtn_geographyPanel']"));
    }


}