package com.exigen.ren.rest.claim.model.common.claimbody.claim;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.Objects;

public class ClaimCoordinationOfBenefitsModel extends Model {
    private String otherInsuredName;
    private String otherCarrierName;
    private String otherInsuredDOB;
    private double otherCarrierAmount;

    public String getOtherInsuredName() {
        return otherInsuredName;
    }

    public void setOtherInsuredName(String otherInsuredName) {
        this.otherInsuredName = otherInsuredName;
    }

    public String getOtherCarrierName() {
        return otherCarrierName;
    }

    public void setOtherCarrierName(String otherCarrierName) {
        this.otherCarrierName = otherCarrierName;
    }

    public String getOtherInsuredDOB() {
        return otherInsuredDOB;
    }

    public void setOtherInsuredDOB(String otherInsuredDOB) {
        this.otherInsuredDOB = otherInsuredDOB;
    }

    public double getOtherCarrierAmount() {
        return otherCarrierAmount;
    }

    public void setOtherCarrierAmount(double otherCarrierAmount) {
        this.otherCarrierAmount = otherCarrierAmount;
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
        ClaimCoordinationOfBenefitsModel that = (ClaimCoordinationOfBenefitsModel) o;
        return Objects.equals(otherInsuredName, that.otherInsuredName) &&
                Objects.equals(otherCarrierName, that.otherCarrierName) &&
                Objects.equals(otherInsuredDOB, that.otherInsuredDOB) &&
                Objects.equals(otherCarrierAmount, that.otherCarrierAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), otherInsuredName, otherCarrierName, otherInsuredDOB, otherCarrierAmount);
    }

}
