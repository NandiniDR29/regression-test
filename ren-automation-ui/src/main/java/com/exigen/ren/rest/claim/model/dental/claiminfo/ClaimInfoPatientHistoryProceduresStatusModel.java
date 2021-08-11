package com.exigen.ren.rest.claim.model.dental.claiminfo;

import com.exigen.ren.rest.model.RestError;

public class ClaimInfoPatientHistoryProceduresStatusModel extends RestError {

    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

}
