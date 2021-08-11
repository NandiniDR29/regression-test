package com.exigen.ren.rest.dxp.model.claim.claimsMemberModels.claimsDisabilityMemberModels;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShortTermDisabilityIncidentModel extends RestError {
    private List<ShortTermDisabilityDateModel> shortTermDisabilityDates;

    public List<ShortTermDisabilityDateModel> getShortTermDisabilityDates() {
        return shortTermDisabilityDates;
    }

    public void setShortTermDisabilityDates(List<ShortTermDisabilityDateModel> shortTermDisabilityDates) {
        this.shortTermDisabilityDates = shortTermDisabilityDates;
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
        ShortTermDisabilityIncidentModel that = (ShortTermDisabilityIncidentModel) o;
        return Objects.equals(shortTermDisabilityDates, that.shortTermDisabilityDates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shortTermDisabilityDates);
    }
}
