package com.exigen.ren.rest.dxp.model.claim.claimsMemberModels.claimsDentalMemberModels;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClaimsProcedureModel extends RestError {
    private String quantity;
    private String procedureDate;
    private String associatedRiskParty;
    private String toothLetter;
    private String oralCavityArea;
    private String reportedFee;
    private String toothSurface;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getProcedureDate() {
        return procedureDate;
    }

    public void setProcedureDate(String procedureDate) {
        this.procedureDate = procedureDate;
    }

    public String getAssociatedRiskParty() {
        return associatedRiskParty;
    }

    public void setAssociatedRiskParty(String associatedRiskParty) {
        this.associatedRiskParty = associatedRiskParty;
    }

    public String getToothLetter() {
        return toothLetter;
    }

    public void setToothLetter(String toothLetter) {
        this.toothLetter = toothLetter;
    }

    public String getOralCavityArea() {
        return oralCavityArea;
    }

    public void setOralCavityArea(String oralCavityArea) {
        this.oralCavityArea = oralCavityArea;
    }

    public String getReportedFee() {
        return reportedFee;
    }

    public void setReportedFee(String reportedFee) {
        this.reportedFee = reportedFee;
    }

    public String getToothSurface() {
        return toothSurface;
    }

    public void setToothSurface(String toothSurface) {
        this.toothSurface = toothSurface;
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
        ClaimsProcedureModel that = (ClaimsProcedureModel) o;
        return Objects.equals(quantity, that.quantity) &&
                Objects.equals(procedureDate, that.procedureDate) &&
                Objects.equals(associatedRiskParty, that.associatedRiskParty) &&
                Objects.equals(toothLetter, that.toothLetter) &&
                Objects.equals(oralCavityArea, that.oralCavityArea) &&
                Objects.equals(reportedFee, that.reportedFee) &&
                Objects.equals(toothSurface, that.toothSurface);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quantity, procedureDate, associatedRiskParty, toothLetter, oralCavityArea, reportedFee, toothSurface);
    }
}
