/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.billing;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.billing.BillingHelper;
import com.exigen.helpers.billing.groupbenefits.BillingHelperGB;
import com.exigen.ipb.eisa.utils.Currency;
import com.exigen.ipb.eisa.utils.db.DBService;
import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.common.pages.MainPage;
import com.exigen.ren.main.enums.BillingConstants.BillsAndStatementsStatusGB;
import com.exigen.ren.main.enums.BillingConstants.PaymentsAndOtherTransactionTypeGB;
import com.exigen.ren.main.enums.PolicyConstants;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.modules.caseprofile.CaseProfileContext;
import com.exigen.ren.main.modules.customer.CustomerContext;
import com.exigen.ren.main.modules.policy.gb_ac.certificate.GroupAccidentCertificatePolicyContext;
import com.exigen.ren.main.modules.policy.gb_ac.masterpolicy.GroupAccidentMasterPolicyContext;
import com.exigen.ren.main.pages.summary.PolicySummaryPage;
import com.exigen.ren.main.pages.summary.billing.BillingSummaryPage;
import com.exigen.ren.main.pages.summary.billing.ModalPremiumSummaryPage;
import com.exigen.ren.rest.billing.BillingBenefitsRestService;
import com.exigen.ren.rest.billing.BillingRestService;
import com.exigen.utils.DbQueryConstants;

import java.time.LocalDateTime;

import static com.exigen.helpers.billing.BillingHelper.ZERO;
import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.TestDataKey.*;
import static com.exigen.ren.main.enums.BillingConstants.BillingModalPremiumTable.MODAL_PREMIUM_EFFECTIVE_DATE;
import static com.exigen.ren.main.enums.BillingConstants.BillingModalPremiumTable.TRANSACTION_TYPE_SUBTYPE_REASON;
import static com.exigen.ren.main.enums.BillingConstants.BillingPaymentsAndOtherTransactionsTable.AMOUNT;
import static com.exigen.ren.main.enums.BillingConstants.BillsAndStatementsStatusGB.PAID_IN_FULL;
import static com.exigen.ren.main.enums.BillingConstants.PaymentsAndOtherTransactionTypeGB.PAYMENT;
import static com.exigen.ren.main.enums.TableConstants.BillingBillsAndStatementsGB.CURRENT_DUE;
import static com.exigen.ren.main.enums.TableConstants.BillingBillsAndStatementsGB.STATUS;
import static com.exigen.ren.main.enums.TableConstants.BillingGeneralInformationGB.TOTAL_DUE;
import static com.exigen.ren.main.enums.TableConstants.BillingGeneralInformationGB.TOTAL_PAID;
import static com.exigen.ren.main.enums.TableConstants.BillingPaymentsAndTransactionsGB.POLICY_NUMBER;
import static com.exigen.ren.main.enums.TableConstants.BillingPaymentsAndTransactionsGB.TYPE;

public class GroupBenefitsBillingBaseTest extends CommonBaseTest implements CustomerContext, CaseProfileContext, GroupAccidentCertificatePolicyContext, GroupAccidentMasterPolicyContext {

    protected static ThreadLocal<String> masterPolicyNumber = new ThreadLocal<>();
    protected static ThreadLocal<String> certificatePolicyNumber = new ThreadLocal<>();
    protected static ThreadLocal<String> secondCertificatePolicyNumber = new ThreadLocal<>();
    protected static ThreadLocal<String> billingAccountNumber = new ThreadLocal<>();

    protected static ThreadLocal<Currency> policyPremium = new ThreadLocal<>();
    protected static ThreadLocal<Currency> modalPremiumAmount = new ThreadLocal<>();
    protected static ThreadLocal<Currency> firstCoverageModalPremium = new ThreadLocal<>();
    protected static ThreadLocal<Currency> secondCoverageModalPremium = new ThreadLocal<>();
    protected static ThreadLocal<LocalDateTime> policyEffectiveDate = new ThreadLocal<>();

    protected BillingBenefitsRestService billingBenefitsRestService = new BillingBenefitsRestService();
    protected BillingRestService billingRestService = new BillingRestService();


    protected void createPolicyFullAdmin() {

        createDefaultGroupAccidentMasterPolicy();

        createDefaultGroupAccidentCertificatePolicy();
        certificatePolicyNumber.set(PolicySummaryPage.labelPolicyNumber.getValue());
        masterPolicyNumber.set(PolicySummaryPage.linkMasterPolicy.getValue());
        billingAccountNumber.set(getBillingAccountNumber(masterPolicyNumber.get()));

        PolicySummaryPage.linkMasterPolicy.click();

        initModalPremiumValues();
    }

    /**
     * Use only when Master Policy has ONLY one BA
     *
     * @param masterPolicyNumber - master policy number
     */
    protected void navigateToBillingAccount(String masterPolicyNumber) {
        String billingAccountNumber = getBillingAccountNumber(masterPolicyNumber);
        LOGGER.info("Navigate to Billing Account #" + billingAccountNumber);

        MainPage.QuickSearch.search(billingAccountNumber);
    }

    /**
     * Use only when Master Policy has ONLY one BA
     *
     * @param masterPolicyNumber - master policy number
     * @return billing account number
     */
    public static String getBillingAccountNumber(String masterPolicyNumber) {
        return DBService.get().getValue(String.format(DbQueryConstants.FIND_BILLING_ACCOUNT_NUMBER_BY_MASTER_POLICY_NUMBER, masterPolicyNumber)).get();
    }

    protected void createPolicyFullAdminTwoCoveragesCertificateOneCoverage() {
        groupAccidentMasterPolicy.createPolicy(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.DATA_GATHER, "TestData_TwoCoveragesNonBASEBU")
                .adjust(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.PROPOSE, TestDataKey.DEFAULT_TEST_DATA_KEY).resolveLinks())
                .adjust(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY).resolveLinks())
                .adjust(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.ISSUE, TestDataKey.DEFAULT_TEST_DATA_KEY).resolveLinks()));

        groupAccidentCertificatePolicy.createPolicy(groupAccidentCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY)
                .adjust(groupAccidentCertificatePolicy.getDefaultTestData(DATA_GATHER, "CoveragesTab_PlanVoluntary").resolveLinks())
                .adjust(groupAccidentCertificatePolicy.getDefaultTestData(TestDataKey.ISSUE, TestDataKey.DEFAULT_TEST_DATA_KEY).resolveLinks()));

        certificatePolicyNumber.set(PolicySummaryPage.labelPolicyNumber.getValue());
        masterPolicyNumber.set(PolicySummaryPage.linkMasterPolicy.getValue());
        PolicySummaryPage.linkMasterPolicy.click();

        initModalPremiumValues();
        firstCoverageModalPremium.set(new Currency(getModalPremiumAmountFromCoverageSummary(1)));
    }

    protected void createPolicyFullAdminTwoCoveragesTwoCertificates() {
        groupAccidentMasterPolicy.createPolicy(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.DATA_GATHER, "TestData_TwoCoveragesNonBASEBU")
                .adjust(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.PROPOSE, TestDataKey.DEFAULT_TEST_DATA_KEY).resolveLinks())
                .adjust(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY).resolveLinks())
                .adjust(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.ISSUE, "TestData").resolveLinks()));

        groupAccidentCertificatePolicy.createPolicy(groupAccidentCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER, "TestData")
                .adjust(groupAccidentCertificatePolicy.getDefaultTestData(DATA_GATHER, "CoveragesTab_PlanVoluntary").resolveLinks())
                .adjust(groupAccidentCertificatePolicy.getDefaultTestData(TestDataKey.ISSUE, DEFAULT_TEST_DATA_KEY).resolveLinks()));
        certificatePolicyNumber.set(PolicySummaryPage.labelPolicyNumber.getValue());
        PolicySummaryPage.linkMasterPolicy.click();

        groupAccidentCertificatePolicy.createPolicy(groupAccidentCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER, "TestData")
                .adjust(groupAccidentCertificatePolicy.getDefaultTestData(DATA_GATHER, "CoveragesTab_PlanEnhanced").resolveLinks())
                .adjust(groupAccidentCertificatePolicy.getDefaultTestData(TestDataKey.ISSUE, DEFAULT_TEST_DATA_KEY).resolveLinks()));

        secondCertificatePolicyNumber.set(PolicySummaryPage.labelPolicyNumber.getValue());
        masterPolicyNumber.set(PolicySummaryPage.linkMasterPolicy.getValue());
        billingAccountNumber.set(getBillingAccountNumber(masterPolicyNumber.get()));
        PolicySummaryPage.linkMasterPolicy.click();

        initModalPremiumValues();
    }

    protected void createPolicyFullAdminOneCoverageEnhancedAccident() {
        groupAccidentMasterPolicy.createPolicy(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.DATA_GATHER, "TestData_OneCoverageNonContributory")
                .adjust(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.PROPOSE, TestDataKey.DEFAULT_TEST_DATA_KEY).resolveLinks())
                .adjust(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY).resolveLinks())
                .adjust(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.ISSUE, "TestData_OnTime").resolveLinks()));
        LOGGER.info("TEST: Master Quote is created #" + PolicySummaryPage.labelPolicyNumber.getValue());
        policyEffectiveDate.set(PolicySummaryPage.getEffectiveDate());

        groupAccidentCertificatePolicy.createPolicy(groupAccidentCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER, "TestData")
                .adjust(groupAccidentCertificatePolicy.getDefaultTestData(TestDataKey.ISSUE, "TestData").resolveLinks()));

        certificatePolicyNumber.set(PolicySummaryPage.labelPolicyNumber.getValue());
        masterPolicyNumber.set(PolicySummaryPage.linkMasterPolicy.getValue());
        PolicySummaryPage.linkMasterPolicy.click();

        initModalPremiumValues();
    }

    protected void createPolicy(TestData testData) {
        groupAccidentMasterPolicy.createPolicy(testData);
        initModalPremiumValues();
        policyEffectiveDate.set(PolicySummaryPage.getEffectiveDate());
        masterPolicyNumber.set(PolicySummaryPage.labelPolicyNumber.getValue());
        billingAccountNumber.set(getBillingAccountNumber(masterPolicyNumber.get()));
    }

    protected void createPolicySelfAdmin() {
        groupAccidentMasterPolicy.createPolicy(groupAccidentMasterPolicy.getDefaultTestData("DataGatherSelfAdmin", "TestData_WithTwoCoverages")
                .adjust(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.PROPOSE, TestDataKey.DEFAULT_TEST_DATA_KEY).resolveLinks())
                .adjust(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY).resolveLinks())
                .adjust(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.ISSUE, DEFAULT_TEST_DATA_KEY).resolveLinks()));

        masterPolicyNumber.set(PolicySummaryPage.labelPolicyNumber.getValue());
        billingAccountNumber.set(getBillingAccountNumber(masterPolicyNumber.get()));
        initModalPremiumValues();
        firstCoverageModalPremium.set(new Currency(getModalPremiumAmountFromCoverageSummary(1)));
        secondCoverageModalPremium.set(new Currency(getModalPremiumAmountFromCoverageSummary(2)));
    }

    protected void createPolicySelfAdminRemoveBASEBUEnhanced() {
        groupAccidentMasterPolicy.createPolicy(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.DATA_GATHER_SELF_ADMIN, "TestData_WithTwoCoveragesRemove")
                .adjust(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.PROPOSE, TestDataKey.DEFAULT_TEST_DATA_KEY).resolveLinks())
                .adjust(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY).resolveLinks())
                .adjust(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.ISSUE, DEFAULT_TEST_DATA_KEY).resolveLinks()));

        masterPolicyNumber.set(PolicySummaryPage.labelPolicyNumber.getValue());
        billingAccountNumber.set(getBillingAccountNumber(masterPolicyNumber.get()));
        initModalPremiumValues();
        firstCoverageModalPremium.set(new Currency(getModalPremiumAmountFromCoverageSummary(1)));
        secondCoverageModalPremium.set(new Currency(getModalPremiumAmountFromCoverageSummary(2)));
    }

    protected void createPolicySelfAdminWithOneCoverage() {
        groupAccidentMasterPolicy.createPolicy(groupAccidentMasterPolicy.getDefaultTestData(DATA_GATHER_SELF_ADMIN, DEFAULT_TEST_DATA_KEY)
                .adjust(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.PROPOSE, TestDataKey.DEFAULT_TEST_DATA_KEY).resolveLinks())
                .adjust(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY).resolveLinks())
                .adjust(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.ISSUE, DEFAULT_TEST_DATA_KEY).resolveLinks()));

        masterPolicyNumber.set(PolicySummaryPage.labelPolicyNumber.getValue());
        billingAccountNumber.set(getBillingAccountNumber(masterPolicyNumber.get()));
        initModalPremiumValues();
        firstCoverageModalPremium.set(new Currency(getModalPremiumAmountFromCoverageSummary(1)));
    }

    protected void createPolicySelfAdminWitTwoNonBASEBUCoverage() {
        groupAccidentMasterPolicy.createPolicy(groupAccidentMasterPolicy.getDefaultTestData(DATA_GATHER_SELF_ADMIN, "TestData_TwoCoveragesNonBASEBU")
                .adjust(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.PROPOSE, TestDataKey.DEFAULT_TEST_DATA_KEY).resolveLinks())
                .adjust(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY).resolveLinks())
                .adjust(groupAccidentMasterPolicy.getDefaultTestData(TestDataKey.ISSUE, "TestData_OnTime").resolveLinks()));

        masterPolicyNumber.set(PolicySummaryPage.labelPolicyNumber.getValue());
        billingAccountNumber.set(getBillingAccountNumber(masterPolicyNumber.get()));
        initModalPremiumValues();
        firstCoverageModalPremium.set(new Currency(getModalPremiumAmountFromCoverageSummary(1)));
        secondCoverageModalPremium.set(new Currency(getModalPremiumAmountFromCoverageSummary(2)));
    }



    protected String getModalPremiumAmountFromCoverageSummary(int row) {
        return PolicySummaryPage.tableCoverageSummary.getRow(row).getCell(PolicyConstants.PolicyCoverageSummaryTable.MODAL_PREMIUM).getValue();
    }

    protected void acceptedPaymentVerification() {
        //wait for calculation is finished
        BillingSummaryPage.tableBillingGeneralInformation.getRow(1)
                .getCell("Current Due").waitFor(cell -> !cell.getValue().equals("Calculating..."));

        assertThat(BillingSummaryPage.tableBillingGeneralInformation.getRow(1))
                .hasCellWithValue("Current Due", BillingHelper.DZERO.toString())
                .hasCellWithValue("Total Due", BillingHelper.DZERO.toString())
                .hasCellWithValue("Total Paid", modalPremiumAmount.get().toString());

        assertThat(BillingSummaryPage.tableBillsAndStatements.getRow(1).getCell("Status")).valueContains(PAID_IN_FULL);

        assertThat(BillingSummaryPage.tablePaymentsOtherTransactions)
                .with(POLICY_NUMBER, masterPolicyNumber.get())
                .with(TYPE, PAYMENT)
                .with(TableConstants.BillingPaymentsAndTransactionsGB.AMOUNT, String.format("(%s)", modalPremiumAmount.get().toString()))
                .containsMatchingRow(1);

    }

    protected void declinePaymentVerification() {
        assertThat(BillingSummaryPage.tableBillingGeneralInformation).isPresent().hasRows(1);
        assertThat(BillingSummaryPage.tableBillingGeneralInformation)
                .with(TableConstants.BillingGeneralInformationGB.CURRENT_DUE, modalPremiumAmount.get())
                .with(TOTAL_DUE, modalPremiumAmount.get())
                .with(TOTAL_PAID, ZERO)
                .containsMatchingRow(1);

        assertThat(BillingSummaryPage.tableBillsAndStatements)
                .with(STATUS, BillsAndStatementsStatusGB.ISSUED)
                .containsMatchingRow(1);

        assertThat(BillingSummaryPage.tablePaymentsOtherTransactions)
                .with(POLICY_NUMBER, masterPolicyNumber.get())
                .with(TYPE, "Decline Payment")
                .with(TableConstants.BillingPaymentsAndTransactionsGB.AMOUNT, modalPremiumAmount.get().toString())
                .containsMatchingRow(1);
    }

    protected void declinePaymentVerificationSelfAdmin() {
        assertThat(BillingSummaryPage.tableBillingGeneralInformation)
                .with(TableConstants.BillingGeneralInformationGB.CURRENT_DUE, modalPremiumAmount.get())
                .with(TOTAL_DUE, modalPremiumAmount.get())
                .with(TOTAL_PAID, ZERO)
                .containsMatchingRow(1);

        assertThat(BillingSummaryPage.tableBillsAndStatements)
                .with(STATUS, BillsAndStatementsStatusGB.ISSUED_ESTIMATED)
                .containsMatchingRow(1);

        assertThat(BillingSummaryPage.tablePaymentsOtherTransactions)
                .with(POLICY_NUMBER, masterPolicyNumber.get())
                .with(TYPE, "Decline Payment")
                .with(TableConstants.BillingPaymentsAndTransactionsGB.AMOUNT, modalPremiumAmount.get().toString())
                .containsMatchingRow(1);
    }

    protected void generateFutureStatementVerificationForSelfAdmin() {
        assertThat(BillingSummaryPage.tableBillsAndStatements)
                .with(STATUS, BillsAndStatementsStatusGB.ISSUED_ESTIMATED)
                .with(CURRENT_DUE, modalPremiumAmount.get())
                .containsMatchingRow(1);

        assertThat(BillingSummaryPage.tableBillingGeneralInformation)
                .with(TableConstants.BillingGeneralInformationGB.CURRENT_DUE, modalPremiumAmount.get())
                .with(TOTAL_DUE, modalPremiumAmount.get())
                .with(TOTAL_PAID, ZERO)
                .containsMatchingRow(1);

        assertThat(BillingSummaryPage.tablePaymentsOtherTransactions)
                .with(POLICY_NUMBER, masterPolicyNumber.get())
                .with(TYPE, PaymentsAndOtherTransactionTypeGB.INVOICE)
                .with(TableConstants.BillingPaymentsAndTransactionsGB.AMOUNT, modalPremiumAmount.get().toString())
                .containsMatchingRow(1);
    }

    protected void generateFutureStatementVerificationForFullAdmin() {
        assertThat(BillingSummaryPage.tableBillsAndStatements)
                .with(STATUS, BillsAndStatementsStatusGB.ISSUED)
                .with(CURRENT_DUE, modalPremiumAmount.get())
                .containsMatchingRow(1);

        assertThat(BillingSummaryPage.tableBillingGeneralInformation)
                .with(TableConstants.BillingGeneralInformationGB.CURRENT_DUE, modalPremiumAmount.get())
                .with(TOTAL_DUE, modalPremiumAmount.get())
                .with(TOTAL_PAID, ZERO)
                .containsMatchingRow(1);

        assertThat(BillingSummaryPage.tablePaymentsOtherTransactions)
                .with(POLICY_NUMBER, masterPolicyNumber.get())
                .with(TYPE, PaymentsAndOtherTransactionTypeGB.INVOICE)
                .with(TableConstants.BillingPaymentsAndTransactionsGB.AMOUNT, modalPremiumAmount.get().toString())
                .containsMatchingRow(1);
    }

    protected void discardedBillVerificationForSelfAdmin() {
        assertThat(BillingSummaryPage.tableBillsAndStatements)
                .with(STATUS, BillsAndStatementsStatusGB.DISCARDED_ESTIMATED)
                .with(CURRENT_DUE, modalPremiumAmount.get())
                .containsMatchingRow(1);


        assertThat(BillingSummaryPage.tableBillingGeneralInformation)
                .with(TableConstants.BillingGeneralInformationGB.CURRENT_DUE, ZERO)
                .with(TOTAL_DUE, ZERO)
                .with(TOTAL_PAID, ZERO)
                .containsMatchingRow(1);

        assertThat(BillingSummaryPage.tablePaymentsOtherTransactions)
                .with(POLICY_NUMBER, masterPolicyNumber.get())
                .with(TYPE, PaymentsAndOtherTransactionTypeGB.DISCARD_INVOICE)
                .with(TableConstants.BillingPaymentsAndTransactionsGB.AMOUNT, String.format("(%s)", modalPremiumAmount.get().toString()))
                .containsMatchingRow(1);
    }

    protected void discardedBillVerificationForFullAdmin() {
        assertThat(BillingSummaryPage.tableBillsAndStatements)
                .with(STATUS, BillsAndStatementsStatusGB.DISCARDED)
                .with(CURRENT_DUE, modalPremiumAmount.get())
                .containsMatchingRow(1);

        assertThat(BillingSummaryPage.tableBillingGeneralInformation)
                .with(TableConstants.BillingGeneralInformationGB.CURRENT_DUE, ZERO)
                .with(TOTAL_DUE, ZERO)
                .with(TOTAL_PAID, ZERO)
                .containsMatchingRow(1);

        assertThat(BillingSummaryPage.tablePaymentsOtherTransactions)
                .with(POLICY_NUMBER, masterPolicyNumber.get())
                .with(TYPE, PaymentsAndOtherTransactionTypeGB.DISCARD_INVOICE)
                .with(TableConstants.BillingPaymentsAndTransactionsGB.AMOUNT, String.format("(%s)", modalPremiumAmount.get().toString()))
                .containsMatchingRow(1);
    }

    protected void regeneratedBillVerificationForSelfAdmin() {
        assertThat(BillingSummaryPage.tableBillingGeneralInformation)
                .with(TableConstants.BillingGeneralInformationGB.CURRENT_DUE, modalPremiumAmount.get())
                .with(TOTAL_DUE, modalPremiumAmount.get())
                .with(TOTAL_PAID, ZERO)
                .containsMatchingRow(1);

        assertThat(BillingSummaryPage.tableBillsAndStatements)
                .with(STATUS, BillsAndStatementsStatusGB.ISSUED_ESTIMATED)
                .with(CURRENT_DUE, modalPremiumAmount.get())
                .containsMatchingRow(1);

        assertThat(BillingSummaryPage.tableBillsAndStatements)
                .with(STATUS, BillsAndStatementsStatusGB.DISCARDED_ESTIMATED)
                .with(CURRENT_DUE, modalPremiumAmount.get())
                .containsMatchingRow(2);

        assertThat(BillingSummaryPage.tablePaymentsOtherTransactions)
                .with(POLICY_NUMBER, masterPolicyNumber.get())
                .with(TYPE, PaymentsAndOtherTransactionTypeGB.INVOICE)
                .with(TableConstants.BillingPaymentsAndTransactionsGB.AMOUNT, modalPremiumAmount.get().toString())
                .containsMatchingRow(1);

        assertThat(BillingSummaryPage.tablePaymentsOtherTransactions)
                .with(POLICY_NUMBER, masterPolicyNumber.get())
                .with(TYPE, PaymentsAndOtherTransactionTypeGB.DISCARD_INVOICE)
                .with(TableConstants.BillingPaymentsAndTransactionsGB.AMOUNT, String.format("(%s)", modalPremiumAmount.get().toString()))
                .containsMatchingRow(2);
    }

    protected void regeneratedBillVerificationForFullAdmin() {
        assertThat(BillingSummaryPage.tableBillingGeneralInformation)
                .with(TableConstants.BillingGeneralInformationGB.CURRENT_DUE, modalPremiumAmount.get())
                .with(TOTAL_DUE, modalPremiumAmount.get())
                .with(TOTAL_PAID, ZERO)
                .containsMatchingRow(1);

        assertThat(BillingSummaryPage.tableBillsAndStatements)
                .with(STATUS, BillsAndStatementsStatusGB.ISSUED)
                .with(CURRENT_DUE, modalPremiumAmount.get())
                .containsMatchingRow(1);

        assertThat(BillingSummaryPage.tableBillsAndStatements)
                .with(STATUS, BillsAndStatementsStatusGB.DISCARDED)
                .with(CURRENT_DUE, modalPremiumAmount.get())
                .containsMatchingRow(2);

        assertThat(BillingSummaryPage.tablePaymentsOtherTransactions)
                .with(POLICY_NUMBER, masterPolicyNumber.get())
                .with(TYPE, PaymentsAndOtherTransactionTypeGB.INVOICE)
                .with(TableConstants.BillingPaymentsAndTransactionsGB.AMOUNT, modalPremiumAmount.get().toString())
                .containsMatchingRow(1);

        assertThat(BillingSummaryPage.tablePaymentsOtherTransactions)
                .with(POLICY_NUMBER, masterPolicyNumber.get())
                .with(TYPE, PaymentsAndOtherTransactionTypeGB.DISCARD_INVOICE)
                .with(TableConstants.BillingPaymentsAndTransactionsGB.AMOUNT, String.format("(%s)", modalPremiumAmount.get().toString()))
                .containsMatchingRow(2);
    }

    protected void verifyTableModalPremium(int rowNumber, String premiumEffectiveDate, String amount, String transactionTypeSubtypeReason) {
        assertThat(ModalPremiumSummaryPage.tableModalPremium.getRow(rowNumber))
                .hasCellWithValue(MODAL_PREMIUM_EFFECTIVE_DATE, premiumEffectiveDate)
                .hasCellWithValue(AMOUNT, amount)
                .hasCellWithValue(TRANSACTION_TYPE_SUBTYPE_REASON, transactionTypeSubtypeReason);
    }

    protected void verifyModalPremiumsTableByBillableCoverage(int rowNumber, int rowIndex, String premiumEffectiveDate, String amount, String transactionTypeSubtypeReason) {
        assertThat(ModalPremiumSummaryPage.getModalPremiumsTableByBillableCoverage(rowIndex).getRow(rowNumber))
                .hasCellWithValue(MODAL_PREMIUM_EFFECTIVE_DATE, premiumEffectiveDate)
                .hasCellWithValue(AMOUNT, amount)
                .hasCellWithValue(TRANSACTION_TYPE_SUBTYPE_REASON, transactionTypeSubtypeReason);
    }

    protected void initModalPremiumValues(){
        if (PolicySummaryPage.tableCoverageSummary.isPresent()) {
            policyPremium.set(PolicySummaryPage.tableCoverageSummary.getPartialValue("Annual Premium")
                    .stream().map(td -> new Currency(td.getValue("Annual Premium"))).reduce(new Currency(0), Currency::add));
            modalPremiumAmount.set(BillingHelperGB.calculateModalPremiumAmount(12, policyPremium.get()));
        }
    }

    protected Currency getModalPremium(){
        Currency policyPremium = PolicySummaryPage.tableCoverageSummary.getPartialValue("Annual Premium")
                .stream().map(td -> new Currency(td.getValue("Annual Premium"))).reduce(new Currency(0), Currency::add);
        return BillingHelperGB.calculateModalPremiumAmount(12, policyPremium);
    }
}