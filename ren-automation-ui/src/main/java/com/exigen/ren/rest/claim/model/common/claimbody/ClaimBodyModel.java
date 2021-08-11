package com.exigen.ren.rest.claim.model.common.claimbody;

import com.exigen.ren.rest.claim.model.common.claimbody.claim.ClaimModel;
import com.exigen.ren.rest.claim.model.common.claimbody.damages.DamageModel;
import com.exigen.ren.rest.claim.model.common.claimbody.serviceRequests.ServiceRequestModel;
import com.exigen.ren.rest.model.RestError;

import java.util.List;
import java.util.Objects;

public class ClaimBodyModel extends RestError {
    private ClaimModel claim;
    private List<DamageModel> damages;
    private List<ServiceRequestModel> serviceRequests;

    public ClaimModel getClaim() {
        return claim;
    }

    public void setClaim(ClaimModel claim) {
        this.claim = claim;
    }

    public List<DamageModel> getDamages() {
        return damages;
    }

    public void setDamages(List<DamageModel> damages) {
        this.damages = damages;
    }

    public List<ServiceRequestModel> getServiceRequests() {
        return serviceRequests;
    }

    public void setServiceRequests(List<ServiceRequestModel> serviceRequests) {
        this.serviceRequests = serviceRequests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        if (!super.equals(o)) {return false;}
        ClaimBodyModel claimBodyModel = (ClaimBodyModel) o;
        return Objects.equals(claim, claimBodyModel.claim) &&
                Objects.equals(damages, claimBodyModel.damages) &&
                Objects.equals(serviceRequests, claimBodyModel.serviceRequests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), claim, damages, serviceRequests);
    }
}
