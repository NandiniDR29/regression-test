package com.exigen.ren.rest.policyBenefits.enrollmentServices.models.enrollmentCensusRecordsModels;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelationshipModel extends Model {
    private EmploymentModel employment;
    private ClassificationGroupModel classificationGroup;

    public EmploymentModel getEmployment() {
        return employment;
    }

    public void setEmployment(EmploymentModel employment) {
        this.employment = employment;
    }

    public ClassificationGroupModel getClassificationGroup() {
        return classificationGroup;
    }

    public void setClassificationGroup(ClassificationGroupModel classificationGroup) {
        this.classificationGroup = classificationGroup;
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
        RelationshipModel that = (RelationshipModel) o;
        return Objects.equals(employment, that.employment) &&
                Objects.equals(classificationGroup, that.classificationGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), employment, classificationGroup);
    }
}
