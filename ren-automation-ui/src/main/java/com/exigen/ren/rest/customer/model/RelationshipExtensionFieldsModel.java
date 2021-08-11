/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.customer.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelationshipExtensionFieldsModel extends Model {

    private String parentCustomerNumber;
    private List<String> serviceRoleCds;

    public RelationshipExtensionFieldsModel() {
    }

    public List<String> getServiceRoleCds() {
        return serviceRoleCds;
    }

    public void setServiceRoleCds(List<String> serviceRoleCds) {
        this.serviceRoleCds = serviceRoleCds;
    }

    public String getParentCustomerNumber() {
        return parentCustomerNumber;
    }

    public void setParentCustomerNumber(String parentCustomerNumber) {
        this.parentCustomerNumber = parentCustomerNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        if (!super.equals(o)) {return false;}
        RelationshipExtensionFieldsModel that = (RelationshipExtensionFieldsModel) o;
        return Objects.equals(parentCustomerNumber, that.parentCustomerNumber) &&
                Objects.equals(serviceRoleCds, that.serviceRoleCds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), parentCustomerNumber, serviceRoleCds);
    }

    @Override
    public String toString() {
        return "RelationshipExtensionFieldsModel{" +
                "parentCustomerNumber='" + parentCustomerNumber + '\'' +
                ", serviceRoleCds=" + serviceRoleCds +
                '}';
    }
}
