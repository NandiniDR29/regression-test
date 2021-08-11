package com.exigen.ren.rest.integration.model;

import com.exigen.ren.rest.model.RestError;

import java.util.Objects;

public class FindMaverestFeeForAllProcedureCodeModel extends RestError {
    private String serviceDate;
    private String feeTableId;
    private String procedureCode;
    private String name;
    private String amount;
    private String noMaxAmount;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getNoMaxAmount() {
        return noMaxAmount;
    }

    public void setNoMaxAmount(String noMaxAmount) {
        this.noMaxAmount = noMaxAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FindMaverestFeeForAllProcedureCodeModel that = (FindMaverestFeeForAllProcedureCodeModel) o;
        return Objects.equals(serviceDate, that.serviceDate) &&
                Objects.equals(feeTableId, that.feeTableId) &&
                Objects.equals(procedureCode, that.procedureCode) &&
                Objects.equals(name, that.name) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(noMaxAmount, that.noMaxAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), serviceDate, feeTableId, procedureCode, name, amount, noMaxAmount);
    }
}
