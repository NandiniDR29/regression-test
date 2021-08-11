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
public class ContactMethodWebAddressModel extends ContactMethodModel {

    private String webAddress;
    private Type type;

    public ContactMethodWebAddressModel() {
    }

    public ContactMethodWebAddressModel(ContactMethodWebAddressModel contactMethod) {
        super(contactMethod);
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public ContactMethodWebAddressModel(TestData data) {
        setContactMethod(ContactMethodModel.Type.WEB_ADDRESS);
        setContactTypeByLabel(data.getValue("Web URL Type"));
        setWebAddress(data.getValue(GeneralTabMetaData.WebUrlDetailsMetaData.WEB_URL.getLabel()));
        setComment(data.getValue("Comment"));
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

        ContactMethodWebAddressModel that = (ContactMethodWebAddressModel) o;

        return webAddress != null ? webAddress.equals(that.webAddress) : that.webAddress == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (webAddress != null ? webAddress.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String parentToString = super.toString();
        return parentToString + "\nChildClass\nContactMethodWebAddress{" +
                "webAddress='" + webAddress + '\'' +
                '}';
    }

    @JsonGetter("contactType")
    public String getContactTypeJsonValue() {
        return type == null ? null : type.getValue();
    }

    @JsonSetter("contactType")
    public void setContactTypeByJsonValue(String type) {
        this.type = Type.getEntityByValue(type);
    }

    public void setContactTypeByLabel(String type) {
        this.type = Type.getEntityByLabel(type);
    }

    @JsonIgnoreType
    private enum Type {
        PERSONAL("Personal", "PERS"), CORPORATE("Corporate", "CORPORATE");

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
}
