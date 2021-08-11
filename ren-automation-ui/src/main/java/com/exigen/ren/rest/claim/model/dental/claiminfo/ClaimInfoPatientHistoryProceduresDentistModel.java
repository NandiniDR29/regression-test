package com.exigen.ren.rest.claim.model.dental.claiminfo;

import com.exigen.ren.rest.model.RestError;

public class ClaimInfoPatientHistoryProceduresDentistModel extends RestError {

    private String dentistID;
    private String inOutNetwork;

    public String getDentistID() {
        return dentistID;
    }

    public void setDentistID(String dentistID) {
        this.dentistID = dentistID;
    }

    public String getInOutNetwork() {
        return inOutNetwork;
    }

    public void setInOutNetwork(String inOutNetwork) {
        this.inOutNetwork = inOutNetwork;
    }

}
