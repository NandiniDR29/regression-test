package com.exigen.ren.rest.claim.model.dental.claimImage;

import com.exigen.ipb.eisa.ws.rest.model.Model;

public class MajorModel extends Model {
    private String tmjDiagnosticsXray;
    private String inlaysOptionBenefit;

    public String getTmjDiagnosticsXray() {
        return tmjDiagnosticsXray;
    }

    public void setTmjDiagnosticsXray(String tmjDiagnosticsXray) {
        this.tmjDiagnosticsXray = tmjDiagnosticsXray;
    }

    public String getInlaysOptionBenefit() {
        return inlaysOptionBenefit;
    }

    public void setInlaysOptionBenefit(String inlaysOptionBenefit) {
        this.inlaysOptionBenefit = inlaysOptionBenefit;
    }
}