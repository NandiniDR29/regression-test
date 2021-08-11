package com.exigen.ren.rest.dxp.model;

import com.exigen.ren.rest.model.RestError;

import java.util.List;
import java.util.Objects;

public class CustomerGroupContactModel extends RestError {
    private String contactRelationshipId;
    private List<String> serviceRoleCds;
    private String customerNumber;
    private String displayValue;
    private String firstName;
    private String middleName;
    private String lastName;
    private String dateOfBirth;
    private boolean paperless;
    private List<ProfilePhoneModel> phones;
    private List<ProfileEmailModel> emails;
    private List<ProfileAddressesModel> addresses;

    public String getContactRelationshipId() {
        return contactRelationshipId;
    }

    public void setContactRelationshipId(String contactRelationshipId) {
        this.contactRelationshipId = contactRelationshipId;
    }

    public List<String> getServiceRoleCds() {
        return serviceRoleCds;
    }

    public void setServiceRoleCds(List<String> serviceRoleCds) {
        this.serviceRoleCds = serviceRoleCds;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean getPaperless() {
        return paperless;
    }

    public void setPaperless(boolean paperless) {
        this.paperless = paperless;
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
        CustomerGroupContactModel model = (CustomerGroupContactModel) o;
        return paperless == model.paperless &&
                Objects.equals(contactRelationshipId, model.contactRelationshipId) &&
                Objects.equals(serviceRoleCds, model.serviceRoleCds) &&
                Objects.equals(customerNumber, model.customerNumber) &&
                Objects.equals(displayValue, model.displayValue) &&
                Objects.equals(firstName, model.firstName) &&
                Objects.equals(middleName, model.middleName) &&
                Objects.equals(lastName, model.lastName) &&
                Objects.equals(dateOfBirth, model.dateOfBirth) &&
                Objects.equals(phones, model.phones) &&
                Objects.equals(emails, model.emails) &&
                Objects.equals(addresses, model.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), contactRelationshipId, serviceRoleCds, customerNumber, displayValue, firstName, middleName, lastName, dateOfBirth, paperless, phones, emails, addresses);
    }
}
