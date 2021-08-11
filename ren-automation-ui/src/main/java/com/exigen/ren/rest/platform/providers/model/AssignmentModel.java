/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.platform.providers.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;

public class AssignmentModel extends Model {
    private String id;
    private String oid;
    private String assignmentType;
    private String externalId;
    private String effective;
    private String expiration;
    private ProviderIdentifiersModel nonIndividualProviderIdentifiers;
    private ProviderIdentifiersModel individualProviderIdentifiers;
    private FacilityDataModel facilityDTO;
    private ProviderIdentifiersModel providerIdentifiers;
    private String facilityID;
    private String facilityExternalId;
    private String serviceFacilityOID;
    private String providerFinancialInfoOID;
    private TermModel term;

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

    public String getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
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

    public ProviderIdentifiersModel getNonIndividualProviderIdentifiers() {
        return nonIndividualProviderIdentifiers;
    }

    public void setNonIndividualProviderIdentifiers(ProviderIdentifiersModel nonIndividualProviderIdentifiers) {
        this.nonIndividualProviderIdentifiers = nonIndividualProviderIdentifiers;
    }

    public ProviderIdentifiersModel getIndividualProviderIdentifiers() {
        return individualProviderIdentifiers;
    }

    public void setIndividualProviderIdentifiers(ProviderIdentifiersModel individualProviderIdentifiers) {
        this.individualProviderIdentifiers = individualProviderIdentifiers;
    }

    public FacilityDataModel getFacilityDTO() {
        return facilityDTO;
    }

    public void setFacilityDTO(FacilityDataModel facilityDTO) {
        this.facilityDTO = facilityDTO;
    }

    public ProviderIdentifiersModel getProviderIdentifiers() {
        return providerIdentifiers;
    }

    public void setProviderIdentifiers(ProviderIdentifiersModel providerIdentifiers) {
        this.providerIdentifiers = providerIdentifiers;
    }

    public String getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(String facilityID) {
        this.facilityID = facilityID;
    }

    public String getFacilityExternalId() {
        return facilityExternalId;
    }

    public void setFacilityExternalId(String facilityExternalId) {
        this.facilityExternalId = facilityExternalId;
    }

    public String getServiceFacilityOID() {
        return serviceFacilityOID;
    }

    public void setServiceFacilityOID(String serviceFacilityOID) {
        this.serviceFacilityOID = serviceFacilityOID;
    }

    public String getProviderFinancialInfoOID() {
        return providerFinancialInfoOID;
    }

    public void setProviderFinancialInfoOID(String providerFinancialInfoOID) {
        this.providerFinancialInfoOID = providerFinancialInfoOID;
    }

    public TermModel getTerm() {
        return term;
    }

    public void setTerm(TermModel term) {
        this.term = term;
    }
}
