package com.exigen.ren.rest.dxp.model.billing;

import com.exigen.ren.rest.model.RestError;

import java.util.Objects;

public class BillingBenefitsCustomerInvoiceModel extends RestError {
    private BillingMoneyModel priorPeriodAdjustments;
    private String billingPeriod;
    private BillingMoneyModel totalDue;
    private String dueDate;
    private String invoiceNumber;
    private String generationDate;
    private String invoiceAdditionalStatusCd;
    private String accountNumber;
    private BillingMoneyModel currentDue;
    private String invoiceStatus;
    private BillingMoneyModel priorDue;

    public BillingMoneyModel getPriorPeriodAdjustments() {
        return priorPeriodAdjustments;
    }

    public void setPriorPeriodAdjustments(BillingMoneyModel priorPeriodAdjustments) {
        this.priorPeriodAdjustments = priorPeriodAdjustments;
    }

    public String getBillingPeriod() {
        return billingPeriod;
    }

    public void setBillingPeriod(String billingPeriod) {
        this.billingPeriod = billingPeriod;
    }

    public BillingMoneyModel getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(BillingMoneyModel totalDue) {
        this.totalDue = totalDue;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(String generationDate) {
        this.generationDate = generationDate;
    }

    public String getInvoiceAdditionalStatusCd() {
        return invoiceAdditionalStatusCd;
    }

    public void setInvoiceAdditionalStatusCd(String invoiceAdditionalStatusCd) {
        this.invoiceAdditionalStatusCd = invoiceAdditionalStatusCd;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BillingMoneyModel getCurrentDue() {
        return currentDue;
    }

    public void setCurrentDue(BillingMoneyModel currentDue) {
        this.currentDue = currentDue;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public BillingMoneyModel getPriorDue() {
        return priorDue;
    }

    public void setPriorDue(BillingMoneyModel priorDue) {
        this.priorDue = priorDue;
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
        BillingBenefitsCustomerInvoiceModel that = (BillingBenefitsCustomerInvoiceModel) o;
        return Objects.equals(priorPeriodAdjustments, that.priorPeriodAdjustments) &&
                Objects.equals(billingPeriod, that.billingPeriod) &&
                Objects.equals(totalDue, that.totalDue) &&
                Objects.equals(dueDate, that.dueDate) &&
                Objects.equals(invoiceNumber, that.invoiceNumber) &&
                Objects.equals(generationDate, that.generationDate) &&
                Objects.equals(invoiceAdditionalStatusCd, that.invoiceAdditionalStatusCd) &&
                Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(currentDue, that.currentDue) &&
                Objects.equals(invoiceStatus, that.invoiceStatus) &&
                Objects.equals(priorDue, that.priorDue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), priorPeriodAdjustments, billingPeriod, totalDue, dueDate, invoiceNumber, generationDate, invoiceAdditionalStatusCd, accountNumber, currentDue, invoiceStatus, priorDue);
    }
}
