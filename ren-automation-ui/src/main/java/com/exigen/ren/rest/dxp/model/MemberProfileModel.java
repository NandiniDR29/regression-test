package com.exigen.ren.rest.dxp.model;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberProfileModel extends RestError {

    private String displayValue;
    private String firstName;
    private String middleName;
    private String lastName;
    private String dateOfBirth;
    private String genderCd;
    private String maritalStatusCd;
    private String taxId;
    private String location;
    private String dateOfHire;
    private String salaryAmount;
    private String payrollFrequency;
    private Boolean paperless;
    private List<ProfilePhoneModel> phones;
    private List<ProfileEmailModel> emails;
    private List<ProfileAddressesModel> addresses;
    private List<ProfileRelationshipsModel> relationships;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<ProfilePhoneModel> getPhones() {
        return phones;
    }

    public void setPhones(List<ProfilePhoneModel> phones) {
        this.phones = phones;
    }

    public List<ProfileEmailModel> getEmails() {
        return emails;
    }

    public void setEmails(List<ProfileEmailModel> emails) {
        this.emails = emails;
    }

    public List<ProfileAddressesModel> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<ProfileAddressesModel> addresses) {
        this.addresses = addresses;
    }

    public List<ProfileRelationshipsModel> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<ProfileRelationshipsModel> relationships) {
        this.relationships = relationships;
    }

    public String getGenderCd() {
        return genderCd;
    }

    public void setGenderCd(String genderCd) {
        this.genderCd = genderCd;
    }

    public String getMaritalStatusCd() {
        return maritalStatusCd;
    }

    public void setMaritalStatusCd(String maritalStatusCd) {
        this.maritalStatusCd = maritalStatusCd;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateOfHire() {
        return dateOfHire;
    }

    public void setDateOfHire(String dateOfHire) {
        this.dateOfHire = dateOfHire;
    }

    public String getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(String salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public String getPayrollFrequency() {
        return payrollFrequency;
    }

    public void setPayrollFrequency(String payrollFrequency) {
        this.payrollFrequency = payrollFrequency;
    }

    public Boolean getPaperless() {
        return paperless;
    }

    public void setPaperless(Boolean paperless) {
        this.paperless = paperless;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        if (!super.equals(o)) {return false;}
        MemberProfileModel that = (MemberProfileModel) o;
        return Objects.equals(displayValue, that.displayValue) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(middleName, that.middleName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(dateOfBirth, that.dateOfBirth) &&
                Objects.equals(phones, that.phones) &&
                Objects.equals(emails, that.emails) &&
                Objects.equals(addresses, that.addresses) &&
                Objects.equals(relationships, that.relationships);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), displayValue, firstName, middleName, lastName, dateOfBirth, phones, emails, addresses, relationships);
    }
}
