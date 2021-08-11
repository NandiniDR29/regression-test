package com.exigen.ren.rest.claim.model.dental.claimImage;

import com.exigen.ipb.eisa.ws.rest.model.Model;

public class ClaimExtensionModel extends Model {
    private PolicyInformationModel policyInformation;

    public PolicyInformationModel getPolicyInformation() {
        return policyInformation;
    }

    public void setPolicyInformation(PolicyInformationModel policyInformation) {
        this.policyInformation = policyInformation;
    }
}