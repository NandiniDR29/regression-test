/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.billing.model.billing_accounts_invoices_regenerate;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillingAccountsInvoicesGenerate extends RestError {

    private String invoiceNumber;
    private String dueDate;
    private String billingPeriod;
    private String invoiceStatus;
    private String invoiceAdditionalStatusCd;
    private BillingValue currentDue;
    private BillingValue priorDue;
    private BillingValue totalDue;
    private BillingPriorPeriodAdjustments priorPeriodAdjustments;
    private BillingAccountsInvoicesRegenerateUip uip;
    private BillingAccountsInvoicesRegenerateDocument document;
    private String accountNumber;
    private String generationDate;
    private BillingExtensionFields extensionFields;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getBillingPeriod() {
        return billingPeriod;
    }

    public void setBillingPeriod(String billingPeriod) {
        this.billingPeriod = billingPeriod;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public String getInvoiceAdditionalStatusCd() {
        return invoiceAdditionalStatusCd;
    }

    public void setInvoiceAdditionalStatusCd(String invoiceAdditionalStatusCd) {
        this.invoiceAdditionalStatusCd = invoiceAdditionalStatusCd;
    }

    public String getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(String generationDate) {
        this.generationDate = generationDate;
    }

    public BillingValue getCurrentDue() {
        return currentDue;
    }

    public void setCurrentDue(BillingValue currentDue) {
        this.currentDue = currentDue;
    }

    public BillingValue getPriorDue() {
        return priorDue;
    }

    public void setPriorDue(BillingValue priorDue) {
        this.priorDue = priorDue;
    }

    public BillingValue getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(BillingValue totalDue) {
        this.totalDue = totalDue;
    }

    public BillingAccountsInvoicesRegenerateUip getUip() {
        return uip;
    }

    public void setUip(BillingAccountsInvoicesRegenerateUip uip) {
        this.uip = uip;
    }

    public BillingAccountsInvoicesRegenerateDocument getDocument() {
        return document;
    }

    public void setDocument(BillingAccountsInvoicesRegenerateDocument document) {
        this.document = document;
    }

    public BillingPriorPeriodAdjustments getPriorPeriodAdjustments() {
        return priorPeriodAdjustments;
    }

    public void setPriorPeriodAdjustments(BillingPriorPeriodAdjustments priorPeriodAdjustments) {
        this.priorPeriodAdjustments = priorPeriodAdjustments;
    }

    public BillingExtensionFields getExtensionFields() {
        return extensionFields;
    }

    public void setExtensionFields(BillingExtensionFields extensionFields) {
        this.extensionFields = extensionFields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        if (!super.equals(o)) {return false;}
        BillingAccountsInvoicesGenerate that = (BillingAccountsInvoicesGenerate) o;
        return Objects.equals(invoiceNumber, that.invoiceNumber) &&
                Objects.equals(dueDate, that.dueDate) &&
                Objects.equals(billingPeriod, that.billingPeriod) &&
                Objects.equals(invoiceStatus, that.invoiceStatus) &&
                Objects.equals(invoiceAdditionalStatusCd, that.invoiceAdditionalStatusCd) &&
                Objects.equals(currentDue, that.currentDue) &&
                Objects.equals(priorDue, that.priorDue) &&
                Objects.equals(totalDue, that.totalDue) &&
                Objects.equals(uip, that.uip) &&
                Objects.equals(document, that.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), invoiceNumber, dueDate, billingPeriod, invoiceStatus, invoiceAdditionalStatusCd, currentDue, priorDue, totalDue, uip, document);
    }
}

