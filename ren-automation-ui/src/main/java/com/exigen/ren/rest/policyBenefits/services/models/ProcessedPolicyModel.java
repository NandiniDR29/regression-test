package com.exigen.ren.rest.policyBenefits.services.models;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ProcessedPolicyModel extends Model {
    @JsonProperty("PolicyNumber")
    private String policyNumber;

    @JsonProperty("Status")
    private String status;

    private String message;

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProcessedPolicyModel that = (ProcessedPolicyModel) o;
        return Objects.equals(policyNumber, that.policyNumber) &&
                Objects.equals(status, that.status) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), policyNumber, status, message);
    }
}
