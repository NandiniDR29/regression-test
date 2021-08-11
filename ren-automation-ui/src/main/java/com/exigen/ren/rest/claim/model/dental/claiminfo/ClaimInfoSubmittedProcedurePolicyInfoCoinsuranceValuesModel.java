package com.exigen.ren.rest.claim.model.dental.claiminfo;

import com.exigen.ren.rest.model.RestError;

public class ClaimInfoSubmittedProcedurePolicyInfoCoinsuranceValuesModel extends RestError {

    private String coinsuranceType;
    private String coinsuranceValue;

    public String getCoinsuranceType() {
        return coinsuranceType;
    }

    public void setCoinsuranceType(String coinsuranceType) {
        this.coinsuranceType = coinsuranceType;
    }

    public String getCoinsuranceValue() {
        return coinsuranceValue;
    }

    public void setCoinsuranceValue(String coinsuranceValue) {
        this.coinsuranceValue = coinsuranceValue;
    }

}
