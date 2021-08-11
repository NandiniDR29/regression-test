package com.exigen.ren.rest.rating.model.gb_vs;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RatingReportVisionModel extends RestError {

    private List<PlanCalculationModel> planCalculation;
    private AdminCostModel adminCost;
    private String nature;
    private ReportsModel reports;

    public List<PlanCalculationModel> getPlanCalculation() {
        return planCalculation;
    }

    public RatingReportVisionModel setPlanCalculation(List<PlanCalculationModel> planCalculation) {
        this.planCalculation = planCalculation;
        return this;
    }

    public AdminCostModel getAdminCost() {
        return adminCost;
    }

    public RatingReportVisionModel setAdminCost(AdminCostModel adminCost) {
        this.adminCost = adminCost;
        return this;
    }

    public String getNature() {
        return nature;
    }

    public RatingReportVisionModel setNature(String nature) {
        this.nature = nature;
        return this;
    }

    public ReportsModel getReports() {
        return reports;
    }

    public RatingReportVisionModel setReports(ReportsModel reports) {
        this.reports = reports;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RatingReportVisionModel)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        RatingReportVisionModel that = (RatingReportVisionModel) o;
        return Objects.equals(planCalculation, that.planCalculation) &&
                Objects.equals(adminCost, that.adminCost) &&
                Objects.equals(nature, that.nature) &&
                Objects.equals(reports, that.reports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), planCalculation, adminCost, nature, reports);
    }

    @Override
    public String toString() {
        return "RatingReportVisionModel{" +
                "planCalculation=" + planCalculation +
                ", adminCost=" + adminCost +
                ", nature='" + nature + '\'' +
                ", reports=" + reports +
                '}';
    }
}
