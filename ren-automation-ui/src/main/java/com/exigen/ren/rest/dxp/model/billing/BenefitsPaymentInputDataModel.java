package com.exigen.ren.rest.dxp.model.billing;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BenefitsPaymentInputDataModel extends RestError {
    private BillingMoneyModel amount;
    private String savedPaymentMethodId;

    public BillingMoneyModel getAmount() {
        return amount;
    }

    public void setAmount(BillingMoneyModel amount) {
        this.amount = amount;
    }

    public String getSavedPaymentMethodId() {
        return savedPaymentMethodId;
    }

    public void setSavedPaymentMethodId(String savedPaymentMethodId) {
        this.savedPaymentMethodId = savedPaymentMethodId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        BenefitsPaymentInputDataModel that = (BenefitsPaymentInputDataModel) o;
        return Objects.equals(amount, that.amount) &&
                Objects.equals(savedPaymentMethodId, that.savedPaymentMethodId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), amount, savedPaymentMethodId);
    }
}
