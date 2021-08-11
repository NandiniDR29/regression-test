/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.integration.model;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntegrationFindFeeScheduleFeeBodyModel extends RestError {

    private String serviceDate;
    private String feeTableId;
    private String procedureCode;

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getFeeTableId() {
        return feeTableId;
    }

    public void setFeeTableId(String feeTableId) {
        this.feeTableId = feeTableId;
    }

    public String getProcedureCode() {
        return procedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        this.procedureCode = procedureCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        IntegrationFindFeeScheduleFeeBodyModel that = (IntegrationFindFeeScheduleFeeBodyModel) o;
        return Objects.equals(serviceDate, that.serviceDate) &&
                Objects.equals(feeTableId, that.feeTableId) &&
                Objects.equals(procedureCode, that.procedureCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), serviceDate, feeTableId, procedureCode);
    }
}
