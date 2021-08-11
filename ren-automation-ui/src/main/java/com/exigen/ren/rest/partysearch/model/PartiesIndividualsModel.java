/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.partysearch.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PartiesIndividualsModel extends Model {
    private String lastName;
    private String deceased;
    private String agency;
    private DefaultAddressModel defaultAddress;
    private String confidentialFlag;
    private List<String> roles;
    private String partyType;
    private String customerNumber;
    private Date birthDate;
    private String firstName;
    private String archived;
    private Date lastUpdated;
    private String nationalId;
    private List<PhonesModel> phones;
    private String confidentialReference;
    private String partyId;

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setDeceased(String deceased) {
        this.deceased = deceased;
    }

    public String getDeceased() {
        return deceased;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAgency() {
        return agency;
    }

    public void setDefaultAddress(DefaultAddressModel defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public DefaultAddressModel getDefaultAddress() {
        return defaultAddress;
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

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setArchived(String archived) {
        this.archived = archived;
    }

    public String getArchived() {
        return archived;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setPhones(List<PhonesModel> phones) {
        this.phones = phones;
    }

    public List<PhonesModel> getPhones() {
        return phones;
    }

    public void setConfidentialReference(String confidentialReference) {
        this.confidentialReference = confidentialReference;
    }

    public String getConfidentialReference() {
        return confidentialReference;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getPartyId() {
        return partyId;
    }
}
