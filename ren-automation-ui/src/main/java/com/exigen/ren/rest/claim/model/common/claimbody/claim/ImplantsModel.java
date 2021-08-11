package com.exigen.ren.rest.claim.model.common.claimbody.claim;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.Objects;

public class ImplantsModel extends Model {
    private String applied;
    private String applyLifetimeLimitTowardAnnualLimitInd;
    private String innLifetimeMaxLimit;
    private String oonLifetimeMaxLimit;

    public String getApplied() {
        return applied;
    }

    public void setApplied(String applied) {
        this.applied = applied;
    }

    public String getApplyLifetimeLimitTowardAnnualLimitInd() {
        return applyLifetimeLimitTowardAnnualLimitInd;
    }

    public void setApplyLifetimeLimitTowardAnnualLimitInd(String applyLifetimeLimitTowardAnnualLimitInd) {
        this.applyLifetimeLimitTowardAnnualLimitInd = applyLifetimeLimitTowardAnnualLimitInd;
    }

    public String getInnLifetimeMaxLimit() {
        return innLifetimeMaxLimit;
    }

    public void setInnLifetimeMaxLimit(String innLifetimeMaxLimit) {
        this.innLifetimeMaxLimit = innLifetimeMaxLimit;
    }

    public String getOonLifetimeMaxLimit() {
        return oonLifetimeMaxLimit;
    }

    public void setOonLifetimeMaxLimit(String oonLifetimeMaxLimit) {
        this.oonLifetimeMaxLimit = oonLifetimeMaxLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ImplantsModel that = (ImplantsModel) o;
        return Objects.equals(applied, that.applied) &&
                Objects.equals(applyLifetimeLimitTowardAnnualLimitInd, that.applyLifetimeLimitTowardAnnualLimitInd) &&
                Objects.equals(innLifetimeMaxLimit, that.innLifetimeMaxLimit) &&
                Objects.equals(oonLifetimeMaxLimit, that.oonLifetimeMaxLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), applied, applyLifetimeLimitTowardAnnualLimitInd, innLifetimeMaxLimit, oonLifetimeMaxLimit);
    }
}
