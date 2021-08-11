/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.enums;

public final class ProductConstants {

    private ProductConstants() {
    }

    public static final class PolicyStatus {
        public static final String CUSTOMER_ACCEPTED = "Customer Accepted";
        public static final String BOUND = "Bound";
        public static final String CANCELLATION_PENDING = "Cancellation Pending";
        public static final String COMPANY_DECLINED = "Company Declined";
        public static final String CUSTOMER_DECLINED = "Customer Declined";
        public static final String DATA_GATHERING = "Data Gathering";
        public static final String ISSUED = "Issued";
        public static final String PENDING_OUT_OF_SEQUENCE_COMPLETION = "Pending out of sequence completion";
        public static final String POLICY_ACTIVE = "Policy Active";
        public static final String POLICY_EXPIRED = "Policy Expired";
        public static final String POLICY_CANCELLED = "Policy Cancelled";
        public static final String POLICY_PENDING = "Policy Pending";
        public static final String PREMIUM_CALCULATED = "Premium Calculated";
        public static final String PROPOSED = "Proposed";
        public static final String SUSPENDED = "Suspended";
        public static final String INITIATED = "Initiated";
        public static final String EXPIRED  = "Expired";
    }

    public static final class StatusWhileCreating {
        public static final String PREMIUM_CALCULATED = "Status: Premium Calculated";
        public static final String DATA_GATHERING = "Status: Data Gathering";
        public static final String INITIATED = "Status: Initiated";
    }

    public static final class ProductFlag {
        public static final String NONE = "";
        public static final String CANCEL_NOTICE = "Cancel Notice";
    }

    public static final class PolicyType {
        public static final String AUTO_BASE = "Auto (Base)";
        public static final String AUTO_PRECONFIGURED = "Auto (Preconfigured)";
        public static final String CERTIFICATE = "Certificate";
        public static final String COMMERCIAL_LINES = "Commercial Lines";
        public static final String COMMERCIAL_PRECONFIGURED = "Commercial (Preconfigured)";
        public static final String COMMERCIAL_LINES_PRECONFIG = "Preconfig Commercial Lines";
        public static final String GBADD = "GBADD";
        public static final String GBASI = "GBASI";
        public static final String GBCII = "GBCII";
        public static final String GBDI = "GBDI";
        public static final String HOME = "Home";
        public static final String HOME_PRECONFIGURED = "Home (Preconfigured)";
        public static final String GROUP_ACCIDENT = "Group Accident";
        public static final String CRITICAL_ILLNESS_INSURANCE = "Critical Illness Insurance";
        public static final String HOSPITAL_INDEMNITY = "Hospital Indemnity";
        public static final String LONG_TERM_DISABILITY = "Long Term Disability";
        public static final String STATUTORY_DISABILITY_INSURANCE = "Statutory Disability Insurance";
        public static final String SHORT_TERM_DISABILITY = "Short Term Disability";
        public static final String TERM_LIFE_INSURANCE= "Term Life Insurance";
    }

    public static final class ProductSubType {
        public static final String PERSONAL_LINES = "Personal Lines";
        public static final String COMMERCIAL_LINES = "Commercial Lines";
        public static final String GROUP_INSURANCE = "Group Insurance";
    }

    public static final class PolicyLineOfBusiness {
        public static final String AUTOMOBILE = "Automobile";
        public static final String HOMEOWNERS = "Homeowners";
        public static final String COMMERCIAL_PACKAGE = "Commercial Package";
        public static final String ACCIDENT_AND_HEALTH = "Accident & Health";
        public static final String DISABILITY_INSURANCE = "Disability Insurance";
        public static final String LIFE_INSURANCE= "Life Insurance";
    }

    public static final class ClaimProductType {
        public static final String AUTO = "Auto";
        public static final String AUTO_NO_POLICY = "AutoNoPolicy";
        public static final String BASE = "Base";
        public static final String BASE_NO_POLICY = "BaseNoPolicy";
        public static final String CLPREC = "CLPrec";
        public static final String CLPREC_NO_POLICY = "CLPrecNoPolicy";
        public static final String GBTLI = "GBTLI";
        public static final String GBTLI_NO_POLICY = "GBTLINoPolicy";
        public static final String HOME = "Home";
        public static final String HOME_NO_POLICY = "HomeNoPolicy";
    }

    public static final class TransactionHistoryType {
        public static final String ANNIVERSARY_RENEWAL = "Anniversary Renewal";
        public static final String ANNIVERSARY_RENEWAL_WITH_LAPSE = "Anniversary Renewal with Lapse";
        public static final String ANNIVERSARY_RENEWAL_WITH_LAPSE_REMOVED = "Anniversary Renewal with Lapse Removed";
        public static final String BACKED_OFF_ANNIVERSARY_RENEWAL = "Backed Off Anniversary Renewal";
        public static final String BACKED_OFF_ANNIVERSARY_RENEWAL_WITH_LAPSE = "Backed Off Anniversary Renewal with Lapse";
        public static final String BACKED_OFF_ENDORSEMENT = "Backed Off Endorsement";
        public static final String BACKED_OFF_REINSTATEMENT = "Backed Off Reinstatement";
        public static final String BACKED_OFF_CANCELLATION = "Backed Off Cancellation";
        public static final String BACKED_OFF_REINSTATEMENT_WITH_LAPSE = "Backed Off Reinstatement with Lapse";
        public static final String CANCEL_NOTICE = "Cancel Notice";
        public static final String CANCELLATION = "Cancellation";
        public static final String CANCELLATION_AUDIT = "Cancellation Audit";
        public static final String CHANGE_AGENCY = "Change Agency";
        public static final String ENDORSEMENT = "Endorsement";
        public static final String FINAL_AUDIT = "Final Audit";
        public static final String FLAT_CANCELLATION = "Flat Cancellation";
        public static final String ISSUE = "Issue";
        public static final String MANUAL_RENEWAL_FLAG = "Manual Renewal Flag";
        public static final String NON_PREMIUM_ENDORSEMENT = "NonPremium Endorsement";
        public static final String OOS_ENDORSEMENT = "OOS Endorsement";
        public static final String OOS_FLAT_CANCELLATION= "OOS Flat Cancellation";
        public static final String OOS_CANCELLATION = "OOS Cancellation";
        public static final String REINSTATEMENT = "Reinstatement";
        public static final String REINSTATEMENT_WITH_LAPSE = "Reinstatement with Lapse";
        public static final String REINSTATEMENT_WITH_LAPSE_REMOVED = "Reinstatement with Lapse Removed";
        public static final String REMOVE_CANCEL_NOTICE = "Remove Cancel Notice";
        public static final String REMOVE_MANUAL_RENEWAL_FLAG = "Remove Manual Renewal Flag";
        public static final String REVERSE_CANCELLATION_AUDIT = "Reverse Cancellation Audit";
        public static final String REVERSE_REVISED_CANCELLATION_AUDIT = "Reverse Revised Cancellation Audit";
        public static final String REVISED_CANCELLATION_AUDIT = "Revised Cancellation Audit";
        public static final String REVISED_FINAL_AUDIT = "Revised Final Audit";
        public static final String ROLL_BACK = "Roll Back";
        public static final String ROLLED_ON_ENDORSEMENT = "Rolled On Endorsement";
        public static final String ROLLED_ON_ANNIVERSARY_RENEWAL = "Rolled On Anniversary Renewal";
        public static final String NPB_ENDORSEMENT = "Non-Premium Endorsement";
    }

    public static final class ReinstatementReason {
        public static final String LAPSE_PAYMENT_RECEIVED_WITHIN_THE_LAPSE_PERIOD = "Lapse: payment received within the lapse period";
        public static final String LAPSE_LAPSE_ALLOWED_FOR_CUSTOMER_RETENTION = "Lapse: lapse allowed for customer retention";
        public static final String WITHOUT_LAPSE_PAYMENT_RECEIVED_WITHIN_GRACE_PERIOD = "Without Lapse: payment received within grace period";
        public static final String RESCIND_CANCELLATION = "Rescind Cancellation";
    }

    public static final class ReinstatementLapseChangeReason {
        public static final String LAPSE_CHANGED_ERROR_ON_ORIGINAL_LAPSE = "Lapse Changed: error on original lapse";
    }

    public static final class PremiumAuditPolicyPremiumAuditTransactions {
        public static final String AP_RP = "AP/RP";
        public static final String AUDIT = "Audit #";
        public static final String AUDIT_TRANSACTION_TYPE = "Audit Transaction Type";
        public static final String AUDIT_PROCESS_DATE = "Audit Process Date";
        public static final String COMMISIONS = "Commission";
        public static final String FEE = "Fee";
        public static final String FINAL_AP_RP = "Final AP/RP";
        public static final String TAX = "Tax";
    }

    public static final class PremiumAuditMethod {
        public static final String AUDIT_COMPLETED = "Audit Completed";
        public static final String AUDIT_REVISED = "Audit Revised";
        public static final String MAIL_AUDIT = "Mail Audit";
        public static final String MAIN_AUDIT = "Main Audit";
        public static final String PHYSICAL_AUDIT = "Physical Audit";
        public static final String PHONE_AUDIT = "Phone Audit";
    }

    public static final class PremiumAuditStage {
        public static final String IDENTIFIED = "Identified";
        public static final String IN_REVIEW = "In Review";
        public static final String NOT_YET_IDENTIFIED = "Not Yet Identified";
    }

    public static final class ProductTable {
        public static final String PRODUCT_NAME = "Product Name";
        public static final String PRODUCT_CODE = "Product Code";
        public static final String PRODUCT_STATUS = "Product Status";
        public static final String COPY_PRODUCT = "Copy Product";
        public static final String ACTIVATED = "Activated";
        public static final String DEACTIVATED = "Deactivated";
        public static final String CHANGE_EXPIRATION = "Change Expiration";
        public static final String EXPIRATION_DATE = "Expiration Date";
        public static final String LOB = "LOB";
        public static final String BROAD_LOB = "Broad LOB";
        public static final String EFFECTIVE_DATE = "Effective Date";
    }
}
