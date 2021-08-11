/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.billing;

import com.exigen.ipb.eisa.base.application.impl.users.User;
import com.exigen.ipb.eisa.ws.rest.RestClient;
import com.exigen.ipb.eisa.ws.rest.conf.client.ConfigurationFactory;
import com.exigen.ipb.eisa.ws.rest.conf.client.JsonConfiguration;
import com.exigen.ipb.eisa.ws.rest.conf.metadata.IRequestContext;
import com.exigen.ipb.eisa.ws.rest.conf.metadata.InlineRequestContext;
import com.exigen.ipb.eisa.ws.rest.conf.metadata.TestDataRequestContext;
import com.exigen.ipb.eisa.ws.rest.util.RestUtil;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.rest.ResponseContainer;
import com.exigen.ren.rest.billing.model.*;
import com.exigen.ren.rest.billing.model.billing_accounts_invoices_regenerate.BillingAccountsInvoicesGenerate;
import com.exigen.ren.rest.billing.model.billing_customers_payment_methods.BillingCustomersPaymentMethods;
import com.exigen.ren.rest.billing.model.billing_customers_payment_methods.BillingGETCustomersPaymentMethods;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BillingRestService {

    private RestClient client;
    private JsonConfiguration configuration;

    public BillingRestService() {
        configuration = ConfigurationFactory.get(JsonConfiguration.class);
        configuration.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        configuration.getObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        client = new RestClient("billing-rs", configuration);
    }

    public List<BillingAccountModel> getCustomersAccounts(String customerNumber, String agencyCd) {
        return client.processRequest("CUSTOMERS.ACCOUNTS", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder()
                        .pathParam("customerNumber", customerNumber)
                        .queryParam("agencyCd", agencyCd).build()).readEntity(
                new GenericType<List<BillingAccountModel>>() {
                });
    }

    public ResponseContainer<List<BillingAccountModel>> getCustomersAccounts(String customerNumber) {
        Response response = client.processRequest("CUSTOMERS.ACCOUNTS", RestClient.HttpMethod.GET, Entity.json(null),
                InlineRequestContext.builder().pathParam("customerNumber", customerNumber).build());
        return new ResponseContainer<>(response, new GenericType<List<BillingAccountModel>>() {
        });
    }

    public ResponseContainer<BillingPaymentMethodResponseModel> postCustomersAddPaymentMethod(String customerNumber, TestData testData) {
        return new ResponseContainer<>(client.processRequest("CUSTOMERS.PAYMENT.METHODS", RestClient.HttpMethod.POST,
                RestUtil.convert(testData, BillingPaymentMethodModel.class, configuration),
                InlineRequestContext.builder().pathParam("customerNumber", customerNumber).build()),
                BillingPaymentMethodResponseModel.class);
    }

    public ResponseContainer<BillingPaymentMethodResponseModel> postCustomersEFTPaymentMethod(String customerNumber, TestData testData) {
        return new ResponseContainer<>(client.processRequest("CUSTOMERS.PAYMENT.METHODS", RestClient.HttpMethod.POST,
                RestUtil.convert(testData, BillingCustomersPaymentMethods.class, configuration),
                InlineRequestContext.builder().pathParam("customerNumber", customerNumber).build()),
                BillingPaymentMethodResponseModel.class);
    }

    public ResponseContainer<List<BillingPaymentMethodResponseModel>> getAllPaymentsMethod(String customerNumber) {
        Response response = client.processRequest("CUSTOMERS.PAYMENT.METHODS", RestClient.HttpMethod.GET,
                Entity.json(null),
                InlineRequestContext.builder().pathParam("customerNumber", customerNumber).build());
        return new ResponseContainer<>(response, new GenericType<List<BillingPaymentMethodResponseModel>>() {
        });
    }

    public ResponseContainer<BillingPaymentMethodResponseModel> putPaymentMethod(TestData td, String customerNumber, String paymentMethodId) {
        return new ResponseContainer<>(client.processRequest("CUSTOMERS.PAYMENT.METHODS.ID", RestClient.HttpMethod.PUT,
                RestUtil.convert(td, BillingCustomersPaymentMethods.class, configuration),
                InlineRequestContext.builder().pathParam("customerNumber", customerNumber).pathParam("paymentMethodId",
                        paymentMethodId).build()), BillingPaymentMethodResponseModel.class);
    }

    public ResponseContainer<BillingGETCustomersPaymentMethods> getPaymentMethod(String customerNumber, String paymentMethodId) {
        return new ResponseContainer<>(client.processRequest("CUSTOMERS.PAYMENT.METHODS.ID", RestClient.HttpMethod.GET,
                Entity.json(null), InlineRequestContext.builder().pathParam("customerNumber", customerNumber)
                        .pathParam("paymentMethodId", paymentMethodId).build()), BillingGETCustomersPaymentMethods.class);
    }

    public Response getSetupPaymentMethod(String customerNumber) {
        return client.processRequest("CUSTOMERS.PAYMENT.SETUP.METHODS", RestClient.HttpMethod.GET,
                Entity.json(null), InlineRequestContext.builder().pathParam("customerNumber", customerNumber).build());
    }

    public Response getPaymentMethodAssignedToPolicyOrBA(String paymentMethodId) {
        return client.processRequest("CUSTOMERS.PAYMENT.ASSIGN.METHODS", RestClient.HttpMethod.GET,
                Entity.json(null), InlineRequestContext.builder().pathParam("paymentMethodId", paymentMethodId).build());
    }

    public Response deletePaymentMethod(String customerNumber, String paymentMethodId) {
        return client.processRequest("CUSTOMERS.PAYMENT.METHODS.ID", RestClient.HttpMethod.DELETE,
                Entity.json(null), InlineRequestContext.builder().pathParam("customerNumber", customerNumber)
                        .pathParam("paymentMethodId", paymentMethodId).build());
    }

    public Response postAccountsBenefitsPayments(String accountNumber, TestData testData) {
        return client.processRequest("ACCOUNTS.BENEFITS.PAYMENTS", RestClient.HttpMethod.POST,
                RestUtil.convert(testData, BillingPaymentModel.class, configuration),
                TestDataRequestContext.of(testData.adjust(TestData.makeKeyPath("query", "accountNumber"), accountNumber)));
    }

    public ResponseContainer<BillingPaymentResponseModel> postaccountspayments(String accountNumber, TestData testData) {
        return new ResponseContainer<>(client.processRequest("ACCOUNTS.PAYMENTS", RestClient.HttpMethod.POST,
                RestUtil.convert(testData, BillingPaymentModel.class, configuration),
                InlineRequestContext.builder().pathParam("accountNumber", accountNumber).build()),
                BillingPaymentResponseModel.class);
    }

    public ResponseContainer<BillingInvoiceModel> postAccountsGenerateFutureStatement(String accountNumber, LocalDateTime dueDate) {
        return new ResponseContainer<>(client.processRequest("ACCOUNTS.GENERATE.FUTURE.STATEMENT",
                RestClient.HttpMethod.POST, new BillingInvoiceModel(dueDate),
                InlineRequestContext.builder().pathParam("accountNumber", accountNumber).build()), BillingInvoiceModel.class);
    }

    public ResponseContainer<BillingPaymentResponseModel> postAccountsTransactions(String accountNumber, BillingAccountTransactionModel billingAccountTransactionModel) {
        return new ResponseContainer<>(client.processRequest("ACCOUNTS.TRANSACTIONS", RestClient.HttpMethod.POST,
                billingAccountTransactionModel, InlineRequestContext.builder().pathParam("accountNumber", accountNumber).build()),
                BillingPaymentResponseModel.class);
    }

    public Response getAccountsTransactions(String accountNumber) {
        return client.processRequest("ACCOUNTS.TRANSACTIONS", RestClient.HttpMethod.GET,
                Entity.json(null), InlineRequestContext.builder().pathParam("accountNumber", accountNumber).build());
    }

    public Response postAccountsStatementDiscard(String accountNumber, String invoiceNumber) {
        return client.processRequest("ACCOUNTS.STATEMENTS.DISCARD", RestClient.HttpMethod.POST,
                Entity.json(null), InlineRequestContext.builder()
                        .pathParam("accountNumber", accountNumber)
                        .pathParam("invoiceNumber", invoiceNumber).build());
    }

    public ResponseContainer<BillingPaymentResponseModel> postAccountsRefunds(String accountNumber, TestData data) {
        return new ResponseContainer<>(client.processRequest("ACCOUNTS.REFUNDS", RestClient.HttpMethod.POST,
                RestUtil.convert(data, BillingRefundModel.class, configuration), InlineRequestContext.builder()
                        .pathParam("accountNumber", accountNumber).build()),
                BillingPaymentResponseModel.class);
    }

    public Response putAccountsRefunds(String accountNumber, TestData data) {
        return client.processRequest("ACCOUNTS.REFUNDS", RestClient.HttpMethod.PUT,
                RestUtil.convert(data, BillingPaymentCustomAllocationModel.class, configuration), InlineRequestContext.builder()
                        .pathParam("accountNumber", accountNumber).build());
    }

    public Response getAccountsStatements(String accountNumber) {
        return client.processRequest("ACCOUNTS.STATEMENTS", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder()
                        .pathParam("accountNumber", accountNumber)
                        .build());
    }

    public Response getAccountsInvoiceStatementDocument(String accountNumber, String invoiceNumber) {
        return client.processRequest("ACCOUNTS.STATEMENTS.DOWNLOAD", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder()
                        .pathParam("accountNumber", accountNumber)
                        .pathParam("invoiceNumber", invoiceNumber).build());
    }

    public Response getAccountsInvoiceStatementDocument(String accountNumber, String invoiceNumber, Predicate<Response> predicate) {
        boolean condition = false;
        Response response = null;
        int amountOfAttempts = 150;
        while (!condition && amountOfAttempts-- > 0) {
            response = getAccountsInvoiceStatementDocument(accountNumber, invoiceNumber);
            condition = predicate.test(response);
            Waiters.SLEEP(1000).go();
        }
        return response;
    }

    public Response getAccountsBillingAccount(String policyNumber, LocalDateTime effectiveDate) {
        return client.processRequest("ACCOUNTS", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder()
                        .queryParam("policyNumber", policyNumber)
                        .queryParam("effectiveDate", effectiveDate.toLocalDate().toString()).build());
    }

    public Response putAccountBillingRefundPayment(String accountNumber, String policyNumber, String paymentMethodId,
                                                   LocalDateTime effectiveDate) {
        return client.processRequest("ACCOUNTS.REFUND.PAYMENT.METHODS", RestClient.HttpMethod.PUT,
                new BillingPaymentRefundModel(paymentMethodId, policyNumber, effectiveDate.toString()), InlineRequestContext.builder()
                        .pathParam("accountNumber", accountNumber)
                        .build());
    }

    public Response putAccountBillingRecurringPayment(String accountNumber, String policyNumber, String paymentMethodId,
                                                      LocalDateTime effectiveDate) {
        return client.processRequest("ACCOUNTS.RECURRING.PAYMENT.METHODS", RestClient.HttpMethod.PUT,
                new BillingPaymentRefundModel(paymentMethodId, policyNumber, effectiveDate.toLocalDate().toString()), InlineRequestContext.builder()
                        .pathParam("accountNumber", accountNumber)
                        .build());
    }

    public ResponseContainer<List<BillingAccountsInvoicesGenerate>> getAccountsAccountNumber(String accountNumber) {
        return new ResponseContainer<>(client.processRequest("ACCOUNTS.ACCOUNT.NUMBER", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().pathParam("accountNumber", accountNumber).build()),
                new GenericType<List<BillingAccountsInvoicesGenerate>>(){});
    }

    public Response getAccountBillingRecurringPayment(String accountNumber) {
        return client.processRequest("ACCOUNTS.RECURRING.PAYMENT.METHODS", RestClient.HttpMethod.GET,
                Entity.json(null), InlineRequestContext.builder()
                        .pathParam("accountNumber", accountNumber)
                        .build());
    }

    public Response putAccountBillingUpdateInformation(String accountNumber, TestData data) {
        return client.processRequest("ACCOUNTS.ACCOUNT.NUMBER", RestClient.HttpMethod.PUT,
                RestUtil.convert(data, BillingAccountModel.class, configuration), InlineRequestContext.builder()
                        .pathParam("accountNumber", accountNumber).build());
    }

    public ResponseContainer<List<BillingAccountsActionsModel>> getAccountBillingReturnActions(String accountNumber){
        return new ResponseContainer<>(client.processRequest("ACCOUNTS.ACTIONS", RestClient.HttpMethod.GET, Entity.json(null),
                InlineRequestContext.builder().pathParam("accountNumber", accountNumber)
                        .build()),   new GenericType<List<BillingAccountsActionsModel>>(){});
    }


    public Response getAccountBillingPoliciesTerms(String accountNumber) {
        return client.processRequest("ACCOUNTS.POLICIES", RestClient.HttpMethod.GET,
                Entity.json(null), InlineRequestContext.builder().pathParam("accountNumber", accountNumber)
                        .build());
    }

    public Response getAccountBillingInstallments(String accountNumber) {
        return client.processRequest("ACCOUNTS.INSTALLMENTS", RestClient.HttpMethod.GET,
                Entity.json(null), InlineRequestContext.builder().pathParam("accountNumber", accountNumber)
                        .build());
    }

    public Response postAccountsPaymentCustomAllocation(String accountNumber, TestData data) {
        return client.processRequest("ACCOUNTS.PAYMENTS.PAY.BY.POLICY", RestClient.HttpMethod.POST,
                RestUtil.convert(data, BillingPaymentCustomAllocationModel.class, configuration), InlineRequestContext.builder()
                        .pathParam("accountNumber", accountNumber).build());
    }

    public Response postAccountRefundAllocations(String accountNumber, List<TestData> data) {
        return client.processRequest("ACCOUNTS.REFUNDS.CALCULATE.ALLOCATIONS", RestClient.HttpMethod.POST,
                data.stream().map(td -> RestUtil.convert(td, AllocationModel.class, configuration))
                        .collect(Collectors.toList()), InlineRequestContext.builder().pathParam("accountNumber", accountNumber)
                        .build());
    }

    public Response postAccountPaymentsAllocations(String accountNumber, List<TestData> data) {
        return client.processRequest("ACCOUNTS.PAYMENTS.CALCULATE.ALLOCATIONS", RestClient.HttpMethod.POST,
                data.stream().map(td -> RestUtil.convert(td, AllocationModel.class, configuration))
                        .collect(Collectors.toList()), InlineRequestContext.builder()
                        .pathParam("accountNumber", accountNumber).build());
    }

    public ResponseContainer<BillingPaymentResponseModel> postAccountRefundByPolicy(String accountNumber, TestData data) {
        return new ResponseContainer<>(client.processRequest("ACCOUNTS.REFUNDS.BY.POLICY", RestClient.HttpMethod.POST,
                RestUtil.convert(data, BillingPaymentCustomAllocationModel.class, configuration), InlineRequestContext.builder()
                        .pathParam("accountNumber", accountNumber).build()), BillingPaymentResponseModel.class);
    }

    public Response postTransactionsDeclinePayment(String transactionNumber, String declineReason) {
        return client.processRequest("TRANSACTIONS.PAYMENT.DECLINE", RestClient.HttpMethod.POST,
                new BillingTransactionDeclineModel(declineReason), InlineRequestContext.builder().pathParam("transactionNumber", transactionNumber).build());
    }

    public Response postTransactionsRefundApproveReject(String transactionNumber, boolean approve) {
        return client.processRequest("TRANSACTIONS.REFUND.APPROVE.REJECT", RestClient.HttpMethod.POST,
                Entity.json(null), InlineRequestContext.builder()
                        .pathParam("transactionNumber", transactionNumber)
                        .pathParam("approve", approve ? "approve" : "reject").build());
    }

    public Response postTransactionsRefundApproveReject(String transactionNumber, boolean approve, User user) {
        return client.processRequest("TRANSACTIONS.REFUND.APPROVE.REJECT", RestClient.HttpMethod.POST,
                Entity.json(null), InlineRequestContext.builder()
                        .user(user)
                        .pathParam("transactionNumber", transactionNumber)
                        .pathParam("approve", approve ? "approve" : "reject").build());
    }

    public Response postTransactionsFeeWaive(String transactionNumber) {
        return client.processRequest("TRANSACTIONS.FEE.WAIVE", RestClient.HttpMethod.POST,
                Entity.json(null), InlineRequestContext.builder()
                        .pathParam("transactionNumber", transactionNumber).build());
    }

    public Response postPoliciesGenerateCancelNotice(String policyNumber, TestData data) {
        return client.processRequest("POLICIES.GENERATE.CANCEL.NOTICE", RestClient.HttpMethod.POST,
                RestUtil.convert(data, BillingCancelNoticeModel.class, configuration), InlineRequestContext.builder()
                        .pathParam("policyNumber", policyNumber).build());
    }

    public Response postPolicyHold(TestData testData) {
        return client.processRequest("BILLING.HOLDS", RestClient.HttpMethod.POST, RestUtil.convert(testData, BillingPolicyHolderModel.class));
    }

    public ResponseContainer<List<BillingPolicyHolderModel>> getPolicyHold(IRequestContext reqParam) {
        return new ResponseContainer<>(client.processRequest("BILLING.HOLDS", RestClient.HttpMethod.GET, null, reqParam), new GenericType<List<BillingPolicyHolderModel>>() {
        });
    }

    public Response putPolicyHold(String holdID, TestData testData) {
        return client.processRequest("BILLING.HOLDS.PUT.DELETE", RestClient.HttpMethod.PUT,
                RestUtil.convert(testData, BillingPolicyHolderModel.class), InlineRequestContext.builder().
                        header("Content-Type", "application/json").pathParam("holdId", holdID).build());
    }

    public Response deletePolicyHold(String holdID) {
        return client.processRequest("BILLING.HOLDS.PUT.DELETE", RestClient.HttpMethod.DELETE, null,
                InlineRequestContext.builder().pathParam("holdId", holdID).header("Content-Type", "application/json").build());
    }

    public Response getAvailablePaymentPlans(String dueDayConfig) {
        return client.processRequest("POLICIES.AVAILABLE.PAYMENT.PLANS", RestClient.HttpMethod.GET, Entity.json(null)
                , InlineRequestContext.builder()
                        .queryParam("dueDayConfig", dueDayConfig).build());
    }

    public Response postCalculateInstallmentsScheduleStarts(String policyNumber, String billingAccountNumber, TestData data) {
        return client.processRequest("POLICIES.CALCULATE.INSTALLMENTS.SCHEDULE.START.DATES", RestClient.HttpMethod.POST,
                RestUtil.convert(data.adjust("billingAccountNumber", billingAccountNumber), PaymentModel.class, configuration), InlineRequestContext.builder()
                        .pathParam("policyNumber", policyNumber).build());
    }

    public Response postCalculateInstallmentsSchedule(String policyNumber, String billingAccountNumber, TestData data) {
        return client.processRequest("POLICIES.CALCULATE.INSTALLMENTS.SCHEDULE", RestClient.HttpMethod.POST,
                RestUtil.convert(data.adjust("billingAccountNumber", billingAccountNumber), PaymentModel.class, configuration), InlineRequestContext.builder()
                        .pathParam("policyNumber", policyNumber).build());
    }

    public Response getBatchPayment() {
        return client.processRequest("BILLING.BATCH.PAYMENT", RestClient.HttpMethod.GET, Entity.json(null));
    }

    public Response getBatchAdjustment() {
        return client.processRequest("BILLING.BATCH.ADJUSTMENT", RestClient.HttpMethod.GET, Entity.json(null));
    }

    public Response getBulkPayment() {
        return client.processRequest("BILLING.BULK.PAYMENTS", RestClient.HttpMethod.GET, Entity.json(null));
    }

    public Response getAgencyPayment() {
        return client.processRequest("BILLING.AGENCY.PAYMENTS", RestClient.HttpMethod.GET, Entity.json(null));
    }

    public Response getSuspense() {
        return client.processRequest("BILLING.SUSPENSE", RestClient.HttpMethod.GET, Entity.json(null));
    }

    public Response getTransactionsByType(String transactionType) {
        return client.processRequest("BILLING.CONFIGURATION.TRANSACTIONS", RestClient.HttpMethod.GET,
                Entity.json(null), InlineRequestContext.builder().queryParam("transactionType", transactionType).build());
    }

    public Response getPaymentMethodTypes() {
        return client.processRequest("BILLING.CONFIGURATION.PAYMENT.METHOD", RestClient.HttpMethod.GET, Entity.json(null));
    }

    public Response getAllHoldReason() {
        return client.processRequest("BILLING.CONFIGURATION.HOLD.REASON", RestClient.HttpMethod.GET, Entity.json(null));
    }

    public Response getAllDownPaymentReason() {
        return client.processRequest("BILLING.CONFIGURATION.DOWN.REASON", RestClient.HttpMethod.GET, Entity.json(null));
    }

    public Response getRefundPaymentMethod() {
        return client.processRequest("BILLING.CONFIGURATION.REFUND.METHOD", RestClient.HttpMethod.GET, Entity.json(null));
    }

    public Response getAllHoldTypes() {
        return client.processRequest("BILLING.CONFIGURATION.HOLD.TYPES", RestClient.HttpMethod.GET, Entity.json(null));
    }

    public Response getAllRefundReasons() {
        return client.processRequest("BILLING.CONFIGURATION.REFUND.REASON", RestClient.HttpMethod.GET, Entity.json(null));
    }

    public Response getDeclinePaymentReasonByDeclinePayment(String paymentMethodType) {
        return client.processRequest("BILLING.CONFIGURATION.REASONS.DECLINE", RestClient.HttpMethod.GET,
                Entity.json(null), InlineRequestContext.builder().queryParam("paymentMethodType", paymentMethodType).build());
    }

    public Response getDeclinePaymentReasonByTransferPayment(String paymentMethodType) {
        return client.processRequest("BILLING.CONFIGURATION.REASONS.TRANSFER", RestClient.HttpMethod.GET,
                Entity.json(null), InlineRequestContext.builder().queryParam("paymentMethodType", paymentMethodType).build());
    }

    public ResponseContainer<List<ExcludeReasonModel>> getNSFExcludeReasons() {
        Response response = client.processRequest("BILLING.CONFIGURATION.NSF.EXCLUDE.REASONS", RestClient.HttpMethod.GET, Entity.json(null));
        return new ResponseContainer<>(response, new GenericType<List<ExcludeReasonModel>>() {});
    }

    public ResponseContainer<List<NsfCounterModel>> getNsfCounters(String policyNumber, LocalDateTime effectiveDate) {
        Response response = client.processRequest("POLICIES.NSF.COUNTERS", RestClient.HttpMethod.GET,
                Entity.json(null), InlineRequestContext.builder().pathParam("policyNumber", policyNumber)
                        .queryParam("effectiveDate", effectiveDate.toLocalDate().toString()).build());
        return new ResponseContainer<>(response, new GenericType<List<NsfCounterModel>>() {});
    }

    public Response putNsfCancellation(String policyNumber,boolean ignoredByNsfCancellation, LocalDateTime effectiveDate) {
        return client.processRequest("POLICIES.NSF.CANCELLATION", RestClient.HttpMethod.PUT,
                Entity.json(String.format("{\"ignoredByNsfCancellation\": %b }", ignoredByNsfCancellation)), InlineRequestContext.builder()
                        .pathParam("policyNumber", policyNumber).queryParam("effectiveDate", effectiveDate.toLocalDate().toString()).build());
    }

    public Response postNsfCounter(String policyNumber, NsfCounterModel nsfCounterModel, LocalDateTime effectiveDate) {
        return client.processRequest("POLICIES.NSF.COUNTER", RestClient.HttpMethod.POST, nsfCounterModel, InlineRequestContext.builder()
                .pathParam("policyNumber", policyNumber).queryParam("effectiveDate", effectiveDate.toLocalDate().toString()).build());
    }

    public ResponseContainer<List<TransactionActionsModel>> getTransactionActions(String transactionNumber) {
        return new ResponseContainer<>(client.processRequest("TRANSACTIONS.ACTIONS", RestClient.HttpMethod.GET, null, InlineRequestContext.builder()
                .pathParam("transactionNumber", transactionNumber).build()), new GenericType<List<TransactionActionsModel>>() {});
    }

    public Response postTransactionClearPayment(String transactionNumber) {
        return client.processRequest("TRANSACTIONS.PAYMENT.CLEAR", RestClient.HttpMethod.POST, null, InlineRequestContext.builder()
                .header("Content-Type", "application/json").pathParam("transactionNumber", transactionNumber).build());
    }

    public ResponseContainer<List<BillingAccountTransactionModel>> getTransactions(String policyNumber, LocalDateTime effectiveDate) {
        Response response = client.processRequest("POLICIES.TRANSACTIONS", RestClient.HttpMethod.GET,
                Entity.json(null), InlineRequestContext.builder().pathParam("policyNumber", policyNumber)
                        .queryParam("effectiveDate", effectiveDate.toLocalDate().toString()).build());
        return new ResponseContainer<>(response, new GenericType<List<BillingAccountTransactionModel>>() {
        });
    }

    public Response getInstallments(String policyNumber, LocalDateTime effectiveDate) {
        return client.processRequest("POLICIES.INSTALLMENTS", RestClient.HttpMethod.GET,
                Entity.json(null), InlineRequestContext.builder().pathParam("policyNumber", policyNumber)
                        .queryParam("effectiveDate", effectiveDate.toLocalDate().toString()).build());
    }

    public Response getStatements(String policyNumber, LocalDateTime effectiveDate) {
        return client.processRequest("POLICIES.STATEMENTS", RestClient.HttpMethod.GET,
                Entity.json(null), InlineRequestContext.builder().pathParam("policyNumber", policyNumber)
                        .queryParam("effectiveDate", effectiveDate.toLocalDate().toString()).build());
    }

    public Response getPolicy(String policyNumber, LocalDateTime effectiveDate) {
        return client.processRequest("POLICIES", RestClient.HttpMethod.GET,
                Entity.json(null), InlineRequestContext.builder().pathParam("policyNumber", policyNumber)
                        .queryParam("effectiveDate", effectiveDate.toLocalDate().toString()).build());
    }

    public Response postPrecalculateForPaymentPlan(String paymentPlan, TestData data, String policyNumber) {
        return client.processRequest("POLICIES.PRECALCULATE.FOR.PAYMENT.PLAN", RestClient.HttpMethod.POST,
                Arrays.asList(RestUtil.convert(data.adjust("policyNumber", policyNumber), PolicyModel.class, configuration)), InlineRequestContext.builder()
                        .pathParam("paymentPlanCd", paymentPlan).build());
    }
}
