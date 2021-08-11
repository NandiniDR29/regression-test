package com.exigen.ren.rest.policyBenefits.enrollmentServices.models;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentCensusRecordModel extends RestError {
    private String referenceId;
    private String status;
    private List<EnrollmentStatusMessageModel> statusMessage;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<EnrollmentStatusMessageModel> getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(List<EnrollmentStatusMessageModel> statusMessage) {
        this.statusMessage = statusMessage;
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
        EnrollmentCensusRecordModel that = (EnrollmentCensusRecordModel) o;
        return Objects.equals(referenceId, that.referenceId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(statusMessage, that.statusMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), referenceId, status, statusMessage);
    }
}
