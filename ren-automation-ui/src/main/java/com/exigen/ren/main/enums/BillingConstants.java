/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.enums;

public final class BillingConstants {

    private BillingConstants() {}

    public static final class BillingAccountPoliciesBillingStatus {
        public static final String ACTIVE = "Active";
        public static final String HOLD = "On Hold";
    }

    public static final class BillsAndStatementsStatusGB {
        public static final String DISCARDED = "Discarded";
        public static final String DISCARDED_ESTIMATED = "Discarded (Estimated)";
        public static final String ISSUED = "Issued";
        public static final String ISSUED_ESTIMATED = "Issued (Estimated)";
        public static final String PAID_IN_FULL = "Paid in Full";
        public static final String PAID_IN_FULL_ESTIMATED = "Paid in Full (Estimated)";
    }


    public static final class PaymentsAndOtherTransactionTypeGB {
        public static final String INVOICE = "Invoice";
        public static final String REFUND_APPROVED = "Refund Approved";
        public static final String DISCARD_INVOICE = "Discard Invoice";
        public static final String DECLINE_PAYMENT = "Decline Payment";
        public static final String ACCOUNT_SUSPENSE = "Account Suspense";
        public static final String PAYMENT_ALLOCATION_ADJUSTMENT = "Payment Allocation Adjustment";
        public static final String PAYMENT_UNALLOCATION = "Payment Un-allocation";
        public static final String REFUND_DECLINED = "Refund Declined";
        public static final String PAYMENT = "Payment";
        public static final String PREMIUM = "Premium";
        public static final String ADJUSTMENT = "Adjustment";
        public static final String FEE = "Fee";
        public static final String REFUND = "Refund";
        public static final String POST_DATED_CHECK = "Post-dated check";
        public static final String CHANGE_ACCOUNT_SUSPENSE = "Change Account Suspense";
    }

    public static final class PaymentsAndOtherTransactionSubtypeReason {
        public static final String POLICY = "Policy";
        public static final String RENEWAL = "Renewal";
        public static final String POLICY_MOVED = "Policy Moved";
        public static final String MANUAL_PAYMENT = "Manual Payment";
        public static final String BULK_PAYMENT = "Bulk Payment";
        public static final String MANUAL_REFUND = "Manual Refund";
        public static final String AUTOMATED_REFUND = "Automated Refund";
        public static final String INSTALLMENT_FEE = "Installment Fee";
        public static final String ENDORSEMENT = "Endorsement";
        public static final String NOT_SUFFICIENT_FUNDS_FEE = "Not Sufficient Funds Fee";
        public static final String CANCELLATION_NOTICE_FEE = "Cancellation Notice Fee";
        public static final String CANCELLATION_FEE = "Cancellation Fee";
        public static final String CANCELLATION_FEE_WAIVED = "Cancellation Fee Waived";
        public static final String CANCELLATION_NOTICE = "Cancellation Notice";
        public static final String CANCELLATION = "Cancellation";
        public static final String CANCELLATION_NON_PAYMENT_OF_PREMIUM = "Cancellation - Non Payment of Premium";
        public static final String CANCELLATION_INSURED_REQUEST_DUE_TO_HIGH_PREMIUM = "Cancellation - Insured Request - Due To High Premium";
        public static final String PAYMENT_DECLINED = "Payment Declined";
        public static final String WRITE_OFF = "Write-off";
        public static final String SERVICE_FEE = "Service Fee";
        public static final String SERVICE_FEE_WAIVED = "Service Fee Waived";
        public static final String INSTALLMENT_FEE_WAIVED = "Installment Fee Waived";
        public static final String EARNED_PREMIUM_WRITE_OFF = "Earned Premium Write-off";
        public static final String EARNED_PREMIUM_WRITE_OFF_REVERSED = "Earned Premium Write-off Reversed";
        public static final String PAYMENT_TRANSFERRED = "Payment Transferred";
        public static final String REALLOCATED_PAYMENT = "Reallocated Payment";
        public static final String REALLOCATE_PAYMENT = "Reallocate Payment";
        public static final String RENEWAL_POLICY_RENEWAL_PROPOSAL = "Renewal - Policy Renewal Proposal";
        public static final String REINSTATEMENT_FEE = "Reinstatement Fee";
        public static final String REINSTATEMENT_FEE_WITH_LAPSE = "Reinstatement with Lapse";
        public static final String REINSTATEMENT_WITHOUT_LAPSE = "Reinstatement - Without Lapse: payment received within grace period";
        public static final String REINSTATEMENT_WITH_LAPSE = "Reinstatement - Lapse: payment received within the lapse period";
        public static final String REINSTATEMENT_RESCIND_CANCELLATION = "Reinstatement - Rescind Cancellation";
        public static final String RECURRING_PAYMENT = "Recurring Payment";
        public static final String CROSS_POLICY_TRANSFER = "Cross Policy Transfer";
        public static final String OFFER_WITHOUT_LAPSE = "Offer without Lapse";
        public static final String SUSPENSE = "Suspense";
    }

    public static final class PaymentsAndAdjustmentsTypeGB {
        public static final String REFUND = "Refund";
        public static final String ISSUED = "Issued";
    }

    public static final class PaymentsAndAdjustmentsSubtypeGB {
        public static final String MANUAL_REFUND = "Manual Refund";
    }

    public static final class PaymentsAndAdjustmentsReasonGB {
        public static final String MISAPPLIED = "Misapplied";
    }

    public static final class PaymentsAndAdjustmentsStatusGB {
        public static final String APPROVED = "Approved";
        public static final String ISSUED = "Issued";
        public static final String CLEARED = "Cleared";
        public static final String PENDING = "Pending";
        public static final String DISAPPROVED = "Disapproved";
        public static final String VOIDED = "Voided";
        public static final String DECLINED = "Declined";
        public static final String STOP_REQUESTED = "Stop Requested";
        public static final String STOPPED = "Stopped";
        public static final String REVERSE = "Reverse";
        public static final String REVERSED = "Reversed";
    }

    public static final class PaymentsAndOtherTransactionStatus {
        public static final String ACTIVE = "Active";
        public static final String APPLIED = "Applied";
        public static final String APPROVED = "Approved";
        public static final String CLEARED = "Cleared";
        public static final String TRANSFERRED = "Transferred";
        public static final String DECLINED = "Declined";
        public static final String ISSUED = "Issued";
        public static final String OUTSTANDING = "Outstanding";
        public static final String COMPLETED = "Completed";
        public static final String PENDING = "Pending";
        public static final String DISAPPROVED = "Disapproved";
    }

    public static final class ModalPremiumTransactionType {
        public static final String ADD_PREMIUM_WAIVER = "Add Premium Waiver";
        public static final String ENDORSEMENT = "Endorsement (Premium Bearing / Divorce)";
        public static final String RENEWAL = "Renewal (Annual / - )";
        public static final String REMOVE_PREMIUM_WAIVER = "Remove Premium Waiver";
        public static final String CANCELLATION = "Cancellation ( - / Insured Request - Due To High Premium)";
        public static final String CANCELLATION_NON_PAYMENT = "Cancellation ( - / Non Payment of Premium)";
        public static final String CANCELLATION_TERM = "Cancellation ( - / Term)";
        public static final String REINSTATEMENT = "Reinstatement ( - / Without Lapse: payment received within grace period)";
        public static final String REINSTATEMENT_OTHER = "Reinstatement ( - / Other)";
    }

    public static final class BillingBillsAndStatmentsTable {
        public static final String DUE_DATE = "Due Date";
        public static final String ISSUE_DATE = "Issue Date";
        public static final String BILING_PERIOD = "Billing Period";
        public static final String TOTAL_DUE = "Total Due";
        public static final String INVOICE = "Invoice #";
        public static final String ACTIONS = "Actions";
        public static final String STATUS = "Status";
        public static final String CURRENT_DUE = "Current Due";
    }

    public static final class BillingGBBillsAndStatmentsTable {
        public static final String ACTION = "Action";
    }

    public static final class BillingPaymentsAndAdjustmentsTable {
        public static final String AMOUNT = "Amount";
        public static final String ACTION = "Action";
    }

    public static final class BillingSuspensePaymentsTable {
        public static final String BILLING_ACCOUNTS = "Billing Accounts";
        public static final String STATUS = "Status";
    }

    public static final class BillingSuspenseForDeclineTable {
        public static final String REFERENCE_NUMBER = "Reference Number";
        public static final String ACTION = "Action";
    }

    public static final class BillingSuspenseSearchResultsTable {
        public static final String ACTION = "Action";
    }

    public static final class BillingConsolidatedStatement {
        public static final String STATUS_Y = "Y";
        public static final String STATUS_N = "N";
    }

    public static final class BillingPaymentsAndOtherTransactionsTable {
        public static final String TRANSACTION_DATE = "Transaction Date";
        public static final String EFFECTIVE_DATE = "Effective Date";
        public static final String TYPE = "Type";
        public static final String ACTION = "Action";
        public static final String AMOUNT = "Amount";
        public static final String SUBTYPE_REASON = "Subtype/Reason";
        public static final String POLICY = "Policy #";
        public static final String DEPOSIT_PAYMENT = "Deposit Payment";
        public static final String DEPOSIT = "Deposit";
    }

    public static final class BillingModalPremiumTable {
        public static final String MODAL_PREMIUM_EFFECTIVE_DATE = "Modal Premium Effective Date";
        public static final String AMOUNT = "Amount";
        public static final String TRANSACTION_TYPE_SUBTYPE_REASON = "Transaction Type (Subtype / Reason)";
        public static final String COVERAGE = "Coverage";
    }

    public static final class BillingAccountsSearchResultTable {
        public static final String BILLING_ACCOUNT = "Billing Account #";
    }

    public static final class BillingAllocationsTable {
        public static final String INVOICE = "Invoice";
        public static final String AMOUNT = "Amount";
    }

    public static final class BillingAllocationsIntoGroupsTable {
        public static final String BILLING_GROUP = "Billing Group";
        public static final String CURRENT = "Current";
    }

    public static final class BillingPaymentAllocationTable {
        public static final String COVERAGE = "Coverage";
        public static final String REMAINING_DUE = "Remaining Due";
        public static final String AMOUNT_PAID = "Amount Paid";
    }

    public static final class BillingBenefitAccountsTable {
        public static final String BILLING_ACCOUNT = "Billing Account #";
    }

    public static final class InvoiceDocumentTemplate {
        public static final String STATUTORY_INVOICE_TYPE_1 = "STATUTORY_INVOICE_TYPE_1";
        public static final String STATUTORY_INVOICE_TYPE_2 = "STATUTORY_INVOICE_TYPE_2";
        public static final String STATUTORY_INVOICE_TYPE_3 = "STATUTORY_INVOICE_TYPE_3";
        public static final String STATUTORY_INVOICE_TYPE_4 = "STATUTORY_INVOICE_TYPE_4";
        public static final String STATUTORY_INVOICE_TYPE_5 = "STATUTORY_INVOICE_TYPE_5";
        public static final String STATUTORY_INVOICE_TYPE_6 = "STATUTORY_INVOICE_TYPE_6";
        public static final String STATUTORY_INVOICE_TYPE_7 = "STATUTORY_INVOICE_TYPE_7";
    }
}
