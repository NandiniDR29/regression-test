package com.exigen.ren.rest.billing.model.billing_accounts_benefits_payments;

import java.util.Objects;

public class BillingAccountsBenefitsPaymentsAmount {

    private String value;
    private String currency;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        BillingAccountsBenefitsPaymentsAmount that = (BillingAccountsBenefitsPaymentsAmount) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }
}
