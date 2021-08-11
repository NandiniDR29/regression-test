/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.common.metadata;

import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class FeatureActionTabMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> FEATURE_NUMBER = declare("Feature Number", TextBox.class);
    public static final AssetDescriptor<TextBox> FEATURE_ID = declare("Feature ID", TextBox.class);
    public static final AssetDescriptor<TextBox> CLAIMANT = declare("Claimant", TextBox.class);
    public static final AssetDescriptor<TextBox> ASSOCIATED_INSURABLE_RISK = declare("Associated Insurable Risk", TextBox.class);
    public static final AssetDescriptor<TextBox> COVERAGE = declare("Coverage", TextBox.class);
    public static final AssetDescriptor<TextBox> DAMAGE = declare("Damage", TextBox.class);
    public static final AssetDescriptor<TextBox> FEATURE_OWNER = declare("Feature Owner", TextBox.class);
    public static final AssetDescriptor<TextBox> DATE_ASSIGNED = declare("Date Assigned", TextBox.class);
    public static final AssetDescriptor<TextBox> TOTAL_INCURRED = declare("Total Incurred", TextBox.class);
    public static final AssetDescriptor<TextBox> FEATURE_STATUS = declare("Feature Status", TextBox.class);
    public static final AssetDescriptor<TextBox> FEATURE_STATUS_DATE = declare("Feature Status Date", TextBox.class);
    public static final AssetDescriptor<TextBox> DESCRIPTION = declare("Description", TextBox.class);
    public static final AssetDescriptor<TextBox> DATE_OF_TRANSACTION = declare("Date of Transaction", TextBox.class);
    public static final AssetDescriptor<TextBox> RESERVE_TYPE = declare("Reserve Type", TextBox.class);
    public static final AssetDescriptor<TextBox> NEW_RESERVE = declare("New Reserve", TextBox.class);
    public static final AssetDescriptor<TextBox> OLD_RESERVE = declare("Old Reserve", TextBox.class);
    public static final AssetDescriptor<TextBox> UPDATE_AMOUNT = declare("Update Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> TRANSACTION = declare("Transaction", TextBox.class);
    public static final AssetDescriptor<TextBox> TRANSACTION_REASON = declare("Transaction Reason", TextBox.class);
    public static final AssetDescriptor<TextBox> TRANSACTION_COMMENT = declare("Transaction Comment", TextBox.class);
    public static final AssetDescriptor<TextBox> PAYMENT_NUMBER = declare("Payment Number", TextBox.class);
    public static final AssetDescriptor<TextBox> PAYEE = declare("Payee", TextBox.class);
    public static final AssetDescriptor<TextBox> TOTAL_PAYMENT_AMOUNT = declare("Total Payment Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> TRANSACTION_STATUS = declare("Transaction Status", TextBox.class);
    public static final AssetDescriptor<TextBox> RECOVERY_NUMBER = declare("Recovery Number", TextBox.class);
    public static final AssetDescriptor<TextBox> RECOVERED_FROM = declare("Recovered From", TextBox.class);
    public static final AssetDescriptor<TextBox> TOTAL_RECOVERY_AMOUNT = declare("Total Recovery Amount", TextBox.class);
}
