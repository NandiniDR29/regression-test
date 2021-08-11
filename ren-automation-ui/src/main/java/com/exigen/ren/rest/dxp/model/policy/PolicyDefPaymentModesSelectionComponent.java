package com.exigen.ren.rest.dxp.model.policy;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyDefPaymentModesSelectionComponent extends RestError {

    private String memberPaymentModes;
    private String sponsorPaymentMode;

    public String getMemberPaymentModes() {
        return memberPaymentModes;
    }

    public void setMemberPaymentModes(String memberPaymentModes) {
        this.memberPaymentModes = memberPaymentModes;
    }

    public String getSponsorPaymentMode() {
        return sponsorPaymentMode;
    }

    public void setSponsorPaymentMode(String sponsorPaymentMode) {
        this.sponsorPaymentMode = sponsorPaymentMode;
    }
}