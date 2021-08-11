/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.customer.model;

import com.exigen.istf.data.TestData;
import com.exigen.ren.main.modules.customer.metadata.GeneralTabMetaData;
import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.*;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactMethodSocialNetModel extends ContactMethodModel {

    private String socialNetId;
    private Type type;

    public ContactMethodSocialNetModel() {
    }

    public ContactMethodSocialNetModel(ContactMethodSocialNetModel contactMethod) {
        super(contactMethod);
    }

    public ContactMethodSocialNetModel(TestData data) {
        setContactMethod(ContactMethodModel.Type.SOCIAL_NET);
        setContactTypeByLabel(data.getValue("Social Net Type"));
        setSocialNetId(data.getValue(GeneralTabMetaData.SocialNetDetailsMetaData.SOCIAL_NET_ID.getLabel()));
    }

    public String getSocialNetId() {
        return socialNetId;
    }

    public void setSocialNetId(String socialNetId) {
        this.socialNetId = socialNetId;
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

        ContactMethodSocialNetModel that = (ContactMethodSocialNetModel) o;

        return socialNetId != null ? socialNetId.equals(that.socialNetId) : that.socialNetId == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (socialNetId != null ? socialNetId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String parentToString = super.toString();
        return parentToString + "\nChildClass\nContactMethodSocialNet{" +
                "socialNetId='" + socialNetId + '\'' +
                '}';
    }

    @JsonIgnoreType
    private enum Type {
        FACEBOOK("Facebook", "FCB"), TWITTER("Twitter", "TWT"), LINKEDIN("LinkedIn", "LKD");

        private String label;
        private String value;

        Type(String label, String value) {
            this.label = label;
            this.value = value;
        }

        public String getUIName() {
            return label;
        }

        public String getValue() {
            return value;
        }

        public static Type getEntityByLabel(String label) {
            return Arrays.stream(Type.values()).filter(ent -> ent.getUIName().equals(label)).findFirst().orElse(null);
        }

        public static Type getEntityByValue(String value) {
            return Arrays.stream(Type.values()).filter(ent -> ent.getValue().equals(value)).findFirst().orElse(null);
        }
    }

    @JsonIgnore
    public String getUIContactType() {
        return type.getUIName();
    }

    @JsonGetter("contactType")
    public String getContactTypeJsonValue() {
        return type == null ? null : type.getValue();
    }

    public void setContactTypeByLabel(String value) {
        this.type = Type.getEntityByLabel(value);
    }

    @JsonSetter("contactType")
    public void setContactTypeByJsonValue(String value) {
        this.type = Type.getEntityByValue(value);
    }
}
