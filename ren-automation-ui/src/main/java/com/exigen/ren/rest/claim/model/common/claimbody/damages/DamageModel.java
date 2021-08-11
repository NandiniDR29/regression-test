package com.exigen.ren.rest.claim.model.common.claimbody.damages;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.List;
import java.util.Objects;

public class DamageModel extends Model {
    private String damageType;
    private LossModel loss;
    private List<DamageFeatureModel> features;

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public LossModel getLoss() {
        return loss;
    }

    public void setLoss(LossModel loss) {
        this.loss = loss;
    }

    public List<DamageFeatureModel> getFeatures() {
        return features;
    }

    public void setFeatures(List<DamageFeatureModel> features) {
        this.features = features;
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
        DamageModel that = (DamageModel) o;
        return Objects.equals(damageType, that.damageType) &&
                Objects.equals(loss, that.loss) &&
                Objects.equals(features, that.features);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), damageType, loss, features);
    }

}
