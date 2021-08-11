package com.exigen.ren.rest.rating.model.gb_vs;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FactorsModel extends Model {

    private String baselineCost;
    private String planFrequency;
    private String area;
    private String contribution;
    private String allowance;
    private String product;
    private String network;
    private String copay;
    private String lensOptions;
    private String trendMultiple;
    private String texasAdjustment;
    private String scratchCoating;
    private String safetyGlasses;
    private String photochromicLens;
    private String progressiveLensesInFull;
    private String totalCost;
    private String trendFactor;

    public String getBaselineCost() {
        return baselineCost;
    }

    public FactorsModel setBaselineCost(String baselineCost) {
        this.baselineCost = baselineCost;
        return this;
    }

    public String getPlanFrequency() {
        return planFrequency;
    }

    public FactorsModel setPlanFrequency(String planFrequency) {
        this.planFrequency = planFrequency;
        return this;
    }

    public String getArea() {
        return area;
    }

    public FactorsModel setArea(String area) {
        this.area = area;
        return this;
    }

    public String getContribution() {
        return contribution;
    }

    public FactorsModel setContribution(String contribution) {
        this.contribution = contribution;
        return this;
    }

    public String getAllowance() {
        return allowance;
    }

    public FactorsModel setAllowance(String allowance) {
        this.allowance = allowance;
        return this;
    }

    public String getProduct() {
        return product;
    }

    public FactorsModel setProduct(String product) {
        this.product = product;
        return this;
    }

    public String getNetwork() {
        return network;
    }

    public FactorsModel setNetwork(String network) {
        this.network = network;
        return this;
    }

    public String getCopay() {
        return copay;
    }

    public FactorsModel setCopay(String copay) {
        this.copay = copay;
        return this;
    }

    public String getLensOptions() {
        return lensOptions;
    }

    public FactorsModel setLensOptions(String lensOptions) {
        this.lensOptions = lensOptions;
        return this;
    }

    public String getTrendMultiple() {
        return trendMultiple;
    }

    public FactorsModel setTrendMultiple(String trendMultiple) {
        this.trendMultiple = trendMultiple;
        return this;
    }

    public String getTexasAdjustment() {
        return texasAdjustment;
    }

    public FactorsModel setTexasAdjustment(String texasAdjustment) {
        this.texasAdjustment = texasAdjustment;
        return this;
    }

    public String getScratchCoating() {
        return scratchCoating;
    }

    public FactorsModel setScratchCoating(String scratchCoating) {
        this.scratchCoating = scratchCoating;
        return this;
    }

    public String getSafetyGlasses() {
        return safetyGlasses;
    }

    public FactorsModel setSafetyGlasses(String safetyGlasses) {
        this.safetyGlasses = safetyGlasses;
        return this;
    }

    public String getPhotochromicLens() {
        return photochromicLens;
    }

    public FactorsModel setPhotochromicLens(String photochromicLens) {
        this.photochromicLens = photochromicLens;
        return this;
    }

    public String getProgressiveLensesInFull() {
        return progressiveLensesInFull;
    }

    public FactorsModel setProgressiveLensesInFull(String progressiveLensesInFull) {
        this.progressiveLensesInFull = progressiveLensesInFull;
        return this;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public FactorsModel setTotalCost(String totalCost) {
        this.totalCost = totalCost;
        return this;
    }

    public String getTrendFactor() {
        return trendFactor;
    }

    public FactorsModel setTrendFactor(String trendFactor) {
        this.trendFactor = trendFactor;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FactorsModel)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        FactorsModel that = (FactorsModel) o;
        return Objects.equals(baselineCost, that.baselineCost) &&
                Objects.equals(planFrequency, that.planFrequency) &&
                Objects.equals(area, that.area) &&
                Objects.equals(contribution, that.contribution) &&
                Objects.equals(allowance, that.allowance) &&
                Objects.equals(product, that.product) &&
                Objects.equals(network, that.network) &&
                Objects.equals(copay, that.copay) &&
                Objects.equals(lensOptions, that.lensOptions) &&
                Objects.equals(trendMultiple, that.trendMultiple) &&
                Objects.equals(texasAdjustment, that.texasAdjustment) &&
                Objects.equals(scratchCoating, that.scratchCoating) &&
                Objects.equals(safetyGlasses, that.safetyGlasses) &&
                Objects.equals(photochromicLens, that.photochromicLens) &&
                Objects.equals(progressiveLensesInFull, that.progressiveLensesInFull) &&
                Objects.equals(totalCost, that.totalCost) &&
                Objects.equals(trendFactor, that.trendFactor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), baselineCost, planFrequency, area, contribution, allowance, product, network, copay, lensOptions, trendMultiple, texasAdjustment, scratchCoating, safetyGlasses, photochromicLens, progressiveLensesInFull, totalCost, trendFactor);
    }

    @Override
    public String toString() {
        return "FactorsModel{" +
                "baselineCost='" + baselineCost + '\'' +
                ", planFrequency='" + planFrequency + '\'' +
                ", area='" + area + '\'' +
                ", contribution='" + contribution + '\'' +
                ", allowance='" + allowance + '\'' +
                ", product='" + product + '\'' +
                ", network='" + network + '\'' +
                ", copay='" + copay + '\'' +
                ", lensOptions='" + lensOptions + '\'' +
                ", trendMultiple='" + trendMultiple + '\'' +
                ", texasAdjustment='" + texasAdjustment + '\'' +
                ", scratchCoating='" + scratchCoating + '\'' +
                ", safetyGlasses='" + safetyGlasses + '\'' +
                ", photochromicLens='" + photochromicLens + '\'' +
                ", progressiveLensesInFull='" + progressiveLensesInFull + '\'' +
                ", totalCost='" + totalCost + '\'' +
                ", trendFactor='" + trendFactor + '\'' +
                '}';
    }
}
