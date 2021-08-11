/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.billing.account.metadata;

import com.exigen.ipb.eisa.controls.dialog.DialogSingleSelector;
import com.exigen.ipb.eisa.controls.dialog.type.AbstractDialog;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;

public class TransferPaymentBenefitsActionTabMetaData extends MetaData {
    public static final AssetDescriptor<DialogSingleSelector> BILLING_ACCOUNT = declare("Billing Account", DialogSingleSelector.class,
            com.exigen.ren.main.modules.billing.account.metadata.TransferPaymentBenefitsActionTabMetaData.BillingAccountSingleSelector.class, false, By.id("searchBillingAccountsForm:billingAccountSearchPopup"));
    public static final AssetDescriptor<TextBox> TRANSFER_AMOUNT = declare("Transfer Amount", TextBox.class);
    public static final AssetDescriptor<StaticElement> PAYMENT_AMOUNT = declare("Payment Amount", StaticElement.class);
    public static final AssetDescriptor<TextBox> BILLING_ACCOUNT_VALUE = declare("Billing account", TextBox.class, By.id("paymentForm:billingAccount"));

    public static final class BillingAccountSingleSelector extends MetaData {
        public static final AssetDescriptor<TextBox> BUSINESS_NAME = declare("Business Name", TextBox.class);
        public static final AssetDescriptor<TextBox> BILLING_ACCOUNT_NUMBER = declare("Billing Account #", TextBox.class);
        public static final AssetDescriptor<TextBox> POLICY_NUMBER = declare("Policy #", TextBox.class);
        public static final AssetDescriptor<TextBox> FIRST_NAME = declare("First Name", TextBox.class);
        public static final AssetDescriptor<TextBox> LAST_NAME = declare("Last Name", TextBox.class);
        public static final AssetDescriptor<TextBox> CASE_NUMBER = declare("Case #", TextBox.class);
        public static final AssetDescriptor<StaticElement> WARNING_MESSAGE = declare("Warning", StaticElement.class, By.id("searchBillingAccountsForm:accountSearchMessage"));

        public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class,
                Waiters.SLEEP(30000), false, By.id("paymentForm:showBillingAccountSearchPopupLnk"));
        public static final AssetDescriptor<Button> BUTTON_SEARCH = declare("Search", Button.class, By.id("searchBillingAccountsForm:searchBtn"));
        public static final AssetDescriptor<Button> BUTTON_CANCEL = declare("Cancel", Button.class, By.id("searchBillingAccountsForm:cancel_btn"));
    }
}
