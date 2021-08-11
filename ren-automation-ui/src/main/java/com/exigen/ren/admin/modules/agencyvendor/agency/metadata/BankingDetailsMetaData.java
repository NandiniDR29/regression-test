/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.agency.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class BankingDetailsMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> SETTLEMENT_METHOD = declare("Settlement Method", ComboBox.class);
    public static final AssetDescriptor<ComboBox> BANK_DETAILS_STATUS = declare("Bank Details Status", ComboBox.class);
    public static final AssetDescriptor<TextBox> ACCOUNT_HOLDER_NAME = declare("Account Holder Name", TextBox.class);
    public static final AssetDescriptor<ComboBox> ACCOUNT_TYPE = declare("Account Type", ComboBox.class);
    public static final AssetDescriptor<TextBox> ACCOUNT = declare("Account #", TextBox.class);
    public static final AssetDescriptor<RadioGroup> EFT_PROTOCAL_FORM_RECEIVED = declare("EFT Protocol Form Received", RadioGroup.class);
    public static final AssetDescriptor<TextBox> ABA_TRANSIT = declare("ABA Transit #", TextBox.class);
    public static final AssetDescriptor<TextBox> EFFECTIVE_DATE = declare("Effective Date", TextBox.class);
    public static final AssetDescriptor<TextBox> EXPIRATION_DATE = declare("Expiration Date", TextBox.class);
    public static final AssetDescriptor<RadioGroup> INTERNATIONAL_ACH_FORMATTING = declare("International ACH Formatting", RadioGroup.class);
    public static final AssetDescriptor<ComboBox> BANK_NAME = declare("Bank Name", ComboBox.class);
    public static final AssetDescriptor<ComboBox> BANK_BRANCH_CODE = declare("Bank Branch Code", ComboBox.class);
    public static final AssetDescriptor<ComboBox> BANK_ACCOUNT_TYPE = declare("Bank Account Type", ComboBox.class);
}
