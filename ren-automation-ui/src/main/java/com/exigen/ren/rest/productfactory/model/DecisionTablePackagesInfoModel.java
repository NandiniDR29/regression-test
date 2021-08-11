/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.productfactory.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.ArrayList;

public class DecisionTablePackagesInfoModel extends Model {
    private String code;
    private String label;
    private String description;
    private String requestDate;
    private String authorityLevel;
    private ArrayList<DimensionsDataModel> dimensions;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getAuthorityLevel() {
        return authorityLevel;
    }

    public void setAuthorityLevel(String authorityLevel) {
        this.authorityLevel = authorityLevel;
    }

    public ArrayList<DimensionsDataModel> getDimensions() {
        return dimensions;
    }

    public void setDimensions(ArrayList<DimensionsDataModel> dimensions) {
        this.dimensions = dimensions;
    }
}
