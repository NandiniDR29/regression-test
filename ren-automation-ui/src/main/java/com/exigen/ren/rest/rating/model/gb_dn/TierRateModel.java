package com.exigen.ren.rest.rating.model.gb_dn;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TierRateModel extends Model {

    private String area;
    private String tier;
    private String manualRate;
    private String adjManualRate;
    private String formulaRate;
    private String adjFormulaRate;
    private String proposedRate;

    public String getTier() {
        return tier;
    }

    public TierRateModel setTier(String tier) {
        this.tier = tier;
        return this;
    }

    public String getManualRate() {
        return manualRate;
    }

    public TierRateModel setManualRate(String manualRate) {
        this.manualRate = manualRate;
        return this;
    }

    public String getAdjManualRate() {
        return adjManualRate;
    }

    public TierRateModel setAdjManualRate(String adjManualRate) {
        this.adjManualRate = adjManualRate;
        return this;
    }

    public String getFormulaRate() {
        return formulaRate;
    }

    public TierRateModel setFormulaRate(String formulaRate) {
        this.formulaRate = formulaRate;
        return this;
    }

    public String getAdjFormulaRate() {
        return adjFormulaRate;
    }

    public TierRateModel setAdjFormulaRate(String adjFormulaRate) {
        this.adjFormulaRate = adjFormulaRate;
        return this;
    }

    public String getProposedRate() {
        return proposedRate;
    }

    public TierRateModel setProposedRate(String proposedRate) {
        this.proposedRate = proposedRate;
        return this;
    }

    public String getArea() {
        return area;
    }

    public TierRateModel setArea(String area) {
        this.area = area;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TierRateModel)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        TierRateModel that = (TierRateModel) o;
        return Objects.equals(area, that.area) &&
                Objects.equals(tier, that.tier) &&
                Objects.equals(manualRate, that.manualRate) &&
                Objects.equals(adjManualRate, that.adjManualRate) &&
                Objects.equals(formulaRate, that.formulaRate) &&
                Objects.equals(adjFormulaRate, that.adjFormulaRate) &&
                Objects.equals(proposedRate, that.proposedRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), area, tier, manualRate, adjManualRate, formulaRate, adjFormulaRate, proposedRate);
    }

    @Override
    public String toString() {
        return "TierRateModel{" +
                "area='" + area + '\'' +
                ", tier='" + tier + '\'' +
                ", manualRate='" + manualRate + '\'' +
                ", adjManualRate='" + adjManualRate + '\'' +
                ", formulaRate='" + formulaRate + '\'' +
                ", adjFormulaRate='" + adjFormulaRate + '\'' +
                ", proposedRate='" + proposedRate + '\'' +
                '}';
    }
}
