package com.exigen.ren.rest.claim.model.dental.claiminfo;

import com.exigen.ren.rest.model.RestError;

public class ClaimInfoSubmittedProcedurePolicyInfoProcedureSubtypeFrequencyModel extends RestError {

    private String procedureSubtype;
    private String frequency;

    public String getProcedureSubtype() {
        return procedureSubtype;
    }

    public void setProcedureSubtype(String procedureSubtype) {
        this.procedureSubtype = procedureSubtype;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

}