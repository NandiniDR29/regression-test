/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.enums;

import com.google.common.collect.ImmutableList;

public final class PolicyConstants {

    private PolicyConstants() {
    }

    public static final class PremiumWaiverErrorMessages {
        public static final String PREMIUM_WAIVER_START_DATE_IS_REQUIRED = "'Premium Waiver Start Date' is required";
        public static final String PREMIUM_WAIVER_START_DATE_DOES_NOT_FALL = "Premium Waiver Start Date does not fall in between " +
                "the Effective Date of the first Certificate Policy term and Expiration Date of the last Certificate Policy term.";
        public static final String PREMIUM_WAIVER_START_DATE_CANNOT_BE_APPLIED = "Premium Waiver Start Date cannot be applied on the " +
                "former Premium Waiver effective days.";
        public static final String PREMIUM_WAIVER_START_DATE_CANNOT_BE_AFTER_POLICY_CANCELLATION_DATE = "Premium Waiver Start Date cannot" +
                " be after the Policy Cancellation Date";
        public static final String PREMIUM_WAIVER_START_DATE_MUST_BE_FALL_IN_THE_CERTIFICATE_TERM = "Premium Waiver Start Date must fall in the" +
                " Certificate Policy term where status is Policy Active, Policy Pending or Cancellation Pending";

        public static final String PREMIUM_WAIVER_END_DATE_DOES_NOT_FALL = "Premium Waiver End Date does not fall in between the Effective" +
                " Date of the first Certificate Policy term and Expiration Date of the last Certificate Policy term.";
        public static final String PREMIUM_WAIVER_END_DATE_IS_REQUIRED = "'Premium Waiver End Date' is required";
        public static final String PREMIUM_WAIVER_END_DATE_IS_CANNOT_BE_PRIOR_THE_START_DATE = "Premium Waiver End Date cannot be prior the Premium Waiver " +
                "Start Date";
        public static final String REMOVE_WAIVER_END_DATE_CANNOT_BE_AFTER_POLICY_CANCELLATION_DATE = "Premium Waiver End Date cannot be after" +
                " the Policy Cancellation Date";
        public static final String PREMIUM_WAIVER_END_DATE_DOES_NOT_FALL_IN_THE_CERTIFICATE_TERM =
                "Premium Waiver End Date does not fall in between the Effective Date of the first Certificate Policy term and Expiration Date of the last Certificate Policy term";
    }

    public static final class PremiumWaiverConfirmationPopUp {
        public static final String ARE_YOU_SURE_WANT_TO_ADD_PREMIUM_WAIVER = "Are you sure you want to add Premium Waiver to Certificate Policy?";
        public static final String ARE_YOU_SURE_WANT_TO_REMOVE_PREMIUM_WAIVER = "Are you sure you want to remove Premium Waiver from Certificate Policy?";
    }

    public static final class PlanTermLifeInsurance {
        public static final String BASIC_LIFE_PLAN = "Basic Life";
        public static final String VOLUNTARY_LIFE_PLAN = "Voluntary Life";
        public static final String BASIC_LIFE_PLAN_PLUS_VOLUNTARY = "Basic Life + Voluntary";
        public static final String BASIC_LIFE_PLAN_PLUS_VOLUNTARY_CLASSIC = "Basic Life + Voluntary Classic";
        public static final String VOLUNTEER_FIRE_FIGHTERS = "Volunteer Fire Fighters";
    }

    public static final class PlanDental {
        public static final String ALACARTE = "A La Carte";
        public static final String BASEPOS = "Basic EPOS";
        public static final String MAJEPOS = "Major EPOS";
        public static final String FLEX_PLUS = "Flex Plus";
        public static final String GRADUATED = "Graduated";
        public static final String ASO = "ASO";
        public static final String ASOALC = "ASO A La Carte";
        public static final String HIGH = "ASO-HIGH";
        public static final String LOW = "ASO-ALA-LOW";

        public static final String DHMO = "DHMO";
        public static final String TRIP_ADVANTAGE = "Triple Advantage";
    }

    public static final class PlanVision {
        public static final String A_LA_CARTE = "A La Carte";
        public static final String EXAM_PLUS = "Exam Plus";
        public static final String PlanB = "10/25 Plan B 130";
        public static final String PlanC = "10/25 Plan C 150";
        public static final String ASOALC_VIS = "ASO A La Carte";
        public static final String ASO_PLANB = "ASO Plan B";
    }

    public static final class PackagedCdCodeAndPlanVision {
        public static final String A_LA_CARTE = "ALACARTE-A La Carte";
        public static final String PlanB = "PlanB-10/25 Plan B 130";
        public static final String PlanC = "PlanC-10/25 Plan C 150";
        public static final String ASOALC_VIS = "ASOALACARTE-ASO A La Carte";
        public static final String ASO_PLANB = "ASOPlanB-ASO Plan B";
    }

    public static final class PlanAccident {
        public static final String ENHANCED_10_UNITS = "Enhanced 10 Units";
        public static final String BASE_BUY_UP = "Base Buy-Up";
        public static final String VOLUNTARY_10_UNITS = "Voluntary 10 Units";
    }

    public static final class PlanSelectionValues {
        public static final String PLAN_ALACARTE = "ALACARTE-A La Carte";
        public static final String PLAN_BASEPOS = "BASEPOS-Basic EPOS";
        public static final String PLAN_MAJEPOS = "MAJEPOS-Major EPOS";
        public static final String PLAN_FLEX_PLUS = "FLEX-Flex Plus";
        public static final String PLAN_GRAD_GRADUATED = "GRAD-Graduated";
        public static final String PLAN_DHMO = "DHMO-DHMO";
        public static final String PLAN_TRIPLE_ADVANTAGE = "TRIPADV-Triple Advantage";
        public static final String PLAN_WA_ONE = "WA1-WA Plan 1";
        public static final String PLAN_WA_TWO = "WA2-WA Plan 2";
        public static final String PLAN_WA_THREE = "WA3-WA Plan 3";
        public static final String PLAN_WA_FOUR = "WA4-WA Plan 4";
        public static final String PLAN_WA_FIVE = "WA5-WA Plan 5";
        public static final String PLAN_WA_SIX = "WA6-WA Plan 6";
        public static final String PLAN_WA_SEVEN = "WA7-WA Plan 7";
        public static final String PLAN_WA_EIGHT = "WA8-WA Plan 8";
        public static final String PLAN_WA_NINE = "WA9-WA Plan 9";
        public static final String PLAN_ASO = "ASO-ASO";
        public static final String ASOALC_ASO_ALACARTE = "ASOALC-ASO A La Carte";
    }

    public static final class PolicyCertificatePoliciesTable {
        public static final String POLICY_NUMBER = "Policy Number";
        public static final String STATUS = "Status";
    }

    public static final class PoliciesTable {
        public static final String POLICY = "Policy #";
    }

    public static final class PolicyErrorsTable {
        public static final String MESSAGE = "Message";
    }

    public static final class PolicyTransactionHistoryTable {
        public static final String TYPE = "Type";
        public static final String TRAN_PREMIUM = "Tran. Premium";
        public static final String TRANSACTION_DATE = "Transaction Date";
        public static final String REASON = "Reason";
        public static final String VERSION_STATE = "Version State";
        public static final String EFFECTIVE_DATE = "Effective Date";
        public static final String ENDING_PREMIUM = "Ending Premium";
        public static final String PERFORMER = "Performer";
        public static final String HASHTAG = "#";
    }

    public static final class PolicyHistoryTable {
        public static final String ACTUAL_EXPOSURE_AMOUNT = "Actual Exposure Amount";
        public static final String CHANGE_IN_EXPOSURE = "Change in Exposure";
    }

    public static final class PolicyCoverageSummaryTable {
        public static final String COVERAGE_NAME = "Coverage Name";
        public static final String PLAN = "Plan";
        public static final String CONTRIBUTION = "Contribution %";
        public static final String INSUREDS = "Insureds";
        public static final String PARTICIPANTS = "Participants";
        public static final String VOLUME = "Volume";
        public static final String PAYOR = "Payor";
        public static final String PAYMENT_MODE = "Payment Mode";
        public static final String MODAL_PREMIUM = "Modal Premium";
        public static final String DAILY_PREMIUM = "Daily Premium";
        public static final String ANNUAL_PREMIUM = "Annual Premium";
        public static final String RATE_BASIS = "Rate Basis";
        public static final String RATE = "Rate";
        public static final String BENEFIT_AMOUNT = "Benefit Amount";
        public static final String PREMIUM = "Premium";
    }

    public static final class PolicyCoveragePremiumSummaryTable {
        public static final String BILLABLE_PREMIUM = "Billable Premium";
    }

    public static final class PolicyGeneralInformationTable {
        public static final String BROKERAGE = "Brokerage";
        public static final String AGENCY_PRODUCER = "Agency/Producer";
        public static final String AGENCY_PRODUCER_FOR_UBI = "Agency / Producer";
        public static final String EFFECTIVE_DATE = "Effective Date";
        public static final String EXPIRATION_DATE = "Expiration Date";
        public static final String AGENCY_PRODUCER_PL = "Agency / Producer";
        public static final String AGENCY_PRODUCER_ITL = "Agency/Producer";
        public static final String QUOTE_CREATION_DATE = "Quote Creation Date";
    }

    public static final class QuoteGeneralInformationTable {
        public static final String AGENCY_PRODUCER = "Agency/Producer";
        public static final String POLICY_NUMBER = "Policy Number";
    }

    public static final class PolicyClassInformationTable {
        public static final String CLASS = "Class";
        public static final String TRANSACTION_TYPE = "Transaction Type";
        public static final String AUDIT_PROCESS_DATE = "Audit Process Date";
        public static final String ORIGINAL_WRITTEN_PREMIUM = "Original Written Premium";
        public static final String ACTUAL_EXPOSURE_AMOUNT = "Actual Exposure Amount";
        public static final String CHANGE_IN_EXPOSURE = "Change in Exposure";
        public static final String AP_RP = "AP/RP";
        public static final String EARNED_PREMIUM = "Earned Premium";
    }

    public static final class PolicyEndorsementsTable {
        public static final String STATUS = "Status";
    }

    public static final class PolicyRenewalsTable {
        public static final String PREMIUM = "Premium";
        public static final String STATUS = "Status";
    }

    public static final class PolicyCoveragesTable {
        public static final String COVERAGE_NAME = "Coverage Name";
        public static final String PLAN = "Plan";
    }

    public static final class PolicyPremiumSummaryTable {
        public static final String TAXES = "Taxes";
        public static final String FEES = "Fees";
        public static final String BASE_PREMIUM = "Base Premium";
        public static final String FORM_PREMIUM = "Form Premium";
        public static final String BILLABLE_PREMIUM = "Billable Premium";
        public static final String AP_RP = "AP/RP";
        public static final String TERM_PREMIUM = "Term Premium";
        public static final String ACTION = "Action";
        public static final String ACTUAL_PREMIUM = "Actual Premium";
    }

    public static final class PolicyGroupCoveragesTable {
        public static final String COVERAGE = "Coverage";
        public static final String COVERAGE_NAME = "Coverage Name";
    }

    public static final class PolicyPlanTable {
        public static final String PLAN = "Plan";
    }

    public static final class PolicyPremiumAuditTable {
        public static final String AUDIT_STAGE = "Audit Stage";
        public static final String AUDIT_METHOD = "Audit Method";
        public static final String AUDIT = "Audit #";
        public static final String AUDIT_PERIOD = "Audit Period";
    }

    public static final class PolicyDeclineReason {
        public static final ImmutableList<String> DECLINE_BY_CUSTOMER_REASONS = ImmutableList.of(
                "Price too high",
                "Stayed with current carrier",
                "Selected other REN plan",
                "Unable to match benefits",
                "RFP Requirements",
                "RFP Withdrawn",
                "Lack DHMO",
                "Network",
                "Agent not BOR",
                "Other");
        public static final ImmutableList<String> DECLINE_BY_COMPANY_REASONS = ImmutableList.of(
                "UW Requirements",
                "RFP Withdrawn",
                "RFP Requirements",
                "Unacceptable Risk",
                "Agent not BOR",
                "Current Affiliate Customer",
                "Operational Requirements Not Met",
                "Other");
    }

    public static final class PlanSTD {
        public static final String CON = "CON";
        public static final String NC = "NC";
        public static final String SGR = "SGR";
        public static final String VOL = "VOL";
    }

    public static final class PlanEAP {
        public static final String EAP = "EAP";
    }

    public static final class PlanLTD {
        public static final String LTD_CON = "CON";
        public static final String LTD_NC = "NC";
        public static final String LTD_SGR = "SGR";
        public static final String LTD_VOL = "VOL";
    }

    public static final class PlanStat {
        public static final String NY_STAT = "NY Stat";
        public static final String NJ_STAT = "NJ Stat";
    }

    public static final class Situs_State_WA_Plans {
        public static final String PLAN_WA1 = "WA Plan 1";
        public static final String PLAN_WA2 = "WA Plan 2";
        public static final String PLAN_WA3 = "WA Plan 3";
        public static final String PLAN_WA4 = "WA Plan 4";
        public static final String PLAN_WA5 = "WA Plan 5";
        public static final String PLAN_WA6 = "WA Plan 6";
        public static final String PLAN_WA7 = "WA Plan 7";
        public static final String PLAN_WA8 = "WA Plan 8";
        public static final String PLAN_WA9 = "WA Plan 9";
    }

    public static final class PlanPFL {
        public static final String FLB = "FLB";
        public static final String FLB_FAMILY_LEAVE_BENEFIT = "FLB Family Leave Benefit";
    }

    public static final class PlanGAC {
        public static final String BASE_BuY_UP = "Base Buy-Up";
        public static final String ENHANCED_10_UNITS = "Enhanced 10 Units";
        public static final String VOLUNTARY_10_UNITS = "Voluntary 10 Units";
    }

    public static final class PlanAccidentSelectionValues {
        public static final String PLAN_ENHANCED_10_UNITS = "ENHANCED10-Enhanced 10 Units";
        public static final String PLAN_BASE_BUY_UP = "BASEBU-Base Buy-Up";
        public static final String PLAN_VOLUNTARY_10_UNITS = "VOL10-Voluntary 10 Units";
    }

    public static final class RateBasisValues {
        public static final String PER_EMPLOYEE_PER_MONTH = "Per Employee Per Month";
        public static final String PER_100_MONTHLY_COVERED_PAYROLL = "Per $100 Monthly Covered Payroll";
        public static final String PERCENT_OF_TAXABLE_WAGE = "Percent of Taxable Wage";
        public static final String PERCENT_OF_COVERED_PAYROLL = "Percent of Covered Payroll";
        public static final String PER_1000 = "Per $1,000";
        public static final String PER_MONTH = "Per Month";
        public static final String PER_10_TOTAL_WEEKLY_BENEFIT = "Per $10 Total Weekly Benefit";
        public static final String MONTHLY_TIRED_PRICE_PER_PARTICIPANT = "Monthly Tiered Price Per Participant";
    }

    public static final class EndorsementReason {
        public static final String EMPTY = "";
        public static final String ACQUISITION_OR_MERGER = "Acquisition or Merger";
        public static final String ADDITION_OF_NEW_COVERAGE = "Addition of new Coverage";
        public static final String CHANGEIN_COVERED_LIVES = "Change in Covered Lives";
        public static final String CHANGE_IN_ELIGIBLE_CLASS = "Change in Eligible Class";
        public static final String COMMISSION_CHANGE = "Commission Change";
        public static final String EOI_ENROLLMENT_CHANGE = "EOI/Enrollment Change";
        public static final String LEGAL_NAME_CHANGE = "Legal Name Change";
        public static final String PLAN_DESIGN_CHANGE = "Plan Design Change";
        public static final String POLICY_ANNIVERSARY_CHANGE = "Policy Anniversary Change";
        public static final String SITUS_STATE_CHANGE = "Situs State Change";
        public static final String POLICY_YEAR_CHANGE = "Policy Year Change";
        public static final String OTHER = "Other";
    }

    public static final class ReinstateReason {
        public static final String GROUP_SPONSOR_ERROR = "Group Sponsor Error";
        public static final String HOME_OFFICE_ERROR = "Home Office Error";
        public static final String REHIRE = "Rehire";
        public static final String REGAINED_ACTIVE_STATUS = "Regained Active Status";
        public static final String COBRA = "COBRA";
        public static final String CONTINUATION = "Continuation";
        public static final String OTHER = "Other";
    }

    public static final class CancellationNoticeReason {
        public static final String NON_PAYMENT_OF_PREMIUM = "Non Payment of Premium";
        public static final String INSURED_REQUEST_DUE_TO_POOR_CUSTOMER_SERVICE = "Insured Request - Due to Poor Customer Service";
        public static final String INSURED_REQUEST_DUE_TO_POOR_CLAIM_SERVICE = "Insured Request - Due to Poor Claim Service";
        public static final String INSURED_REQUEST_OUT_OF_BUSINESS = "Insured Request - Out of Business";
        public static final String INSURED_REQUEST_DUE_TO_HIGH_PREMIUM = "Insured Request - Due to High Premium";
        public static final String INSURED_REQUEST_NOT_SPECIFIED = "Insured Request - Not Specified";
        public static final String INSURED_REQUEST_REPLACED_WITH_DIFFERENT_CARRIER = "Insured Request - Replaced with Different Carrier";
        public static final String COVERAGE_REWRITTEN = "Coverage Rewritten";
        public static final String UNDERWRITING_CRITERIA = "Underwriting Criteria";
        public static final String OTHER = "Other";
    }

    public static final class UnderwritingCompanyValues {
        public static final String RENAISSANCE_LIFE_OF_NEW_YORK = "Renaissance Life & Health Insurance Company of New York";
        public static final String RENAISSANCE_LIFE_OF_AMERICA = "Renaissance Life & Health Insurance Company of America";
    }

    public static final class CancellationReason {
        public static final String NON_PAYMENT_OF_PREMIUM = "Non Payment of Premium";
        public static final String INSURED_REQUEST_DUE_TO_POOR_CUSTOMER_SERVICE = "Insured Request - Due To Poor Customer Service";
        public static final String INSURED_REQUEST_DUE_TO_POOR_CLAIM_SERVICE = "Insured Request - Due To Poor Claim Service";
        public static final String INSURED_REQUEST_DUE_TO_HIGH_PREMIUM = "Insured Request - Due To High Premium";
        public static final String INSURED_REQUEST_NOT_SPECIFIED = "Insured Request - Not Specified";
        public static final String REPLACED_WITH_NEW_CARRIER = "Replaced With New Carrier";
        public static final String REWRITE = "Rewrite";
        public static final String UNDERWRITING_CRITERIA = "Underwriting Criteria";
        public static final String OTHER = "Other";
    }

    public static final class NameToDisplayOnMPDocumentsValues {
        public static final String GROUP_SPONSOR = "Group Sponsor";
        public static final String MEMBER_COMPANY = "Member Company";
        public static final String BOTH = "Both";
    }

    public static final class RelationshipToInsured {
        public static final String DEPENDENT_CHILD = "Dependent Child";
        public static final String DISABLED_DEPENDENT = "Disabled Dependent";
        public static final String SPOUSE_DOMESTIC_PARTNER = "Spouse/Domestic Partner";
        public static final String SELF = "Self";
        public static final String TRUST_CHARITY_OTHER = "Trust/Charity/Other";
    }

    public static final class Participants {
        public static final String CHILD_PARTICIPANT = "Child Participant";
        public static final String PRIMARY_PARTICIPANT = "Primary Participant";
        public static final String SPOUSE_PARTICIPANT = "Spouse Participant";
    }

    public static final class BenefitType {
        public static final String SPECIFIED_AMOUNT_SINGLE = "Specified Amount - Single Value";
        public static final String SALARY_MULTIPLIER_SINGLE = "Salary Multiplier - Single Value w Additional Amount";
        public static final String SPECIFIED_AMOUNT_RANGE = "Specified Amount - Range Values";
        public static final String SPECIFIED_AMOUNT_MULTIPLE = "Specified Amount - Multiple Values";
        public static final String PERCENTAGE_OF_EMPLOYEE_AMOUNT = "Percentage of Employee Amount";
        public static final String SALARY_MULTIPLIER_MULTIPLE = "Salary Multiplier - Multiple Values";
        public static final String SALARY_MULTIPLIER_SINGLE_VALUE = "Salary Multiplier - Single Value";
        public static final String LIFE_BENEFIT_MULTIPLE = "Life Benefit Multiple";
        public static final String GRANDFATHERED_AMOUNT_ON_FILE = "Grandfathered Amount on File";
    }

    public static final class OverrideReasons {
        public static final String COMPETITIVE_ADJUSTMENT = "Competitive Adjustment";
        public static final String PREMIUM_FUND = "Premium Fund";
        public static final String PREMIUM_FUND_COMPETITIVE_ADJUSTMENT_ = "Premium Fund + Competitive Adjustment";
        public static final String MATCH_QUOTE = "Match Quote";
        public static final String MULTI_POLICY_DECISION = "Multi Policy Discount";
        public static final String BUSINESS_DECISION = "Business Decision";
        public static final String DHMO_FINAL_RATE = "DHMO Final Rate";
        public static final String MAINTAIN_IN_FORCE_RATES = "Maintain In Force Rates";
    }

    public static final class SubGroups {
        public static final String MALE = "Male";
        public static final String FEMALE = "Female";
        public static final String PROPRIETOR = "Proprietor";
        public static final String OTHER_NOT_SPECIFIED = "Other/Not Specified";
    }
}