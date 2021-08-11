package com.exigen.ren.rest.dxp.model.claim.claimsEmployerModels.claimsDisabilityEmployerModels;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LongTermDisabilityModel extends RestError {
    private List<LongTermDisabilityCoverageEvaluationModel> longTermDisabilityCoverageEvaluations;

    public List<LongTermDisabilityCoverageEvaluationModel> getLongTermDisabilityCoverageEvaluations() {
        return longTermDisabilityCoverageEvaluations;
    }

    public void setLongTermDisabilityCoverageEvaluations(List<LongTermDisabilityCoverageEvaluationModel> longTermDisabilityCoverageEvaluations) {
        this.longTermDisabilityCoverageEvaluations = longTermDisabilityCoverageEvaluations;
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
        LongTermDisabilityModel that = (LongTermDisabilityModel) o;
        return Objects.equals(longTermDisabilityCoverageEvaluations, that.longTermDisabilityCoverageEvaluations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), longTermDisabilityCoverageEvaluations);
    }
}
