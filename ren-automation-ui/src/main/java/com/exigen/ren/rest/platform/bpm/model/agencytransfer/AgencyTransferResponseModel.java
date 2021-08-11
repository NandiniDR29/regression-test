/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.platform.bpm.model.agencytransfer;

import com.exigen.istf.data.TestData;
import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgencyTransferResponseModel extends RestError {

    private String contextDescription;
    private String messagesAsString;
    private String successful;
    private String status;
    private String entityType;
    private String entityRefNo;
    private String agencyFrom;
    private String agencyTo;
    private String includeCompleted;

    public AgencyTransferResponseModel() {
    }

    public AgencyTransferResponseModel(TestData testData) {
        super(testData);
        this.contextDescription = testData.getValue("contextDescription");
        this.messagesAsString = testData.getValue("messagesAsString");
        this.successful = testData.getValue("successful");
        this.status = testData.getValue("status");
    }

    public String getContextDescription() {
        return contextDescription;
    }

    public void setContextDescription(String contextDescription) {
        this.contextDescription = contextDescription;
    }

    public String getMessagesAsString() {
        return messagesAsString;
    }

    public void setMessagesAsString(String messagesAsString) {
        this.messagesAsString = messagesAsString;
    }

    public String getSuccessful() {
        return successful;
    }

    public void setSuccessful(String successful) {
        this.successful = successful;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityRefNo() {
        return entityRefNo;
    }

    public void setEntityRefNo(String entityRefNo) {
        this.entityRefNo = entityRefNo;
    }

    public String getAgencyFrom() {
        return agencyFrom;
    }

    public void setAgencyFrom(String agencyFrom) {
        this.agencyFrom = agencyFrom;
    }

    public String getAgencyTo() {
        return agencyTo;
    }

    public void setAgencyTo(String agencyTo) {
        this.agencyTo = agencyTo;
    }

    public String getIncludeCompleted() {
        return includeCompleted;
    }

    public void setIncludeCompleted(String includeCompleted) {
        this.includeCompleted = includeCompleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || !(o instanceof RestError)) {
            return false;
        }

        if (getErrorCode() != null) {
            return super.equals(o);
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        AgencyTransferResponseModel that = (AgencyTransferResponseModel) o;

        if (contextDescription != null ? !contextDescription.equals(that.contextDescription) : that.contextDescription != null) {
            return false;
        }
        if (messagesAsString != null ? !messagesAsString.equals(that.messagesAsString) : that.messagesAsString != null) {
            return false;
        }
        if (successful != null ? !successful.equals(that.successful) : that.successful != null) {
            return false;
        }
        return status != null ? status.equals(that.status) : that.status == null;
    }

    @Override
    public int hashCode() {
        int result = contextDescription != null ? contextDescription.hashCode() : 0;
        result = 31 * result + (messagesAsString != null ? messagesAsString.hashCode() : 0);
        result = 31 * result + (successful != null ? successful.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AgencyTransferResponse{" +
                "contextDescription='" + contextDescription + '\'' +
                ", messagesAsString='" + messagesAsString + '\'' +
                ", successful='" + successful + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
