package com.exigen.ren.rest.claim.model.common.claimbody.claim;

import com.exigen.ipb.eisa.ws.rest.model.Model;


import java.util.Objects;

public class MasterPolicyDetailsCoverageDefinitionsModel extends Model {

    private String packageCd;
    private boolean procedureOverrideInd;
    private boolean selfAdministered;
    private boolean poPlanInd;
    private EligibilityModel eligibility;
    private PlanMaximumsModel planMaximums;
    private CoinsuranceModel coinsurance;
    private DeductibleModel deductible;
    private ImplantsModel implants;
    private OrthodontiaModel orthodontia;
    private ExclusionsModel exclusions;
    private PreventativeModel preventative;
    private MajorModel major ;

    public ExclusionsModel getExclusions() {
        return exclusions;
    }

    public void setExclusions(ExclusionsModel exclusions) {
        this.exclusions = exclusions;
    }

    public PreventativeModel getPreventative() {
        return preventative;
    }

    public void setPreventative(PreventativeModel preventative) {
        this.preventative = preventative;
    }

    public MajorModel getMajor() {
        return major;
    }

    public void setMajor(MajorModel major) {
        this.major = major;
    }

    public String getPackageCd() {
        return packageCd;
    }

    public void setPackageCd(String packageCd) {
        this.packageCd = packageCd;
    }

    public boolean isProcedureOverrideInd() {
        return procedureOverrideInd;
    }

    public void setProcedureOverrideInd(boolean procedureOverrideInd) {
        this.procedureOverrideInd = procedureOverrideInd;
    }

    public boolean isSelfAdministered() {
        return selfAdministered;
    }

    public void setSelfAdministered(boolean selfAdministered) {
        this.selfAdministered = selfAdministered;
    }

    public boolean isPoPlanInd() {
        return poPlanInd;
    }

    public void setPoPlanInd(boolean poPlanInd) {
        this.poPlanInd = poPlanInd;
    }

    public EligibilityModel getEligibility() {
        return eligibility;
    }

    public void setEligibility(EligibilityModel eligibility) {
        this.eligibility = eligibility;
    }

    public PlanMaximumsModel getPlanMaximums() {
        return planMaximums;
    }

    public void setPlanMaximums(PlanMaximumsModel planMaximums) {
        this.planMaximums = planMaximums;
    }

    public CoinsuranceModel getCoinsurance() {
        return coinsurance;
    }

    public void setCoinsurance(CoinsuranceModel coinsurance) {
        this.coinsurance = coinsurance;
    }

    public DeductibleModel getDeductible() {
        return deductible;
    }

    public void setDeductible(DeductibleModel deductible) {
        this.deductible = deductible;
    }

    public ImplantsModel getImplants() {
        return implants;
    }

    public void setImplants(ImplantsModel implants) {
        this.implants = implants;
    }

    public OrthodontiaModel getOrthodontia() {
        return orthodontia;
    }

    public void setOrthodontia(OrthodontiaModel orthodontia) {
        this.orthodontia = orthodontia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MasterPolicyDetailsCoverageDefinitionsModel)) return false;
        if (!super.equals(o)) return false;
        MasterPolicyDetailsCoverageDefinitionsModel that = (MasterPolicyDetailsCoverageDefinitionsModel) o;
        return procedureOverrideInd == that.procedureOverrideInd &&
                selfAdministered == that.selfAdministered &&
                poPlanInd == that.poPlanInd &&
                Objects.equals(packageCd, that.packageCd) &&
                Objects.equals(eligibility, that.eligibility) &&
                Objects.equals(planMaximums, that.planMaximums) &&
                Objects.equals(coinsurance, that.coinsurance) &&
                Objects.equals(deductible, that.deductible) &&
                Objects.equals(implants, that.implants) &&
                Objects.equals(orthodontia, that.orthodontia) &&
                Objects.equals(exclusions, that.exclusions) &&
                Objects.equals(preventative, that.preventative) &&
                Objects.equals(major, that.major);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), packageCd, procedureOverrideInd, selfAdministered, poPlanInd, eligibility, planMaximums, coinsurance, deductible, implants, orthodontia, exclusions, preventative, major);
    }
}
