/* Copyright © 2018 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.platform.providers.model;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceFeeScheduleModel extends RestError {

    private String id;
    private String effectiveDate;
    private String expirationDate;
    private ServiceFeeScheduleDataModel serviceFeeScheduleDTO;
    private List<ServiceFeeScheduleDataModel> serviceFeeRateDTOs;
    private ServiceFeeScheduleDataModel serviceFeeSchedule;
    private List<ServiceFeeScheduleDataModel> serviceFeeRates;
    private String percentile;
    private String effectiveOnDate;

    public String getEffectiveOnDate() {
        return effectiveOnDate;
    }

    public void setEffectiveOnDate(String effectiveOnDate) {
        this.effectiveOnDate = effectiveOnDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public ServiceFeeScheduleDataModel getServiceFeeScheduleDTO() {
        return serviceFeeScheduleDTO;
    }

    public void setServiceFeeScheduleDTO(ServiceFeeScheduleDataModel serviceFeeScheduleDTO) {
        this.serviceFeeScheduleDTO = serviceFeeScheduleDTO;
    }

    public String getPercentile() {
        return percentile;
    }

    public void setPercentile(String percentile) {
        this.percentile = percentile;
    }

    public List<ServiceFeeScheduleDataModel> getServiceFeeRateDTOs() {
        return serviceFeeRateDTOs;
    }

    public void setServiceFeeRateDTOs(List<ServiceFeeScheduleDataModel> serviceFeeRateDTOs) {
        this.serviceFeeRateDTOs = serviceFeeRateDTOs;
    }

    public ServiceFeeScheduleDataModel getServiceFeeSchedule() {
        return serviceFeeSchedule;
    }

    public void setServiceFeeSchedule(ServiceFeeScheduleDataModel serviceFeeSchedule) {
        this.serviceFeeSchedule = serviceFeeSchedule;
    }

    public List<ServiceFeeScheduleDataModel> getServiceFeeRates() {
        return serviceFeeRates;
    }

    public void setServiceFeeRates(List<ServiceFeeScheduleDataModel> serviceFeeRates) {
        this.serviceFeeRates = serviceFeeRates;
    }
}
