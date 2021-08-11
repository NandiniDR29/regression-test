/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.billing.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;

public class NsfCounterModel extends Model {
    private String transactionNumber;
    private String transactionDate;
    private String transactionTypeCd;
    private String transactionSubtypeCd;
    private String transactionReasonCd;
    private AllocationAmountNfsModel allocationAmount;
    private Boolean increaseNsfCount;
    private String reasonForExcludeCd;

    public NsfCounterModel(String transactionNumber, boolean increaseNfsCount, String reasonForExcludeCd) {
        this.transactionNumber = transactionNumber;
        this.reasonForExcludeCd = reasonForExcludeCd;
        this.increaseNsfCount = increaseNfsCount;
    }

    public NsfCounterModel() {
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionTypeCd() {
        return transactionTypeCd;
    }

    public void setTransactionTypeCd(String transactionTypeCd) {
        this.transactionTypeCd = transactionTypeCd;
    }

    public String getTransactionSubtypeCd() {
        return transactionSubtypeCd;
    }

    public void setTransactionSubtypeCd(String transactionSubtypeCd) {
        this.transactionSubtypeCd = transactionSubtypeCd;
    }

    public String getTransactionReasonCd() {
        return transactionReasonCd;
    }

    public void setTransactionReasonCd(String transactionReasonCd) {
        this.transactionReasonCd = transactionReasonCd;
    }

    public AllocationAmountNfsModel getAllocationAmount() {
        return allocationAmount;
    }

    public void setAllocationAmount(AllocationAmountNfsModel allocationAmount) {
        this.allocationAmount = allocationAmount;
    }

    public String getReasonForExcludeCd() {
        return reasonForExcludeCd;
    }

    public void setReasonForExcludeCd(String reasonForExcludeCd) {
        this.reasonForExcludeCd = reasonForExcludeCd;
    }

    public Boolean getIncreaseNsfCount() {
        return increaseNsfCount;
    }

    public void setIncreaseNsfCount(Boolean increaseNsfCount) {
        this.increaseNsfCount = increaseNsfCount;
    }
}

class AllocationAmountNfsModel {
    private String value;
    private String currency;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
