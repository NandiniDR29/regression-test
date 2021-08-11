package com.exigen.ren.rest.claim.model.common.claimbody.claim;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.Objects;

public class EligibilityModel extends Model {
    private String minHourlyReq;
    private String preventiveWaitingPeriod;
    private String basicWaitingPeriod;
    private String majorWaitingPeriod;
    private String newEmployeeWaitingPeriod;
    private String newEmployeeWaitingPeriodInteger;
    private String newEmployeeWaitingPeriodMode;
    private String dependentMaxAge;
    private String studentMinAge;
    private String studentMaxAge;
    private String disabledDependents;
    private String waitingPeriodWaived;
    private String endOnBenefits;
    private String benefitPeriodBasedOnMasterPolicy;

    public String getMinHourlyReq() {
        return minHourlyReq;
    }

    public void setMinHourlyReq(String minHourlyReq) {
        this.minHourlyReq = minHourlyReq;
    }

    public String getPreventiveWaitingPeriod() {
        return preventiveWaitingPeriod;
    }

    public void setPreventiveWaitingPeriod(String preventiveWaitingPeriod) {
        this.preventiveWaitingPeriod = preventiveWaitingPeriod;
    }

    public String getBasicWaitingPeriod() {
        return basicWaitingPeriod;
    }

    public void setBasicWaitingPeriod(String basicWaitingPeriod) {
        this.basicWaitingPeriod = basicWaitingPeriod;
    }

    public String getMajorWaitingPeriod() {
        return majorWaitingPeriod;
    }

    public void setMajorWaitingPeriod(String majorWaitingPeriod) {
        this.majorWaitingPeriod = majorWaitingPeriod;
    }

    public String getNewEmployeeWaitingPeriod() {
        return newEmployeeWaitingPeriod;
    }

    public void setNewEmployeeWaitingPeriod(String newEmployeeWaitingPeriod) {
        this.newEmployeeWaitingPeriod = newEmployeeWaitingPeriod;
    }

    public String getNewEmployeeWaitingPeriodInteger() {
        return newEmployeeWaitingPeriodInteger;
    }

    public void setNewEmployeeWaitingPeriodInteger(String newEmployeeWaitingPeriodInteger) {
        this.newEmployeeWaitingPeriodInteger = newEmployeeWaitingPeriodInteger;
    }

    public String getNewEmployeeWaitingPeriodMode() {
        return newEmployeeWaitingPeriodMode;
    }

    public void setNewEmployeeWaitingPeriodMode(String newEmployeeWaitingPeriodMode) {
        this.newEmployeeWaitingPeriodMode = newEmployeeWaitingPeriodMode;
    }

    public String getDependentMaxAge() {
        return dependentMaxAge;
    }

    public void setDependentMaxAge(String dependentMaxAge) {
        this.dependentMaxAge = dependentMaxAge;
    }

    public String getStudentMinAge() {
        return studentMinAge;
    }

    public void setStudentMinAge(String studentMinAge) {
        this.studentMinAge = studentMinAge;
    }

    public String getStudentMaxAge() {
        return studentMaxAge;
    }

    public void setStudentMaxAge(String studentMaxAge) {
        this.studentMaxAge = studentMaxAge;
    }

    public String getDisabledDependents() {
        return disabledDependents;
    }

    public void setDisabledDependents(String disabledDependents) {
        this.disabledDependents = disabledDependents;
    }

    public String getWaitingPeriodWaived() {
        return waitingPeriodWaived;
    }

    public void setWaitingPeriodWaived(String waitingPeriodWaived) {
        this.waitingPeriodWaived = waitingPeriodWaived;
    }

    public String getEndOnBenefits() {
        return endOnBenefits;
    }

    public void setEndOnBenefits(String endOnBenefits) {
        this.endOnBenefits = endOnBenefits;
    }

    public String getBenefitPeriodBasedOnMasterPolicy() {
        return benefitPeriodBasedOnMasterPolicy;
    }

    public void setBenefitPeriodBasedOnMasterPolicy(String benefitPeriodBasedOnMasterPolicy) {
        this.benefitPeriodBasedOnMasterPolicy = benefitPeriodBasedOnMasterPolicy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EligibilityModel that = (EligibilityModel) o;
        return Objects.equals(minHourlyReq, that.minHourlyReq) &&
                Objects.equals(preventiveWaitingPeriod, that.preventiveWaitingPeriod) &&
                Objects.equals(basicWaitingPeriod, that.basicWaitingPeriod) &&
                Objects.equals(majorWaitingPeriod, that.majorWaitingPeriod) &&
                Objects.equals(newEmployeeWaitingPeriod, that.newEmployeeWaitingPeriod) &&
                Objects.equals(newEmployeeWaitingPeriodInteger, that.newEmployeeWaitingPeriodInteger) &&
                Objects.equals(newEmployeeWaitingPeriodMode, that.newEmployeeWaitingPeriodMode) &&
                Objects.equals(dependentMaxAge, that.dependentMaxAge) &&
                Objects.equals(studentMinAge, that.studentMinAge) &&
                Objects.equals(studentMaxAge, that.studentMaxAge) &&
                Objects.equals(disabledDependents, that.disabledDependents) &&
                Objects.equals(waitingPeriodWaived, that.waitingPeriodWaived) &&
                Objects.equals(endOnBenefits, that.endOnBenefits) &&
                Objects.equals(benefitPeriodBasedOnMasterPolicy, that.benefitPeriodBasedOnMasterPolicy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), minHourlyReq, preventiveWaitingPeriod, basicWaitingPeriod, majorWaitingPeriod, newEmployeeWaitingPeriod, newEmployeeWaitingPeriodInteger, newEmployeeWaitingPeriodMode, dependentMaxAge, studentMinAge, studentMaxAge, disabledDependents, waitingPeriodWaived, endOnBenefits, benefitPeriodBasedOnMasterPolicy);
    }
}
