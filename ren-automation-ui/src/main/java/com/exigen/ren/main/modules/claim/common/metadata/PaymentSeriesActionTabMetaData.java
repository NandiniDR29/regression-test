/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.common.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class PaymentSeriesActionTabMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> SERIES_NUMBER = declare("Series Number", TextBox.class);
    public static final AssetDescriptor<TextBox> PAYEE = declare("Payee", TextBox.class);
    public static final AssetDescriptor<TextBox> EFFECTIVE_DATE = declare("Effective Date", TextBox.class);
    public static final AssetDescriptor<TextBox> EXPIRATION_DATE = declare("Expiration Date", TextBox.class);
    public static final AssetDescriptor<ComboBox> FREQUENCY = declare("Frequency", ComboBox.class);
    public static final AssetDescriptor<TextBox> TOTAL_AMOUNT = declare("Total Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> PERFORMER = declare("Performer", TextBox.class);
    public static final AssetDescriptor<ComboBox> STATUS = declare("Status", ComboBox.class);
    public static final AssetDescriptor<TextBox> DESCRIPTION = declare("Description", TextBox.class);
    public static final AssetDescriptor<TextBox> PAYMENT_NUMBER = declare("Payment Number", TextBox.class);
    public static final AssetDescriptor<TextBox> PAYMENT_POST_DATE = declare("Payment Post Date", TextBox.class);
    public static final AssetDescriptor<TextBox> PAYMENT_AMOUNT = declare("Payment Amount", TextBox.class);
    public static final AssetDescriptor<ComboBox> PAYMENT_METHOD = declare("Payment Method", ComboBox.class);
    public static final AssetDescriptor<TextBox> TRANSACTION_STATUS = declare("Transaction Status", TextBox.class);
    public static final AssetDescriptor<TextBox> PAYMENT_SCHEDULE_DATE = declare("Payment Schedule Date", TextBox.class);
    public static final AssetDescriptor<TextBox> AMOUNT = declare("Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> SERIES_STATUS_DATE = declare("Series Status Date", TextBox.class);
    public static final AssetDescriptor<TextBox> ACTION = declare("Action", TextBox.class);
    public static final AssetDescriptor<TextBox> REASON = declare("Reason", TextBox.class);
    public static final AssetDescriptor<TextBox> DETAILS = declare("Details", TextBox.class);
    public static final AssetDescriptor<TextBox> COMPONENT_NAME = declare("Component Name", TextBox.class);
}
