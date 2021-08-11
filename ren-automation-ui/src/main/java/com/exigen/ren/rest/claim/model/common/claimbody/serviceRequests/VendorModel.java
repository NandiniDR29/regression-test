package com.exigen.ren.rest.claim.model.common.claimbody.serviceRequests;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.Objects;

public class VendorModel extends Model {
    private ProfileModel profile;

    public ProfileModel getProfile() {
        return profile;
    }

    public void setProfile(ProfileModel profile) {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        if (!super.equals(o)) {return false;}
        VendorModel that = (VendorModel) o;
        return Objects.equals(profile, that.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), profile);
    }
}
