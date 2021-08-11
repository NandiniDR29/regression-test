package com.exigen.ren.rest.billing.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillingAccountsActionsModel {

    private String actionCd;


    public String getActionCd() {
        return actionCd;
    }

    public void setActionCd(String actionCd) {
        this.actionCd = actionCd;
    }
}
