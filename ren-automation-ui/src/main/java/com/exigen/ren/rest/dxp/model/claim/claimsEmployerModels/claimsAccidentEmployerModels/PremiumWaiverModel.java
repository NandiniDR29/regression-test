package com.exigen.ren.rest.dxp.model.claim.claimsEmployerModels.claimsAccidentEmployerModels;

import com.exigen.ren.rest.model.RestError;

import java.util.Objects;

public class PremiumWaiverModel extends RestError {
    private PremiumWaiverIncidentModel premiumWaiverIncident;

    public PremiumWaiverIncidentModel getPremiumWaiverIncident() {
        return premiumWaiverIncident;
    }

    public void setPremiumWaiverIncident(PremiumWaiverIncidentModel premiumWaiverIncident) {
        this.premiumWaiverIncident = premiumWaiverIncident;
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
        PremiumWaiverModel that = (PremiumWaiverModel) o;
        return Objects.equals(premiumWaiverIncident, that.premiumWaiverIncident);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), premiumWaiverIncident);
    }
}
