package com.exigen.ren.rest.claim.model.dental.claiminfo;

import com.exigen.ren.rest.model.RestError;

import java.util.List;

public class ClaimInfoModel extends RestError {
    private String claimID;
    private ClaimInfoPatientModel patient;
    private List<ClaimInfoSubmittedProcedureModel> submittedProcedures;
    private String isReportAttached;
    private String orthoMonths;
    private String claimSource;
    private String claimReceivedDate;
    private String cleanClaimDate;
    private String otherCarrierAmount;
    private String claimsPolicyStatus;
    private String transactionType;

    public String getClaimID() {
        return claimID;
    }

    public void setClaimID(String claimID) {
        this.claimID = claimID;
    }

    public ClaimInfoPatientModel getPatient() {
        return patient;
    }

    public void setPatient(ClaimInfoPatientModel patient) {
        this.patient = patient;
    }

    public List<ClaimInfoSubmittedProcedureModel> getSubmittedProcedures() {
        return submittedProcedures;
    }

    public void setSubmittedProcedures(List<ClaimInfoSubmittedProcedureModel> submittedProcedures) {
        this.submittedProcedures = submittedProcedures;
    }

    public String getIsReportAttached() {
        return isReportAttached;
    }

    public void setIsReportAttached(String isReportAttached) {
        this.isReportAttached = isReportAttached;
    }

    public String getOrthoMonths() {
        return orthoMonths;
    }

    public void setOrthoMonths(String orthoMonths) {
        this.orthoMonths = orthoMonths;
    }

    public String getClaimSource() {
        return claimSource;
    }

    public void setClaimSource(String claimSource) {
        this.claimSource = claimSource;
    }

    public String getClaimReceivedDate() {
        return claimReceivedDate;
    }

    public void setClaimReceivedDate(String claimReceivedDate) {
        this.claimReceivedDate = claimReceivedDate;
    }

    public String getCleanClaimDate() {
        return cleanClaimDate;
    }

    public void setCleanClaimDate(String cleanClaimDate) {
        this.cleanClaimDate = cleanClaimDate;
    }

    public String getOtherCarrierAmount() {
        return otherCarrierAmount;
    }

    public void setOtherCarrierAmount(String otherCarrierAmount) {
        this.otherCarrierAmount = otherCarrierAmount;
    }

    public String getClaimsPolicyStatus() {
        return claimsPolicyStatus;
    }

    public void setClaimsPolicyStatus(String claimsPolicyStatus) {
        this.claimsPolicyStatus = claimsPolicyStatus;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

}