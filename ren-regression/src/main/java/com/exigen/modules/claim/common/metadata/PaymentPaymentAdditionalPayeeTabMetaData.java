/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.common.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class PaymentPaymentAdditionalPayeeTabMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> PAYEE = declare("Payee", ComboBox.class);
    public static final AssetDescriptor<TextBox> ORIGINAL_ADDITIONAL_PAYEE = declare("Original Additional Payee", TextBox.class);
}
