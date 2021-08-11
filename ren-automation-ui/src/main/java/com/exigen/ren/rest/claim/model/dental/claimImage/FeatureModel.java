package com.exigen.ren.rest.claim.model.dental.claimImage;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.Objects;

public class FeatureModel extends Model {
    private ExtensionModel extension;

    public ExtensionModel getExtension() {
        return extension;
    }

    public void setExtension(ExtensionModel extension) {
        this.extension = extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FeatureModel that = (FeatureModel) o;
        return Objects.equals(extension, that.extension);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), extension);
    }
}
