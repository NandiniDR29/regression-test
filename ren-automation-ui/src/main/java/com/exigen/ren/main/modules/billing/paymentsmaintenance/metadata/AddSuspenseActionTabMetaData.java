/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.billing.paymentsmaintenance.metadata;

import com.exigen.ipb.eisa.controls.dialog.DialogMultiSelector;
import com.exigen.ipb.eisa.controls.dialog.DialogSingleSelector;
import com.exigen.ipb.eisa.controls.dialog.type.AbstractDialog;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.main.metadata.PaymentsMaintenanceMetaData;
import org.openqa.selenium.By;

public class AddSuspenseActionTabMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> SUSPENSE_AMOUNT = declare("Suspense Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> SUSPENSE_REFERENCE = declare("Suspense Reference #", TextBox.class);
    public static final AssetDescriptor<ComboBox> PAYMENT_DESIGNATION = declare("Payment Designation", ComboBox.class);
    public static final AssetDescriptor<TextBox> RECEIVED_FROM = declare("Received From", TextBox.class);
    public static final AssetDescriptor<ComboBox> PAYMENT_CHANNEL = declare("Payment Channel", ComboBox.class);
    public static final AssetDescriptor<DialogSingleSelector> BUSINESS_NAME = declare("Business Name", DialogSingleSelector.class, SelectGroupInsuranceCustomer.class);

    public static final class SelectGroupInsuranceCustomer extends MetaData {

        public static final AssetDescriptor<TextBox> BILLING_ACCOUNT = declare("Billing Account #", TextBox.class);
        public static final AssetDescriptor<TextBox> POLICY = declare("Policy/Quote #", TextBox.class);
        public static final AssetDescriptor<TextBox> GROUP_INSURANCE_CUSTOMER = declare("Group Insurance Customer", TextBox.class);
        public static final AssetDescriptor<TextBox> ACCOUNT = declare("Account #", TextBox.class);
        public static final AssetDescriptor<TextBox> CUSTOMER = declare("Customer #", TextBox.class);
        public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class,
                Waiters.DEFAULT, false, By.id("suspenseForm:selectBusinessCusomerBtn"));
    }
}
