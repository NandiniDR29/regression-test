/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.billing.account.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class OtherTransactionsActionTabMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> TRANSACTION_TYPE = declare("Transaction Type", ComboBox.class);
    public static final AssetDescriptor<ComboBox> TRANSACTION_SUBTYPE = declare("Transaction Subtype", ComboBox.class);
    public static final AssetDescriptor<ComboBox> REASON = declare("Reason", ComboBox.class);
    public static final AssetDescriptor<TextBox> AMOUNT = declare("Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> DESCRIPTION = declare("Description", TextBox.class);
    public static final AssetDescriptor<TextBox> ADDITIONAL_INFORMATION = declare("Additional Information", TextBox.class);
}
