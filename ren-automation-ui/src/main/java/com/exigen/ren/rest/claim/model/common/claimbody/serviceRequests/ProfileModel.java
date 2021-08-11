package com.exigen.ren.rest.claim.model.common.claimbody.serviceRequests;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.Objects;

public class ProfileModel extends Model {
    private String externalId;
    private ProfileExtensionModel extension;

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public ProfileExtensionModel getExtension() {
        return extension;
    }

    public void setExtension(ProfileExtensionModel extension) {
        this.extension = extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        if (!super.equals(o)) {return false;}
        ProfileModel that = (ProfileModel) o;
        return Objects.equals(externalId, that.externalId) &&
                Objects.equals(extension, that.extension);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), externalId, extension);
    }
}
