/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.billing.account.metadata;

import com.exigen.istf.webdriver.controls.*;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.billing.account.metadata.AcceptPaymentActionTabMetaData;
import org.openqa.selenium.By;

public class AddPaymentMethodTabMetaData extends MetaData {
    public static final AssetDescriptor<Link> ADD_PAYMENT_METHOD = declare("Add Payment Method", Link.class, By.id("paymentForm:addPaymentMethodButton"));
    public static final AssetDescriptor<ComboBox> PAYMENT_METHOD = declare("Payment Method", ComboBox.class);
    public static final AssetDescriptor<AssetList> CARD_BILLING_ADDRESS = declare("Card Billing Address", AssetList.class, AcceptPaymentActionTabMetaData.CardBillingAddress.class, false, By.xpath("//span[@id='paymentMethodForm:paymentMethodDetailsAddressForm']"));
    public static final AssetDescriptor<AssetList> GENERAL = declare("General", AssetList.class, AcceptPaymentActionTabMetaData.General.class, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<ComboBox> BANK_ACCOUNT_TYPE = declare("Bank Account Type", ComboBox.class);
    public static final AssetDescriptor<TextBox> TRANSIT_NUMBER = declare("Routing#/Transit #", TextBox.class);
    public static final AssetDescriptor<TextBox> ACCOUNT_NUMBER = declare("Account #", TextBox.class);
    public static final AssetDescriptor<TextBox> BANK_NAME = declare("Bank Name", TextBox.class);
    public static final AssetDescriptor<TextBox> PAYMENT_METHOD_EFFECTIVE_DATE = declare("Payment Method Effective Date", TextBox.class);
    public static final AssetDescriptor<TextBox> PAYMENT_METHOD_EXPIRATION_DATE = declare("Payment Method Expiration Date", TextBox.class);
    public static final AssetDescriptor<ComboBox> NAME_TYPE = declare("Name Type", ComboBox.class);
    public static final AssetDescriptor<TextBox> NAME = declare("Name", TextBox.class);
    public static final AssetDescriptor<ComboBox> PREFIX = declare("Prefix", ComboBox.class);
    public static final AssetDescriptor<TextBox> FIRST_NAME = declare("First Name", TextBox.class);
    public static final AssetDescriptor<TextBox> MIDDLE_NAME = declare("Middle Name", TextBox.class);
    public static final AssetDescriptor<TextBox> LAST_NAME = declare("Last Name", TextBox.class);
    public static final AssetDescriptor<RadioGroup> DOES_THE_BANK_ACCOUNT_BELONG_TO_THE_INSURED = declare("Does the Bank Account belong to the Insured?", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> DOES_THE_CREDIT_CARD_BELONG_TO_THE_INSURED = declare("Does the Credit Card belong to the Insured?", RadioGroup.class);
    public static final AssetDescriptor<AssetList> BILLING_MAILING_ADDRESS = declare("Billing Mailing Address", AssetList.class, AcceptPaymentActionTabMetaData.BillingMailingAddress.class,false, By.xpath("//span[contains(@id,'billingMailingAddressForm')]"));
    public static final AssetDescriptor<ComboBox> PAYORS_NAME_TYPE = declare("Payor's Name Type", ComboBox.class);
    public static final AssetDescriptor<TextBox> PAYORS_NAME = declare("Payor's Name", TextBox.class);
    public static final AssetDescriptor<ComboBox> PAYORS_PREFIX = declare("Payor's Prefix", ComboBox.class);
    public static final AssetDescriptor<TextBox> PAYORS_FIRST_NAME = declare("Payor's First Name", TextBox.class);
    public static final AssetDescriptor<TextBox> PAYORS_MIDDLE_NAME = declare("Payor's Middle Name", TextBox.class);
    public static final AssetDescriptor<TextBox> PAYORS_LAST_NAME = declare("Payor's Last Name", TextBox.class);
    public static final AssetDescriptor<Button> ADD_UPDATE = declare("Add/Update", Button.class, By.xpath("//input[@value='Add/Update']"));
    public static final AssetDescriptor<Button> BACK = declare("Back", Button.class, By.id("primaryButtonsForm:backButton_footer"));
}
