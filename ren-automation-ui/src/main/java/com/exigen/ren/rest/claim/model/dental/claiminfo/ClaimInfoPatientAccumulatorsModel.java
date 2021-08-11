package com.exigen.ren.rest.claim.model.dental.claiminfo;

import com.exigen.ren.rest.model.RestError;

public class ClaimInfoPatientAccumulatorsModel extends RestError {

    private String accumulatorType;
    private String remaining;
    private String oonRemaining;

    public String getAccumulatorType() {
        return accumulatorType;
    }

    public void setAccumulatorType(String accumulatorType) {
        this.accumulatorType = accumulatorType;
    }

    public String getRemaining() {
        return remaining;
    }

    public void setRemaining(String remaining) {
        this.remaining = remaining;
    }

    public String getOonRemaining() {
        return oonRemaining;
    }

    public void setOonRemaining(String oonRemaining) {
        this.oonRemaining = oonRemaining;
    }
}