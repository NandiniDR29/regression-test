package com.exigen.ren.rest.dxp.model.claim.claimsMemberModels.claimsDentalMemberModels;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClaimsDentalMemberClaimsModel extends RestError {
    private ClaimsServiceRequestModel claimsServiceRequest;
    private List<ClaimsDamageModel> claimsDamages;

    public ClaimsServiceRequestModel getClaimsServiceRequest() {
        return claimsServiceRequest;
    }

    public void setClaimsServiceRequest(ClaimsServiceRequestModel claimsServiceRequest) {
        this.claimsServiceRequest = claimsServiceRequest;
    }

    public List<ClaimsDamageModel> getClaimsDamages() {
        return claimsDamages;
    }

    public void setClaimsDamages(List<ClaimsDamageModel> claimsDamages) {
        this.claimsDamages = claimsDamages;
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
        ClaimsDentalMemberClaimsModel that = (ClaimsDentalMemberClaimsModel) o;
        return Objects.equals(claimsServiceRequest, that.claimsServiceRequest) &&
                Objects.equals(claimsDamages, that.claimsDamages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), claimsServiceRequest, claimsDamages);
    }
}