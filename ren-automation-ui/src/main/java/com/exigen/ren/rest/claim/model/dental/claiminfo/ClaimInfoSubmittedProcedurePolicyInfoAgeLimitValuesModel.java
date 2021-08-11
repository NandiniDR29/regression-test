package com.exigen.ren.rest.claim.model.dental.claiminfo;

import com.exigen.ren.rest.model.RestError;

public class ClaimInfoSubmittedProcedurePolicyInfoAgeLimitValuesModel extends RestError {

    private String procedureSubtype;
    private String ageLimitValue;

    public String getProcedureSubtype() {
        return procedureSubtype;
    }

    public void setProcedureSubtype(String procedureSubtype) {
        this.procedureSubtype = procedureSubtype;
    }

    public String getAgeLimitValue() {
        return ageLimitValue;
    }

    public void setAgeLimitValue(String ageLimitValue) {
        this.ageLimitValue = ageLimitValue;
    }

}
