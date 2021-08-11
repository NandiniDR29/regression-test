package com.exigen.ren.rest.policyBenefits.enrollmentServices.models.enrollmentCensusRecordsModels;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoveragesModel extends Model {
    private ParticipantsModel participants;
    private String benefitAmount;
    private String coverageCd;
    private String planCd;
    private CoverageTierCdModel coverageTierCd;
    private String enrollmentDt;

    public ParticipantsModel getParticipants() {
        return participants;
    }

    public void setParticipants(ParticipantsModel participants) {
        this.participants = participants;
    }

    public String getBenefitAmount() {
        return benefitAmount;
    }

    public void setBenefitAmount(String benefitAmount) {
        this.benefitAmount = benefitAmount;
    }

    public String getCoverageCd() {
        return coverageCd;
    }

    public void setCoverageCd(String coverageCd) {
        this.coverageCd = coverageCd;
    }

    public String getPlanCd() {
        return planCd;
    }

    public void setPlanCd(String planCd) {
        this.planCd = planCd;
    }

    public CoverageTierCdModel getCoverageTierCd() {
        return coverageTierCd;
    }

    public void setCoverageTierCd(CoverageTierCdModel coverageTierCd) {
        this.coverageTierCd = coverageTierCd;
    }

    public String getEnrollmentDt() {
        return enrollmentDt;
    }

    public void setEnrollmentDt(String enrollmentDt) {
        this.enrollmentDt = enrollmentDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        CoveragesModel that = (CoveragesModel) o;
        return Objects.equals(participants, that.participants) &&
                Objects.equals(benefitAmount, that.benefitAmount) &&
                Objects.equals(coverageCd, that.coverageCd) &&
                Objects.equals(planCd, that.planCd) &&
                Objects.equals(coverageTierCd, that.coverageTierCd) &&
                Objects.equals(enrollmentDt, that.enrollmentDt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), participants, benefitAmount, coverageCd, planCd, coverageTierCd, enrollmentDt);
    }
}
