/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.policy.gb_eap.masterpolicy.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
import com.exigen.istf.webdriver.controls.CheckBox;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.common.pages.Page;
import org.openqa.selenium.By;

public class PlanDefinitionTabMetaData extends MetaData {
    public static final AssetDescriptor<AdvancedSelector> PLAN = declare("Plan", AdvancedSelector.class);
    public static final AssetDescriptor<TextBox> PLAN_TEXTBOX = declare("Plan Textbox", TextBox.class, By.id("policyDataGatherForm:sedit_GroupCoverageDefinitionCodeViewOnlyComponent_packageCd"));
    public static final AssetDescriptor<TextBox> PLAN_NAME = declare("Plan Name", TextBox.class);
    public static final AssetDescriptor<ComboBox> REQUIRED_PARTICIPATION = declare("Required Participation %", ComboBox.class);
    public static final AssetDescriptor<ComboBox> ASSUMED_PARTICIPATION = declare("Assumed Participation %", ComboBox.class);
    public static final AssetDescriptor<TextBox> TOTAL_NUMBER_OF_ELIGIBLE_LIVES = declare("Total Number of Eligible Lives", TextBox.class);
    public static final AssetDescriptor<ComboBox> INITIAL_ENROLLMENT_UNDERWRITING_OFFER = declare("Initial Enrollment Underwriting Offer", ComboBox.class);
    public static final AssetDescriptor<ComboBox> ANNUAL_ENROLLMENT_UNDERWRITING_OFFER = declare("Annual Enrollment Underwriting Offer", ComboBox.class);
    public static final AssetDescriptor<ComboBox> UNDERWRITING_OFFER_FOR_QUALIFYING_LIFE_EVENT = declare("Underwriting Offer for Qualifying Life Event", ComboBox.class);
    public static final AssetDescriptor<ComboBox> COVERAGE_NAME = declare("Coverage Name", ComboBox.class);
    public static final AssetDescriptor<ComboBox> PLAN_COMBOBOX = declare("Plan Combobox", ComboBox.class, By.id("policyDataGatherForm:sedit_GroupCoverageDefinitionCodeViewOnlyComponent_packageCd"));
    public static final AssetDescriptor<AssetList> COVERAGE_INCLUDED_IN_PACKAGE = declare("Coverage Included in Package", AssetList.class, CoverageIncludedInPackageMetaData.class, false, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));


    public static final class CoverageIncludedInPackageMetaData extends MetaData {
        public static final AssetDescriptor<CheckBox> STD = declare("STD", CheckBox.class);
        public static final AssetDescriptor<CheckBox> LTD = declare("LTD", CheckBox.class);
        public static final AssetDescriptor<CheckBox> LIFE = declare("LIFE", CheckBox.class);
        public static final AssetDescriptor<CheckBox> DENTAL = declare("DENTAL", CheckBox.class);
        public static final AssetDescriptor<CheckBox> VISION = declare("VISION", CheckBox.class);
    }

    public static final AssetDescriptor<AdvancedSelector> COVERAGE_TIERS = declare("Coverage Tiers", AdvancedSelector.class);

    public static final AssetDescriptor<TextBox> MINIMUM_NUMBER_OF_PARTICIPANTS = declare("Minimum Number of Participants", TextBox.class);
    public static final AssetDescriptor<ComboBox> TAXABILITY = declare("Taxability", ComboBox.class);
    public static final AssetDescriptor<AdvancedSelector> MEMBER_PAYMENT_MODE = declare("Member Payment Mode", AdvancedSelector.class);

    public static final AssetDescriptor<ComboBox> RATE_GUARANTEE = declare("Rate Guarantee", ComboBox.class);
    public static final AssetDescriptor<ComboBox> FACE_AMOUNT_SPAUSE = declare("Face Amount - Spouse", ComboBox.class);
    public static final AssetDescriptor<ComboBox> CORONARY_ARTERY_BYPASS_SURGERY = declare("Coronary Artery Bypass Surgery", ComboBox.class);

    public static final AssetDescriptor<TextBox> STAT_OFFSET_AMOUNT = declare("STAT Offset Amount", TextBox.class);
    public static final AssetDescriptor<ComboBox> SICK_LEAVE = declare("Sick Leave", ComboBox.class);
    public static final AssetDescriptor<ComboBox> PTO = declare("PTO", ComboBox.class);
    public static final AssetDescriptor<ComboBox> TERMINATION_SEVERANCE = declare("Termination/Severance", ComboBox.class);
    public static final AssetDescriptor<ComboBox> WORK_EARNINGS = declare("Work Earnings", ComboBox.class);
    public static final AssetDescriptor<ComboBox> RETIREMENT_PLAN = declare("Retirement Plan", ComboBox.class);
    public static final AssetDescriptor<ComboBox> AUTOMOBILE_LIABILITY = declare("Automobile Liability", ComboBox.class);
    public static final AssetDescriptor<ComboBox> THIRD_PARTY_SETTLEMENT = declare("3rd Party Settlement", ComboBox.class);
    public static final AssetDescriptor<ComboBox> INDIVIDUAL_DISABILITY_PLAN = declare("Individual Disability Plan", ComboBox.class);
    public static final AssetDescriptor<ComboBox> UNEMPLOYMENT = declare("Unemployment", ComboBox.class);
    public static final AssetDescriptor<ComboBox> WORKERS_COMPENSATION = declare("Workers Compensation", ComboBox.class);
    public static final AssetDescriptor<ComboBox> ASSOCIATION_PLANS = declare("Association Plans", ComboBox.class);
    public static final AssetDescriptor<ComboBox> GOVERNMENTAL_RETIREMENT = declare("Governmental Retirement", ComboBox.class);

    public static final AssetDescriptor<AssetList> BENEFIT_SCHEDULE = declare("Benefit Schedule", AssetList.class, BenefitScheduleMetaData.class, false, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> SCHEDULE_OF_CONTINUATION_PROVISION = declare("Schedule of Continuation Provision", AssetList.class, ScheduleOfContinuationProvisionMetaData.class, By.id("policyDataGatherForm:componentView_PreconfigGroupContinuations"));
    public static final AssetDescriptor<AssetList> OPTIONS = declare("Options", AssetList.class, OptionsMetaData.class,
            By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> SPONSOR_PARTICIPANT_FUNDING_STRUCTURE = declare("Sponsor/Participant Funding Structure", AssetList.class, SponsorParticipantFundingStructureMetaData.class, false, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> BENEFIT_TERM_OPTION = declare("Benefit Termination Option", AssetList.class, BenefitTerminationOptionMetaData.class, false, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> ELIGIBILITY = declare("Eligibility", AssetList.class, EligibilityMetaData.class, false, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> RATING = declare("Rating", AssetList.class, RatingMetaData.class,
            By.xpath("//div[@id='policyDataGatherForm:componentView_GroupCoverageDefinitionRatingView']"));


    public static final class BenefitScheduleMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> BENEFIT_TYPE = declare("Benefit Type", ComboBox.class);
        public static final AssetDescriptor<ComboBox> BENEFIT_PERCENTAGE = declare("Benefit Percentage", ComboBox.class);
        public static final AssetDescriptor<TextBox> WEEKLY_BENEFIT_AMOUNT = declare("Weekly Benefit Amount", TextBox.class);
        public static final AssetDescriptor<TextBox> MAXIMUM_WEEKLY_BENEFIT_AMOUNT = declare("Maximum Weekly Benefit Amount", TextBox.class);
        public static final AssetDescriptor<ComboBox> PARTIAL_DISABILITY = declare("Partial Disability", ComboBox.class);
        public static final AssetDescriptor<ComboBox> EARNING_TEST = declare("Earning Test", ComboBox.class);
        public static final AssetDescriptor<TextBox> MAXIMUM_PAYMENT_DURATION = declare("Maximum Payment Duration", TextBox.class);
        public static final AssetDescriptor<ComboBox> TEST_DEFINITION = declare("Test Definition", ComboBox.class);
        public static final AssetDescriptor<ComboBox> DEFINITION_OF_DISABILITY = declare("Definition of Disability", ComboBox.class);
        public static final AssetDescriptor<TextBox> MAXIMUM_BENEFIT_PERIOD_INCLUDING_EP = declare("Maximum Benefit period Including EP", TextBox.class);
        public static final AssetDescriptor<RadioGroup> END_OF_SALARY_CONTINUATION = declare("End of Salary Continuation", RadioGroup.class);
        public static final AssetDescriptor<RadioGroup> END_OF_ACCUMULATED_SICK_LEAVE = declare("End of Accumulated Sick Leave", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> MINIMUM_WEEKLY_BENEFIT_AMOUNT = declare("Minimum Weekly Benefit Amount", ComboBox.class);
        public static final AssetDescriptor<ComboBox> EARNING_DEFINITION = declare("Earning Definition", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PRE_EXISTING_CONDITIONS = declare("Pre-Existing Conditions", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PRE_EXISTING_CONDITION_LOOK_BACK_PERIOD = declare("Pre-Existing Condition: Look Back Period", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PRE_EXISTING_CONDITION_TREATMENT_FREE_PERIOD = declare("Pre-Existing Condition: Treatment Free Period", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PRE_EXISTING_CONDITION_CONTINUOUSLY_INSURED_PERIOD = declare("Pre-Existing Condition: Continuously Insured Period", ComboBox.class);
        public static final AssetDescriptor<ComboBox> ELIMINATION_PERIOD_INJURY = declare("Elimination Period - Injury (Calendar Days)", ComboBox.class);
        public static final AssetDescriptor<ComboBox> ELIMINATION_PERIOD_SICKNESS = declare("Elimination Period - Sickness (Calendar Days)", ComboBox.class);
        public static final AssetDescriptor<TextBox> RTW_DURING_EP = declare("RTW during EP", TextBox.class);
        public static final AssetDescriptor<ComboBox> RESIDUAL = declare("Residual", ComboBox.class);
        public static final AssetDescriptor<ComboBox> WIB_DURATION = declare("WIB Duration", ComboBox.class);
    }

    public static final class SponsorParticipantFundingStructureMetaData extends MetaData {
        public static final AssetDescriptor<RadioGroup> SELF_ADMINISTERED = declare("Self-administered?", RadioGroup.class);
        public static final AssetDescriptor<RadioGroup> DIRECT_BILL = declare("Direct Bill", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> CONTRIBUTION_TYPE = declare("Contribution Type", ComboBox.class);
        public static final AssetDescriptor<TextBox> PARTICIPANT_CONTRIBUTION = declare("Participant Contribution %", TextBox.class);
        public static final AssetDescriptor<ComboBox> SPONSOR_PAYMENT_MODE = declare("Sponsor Payment Mode", ComboBox.class);
    }

    public static final class BenefitTerminationOptionMetaData extends MetaData {
        public static final AssetDescriptor<RadioGroup> LTD_EP_COMPLETION = declare("Completion of LTD EP", RadioGroup.class);
        public static final AssetDescriptor<RadioGroup> MANDATORY_REHAB = declare("Mandatory Rehabilitation", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> RESIDE_OUTSIDE = declare("Reside Outside", ComboBox.class);
    }

    public static final class RatingMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> RATE_BASIS = declare("Rate Basis", ComboBox.class);
        public static final AssetDescriptor<TextBox> EXPERIENCE_CLAIM_AMOUNT = declare("Experience Claim Amount", TextBox.class);
        public static final AssetDescriptor<TextBox> CREDIBILITY_FACTOR = declare("Credibility Factor", TextBox.class);
        public static final AssetDescriptor<TextBox> SIC_CODE = declare("SIC Code", TextBox.class);
        public static final AssetDescriptor<ComboBox> PLAN_TYPE = declare("Plan Type", ComboBox.class);
    }

    public static final class ScheduleOfContinuationProvisionMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> FAMILY_AND_MEDICAL_LEAVE_ACT = declare("Family & Medical Leave Act", ComboBox.class);
        public static final AssetDescriptor<ComboBox> LAYOFF = declare("Layoff", ComboBox.class);
        public static final AssetDescriptor<ComboBox> LEAVE_OF_ABSENCE_NON_MEDICAL = declare("Leave of Absence (Non-Medical)", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MILITARY_LEAVE = declare("Military Leave", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MILITARY_LEAVE_DURATION = declare("Military Leave Duration", ComboBox.class);
        public static final AssetDescriptor<ComboBox> LABOR_DISPUTE = declare("Labor Dispute", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SABBATICAL = declare("Sabbatical", ComboBox.class);
    }

    public static final class OptionsMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> FIRST_DAY_HOSPITALIZATION = declare("First Day Hospitalization", ComboBox.class);
        public static final AssetDescriptor<ComboBox> REHABILITATION_INCENTIVE_BENEFIT = declare("Rehabilitation Incentive Benefit", ComboBox.class);
        public static final AssetDescriptor<ComboBox> REHABILITATION_BENEFIT_MAXIMUM_AMOUNT = declare("Rehabilitation Benefit Maximum Amount", ComboBox.class);
        public static final AssetDescriptor<RadioGroup> PRUDENT_PERSON = declare("Prudent Person", RadioGroup.class);
        public static final AssetDescriptor<TextBox> TEMP_RECOVERY_PERIOD_DAYS = declare("Temporary Recovery Period (days)", TextBox.class);
        public static final AssetDescriptor<ComboBox> PREMIUM_WAIVER = declare("Premium Waiver", ComboBox.class);
        public static final AssetDescriptor<ComboBox> ERISA_OPTION = declare("ERISA Option", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RESIDUAL = declare("Residual", ComboBox.class);
        public static final AssetDescriptor<ComboBox> W2 = declare("W2", ComboBox.class);
    }

    public static final class EligibilityMetaData extends MetaData {
        public static final AssetDescriptor<TextBox> MINIMUM_HOURLY_REQUIREMENT_HOURS_PER_WEEK = declare("Minimum Hourly Requirement (hours per week)", TextBox.class);
        public static final AssetDescriptor<RadioGroup> WAITING_PERIOD_WAIVED_FOR_CURRENT_EMPLOYEE = declare("Waiting Period Waived For Current Employees?", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> ELIGIBILITY_WAITING_PERIOD_DEFINITION = declare("Eligibility Waiting Period Definition", ComboBox.class);
        public static final AssetDescriptor<TextBox> WAITING_PERIOD_DEFINITION = declare("Waiting Period", TextBox.class);
        public static final AssetDescriptor<ComboBox> WAITING_PERIOD_MODE_DEFINITION = declare("Waiting Period Mode", ComboBox.class);
    }
}

