package com.exigen.ren.rest.claim.model.dental.claiminfo;

import com.exigen.ren.rest.model.RestError;

public class ClaimInfoSubmittedProcedurePolicyInfoWaitingPeriodValuesModel extends RestError {

    private String waitingPeriodCategory;
    private String waitingPeriodValue;

    public String getWaitingPeriodCategory() {
        return waitingPeriodCategory;
    }

    public void setWaitingPeriodCategory(String waitingPeriodCategory) {
        this.waitingPeriodCategory = waitingPeriodCategory;
    }

    public String getWaitingPeriodValue() {
        return waitingPeriodValue;
    }

    public void setWaitingPeriodValue(String waitingPeriodValue) {
        this.waitingPeriodValue = waitingPeriodValue;
    }

}
