/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.billing.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author arutski
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingPaymentRefundModel extends Model {

    private String paymentMethodId;
    private String policyNumber;
    private String policyEffectiveDate;

    public BillingPaymentRefundModel(String paymentMethodId, String policyNumber, String policyEffectiveDate) {
        this.paymentMethodId = paymentMethodId;
        this.policyNumber = policyNumber;
        this.policyEffectiveDate = policyEffectiveDate;
    }
    public BillingPaymentRefundModel() { }

    public String getPaymentMethodId() { return paymentMethodId; }

    public String getPolicyNumber() { return policyNumber; }

    public String getPolicyEffectiveDate() { return policyEffectiveDate; }

    public void setPaymentMethodId(String paymentMethodId) { this.paymentMethodId = paymentMethodId; }

    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }

    public void setPolicyEffectiveDate(String policyEffectiveDate) { this.policyEffectiveDate = policyEffectiveDate; }
}
