package com.exigen.ren.rest.rating.model.gb_dn;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentByMSAModel extends Model {

    private String state;
    private String msa;
    private String numberOfLives;
    private String enrolledPct;
    private String ppoPenetration;
    private String ppoAreaFactor;
    private String indemnityAreaFactor;

    public String getState() {
        return state;
    }

    public EnrollmentByMSAModel setState(String state) {
        this.state = state;
        return this;
    }

    public String getMsa() {
        return msa;
    }

    public EnrollmentByMSAModel setMsa(String msa) {
        this.msa = msa;
        return this;
    }

    public String getNumberOfLives() {
        return numberOfLives;
    }

    public EnrollmentByMSAModel setNumberOfLives(String numberOfLives) {
        this.numberOfLives = numberOfLives;
        return this;
    }

    public String getEnrolledPct() {
        return enrolledPct;
    }

    public EnrollmentByMSAModel setEnrolledPct(String enrolledPct) {
        this.enrolledPct = enrolledPct;
        return this;
    }

    public String getPpoPenetration() {
        return ppoPenetration;
    }

    public EnrollmentByMSAModel setPpoPenetration(String ppoPenetration) {
        this.ppoPenetration = ppoPenetration;
        return this;
    }

    public String getPpoAreaFactor() {
        return ppoAreaFactor;
    }

    public EnrollmentByMSAModel setPpoAreaFactor(String ppoAreaFactor) {
        this.ppoAreaFactor = ppoAreaFactor;
        return this;
    }

    public String getIndemnityAreaFactor() {
        return indemnityAreaFactor;
    }

    public EnrollmentByMSAModel setIndemnityAreaFactor(String indemnityAreaFactor) {
        this.indemnityAreaFactor = indemnityAreaFactor;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EnrollmentByMSAModel)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        EnrollmentByMSAModel that = (EnrollmentByMSAModel) o;
        return Objects.equals(state, that.state) &&
                Objects.equals(msa, that.msa) &&
                Objects.equals(numberOfLives, that.numberOfLives) &&
                Objects.equals(enrolledPct, that.enrolledPct) &&
                Objects.equals(ppoPenetration, that.ppoPenetration) &&
                Objects.equals(ppoAreaFactor, that.ppoAreaFactor) &&
                Objects.equals(indemnityAreaFactor, that.indemnityAreaFactor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), state, msa, numberOfLives, enrolledPct, ppoPenetration, ppoAreaFactor, indemnityAreaFactor);
    }

    @Override
    public String toString() {
        return "EnrollmentByMSAModel{" +
                "state='" + state + '\'' +
                ", msa='" + msa + '\'' +
                ", numberOfLives='" + numberOfLives + '\'' +
                ", enrolledPct='" + enrolledPct + '\'' +
                ", ppoPenetration='" + ppoPenetration + '\'' +
                ", ppoAreaFactor='" + ppoAreaFactor + '\'' +
                ", indemnityAreaFactor='" + indemnityAreaFactor + '\'' +
                '}';
    }
}
