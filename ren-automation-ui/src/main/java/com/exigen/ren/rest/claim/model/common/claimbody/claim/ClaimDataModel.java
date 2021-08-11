package com.exigen.ren.rest.claim.model.common.claimbody.claim;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.Objects;

public class ClaimDataModel extends Model {
    private String payeeType;
    private String cleanClaimDate;
    private String receivedDate;
    private String source;
    private String orthoMonths;
    private String transmissionId;
    private String predeterminationNumber;
    private String clearingHouseId;
    private String otherCoverageInd;
    private ClaimCoordinationOfBenefitsModel coordinationOfBenefits;
    private String transactionType;

    public String getPayeeType() {
        return payeeType;
    }

    public void setPayeeType(String payeeType) {
        this.payeeType = payeeType;
    }

    public String getCleanClaimDate() {
        return cleanClaimDate;
    }

    public void setCleanClaimDate(String cleanClaimDate) {
        this.cleanClaimDate = cleanClaimDate;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getOrthoMonths() {
        return orthoMonths;
    }

    public void setOrthoMonths(String orthoMonths) {
        this.orthoMonths = orthoMonths;
    }

    public String getOtherCoverageInd() {
        return otherCoverageInd;
    }

    public void setOtherCoverageInd(String otherCoverageInd) {
        this.otherCoverageInd = otherCoverageInd;
    }

    public ClaimCoordinationOfBenefitsModel getCoordinationOfBenefits() {
        return coordinationOfBenefits;
    }

    public void setCoordinationOfBenefits(ClaimCoordinationOfBenefitsModel coordinationOfBenefits) {
        this.coordinationOfBenefits = coordinationOfBenefits;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransmissionId() {
        return transmissionId;
    }

    public void setTransmissionId(String transmissionId) {
        this.transmissionId = transmissionId;
    }

    public String getPredeterminationNumber() {
        return predeterminationNumber;
    }

    public void setPredeterminationNumber(String predeterminationNumber) {
        this.predeterminationNumber = predeterminationNumber;
    }

    public String getClearingHouseId() {
        return clearingHouseId;
    }

    public void setClearingHouseId(String clearingHouseId) {
        this.clearingHouseId = clearingHouseId;
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
        ClaimDataModel that = (ClaimDataModel) o;
        return Objects.equals(payeeType, that.payeeType) &&
                Objects.equals(cleanClaimDate, that.cleanClaimDate) &&
                Objects.equals(receivedDate, that.receivedDate) &&
                Objects.equals(source, that.source) &&
                Objects.equals(orthoMonths, that.orthoMonths) &&
                Objects.equals(transmissionId, that.transmissionId) &&
                Objects.equals(predeterminationNumber, that.predeterminationNumber) &&
                Objects.equals(clearingHouseId, that.clearingHouseId) &&
                Objects.equals(otherCoverageInd, that.otherCoverageInd) &&
                Objects.equals(coordinationOfBenefits, that.coordinationOfBenefits) &&
                Objects.equals(transactionType, that.transactionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), payeeType, cleanClaimDate, receivedDate, source, orthoMonths, transmissionId, predeterminationNumber, clearingHouseId, otherCoverageInd, coordinationOfBenefits, transactionType);
    }

}
