package com.exigen.ren.rest.dxp.model.certificate;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployerGroupsGroupMemberModel extends RestError {

    private String groupCustomerNumber;
    private String customerNumber;
    private String displayValue;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String genderCd;
    private String taxId;
    private String location;
    private String dateOfHire;
    private String computedCoverageStatusCd;
    private CertificatesCount certificatesCount;

    public String getGroupCustomerNumber() {
        return groupCustomerNumber;
    }

    public void setGroupCustomerNumber(String groupCustomerNumber) {
        this.groupCustomerNumber = groupCustomerNumber;
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

    public String getGenderCd() {
        return genderCd;
    }

    public void setGenderCd(String genderCd) {
        this.genderCd = genderCd;
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

    public String getComputedCoverageStatusCd() {
        return computedCoverageStatusCd;
    }

    public void setComputedCoverageStatusCd(String computedCoverageStatusCd) {
        this.computedCoverageStatusCd = computedCoverageStatusCd;
    }

    public CertificatesCount getCertificatesCount() {
        return certificatesCount;
    }

    public void setCertificatesCount(CertificatesCount certificatesCount) {
        this.certificatesCount = certificatesCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        if (!super.equals(o)) {return false;}
        EmployerGroupsGroupMemberModel that = (EmployerGroupsGroupMemberModel) o;
        return Objects.equals(groupCustomerNumber, that.groupCustomerNumber) &&
                Objects.equals(customerNumber, that.customerNumber) &&
                Objects.equals(displayValue, that.displayValue) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(dateOfBirth, that.dateOfBirth) &&
                Objects.equals(genderCd, that.genderCd) &&
                Objects.equals(taxId, that.taxId) &&
                Objects.equals(location, that.location) &&
                Objects.equals(dateOfHire, that.dateOfHire) &&
                Objects.equals(computedCoverageStatusCd, that.computedCoverageStatusCd) &&
                Objects.equals(certificatesCount, that.certificatesCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), groupCustomerNumber, customerNumber, displayValue, firstName, lastName, dateOfBirth, genderCd, taxId, location, dateOfHire, computedCoverageStatusCd, certificatesCount);
    }

    public static class CertificatesCount {
        private String total;
        private String expired;
        private String pendingCancellation;
        private String pending;
        private String active;
        private String cancelled;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getExpired() {
            return expired;
        }

        public void setExpired(String expired) {
            this.expired = expired;
        }

        public String getPendingCancellation() {
            return pendingCancellation;
        }

        public void setPendingCancellation(String pendingCancellation) {
            this.pendingCancellation = pendingCancellation;
        }

        public String getPending() {
            return pending;
        }

        public void setPending(String pending) {
            this.pending = pending;
        }

        public String getActive() {
            return active;
        }

        public void setActive(String active) {
            this.active = active;
        }

        public String getCancelled() {
            return cancelled;
        }

        public void setCancelled(String cancelled) {
            this.cancelled = cancelled;
        }
    }
}
