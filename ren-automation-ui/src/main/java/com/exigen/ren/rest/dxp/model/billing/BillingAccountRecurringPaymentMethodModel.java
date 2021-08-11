package com.exigen.ren.rest.dxp.model.billing;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillingAccountRecurringPaymentMethodModel extends RestError {
    private RecurringPaymentMethodModel recurringPaymentsMethod;

    public RecurringPaymentMethodModel getRecurringPaymentsMethod() {
        return recurringPaymentsMethod;
    }

    public void setRecurringPaymentsMethod(RecurringPaymentMethodModel recurringPaymentsMethod) {
        this.recurringPaymentsMethod = recurringPaymentsMethod;
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
        BillingAccountRecurringPaymentMethodModel that = (BillingAccountRecurringPaymentMethodModel) o;
        return Objects.equals(recurringPaymentsMethod, that.recurringPaymentsMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), recurringPaymentsMethod);
    }
}
