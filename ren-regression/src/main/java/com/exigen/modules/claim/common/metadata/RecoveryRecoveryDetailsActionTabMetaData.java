/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.common.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class RecoveryRecoveryDetailsActionTabMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> TYPE_OF_RECOVERY = declare("Type of Recovery", ComboBox.class);
    public static final AssetDescriptor<TextBox> AMOUNT = declare("Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> POSTING_DATE = declare("Posting Date", TextBox.class);
    public static final AssetDescriptor<TextBox> POSTING_TIME = declare("Posting Time", TextBox.class);
    public static final AssetDescriptor<ComboBox> RECOVERY_METHOD = declare("Recovery Method", ComboBox.class);
    public static final AssetDescriptor<TextBox> CHECK = declare("Check #", TextBox.class);
    public static final AssetDescriptor<TextBox> BANK_ACCOUNT = declare("Bank Account", TextBox.class);
    public static final AssetDescriptor<TextBox> RECOVERY_MEMO = declare("Recovery Memo", TextBox.class);
    public static final AssetDescriptor<TextBox> ALLOCATIONS_AMOUNT = declare("Allocations Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> DATE = declare("Date", TextBox.class);
    public static final AssetDescriptor<TextBox> REASON = declare("Reason", TextBox.class);
    public static final AssetDescriptor<TextBox> DETAILS = declare("Details", TextBox.class);
    public static final AssetDescriptor<TextBox> TAXATION_YEAR = declare("Taxation Year", TextBox.class);
    public static final AssetDescriptor<RadioGroup> OVERPAYMENT_TAX_RECORDING = declare("Overpayment Tax Recording", RadioGroup.class);
}
