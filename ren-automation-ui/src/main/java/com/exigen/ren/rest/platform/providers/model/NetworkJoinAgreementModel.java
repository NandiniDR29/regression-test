/* Copyright © 2018 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.platform.providers.model;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NetworkJoinAgreementModel extends RestError {
    private String id;
    private String termEffectiveDate;
    private String termExpirationDate;
    private String serviceNetworkID;
    private String serviceFeeScheduleID;
    private String serviceAgentAssignmentID;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTermEffectiveDate(String termEffectiveDate) {
        this.termEffectiveDate = termEffectiveDate;
    }

    public String getTermEffectiveDate() {
        return termEffectiveDate;
    }

    public void setTermExpirationDate(String termExpirationDate) {
        this.termExpirationDate = termExpirationDate;
    }

    public String getTermExpirationDate() {
        return termExpirationDate;
    }

    public void setServiceNetworkID(String serviceNetworkID) {
        this.serviceNetworkID = serviceNetworkID;
    }

    public String getServiceNetworkID() {
        return serviceNetworkID;
    }

    public void setServiceFeeScheduleID(String serviceFeeScheduleID) {
        this.serviceFeeScheduleID = serviceFeeScheduleID;
    }

    public String getServiceFeeScheduleID() {
        return serviceFeeScheduleID;
    }

    public void setServiceAgentAssignmentID(String serviceAgentAssignmentID) {
        this.serviceAgentAssignmentID = serviceAgentAssignmentID;
    }

    public String getServiceAgentAssignmentID() {
        return serviceAgentAssignmentID;
    }
}
