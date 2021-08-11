/* Copyright © 2018 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.platform.providers.model;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgreementInfoModel extends RestError {
    private int id;
    private String effective;
    private String expiration;
    private ServiceNetWorkModel serviceNetworkDTOModel;
    private ServiceFeeSchedulesModel serviceFeeScheduleDTO;
    private ServiceProviderSearchResultModel serviceProviderSearchResult;
    private ServiceProviderSearchResultModel serviceProviderInfo;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setEffective(String effective) {
        this.effective = effective;
    }

    public String getEffective() {
        return effective;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setServiceNetworkDTOModel(ServiceNetWorkModel serviceNetworkDTOModel) {
        this.serviceNetworkDTOModel = serviceNetworkDTOModel;
    }

    public ServiceNetWorkModel getServiceNetworkDTOModel() {
        return serviceNetworkDTOModel;
    }

    public void setServiceFeeScheduleDTO(ServiceFeeSchedulesModel serviceFeeScheduleDTO) {
        this.serviceFeeScheduleDTO = serviceFeeScheduleDTO;
    }

    public ServiceFeeSchedulesModel getServiceFeeScheduleDTO() {
        return serviceFeeScheduleDTO;
    }

    public void setServiceProviderSearchResult(ServiceProviderSearchResultModel serviceProviderSearchResult) {
        this.serviceProviderSearchResult = serviceProviderSearchResult;
    }

    public ServiceProviderSearchResultModel getServiceProviderSearchResult() {
        return serviceProviderSearchResult;
    }

    public ServiceProviderSearchResultModel getServiceProviderInfo() {
        return serviceProviderInfo;
    }

    public void setServiceProviderInfo(ServiceProviderSearchResultModel serviceProviderInfo) {
        this.serviceProviderInfo = serviceProviderInfo;
    }
}
