/* Copyright © 2018 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.customer.groupSponsors.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.exigen.ren.rest.customer.model.BusinessDetailsModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParticipantModel extends Model {

    private String customerNumber;
    private String customerType;
    private String accountNumber;
    private String customerStatus;
    private String sourceCd;
    private String ratingCd;
    private String displayValue;
    private String brandCd;
    private String preferredSpokenLanguageCd;
    private String preferredWrittenLanguageCd;
    private boolean paperless;
    private List<String> segments;
    private boolean registeredOnline;
    private boolean archived;
    private String sourceOfExchangeRate;
    private String rateDateIntake;
    private String rateDatePayment;
    private String preferredCurrency;
    private IndividualDetailsModel individualDetails;
    private BusinessDetailsModel businessDetails;
    private ExtensionFieldsModel extensionFields;

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerNumber() {
        return this.customerNumber;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerType() {
        return this.customerType;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getCustomerStatus() {
        return this.customerStatus;
    }

    public void setSourceCd(String sourceCd) {
        this.sourceCd = sourceCd;
    }

    public String getSourceCd() {
        return this.sourceCd;
    }

    public void setRatingCd(String ratingCd) {
        this.ratingCd = ratingCd;
    }

    public String getRatingCd() {
        return this.ratingCd;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return this.displayValue;
    }

    public void setBrandCd(String brandCd) {
        this.brandCd = brandCd;
    }

    public String getBrandCd() {
        return this.brandCd;
    }

    public void setPreferredSpokenLanguageCd(String preferredSpokenLanguageCd) {
        this.preferredSpokenLanguageCd = preferredSpokenLanguageCd;
    }

    public String getPreferredSpokenLanguageCd() {
        return this.preferredSpokenLanguageCd;
    }

    public void setPreferredWrittenLanguageCd(String preferredWrittenLanguageCd) {
        this.preferredWrittenLanguageCd = preferredWrittenLanguageCd;
    }

    public String getPreferredWrittenLanguageCd() {
        return this.preferredWrittenLanguageCd;
    }

    public void setPaperless(boolean paperless) {
        this.paperless = paperless;
    }

    public boolean getPaperless() {
        return this.paperless;
    }

    public void setSegments(List<String> segments) {
        this.segments = segments;
    }

    public List<String> getSegments() {
        return this.segments;
    }

    public void setRegisteredOnline(boolean registeredOnline) {
        this.registeredOnline = registeredOnline;
    }

    public boolean getRegisteredOnline() {
        return this.registeredOnline;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean getArchived() {
        return this.archived;
    }

    public void setSourceOfExchangeRate(String sourceOfExchangeRate) {
        this.sourceOfExchangeRate = sourceOfExchangeRate;
    }

    public String getSourceOfExchangeRate() {
        return this.sourceOfExchangeRate;
    }

    public void setRateDateIntake(String rateDateIntake) {
        this.rateDateIntake = rateDateIntake;
    }

    public String getRateDateIntake() {
        return this.rateDateIntake;
    }

    public void setRateDatePayment(String rateDatePayment) {
        this.rateDatePayment = rateDatePayment;
    }

    public String getRateDatePayment() {
        return this.rateDatePayment;
    }

    public void setPreferredCurrency(String preferredCurrency) {
        this.preferredCurrency = preferredCurrency;
    }

    public String getPreferredCurrency() {
        return this.preferredCurrency;
    }

    public void setIndividualDetails(IndividualDetailsModel individualDetails) {
        this.individualDetails = individualDetails;
    }

    public IndividualDetailsModel getIndividualDetails() {
        return this.individualDetails;
    }

    public void setBusinessDetails(BusinessDetailsModel businessDetails) {
        this.businessDetails = businessDetails;
    }

    public BusinessDetailsModel getBusinessDetails() {
        return this.businessDetails;
    }

    public void setExtensionFields(ExtensionFieldsModel extensionFields) {
        this.extensionFields = extensionFields;
    }

    public ExtensionFieldsModel getExtensionFields() {
        return this.extensionFields;
    }
}
