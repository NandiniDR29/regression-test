/* Copyright © 2018 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.platform.providers.model;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeeScheduleNetworkBindingModel extends RestError {
    private String id;
    private String effectiveDate;
    private String expirationDate;
    private String serviceFeeScheduleVersionId;
    private String serviceNetworkId;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setServiceFeeScheduleVersionId(String serviceFeeScheduleVersionId) {
        this.serviceFeeScheduleVersionId = serviceFeeScheduleVersionId;
    }

    public String getServiceFeeScheduleVersionId() {
        return serviceFeeScheduleVersionId;
    }

    public void setServiceNetworkId(String serviceNetworkId) {
        this.serviceNetworkId = serviceNetworkId;
    }

    public String getServiceNetworkId() {
        return serviceNetworkId;
    }
}
