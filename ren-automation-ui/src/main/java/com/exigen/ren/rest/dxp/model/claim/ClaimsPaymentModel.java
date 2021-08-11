package com.exigen.ren.rest.dxp.model.claim;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClaimsPaymentModel extends RestError {
    private String benefit;
    private String fromDt;
    private String referenceNumber;
    private String throughDt;
    private PaymentDetailsModel paymentDetails;
    private String paymentStatus;
    private String paymentNumber;
    private String description;
    private String paymentTo;
    private String issueDate;

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public String getFromDt() {
        return fromDt;
    }

    public void setFromDt(String fromDt) {
        this.fromDt = fromDt;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getThroughDt() {
        return throughDt;
    }

    public void setThroughDt(String throughDt) {
        this.throughDt = throughDt;
    }

    public PaymentDetailsModel getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetailsModel paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentTo() {
        return paymentTo;
    }

    public void setPaymentTo(String paymentTo) {
        this.paymentTo = paymentTo;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
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
        ClaimsPaymentModel that = (ClaimsPaymentModel) o;
        return Objects.equals(benefit, that.benefit) &&
                Objects.equals(fromDt, that.fromDt) &&
                Objects.equals(referenceNumber, that.referenceNumber) &&
                Objects.equals(throughDt, that.throughDt) &&
                Objects.equals(paymentDetails, that.paymentDetails) &&
                Objects.equals(paymentStatus, that.paymentStatus) &&
                Objects.equals(paymentNumber, that.paymentNumber) &&
                Objects.equals(description, that.description) &&
                Objects.equals(paymentTo, that.paymentTo) &&
                Objects.equals(issueDate, that.issueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), benefit, fromDt, referenceNumber, throughDt, paymentDetails, paymentStatus, paymentNumber, description, paymentTo, issueDate);
    }
}
