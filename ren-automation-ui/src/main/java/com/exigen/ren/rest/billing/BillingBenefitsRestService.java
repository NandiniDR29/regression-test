/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.billing;

import com.exigen.ipb.eisa.base.application.impl.users.User;
import com.exigen.ipb.eisa.ws.rest.RestClient;
import com.exigen.ipb.eisa.ws.rest.conf.client.ConfigurationFactory;
import com.exigen.ipb.eisa.ws.rest.conf.client.JsonConfiguration;
import com.exigen.ipb.eisa.ws.rest.conf.metadata.InlineRequestContext;
import com.exigen.ipb.eisa.ws.rest.util.RestUtil;
import com.exigen.istf.data.TestData;
import com.exigen.ren.rest.ResponseContainer;
import com.exigen.ren.rest.billing.model.*;
import com.exigen.ren.rest.billing.model.billing_accounts_benefits_payments.BillingAccountsBenefitsPayments;
import com.exigen.ren.rest.billing.model.billing_accounts_invoices.BillingAccountsInvoices;
import com.exigen.ren.rest.billing.model.billing_accounts_invoices.BillingAccountsInvoicesCoveragesParticipants;
import com.exigen.ren.rest.billing.model.billing_accounts_invoices_regenerate.BillingAccountsInvoicesGenerate;
import com.exigen.ren.rest.billing.model.billing_accounts_invoices_regenerate.BillingAccountsInvoicesRegenerate;
import com.exigen.ren.rest.billing.model.billing_payment.BillingAccountPayment;
import com.exigen.ren.rest.billing.model.billing_policies_grace_period.BillingPoliciesGracePeriod;
import com.exigen.ren.rest.billing.model.billing_policies_paid_to_date.billing_policies_grace_period.BillingPoliciesPaidToDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.List;

public class BillingBenefitsRestService {

    private RestClient client;

    public BillingBenefitsRestService() {
        JsonConfiguration configuration = ConfigurationFactory.get(JsonConfiguration.class);
        configuration.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        configuration.getObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        client = new RestClient("billing-benefits-rs", configuration);
    }
    public BillingBenefitsRestService(User user) {
        JsonConfiguration configuration = ConfigurationFactory.get(JsonConfiguration.class, user);
        configuration.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        configuration.getObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        client = new RestClient("billing-benefits-rs", configuration);
    }

    public ResponseContainer<BillingGenerateDraftBillModel> postGenerateDraftBill(String accountNumber) {
        return new ResponseContainer<>(client.processRequest("ACCOUNTS.GENERATE.DRAFT.BILL", RestClient.HttpMethod.POST, Entity.json(null),
                InlineRequestContext.builder().pathParam("accountNumber", accountNumber).build()),
                BillingGenerateDraftBillModel.class);
    }

    public ResponseContainer<BillingGenerateDraftBillModel> postGenerateDraftBill(String accountNumber, String xClientId) {
        return new ResponseContainer<>(client.processRequest("ACCOUNTS.GENERATE.DRAFT.BILL", RestClient.HttpMethod.POST, Entity.json(null),
                InlineRequestContext.builder().header("X-Client-Application-ID", xClientId).pathParam("accountNumber", accountNumber).build()),
                BillingGenerateDraftBillModel.class);
    }

    public ResponseContainer<BillingAccountsBenefitsPayments> postAccountsBenefitsPayments(String referenceNumber, String invoiceNumber, TestData td) {
        return new ResponseContainer<>(client.processRequest("ACCOUNTS.BENEFITS.PAYMENTS", RestClient.HttpMethod.POST,
                RestUtil.convert(td, BillingAccountsBenefitsPayments.class),
                InlineRequestContext.builder()
                        .queryParam("referenceNumber", referenceNumber)
                        .queryParam("invoiceNumber", invoiceNumber).build()),
                BillingAccountsBenefitsPayments.class);
    }

    public ResponseContainer<BillingAccountsDocumentGenerationStatus> getAccountsDocumentGenerationStatus(String docgenTicket) {
        return new ResponseContainer<>(client.processRequest("ACCOUNTS.DOCUMENTS.GENERATION.STATUS", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().pathParam("docgenTicket", docgenTicket).build()),
                BillingAccountsDocumentGenerationStatus.class);
    }

    public ResponseContainer<BillingAccountsInvoices> getAccountsInvoices(String accountNumber, String invoiceNumber) {
        return new ResponseContainer<>(client.processRequest("ACCOUNTS.INVOICES", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder()
                        .pathParam("accountNumber", accountNumber)
                        .pathParam("invoiceNumber", invoiceNumber).build()),
                BillingAccountsInvoices.class);
    }

    public ResponseContainer<List<BillingAccountsInvoicesCoveragesParticipants>> getAccountsInvoicesCoveragesParticipants(String accountNumber, String invoiceNumber, String referenceNumber) {
        return new ResponseContainer<>(client.processRequest("ACCOUNTS.INVOICES.COVERAGES.PARTICIPANTS", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder()
                        .pathParam("accountNumber", accountNumber).pathParam("invoiceNumber", invoiceNumber).pathParam("referenceNumber", referenceNumber).build()),
                new GenericType<List<BillingAccountsInvoicesCoveragesParticipants>>(){});
    }


    public ResponseContainer<List<BillingAccountsInvoicesGenerate>> getAccountsAccountNumberInvoices(String accountNumber) {
        return new ResponseContainer<>(client.processRequest("ACCOUNTS.ACCOUNTNUMBER.INVOICES", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().pathParam("accountNumber", accountNumber).build()),
                new GenericType<List<BillingAccountsInvoicesGenerate>>(){});
    }


    public ResponseContainer<List<BillingAccountPayment>> getAccountsAccountNumberPayments(String accountNumber, String transactionDateStart,
                                                                                           String transactionDateEnd, String effectiveDateStart, String effectiveDateEnd, String offset, String limit) {
        return new ResponseContainer<>(client.processRequest("ACCOUNTS.ACCOUNTNUMBER.PAYMENTS", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().pathParam("accountNumber", accountNumber)
                        .queryParam("transactionDateStart", transactionDateStart)
                        .queryParam("transactionDateEnd", transactionDateEnd)
                        .queryParam("effectiveDateStart", effectiveDateStart)
                        .queryParam("effectiveDateEnd", effectiveDateEnd)
                        .queryParam("offset", offset)
                        .queryParam("limit", limit).build()),
                new GenericType<List<BillingAccountPayment>>(){});
    }

    public ResponseContainer<List<BillingInvoiceCoveragePeriodModel>> getAccountsInvoiceCoveragePeriods(String accountNumber) {
        return new ResponseContainer<>(client.processRequest("ACCOUNTS.INVOICE.COVERAGE.PERIODS", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().pathParam("accountNumber", accountNumber).build()),
                new GenericType<List<BillingInvoiceCoveragePeriodModel>>(){});
    }

    public ResponseContainer<BillingInvoiceCoveragePeriodDateModel> getAccountsInvoiceCoveragePeriodsWithDate(String accountNumber, String startDate, String endDate) {
        return new ResponseContainer<>(client.processRequest("ACCOUNTS.INVOICE.COVERAGE.PERIODS.DATE", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().pathParam("accountNumber", accountNumber)
                        .pathParam("startDate", startDate).pathParam("endDate", endDate).build()),
                new GenericType<BillingInvoiceCoveragePeriodDateModel>(){});
    }

    public ResponseContainer<BillingInvoiceCoveragePeriodDateModel> putAccountsInvoiceCoveragePeriodsWithDate(BillingInvoiceCoveragePeriodDatePUTModel model, String accountNumber, String startDate, String endDate) {
        return new ResponseContainer<>(client.processRequest("ACCOUNTS.INVOICE.COVERAGE.PERIODS.DATE", RestClient.HttpMethod.PUT, model,
                InlineRequestContext.builder().pathParam("accountNumber", accountNumber)
                        .pathParam("startDate", startDate).pathParam("endDate", endDate).build()),
                new GenericType<BillingInvoiceCoveragePeriodDateModel>(){});
    }

    public ResponseContainer<BillingAccountsInvoicesRegenerate> postAccountsInvoicesRegenerate(String accountNumber, String invoiceNumber) {
        return new ResponseContainer<>(client.processRequest("ACCOUNTS.INVOICES.REGENERATE", RestClient.HttpMethod.POST, null,
                InlineRequestContext.builder()
                        .pathParam("accountNumber", accountNumber)
                        .pathParam("invoiceNumber", invoiceNumber).build()),
                BillingAccountsInvoicesRegenerate.class);
    }

    public ResponseContainer<BillingAccountsInvoicesGenerate> postAccountsInvoicesGenerate(String accountNumber) {
        return new ResponseContainer<>(client.processRequest("ACCOUNTS.INVOICES.GENERATE", RestClient.HttpMethod.POST, null,
                InlineRequestContext.builder()
                        .pathParam("accountNumber", accountNumber).build()),
                BillingAccountsInvoicesGenerate.class);
    }

    public ResponseContainer<BillingAccountsInvoicesGenerate> postAccountsInvoicesGenerate(String accountNumber, String xClientId) {
        return new ResponseContainer<>(client.processRequest("ACCOUNTS.INVOICES.GENERATE", RestClient.HttpMethod.POST, null,
                InlineRequestContext.builder().header("X-Client-Application-ID", xClientId)
                        .pathParam("accountNumber", accountNumber).build()),
                BillingAccountsInvoicesGenerate.class);
    }

    public ResponseContainer<BillingPoliciesGracePeriod> getPoliciesGracePeriod(String policyNumber, LocalDateTime effectiveDate) {
        return new ResponseContainer<>(client.processRequest("POLICIES.GRACE.PERIOD", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder()
                        .pathParam("policyNumber", policyNumber).queryParam("effectiveDate", effectiveDate.toLocalDate().toString()).build()),
                BillingPoliciesGracePeriod.class);
    }

    public ResponseContainer<BillingPoliciesPaidToDate> getPoliciesPaidToDate(String policyNumber, LocalDateTime effectiveDate) {
        return new ResponseContainer<>(client.processRequest("POLICIES.PAID.TO.DATE", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder()
                        .pathParam("policyNumber", policyNumber).queryParam("policyEffectiveDate", effectiveDate.toLocalDate().toString()).build()),
                BillingPoliciesPaidToDate.class);
    }

    public ResponseContainer<List<BillingBenefitsAccountsModel>> getAccountsBillingAccount(List<String> listCustomerNumbers, String accountNumber,  String masterPolicyNumber,
                                                                                           String offset, String limit, List<String> listSort, String billingAccountTypeCd) {
        MultivaluedMap<String, String> params = new MultivaluedHashMap<>();
        params.putSingle("accountNumber", accountNumber);
        params.putSingle("masterPolicyNumber", masterPolicyNumber);
        params.putSingle("billingAccountTypeCd", billingAccountTypeCd);
        params.putSingle("offset", offset);
        params.putSingle("limit", limit);
        params.put("customerNumber", listCustomerNumbers);
        params.put("sort", listSort);
        Response response = client.processRequest("ACCOUNTS", RestClient.HttpMethod.GET,
                Entity.json(null), InlineRequestContext.builder()
                        .queryParams(params).build());
        return new ResponseContainer<>(response, new GenericType<List<BillingBenefitsAccountsModel>>() {
        });
    }

    public ResponseContainer<List<BillingAccountsInvoicesGenerate>> getCustomerInvoices(String customerNumber, String accountNumber, String invoiceNumber, String dueDateStart, String dueDateEnd, String offset,String limit){
        return new ResponseContainer<>(client.processRequest("CUSTOMER.INVOICES", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().pathParam("customerNumber", customerNumber)
                        .queryParam("accountNumber", accountNumber)
                        .queryParam("invoiceNumber", invoiceNumber)
                        .queryParam("dueDateStart", dueDateStart)
                        .queryParam("customerNumber", customerNumber)
                        .queryParam("dueDateEnd", dueDateEnd)
                        .queryParam("offset", offset).queryParam("limit", limit).build()),
                new GenericType<List<BillingAccountsInvoicesGenerate>>(){});
    }
}
