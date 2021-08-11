package com.exigen.ren.rest.claim.model.dental.claiminfo;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.Objects;

public class FeeRateModel extends Model {
    private String feeCode;
    private String feeAmount;
    private String feeScheduleCode;

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

    public String getFeeScheduleCode() {
        return feeScheduleCode;
    }

    public void setFeeScheduleCode(String feeScheduleCode) {
        this.feeScheduleCode = feeScheduleCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FeeRateModel that = (FeeRateModel) o;
        return Objects.equals(feeCode, that.feeCode) &&
                Objects.equals(feeAmount, that.feeAmount) &&
                Objects.equals(feeScheduleCode, that.feeScheduleCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), feeCode, feeAmount, feeScheduleCode);
    }
}
