package com.exigen.ren.rest.dxp.model.claim.claimsEmployerModels.claimsAccidentEmployerModels;

import com.exigen.ren.rest.dxp.model.claim.claimsEmployerModels.ClaimsEmployerIncidentAbstractModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CriticalIllnessIncidentModel extends ClaimsEmployerIncidentAbstractModel {
    private CriticalIllnessModel criticalIllness;

    public CriticalIllnessModel getCriticalIllness() {
        return criticalIllness;
    }

    public void setCriticalIllness(CriticalIllnessModel criticalIllness) {
        this.criticalIllness = criticalIllness;
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
        CriticalIllnessIncidentModel that = (CriticalIllnessIncidentModel) o;
        return Objects.equals(criticalIllness, that.criticalIllness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), criticalIllness);
    }
}
