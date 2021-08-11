/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.gb_ltd_st_std.metadata;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.tabs.BenefitsLTDInjuryPartyInformationTab;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.tabs.BenefitsLTDInjuryPartyInformationTab.ParticipantIndexedPreDisabilityEarnings;
import org.openqa.selenium.By;

public class BenefitsLTDInjuryPartyInformationTabMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> ASSOCIATE_POLICY_PARTY = declare("Associate Policy Party", ComboBox.class);
    public static final AssetDescriptor<ComboBox> RELATIONSHIP_TO_PARTICIPANT = declare("Relationship To Participant", ComboBox.class);
    public static final AssetDescriptor<TextBox> DESCRIPTION_OF_RELATIONSHIP_TO_INSURED = declare("Description of Relationship to Insured", TextBox.class);
    public static final AssetDescriptor<ComboBox> PREFIX = declare("Prefix", ComboBox.class);
    public static final AssetDescriptor<TextBox> FIRST_NAME = declare("First Name", TextBox.class);
    public static final AssetDescriptor<TextBox> MIDDLE_NAME = declare("Middle Name", TextBox.class);
    public static final AssetDescriptor<TextBox> LAST_NAME = declare("Last Name", TextBox.class);
    public static final AssetDescriptor<ComboBox> SUFFIX = declare("Suffix", ComboBox.class);
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
    public static final AssetDescriptor<ComboBox> PREFERED_PAYMENT_METHOD = declare("Preferred Payment method", ComboBox.class);
    public static final AssetDescriptor<ComboBox> ADDRESS_TYPE = declare("Address Type", ComboBox.class);
    public static final AssetDescriptor<ComboBox> COUNTRY = declare("Country", ComboBox.class);
    public static final AssetDescriptor<TextBox> ZIP_POSTAL_CODE = declare("Zip / Postal Code", TextBox.class);
    public static final AssetDescriptor<TextBox> ADDRESS_LINE_1 = declare("Address Line 1", TextBox.class);
    public static final AssetDescriptor<TextBox> ADDRESS_LINE_2 = declare("Address Line 2", TextBox.class);
    public static final AssetDescriptor<TextBox> ADDRESS_LINE_3 = declare("Address Line 3", TextBox.class);
    public static final AssetDescriptor<TextBox> CITY = declare("City", TextBox.class);
    public static final AssetDescriptor<ComboBox> STATE_PROVINCE = declare("State / Province", ComboBox.class);
    public static final AssetDescriptor<TextBox> COUNTY = declare("County", TextBox.class);
    public static final AssetDescriptor<ComboBox> ASSOCIATED_SCHEDULED_ITEM = declare("Associated Scheduled Item", ComboBox.class);
    public static final AssetDescriptor<TextBox> ESTIMATED_COST_VALUE = declare("Estimated Cost/Value", TextBox.class);
    public static final AssetDescriptor<TextBox> REPORTED_EXPENSE_AMOUNT = declare("Reported Expense Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> COVERED_EARNINGS = declare("Covered Earnings", TextBox.class);
    public static final AssetDescriptor<Button> ADD_PARTICIPANT_INDEXED = declare("Add Coverage", Button.class, By.id("policyDataGatherForm:addRenClaimsLTDIndexedPreDisabilityEarnings"));
    public static final AssetDescriptor<Button> REMOVE_PARTICIPANT_INDEXED = declare("Remove Coverage", Button.class, By.id("policyDataGatherForm:eliminateRenClaimsLTDIndexedPreDisabilityEarnings"));

    public static final AssetDescriptor<ParticipantIndexedPreDisabilityEarnings> PARTICIPANT_INDEXED_PRE_DISABILITY_EARNINGS =
            declare("Participant Indexed Pre-Disability Earnings", ParticipantIndexedPreDisabilityEarnings.class, ParticipantIndexedPreDisabilityEarningsMetaData.class);

    public static final AssetDescriptor<BenefitsLTDInjuryPartyInformationTab.YTDTaxableWageMultiAssetList> YTD_TAXABLE_WAGE =
            declare("YTD Taxable Wage", BenefitsLTDInjuryPartyInformationTab.YTDTaxableWageMultiAssetList.class, YTDTaxableWageMetaData.class, By.id("policyDataGatherForm:formGrid_LTDPartyYTDTaxableWage"));

    public static final class YTDTaxableWageMetaData extends MetaData {
        public static final AssetDescriptor<TextBox> ID = declare("ID", TextBox.class);
        public static final AssetDescriptor<TextBox> YTD_TAXABLE_WAGE = declare("YTD Taxable Wage", TextBox.class);
        public static final AssetDescriptor<TextBox> YEAR = declare("Year", TextBox.class);
        public static final AssetDescriptor<ComboBox> BILLING_LOCATION = declare("Billing Location", ComboBox.class);
    }

    public static final class ParticipantIndexedPreDisabilityEarningsMetaData extends MetaData {
        public static final AssetDescriptor<TextBox> YEAR_NO = declare("Year No.", TextBox.class);
        public static final AssetDescriptor<TextBox> YEAR_START_DATE = declare("Year Start Date (MM/DD/YYYY)", TextBox.class);
        public static final AssetDescriptor<TextBox> YEAR_END_DATE = declare("Year End Date (MM/DD/YYYY)", TextBox.class);
        public static final AssetDescriptor<TextBox> INDEXED_PRE_DISABILITY_EARNINGS = declare("Indexed Pre-Disability Earnings", TextBox.class);
    }
}