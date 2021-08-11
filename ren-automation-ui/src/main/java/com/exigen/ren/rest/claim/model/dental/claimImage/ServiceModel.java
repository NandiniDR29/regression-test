package com.exigen.ren.rest.claim.model.dental.claimImage;

import com.exigen.ipb.eisa.ws.rest.model.Model;

public class ServiceModel extends Model {

    private MasterPolicyDetailsModel masterPolicyDetails;

    public MasterPolicyDetailsModel getMasterPolicyDetails() {
        return masterPolicyDetails;
    }

    public void setMasterPolicyDetails(MasterPolicyDetailsModel masterPolicyDetails) {
        this.masterPolicyDetails = masterPolicyDetails;
    }
}