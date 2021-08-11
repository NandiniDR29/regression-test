/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.billing.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.exigen.ren.rest.billing.model.billing_accounts_invoices_regenerate.BillingValue;
import com.exigen.ren.rest.dxp.model.billing.BillingAccountsModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
public class BillingAccountModel extends Model {

    private String accountNumber;
    private String accountName;
    private String blobCd;
    private String billType;
    private BillingAddressModel billingAddress;
    private BillingContactModel billingContact;
    private InvoicingCalendarModel invoicingCalendar;
    private BillingValue currentDue;
    private BillingValue priorDue;
    private BillingValue totalDue;
    private List<BillingAccountsModel.Policy> masterPolicies;

    public BillingAccountModel() {
    }

    public BillingAccountModel(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BillingAddressModel getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddressModel billingAddress) {
        this.billingAddress = billingAddress;
    }

    public BillingContactModel getBillingContact() {
        return billingContact;
    }

    public void setBillingContact(BillingContactModel billingContact) {
        this.billingContact = billingContact;
    }

    public String getBlobCd() {
        return blobCd;
    }

    public void setBlobCd(String blobCd) {
        this.blobCd = blobCd;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public InvoicingCalendarModel getInvoicingCalendar() {
        return invoicingCalendar;
    }

    public void setInvoicingCalendar(InvoicingCalendarModel invoicingCalendar) {
        this.invoicingCalendar = invoicingCalendar;
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

    public List<BillingAccountsModel.Policy> getMasterPolicies() {
        return masterPolicies;
    }

    public void setMasterPolicies(List<BillingAccountsModel.Policy> masterPolicies) {
        this.masterPolicies = masterPolicies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BillingAccountModel that = (BillingAccountModel) o;
        return Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(accountName, that.accountName) &&
                Objects.equals(blobCd, that.blobCd) &&
                Objects.equals(billType, that.billType) &&
                Objects.equals(billingAddress, that.billingAddress) &&
                Objects.equals(billingContact, that.billingContact) &&
                Objects.equals(invoicingCalendar, that.invoicingCalendar) &&
                Objects.equals(currentDue, that.currentDue) &&
                Objects.equals(priorDue, that.priorDue) &&
                Objects.equals(totalDue, that.totalDue) &&
                Objects.equals(masterPolicies, that.masterPolicies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), accountNumber, accountName, blobCd, billType, billingAddress, billingContact, invoicingCalendar, currentDue, priorDue, totalDue, masterPolicies);
    }
}

class BillingContactModel {

    private String nameTypeCd;
    private String prefix;
    private String firstName;
    private String middleName;
    private String lastName;
    private String otherName;

    public String getNameTypeCd() {
        return nameTypeCd;
    }

    public void setNameTypeCd(String nameTypeCd) {
        this.nameTypeCd = nameTypeCd;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }
}

