/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.common.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class BenefitsAccidentalDeathBeneficiaryTabMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> PARTY_NAME = declare("Party Name", ComboBox.class);
    public static final AssetDescriptor<ComboBox> RELATIONSHIP_TO_DECEDENT = declare("Relationship To Decedent", ComboBox.class);
    public static final AssetDescriptor<TextBox> DESCRIPTION_OF_RELATIONSHIP_TO_DECEDENT = declare("Description of Relationship to Decedent", TextBox.class);
    public static final AssetDescriptor<ComboBox> PREFIX = declare("Prefix", ComboBox.class);
    public static final AssetDescriptor<TextBox> FIRST_NAME = declare("First Name", TextBox.class);
    public static final AssetDescriptor<TextBox> MIDDLE_NAME = declare("Middle Name", TextBox.class);
    public static final AssetDescriptor<TextBox> LAST_NAME = declare("Last Name", TextBox.class);
    public static final AssetDescriptor<ComboBox> SUFFIX = declare("Suffix", ComboBox.class);
    public static final AssetDescriptor<TextBox> COMPANY_NAME = declare("Company Name", TextBox.class);
    public static final AssetDescriptor<TextBox> TAX_IDENTIFICATION_NUMBER_OR_FEDERAL_EMPLOYMENT_IDENTIFICATION_NUMBER =
            declare("Tax Identification Number or Federal Employment Identification Number", TextBox.class);
    public static final AssetDescriptor<ComboBox> PHONE_TYPE2 = declare("Phone Type2", ComboBox.class);
    public static final AssetDescriptor<TextBox> PHONE2 = declare("Phone2", TextBox.class);
    public static final AssetDescriptor<ComboBox> PHONE_TYPE3 = declare("Phone Type3", ComboBox.class);
    public static final AssetDescriptor<TextBox> PHONE3 = declare("Phone3", TextBox.class);
    public static final AssetDescriptor<ComboBox> PHONE_TYPE4 = declare("Phone Type4", ComboBox.class);
    public static final AssetDescriptor<TextBox> PHONE4 = declare("Phone4", TextBox.class);
    public static final AssetDescriptor<TextBox> SOCIAL_SECURITY_NUMBER_SSN = declare("Social Security Number (SSN)", TextBox.class);
    public static final AssetDescriptor<TextBox> DATE_OF_BIRTH = declare("Date of Birth", TextBox.class);
    public static final AssetDescriptor<TextBox> CURRENT_AGE = declare("Current Age", TextBox.class);
    public static final AssetDescriptor<ComboBox> GENDER = declare("Gender", ComboBox.class);
    public static final AssetDescriptor<ComboBox> MARITAL_STATUS = declare("Marital Status", ComboBox.class);
    public static final AssetDescriptor<ComboBox> PHONE_TYPE = declare("Phone Type", ComboBox.class);
    public static final AssetDescriptor<TextBox> PHONE = declare("Phone", TextBox.class);
    public static final AssetDescriptor<ComboBox> PHONE_TYPE5 = declare("Phone Type5", ComboBox.class);
    public static final AssetDescriptor<TextBox> PHONE5 = declare("Phone5", TextBox.class);
    public static final AssetDescriptor<TextBox> EMAIL = declare("Email", TextBox.class);
    public static final AssetDescriptor<TextBox> FAX = declare("Fax", TextBox.class);
    public static final AssetDescriptor<ComboBox> CONTACT_PREFERENCE = declare("Contact Preference", ComboBox.class);
    public static final AssetDescriptor<ComboBox> ADDRESS_TYPE = declare("Address Type", ComboBox.class);
    public static final AssetDescriptor<ComboBox> COUNTRY = declare("Country", ComboBox.class);
    public static final AssetDescriptor<TextBox> ZIP_POSTAL_CODE = declare("Zip / Postal Code", TextBox.class);
    public static final AssetDescriptor<TextBox> ADDRESS_LINE_1 = declare("Address Line 1", TextBox.class);
    public static final AssetDescriptor<TextBox> ADDRESS_LINE_2 = declare("Address Line 2", TextBox.class);
    public static final AssetDescriptor<TextBox> ADDRESS_LINE_3 = declare("Address Line 3", TextBox.class);
    public static final AssetDescriptor<TextBox> CITY = declare("City", TextBox.class);
    public static final AssetDescriptor<ComboBox> STATE_PROVINCE = declare("State / Province", ComboBox.class);
    public static final AssetDescriptor<TextBox> COUNTY = declare("County", TextBox.class);
    public static final AssetDescriptor<ComboBox> ASSOCIATED_INSURABLE_RISK = declare("Associated Insurable Risk", ComboBox.class);
    public static final AssetDescriptor<ComboBox> COVERAGE = declare("Coverage", ComboBox.class);
    public static final AssetDescriptor<ComboBox> TYPE_OF_BENEFICIARY = declare("Type of Beneficiary", ComboBox.class);
    public static final AssetDescriptor<TextBox> PERCENTAGE_OF_BENEFIT_DESIGNATION = declare("Percentage of Benefit Designation", TextBox.class);
    public static final AssetDescriptor<TextBox> AMOUNT_OF_BENEFIT_DESIGNATION = declare("Amount of Benefit Designation", TextBox.class);
    public static final AssetDescriptor<ComboBox> RETAINED_ASSET_ACCOUNT_APPROVED_BY_BENEFICIARY =
            declare("Retained Asset Account Approved by Beneficiary", ComboBox.class);
    public static final AssetDescriptor<ComboBox> PREFERRED_PAYMENT_METHOD = declare("Preferred Payment method", ComboBox.class);
    public static final AssetDescriptor<TextBox> PROOF_OF_LOSS_RECEIVED = declare("Proof of Loss Received", TextBox.class);

}
