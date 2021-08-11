/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.billing.model.billing_payment;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillingAccountPayment extends RestError {

    private String transactionDate;
    private String effectiveDate;
    private String transactionType;
    private String paymentAmount;
    private String balanceAmount;
    private String suspenseReferenceNumber;
    private PaymentDetailsModel paymentDetails;
    private List<AllocatedSuspenses> allocatedSuspenses;
    private List<PaymentAllocations> paymentAllocations;
    private String suspenseAmount;


    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(String balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public String getSuspenseReferenceNumber() {
        return suspenseReferenceNumber;
    }

    public void setSuspenseReferenceNumber(String suspenseReferenceNumber) {
        this.suspenseReferenceNumber = suspenseReferenceNumber;
    }

    public PaymentDetailsModel getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetailsModel paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public List<AllocatedSuspenses> getAllocatedSuspenses() {
        return allocatedSuspenses;
    }

    public void setAllocatedSuspenses(List<AllocatedSuspenses> allocatedSuspenses) {
        this.allocatedSuspenses = allocatedSuspenses;
    }

    public List<PaymentAllocations> getPaymentAllocations() {
        return paymentAllocations;
    }

    public void setPaymentAllocations(List<PaymentAllocations> paymentAllocations) {
        this.paymentAllocations = paymentAllocations;
    }

    public String getSuspenseAmount() {
        return suspenseAmount;
    }

    public void setSuspenseAmount(String suspenseAmount) {
        this.suspenseAmount = suspenseAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        if (!super.equals(o)) {return false;}
        BillingAccountPayment that = (BillingAccountPayment) o;
        return Objects.equals(transactionDate, that.transactionDate) &&
                Objects.equals(effectiveDate, that.effectiveDate) &&
                Objects.equals(transactionType, that.transactionType) &&
                Objects.equals(paymentAmount, that.paymentAmount) &&
                Objects.equals(balanceAmount, that.balanceAmount) &&
                Objects.equals(suspenseReferenceNumber, that.suspenseReferenceNumber) &&
                Objects.equals(paymentDetails, that.paymentDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), transactionDate, effectiveDate, transactionType, paymentAmount, balanceAmount, suspenseReferenceNumber, paymentDetails);
    }
}