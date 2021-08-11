/* Copyright © 2018 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.partysearch.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BobReferenceModel extends Model {

    private String objectName;
    private String objectNumber;
    private String producerCode;
    private String subProducerCode;
    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }
    public String getObjectName() {
        return objectName;
    }

    public void setObjectNumber(String objectNumber) {
        this.objectNumber = objectNumber;
    }
    public String getObjectNumber() {
        return objectNumber;
    }

    public void setProducerCode(String producerCode) {
        this.producerCode = producerCode;
    }
    public String getProducerCode() {
        return producerCode;
    }

    public void setSubProducerCode(String subProducerCode) {
        this.subProducerCode = subProducerCode;
    }
    public String getSubProducerCode() {
        return subProducerCode;
    }

}