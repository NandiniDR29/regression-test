/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.platform.providers.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;

public class ServiceProviderModel extends Model {
    private ProviderModel individualInfo;
    private ProviderModel nonIndividualInfo;
    private String individualFirstName;
    private String individualLastName;
    private TermModel thirdPartyTerm;

    public ProviderModel getIndividualInfo() {
        return individualInfo;
    }

    public void setIndividualInfo(ProviderModel individualInfo) {
        this.individualInfo = individualInfo;
    }

    public ProviderModel getNonIndividualInfo() {
        return nonIndividualInfo;
    }

    public void setNonIndividualInfo(ProviderModel nonIndividualInfo) {
        this.nonIndividualInfo = nonIndividualInfo;
    }

    public String getIndividualFirstName() {
        return individualFirstName;
    }

    public void setIndividualFirstName(String individualFirstName) {
        this.individualFirstName = individualFirstName;
    }

    public String getIndividualLastName() {
        return individualLastName;
    }

    public void setIndividualLastName(String individualLastName) {
        this.individualLastName = individualLastName;
    }

    public TermModel getThirdPartyTerm() {
        return thirdPartyTerm;
    }

    public void setThirdPartyTerm(TermModel thirdPartyTerm) {
        this.thirdPartyTerm = thirdPartyTerm;
    }
}
