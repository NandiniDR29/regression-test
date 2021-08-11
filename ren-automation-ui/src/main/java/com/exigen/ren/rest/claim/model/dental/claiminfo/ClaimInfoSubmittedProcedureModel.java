package com.exigen.ren.rest.claim.model.dental.claiminfo;

import com.exigen.ren.rest.model.RestError;

import java.util.List;
import java.util.Objects;

public class ClaimInfoSubmittedProcedureModel extends RestError {
    private String procedureID;
    private String procedureCode;
    private String predetInd;
    private List<String> toothArea;
    private List<String> surfaces;
    private String areaOfOralCavity;
    private String quantity;
    private String submittedFee;
    private ClaimInfoSubmittedProcedurePolicyInfoModel policyInfo;
    private DentistModel dentist;
    private CalculationResultModel calculationResult;
    private OverrideValueModel overrideValue;
    private OverrideLineRuleModel overrideLineRule;
    private String dateOfService;
    private List<FeeRateModel> feeSchedule;
    private List<FeeRateModel> feeUCR;

    public String getProcedureID() {
        return procedureID;
    }

    public void setProcedureID(String procedureID) {
        this.procedureID = procedureID;
    }

    public String getProcedureCode() {
        return procedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        this.procedureCode = procedureCode;
    }

    public String getPredetInd() {
        return predetInd;
    }

    public void setPredetInd(String predetInd) {
        this.predetInd = predetInd;
    }

    public List<String> getToothArea() {
        return toothArea;
    }

    public void setToothArea(List<String> toothArea) {
        this.toothArea = toothArea;
    }

    public List<String> getSurfaces() {
        return surfaces;
    }

    public void setSurfaces(List<String> surfaces) {
        this.surfaces = surfaces;
    }

    public String getAreaOfOralCavity() {
        return areaOfOralCavity;
    }

    public void setAreaOfOralCavity(String areaOfOralCavity) {
        this.areaOfOralCavity = areaOfOralCavity;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSubmittedFee() {
        return submittedFee;
    }

    public void setSubmittedFee(String submittedFee) {
        this.submittedFee = submittedFee;
    }

    public ClaimInfoSubmittedProcedurePolicyInfoModel getPolicyInfo() {
        return policyInfo;
    }

    public void setPolicyInfo(ClaimInfoSubmittedProcedurePolicyInfoModel policyInfo) {
        this.policyInfo = policyInfo;
    }

    public DentistModel getDentist() {
        return dentist;
    }

    public void setDentist(DentistModel dentist) {
        this.dentist = dentist;
    }

    public CalculationResultModel getCalculationResult() {
        return calculationResult;
    }

    public void setCalculationResult(CalculationResultModel calculationResult) {
        this.calculationResult = calculationResult;
    }

    public OverrideValueModel getOverrideValue() {
        return overrideValue;
    }

    public void setOverrideValue(OverrideValueModel overrideValue) {
        this.overrideValue = overrideValue;
    }

    public OverrideLineRuleModel getOverrideLineRule() {
        return overrideLineRule;
    }

    public void setOverrideLineRule(OverrideLineRuleModel overrideLineRule) {
        this.overrideLineRule = overrideLineRule;
    }

    public String getDateOfService() {
        return dateOfService;
    }

    public void setDateOfService(String dateOfService) {
        this.dateOfService = dateOfService;
    }

    public List<FeeRateModel> getFeeSchedule() {
        return feeSchedule;
    }

    public void setFeeSchedule(List<FeeRateModel> feeSchedule) {
        this.feeSchedule = feeSchedule;
    }

    public List<FeeRateModel> getFeeUCR() {
        return feeUCR;
    }

    public void setFeeUCR(List<FeeRateModel> feeUCR) {
        this.feeUCR = feeUCR;
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
        ClaimInfoSubmittedProcedureModel that = (ClaimInfoSubmittedProcedureModel) o;
        return predetInd == that.predetInd &&
                Objects.equals(procedureID, that.procedureID) &&
                Objects.equals(procedureCode, that.procedureCode) &&
                Objects.equals(toothArea, that.toothArea) &&
                Objects.equals(surfaces, that.surfaces) &&
                Objects.equals(areaOfOralCavity, that.areaOfOralCavity) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(submittedFee, that.submittedFee) &&
                Objects.equals(policyInfo, that.policyInfo) &&
                Objects.equals(dentist, that.dentist) &&
                Objects.equals(calculationResult, that.calculationResult) &&
                Objects.equals(overrideValue, that.overrideValue) &&
                Objects.equals(overrideLineRule, that.overrideLineRule) &&
                Objects.equals(dateOfService, that.dateOfService) &&
                Objects.equals(feeSchedule, that.feeSchedule) &&
                Objects.equals(feeUCR, that.feeUCR);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), procedureID, procedureCode, predetInd, toothArea, surfaces, areaOfOralCavity, quantity, submittedFee, policyInfo, dentist, calculationResult, overrideValue, overrideLineRule, dateOfService, feeSchedule, feeUCR);
    }

}
