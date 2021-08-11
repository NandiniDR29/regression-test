/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.platform.providers.model;

import com.exigen.ren.rest.model.RestError;

import java.util.List;

public class ProviderModel extends RestError {
    private String id;
    private String oid;
    private String externalID;
    private String npi;
    private String taxId;
    private String taxID;
    private String status;
    private String name;
    private String startDate;
    private String countryCd;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String unitNumber;
    private String city;
    private String zipCd;
    private String state;
    private String phoneNo;
    private List<String> serviceTypes;
    private String contactFirstName;
    private String contactLastName;
    private String settlementMethod;
    private String finishDate;
    private String vendorTypeCd;
    private ServiceProviderDataModel serviceProviderCreateDTO;
    private String effective;
    private String expiration;
    private String vendorRating;
    private String regionCd;
    private String insuredCorrespondenceRequired;
    private String externalSourceType;
    private String vendorProfileType;
    private boolean mailingAddressSame;
    private IdentitiesModel identities;
    private List<FinancialInfoModel> financialInfo;
    private List<LicenceOptionsModel> licenceOptions;
    private Boolean fraudInd;
    private String fraudType;
    private String fraudDetails;

    public List<FinancialInfoModel> getFinancialInfo() {
        return financialInfo;
    }

    public void setFinancialInfo(List<FinancialInfoModel> financialInfo) {
        this.financialInfo = financialInfo;
    }

    public List<LicenceOptionsModel> getLicenceOptions() {
        return licenceOptions;
    }

    public void setLicenceOptions(List<LicenceOptionsModel> licenceOptions) {
        this.licenceOptions = licenceOptions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getExternalID() {
        return externalID;
    }

    public void setExternalID(String externalID) {
        this.externalID = externalID;
    }

    public String getNpi() {
        return npi;
    }

    public void setNpi(String npi) {
        this.npi = npi;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getTaxID() {
        return taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCd() {
        return countryCd;
    }

    public void setCountryCd(String countryCd) {
        this.countryCd = countryCd;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCd() {
        return zipCd;
    }

    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ServiceProviderDataModel getServiceProviderCreateDTO() {
        return serviceProviderCreateDTO;
    }

    public void setServiceProviderCreateDTO(ServiceProviderDataModel serviceProviderCreateDTO) {
        this.serviceProviderCreateDTO = serviceProviderCreateDTO;
    }

    public String getEffective() {
        return effective;
    }

    public void setEffective(String effective) {
        this.effective = effective;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getVendorRating() {
        return vendorRating;
    }

    public void setVendorRating(String vendorRating) {
        this.vendorRating = vendorRating;
    }

    public String getRegionCd() {
        return regionCd;
    }

    public void setRegionCd(String regionCd) {
        this.regionCd = regionCd;
    }

    public String getInsuredCorrespondenceRequired() {
        return insuredCorrespondenceRequired;
    }

    public void setInsuredCorrespondenceRequired(String insuredCorrespondenceRequired) {
        this.insuredCorrespondenceRequired = insuredCorrespondenceRequired;
    }

    public String getExternalSourceType() {
        return externalSourceType;
    }

    public void setExternalSourceType(String externalSourceType) {
        this.externalSourceType = externalSourceType;
    }

    public String getVendorProfileType() {
        return vendorProfileType;
    }

    public void setVendorProfileType(String vendorProfileType) {
        this.vendorProfileType = vendorProfileType;
    }

    public boolean isMailingAddressSame() {
        return mailingAddressSame;
    }

    public void setMailingAddressSame(boolean mailingAddressSame) {
        this.mailingAddressSame = mailingAddressSame;
    }

    public IdentitiesModel getIdentities() {
        return identities;
    }

    public void setIdentities(IdentitiesModel identities) {
        this.identities = identities;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public List<String> getServiceTypes() {
        return serviceTypes;
    }

    public void setServiceTypes(List<String> serviceTypes) {
        this.serviceTypes = serviceTypes;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getSettlementMethod() {
        return settlementMethod;
    }

    public void setSettlementMethod(String settlementMethod) {
        this.settlementMethod = settlementMethod;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getVendorTypeCd() {
        return vendorTypeCd;
    }

    public void setVendorTypeCd(String vendorTypeCd) {
        this.vendorTypeCd = vendorTypeCd;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public Boolean isFraudInd() {
        return fraudInd;
    }

    public void setFraudInd(Boolean fraudInd) {
        this.fraudInd = fraudInd;
    }

    public String getFraudType() {
        return fraudType;
    }

    public void setFraudType(String fraudType) {
        this.fraudType = fraudType;
    }

    public String getFraudDetails() {
        return fraudDetails;
    }

    public void setFraudDetails(String fraudDetails) {
        this.fraudDetails = fraudDetails;
    }
}
