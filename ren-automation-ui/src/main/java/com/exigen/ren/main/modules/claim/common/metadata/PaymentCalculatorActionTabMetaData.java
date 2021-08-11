/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.common.metadata;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.main.modules.claim.common.tabs.PaymentCalculatorTab;
import com.exigen.ren.main.modules.claim.common.tabs.PaymentCalculatorTab.PaymentTaxMultiAssetList;
import org.openqa.selenium.By;

public class PaymentCalculatorActionTabMetaData extends MetaData {
    public static final AssetDescriptor<PaymentCalculatorTab.PaymentAdditionMultiAssetList> PAYMENT_ADDITION = declare("Payment Addition", PaymentCalculatorTab.PaymentAdditionMultiAssetList.class, PaymentAdditionMetaData.class, By.id("policyDataGatherForm:formGrid_ClaimsPaymentCalculatorAddition"));
    public static final AssetDescriptor<AssetList> PAYMENT_REDUCTION = declare("Payment Reduction", AssetList.class, PaymentReductionMetaData.class, By.id("policyDataGatherForm:formGrid_ClaimsPaymentCalculatorReduction"));
    public static final AssetDescriptor<PaymentTaxMultiAssetList> PAYMENT_TAX = declare("Payment Tax", PaymentTaxMultiAssetList.class, PaymentTaxMetaData.class, By.xpath("//span[@id='policyDataGatherForm:componentRegion_ClaimsPaymentTaxCalculator']/div"));
    public static final AssetDescriptor<TextBox> ALLOCATION_AMOUNT = declare("Allocation Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> ALLOCATION_NET_AMOUNT = declare("Allocation Net Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> TOTAL_TAX_AMOUNT = declare("Total Tax Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> OASDI_TAXABLE_WAGES = declare("Oasdi Taxable Wages", TextBox.class);
    public static final AssetDescriptor<TextBox> MEDICARE_TAXABLE_WAGES = declare("Medicare Taxable Wages", TextBox.class);
    public static final AssetDescriptor<TextBox> FEDERAL_TAXABLE_WAGES = declare("Federal Taxable Wages", TextBox.class);
    public static final AssetDescriptor<TextBox> STATE_TAXABLE_WAGES = declare("State Taxable Wages", TextBox.class);
    public static final AssetDescriptor<TextBox> GROSS_AMOUNT = declare("Gross Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> NET_AMOUNT = declare("Net Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> OLD_CALCULATED_AMOUNT = declare("Old Calculated Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> CALCULATED_AMOUNT = declare("Calculated Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> AMOUNT = declare("Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> REMAINING_BENEFIT_MAXIMUM_FOR_CURRENT_CALENDAR_YEAR = declare("Remaining Benefit Maximum for current Calendar Year", TextBox.class);
    public static final AssetDescriptor<TextBox> BENEFIT_AMOUNT_PER_MEMBER_PER_MONTH = declare("Benefit Amount - Per Member Per Month", TextBox.class);
    public static final AssetDescriptor<TextBox> TOTAL_BENEFIT_AMOUNT = declare("Total Benefit Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> BENEFIT_AMOUNT_PER_CHILD = declare("Benefit Amount per Child", TextBox.class);
    public static final AssetDescriptor<TextBox> TOTAL_CHILD_EDUCATION_BENEFIT_AMOUNT = declare("Total Child Education Benefit Amount", TextBox.class,
            By.xpath("//input[@id='policyDataGatherForm:sedit_ClaimsPaymentCalculatorAddition_totChEduBenefitAmount']"));
    public static final AssetDescriptor<TextBox> INTEREST_PAID_UP_TO_DATE = declare("Interest paid up to Date", TextBox.class);
    public static final AssetDescriptor<TextBox> AMOUNT_TO_CALCULATE_INTEREST_ON = declare("Amount to calculate interest on", TextBox.class);
    public static final AssetDescriptor<TextBox> NUMBER_OF_DAYS_FROM_DATE_OF_LOSS = declare("Number of days from Date of Loss", TextBox.class);
    public static final AssetDescriptor<TextBox> INTEREST_PAYMENT_AMOUNT = declare("Interest Payment Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> STATE = declare("State", TextBox.class);
    public static final AssetDescriptor<TextBox> REDUCTION_COMMENTS = declare("Reduction Comments", TextBox.class);
    public static final AssetDescriptor<TextBox> COLA_PERCENT = declare("COLA %", TextBox.class);
    public static final AssetDescriptor<TextBox> COLA_AMOUNT = declare("COLA Amount", TextBox.class);
    public static final AssetDescriptor<Button> BUTTON_ADD_PAYMENT_ADDITION = declare("Payment Addition - Add", Button.class, By.id("policyDataGatherForm:addClaimsPaymentCalculatorAddition"));
    public static final AssetDescriptor<Button> BUTTON_REMOVE_PAYMENT_ADDITION = declare("Payment Addition - Remove", Button.class, By.id("policyDataGatherForm:eliminateClaimsPaymentCalculatorAddition"));
    public static final AssetDescriptor<Button> BUTTON_ADD_PAYMENT_REDUCTION = declare("Payment Reduction - Add", Button.class, By.id("policyDataGatherForm:addClaimsPaymentCalculatorReduction"));
    public static final AssetDescriptor<Button> BUTTON_REMOVE_PAYMENT_REDUCTION = declare("Payment Reduction - Remove", Button.class, By.id("policyDataGatherForm:eliminateClaimsPaymentCalculatorReduction"));

    public static final class PaymentAdditionMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> ADDITION_TYPE = declare("Addition Type", ComboBox.class);
        public static final AssetDescriptor<TextBox> WEEKLY_BENEFIT_AMOUNT = declare("Weekly Benefit Amount", TextBox.class, By.id("policyDataGatherForm:sedit_ClaimsPaymentCalculatorAddition_weeklyBenefitAmount"));
        public static final AssetDescriptor<TextBox> MONTHLY_BENEFIT_AMOUNT = declare("Monthly Benefit Amount", TextBox.class, By.id("policyDataGatherForm:sedit_ClaimsPaymentCalculatorAddition_monthlyBenefitAmount"));
        public static final AssetDescriptor<TextBox> BEGINNING_DATE = declare("Beginning Date", TextBox.class);
        public static final AssetDescriptor<TextBox> THROUGH_DATE = declare("Through Date", TextBox.class);
        public static final AssetDescriptor<TextBox> ADDITION_COMMENTS = declare("Addition Comments", TextBox.class);
        public static final AssetDescriptor<ComboBox> NUMBER_OF_ADJUSTMENTS = declare("Number of Adjustments", ComboBox.class);
        public static final AssetDescriptor<TextBox> REQUIRED_MONTHLY_401K_CONTRIBUTION_AMOUNT = declare("Required Monthly 401K Contribution Amount", TextBox.class);
        public static final AssetDescriptor<TextBox> REQUIRED_MONTHLY_COBRA_PREMIUM = declare("Required Monthly COBRA Premium Amount", TextBox.class);
        public static final AssetDescriptor<TextBox> NUMBER_OF_CHILDREN = declare("Number of Children", TextBox.class);
        public static final AssetDescriptor<TextBox> NUMBER_OF_FAMILY_MEMBERS = declare("Number of Family Members", TextBox.class);
        public static final AssetDescriptor<TextBox> REQUIRED_MONTHLY_STUDENT_LOAN_AMOUNT = declare("Required Monthly Student Loan Amount", TextBox.class);
    }

    public static final class PaymentReductionMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> REDUCTION_TYPE = declare("Reduction Type", ComboBox.class);
        public static final AssetDescriptor<ComboBox> TYPE_OF_DEDUCTION = declare("Type Of Deduction", ComboBox.class);
        public static final AssetDescriptor<TextBox> BEGINNING_DATE = declare("Beginning Date", TextBox.class);
        public static final AssetDescriptor<TextBox> THROUGH_DATE = declare("Through Date", TextBox.class);
        public static final AssetDescriptor<TextBox> DEDUCTION_AMOUNT = declare("Deduction Amount", TextBox.class, By.id("policyDataGatherForm:sedit_ClaimsPaymentCalculatorReduction_deductionAmount"));
        public static final AssetDescriptor<RadioGroup> APPLY_PRE_TAX = declare("Apply Pre-tax", RadioGroup.class);
        public static final AssetDescriptor<TextBox> PRIORITY = declare("Priority", TextBox.class);
        public static final AssetDescriptor<ComboBox> PARTY = declare("Party", ComboBox.class);
        public static final AssetDescriptor<RadioGroup> EXCLUDED = declare("Excluded", RadioGroup.class);
    }

    public static final class PaymentTaxMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> TAX_TYPE = declare("Tax Type", ComboBox.class);
        public static final AssetDescriptor<TextBox> TAX_AMOUNT = declare("Tax Amount", TextBox.class);
        public static final AssetDescriptor<TextBox> FICA_SOCIAL_SECURITY_TAX_AMOUNT = declare("FICA Social Security Tax Amount", TextBox.class);
        public static final AssetDescriptor<TextBox> FICA_MEDICARE_TAX_AMOUNT = declare("FICA Medicare Tax Amount", TextBox.class);
        public static final AssetDescriptor<TextBox> RATE = declare("Rate %", TextBox.class);
    }

}
