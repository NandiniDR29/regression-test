/* Copyright © 2018 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.platform.providers.model;

public class ServiceFeeScheduleDataModel {

    private String id;
    private String feeScheduleType;
    private String feeScheduleCode;
    private String feeCode;
    private String feeAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFeeScheduleType() {
        return feeScheduleType;
    }

    public void setFeeScheduleType(String feeScheduleType) {
        this.feeScheduleType = feeScheduleType;
    }

    public String getFeeScheduleCode() {
        return feeScheduleCode;
    }

    public void setFeeScheduleCode(String feeScheduleCode) {
        this.feeScheduleCode = feeScheduleCode;
    }

    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public String getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(String feeAmount) {
        this.feeAmount = feeAmount;
    }
}
