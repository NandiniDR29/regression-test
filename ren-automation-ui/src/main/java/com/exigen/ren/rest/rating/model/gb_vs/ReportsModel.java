package com.exigen.ren.rest.rating.model.gb_vs;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReportsModel extends Model {

    List<PlanModel> plans;
    private String policyId;

    public List<PlanModel> getPlans() {
        return plans;
    }

    public ReportsModel setPlans(List<PlanModel> plans) {
        this.plans = plans;
        return this;
    }

    @JsonProperty("policyID")
    public String getPolicyId() {
        return policyId;
    }

    @JsonProperty("policyID")
    public ReportsModel setPolicyId(String policyId) {
        this.policyId = policyId;
        return this;
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
