/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.commission.commissionbonus.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class CommissionBonusMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> COMMISSION_BONUS_NAME = declare("Commission Bonus Name", TextBox.class);
    public static final AssetDescriptor<ComboBox> SALES_CHANNEL = declare("Sales Channel", ComboBox.class);
    public static final AssetDescriptor<TextBox> DATE_FROM = declare("Date From", TextBox.class);
    public static final AssetDescriptor<TextBox> DATE_TO = declare("Date To", TextBox.class);
    public static final AssetDescriptor<RadioGroup> TRANSACTION_DATES = declare("Transaction Dates", RadioGroup.class);
    public static final AssetDescriptor<ComboBox> ROUNDING = declare("Rounding", ComboBox.class);

    public static final class MinimumPremiumThreshold extends MetaData {
        public static final AssetDescriptor<ComboBox> PRODUCT_CODE_NAME = declare("Product Code-Name", ComboBox.class);
        public static final AssetDescriptor<TextBox> PREMIUM_AMOUNT = declare("Premium Amount", TextBox.class);
        public static final AssetDescriptor<TextBox> LOSS_RATIO = declare("Loss Ratio", TextBox.class);
    }

    public static final class BonusPlan extends MetaData {
        public static final AssetDescriptor<TextBox> TOTAL_PREMIUM_WRITTEN = declare("Total Premium Written", TextBox.class);
        public static final AssetDescriptor<TextBox> PAY_BONUS = declare("Pay Bonus", TextBox.class);
        public static final AssetDescriptor<TextBox> LOSS_RATIO = declare("Loss Ratio", TextBox.class);
    }
}
