/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.billing.model.billing_customers_payment_methods;

import com.exigen.ren.rest.billing.model.billing_accounts_benefits_payments.BillingAccountsBenefitsPaymentsPaymentDetailsTypeCreditCard;
import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillingCustomersPaymentMethods extends RestError {

    private String id;
    private String type;
    private BillingAccountsBenefitsPaymentsPaymentDetailsTypeCreditCard creditCard;
    private BillingAccountsBenefitsPaymentsPaymentDetailsTypeCreditCard pciCreditCard;
    private BillingAccountsBenefitsPaymentMethodEFT eft;
    private BillingAccountsBenefitsPaymentMethodACH ach;
    private String extensionFields;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BillingAccountsBenefitsPaymentsPaymentDetailsTypeCreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(BillingAccountsBenefitsPaymentsPaymentDetailsTypeCreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public BillingAccountsBenefitsPaymentsPaymentDetailsTypeCreditCard getPciCreditCard() {
        return pciCreditCard;
    }

    public void setPciCreditCard(BillingAccountsBenefitsPaymentsPaymentDetailsTypeCreditCard pciCreditCard) {
        this.pciCreditCard = pciCreditCard;
    }

    public BillingAccountsBenefitsPaymentMethodEFT getEft() {
        return eft;
    }

    public void setEft(BillingAccountsBenefitsPaymentMethodEFT eft) {
        this.eft = eft;
    }

    public BillingAccountsBenefitsPaymentMethodACH getAch() {
        return ach;
    }

    public void setAch(BillingAccountsBenefitsPaymentMethodACH ach) {
        this.ach = ach;
    }

    public String getExtensionFields() {
        return extensionFields;
    }

    public void setExtensionFields(String extensionFields) {
        this.extensionFields = extensionFields;
    }
}

