package com.exigen.ren.rest.rating.model.gb_dn;

import com.exigen.ipb.eisa.utils.Currency;
import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.exigen.istf.exceptions.IstfException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RatingReportDentalModel extends Model {

    private String policyID;
    private List<PlanCalculationModel> planCalculations;
    private List<AdminCostsModel> adminCosts;
    private AsoAdminCostModel asoAdminCost;
    private String nature;
    private ReportsModel reports;

    public String getPolicyID() {
        return policyID;
    }

    public RatingReportDentalModel setPolicyID(String policyID) {
        this.policyID = policyID;
        return this;
    }

    public List<PlanCalculationModel> getPlanCalculations() {
        return planCalculations;
    }

    public RatingReportDentalModel setPlanCalculations(List<PlanCalculationModel> planCalculations) {
        this.planCalculations = planCalculations;
        return this;
    }

    public List<AdminCostsModel> getAdminCosts() {
        return adminCosts;
    }

    /**
     * Adapt values from REST to expected UI format
     * Method can be used to getting values from REST and compare with UI values*
     */
    public List<AdminCostsModel> getAdminCostsWithRoundedValues() {
        List<AdminCostsModel> result = getAdminCosts();
        result.forEach(
                model -> {
                    model.setAnnualAmt(new Currency(model.getAnnualAmt(), RoundingMode.HALF_UP).toString());
                    model.setPerClaimAmt(new Currency(model.getPerClaimAmt(), RoundingMode.HALF_UP).toString());
                    model.setPerEmployeeAmt(new Currency(model.getPerEmployeeAmt(), RoundingMode.HALF_UP).toString());
                    model.setPremiumPct(new DecimalFormat("#0.00%").format(new BigDecimal(model.getPremiumPct())));
                }
        );
        return result;
    }

    public RatingReportDentalModel setAdminCosts(List<AdminCostsModel> adminCosts) {
        this.adminCosts = adminCosts;
        return this;
    }

    public String getNature() {
        return nature;
    }

    public RatingReportDentalModel setNature(String nature) {
        this.nature = nature;
        return this;
    }

    public AsoAdminCostModel getAsoAdminCost() {
        return asoAdminCost;
    }

    /**
     * Adapt values from REST to expected UI format
     * Method can be used to getting values from REST and compare with UI values*
     */
    public AsoAdminCostModel getAsoAdminCostWithRoundedValues() {
        AsoAdminCostModel asoAdminCostModel = new AsoAdminCostModel();
        asoAdminCostModel.setFullyInsuredPremiumNetComAmt(new Currency(asoAdminCost.getFullyInsuredPremiumNetComAmt(), RoundingMode.HALF_UP).toString());
        asoAdminCostModel.setFullyInsuredPremiumNetComPct(new DecimalFormat("#0.00%").format(new BigDecimal(asoAdminCost.getFullyInsuredPremiumNetComPct())));
        asoAdminCostModel.setAdmExpencesAmt(new Currency(asoAdminCost.getAdmExpencesAmt(), RoundingMode.HALF_UP).toString());
        asoAdminCostModel.setAdmExpencesPct(new DecimalFormat("#0.00%").format(new BigDecimal(asoAdminCost.getAdmExpencesPct())));
        asoAdminCostModel.setClaimsAmt(new Currency(asoAdminCost.getClaimsAmt(), RoundingMode.HALF_UP).toString());
        asoAdminCostModel.setClaimsPct(new DecimalFormat("#0.00%").format(new BigDecimal(asoAdminCost.getClaimsPct())));
        asoAdminCostModel.setRiskAndTaxesAmt(new Currency(asoAdminCost.getRiskAndTaxesAmt(),RoundingMode.HALF_UP).toString());
        asoAdminCostModel.setRiskAndTaxesPct(new DecimalFormat("#0.00%").format(new BigDecimal(asoAdminCost.getRiskAndTaxesPct())));
        asoAdminCostModel.setLostInterestAmt(new Currency(asoAdminCost.getLostInterestAmt(), RoundingMode.HALF_UP).toString());
        asoAdminCostModel.setLostInterestPct(new DecimalFormat("#0.00%").format(new BigDecimal(asoAdminCost.getLostInterestPct())));
        asoAdminCostModel.setAsoPreCommision(new Currency(asoAdminCost.getAsoPreCommision(), RoundingMode.HALF_UP).toString());
        asoAdminCostModel.setAsoPreCommisionPEPM(new Currency(asoAdminCost.getAsoPreCommisionPEPM(), RoundingMode.HALF_UP).toString());
        asoAdminCostModel.setExeptionPct(new DecimalFormat("#0.00%").format(new BigDecimal(asoAdminCost.getExeptionPct())));
        asoAdminCostModel.setAsoNetCommisions(new Currency(asoAdminCost.getAsoNetCommisions(),RoundingMode.HALF_UP).toString());
        if(null == asoAdminCost.getAsoCommissionPEPMOverride()){
            asoAdminCostModel.setAsoCommissionPEPMOverride("");
        } else {
            asoAdminCostModel.setAsoCommissionPEPMOverride(new Currency(asoAdminCost.getAsoCommissionPEPMOverride(), RoundingMode.HALF_UP).toString());
        }
        asoAdminCostModel.setAsoFinalPEPM(new Currency(asoAdminCost.getAsoFinalPEPM(), RoundingMode.HALF_UP).toString());
        asoAdminCostModel.setAsoFinal(new Currency(asoAdminCost.getAsoFinal(), RoundingMode.HALF_UP).toString());
        asoAdminCostModel.setAsoEquivalency(new Currency(asoAdminCost.getAsoEquivalency(), RoundingMode.HALF_UP).toString());
        return asoAdminCostModel;
    }

    public RatingReportDentalModel setAsoAdminCost(AsoAdminCostModel asoAdminCost) {
        this.asoAdminCost = asoAdminCost;
        return this;
    }

    public ReportsModel getReports() {
        return reports;
    }

    public RatingReportDentalModel setReports(ReportsModel reports) {
        this.reports = reports;
        return this;
    }

    public PlanCalculationModel getPlanCalculationModelByPlanName(String planName) {
        PlanCalculationModel planCalculationModel = null;
        for (PlanCalculationModel model : planCalculations) {
            if (model.getPlanName().equals(planName)) {
                planCalculationModel = model;
            }
        }
        if (planCalculationModel == null) {
            throw new IstfException(String.format("Plan Calculation Model with name '%s' isn't exist in Rating Report Model. Check Plan name", planName));
        }
        return planCalculationModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RatingReportDentalModel)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        RatingReportDentalModel that = (RatingReportDentalModel) o;
        return Objects.equals(policyID, that.policyID) &&
                Objects.equals(planCalculations, that.planCalculations) &&
                Objects.equals(adminCosts, that.adminCosts) &&
                Objects.equals(asoAdminCost, that.asoAdminCost) &&
                Objects.equals(nature, that.nature) &&
                Objects.equals(reports, that.reports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), policyID, planCalculations, adminCosts, asoAdminCost, nature, reports);
    }

    @Override
    public String toString() {
        return "RatingReportDentalModel{" +
                "policyID='" + policyID + '\'' +
                ", planCalculations=" + planCalculations +
                ", adminCosts=" + adminCosts +
                ", asoAdminCost=" + asoAdminCost +
                ", nature='" + nature + '\'' +
                ", reports=" + reports +
                '}';
    }
}
