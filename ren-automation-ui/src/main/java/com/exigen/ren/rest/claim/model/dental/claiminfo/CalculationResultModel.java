package com.exigen.ren.rest.claim.model.dental.claiminfo;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.Objects;

public class CalculationResultModel extends Model {
    private String procedureID;
    private String submittedCode;
    private String coveredCode;
    private String procedureType;
    private String charge;
    private String consideredFee;
    private String coveredFee;
    private String payableDeductible;
    private String coinsurancePercentage;
    private String coinsuranceAmt;
    private String netBenefitAmount;
    private String patientResponsibility;
    private String allowedFee;
    private String copay;
    private String contributionToMOOP;
    private String planToPay;
    private String featureNumber;
    private String cobApplied;
    private String feeScheduleName;
    private String netWorkName;
    private String inOutNetwork;
    private String feeMax;
    private String dentistAdjustment;

    public String getProcedureID() {
        return procedureID;
    }

    public void setProcedureID(String procedureID) {
        this.procedureID = procedureID;
    }

    public String getSubmittedCode() {
        return submittedCode;
    }

    public void setSubmittedCode(String submittedCode) {
        this.submittedCode = submittedCode;
    }

    public String getCoveredCode() {
        return coveredCode;
    }

    public void setCoveredCode(String coveredCode) {
        this.coveredCode = coveredCode;
    }

    public String getProcedureType() {
        return procedureType;
    }

    public void setProcedureType(String procedureType) {
        this.procedureType = procedureType;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getConsideredFee() {
        return consideredFee;
    }

    public void setConsideredFee(String consideredFee) {
        this.consideredFee = consideredFee;
    }

    public String getCoveredFee() {
        return coveredFee;
    }

    public void setCoveredFee(String coveredFee) {
        this.coveredFee = coveredFee;
    }

    public String getPayableDeductible() {
        return payableDeductible;
    }

    public void setPayableDeductible(String payableDeductible) {
        this.payableDeductible = payableDeductible;
    }

    public String getCoinsurancePercentage() {
        return coinsurancePercentage;
    }

    public void setCoinsurancePercentage(String coinsurancePercentage) {
        this.coinsurancePercentage = coinsurancePercentage;
    }

    public String getCoinsuranceAmt() {
        return coinsuranceAmt;
    }

    public void setCoinsuranceAmt(String coinsuranceAmt) {
        this.coinsuranceAmt = coinsuranceAmt;
    }

    public String getNetBenefitAmount() {
        return netBenefitAmount;
    }

    public void setNetBenefitAmount(String netBenefitAmount) {
        this.netBenefitAmount = netBenefitAmount;
    }

    public String getPatientResponsibility() {
        return patientResponsibility;
    }

    public void setPatientResponsibility(String patientResponsibility) {
        this.patientResponsibility = patientResponsibility;
    }

    public String getAllowedFee() {
        return allowedFee;
    }

    public void setAllowedFee(String allowedFee) {
        this.allowedFee = allowedFee;
    }

    public String getCopay() {
        return copay;
    }

    public void setCopay(String copay) {
        this.copay = copay;
    }

    public String getContributionToMOOP() {
        return contributionToMOOP;
    }

    public void setContributionToMOOP(String contributionToMOOP) {
        this.contributionToMOOP = contributionToMOOP;
    }

    public String getPlanToPay() {
        return planToPay;
    }

    public void setPlanToPay(String planToPay) {
        this.planToPay = planToPay;
    }

    public String getFeatureNumber() {
        return featureNumber;
    }

    public void setFeatureNumber(String featureNumber) {
        this.featureNumber = featureNumber;
    }

    public String getCobApplied() {
        return cobApplied;
    }

    public void setCobApplied(String cobApplied) {
        this.cobApplied = cobApplied;
    }

    public String getFeeScheduleName() {
        return feeScheduleName;
    }

    public void setFeeScheduleName(String feeScheduleName) {
        this.feeScheduleName = feeScheduleName;
    }

    public String getNetWorkName() {
        return netWorkName;
    }

    public void setNetWorkName(String netWorkName) {
        this.netWorkName = netWorkName;
    }

    public String getInOutNetwork() {
        return inOutNetwork;
    }

    public void setInOutNetwork(String inOutNetwork) {
        this.inOutNetwork = inOutNetwork;
    }

    public String getFeeMax() {
        return feeMax;
    }

    public void setFeeMax(String feeMax) {
        this.feeMax = feeMax;
    }

    public String getDentistAdjustment() {
        return dentistAdjustment;
    }

    public void setDentistAdjustment(String dentistAdjustment) {
        this.dentistAdjustment = dentistAdjustment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CalculationResultModel that = (CalculationResultModel) o;
        return Objects.equals(procedureID, that.procedureID) &&
                Objects.equals(submittedCode, that.submittedCode) &&
                Objects.equals(coveredCode, that.coveredCode) &&
                Objects.equals(procedureType, that.procedureType) &&
                Objects.equals(charge, that.charge) &&
                Objects.equals(consideredFee, that.consideredFee) &&
                Objects.equals(coveredFee, that.coveredFee) &&
                Objects.equals(payableDeductible, that.payableDeductible) &&
                Objects.equals(coinsurancePercentage, that.coinsurancePercentage) &&
                Objects.equals(coinsuranceAmt, that.coinsuranceAmt) &&
                Objects.equals(netBenefitAmount, that.netBenefitAmount) &&
                Objects.equals(patientResponsibility, that.patientResponsibility) &&
                Objects.equals(allowedFee, that.allowedFee) &&
                Objects.equals(copay, that.copay) &&
                Objects.equals(contributionToMOOP, that.contributionToMOOP) &&
                Objects.equals(planToPay, that.planToPay) &&
                Objects.equals(featureNumber, that.featureNumber) &&
                Objects.equals(cobApplied, that.cobApplied) &&
                Objects.equals(feeScheduleName, that.feeScheduleName) &&
                Objects.equals(netWorkName, that.netWorkName) &&
                Objects.equals(inOutNetwork, that.inOutNetwork) &&
                Objects.equals(feeMax, that.feeMax) &&
                Objects.equals(dentistAdjustment, that.dentistAdjustment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), procedureID, submittedCode, coveredCode, procedureType, charge, consideredFee, coveredFee, payableDeductible, coinsurancePercentage, coinsuranceAmt, netBenefitAmount, patientResponsibility, allowedFee, copay, contributionToMOOP, planToPay, featureNumber, cobApplied, feeScheduleName, netWorkName, inOutNetwork, feeMax, dentistAdjustment);
    }
}


    