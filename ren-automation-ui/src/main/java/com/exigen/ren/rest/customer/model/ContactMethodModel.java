/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.customer.model;

import com.exigen.ren.rest.model.RestError;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ContactMethodModel extends RestError {

    private Integer id; //for all
    private String contactMethod;// for all
    private String contactType; // for all
    private String preferredInd; // for all
    private Boolean doNotSolicitInd; // for all
    private String comment; // for all
    private List<String> communicationPreferences;

    public ContactMethodModel() {
    }

    public ContactMethodModel(ContactMethodModel contactMethodModel) {
        this.id = contactMethodModel.getId();
        this.contactMethod = contactMethodModel.getContactMethod();
        this.contactType = contactMethodModel.getContactType();
        this.preferredInd = contactMethodModel.getPreferredInd();
        this.doNotSolicitInd = contactMethodModel.getDoNotSolicitInd();
        this.comment = contactMethodModel.getComment();
        this.communicationPreferences = contactMethodModel.getCommunicationPreferences();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContactMethod() {
        return contactMethod;
    }

    public ContactMethodModel setContactMethod(Type contactMethod) {
        this.contactMethod = contactMethod.name();
        return this;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getPreferredInd() {
        return preferredInd;
    }

    public void setPreferredInd(String preferredInd) {
        this.preferredInd = preferredInd;
    }

    public Boolean getDoNotSolicitInd() {
        return doNotSolicitInd;
    }

    public void setDoNotSolicitInd(Boolean doNotSolicitInd) {
        this.doNotSolicitInd = doNotSolicitInd;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

        if (!(o instanceof RestError)) {
            return false;
        }

        if (getErrorCode() != null) {
            return super.equals(o);
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        ContactMethodModel that = (ContactMethodModel) o;

        if (contactMethod != null ? !contactMethod.equals(that.contactMethod) : that.contactMethod != null) {
            return false;
        }
        if (contactType != null ? !contactType.equals(that.contactType) : that.contactType != null) {
            return false;
        }
        if (preferredInd != null ? !preferredInd.equals(that.preferredInd) : that.preferredInd != null) {
            return false;
        }
        if (doNotSolicitInd != null ? !doNotSolicitInd.equals(that.doNotSolicitInd) : that.doNotSolicitInd != null) {
            return false;
        }
        if (communicationPreferences != null ? !communicationPreferences.containsAll(that.communicationPreferences) : that.communicationPreferences != null) {
            return false;
        }
        return comment != null ? comment.equals(that.comment) : that.comment == null;
    }

    @Override
    public int hashCode() {
        int result = contactMethod != null ? contactMethod.hashCode() : 0;
        result = 31 * result + (contactType != null ? contactType.hashCode() : 0);
        result = 31 * result + (preferredInd != null ? preferredInd.hashCode() : 0);
        result = 31 * result + (doNotSolicitInd != null ? doNotSolicitInd.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (communicationPreferences != null ? communicationPreferences.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactMethod{" +
                "id(Excluded from equals)='" + id + '\'' +
                ", contactMethod='" + contactMethod + '\'' +
                ", contactType='" + contactType + '\'' +
                ", preferredInd='" + preferredInd + '\'' +
                ", doNotSolicitInd='" + doNotSolicitInd + '\'' +
                ", comment='" + comment + '\'' +
                ", communicationPreferences=" + communicationPreferences +
                '}';
    }

    public enum Type {CHAT, WEB_ADDRESS, PHONE, ADDRESS, SOCIAL_NET, EMAIL}
}
