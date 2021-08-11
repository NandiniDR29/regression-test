package com.exigen.ren.rest.dxp.model;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileEmailModel extends RestError {

    private String email;
    private String id;
    private String emailTypeCd;
    private Boolean preferredInd;
    private List<String> communicationPreferences;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmailTypeCd() {
        return emailTypeCd;
    }

    public void setEmailTypeCd(String emailTypeCd) {
        this.emailTypeCd = emailTypeCd;
    }

    public Boolean getPreferredInd() {
        return preferredInd;
    }

    public void setPreferredInd(Boolean preferredInd) {
        this.preferredInd = preferredInd;
    }

    public List<String> getCommunicationPreferences() {
        return communicationPreferences;
    }

    public void setCommunicationPreferences(List<String> communicationPreferences) {
        this.communicationPreferences = communicationPreferences;
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
        ProfileEmailModel that = (ProfileEmailModel) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(id, that.id) &&
                Objects.equals(emailTypeCd, that.emailTypeCd) &&
                Objects.equals(preferredInd, that.preferredInd) &&
                Objects.equals(communicationPreferences, that.communicationPreferences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, id, emailTypeCd, preferredInd, communicationPreferences);
    }
}
