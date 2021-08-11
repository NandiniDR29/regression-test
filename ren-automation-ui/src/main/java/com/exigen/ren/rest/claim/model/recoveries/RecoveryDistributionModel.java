package com.exigen.ren.rest.claim.model.recoveries;

import java.util.Objects;

public class RecoveryDistributionModel {

    private String amount;
    private String allocationType;
    private String featureOid;
    private String reserveTypeCd;
    private String adjustReserveInd;
    private String oid;
    private String featureId;
    private String currencyCd;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAllocationType() {
        return allocationType;
    }

    public void setAllocationType(String allocationType) {
        this.allocationType = allocationType;
    }

    public String getFeatureOid() {
        return featureOid;
    }

    public void setFeatureOid(String featureOid) {
        this.featureOid = featureOid;
    }

    public String getReserveTypeCd() {
        return reserveTypeCd;
    }

    public void setReserveTypeCd(String reserveTypeCd) {
        this.reserveTypeCd = reserveTypeCd;
    }

    public String getAdjustReserveInd() {
        return adjustReserveInd;
    }

    public void setAdjustReserveInd(String adjustReserveInd) {
        this.adjustReserveInd = adjustReserveInd;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RecoveryDistributionModel that = (RecoveryDistributionModel) o;
        return Objects.equals(amount, that.amount) &&
                Objects.equals(allocationType, that.allocationType) &&
                Objects.equals(featureOid, that.featureOid) &&
                Objects.equals(reserveTypeCd, that.reserveTypeCd) &&
                Objects.equals(adjustReserveInd, that.adjustReserveInd) &&
                Objects.equals(oid, that.oid) &&
                Objects.equals(featureId, that.featureId) &&
                Objects.equals(currencyCd, that.currencyCd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, allocationType, featureOid, reserveTypeCd, adjustReserveInd, oid, featureId, currencyCd);
    }

}
