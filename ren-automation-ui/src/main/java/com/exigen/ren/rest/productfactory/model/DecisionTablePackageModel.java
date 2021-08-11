/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.productfactory.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DecisionTablePackageModel extends Model {
    @JsonProperty("Policy")
    private PolicyDataModel policy;

    public PolicyDataModel getPolicyData() {
        return policy;
    }

    public void setPolicyData(PolicyDataModel policyDataModel) {
        this.policy = policyDataModel;
    }
}
