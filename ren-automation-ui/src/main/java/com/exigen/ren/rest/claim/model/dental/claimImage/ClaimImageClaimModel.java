package com.exigen.ren.rest.claim.model.dental.claimImage;

import com.exigen.ipb.eisa.ws.rest.model.Model;

public class ClaimImageClaimModel extends Model {
    private ClaimExtensionModel extension;

    public ClaimExtensionModel getExtension() {
        return extension;
    }

    public void setExtension(ClaimExtensionModel extension) {
        this.extension = extension;
    }
}