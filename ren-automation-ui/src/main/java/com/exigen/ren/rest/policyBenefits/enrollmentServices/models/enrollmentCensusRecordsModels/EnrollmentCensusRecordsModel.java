package com.exigen.ren.rest.policyBenefits.enrollmentServices.models.enrollmentCensusRecordsModels;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentCensusRecordsModel extends Model {
    private String referenceID;
    private CertificateModel certificate;
    private AllParticipantsModel allParticipants;

    public String getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(String referenceID) {
        this.referenceID = referenceID;
    }

    public CertificateModel getCertificate() {
        return certificate;
    }

    public void setCertificate(CertificateModel certificate) {
        this.certificate = certificate;
    }

    public AllParticipantsModel getAllParticipants() {
        return allParticipants;
    }

    public void setAllParticipants(AllParticipantsModel allParticipants) {
        this.allParticipants = allParticipants;
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
        EnrollmentCensusRecordsModel that = (EnrollmentCensusRecordsModel) o;
        return Objects.equals(referenceID, that.referenceID) &&
                Objects.equals(certificate, that.certificate) &&
                Objects.equals(allParticipants, that.allParticipants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), referenceID, certificate, allParticipants);
    }
}
