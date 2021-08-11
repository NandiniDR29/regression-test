package com.exigen.ren.rest.policyBenefits.enrollmentServices.models.enrollmentCensusRecordsModels;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrimaryParticipantModel extends Model {
    private String personOID;
    private RelationshipModel relationship;

    public String getPersonOID() {
        return personOID;
    }

    public void setPersonOID(String personOID) {
        this.personOID = personOID;
    }

    public RelationshipModel getRelationship() {
        return relationship;
    }

    public void setRelationship(RelationshipModel relationship) {
        this.relationship = relationship;
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
        PrimaryParticipantModel that = (PrimaryParticipantModel) o;
        return Objects.equals(personOID, that.personOID) &&
                Objects.equals(relationship, that.relationship);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), personOID, relationship);
    }
}
