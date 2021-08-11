package com.exigen.ren.rest.billing.model.billing_customers_payment_methods;

import com.exigen.ren.rest.billing.model.billing_accounts_benefits_payments.BillingAccountsBenefitsPaymentsPaymentDetailsTypeEFTEffectiveTerm;
import com.exigen.ren.rest.billing.model.billing_accounts_benefits_payments.BillingAccountsBenefitsPaymentsPaymentDetailsTypePayorDetails;
import com.exigen.ren.rest.billing.model.billing_accounts_benefits_payments.BillingAccountsBenefitsPaymentsPaymentDetailsTypePayorDetailsNameInfo;

import java.util.List;

public class BillingAccountsBenefitsPaymentMethodACH {

    private String profileId;
    private List extensionFields;
    private BillingAccountsBenefitsPaymentsPaymentDetailsTypePayorDetails payorDetails;
    private String paymentMethodEffectiveDate;
    private String paymentMethodExpirationDate;
    private String transitNumber;
    private String bankName;
    private String accountNumber;
    private String firstName;
    private String lastName;
    private String status;
    private String bankAccountHolderName;
    private String bankAccountHolderNamePhonetic;
    private String statusUpdatedBy;
    private String bankCd;
    private String bankBranchCd;
    private String accountTypeCd;
    private Boolean achProtocolFormReceived;
    private BillingAccountsBenefitsPaymentsPaymentDetailsTypeEFTEffectiveTerm effectiveTerm;
    private BillingAccountsBenefitsPaymentsPaymentDetailsTypePayorDetailsNameInfo accountHolderInfo;
    private Boolean internationalAchFormatting;
    private String bankAccountType;
    private String countryCd;
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

    public String getTransitNumber() {
        return transitNumber;
    }

    public void setTransitNumber(String transitNumber) {
        this.transitNumber = transitNumber;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBankAccountHolderName() {
        return bankAccountHolderName;
    }

    public void setBankAccountHolderName(String bankAccountHolderName) {
        this.bankAccountHolderName = bankAccountHolderName;
    }

    public String getBankAccountHolderNamePhonetic() {
        return bankAccountHolderNamePhonetic;
    }

    public void setBankAccountHolderNamePhonetic(String bankAccountHolderNamePhonetic) {
        this.bankAccountHolderNamePhonetic = bankAccountHolderNamePhonetic;
    }

    public String getStatusUpdatedBy() {
        return statusUpdatedBy;
    }

    public void setStatusUpdatedBy(String statusUpdatedBy) {
        this.statusUpdatedBy = statusUpdatedBy;
    }

    public String getBankCd() {
        return bankCd;
    }

    public void setBankCd(String bankCd) {
        this.bankCd = bankCd;
    }

    public String getBankBranchCd() {
        return bankBranchCd;
    }

    public void setBankBranchCd(String bankBranchCd) {
        this.bankBranchCd = bankBranchCd;
    }

    public String getAccountTypeCd() {
        return accountTypeCd;
    }

    public void setAccountTypeCd(String accountTypeCd) {
        this.accountTypeCd = accountTypeCd;
    }

    public Boolean getAchProtocolFormReceived() {
        return achProtocolFormReceived;
    }

    public void setAchProtocolFormReceived(Boolean achProtocolFormReceived) {
        this.achProtocolFormReceived = achProtocolFormReceived;
    }

    public BillingAccountsBenefitsPaymentsPaymentDetailsTypeEFTEffectiveTerm getEffectiveTerm() {
        return effectiveTerm;
    }

    public void setEffectiveTerm(BillingAccountsBenefitsPaymentsPaymentDetailsTypeEFTEffectiveTerm effectiveTerm) {
        this.effectiveTerm = effectiveTerm;
    }

    public BillingAccountsBenefitsPaymentsPaymentDetailsTypePayorDetailsNameInfo getAccountHolderInfo() {
        return accountHolderInfo;
    }

    public void setAccountHolderInfo(BillingAccountsBenefitsPaymentsPaymentDetailsTypePayorDetailsNameInfo accountHolderInfo) {
        this.accountHolderInfo = accountHolderInfo;
    }

    public Boolean getInternationalAchFormatting() {
        return internationalAchFormatting;
    }

    public void setInternationalAchFormatting(Boolean internationalAchFormatting) {
        this.internationalAchFormatting = internationalAchFormatting;
    }

    public String getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(String bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    public String getCountryCd() {
        return countryCd;
    }

    public void setCountryCd(String countryCd) {
        this.countryCd = countryCd;
    }

    public Boolean getPayorDifferent() {
        return payorDifferent;
    }

    public void setPayorDifferent(Boolean payorDifferent) {
        this.payorDifferent = payorDifferent;
    }
}
