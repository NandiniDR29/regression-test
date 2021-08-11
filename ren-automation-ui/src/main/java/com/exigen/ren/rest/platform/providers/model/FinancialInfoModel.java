/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.platform.providers.model;

import com.exigen.ren.rest.model.RestError;

public class FinancialInfoModel extends RestError {

    private String preferredSettlementMethodCd;
    private String bankName;
    private String branchCity;
    private String bankNumber;
    private String accountNumber;
    private String accountStatus;
    private String accountName;
    private AddressDataModel paymentAddress;
    private String holderName;
    private TermModel validityTerm;
    private String bulkPaymentDay;
    private String externalID;
    private String bulkPaymentInd;
    private String bankAccountTypeCd;
    private String achFormattingInd;
    private String oid;
    private String id;
    private String externalId;
    private String defaultInd;

    public String getAccountName() {
        return accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public String getBankName() {
        return bankName;
    }

    public AddressDataModel getPaymentAddress() {
        return paymentAddress;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public String getBranchCity() {
        return branchCity;
    }

    public String getBulkPaymentDay() {
        return bulkPaymentDay;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getBulkPaymentInd() {
        return bulkPaymentInd;
    }

    public String getExternalID() {
        return externalID;
    }

    public String getPreferredSettlementMethodCd() {
        return preferredSettlementMethodCd;
    }

    public TermModel getValidityTerm() {
        return validityTerm;
    }

    public String getAchFormattingInd() {
        return achFormattingInd;
    }

    public String getBankAccountTypeCd() {
        return bankAccountTypeCd;
    }

    public String getOid() {
        return oid;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public void setBranchCity(String branchCity) {
        this.branchCity = branchCity;
    }

    public void setBulkPaymentDay(String bulkPaymentDay) {
        this.bulkPaymentDay = bulkPaymentDay;
    }

    public void setBulkPaymentInd(String bulkPaymentInd) {
        this.bulkPaymentInd = bulkPaymentInd;
    }

    public void setExternalID(String externalID) {
        this.externalID = externalID;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setPaymentAddress(AddressDataModel paymentAddress) {
        this.paymentAddress = paymentAddress;
    }

    public void setPreferredSettlementMethodCd(String preferredSettlementMethodCd) {
        this.preferredSettlementMethodCd = preferredSettlementMethodCd;
    }

    public void setValidityTerm(TermModel validityTerm) {
        this.validityTerm = validityTerm;
    }

    public void setAchFormattingInd(String achFormattingInd) {
        this.achFormattingInd = achFormattingInd;
    }

    public void setBankAccountTypeCd(String bankAccountTypeCd) {
        this.bankAccountTypeCd = bankAccountTypeCd;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getExternalId() {
        return externalId;
    }

    public String getDefaultInd() {
        return defaultInd;
    }

    public void setDefaultInd(String defaultInd) {
        this.defaultInd = defaultInd;
    }
}
