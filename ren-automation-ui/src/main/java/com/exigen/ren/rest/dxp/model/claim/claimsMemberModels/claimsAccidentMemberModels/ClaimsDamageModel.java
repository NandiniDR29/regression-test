package com.exigen.ren.rest.dxp.model.claim.claimsMemberModels.claimsAccidentMemberModels;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClaimsDamageModel extends RestError {
    private CriticalIllnessModel criticalIllness;
    private PremiumWaiverModel premiumWaiver;
    private AccidentalInjuryModel accidentalInjury;
    private AccidentalDismembermentModel accidentalDismemberment;
    private AccidentalDeathModel accidentalDeath;

    public CriticalIllnessModel getCriticalIllness() {
        return criticalIllness;
    }

    public void setCriticalIllness(CriticalIllnessModel criticalIllness) {
        this.criticalIllness = criticalIllness;
    }

    public PremiumWaiverModel getPremiumWaiver() {
        return premiumWaiver;
    }

    public void setPremiumWaiver(PremiumWaiverModel premiumWaiver) {
        this.premiumWaiver = premiumWaiver;
    }

    public AccidentalInjuryModel getAccidentalInjury() {
        return accidentalInjury;
    }

    public void setAccidentalInjury(AccidentalInjuryModel accidentalInjury) {
        this.accidentalInjury = accidentalInjury;
    }

    public AccidentalDismembermentModel getAccidentalDismemberment() {
        return accidentalDismemberment;
    }

    public void setAccidentalDismemberment(AccidentalDismembermentModel accidentalDismemberment) {
        this.accidentalDismemberment = accidentalDismemberment;
    }

    public AccidentalDeathModel getAccidentalDeath() {
        return accidentalDeath;
    }

    public void setAccidentalDeath(AccidentalDeathModel accidentalDeath) {
        this.accidentalDeath = accidentalDeath;
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
        ClaimsDamageModel that = (ClaimsDamageModel) o;
        return Objects.equals(criticalIllness, that.criticalIllness) &&
                Objects.equals(premiumWaiver, that.premiumWaiver) &&
                Objects.equals(accidentalInjury, that.accidentalInjury) &&
                Objects.equals(accidentalDismemberment, that.accidentalDismemberment) &&
                Objects.equals(accidentalDeath, that.accidentalDeath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), criticalIllness, premiumWaiver, accidentalInjury, accidentalDismemberment, accidentalDeath);
    }
}