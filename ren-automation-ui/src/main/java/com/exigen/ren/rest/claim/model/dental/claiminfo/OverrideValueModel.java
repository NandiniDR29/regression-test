package com.exigen.ren.rest.claim.model.dental.claiminfo;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.List;

public class OverrideValueModel extends Model {

    private String procedureCd;
    private String covered;
    private String deductible;
    private String coinsurancePercentage;
    private String patientResponsibility;
    private String appliedCOB;
    private List<String> iRCode;

    public String getProcedureCd() {
        return procedureCd;
    }

    public void setProcedureCd(String procedureCd) {
        this.procedureCd = procedureCd;
    }

    public String getCovered() {
        return covered;
    }

    public void setCovered(String covered) {
        this.covered = covered;
    }

    public String getDeductible() {
        return deductible;
    }

    public void setDeductible(String deductible) {
        this.deductible = deductible;
    }

    public String getCoinsurancePercentage() {
        return coinsurancePercentage;
    }

    public void setCoinsurancePercentage(String coinsurancePercentage) {
        this.coinsurancePercentage = coinsurancePercentage;
    }

    public String getPatientResponsibility() {
        return patientResponsibility;
    }

    public void setPatientResponsibility(String patientResponsibility) {
        this.patientResponsibility = patientResponsibility;
    }

    public String getAppliedCOB() {
        return appliedCOB;
    }

    public void setAppliedCOB(String appliedCOB) {
        this.appliedCOB = appliedCOB;
    }

    public List<String> getiRCode() {
        return iRCode;
    }

    public void setiRCode(List<String> iRCode) {
        this.iRCode = iRCode;
    }
}