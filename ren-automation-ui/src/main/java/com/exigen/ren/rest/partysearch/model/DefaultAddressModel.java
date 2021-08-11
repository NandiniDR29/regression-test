/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.partysearch.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultAddressModel extends Model {
    private String zip;
    private String preferredAddress;
    private String country;
    private String addressTypeCd;
    private String city;
    private String confidentialFlag;
    private String street1;
    private String confidentialReference;
    private String street2;
    private String state;
    private String addressLine3;
    @JsonProperty("DoNotSolicit")
    private String doNotSolicit;
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getZip() {
        return zip;
    }

    public void setPreferredAddress(String preferredAddress) {
        this.preferredAddress = preferredAddress;
    }
    public String getPreferredAddress() {
        return preferredAddress;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public String getCountry() {
        return country;
    }

    public void setAddressTypeCd(String addressTypeCd) {
        this.addressTypeCd = addressTypeCd;
    }
    public String getAddressTypeCd() {
        return addressTypeCd;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
    }

    public void setConfidentialFlag(String confidentialFlag) {
        this.confidentialFlag = confidentialFlag;
    }
    public String getConfidentialFlag() {
        return confidentialFlag;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }
    public String getStreet1() {
        return street1;
    }

    public void setConfidentialReference(String confidentialReference) {
        this.confidentialReference = confidentialReference;
    }
    public String getConfidentialReference() {
        return confidentialReference;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }
    public String getStreet2() {
        return street2;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setDoNotSolicit(String doNotSolicit) {
        this.doNotSolicit = doNotSolicit;
    }
    public String getDoNotSolicit() {
        return doNotSolicit;
    }

}
