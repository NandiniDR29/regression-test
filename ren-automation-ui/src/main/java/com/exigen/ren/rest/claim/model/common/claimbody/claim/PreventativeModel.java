package com.exigen.ren.rest.claim.model.common.claimbody.claim;

import com.exigen.ipb.eisa.ws.rest.model.Model;

public class PreventativeModel extends Model {
    private String includeBicuspidSealant;

    public String getIncludeBicuspidSealant() {
        return includeBicuspidSealant;
    }

    public void setIncludeBicuspidSealant(String includeBicuspidSealant) {
        this.includeBicuspidSealant = includeBicuspidSealant;
    }
}