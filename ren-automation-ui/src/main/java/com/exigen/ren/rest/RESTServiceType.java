/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest;

import com.exigen.ren.rest.billing.BillingRestService;
import com.exigen.ren.rest.customer.CustomerRestService;
import com.exigen.ren.rest.customer.RenCustomerRestService;
import com.exigen.ren.rest.dxp.DxpRestService;
import com.exigen.ren.rest.integration.IntegrationRestService;
import com.exigen.ren.rest.partysearch.PartySearchRestService;
import com.exigen.ren.rest.platform.bpm.AgencyVendorRestService;
import com.exigen.ren.rest.platform.bpm.BPMRestService;
import com.exigen.ren.rest.platform.notes.NotesRestService;
import com.exigen.ren.rest.platform.providers.ProviderRestService;
import com.exigen.ren.rest.policyBenefits.enrollmentServices.EnrollmentRestService;
import com.exigen.ren.rest.policyBenefits.services.ServicesRestService;
import com.exigen.ren.rest.productfactory.ProductDecisionTableRestService;
import com.exigen.ren.rest.rating.RatingReportRestService;
import com.exigen.ren.rest.salesforce.SalesforceRestService;

public enum RESTServiceType {

    NOTES("Notes REST", new NotesRestService()),
    BPM("Tasks REST", new BPMRestService()),
    PARTY_SEARCH("PartySearch REST", new PartySearchRestService()),
    CUSTOMERS("Customer REST", new CustomerRestService()),
    BILLING("Billing REST", new BillingRestService()),
    PROVIDER("Provider REST", new ProviderRestService()),
    AGENCYVENDOR("Agency REST", new AgencyVendorRestService()),
    PRODUCT_DECISION_TABLE("Product Decision Table REST", new ProductDecisionTableRestService()),
    DXP("DXP", new DxpRestService()),
    REN_CUSTOMERS("Ren Customers REST", new RenCustomerRestService()),
    RATING_REPORT("Rating Report", new RatingReportRestService()),
    SALESFORCE("Salesforce", new SalesforceRestService()),
    ENROLLMENT_SERVICES_REST_SERVICE("Enrollment Services", new EnrollmentRestService()),
    INTEGRATION("Integration REST", new IntegrationRestService()),
    POLICY_BENEFITS_SERVICES("Policy Benefits Services REST", new ServicesRestService());

    private String restServiceClientName;
    private Object client;

    RESTServiceType(String n, Object p) {
        restServiceClientName = n;
        client = p;
    }

    public <T extends Object> T get() {
        return (T) client;
    }

    public String getName() {
        return restServiceClientName;
    }

    public String getKey() {
        return client.getClass().getSimpleName();
    }

    public String getTypeKey() {
        return this.getClass().getSimpleName().replace("Type", "").toLowerCase();
    }

}
