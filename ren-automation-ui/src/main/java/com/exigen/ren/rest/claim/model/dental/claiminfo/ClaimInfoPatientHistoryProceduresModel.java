package com.exigen.ren.rest.claim.model.dental.claiminfo;

import com.exigen.ren.rest.model.RestError;

import java.util.List;

public class ClaimInfoPatientHistoryProceduresModel extends RestError {

    private String procedureID;
    private String procedureCode;
    private String procedureStatus;
    private String areaOfOralCavity;
    private List<String> toothArea;
    private List<String> surfaces;
    private ClaimInfoPatientHistoryProceduresDentistModel dentist;
    private ClaimInfoPatientHistoryProceduresStatusModel status;

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

    public String getProcedureStatus() {
        return procedureStatus;
    }

    public void setProcedureStatus(String procedureStatus) {
        this.procedureStatus = procedureStatus;
    }

    public String getAreaOfOralCavity() {
        return areaOfOralCavity;
    }

    public void setAreaOfOralCavity(String areaOfOralCavity) {
        this.areaOfOralCavity = areaOfOralCavity;
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

    public ClaimInfoPatientHistoryProceduresDentistModel getDentist() {
        return dentist;
    }

    public void setDentist(ClaimInfoPatientHistoryProceduresDentistModel dentist) {
        this.dentist = dentist;
    }

    public ClaimInfoPatientHistoryProceduresStatusModel getStatus() {
        return status;
    }

    public void setStatus(ClaimInfoPatientHistoryProceduresStatusModel status) {
        this.status = status;
    }

}