package com.exigen.ren.rest.salesforce.model;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalesforceAccountModel extends RestError {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("EIS_ID__c")
    private String eisId;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("BillingStreet")
    private String billingStreet;
    @JsonProperty("BillingCity")
    private String billingCity;
    @JsonProperty("BillingState")
    private String billingState;
    @JsonProperty("BillingPostalCode")
    private String billingPostalCode;
    @JsonProperty("BillingCountry")
    private String billingCountry;
    @JsonProperty("Sic")
    private String sic;
    @JsonProperty("SicDesc")
    private String sicDesc;
    @JsonProperty("Tax_ID_Number__c")
    private String taxId;
    @JsonProperty("Phone")
    private String phone;
    @JsonProperty("NumberOfEmployees")
    private String numberOfEmployees;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEisId() {
        return eisId;
    }

    public void setEisId(String eisId) {
        this.eisId = eisId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBillingStreet() {
        return billingStreet;
    }

    public void setBillingStreet(String billingStreet) {
        this.billingStreet = billingStreet;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingPostalCode() {
        return billingPostalCode;
    }

    public void setBillingPostalCode(String billingPostalCode) {
        this.billingPostalCode = billingPostalCode;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getSic() {
        return sic;
    }

    public void setSic(String sic) {
        this.sic = sic;
    }

    public String getSicDesc() {
        return sicDesc;
    }

    public void setSicDesc(String sicDesc) {
        this.sicDesc = sicDesc;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        SalesforceAccountModel that = (SalesforceAccountModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(eisId, that.eisId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(billingStreet, that.billingStreet) &&
                Objects.equals(billingCity, that.billingCity) &&
                Objects.equals(billingState, that.billingState) &&
                Objects.equals(billingPostalCode, that.billingPostalCode) &&
                Objects.equals(billingCountry, that.billingCountry) &&
                Objects.equals(sic, that.sic) &&
                Objects.equals(sicDesc, that.sicDesc) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(numberOfEmployees, that.numberOfEmployees) &&
                Objects.equals(taxId, that.taxId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, eisId, name, type, billingStreet, billingCity, billingState, billingPostalCode, billingCountry, sic, sicDesc, taxId, phone, numberOfEmployees);
    }
}
