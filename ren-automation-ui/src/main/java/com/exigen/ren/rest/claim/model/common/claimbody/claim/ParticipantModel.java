package com.exigen.ren.rest.claim.model.common.claimbody.claim;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.List;
import java.util.Objects;

public class ParticipantModel extends Model {
    private String oid;
    private String titleCd;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nameSuffix;
    private String birthDt;
    private String gender;
    private String maritalStatus;
    private String relationShipToInsured;
    private List<AddressModel> addresses;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getTitleCd() {
        return titleCd;
    }

    public void setTitleCd(String titleCd) {
        this.titleCd = titleCd;
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

    public String getNameSuffix() {
        return nameSuffix;
    }

    public void setNameSuffix(String nameSuffix) {
        this.nameSuffix = nameSuffix;
    }

    public String getBirthDt() {
        return birthDt;
    }

    public void setBirthDt(String birthDt) {
        this.birthDt = birthDt;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getRelationShipToInsured() {
        return relationShipToInsured;
    }

    public void setRelationShipToInsured(String relationShipToInsured) {
        this.relationShipToInsured = relationShipToInsured;
    }

    public List<AddressModel> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressModel> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ParticipantModel that = (ParticipantModel) o;
        return Objects.equals(oid, that.oid) &&
                Objects.equals(titleCd, that.titleCd) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(middleName, that.middleName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(nameSuffix, that.nameSuffix) &&
                Objects.equals(birthDt, that.birthDt) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(maritalStatus, that.maritalStatus) &&
                Objects.equals(relationShipToInsured, that.relationShipToInsured) &&
                Objects.equals(addresses, that.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), oid, titleCd, firstName, middleName, lastName, nameSuffix, birthDt, gender, maritalStatus, relationShipToInsured, addresses);
    }
}
