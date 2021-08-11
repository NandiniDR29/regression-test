package com.exigen.ren.rest.claim.model.payments;

import java.util.Objects;

public class PaymentModel {

    private String paymentNumber;
    private String paymentIssueDate;
    private String paymentStatus;
    private String paymentMemo;
    private PaymentPayeeModel payee;
    private PaymentNetPaymentAmtModel netPaymentAmt;
    private PaymentPaymentDetailsModel paymentDetails;

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public String getPaymentIssueDate() {
        return paymentIssueDate;
    }

    public void setPaymentIssueDate(String paymentIssueDate) {
        this.paymentIssueDate = paymentIssueDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMemo() {
        return paymentMemo;
    }

    public void setPaymentMemo(String paymentMemo) {
        this.paymentMemo = paymentMemo;
    }

    public PaymentPayeeModel getPayee() {
        return payee;
    }

    public void setPayee(PaymentPayeeModel payee) {
        this.payee = payee;
    }

    public PaymentNetPaymentAmtModel getNetPaymentAmt() {
        return netPaymentAmt;
    }

    public void setNetPaymentAmt(PaymentNetPaymentAmtModel netPaymentAmt) {
        this.netPaymentAmt = netPaymentAmt;
    }

    public PaymentPaymentDetailsModel getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentPaymentDetailsModel paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public PaymentModel normalizePaymentDate() {
        this.setPaymentIssueDate(paymentIssueDate.substring(0, paymentIssueDate.lastIndexOf(":")));
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentModel that = (PaymentModel) o;
        return Objects.equals(paymentNumber, that.paymentNumber) &&
                Objects.equals(paymentIssueDate, that.paymentIssueDate) &&
                Objects.equals(paymentStatus, that.paymentStatus) &&
                Objects.equals(paymentMemo, that.paymentMemo) &&
                Objects.equals(payee, that.payee) &&
                Objects.equals(netPaymentAmt, that.netPaymentAmt) &&
                Objects.equals(paymentDetails, that.paymentDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentNumber, paymentIssueDate, paymentStatus, paymentMemo, payee, netPaymentAmt, paymentDetails);
    }

}
