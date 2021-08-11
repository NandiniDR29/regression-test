/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.customer.campaigns.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductsModel extends Model {
    private String productCd;
    private String lobCd;
    private String riskCd;

    public void setProductCd(String productCd) {
        this.productCd = productCd;
    }

    public String getProductCd() {
        return productCd;
    }

    public void setLobCd(String lobCd) {
        this.lobCd = lobCd;
    }

    public String getLobCd() {
        return lobCd;
    }

    public void setRiskCd(String riskCd) {
        this.riskCd = riskCd;
    }

    public String getRiskCd() {
        return riskCd;
    }
}
