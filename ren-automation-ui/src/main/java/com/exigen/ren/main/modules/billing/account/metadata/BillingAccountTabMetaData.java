/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.billing.account.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
import com.exigen.ipb.eisa.controls.dialog.DialogAssetList;
import com.exigen.istf.webdriver.controls.*;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.common.pages.Page;
import org.openqa.selenium.By;

public class BillingAccountTabMetaData extends MetaData {
    public static final AssetDescriptor<StaticElement> GROUP=declare("Billing Group Name",StaticElement.class);
    public static final AssetDescriptor<RadioGroup> SELECT_ACTION = declare("Select Action", RadioGroup.class);
    public static final AssetDescriptor<AssetList> CREATE_NEW_BILLING_ACCOUNT = declare("Create New Account", AssetList.class, BillingAccountGeneralOptions.class, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<ComboBox> BILL_UNDER_ACCOUNT = declare("Bill Under Account", ComboBox.class);
    public static final AssetDescriptor<StaticElement> BILLING_ACCOUNT_SETUP_ERROR_MESSAGE = declare("Error Message", StaticElement.class, By.xpath("//div[@id='purchaseForm:purchaseFormPanel']/span[contains(@class,'error_message')]"));
    public static final AssetDescriptor<ComboBox> INVOICING_CALENDAR_VALUE = declare("Invoicing Calendar", ComboBox.class, Waiters.DEFAULT,By.id("purchaseForm:createLinkedNonPremiumBA_invoicingStrategy"));
    public static final AssetDescriptor<Button> MANAGE_INVOICING_CALENDARS_NON_PREMIUM = declare("Manage Invoicing Calendars", Button.class, By.id("purchaseForm:createLinkedNonPremiumBA_manageInvoiceCalendarsLink"));

    public static final class BillingAccountGeneralOptions extends MetaData {
        public static final AssetDescriptor<TextBox> BILLING_ACCOUNT_NAME = declare("Billing Account Name", TextBox.class);
        public static final AssetDescriptor<ComboBox> BILL_TYPE = declare("Bill Type", ComboBox.class);
        public static final AssetDescriptor<TextBox> BILLING_CONTACT_NAME = declare("Billing Contact Name", TextBox.class);

        public static final AssetDescriptor<ComboBox> COUNTRY = declare("Country", ComboBox.class);
        public static final AssetDescriptor<TextBox> ZIP_POSTAL_CODE = declare("Zip / Postal Code", TextBox.class);
        public static final AssetDescriptor<TextBox> ADDRESS_LINE_1 = declare("Address Line 1", TextBox.class);
        public static final AssetDescriptor<TextBox> ADDRESS_LINE_2 = declare("Address Line 2", TextBox.class);
        public static final AssetDescriptor<TextBox> ADDRESS_LINE_3 = declare("Address Line 3", TextBox.class);
        public static final AssetDescriptor<TextBox> CITY = declare("City", TextBox.class);
        public static final AssetDescriptor<ComboBox> STATE_PROVINCE = declare("State / Province", ComboBox.class);
        public static final AssetDescriptor<TextBox> PHONE = declare("Phone #", TextBox.class);
        public static final AssetDescriptor<TextBox> EMAIL = declare("Email", TextBox.class);
        public static final AssetDescriptor<AssetList> ADD_INVOICING_CALENDAR = declare("Add Invoicing Calendar", AssetList.class, BillingAccountTabMetaData.InvoicingCalendarTab.class, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
        public static final AssetDescriptor<ComboBox> INVOICING_CALENDAR = declare("Invoicing Calendar", ComboBox.class, Waiters.DEFAULT);
        public static final AssetDescriptor<ComboBox> INVOICE_DOCUMENT_TEMPLATE = declare("Invoice document template", ComboBox.class);
        public static final AssetDescriptor<TextBox> TDB_PRIVATE_PLAN = declare("TDB Private Plan #", TextBox.class);
        public static final AssetDescriptor<TextBox> FLB_PRIVATE_PLAN = declare("FLB Private Plan #", TextBox.class);
        public static final AssetDescriptor<CheckBox> CREATE_LINKED_NON_PREMIUM_TYPE_BILLING_ACCOUNT = declare("Create Linked Non-Premium Type Billing Account", CheckBox.class, By.id("purchaseForm:billingAccountTemplateDetails_billingAccountDetail_createNonPremiumBACheckbox"));

        public static final AssetDescriptor<AssetList> BILLING_ACCOUNT_PAYMENT_OPTIONS = declare("Billing Account Payment Options", AssetList.class, BillingAccountPaymentOptions.class, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
        public static final AssetDescriptor<AssetList> LINKED_NON_PREMIUM_TYPE_BILLING_ACCOUNT = declare("Linked Non-Premium Type Billing Account", AssetList.class, LinkedNonPremiumTypeBillingAccountMetaData.class, By.xpath("//span[@id='purchaseForm:createLinkedNonPremiumBA_linkedNonPremiumBillingAccountComponent']/table"));
    }

    public static final class BillingAccountPaymentOptions extends MetaData {
        public static final AssetDescriptor<CheckBox> ENABLE_RECURRING_PAYMENTS = declare("Enable Recurring Payments", CheckBox.class);
        public static final AssetDescriptor<ComboBox> USE_PAYMENT_METHOD = declare("Use Payment Method", ComboBox.class);
        public static final AssetDescriptor<Button> ADD_PAYMENT_METHOD = declare("Add Payment Method", Button.class, By.id("updateForm:addPaymentMethodBtn"));
    }

    public static final class LinkedNonPremiumTypeBillingAccountMetaData extends MetaData {
        public static final AssetDescriptor<TextBox> BILLING_ACCOUNT_NAME = declare("Billing Account Name", TextBox.class);
        public static final AssetDescriptor<ComboBox> INVOICING_CALENDAR = declare("Invoicing Calendar", ComboBox.class);
        public static final AssetDescriptor<CheckBox> ENABLE_RECURRING_PAYMENTS = declare("Enable Recurring Payments", CheckBox.class);
        public static final AssetDescriptor<ComboBox> USE_PAYMENT_METHOD = declare("Use Payment Method", ComboBox.class);
    }

    public static final class InvoicingCalendarTab extends MetaData {
        public static final AssetDescriptor<Button> MANAGE_INVOICING_CALENDARS = declare("Manage Invoicing Calendars", Button.class, By.xpath(".//*[contains (@id, 'manageInvoiceCalendarsLink')]"));
        public static final AssetDescriptor<Button> ADD_INVOICING_CALENDAR_BUTTON = declare("Add Invoicing Calendar Button", Button.class, By.id("manageInvoiceCalendarsForm:addBtn_footer"));

        public static final AssetDescriptor<ComboBox> BILLING_CALENDAR = declare("Billing Calendar", ComboBox.class);
        public static final AssetDescriptor<TextBox> CALENDAR_NAME = declare("Calendar Name", TextBox.class);
        public static final AssetDescriptor<CheckBox> SELF_ADMINISTERED = declare("Self Administered", CheckBox.class,
                By.xpath("//input[@id='invoicingCalendarEditForm:groupType:0']"));
        public static final AssetDescriptor<CheckBox> LIST_BILL = declare("List Bill", CheckBox.class,
                By.xpath("//input[@id='invoicingCalendarEditForm:groupType:1']"));
        public static final AssetDescriptor<CheckBox> NON_PREMIUM = declare("Non Premium", CheckBox.class,
                By.xpath("//input[@id='invoicingCalendarEditForm:groupType:2']"));
        public static final AssetDescriptor<DialogAssetList> GEOGRAPHY = declare("Geography", DialogAssetList.class, GeographyMetaData.class, false, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
        public static final AssetDescriptor<AdvancedSelector> PRODUCTS = declare("Products", AdvancedSelector.class);
        public static final AssetDescriptor<TextBox> EFFECTIVE_DATE = declare("Effective Date", TextBox.class);
        public static final AssetDescriptor<TextBox> EXPIRATION_DATE = declare("Expiration Date", TextBox.class);
        public static final AssetDescriptor<ComboBox> INVOICING_FREQUENCY = declare("Invoicing Frequency", ComboBox.class);
        public static final AssetDescriptor<ComboBox> INVOICING_RULE = declare("Invoicing Rule", ComboBox.class);
        public static final AssetDescriptor<ComboBox> BILLING_PERIOD_OFFSET = declare("Billing Period Offset", ComboBox.class);
        public static final AssetDescriptor<ComboBox> INVOICE_DUE_DAY = declare("Invoice Due Day", ComboBox.class);
        public static final AssetDescriptor<TextBox> GENERATION_DATE_RULE = declare("Generation Date Rule", TextBox.class);

        public static final AssetDescriptor<Button> CALENDAR_SAVE_BUTTON = declare("Calendar Save Button", Button.class, By.id("invoicingCalendarEditForm:saveButton_footer"));
        public static final AssetDescriptor<Button> CALENDAR_BACK_BUTTON = declare("Calendar Back Button", Button.class, By.id("manageInvoiceCalendarsForm:backBtn_footer"));
    }

    public static class GeographyMetaData extends MetaData {
        public static final AssetDescriptor<Button> OPEN_POPUP = declare("Open Popup", Button.class, Waiters.AJAX, By.xpath(".//*[@id='invoicingCalendarEditForm:selectGeographyBtn']"));
        public static final AssetDescriptor<ListBox> COUNTRIES = declare("Countries", ListBox.class, Waiters.AJAX, false, By.xpath(".//*[@id='gForm_geographyPanel:countries']"));
        public static final AssetDescriptor<ListBox> STATES = declare("States", ListBox.class, Waiters.AJAX, false, By.xpath(".//*[@id='gForm_geographyPanel:states']"));
        public static final AssetDescriptor<Button> SUBMIT_POPUP = declare("Submit Popup", Button.class, Waiters.AJAX, false, By.xpath(".//*[@id='gForm_geographyPanel:okBtn_geographyPanel']"));
        public static final AssetDescriptor<Button> CLOSE_POPUP = declare("Close Popup", Button.class, Waiters.AJAX, false, By.xpath(".//*[@id='gForm_geographyPanel:cancelBtn_geographyPanel']"));
    }
}
