package com.exigen.ren.rest.dxp.model;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PremiumSummariesModel extends RestError {

    private String coverageCd;
    private String contributionType;
    private String contributionPrct;
    private String insureds;
    private String benefitType;
    private String benefitAmount;
    private String rateBasis;
    private String rate;
    private String annualPremium;
    private String payor;
    private String paymentMode;
    private String modalPremium;
    private String dailyPremium;
    private String coverageTier;
    private String effectiveDate;

    public String getCoverageCd() {
        return coverageCd;
    }

    public void setCoverageCd(String coverageCd) {
        this.coverageCd = coverageCd;
    }

    public String getContributionType() {
        return contributionType;
    }

    public void setContributionType(String contributionType) {
        this.contributionType = contributionType;
    }

    public String getContributionPrct() {
        return contributionPrct;
    }

    public void setContributionPrct(String contributionPrct) {
        this.contributionPrct = contributionPrct;
    }

    public String getInsureds() {
        return insureds;
    }

    public void setInsureds(String insureds) {
        this.insureds = insureds;
    }

    public String getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(String benefitType) {
        this.benefitType = benefitType;
    }

    public String getBenefitAmount() {
        return benefitAmount;
    }

    public void setBenefitAmount(String benefitAmount) {
        this.benefitAmount = benefitAmount;
    }

    public String getRateBasis() {
        return rateBasis;
    }

    public void setRateBasis(String rateBasis) {
        this.rateBasis = rateBasis;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getAnnualPremium() {
        return annualPremium;
    }

    public void setAnnualPremium(String annualPremium) {
        this.annualPremium = annualPremium;
    }

    public String getPayor() {
        return payor;
    }

    public void setPayor(String payor) {
        this.payor = payor;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getModalPremium() {
        return modalPremium;
    }

    public void setModalPremium(String modalPremium) {
        this.modalPremium = modalPremium;
    }

    public String getDailyPremium() {
        return dailyPremium;
    }

    public void setDailyPremium(String dailyPremium) {
        this.dailyPremium = dailyPremium;
    }

    public String getCoverageTier() {
        return coverageTier;
    }

    public void setCoverageTier(String coverageTier) {
        this.coverageTier = coverageTier;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        if (!super.equals(o)) {return false;}
        PremiumSummariesModel that = (PremiumSummariesModel) o;
        return Objects.equals(coverageCd, that.coverageCd) &&
                Objects.equals(contributionType, that.contributionType) &&
                Objects.equals(contributionPrct, that.contributionPrct) &&
                Objects.equals(insureds, that.insureds) &&
                Objects.equals(benefitType, that.benefitType) &&
                Objects.equals(benefitAmount, that.benefitAmount) &&
                Objects.equals(rateBasis, that.rateBasis) &&
                Objects.equals(rate, that.rate) &&
                Objects.equals(annualPremium, that.annualPremium) &&
                Objects.equals(payor, that.payor) &&
                Objects.equals(paymentMode, that.paymentMode) &&
                Objects.equals(modalPremium, that.modalPremium) &&
                Objects.equals(dailyPremium, that.dailyPremium) &&
                Objects.equals(coverageTier, that.coverageTier) &&
                Objects.equals(effectiveDate, that.effectiveDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coverageCd, contributionType, contributionPrct, insureds, benefitType, benefitAmount, rateBasis, rate, annualPremium, payor, paymentMode, modalPremium, dailyPremium, coverageTier, effectiveDate);
    }
}
