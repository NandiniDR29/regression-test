/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.common.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;

public class OtherIncomeBenefitActionTabMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> TYPE_OF_OFFSET = declare("Type of Offset", ComboBox.class, Waiters.AJAX.then(Waiters.SLEEP(2000)));
    public static final AssetDescriptor<TextBox> PAYMENT_AMOUNT = declare("Payment Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> BEGINNING_DATE = declare("Beginning Date", TextBox.class);
    public static final AssetDescriptor<TextBox> THROUGH_DATE = declare("Through Date", TextBox.class);
    public static final AssetDescriptor<ComboBox> PRORATING_RATE = declare("Prorating Rate", ComboBox.class);
}
