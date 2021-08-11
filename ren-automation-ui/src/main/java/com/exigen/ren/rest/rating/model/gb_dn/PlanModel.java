package com.exigen.ren.rest.rating.model.gb_dn;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.exigen.istf.exceptions.IstfException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlanModel extends Model {

    private String voluntaryOverrideEE;
    private String areaFactorOverridePPO;
    private String indemnityOverride;
    private String networkPenetrationOverridePPO;
    List<UwManualAdjustmentsModel> uwManualAdjustments;
    private String planName;
    List<CurrentRatesBreakdownModel> currentRatesBreakdown;

    public String getVoluntaryOverrideEE() {
        return voluntaryOverrideEE;
    }

    public PlanModel setVoluntaryOverrideEE(String voluntaryOverrideEE) {
        this.voluntaryOverrideEE = voluntaryOverrideEE;
        return this;
    }

    public String getAreaFactorOverridePPO() {
        return areaFactorOverridePPO;
    }

    public PlanModel setAreaFactorOverridePPO(String areaFactorOverridePPO) {
        this.areaFactorOverridePPO = areaFactorOverridePPO;
        return this;
    }

    public String getIndemnityOverride() {
        return indemnityOverride;
    }

    public PlanModel setIndemnityOverride(String indemnityOverride) {
        this.indemnityOverride = indemnityOverride;
        return this;
    }

    public String getNetworkPenetrationOverridePPO() {
        return networkPenetrationOverridePPO;
    }

    public PlanModel setNetworkPenetrationOverridePPO(String networkPenetrationOverridePPO) {
        this.networkPenetrationOverridePPO = networkPenetrationOverridePPO;
        return this;
    }

    public List<UwManualAdjustmentsModel> getUwManualAdjustments() {
        return uwManualAdjustments;
    }

    public PlanModel setUwManualAdjustments(List<UwManualAdjustmentsModel> uwManualAdjustments) {
        this.uwManualAdjustments = uwManualAdjustments;
        return this;
    }

    public String getPlanName() {
        return planName;
    }

    public PlanModel setPlanName(String planName) {
        this.planName = planName;
        return this;
    }

    public List<CurrentRatesBreakdownModel> getCurrentRatesBreakdown() {
        return currentRatesBreakdown;
    }

    public PlanModel setCurrentRatesBreakdown(List<CurrentRatesBreakdownModel> currentRatesBreakdown) {
        this.currentRatesBreakdown = currentRatesBreakdown;
        return this;
    }

    public CurrentRatesBreakdownModel getCurrentRatesBreakdownModelByTierName(String tierName) {
        CurrentRatesBreakdownModel currentRatesBreakdownModel = null;
        for (CurrentRatesBreakdownModel model : currentRatesBreakdown) {
            if (model.getTier().equals(tierName)) {
                currentRatesBreakdownModel = model;
            }
        }
        if (currentRatesBreakdownModel == null) {
            throw new IstfException(String.format("Current Rates Breakdown Model with name '%s' isn't exist in Plan Model. Check Tier name", tierName));
        }
        return currentRatesBreakdownModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PlanModel)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        PlanModel planModel = (PlanModel) o;
        return Objects.equals(voluntaryOverrideEE, planModel.voluntaryOverrideEE) &&
                Objects.equals(areaFactorOverridePPO, planModel.areaFactorOverridePPO) &&
                Objects.equals(indemnityOverride, planModel.indemnityOverride) &&
                Objects.equals(networkPenetrationOverridePPO, planModel.networkPenetrationOverridePPO) &&
                Objects.equals(uwManualAdjustments, planModel.uwManualAdjustments) &&
                Objects.equals(planName, planModel.planName) &&
                Objects.equals(currentRatesBreakdown, planModel.currentRatesBreakdown);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), voluntaryOverrideEE, areaFactorOverridePPO, indemnityOverride, networkPenetrationOverridePPO, uwManualAdjustments, planName, currentRatesBreakdown);
    }

    @Override
    public String toString() {
        return "PlanModel{" +
                "voluntaryOverrideEE='" + voluntaryOverrideEE + '\'' +
                ", areaFactorOverridePPO='" + areaFactorOverridePPO + '\'' +
                ", indemnityOverride='" + indemnityOverride + '\'' +
                ", networkPenetrationOverridePPO='" + networkPenetrationOverridePPO + '\'' +
                ", uwManualAdjustments=" + uwManualAdjustments +
                ", planName='" + planName + '\'' +
                ", currentRatesBreakdown=" + currentRatesBreakdown +
                '}';
    }
}
