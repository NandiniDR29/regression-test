/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.billing.model.billing_customers_payment_methods;

import com.exigen.ren.rest.billing.model.billing_accounts_benefits_payments.BillingAccountsBenefitsPaymentsPaymentDetailsTypeCreditCard;
import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillingGETCustomersPaymentMethods extends RestError {

    private String type;
    private BillingAccountsBenefitsPaymentsPaymentDetailsTypeCreditCard creditCard;
    private BillingAccountsBenefitsPaymentsPaymentDetailsTypeCreditCard pciCreditCard;
    private BillingAccountsBenefitsPaymentMethodEFT eft;
    private BillingSavedPaymentMethod savedPaymentMethod;
    private BillingAccountsBenefitsPaymentMethodACH ach;
    private String version;

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

    public BillingSavedPaymentMethod getSavedPaymentMethod() {
        return savedPaymentMethod;
    }

    public void setSavedPaymentMethod(BillingSavedPaymentMethod savedPaymentMethod) {
        this.savedPaymentMethod = savedPaymentMethod;
    }

    public BillingAccountsBenefitsPaymentMethodACH getAch() {
        return ach;
    }

    public void setAch(BillingAccountsBenefitsPaymentMethodACH ach) {
        this.ach = ach;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        if (!super.equals(o)) {return false;}
        BillingGETCustomersPaymentMethods that = (BillingGETCustomersPaymentMethods) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(creditCard, that.creditCard) &&
                Objects.equals(pciCreditCard, that.pciCreditCard) &&
                Objects.equals(eft, that.eft) &&
                Objects.equals(savedPaymentMethod, that.savedPaymentMethod) &&
                Objects.equals(ach, that.ach) &&
                Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, creditCard, pciCreditCard, eft, savedPaymentMethod, ach, version);
    }
}

