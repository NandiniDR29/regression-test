package com.exigen.ren.rest.billing.model.billing_accounts_benefits_payments;

import java.util.List;
import java.util.Objects;

public class BillingAccountsBenefitsPaymentsPaymentDetailsTypeCreditCard {

    private String profileId;
    private List extensionFields;
    private BillingAccountsBenefitsPaymentsPaymentDetailsTypePayorDetails payorDetails;
    private String paymentMethodEffectiveDate;
    private String paymentMethodExpirationDate;
    private String expirationDate;
    private String fullName;
    private String fullNumber;
    private String number;
    private String type;
    private BillingAccountsBenefitsPaymentsPaymentDetailsTypeBillingAddress billingAddress;
    private Boolean payorDifferent;

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public List getExtensionFields() {
        return extensionFields;
    }

    public void setExtensionFields(List extensionFields) {
        this.extensionFields = extensionFields;
    }

    public BillingAccountsBenefitsPaymentsPaymentDetailsTypePayorDetails getPayorDetails() {
        return payorDetails;
    }

    public void setPayorDetails(BillingAccountsBenefitsPaymentsPaymentDetailsTypePayorDetails payorDetails) {
        this.payorDetails = payorDetails;
    }

    public String getPaymentMethodEffectiveDate() {
        return paymentMethodEffectiveDate;
    }

    public void setPaymentMethodEffectiveDate(String paymentMethodEffectiveDate) {
        this.paymentMethodEffectiveDate = paymentMethodEffectiveDate;
    }

    public String getPaymentMethodExpirationDate() {
        return paymentMethodExpirationDate;
    }

    public void setPaymentMethodExpirationDate(String paymentMethodExpirationDate) {
        this.paymentMethodExpirationDate = paymentMethodExpirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullNumber() {
        return fullNumber;
    }

    public void setFullNumber(String fullNumber) {
        this.fullNumber = fullNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BillingAccountsBenefitsPaymentsPaymentDetailsTypeBillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAccountsBenefitsPaymentsPaymentDetailsTypeBillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Boolean getPayorDifferent() {
        return payorDifferent;
    }

    public void setPayorDifferent(Boolean payorDifferent) {
        this.payorDifferent = payorDifferent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        BillingAccountsBenefitsPaymentsPaymentDetailsTypeCreditCard that = (BillingAccountsBenefitsPaymentsPaymentDetailsTypeCreditCard) o;
        return Objects.equals(profileId, that.profileId) &&
                Objects.equals(extensionFields, that.extensionFields) &&
                Objects.equals(payorDetails, that.payorDetails) &&
                Objects.equals(paymentMethodEffectiveDate, that.paymentMethodEffectiveDate) &&
                Objects.equals(paymentMethodExpirationDate, that.paymentMethodExpirationDate) &&
                Objects.equals(expirationDate, that.expirationDate) &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(fullNumber, that.fullNumber) &&
                Objects.equals(number, that.number) &&
                Objects.equals(type, that.type) &&
                Objects.equals(billingAddress, that.billingAddress) &&
                Objects.equals(payorDifferent, that.payorDifferent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profileId, extensionFields, payorDetails, paymentMethodEffectiveDate, paymentMethodExpirationDate, expirationDate, fullName, fullNumber, number, type, billingAddress, payorDifferent);
    }
}
