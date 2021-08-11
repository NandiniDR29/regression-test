package com.exigen.ren.rest.claim.model.common.claimbody.claim;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.List;
import java.util.Objects;

public class ServiceModel extends Model {

    private String effectiveDt;
    private String expirationDt;
    private String transactionEffectiveDate;
    private String countryCd;
    private String riskStateCd;
    private String policyStatusCd;
    private String planName;
    private String planEffectiveDt;
    private String coverageTier;
    private List<ParticipantModel> participants;
    private MasterPolicyDetailsModel masterPolicyDetails;

    public String getEffectiveDt() {
        return effectiveDt;
    }

    public void setEffectiveDt(String effectiveDt) {
        this.effectiveDt = effectiveDt;
    }

    public String getExpirationDt() {
        return expirationDt;
    }

    public void setExpirationDt(String expirationDt) {
        this.expirationDt = expirationDt;
    }

    public String getTransactionEffectiveDate() {
        return transactionEffectiveDate;
    }

    public void setTransactionEffectiveDate(String transactionEffectiveDate) {
        this.transactionEffectiveDate = transactionEffectiveDate;
    }

    public String getCountryCd() {
        return countryCd;
    }

    public void setCountryCd(String countryCd) {
        this.countryCd = countryCd;
    }

    public String getRiskStateCd() {
        return riskStateCd;
    }

    public void setRiskStateCd(String riskStateCd) {
        this.riskStateCd = riskStateCd;
    }

    public String getPolicyStatusCd() {
        return policyStatusCd;
    }

    public void setPolicyStatusCd(String policyStatusCd) {
        this.policyStatusCd = policyStatusCd;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanEffectiveDt() {
        return planEffectiveDt;
    }

    public void setPlanEffectiveDt(String planEffectiveDt) {
        this.planEffectiveDt = planEffectiveDt;
    }

    public String getCoverageTier() {
        return coverageTier;
    }

    public void setCoverageTier(String coverageTier) {
        this.coverageTier = coverageTier;
    }

    public List<ParticipantModel> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantModel> participants) {
        this.participants = participants;
    }

    public MasterPolicyDetailsModel getMasterPolicyDetails() {
        return masterPolicyDetails;
    }

    public void setMasterPolicyDetails(MasterPolicyDetailsModel masterPolicyDetails) {
        this.masterPolicyDetails = masterPolicyDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ServiceModel that = (ServiceModel) o;
        return Objects.equals(effectiveDt, that.effectiveDt) &&
                Objects.equals(expirationDt, that.expirationDt) &&
                Objects.equals(transactionEffectiveDate, that.transactionEffectiveDate) &&
                Objects.equals(countryCd, that.countryCd) &&
                Objects.equals(riskStateCd, that.riskStateCd) &&
                Objects.equals(policyStatusCd, that.policyStatusCd) &&
                Objects.equals(planName, that.planName) &&
                Objects.equals(planEffectiveDt, that.planEffectiveDt) &&
                Objects.equals(coverageTier, that.coverageTier) &&
                Objects.equals(participants, that.participants) &&
                Objects.equals(masterPolicyDetails, that.masterPolicyDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), effectiveDt, expirationDt, transactionEffectiveDate, countryCd, riskStateCd, policyStatusCd, planName, planEffectiveDt, coverageTier, participants, masterPolicyDetails);
    }
}
