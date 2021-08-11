package com.exigen.ren.rest.claim.model.common.claimbody.claim;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import java.util.Objects;

public class ClaimExtensionModel extends Model {
    private ClaimDataModel claimData;
    private PolicyInformationModel policyInformation;
    private PaidToDateInfoModel paidToDateInfo;

    public ClaimDataModel getClaimData() {
        return claimData;
    }

    public void setClaimData(ClaimDataModel claimData) {
        this.claimData = claimData;
    }

    public PolicyInformationModel getPolicyInformation() {
        return policyInformation;
    }

    public void setPolicyInformation(PolicyInformationModel policyInformation) {
        this.policyInformation = policyInformation;
    }

    public PaidToDateInfoModel getPaidToDateInfo() {
        return paidToDateInfo;
    }

    public void setPaidToDateInfo(PaidToDateInfoModel paidToDateInfo) {
        this.paidToDateInfo = paidToDateInfo;
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
        ClaimExtensionModel that = (ClaimExtensionModel) o;
        return Objects.equals(claimData, that.claimData) &&
                Objects.equals(policyInformation, that.policyInformation) &&
                Objects.equals(paidToDateInfo, that.paidToDateInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), claimData, policyInformation, paidToDateInfo);
    }

}
