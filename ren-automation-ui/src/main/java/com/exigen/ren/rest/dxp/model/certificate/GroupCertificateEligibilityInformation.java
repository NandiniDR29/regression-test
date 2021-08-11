package com.exigen.ren.rest.dxp.model.certificate;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupCertificateEligibilityInformation extends RestError {

    private String classificationGroupName;
    private String classificationGroup;

    public String getClassificationGroupName() {
        return classificationGroupName;
    }

    public void setClassificationGroupName(String classificationGroupName) {
        this.classificationGroupName = classificationGroupName;
    }

    public String getClassificationGroup() {
        return classificationGroup;
    }

    public void setClassificationGroup(String classificationGroup) {
        this.classificationGroup = classificationGroup;
    }
}