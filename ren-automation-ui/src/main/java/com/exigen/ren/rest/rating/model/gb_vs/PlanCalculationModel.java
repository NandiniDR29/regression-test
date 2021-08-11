package com.exigen.ren.rest.rating.model.gb_vs;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlanCalculationModel extends Model {

    private String planName;
    private List<TierRateModel> tierRates;
    private String currentParticipationPct;
    private String quotedParticipationPct;
    private String currentCompositeRate;
    private String renewalCompositeRate;
    private String finalCompositeRate;
    private String proposedCompositeRate;
    private String currentAnnualPremium;
    private String renewalAnnualPremium;
    private String finalAnnualPremium;
    private String proposedAnnualPremium;
    private String pctRenewalFromCurrent;
    private String pctFinalFromCurrent;
    private String pctFinalFromRenewal;
    private String pctProposedFromCurrent;
    private String pctProposedFromRenewal;
    private String amtProposedFromCurrent;
    private String amtProposedFromRenewal;
    private String experienceAdjustmentPct;
    private String experienceAdjustmentFactor;
    private String exceptionAmt;
    private List<EnrollmentByStateModel> enrollmentByState;
    private String areaFactor;
    private String trend;
    private String experienceRate;
    private String manualCompositeRate;
    private FactorsModel factors;
    private String totalEnrollment;
    private String neededPremium;
    private String tlr;
    private String manualClaimCost;
    private String manualClaimPepm;
    private String assumedParticipation;
    private List<ClassCalculationModel> classCalculation;

    public String getPlanName() {
        return planName;
    }

    public PlanCalculationModel setPlanName(String planName) {
        this.planName = planName;
        return this;
    }

    public List<TierRateModel> getTierRates() {
        return tierRates;
    }

    public PlanCalculationModel setTierRates(List<TierRateModel> tierRates) {
        this.tierRates = tierRates;
        return this;
    }

    public String getCurrentParticipationPct() {
        return currentParticipationPct;
    }

    public PlanCalculationModel setCurrentParticipationPct(String currentParticipationPct) {
        this.currentParticipationPct = currentParticipationPct;
        return this;
    }

    public String getQuotedParticipationPct() {
        return quotedParticipationPct;
    }

    public PlanCalculationModel setQuotedParticipationPct(String quotedParticipationPct) {
        this.quotedParticipationPct = quotedParticipationPct;
        return this;
    }

    public String getCurrentCompositeRate() {
        return currentCompositeRate;
    }

    public PlanCalculationModel setCurrentCompositeRate(String currentCompositeRate) {
        this.currentCompositeRate = currentCompositeRate;
        return this;
    }

    public String getRenewalCompositeRate() {
        return renewalCompositeRate;
    }

    public PlanCalculationModel setRenewalCompositeRate(String renewalCompositeRate) {
        this.renewalCompositeRate = renewalCompositeRate;
        return this;
    }

    public String getFinalCompositeRate() {
        return finalCompositeRate;
    }

    public PlanCalculationModel setFinalCompositeRate(String finalCompositeRate) {
        this.finalCompositeRate = finalCompositeRate;
        return this;
    }

    public String getProposedCompositeRate() {
        return proposedCompositeRate;
    }

    public PlanCalculationModel setProposedCompositeRate(String proposedCompositeRate) {
        this.proposedCompositeRate = proposedCompositeRate;
        return this;
    }

    public String getCurrentAnnualPremium() {
        return currentAnnualPremium;
    }

    public PlanCalculationModel setCurrentAnnualPremium(String currentAnnualPremium) {
        this.currentAnnualPremium = currentAnnualPremium;
        return this;
    }

    public String getRenewalAnnualPremium() {
        return renewalAnnualPremium;
    }

    public PlanCalculationModel setRenewalAnnualPremium(String renewalAnnualPremium) {
        this.renewalAnnualPremium = renewalAnnualPremium;
        return this;
    }

    public String getFinalAnnualPremium() {
        return finalAnnualPremium;
    }

    public PlanCalculationModel setFinalAnnualPremium(String finalAnnualPremium) {
        this.finalAnnualPremium = finalAnnualPremium;
        return this;
    }

    public String getProposedAnnualPremium() {
        return proposedAnnualPremium;
    }

    public PlanCalculationModel setProposedAnnualPremium(String proposedAnnualPremium) {
        this.proposedAnnualPremium = proposedAnnualPremium;
        return this;
    }

    public String getPctRenewalFromCurrent() {
        return pctRenewalFromCurrent;
    }

    public PlanCalculationModel setPctRenewalFromCurrent(String pctRenewalFromCurrent) {
        this.pctRenewalFromCurrent = pctRenewalFromCurrent;
        return this;
    }

    public String getPctFinalFromCurrent() {
        return pctFinalFromCurrent;
    }

    public PlanCalculationModel setPctFinalFromCurrent(String pctFinalFromCurrent) {
        this.pctFinalFromCurrent = pctFinalFromCurrent;
        return this;
    }

    public String getPctFinalFromRenewal() {
        return pctFinalFromRenewal;
    }

    public PlanCalculationModel setPctFinalFromRenewal(String pctFinalFromRenewal) {
        this.pctFinalFromRenewal = pctFinalFromRenewal;
        return this;
    }

    public String getPctProposedFromCurrent() {
        return pctProposedFromCurrent;
    }

    public PlanCalculationModel setPctProposedFromCurrent(String pctProposedFromCurrent) {
        this.pctProposedFromCurrent = pctProposedFromCurrent;
        return this;
    }

    public String getPctProposedFromRenewal() {
        return pctProposedFromRenewal;
    }

    public PlanCalculationModel setPctProposedFromRenewal(String pctProposedFromRenewal) {
        this.pctProposedFromRenewal = pctProposedFromRenewal;
        return this;
    }

    public String getAmtProposedFromCurrent() {
        return amtProposedFromCurrent;
    }

    public PlanCalculationModel setAmtProposedFromCurrent(String amtProposedFromCurrent) {
        this.amtProposedFromCurrent = amtProposedFromCurrent;
        return this;
    }

    public String getAmtProposedFromRenewal() {
        return amtProposedFromRenewal;
    }

    public PlanCalculationModel setAmtProposedFromRenewal(String amtProposedFromRenewal) {
        this.amtProposedFromRenewal = amtProposedFromRenewal;
        return this;
    }

    public String getExperienceAdjustmentPct() {
        return experienceAdjustmentPct;
    }

    public PlanCalculationModel setExperienceAdjustmentPct(String experienceAdjustmentPct) {
        this.experienceAdjustmentPct = experienceAdjustmentPct;
        return this;
    }

    public String getExperienceAdjustmentFactor() {
        return experienceAdjustmentFactor;
    }

    public PlanCalculationModel setExperienceAdjustmentFactor(String experienceAdjustmentFactor) {
        this.experienceAdjustmentFactor = experienceAdjustmentFactor;
        return this;
    }

    public String getExceptionAmt() {
        return exceptionAmt;
    }

    public PlanCalculationModel setExceptionAmt(String exceptionAmt) {
        this.exceptionAmt = exceptionAmt;
        return this;
    }

    public List<EnrollmentByStateModel> getEnrollmentByState() {
        return enrollmentByState;
    }

    public PlanCalculationModel setEnrollmentByState(List<EnrollmentByStateModel> enrollmentByState) {
        this.enrollmentByState = enrollmentByState;
        return this;
    }

    public String getAreaFactor() {
        return areaFactor;
    }

    public PlanCalculationModel setAreaFactor(String areaFactor) {
        this.areaFactor = areaFactor;
        return this;
    }

    public String getTrend() {
        return trend;
    }

    public PlanCalculationModel setTrend(String trend) {
        this.trend = trend;
        return this;
    }

    public String getExperienceRate() {
        return experienceRate;
    }

    public PlanCalculationModel setExperienceRate(String experienceRate) {
        this.experienceRate = experienceRate;
        return this;
    }

    public String getManualCompositeRate() {
        return manualCompositeRate;
    }

    public PlanCalculationModel setManualCompositeRate(String manualCompositeRate) {
        this.manualCompositeRate = manualCompositeRate;
        return this;
    }

    public FactorsModel getFactors() {
        return factors;
    }

    public PlanCalculationModel setFactors(FactorsModel factors) {
        this.factors = factors;
        return this;
    }

    public String getTotalEnrollment() {
        return totalEnrollment;
    }

    public PlanCalculationModel setTotalEnrollment(String totalEnrollment) {
        this.totalEnrollment = totalEnrollment;
        return this;
    }

    public String getNeededPremium() {
        return neededPremium;
    }

    public PlanCalculationModel setNeededPremium(String neededPremium) {
        this.neededPremium = neededPremium;
        return this;
    }

    public String getTlr() {
        return tlr;
    }

    public PlanCalculationModel setTlr(String tlr) {
        this.tlr = tlr;
        return this;
    }

    public String getManualClaimCost() {
        return manualClaimCost;
    }

    public PlanCalculationModel setManualClaimCost(String manualClaimCost) {
        this.manualClaimCost = manualClaimCost;
        return this;
    }

    public String getManualClaimPepm() {
        return manualClaimPepm;
    }

    public PlanCalculationModel setManualClaimPepm(String manualClaimPepm) {
        this.manualClaimPepm = manualClaimPepm;
        return this;
    }

    public String getAssumedParticipation() {
        return assumedParticipation;
    }

    public PlanCalculationModel setAssumedParticipation(String assumedParticipation) {
        this.assumedParticipation = assumedParticipation;
        return this;
    }

    public List<ClassCalculationModel> getClassCalculation() {
        return classCalculation;
    }

    public PlanCalculationModel setClassCalculation(List<ClassCalculationModel> classCalculation) {
        this.classCalculation = classCalculation;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PlanCalculationModel)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        PlanCalculationModel that = (PlanCalculationModel) o;
        return Objects.equals(planName, that.planName) &&
                Objects.equals(tierRates, that.tierRates) &&
                Objects.equals(currentParticipationPct, that.currentParticipationPct) &&
                Objects.equals(quotedParticipationPct, that.quotedParticipationPct) &&
                Objects.equals(currentCompositeRate, that.currentCompositeRate) &&
                Objects.equals(renewalCompositeRate, that.renewalCompositeRate) &&
                Objects.equals(finalCompositeRate, that.finalCompositeRate) &&
                Objects.equals(proposedCompositeRate, that.proposedCompositeRate) &&
                Objects.equals(currentAnnualPremium, that.currentAnnualPremium) &&
                Objects.equals(renewalAnnualPremium, that.renewalAnnualPremium) &&
                Objects.equals(finalAnnualPremium, that.finalAnnualPremium) &&
                Objects.equals(proposedAnnualPremium, that.proposedAnnualPremium) &&
                Objects.equals(pctRenewalFromCurrent, that.pctRenewalFromCurrent) &&
                Objects.equals(pctFinalFromCurrent, that.pctFinalFromCurrent) &&
                Objects.equals(pctFinalFromRenewal, that.pctFinalFromRenewal) &&
                Objects.equals(pctProposedFromCurrent, that.pctProposedFromCurrent) &&
                Objects.equals(pctProposedFromRenewal, that.pctProposedFromRenewal) &&
                Objects.equals(amtProposedFromCurrent, that.amtProposedFromCurrent) &&
                Objects.equals(amtProposedFromRenewal, that.amtProposedFromRenewal) &&
                Objects.equals(experienceAdjustmentPct, that.experienceAdjustmentPct) &&
                Objects.equals(experienceAdjustmentFactor, that.experienceAdjustmentFactor) &&
                Objects.equals(exceptionAmt, that.exceptionAmt) &&
                Objects.equals(enrollmentByState, that.enrollmentByState) &&
                Objects.equals(areaFactor, that.areaFactor) &&
                Objects.equals(trend, that.trend) &&
                Objects.equals(experienceRate, that.experienceRate) &&
                Objects.equals(manualCompositeRate, that.manualCompositeRate) &&
                Objects.equals(factors, that.factors) &&
                Objects.equals(totalEnrollment, that.totalEnrollment) &&
                Objects.equals(neededPremium, that.neededPremium) &&
                Objects.equals(tlr, that.tlr) &&
                Objects.equals(manualClaimCost, that.manualClaimCost) &&
                Objects.equals(manualClaimPepm, that.manualClaimPepm) &&
                Objects.equals(assumedParticipation, that.assumedParticipation) &&
                Objects.equals(classCalculation, that.classCalculation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), planName, tierRates, currentParticipationPct, quotedParticipationPct, currentCompositeRate, renewalCompositeRate, finalCompositeRate, proposedCompositeRate, currentAnnualPremium, renewalAnnualPremium, finalAnnualPremium, proposedAnnualPremium, pctRenewalFromCurrent, pctFinalFromCurrent, pctFinalFromRenewal, pctProposedFromCurrent, pctProposedFromRenewal, amtProposedFromCurrent, amtProposedFromRenewal, experienceAdjustmentPct, experienceAdjustmentFactor, exceptionAmt, enrollmentByState, areaFactor, trend, experienceRate, manualCompositeRate, factors, totalEnrollment, neededPremium, tlr, manualClaimCost, manualClaimPepm, assumedParticipation, classCalculation);
    }

    @Override
    public String toString() {
        return "PlanCalculationModel{" +
                "planName='" + planName + '\'' +
                ", tierRates=" + tierRates +
                ", currentParticipationPct='" + currentParticipationPct + '\'' +
                ", quotedParticipationPct='" + quotedParticipationPct + '\'' +
                ", currentCompositeRate='" + currentCompositeRate + '\'' +
                ", renewalCompositeRate='" + renewalCompositeRate + '\'' +
                ", finalCompositeRate='" + finalCompositeRate + '\'' +
                ", proposedCompositeRate='" + proposedCompositeRate + '\'' +
                ", currentAnnualPremium='" + currentAnnualPremium + '\'' +
                ", renewalAnnualPremium='" + renewalAnnualPremium + '\'' +
                ", finalAnnualPremium='" + finalAnnualPremium + '\'' +
                ", proposedAnnualPremium='" + proposedAnnualPremium + '\'' +
                ", pctRenewalFromCurrent='" + pctRenewalFromCurrent + '\'' +
                ", pctFinalFromCurrent='" + pctFinalFromCurrent + '\'' +
                ", pctFinalFromRenewal='" + pctFinalFromRenewal + '\'' +
                ", pctProposedFromCurrent='" + pctProposedFromCurrent + '\'' +
                ", pctProposedFromRenewal='" + pctProposedFromRenewal + '\'' +
                ", amtProposedFromCurrent='" + amtProposedFromCurrent + '\'' +
                ", amtProposedFromRenewal='" + amtProposedFromRenewal + '\'' +
                ", experienceAdjustmentPct='" + experienceAdjustmentPct + '\'' +
                ", experienceAdjustmentFactor='" + experienceAdjustmentFactor + '\'' +
                ", exceptionAmt='" + exceptionAmt + '\'' +
                ", enrollmentByState=" + enrollmentByState +
                ", areaFactor='" + areaFactor + '\'' +
                ", trend='" + trend + '\'' +
                ", experienceRate='" + experienceRate + '\'' +
                ", manualCompositeRate='" + manualCompositeRate + '\'' +
                ", factors=" + factors +
                ", totalEnrollment='" + totalEnrollment + '\'' +
                ", neededPremium='" + neededPremium + '\'' +
                ", tlr='" + tlr + '\'' +
                ", manualClaimCost='" + manualClaimCost + '\'' +
                ", manualClaimPepm='" + manualClaimPepm + '\'' +
                ", assumedParticipation='" + assumedParticipation + '\'' +
                ", classCalculation=" + classCalculation +
                '}';
    }
}
