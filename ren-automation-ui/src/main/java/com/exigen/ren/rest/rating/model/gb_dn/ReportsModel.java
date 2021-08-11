package com.exigen.ren.rest.rating.model.gb_dn;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.exigen.istf.exceptions.IstfException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReportsModel extends Model {

    private List<PlanModel> plans;
    private String policyId;

    public List<PlanModel> getPlans() {
        return plans;
    }

    public ReportsModel setPlans(List<PlanModel> plans) {
        this.plans = plans;
        return this;
    }

    public String getPolicyId() {
        return policyId;
    }

    public ReportsModel setPolicyId(String policyId) {
        this.policyId = policyId;
        return this;
    }

    public PlanModel getPlanModelByPlanName(String planName) {
        PlanModel planModel = null;
        for (PlanModel model : plans) {
            if (model.getPlanName().equals(planName)) {
                planModel = model;
            }
        }
        if (planModel == null) {
            throw new IstfException(String.format("Plan Model with name '%s' isn't exist in Rating Report Model. Check Plan Model name", planName));
        }
        return planModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReportsModel)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        ReportsModel that = (ReportsModel) o;
        return Objects.equals(plans, that.plans) &&
                Objects.equals(policyId, that.policyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), plans, policyId);
    }

    @Override
    public String toString() {
        return "ReportsModel{" +
                "plans=" + plans +
                ", policyId='" + policyId + '\'' +
                '}';
    }
}
