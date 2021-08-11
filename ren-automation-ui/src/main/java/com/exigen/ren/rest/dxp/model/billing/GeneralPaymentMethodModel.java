package com.exigen.ren.rest.dxp.model.billing;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeneralPaymentMethodModel extends RestError {
    private String paymentMethodExpirationDate;
    private String paymentMethodEffectiveDate;
    private String description;
    private String bankName;
    private String accountNumber;
    private String type;
    private String id;

    public String getPaymentMethodExpirationDate() {
        return paymentMethodExpirationDate;
    }

    public void setPaymentMethodExpirationDate(String paymentMethodExpirationDate) {
        this.paymentMethodExpirationDate = paymentMethodExpirationDate;
    }

    public String getPaymentMethodEffectiveDate() {
        return paymentMethodEffectiveDate;
    }

    public void setPaymentMethodEffectiveDate(String paymentMethodEffectiveDate) {
        this.paymentMethodEffectiveDate = paymentMethodEffectiveDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        GeneralPaymentMethodModel that = (GeneralPaymentMethodModel) o;
        return Objects.equals(paymentMethodExpirationDate, that.paymentMethodExpirationDate) &&
                Objects.equals(paymentMethodEffectiveDate, that.paymentMethodEffectiveDate) &&
                Objects.equals(description, that.description) &&
                Objects.equals(bankName, that.bankName) &&
                Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(type, that.type) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), paymentMethodExpirationDate, paymentMethodEffectiveDate, description, bankName, accountNumber, type, id);
    }
}
