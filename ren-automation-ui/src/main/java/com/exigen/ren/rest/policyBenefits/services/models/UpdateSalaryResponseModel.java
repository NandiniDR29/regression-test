package com.exigen.ren.rest.policyBenefits.services.models;

import com.exigen.ren.rest.model.RestError;

import java.util.List;
import java.util.Objects;

public class UpdateSalaryResponseModel extends RestError {
    private List<ProcessedPolicyModel> processedPolicies;

    public List<ProcessedPolicyModel> getProcessedPolicies() {
        return processedPolicies;
    }

    public void setProcessedPolicies(List<ProcessedPolicyModel> processedPolicies) {
        this.processedPolicies = processedPolicies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UpdateSalaryResponseModel that = (UpdateSalaryResponseModel) o;
        return Objects.equals(processedPolicies, that.processedPolicies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), processedPolicies);
    }
}
