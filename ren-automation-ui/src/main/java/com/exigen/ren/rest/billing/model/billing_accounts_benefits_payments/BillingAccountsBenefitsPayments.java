package com.exigen.ren.rest.billing.model.billing_accounts_benefits_payments;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillingAccountsBenefitsPayments extends RestError {
    private BillingAccountsBenefitsPaymentsAmount amount;
    private BillingAccountsBenefitsPaymentsPaymentDetails paymentDetails;
    private String savedPaymentMethodId;

    public BillingAccountsBenefitsPaymentsAmount getAmount() {
        return amount;
    }

    public void setAmount(BillingAccountsBenefitsPaymentsAmount amount) {
        this.amount = amount;
    }

    public BillingAccountsBenefitsPaymentsPaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(BillingAccountsBenefitsPaymentsPaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public String getSavedPaymentMethodId() {
        return savedPaymentMethodId;
    }

    public void setSavedPaymentMethodId(String savedPaymentMethodId) {
        this.savedPaymentMethodId = savedPaymentMethodId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        BillingAccountsBenefitsPayments that = (BillingAccountsBenefitsPayments) o;
        return Objects.equals(amount, that.amount) &&
                Objects.equals(paymentDetails, that.paymentDetails) &&
                Objects.equals(savedPaymentMethodId, that.savedPaymentMethodId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, paymentDetails, savedPaymentMethodId);
    }
}
