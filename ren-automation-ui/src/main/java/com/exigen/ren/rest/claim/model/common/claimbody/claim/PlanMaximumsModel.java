package com.exigen.ren.rest.claim.model.common.claimbody.claim;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.Objects;

public class PlanMaximumsModel extends Model {
    private String expensePeriodCd;
    private boolean maximumRollOver;
    private boolean gradedMaxInd;
    private String innFirstYearLimit;
    private String oonFirstYearLimit;
    private String innSecondYearLimit;
    private String oonSecondYearLimit;
    private String innThirdYearLimit;
    private String oonThirdYearLimit;
    private String innPlanLimit;
    private String oonPlanLimit;
    private String maxExtenderInd;
    private String rollOverThreshold;
    private String rollOverBenefit;
    private String rollOverBenefitLimit;
    private String oonFourthYearLimit;
    private String innFourthYearLimit;
    private String planMaxLimit;
    private String numberOfGradedYears;

    public String getExpensePeriodCd() {
        return expensePeriodCd;
    }

    public void setExpensePeriodCd(String expensePeriodCd) {
        this.expensePeriodCd = expensePeriodCd;
    }

    public boolean isMaximumRollOver() {
        return maximumRollOver;
    }

    public void setMaximumRollOver(boolean maximumRollOver) {
        this.maximumRollOver = maximumRollOver;
    }

    public boolean isGradedMaxInd() {
        return gradedMaxInd;
    }

    public void setGradedMaxInd(boolean gradedMaxInd) {
        this.gradedMaxInd = gradedMaxInd;
    }

    public String getInnFirstYearLimit() {
        return innFirstYearLimit;
    }

    public void setInnFirstYearLimit(String innFirstYearLimit) {
        this.innFirstYearLimit = innFirstYearLimit;
    }

    public String getOonFirstYearLimit() {
        return oonFirstYearLimit;
    }

    public void setOonFirstYearLimit(String oonFirstYearLimit) {
        this.oonFirstYearLimit = oonFirstYearLimit;
    }

    public String getInnSecondYearLimit() {
        return innSecondYearLimit;
    }

    public void setInnSecondYearLimit(String innSecondYearLimit) {
        this.innSecondYearLimit = innSecondYearLimit;
    }

    public String getOonSecondYearLimit() {
        return oonSecondYearLimit;
    }

    public void setOonSecondYearLimit(String oonSecondYearLimit) {
        this.oonSecondYearLimit = oonSecondYearLimit;
    }

    public String getInnThirdYearLimit() {
        return innThirdYearLimit;
    }

    public void setInnThirdYearLimit(String innThirdYearLimit) {
        this.innThirdYearLimit = innThirdYearLimit;
    }

    public String getOonThirdYearLimit() {
        return oonThirdYearLimit;
    }

    public void setOonThirdYearLimit(String oonThirdYearLimit) {
        this.oonThirdYearLimit = oonThirdYearLimit;
    }

    public String getInnPlanLimit() {
        return innPlanLimit;
    }

    public void setInnPlanLimit(String innPlanLimit) {
        this.innPlanLimit = innPlanLimit;
    }

    public String getOonPlanLimit() {
        return oonPlanLimit;
    }

    public void setOonPlanLimit(String oonPlanLimit) {
        this.oonPlanLimit = oonPlanLimit;
    }

    public String getMaxExtenderInd() {
        return maxExtenderInd;
    }

    public void setMaxExtenderInd(String maxExtenderInd) {
        this.maxExtenderInd = maxExtenderInd;
    }

    public String getRollOverThreshold() {
        return rollOverThreshold;
    }

    public void setRollOverThreshold(String rollOverThreshold) {
        this.rollOverThreshold = rollOverThreshold;
    }

    public String getRollOverBenefit() {
        return rollOverBenefit;
    }

    public void setRollOverBenefit(String rollOverBenefit) {
        this.rollOverBenefit = rollOverBenefit;
    }

    public String getRollOverBenefitLimit() {
        return rollOverBenefitLimit;
    }

    public void setRollOverBenefitLimit(String rollOverBenefitLimit) {
        this.rollOverBenefitLimit = rollOverBenefitLimit;
    }

    public String getOonFourthYearLimit() {
        return oonFourthYearLimit;
    }

    public void setOonFourthYearLimit(String oonFourthYearLimit) {
        this.oonFourthYearLimit = oonFourthYearLimit;
    }

    public String getInnFourthYearLimit() {
        return innFourthYearLimit;
    }

    public void setInnFourthYearLimit(String innFourthYearLimit) {
        this.innFourthYearLimit = innFourthYearLimit;
    }

    public String getPlanMaxLimit() {
        return planMaxLimit;
    }

    public void setPlanMaxLimit(String planMaxLimit) {
        this.planMaxLimit = planMaxLimit;
    }

    public String getNumberOfGradedYears() {
        return numberOfGradedYears;
    }

    public void setNumberOfGradedYears(String numberOfGradedYears) {
        this.numberOfGradedYears = numberOfGradedYears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PlanMaximumsModel that = (PlanMaximumsModel) o;
        return maximumRollOver == that.maximumRollOver &&
                gradedMaxInd == that.gradedMaxInd &&
                Objects.equals(expensePeriodCd, that.expensePeriodCd) &&
                Objects.equals(innFirstYearLimit, that.innFirstYearLimit) &&
                Objects.equals(oonFirstYearLimit, that.oonFirstYearLimit) &&
                Objects.equals(innSecondYearLimit, that.innSecondYearLimit) &&
                Objects.equals(oonSecondYearLimit, that.oonSecondYearLimit) &&
                Objects.equals(innThirdYearLimit, that.innThirdYearLimit) &&
                Objects.equals(oonThirdYearLimit, that.oonThirdYearLimit) &&
                Objects.equals(innPlanLimit, that.innPlanLimit) &&
                Objects.equals(oonPlanLimit, that.oonPlanLimit) &&
                Objects.equals(maxExtenderInd, that.maxExtenderInd) &&
                Objects.equals(rollOverThreshold, that.rollOverThreshold) &&
                Objects.equals(rollOverBenefit, that.rollOverBenefit) &&
                Objects.equals(rollOverBenefitLimit, that.rollOverBenefitLimit) &&
                Objects.equals(oonFourthYearLimit, that.oonFourthYearLimit) &&
                Objects.equals(innFourthYearLimit, that.innFourthYearLimit) &&
                Objects.equals(planMaxLimit, that.planMaxLimit) &&
                Objects.equals(numberOfGradedYears, that.numberOfGradedYears);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), expensePeriodCd, maximumRollOver, gradedMaxInd, innFirstYearLimit, oonFirstYearLimit, innSecondYearLimit, oonSecondYearLimit, innThirdYearLimit, oonThirdYearLimit, innPlanLimit, oonPlanLimit, maxExtenderInd, rollOverThreshold, rollOverBenefit, rollOverBenefitLimit, oonFourthYearLimit, innFourthYearLimit, planMaxLimit, numberOfGradedYears);
    }
}
