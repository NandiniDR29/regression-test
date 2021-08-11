package com.exigen.ren.rest.claim.model.dental.claiminfo;

import com.exigen.ren.rest.model.RestError;

import java.util.List;

public class ClaimInfoPatientModel extends RestError {

    private String patientID;
    private List<ClaimInfoPatientHistoryProceduresModel> historyProcedures;
    private List<ClaimInfoPatientAccumulatorsModel> accumulators;
    private String dateOfBirth;
    private String isOtherPatient;
    private String isSpecialReviewExist;

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public List<ClaimInfoPatientHistoryProceduresModel> getHistoryProcedures() {
        return historyProcedures;
    }

    public void setHistoryProcedures(List<ClaimInfoPatientHistoryProceduresModel> historyProcedures) {
        this.historyProcedures = historyProcedures;
    }

    public List<ClaimInfoPatientAccumulatorsModel> getAccumulators() {
        return accumulators;
    }

    public void setAccumulators(List<ClaimInfoPatientAccumulatorsModel> accumulators) {
        this.accumulators = accumulators;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIsOtherPatient() {
        return isOtherPatient;
    }

    public void setIsOtherPatient(String isOtherPatient) {
        this.isOtherPatient = isOtherPatient;
    }

    public String getIsSpecialReviewExist() {
        return isSpecialReviewExist;
    }

    public void setIsSpecialReviewExist(String isSpecialReviewExist) {
        this.isSpecialReviewExist = isSpecialReviewExist;
    }
}