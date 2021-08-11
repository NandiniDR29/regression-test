/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.billing.setup_billing_groups.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import org.openqa.selenium.By;

public class BillingGroupsTabMetaData extends MetaData {
    public static final AssetDescriptor<Button> ADD_BILLING_GROUP = declare("Add Billing Group", Button.class, By.id("policyDataGatherForm:addGroupBillingGroup"));
    public static final AssetDescriptor<TextBox> BILLING_GROUP_NAME = declare("Billing Group Name", TextBox.class);
    public static final AssetDescriptor<ComboBox> BILLING_GROUP_TYPE = declare("Billing Group Type", ComboBox.class);
    public static final AssetDescriptor<ComboBox> PAYMENT_MODE = declare("Payment Mode", ComboBox.class);
    public static final AssetDescriptor<ComboBox> PAYOR = declare("Payor", ComboBox.class);
    public static final AssetDescriptor<ComboBox> PAYROLL_FREQUENCY = declare("Payroll Frequency", ComboBox.class);
    public static final AssetDescriptor<AdvancedSelector> COVERAGE = declare("Coverage", AdvancedSelector.class);
    public static final AssetDescriptor<AdvancedSelector> CLASSIFICATION_GROUP = declare("Classification Group", AdvancedSelector.class);
    public static final AssetDescriptor<AdvancedSelector> BILLING_LOCATION = declare("Billing Location", AdvancedSelector.class);
    public static final AssetDescriptor<ComboBox> PAYROLL_CALENDAR = declare("Payroll Calendar", ComboBox.class);
    public static final AssetDescriptor<TextBox> DEDUCTION_START_DATE = declare("Deduction Start Date", TextBox.class);
}
