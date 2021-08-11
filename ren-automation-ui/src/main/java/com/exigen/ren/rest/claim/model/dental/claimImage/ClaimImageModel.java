package com.exigen.ren.rest.claim.model.dental.claimImage;

import com.exigen.ren.rest.claim.model.common.claimbody.claim.ClaimModel;
import com.exigen.ren.rest.model.RestError;

import java.util.List;
import java.util.Objects;

public class ClaimImageModel extends RestError {
    private ClaimModel claim;
    private List<DamageModel> damages;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClaimImageModel that = (ClaimImageModel) o;
        return Objects.equals(claim, that.claim) &&
                Objects.equals(damages, that.damages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), claim, damages);
    }
}
