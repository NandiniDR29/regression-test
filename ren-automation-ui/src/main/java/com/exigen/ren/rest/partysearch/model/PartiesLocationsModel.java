/* Copyright © 2018 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.partysearch.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PartiesLocationsModel extends Model {
    private String zip;
    private String country;
    private String city;
    private String confidentialFlag;
    private List<String> roles;
    private String partyType;
    private String doNotSolicit;
    private Date lastUpdated;
    private String addressTypeCd;
    private String street1;
    private String confidentialReference;
    private String state;
    private String partyId;
    private List<EntitiesModel> entities;

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
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

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

    public String getPartyType() {
        return partyType;
    }

    public void setDoNotSolicit(String doNotSolicit) {
        this.doNotSolicit = doNotSolicit;
    }

    public String getDoNotSolicit() {
        return doNotSolicit;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setAddressTypeCd(String addressTypeCd) {
        this.addressTypeCd = addressTypeCd;
    }

    public String getAddressTypeCd() {
        return addressTypeCd;
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

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setEntities(List<EntitiesModel> entities) {
        this.entities = entities;
    }

    public List<EntitiesModel> getEntities() {
        return entities;
    }
}
