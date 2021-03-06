package com.exigen.ren.rest.dxp.model.claim.claimsEmployerModels.claimsDisabilityEmployerModels;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShortTermDisabilityModel extends RestError {
    private List<ShortTermDisabilityCoverageEvaluationModel> shortTermDisabilityCoverageEvaluations;

    public List<ShortTermDisabilityCoverageEvaluationModel> getShortTermDisabilityCoverageEvaluations() {
        return shortTermDisabilityCoverageEvaluations;
    }

    public void setShortTermDisabilityCoverageEvaluations(List<ShortTermDisabilityCoverageEvaluationModel> shortTermDisabilityCoverageEvaluations) {
        this.shortTermDisabilityCoverageEvaluations = shortTermDisabilityCoverageEvaluations;
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
        ShortTermDisabilityModel that = (ShortTermDisabilityModel) o;
        return Objects.equals(shortTermDisabilityCoverageEvaluations, that.shortTermDisabilityCoverageEvaluations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shortTermDisabilityCoverageEvaluations);
    }
}
