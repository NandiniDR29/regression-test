package com.exigen.ren.rest.dxp.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.exigen.ren.rest.model.RestError;

import java.util.List;
import java.util.Objects;

public class CustomerRenContacts extends RestError {
    private List<CustomerRenContact> emails;
    private List<CustomerRenContact> addresses;

    public List<CustomerRenContact> getEmails() {
        return emails;
    }

    public void setEmails(List<CustomerRenContact> emails) {
        this.emails = emails;
    }

    public List<CustomerRenContact> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<CustomerRenContact> addresses) {
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
        CustomerRenContacts that = (CustomerRenContacts) o;
        return Objects.equals(emails, that.emails) &&
                Objects.equals(addresses, that.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), emails, addresses);
    }
}
