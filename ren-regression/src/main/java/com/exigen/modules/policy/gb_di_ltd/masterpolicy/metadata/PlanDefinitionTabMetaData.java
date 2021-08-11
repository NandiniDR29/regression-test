/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.policy.gb_di_ltd.masterpolicy.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
import com.exigen.istf.webdriver.controls.CheckBox;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.common.pages.Page;
import org.openqa.selenium.By;

public class PlanDefinitionTabMetaData extends MetaData {
    public static final AssetDescriptor<AdvancedSelector> PLAN = declare("Plan", AdvancedSelector.class);
    public static final AssetDescriptor<ComboBox> COVERAGE_NAME = declare("Coverage Name", ComboBox.class);
    public static final AssetDescriptor<TextBox> PLAN_COMBOBOX = declare("Plan ComboBox", TextBox.class, By.id("policyDataGatherForm:sedit_GroupCoverageDefinitionCodeViewOnlyComponent_packageCd"));
    public static final AssetDescriptor<TextBox> PLAN_NAME = declare("Plan Name", TextBox.class);
    public static final AssetDescriptor<ComboBox> CENSUS_TYPE = declare("Census Type", ComboBox.class);
    public static final AssetDescriptor<TextBox> TOTAL_NUMBER_OF_ELIGIBLE_LIVES = declare("Total Number of Eligible Lives", TextBox.class);
    public static final AssetDescriptor<ComboBox> REQUIRED_PARTICIPATION = declare("Required Participation %", ComboBox.class);
    public static final AssetDescriptor<ComboBox> CONTRIBUTION_TYPE = declare("Contribution Type", ComboBox.class);
    public static final AssetDescriptor<ComboBox> ASSUMED_PARTICIPATION = declare("Assumed Participation %", ComboBox.class);
    public static final AssetDescriptor<ComboBox> ANNUAL_ENROLLMENT_UNDERWRITING_OFFER = declare("Annual Enrollment Underwriting Offer", ComboBox.class);

    public static final AssetDescriptor<AssetList> COVERAGE_INCLUDED_IN_PACKAGE = declare("Coverage Included in Package", AssetList.class, CoverageIncludedInPackageMetaData.class, false, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> SPONSOR_PARTICIPANT_FUNDING_STRUCTURE = declare("Sponsor/Participant Funding Structure", AssetList.class, SponsorParticipantFundingStructureMetaData.class, false, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> ELIGIBILITY = declare("Eligibility", AssetList.class, EligibilityMetaData.class, By.id("policyDataGatherForm:componentRegion_PreconfigGroupEligibility"));
    public static final AssetDescriptor<AssetList> RATING = declare("Rating", AssetList.class, RatingMetaData.class, By.id("policyDataGatherForm:componentRegion_GroupCoverageDefinitionRatingView"));
    public static final AssetDescriptor<AssetList> BENEFIT_SCHEDULE = declare("Benefit Schedule", AssetList.class, BenefitScheduleMetaData.class, false, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> GUARANTEED_ISSUE = declare("Guaranteed Issue", AssetList.class, GuaranteedIssueMetaData.class, false, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> OFFSETS = declare("Offsets", AssetList.class, OffsetsMetaData.class, false, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> SCHEDULE_OF_CONTINUATION_PROVISION = declare("Schedule of Continuation Provision", AssetList.class, ScheduleOfContinuationProvisionMetaData.class, false
            , By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> OPTIONS = declare("Options", AssetList.class, OptionsMetaData.class, false, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> BENEFIT_TERM_OPTION = declare("Benefit Termination Option", AssetList.class, BenefitTerminationOptionMetaData.class, false, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> EMPLOYER_BENEFITS = declare("Employer Benefits", AssetList.class, EmployerBenefitsMetaData.class, false, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));

    public static final class CoverageIncludedInPackageMetaData extends MetaData {
        public static final AssetDescriptor<CheckBox> STD = declare("STD", CheckBox.class);
        public static final AssetDescriptor<CheckBox> LIFE = declare("LIFE", CheckBox.class);
        public static final AssetDescriptor<CheckBox> DENTAL = declare("DENTAL", CheckBox.class);
        public static final AssetDescriptor<CheckBox> VISION = declare("VISION", CheckBox.class);
        public static final AssetDescriptor<CheckBox> STD_ADMINISTERED = declare("STD Administered?", CheckBox.class);
        public static final AssetDescriptor<ComboBox> INITIAL_ENROLLMENT_UNDERWRITING_OFFER = declare("Initial Enrollment Underwriting Offer", ComboBox.class);
        public static final AssetDescriptor<ComboBox> ANNUAL_ENROLLMENT_UNDERWRITING_OFFER = declare("Annual Enrollment Underwriting Offer", ComboBox.class);
    }

    public static final class SponsorParticipantFundingStructureMetaData extends MetaData {
        public static final AssetDescriptor<RadioGroup> SELF_ADMINISTERED = declare("Self-administered?", RadioGroup.class);
        public static final AssetDescriptor<RadioGroup> DIRECT_BILL = declare("Direct Bill", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> CONTRIBUTION_TYPE = declare("Contribution Type", ComboBox.class);
        public static final AssetDescriptor<TextBox> PARTICIPANT_CONTRIBUTION = declare("Participant Contribution %", TextBox.class);
        public static final AssetDescriptor<TextBox> MINIMUM_NUMBER_OF_PARTICIPANTS = declare("Minimum Number of Participants", TextBox.class);
        public static final AssetDescriptor<CheckBox> GROSS_UP = declare("Gross Up", CheckBox.class);
        public static final AssetDescriptor<ComboBox> TAXABILITY = declare("Taxability", ComboBox.class);
        public static final AssetDescriptor<RadioGroup> PREMIUM_PAID_POST_TAX = declare("Premium Paid-Post Tax", RadioGroup.class);
        public static final AssetDescriptor<AdvancedSelector> MEMBER_PAYMENT_MODE = declare("Member Payment Mode", AdvancedSelector.class);
        public static final AssetDescriptor<ComboBox> SPONSOR_PAYMENT_MODE = declare("Sponsor Payment Mode", ComboBox.class);
    }

    public static final class EligibilityMetaData extends MetaData {
        public static final AssetDescriptor<TextBox> MINIMUM_HOURLY_REQUIREMENT = declare("Minimum Hourly Requirement (hours per week)", TextBox.class);
        public static final AssetDescriptor<RadioGroup> WAITING_PERIOD_WAIVED_FOR_CURRENT_EMPLOYEES = declare("Waiting Period Waived For Current Employees?", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> ELIGIBILITY_WAITING_PERIOD_DEFINITION = declare("Eligibility Waiting Period Definition", ComboBox.class);
        public static final AssetDescriptor<TextBox> WAITING_PERIOD = declare("Waiting Period", TextBox.class);
        public static final AssetDescriptor<ComboBox> WAITING_PERIOD_MODE = declare("Waiting Period Mode", ComboBox.class);
    }

    public static final class RatingMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> RATE_BASIS = declare("Rate Basis", ComboBox.class);
        public static final AssetDescriptor<TextBox> SIC_CODE = declare("SIC Code", TextBox.class);
        public static final AssetDescriptor<TextBox> EXPERIENCE_CLAIM_AMOUNT = declare("Experience Claim Amount", TextBox.class);
        public static final AssetDescriptor<TextBox> CREDIBILITY_FACTOR = declare("Credibility Factor", TextBox.class);
    }

    public static final class BenefitScheduleMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> BENEFIT_TYPE = declare("Benefit Type", ComboBox.class);
        public static final AssetDescriptor<TextBox> MAX_MONTHLY_BENEFIT_AMOUNT = declare("Maximum Monthly Benefit Amount", TextBox.class);
        public static final AssetDescriptor<ComboBox> BENEFIT_PERCENTAGE = declare("Benefit Percentage", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MINIMUM_MONTHLY_BENEFIT_PERCENTAGE = declare("Minimum Monthly Benefit Percentage", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MINIMUM_MONTHLY_BENEFIT_AMOUNT = declare("Minimum Monthly Benefit Amount", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MAXIMUM_BENEFIT_PERIOD = declare("Maximum Benefit Period", ComboBox.class);
        public static final AssetDescriptor<ComboBox> ELIMINATION_PERIOD_DAYS = declare("Elimination Period (days)", ComboBox.class);
        public static final AssetDescriptor<ComboBox> DEFINITION_OF_DISABILITY = declare("Definition of Disability", ComboBox.class);
        public static final AssetDescriptor<ComboBox> TEST_DEFINITION = declare("Test Definition", ComboBox.class);
        public static final AssetDescriptor<ComboBox> NUMBER_OF_MONTH = declare("Number of Months", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RESIDUAL = declare("Residual", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PARTIAL_DISABILITY_BENEFIT = declare("Partial Disability Benefit", ComboBox.class);
        public static final AssetDescriptor<ComboBox> WIB_DURATION = declare("WIB Duration", ComboBox.class);
        public static final AssetDescriptor<ComboBox> OFFSET_PERCENT_AFTER_WIB_DURATION = declare("Offset % After WIB Duration", ComboBox.class);
        public static final AssetDescriptor<CheckBox> SPECIALTY_OWN_OCCUPATION = declare("Specialty Own Occupation", CheckBox.class);
        public static final AssetDescriptor<ComboBox> EARNING_DEFINITION = declare("Earning Definition", ComboBox.class);
        public static final AssetDescriptor<ComboBox> OWN_OCCUPATION_EARNINGS_TEST = declare("Own Occupation Earnings Test", ComboBox.class);
        public static final AssetDescriptor<ComboBox> ANY_OCCUPATION_EARNINGS_TEST = declare("Any Occupation Earnings Test", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PRE_EXISTING_CONDITIONS = declare("Pre-Existing Conditions", ComboBox.class, Waiters.DEFAULT);
        public static final AssetDescriptor<ComboBox> PRE_EXISTING_CONDITION_LOOK_BACK_PERIOD = declare("Pre-Existing Condition: Look Back Period", ComboBox.class, Waiters.DEFAULT, By.xpath("//select[@id='policyDataGatherForm:sedit_PreExistingConditions_lookBackPeriod']"));
        public static final AssetDescriptor<ComboBox> PRE_EXISTING_CONDITION_CONTINUOUSLY_INSURED_PERIOD = declare("Pre-Existing Condition: Continuously Insured Period", ComboBox.class, Waiters.DEFAULT);
        public static final AssetDescriptor<ComboBox> PRE_EXISTING_CONDITION_TREATMENT_FREE_PERIOD = declare("Pre-Existing Condition: Treatment Free Period", ComboBox.class, Waiters.DEFAULT);
        public static final AssetDescriptor<TextBox> TEMPORARY_RECOVERY_PERIODS_DURING_EP_DAYS = declare("Temporary Recovery Period During EP (days)", TextBox.class);
        public static final AssetDescriptor<TextBox> TEMPORARY_RECOVERY_PERIODS_AFTER_EP_MONTHS = declare("Temporary Recovery Period After EP (months)", TextBox.class);
        public static final AssetDescriptor<ComboBox> SUCCESSIVE_PERIOD_MONTHS = declare("Successive Period (Months)", ComboBox.class);
        public static final AssetDescriptor<TextBox> SURVIVOR_BENEFIT_WAITING_PERIOD = declare("Survivor Benefit Waiting Period", TextBox.class);
        public static final AssetDescriptor<ComboBox> SURVIVOR_FAMILY_INCOME_BENEFIT_TYPE = declare("Survivor - Family Income Benefit Type", ComboBox.class);
        public static final AssetDescriptor<CheckBox> PAY_SURVIVOR_BENEFIT_GROSS = declare("Pay Survivor Benefit Gross", CheckBox.class);
        public static final AssetDescriptor<CheckBox> ESTATE_PAYABLE = declare("Estate Payable", CheckBox.class);
    }

    public static final class OffsetsMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> SICK_LEAVE = declare("Sick Leave", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PTO = declare("PTO", ComboBox.class);
        public static final AssetDescriptor<ComboBox> COMPULSORY_STATE_PLANS = declare("Compulsory State Plans", ComboBox.class);
        public static final AssetDescriptor<ComboBox> TERMINATION_OR_SEVERANCE = declare("Termination/Severance", ComboBox.class);
        public static final AssetDescriptor<ComboBox> WORK_EARNINGS = declare("Work Earnings", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RETIREMENT_PLAN = declare("Retirement Plan", ComboBox.class);
        public static final AssetDescriptor<ComboBox> AUTO_LIABILITY = declare("Automobile Liability", ComboBox.class);
        public static final AssetDescriptor<RadioGroup> INCLUDE_PERS_AND_STRS = declare("Include PERS and STRS", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> THIRD_PARTY_SETTLEMENT = declare("3rd Party Settlement", ComboBox.class);
        public static final AssetDescriptor<ComboBox> INDIVIDUAL_DISABILITY_PLAN = declare("Individual Disability Plan", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SOCIAL_SECURITY_INTEGRATION_METHOD = declare("Social Security Integration Method", ComboBox.class);
        public static final AssetDescriptor<ComboBox> INTEGRATION_PERCENT = declare("Integration Percent", ComboBox.class);
    }

    public static final class ScheduleOfContinuationProvisionMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> FAMILY_MEDICAL_LEAVE = declare("Family & Medical Leave Act", ComboBox.class);
        public static final AssetDescriptor<ComboBox> LAYOFF_LEAVE_ABSENCE = declare("Layoff Leave of Absence", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MILITARY_LEAVE = declare("Military Leave", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MILITARY_LEAVE_DURATION = declare("Military Leave Duration", ComboBox.class);
        public static final AssetDescriptor<ComboBox> LEAVE_OF_ABSENCE = declare("Leave of Absence", ComboBox.class);
        public static final AssetDescriptor<ComboBox> LABOR_DISPUTE = declare("Labor Dispute", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SABBATICAL = declare("Sabbatical", ComboBox.class);
    }

    public static final class GuaranteedIssueMetaData extends MetaData {
        public static final AssetDescriptor<TextBox> GUARANTEED_ISSUE_AMT = declare("Guaranteed Issue Amount", TextBox.class);
    }

    public static final class OptionsMetaData extends MetaData {
        public static final AssetDescriptor<RadioGroup> PRUDENT_PERSON = declare("Prudent Person", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> REHABILITATION_INCENTIVE_BENEFIT = declare("Rehabilitation Incentive Benefit", ComboBox.class);
        public static final AssetDescriptor<ComboBox> REHABILITATION_INCENTIVE_BENEFIT_MAX_AMOUNT = declare("Rehabilitation Incentive Benefit Max Amount", ComboBox.class);
        public static final AssetDescriptor<ComboBox> REHABILITATION_INCENTIVE_BENEFIT_DURATION = declare("Rehabilitation Incentive Benefit Duration", ComboBox.class);
        public static final AssetDescriptor<ComboBox> REHABILITATION_INCENTIVE_BENEFIT_THRESHOLD = declare("Rehabilitation Incentive Benefit Threshold", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MENTAL_ILLNESS_LIMITATION = declare("Mental Illness Limitation", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SPECIAL_CONDITIONS_LIMITATION = declare("Special Conditions Limitation", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SUBSTANCE_ABUSE_LIMITATION = declare("Substance Abuse Limitation", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SELF_REPORTED_CONDITIONS_LIMITATION = declare("Self Reported Conditions Limitation", ComboBox.class);
        public static final AssetDescriptor<CheckBox> COMBINED_LIMIT = declare("Combined Limit", CheckBox.class);
        public static final AssetDescriptor<ComboBox> FAMILY_CARE_BENEFIT = declare("Family Care Benefit", ComboBox.class);
        public static final AssetDescriptor<ComboBox> FAMILY_CARE_BENEFIT_AMOUNT = declare("Family Care Benefit Amount - Per Family Member", ComboBox.class);
        public static final AssetDescriptor<ComboBox> FAMILY_CARE_BENEFIT_AMOUNT_DURATION = declare("Family Care Benefit Amount Duration", ComboBox.class);
        public static final AssetDescriptor<ComboBox> FAMILY_CARE_BENEFIT_MAXIMUM_ALL_FAMILY_MEMBERS = declare("Family Care Benefit Maximum - All Family Members", ComboBox.class);
        public static final AssetDescriptor<ComboBox> TERMINAL_ILLNESS_BENEFIT = declare("Terminal Illness Benefit", ComboBox.class);
        public static final AssetDescriptor<CheckBox> PAY_TERMINAL_ILLNESS_BENEFIT_GROSS = declare("Pay Terminal Illness Benefit Gross", CheckBox.class);
        public static final AssetDescriptor<TextBox> TERMINAL_ILLNESS_BENEFIT_WAITING_PERIOD = declare("Terminal Illness benefit waiting period", TextBox.class);
        public static final AssetDescriptor<ComboBox> COST_OF_LIVING_ADJUSTMENT_BENEFIT = declare("Cost of Living Adjustment Benefit", ComboBox.class);
        public static final AssetDescriptor<ComboBox> NUMBER_OF_ADJUSTMENTS = declare("Number of Adjustments", ComboBox.class);
        public static final AssetDescriptor<TextBox> COBRA_PREMIUM_REIMB_AMOUNT = declare("COBRA Premium Reimbursement Amount", TextBox.class);
        public static final AssetDescriptor<ComboBox> COBRA_PREMIUM_REIMB_DURATION = declare("COBRA Premium Reimbursement Duration", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RECOVERY_INCOME_BENEFIT = declare("Recovery Income Benefit", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RECOVERY_INCOME_PROTECTION_MAX = declare("Recovery Income Protection Max", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PRESUMPTIVE_DISABILITY = declare("Presumptive Disability", ComboBox.class);
        public static final AssetDescriptor<ComboBox> CATASTROPHIC_DISABILITY_BENEFIT = declare("Catastrophic Disability Benefit", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MAXIMUM_DOLLAR_AMOUNT = declare("Maximum Dollar Amount", ComboBox.class);
        public static final AssetDescriptor<ComboBox> INFECTIOUS_DISEASE = declare("Infectious Disease", ComboBox.class);
        public static final AssetDescriptor<ComboBox> INFECTIOUS_DISEASE_DURATION = declare("Infectious Disease Duration", ComboBox.class);
        public static final AssetDescriptor<ComboBox> CHILD_EDUCATION_BENEFIT = declare("Child Education Benefit", ComboBox.class);
        public static final AssetDescriptor<TextBox> BENEFIT_AMOUNT_PER_CHILD = declare("Benefit Amount per Child", TextBox.class);
        public static final AssetDescriptor<TextBox> MAXIMUM_MONTHLY_PAYMENTS = declare("Maximum Monthly Payments", TextBox.class);
        public static final AssetDescriptor<TextBox> BENEFIT_AMOUNT_FOR_ALL_CHILDREN = declare("Benefit Amount for all Children", TextBox.class);
        public static final AssetDescriptor<ComboBox> STUDENT_LOAN_REPAYMENT_AMOUNT = declare("Student Loan Repayment Amount", ComboBox.class);
        public static final AssetDescriptor<ComboBox> STUDENT_LOAN_REPAYMENT_DURATION = declare("Student Loan Repayment Duration", ComboBox.class);
        public static final AssetDescriptor<TextBox> ERISA_OPTION = declare("ERISA Option", TextBox.class);
        public static final AssetDescriptor<TextBox> ACCUMULATION_PERIOD = declare("Accumulation Period", TextBox.class);
        public static final AssetDescriptor<ComboBox> FOUR_HUNDRED_ONE_K_CONTRIBUTION_DURING_DISABILITY = declare("401K Contribution During Disability", ComboBox.class);
        public static final AssetDescriptor<TextBox> FOUR_HUNDRED_ONE_K_CONTRIBUTION_MONTHLY_MAXIMUM_AMOUNT = declare("401K Contribution Monthly Maximum Amount", TextBox.class);
        public static final AssetDescriptor<ComboBox> FICA_MATCH = declare("FICA Match", ComboBox.class);
        public static final AssetDescriptor<ComboBox> W_TWO = declare("W2", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MENTAL_ILLNESS_EVENT = declare("Mental Illness Event", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SUBSTANCE_ABUSE_EVENT = declare("Substance Abuse Event", ComboBox.class);
        public static final AssetDescriptor<ComboBox> NON_VERIFIABLE_SYMPTOMS_EVENT = declare("Non-Verifiable Symptoms Event", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SPECIAL_CONDITIONS_EVENT = declare("Special Conditions Event", ComboBox.class);
    }

    public static final class BenefitTerminationOptionMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> MANDATORY_WELLNESS = declare("Mandatory Wellness", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MANDATORY_REHAB = declare("Mandatory Rehabilitation", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RESIDE_OUTSIDE = declare("Reside Outside", ComboBox.class);
    }

    public static final class EmployerBenefitsMetaData extends MetaData {
        public static final AssetDescriptor<CheckBox> NONE = declare("None", CheckBox.class);
        public static final AssetDescriptor<CheckBox> OWNER = declare("Owner", CheckBox.class);
        public static final AssetDescriptor<CheckBox> SOLE_PROPRIETOR = declare("Sole proprietor", CheckBox.class);
        public static final AssetDescriptor<CheckBox> PARTNER = declare("Partner", CheckBox.class);
        public static final AssetDescriptor<CheckBox> SHAREHOLDER = declare("Shareholder", CheckBox.class);
        public static final AssetDescriptor<CheckBox> DIRECTOR = declare("Director", CheckBox.class);
        public static final AssetDescriptor<CheckBox> MANAGER = declare("Manager", CheckBox.class);
        public static final AssetDescriptor<ComboBox> REVENUE_PROTECTION_BENEFIT_MAXIMUM = declare("Revenue Protection Benefit Maximum", ComboBox.class);
        public static final AssetDescriptor<ComboBox> REVENUE_PROTECTION_BENEFIT_PERCENT = declare("Revenue protection benefit %", ComboBox.class);
        public static final AssetDescriptor<ComboBox> REVENUE_PROTECTION_BENEFIT_DURATION = declare("Revenue protection benefit duration", ComboBox.class);
        public static final AssetDescriptor<ComboBox> WORKPLACE_MODIFICATION_BENEFIT = declare("Workplace Modification Benefit", ComboBox.class);
        public static final AssetDescriptor<TextBox> WORKPLACE_MODIFICATION_BENEFIT_PERCENT = declare("Workplace modification benefit %", TextBox.class);
        public static final AssetDescriptor<TextBox> WORKPLACE_MODIFICATION_BENEFIT_MAXIMUM = declare("Workplace modification benefit Maximum", TextBox.class);
    }
}
