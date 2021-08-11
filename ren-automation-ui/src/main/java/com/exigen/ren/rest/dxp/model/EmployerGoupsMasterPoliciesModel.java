package com.exigen.ren.rest.dxp.model;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployerGoupsMasterPoliciesModel extends RestError {

    private String policyNumber;
    private String customerNumber;
    private Boolean currentRevisionInd;
    private String revisionNumber;
    private String policyStatusCd;
    private String timedPolicyStatusCd;
    private String transactionTypeCd;
    private String effectiveDate;
    private String expirationDate;
    private String anniversaryDate;
    private String cancellationDate;
    private String transactionEffectiveDate;
    private String productCode;
    private String productVersion;
    private String issueDate;

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Boolean getCurrentRevisionInd() {
        return currentRevisionInd;
    }

    public void setCurrentRevisionInd(Boolean currentRevisionInd) {
        this.currentRevisionInd = currentRevisionInd;
    }

    public String getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(String revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    public String getPolicyStatusCd() {
        return policyStatusCd;
    }

    public void setPolicyStatusCd(String policyStatusCd) {
        this.policyStatusCd = policyStatusCd;
    }

    public String getTimedPolicyStatusCd() {
        return timedPolicyStatusCd;
    }

    public void setTimedPolicyStatusCd(String timedPolicyStatusCd) {
        this.timedPolicyStatusCd = timedPolicyStatusCd;
    }

    public String getTransactionTypeCd() {
        return transactionTypeCd;
    }

    public void setTransactionTypeCd(String transactionTypeCd) {
        this.transactionTypeCd = transactionTypeCd;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getAnniversaryDate() {
        return anniversaryDate;
    }

    public void setAnniversaryDate(String anniversaryDate) {
        this.anniversaryDate = anniversaryDate;
    }

    public String getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(String cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public String getTransactionEffectiveDate() {
        return transactionEffectiveDate;
    }

    public void setTransactionEffectiveDate(String transactionEffectiveDate) {
        this.transactionEffectiveDate = transactionEffectiveDate;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        if (!super.equals(o)) {return false;}
        EmployerGoupsMasterPoliciesModel that = (EmployerGoupsMasterPoliciesModel) o;
        return Objects.equals(policyNumber, that.policyNumber) &&
                Objects.equals(customerNumber, that.customerNumber) &&
                Objects.equals(currentRevisionInd, that.currentRevisionInd) &&
                Objects.equals(revisionNumber, that.revisionNumber) &&
                Objects.equals(policyStatusCd, that.policyStatusCd) &&
                Objects.equals(timedPolicyStatusCd, that.timedPolicyStatusCd) &&
                Objects.equals(transactionTypeCd, that.transactionTypeCd) &&
                Objects.equals(effectiveDate, that.effectiveDate) &&
                Objects.equals(expirationDate, that.expirationDate) &&
                Objects.equals(anniversaryDate, that.anniversaryDate) &&
                Objects.equals(cancellationDate, that.cancellationDate) &&
                Objects.equals(transactionEffectiveDate, that.transactionEffectiveDate) &&
                Objects.equals(productCode, that.productCode) &&
                Objects.equals(productVersion, that.productVersion) &&
                Objects.equals(issueDate, that.issueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), policyNumber, customerNumber, currentRevisionInd, revisionNumber, policyStatusCd, timedPolicyStatusCd, transactionTypeCd, effectiveDate, expirationDate, anniversaryDate, cancellationDate, transactionEffectiveDate, productCode, productVersion, issueDate);
    }
}
