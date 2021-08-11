package com.exigen.ren.rest.claim.model.dental.processediclaim;

import com.exigen.ren.rest.model.RestError;

import java.util.List;
import java.util.Objects;

public class ProcessEdiClaimResponseModel extends RestError {
    private String claimNumber;
    private List<String> errorMessages;

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        if (!super.equals(o)) {return false;}
        ProcessEdiClaimResponseModel that = (ProcessEdiClaimResponseModel) o;
        return Objects.equals(claimNumber, that.claimNumber) &&
                Objects.equals(errorMessages, that.errorMessages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), claimNumber, errorMessages);
    }
}

