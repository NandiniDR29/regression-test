package com.exigen.ren.rest.salesforce;

import com.exigen.ipb.eisa.ws.rest.RestClient;
import com.exigen.ipb.eisa.ws.rest.conf.client.ConfigurationFactory;
import com.exigen.ipb.eisa.ws.rest.conf.metadata.InlineRequestContext;
import com.exigen.ren.rest.ResponseContainer;
import com.exigen.ren.rest.salesforce.model.*;
import com.fasterxml.jackson.databind.DeserializationFeature;


public class SalesforceRestService {

    private RestClient client;
    private SalesforceConfiguration conf;

    public SalesforceRestService() {
        conf = ConfigurationFactory.get(SalesforceConfiguration.class);
        conf.getObjectMapper()
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        client = new RestClient("salesforce", conf);
    }

    /* accountNumber - is the salasforceId (code starting from 001) for the NonIndividual customer */
    public ResponseContainer<SalesforceAccountModel> getAccount(String accountNumber) {
        return new ResponseContainer<>(client.processRequest("ACCOUNT", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().pathParam("accountNumber", accountNumber).build()),
                SalesforceAccountModel.class);
    }

    public ResponseContainer<SalesforceContactModel> getContactByCustomerNumber(String customerNumber) {
        return new ResponseContainer<>(client.processRequest("CONTACT_BY_CUSTOMER", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().pathParam("customerNumber", customerNumber).build()),
                SalesforceContactModel.class);
    }

    public ResponseContainer<ResponseFromItems> getContacts() {
        return new ResponseContainer<>(client.processRequest("CONTACTS", RestClient.HttpMethod.GET, null),
                ResponseFromItems.class);
    }

    public void deleteAccount(String accountNumber) {
        new ResponseContainer<>(client.processRequest("ACCOUNT", RestClient.HttpMethod.DELETE, null,
                InlineRequestContext.builder().pathParam("accountNumber", accountNumber).build()),
                SalesforceAccountModel.class);
    }

    /* relationshipId - is the salasforceId (code starting from 003) for the Relationship (Individual customer ID) */
    public ResponseContainer<SalesforceContactModel> getContact(String relationshipId) {
        return new ResponseContainer<>(client.processRequest("CONTACT", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().pathParam("relationshipId", relationshipId).build()),
                SalesforceContactModel.class);
    }

    /* caseProfileId - is the CaseProfile number */
    public ResponseContainer<SalesforceOpportunityModel> getOpportunity(String caseProfileId) {
        return new ResponseContainer<>(client.processRequest("OPPORTUNITY_BY_EIS_ID", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().pathParam("caseProfileId", caseProfileId).build()),
                SalesforceOpportunityModel.class);
    }

    /* opportunityId - is the salasforceId (code starting from 006) for the NonIndividual case */
    public ResponseContainer<SalesforceOpportunityModel> deleteOpportunity(String opportunityId) {
        return new ResponseContainer<>(client.processRequest("OPPORTUNITY_BY_SF_ID", RestClient.HttpMethod.DELETE, null,
                InlineRequestContext.builder().pathParam("opportunityId", opportunityId).build()),
                SalesforceOpportunityModel.class);
    }

    /* ownerId - is the salasforceId (code starting from 005) for the Users */
    public ResponseContainer<SalesforceUserModel> getUserFromSalesforce(String ownerId) {
        return new ResponseContainer<>(client.processRequest("USER", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().pathParam("ownerId", ownerId).build()),
                SalesforceUserModel.class);
    }

    /* quoteId - is the salasforceId ('quoteNumber' + 'planName' + 'coverage' Insured) for the quote */
    public ResponseContainer<SalesforceQuoteModel> getQuoteFromSalesforce(String quoteId) {
        return new ResponseContainer<>(client.processRequest("QUOTE", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().pathParam("quoteId", quoteId).build()),
                SalesforceQuoteModel.class);
    }
}
