package com.exigen.ren.rest.rating.model.gb_dn;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDetailsModel extends Model {

    private String tierElement;
    private String benefitCategory;
    private String base;
    private String deductibleCredit;
    private String deductibleUtil;
    private String ageFactor;
    private String copay;
    private String claimsRate;
    private String rateCalc;
    private String rateCalcWO;

    public String getTierElement() {
        return tierElement;
    }

    public EmployeeDetailsModel setTierElement(String tierElement) {
        this.tierElement = tierElement;
        return this;
    }

    public String getBenefitCategory() {
        return benefitCategory;
    }

    public EmployeeDetailsModel setBenefitCategory(String benefitCategory) {
        this.benefitCategory = benefitCategory;
        return this;
    }

    public String getBase() {
        return base;
    }

    public EmployeeDetailsModel setBase(String base) {
        this.base = base;
        return this;
    }

    public String getDeductibleCredit() {
        return deductibleCredit;
    }

    public EmployeeDetailsModel setDeductibleCredit(String deductibleCredit) {
        this.deductibleCredit = deductibleCredit;
        return this;
    }

    public String getDeductibleUtil() {
        return deductibleUtil;
    }

    public EmployeeDetailsModel setDeductibleUtil(String deductibleUtil) {
        this.deductibleUtil = deductibleUtil;
        return this;
    }

    public String getAgeFactor() {
        return ageFactor;
    }

    public EmployeeDetailsModel setAgeFactor(String ageFactor) {
        this.ageFactor = ageFactor;
        return this;
    }

    public String getCopay() {
        return copay;
    }

    public EmployeeDetailsModel setCopay(String copay) {
        this.copay = copay;
        return this;
    }

    public String getClaimsRate() {
        return claimsRate;
    }

    public EmployeeDetailsModel setClaimsRate(String claimsRate) {
        this.claimsRate = claimsRate;
        return this;
    }

    public String getRateCalc() {
        return rateCalc;
    }

    public EmployeeDetailsModel setRateCalc(String rateCalc) {
        this.rateCalc = rateCalc;
        return this;
    }

    public String getRateCalcWO() {
        return rateCalcWO;
    }

    public EmployeeDetailsModel setRateCalcWO(String rateCalcWO) {
        this.rateCalcWO = rateCalcWO;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmployeeDetailsModel)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        EmployeeDetailsModel that = (EmployeeDetailsModel) o;
        return Objects.equals(tierElement, that.tierElement) &&
                Objects.equals(benefitCategory, that.benefitCategory) &&
                Objects.equals(base, that.base) &&
                Objects.equals(deductibleCredit, that.deductibleCredit) &&
                Objects.equals(deductibleUtil, that.deductibleUtil) &&
                Objects.equals(ageFactor, that.ageFactor) &&
                Objects.equals(copay, that.copay) &&
                Objects.equals(claimsRate, that.claimsRate) &&
                Objects.equals(rateCalc, that.rateCalc) &&
                Objects.equals(rateCalcWO, that.rateCalcWO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tierElement, benefitCategory, base, deductibleCredit, deductibleUtil, ageFactor, copay, claimsRate, rateCalc, rateCalcWO);
    }

    @Override
    public String toString() {
        return "EmployeeDetailsModel{" +
                "tierElement='" + tierElement + '\'' +
                ", benefitCategory='" + benefitCategory + '\'' +
                ", base='" + base + '\'' +
                ", deductibleCredit='" + deductibleCredit + '\'' +
                ", deductibleUtil='" + deductibleUtil + '\'' +
                ", ageFactor='" + ageFactor + '\'' +
                ", copay='" + copay + '\'' +
                ", claimsRate='" + claimsRate + '\'' +
                ", rateCalc='" + rateCalc + '\'' +
                ", rateCalcWO='" + rateCalcWO + '\'' +
                '}';
    }
}
