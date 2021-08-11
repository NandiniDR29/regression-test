package com.exigen.ren.rest.claim.model.dental.claiminfo;

import com.exigen.ren.rest.model.RestError;

import java.util.List;

public class ClaimInfoSubmittedProcedurePolicyInfoModel extends RestError {
    private String policyPaidToDate;
    private String policyPaidToDateWithGracePeriod;
    private String patientEffectiveDate;
    private List<ClaimInfoSubmittedProcedureParticipantsModel> participants;
    private List<ClaimInfoSubmittedProcedurePolicyInfoProcedureSubtypeFrequencyModel> procedureSubtypeFrequency;
    private List<ClaimInfoSubmittedProcedurePolicyInfoPlanLimitationsModel> planLimitations;
    private List<ClaimInfoSubmittedProcedurePolicyInfoAgeLimitValuesModel> ageLimitValues;
    private List<ClaimInfoSubmittedProcedurePolicyInfoWaitingPeriodValuesModel> waitingPeriodValues;
    private List<ClaimInfoSubmittedProcedurePolicyInfoServiceCategoriesValuesModel> serviceCategoriesValues;
    private List<ClaimInfoSubmittedProcedurePolicyInfoCoinsuranceValuesModel> coinsuranceValues;
    private List<ClaimInfoSubmittedProcedurePolicyInfoOrthoCoinsuranceValuesModel> orthoCoinsuranceValues;

    public String getPolicyPaidToDate() {
        return policyPaidToDate;
    }

    public void setPolicyPaidToDate(String policyPaidToDate) {
        this.policyPaidToDate = policyPaidToDate;
    }

    public String getPolicyPaidToDateWithGracePeriod() {
        return policyPaidToDateWithGracePeriod;
    }

    public void setPolicyPaidToDateWithGracePeriod(String policyPaidToDateWithGracePeriod) {
        this.policyPaidToDateWithGracePeriod = policyPaidToDateWithGracePeriod;
    }

    public List<ClaimInfoSubmittedProcedureParticipantsModel> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ClaimInfoSubmittedProcedureParticipantsModel> participants) {
        this.participants = participants;
    }

    public String getPatientEffectiveDate() {
        return patientEffectiveDate;
    }

    public void setPatientEffectiveDate(String patientEffectiveDate) {
        this.patientEffectiveDate = patientEffectiveDate;
    }

    public List<ClaimInfoSubmittedProcedurePolicyInfoProcedureSubtypeFrequencyModel> getProcedureSubtypeFrequency() {
        return procedureSubtypeFrequency;
    }

    public void setProcedureSubtypeFrequency(List<ClaimInfoSubmittedProcedurePolicyInfoProcedureSubtypeFrequencyModel> procedureSubtypeFrequency) {
        this.procedureSubtypeFrequency = procedureSubtypeFrequency;
    }

    public List<ClaimInfoSubmittedProcedurePolicyInfoPlanLimitationsModel> getPlanLimitations() {
        return planLimitations;
    }

    public void setPlanLimitations(List<ClaimInfoSubmittedProcedurePolicyInfoPlanLimitationsModel> planLimitations) {
        this.planLimitations = planLimitations;
    }

    public List<ClaimInfoSubmittedProcedurePolicyInfoAgeLimitValuesModel> getAgeLimitValues() {
        return ageLimitValues;
    }

    public void setAgeLimitValues(List<ClaimInfoSubmittedProcedurePolicyInfoAgeLimitValuesModel> ageLimitValues) {
        this.ageLimitValues = ageLimitValues;
    }

    public List<ClaimInfoSubmittedProcedurePolicyInfoWaitingPeriodValuesModel> getWaitingPeriodValues() {
        return waitingPeriodValues;
    }

    public void setWaitingPeriodValues(List<ClaimInfoSubmittedProcedurePolicyInfoWaitingPeriodValuesModel> waitingPeriodValues) {
        this.waitingPeriodValues = waitingPeriodValues;
    }

    public List<ClaimInfoSubmittedProcedurePolicyInfoServiceCategoriesValuesModel> getServiceCategoriesValues() {
        return serviceCategoriesValues;
    }

    public void setServiceCategoriesValues(List<ClaimInfoSubmittedProcedurePolicyInfoServiceCategoriesValuesModel> serviceCategoriesValues) {
        this.serviceCategoriesValues = serviceCategoriesValues;
    }

    public List<ClaimInfoSubmittedProcedurePolicyInfoCoinsuranceValuesModel> getCoinsuranceValues() {
        return coinsuranceValues;
    }

    public void setCoinsuranceValues(List<ClaimInfoSubmittedProcedurePolicyInfoCoinsuranceValuesModel> coinsuranceValues) {
        this.coinsuranceValues = coinsuranceValues;
    }

    public List<ClaimInfoSubmittedProcedurePolicyInfoOrthoCoinsuranceValuesModel> getOrthoCoinsuranceValues() {
        return orthoCoinsuranceValues;
    }

    public void setOrthoCoinsuranceValues(List<ClaimInfoSubmittedProcedurePolicyInfoOrthoCoinsuranceValuesModel> orthoCoinsuranceValues) {
        this.orthoCoinsuranceValues = orthoCoinsuranceValues;
    }

}