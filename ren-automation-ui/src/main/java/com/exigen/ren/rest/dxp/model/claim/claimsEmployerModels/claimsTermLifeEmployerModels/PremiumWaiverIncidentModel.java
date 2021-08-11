package com.exigen.ren.rest.dxp.model.claim.claimsEmployerModels.claimsTermLifeEmployerModels;

import com.exigen.ren.rest.dxp.model.claim.claimsEmployerModels.ClaimsEmployerIncidentAbstractModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PremiumWaiverIncidentModel extends ClaimsEmployerIncidentAbstractModel {
    private String rtwDate;

    public String getRtwDate() {
        return rtwDate;
    }

    public void setRtwDate(String rtwDate) {
        this.rtwDate = rtwDate;
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
        PremiumWaiverIncidentModel that = (PremiumWaiverIncidentModel) o;
        return Objects.equals(rtwDate, that.rtwDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rtwDate);
    }
}
