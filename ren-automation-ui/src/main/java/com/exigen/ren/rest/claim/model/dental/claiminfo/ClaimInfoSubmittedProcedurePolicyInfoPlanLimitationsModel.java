package com.exigen.ren.rest.claim.model.dental.claiminfo;

import com.exigen.ren.rest.model.RestError;

public class ClaimInfoSubmittedProcedurePolicyInfoPlanLimitationsModel extends RestError {

    private String procedureSubtype;
    private String planLimitationValue;

    public String getProcedureSubtype() {
        return procedureSubtype;
    }

    public void setProcedureSubtype(String procedureSubtype) {
        this.procedureSubtype = procedureSubtype;
    }

    public String getPlanLimitationValue() {
        return planLimitationValue;
    }

    public void setPlanLimitationValue(String planLimitationValue) {
        this.planLimitationValue = planLimitationValue;
    }

}