package com.exigen.ren.main.modules.policy.common.metadata.master;

import com.exigen.istf.webdriver.controls.*;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;

public class PolicyInfoEndorseNPBInfoActionTabMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> QUOTE_CREATION_DATE = declare("Quote Creation Date", TextBox.class);
    public static final AssetDescriptor<TextBox> QUOTE_EXPIRATION_DATE = declare("Quote Expiration Date", TextBox.class);
    public static final AssetDescriptor<RadioGroup> ASO_PLAN = declare("ASO Plan", RadioGroup.class);
    public static final AssetDescriptor<ComboBox> UNDEWRITING_COMPANY = declare("Underwriting Company", ComboBox.class);
    public static final AssetDescriptor<RadioGroup> GROUP_IS_MEMBER_COMPANY = declare("Group is Member Company", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> SHORT_TERM = declare("Short Term", RadioGroup.class);
    public static final AssetDescriptor<TextBox> POLICY_EFFECTIVE_DATE = declare("Policy Effective Date", TextBox.class);
    public static final AssetDescriptor<TextBox> CURRENT_POLICY_YEAR_START_DATE = declare("Current Policy Year Start Date", TextBox.class);
    public static final AssetDescriptor<TextBox> NEXT_POLICY_YEAR_START_DATE = declare("Next Policy Year Start Date", TextBox.class);
    public static final AssetDescriptor<RadioGroup> USE_POLICY_TERM = declare("Use Policy Term?", RadioGroup.class);
    public static final AssetDescriptor<ComboBox> CURRENCY = declare("Currency", ComboBox.class);
    public static final AssetDescriptor<TextBox> RATE_GUARANTEE_MONTHS = declare("Rate Guarantee (Months)", TextBox.class);
    public static final AssetDescriptor<TextBox> NEXT_RENEWAL_EFFECTIVE_DATE = declare("Next Renewal Effective Date", TextBox.class);
    public static final AssetDescriptor<TextBox> NEXT_RENEWAL_QUOTE_START_DATE = declare("Next Renewal Quote Start Date", TextBox.class);
    public static final AssetDescriptor<ComboBox> COUNTRY = declare("Country", ComboBox.class);
    public static final AssetDescriptor<TextBox> RENEWAL_NOTIFICATION_DAYS = declare("Renewal Notification Days", TextBox.class);
    public static final AssetDescriptor<ComboBox> DELIVERY_MODEL = declare("Delivery Model", ComboBox.class);
    public static final AssetDescriptor<ComboBox> SITUS_STATE = declare("Situs State", ComboBox.class);
    public static final AssetDescriptor<TextBox> TOTAL_NUMBER_OF_ELIGIBLE_LIVES = declare("Total Number of Eligible Lives", TextBox.class);
    public static final AssetDescriptor<TextBox> ZIP_CODE = declare("Zip Code", TextBox.class);
    public static final AssetDescriptor<RadioGroup> GROUP_IS_AN_ASSOCIATION = declare("Group is an Association?", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> ALLOW_INDEPENDENT_COMMISSIONABLE_PRODUCERS = declare("Allow Independent Commissionable Producers?", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> BLEND_DEMOGRAPHICS = declare("Blend Demographics", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> HAS_CONTINUITY_OF_COVERAGE = declare("Has Continuity of Coverage?", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> UNDER_FIFTY_LIVES = declare("Under 50 Lives?", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> FIRST_TIME_BUYER = declare("First Time Buyer?", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> SMALL_GROUP = declare("Small Group?", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> SMALL_GROUP_AC = declare("Small group?", RadioGroup.class);
    public static final AssetDescriptor<CheckBox> PRIOR_CLAIMS_ALLOWED = declare("Prior Claims Allowed?", CheckBox.class);
    public static final AssetDescriptor<TextBox> PRIOR_CLAIMS_RETROACTIVE_EFFECTIVE_DATE = declare("Prior Claims Retroactive Effective Date", TextBox.class);
    public static final AssetDescriptor<TextBox> MINIMUM_PARTICIPATION_PERCENTAGE = declare("Minimum Participation Percentage", TextBox.class);
    public static final AssetDescriptor<TextBox> MINIMUM_NUMBER_OF_PARTICIPANTS = declare("Minimum Number of Participants", TextBox.class);
    public static final AssetDescriptor<TextBox> MAXIMUM_NUMBER_OF_PARTICIPANTS = declare("Maximum Number of Participants", TextBox.class);
    public static final AssetDescriptor<RadioGroup> USE_EXPERIENCE_RATING = declare("Use Experience Rating ?", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> SEPARATE_OR_COMBINED_EXPERIENCE_RATING = declare("Separate Or Combined Experience Rating?", RadioGroup.class);
    public static final AssetDescriptor<ComboBox> AGING_FREQUENCY = declare("Aging Frequency", ComboBox.class);
    public static final AssetDescriptor<RadioGroup> UNDER_FIFTY_LIVES_WORKFLOW = declare("Under 50 Lives Workflow?", RadioGroup.class);
    public static final AssetDescriptor<DoubleComboBox> ANNIVERSARY_DAY = declare("Anniversary Day", DoubleComboBox.class, By.id("policyDataGatherForm:formGrid_GroupMasterAnniversary"));
    public static final AssetDescriptor<RadioGroup> PRIOR_DENTAL_COVERAGE = declare("Prior Dental Coverage", RadioGroup.class);
    public static final AssetDescriptor<TextBox> ANNUAL_ANNIVERSARY_DAY = declare("Annual Anniversary Date", TextBox.class);

    public static final AssetDescriptor<ComboBox> COUNTY_CODE = declare("County Code", ComboBox.class, Waiters.DEFAULT);
    public static final AssetDescriptor<ComboBox> PRIOR_CARRIER_NAME = declare("Prior Carrier Name Combo", ComboBox.class, By.id("policyDataGatherForm:sedit_Policy_priorCarrierName"));
    public static final AssetDescriptor<RadioGroup> PRIOR_LIFE_COVERAGE = declare("Prior Life Coverage", RadioGroup.class);
    public static final AssetDescriptor<TextBox> PRIOR_CARRIER_NAME_TEXT_BOX = declare("Prior Carrier Name", TextBox.class);
    public static final AssetDescriptor<TextBox> PRIOR_CARRIER_POLICY_NUMBER = declare("Prior Carrier Policy Number", TextBox.class);
    public static final AssetDescriptor<ComboBox> DEDUCTION_BY_PAY_PERIOD = declare("Deduction by Pay Period", ComboBox.class);

    public static final AssetDescriptor<ComboBox> RENEWAL_FREQUENCY = declare("Renewal Frequency", ComboBox.class);
    public static final AssetDescriptor<TextBox> POLICY_TERM = declare("Policy Term", TextBox.class);
    public static final AssetDescriptor<ComboBox> MEMBER_COMPANY_NAME = declare("Member Company Name", ComboBox.class);
    public static final AssetDescriptor<ComboBox> NAME_TO_DISPLAY_ON_MP_DOCUMENTS = declare("Name to Display on Master Policy Documents", ComboBox.class);
}
