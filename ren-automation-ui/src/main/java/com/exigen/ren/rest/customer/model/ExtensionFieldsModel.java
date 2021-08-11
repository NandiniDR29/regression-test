/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.customer.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtensionFieldsModel extends Model {

    private OwnerModel owner;
    private String mailCardsTo;
    private String mailW2To;
    private Boolean electronicSSAFiling;

    public ExtensionFieldsModel() {
    }

    public ExtensionFieldsModel(OwnerModel owner) {
        this.owner = owner;
    }

    public ExtensionFieldsModel setOwner(OwnerModel owner) {
        this.owner = owner;
        return this;
    }

    public OwnerModel getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        if (!super.equals(o)) { return false; }
        ExtensionFieldsModel that = (ExtensionFieldsModel) o;
        return Objects.equals(owner, that.owner) &&
                Objects.equals(mailCardsTo, that.mailCardsTo) &&
                Objects.equals(mailW2To, that.mailW2To) &&
                Objects.equals(electronicSSAFiling, that.electronicSSAFiling);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), owner, mailCardsTo, mailW2To, electronicSSAFiling);
    }

    @Override
    public String toString() {
        return "extensionFields{" +
                "owner='" + owner + '\'' +
                "mailCardsTo='" + mailCardsTo + '\'' +
                "mailW2To='" + mailW2To + '\'' +
                "electronicSSAFiling='" + electronicSSAFiling + '\'' +
                '}';
    }

	public String getMailCardsTo() {
		return mailCardsTo;
	}

	public void setMailCardsTo(String mailCardsTo) {
		this.mailCardsTo = mailCardsTo;
	}

    public Boolean getElectronicSSAFiling() {
        return electronicSSAFiling;
    }

    public void setElectronicSSAFiling(Boolean electronicSSAFiling) {
        this.electronicSSAFiling = electronicSSAFiling;
    }

    public String getMailW2To() {
        return mailW2To;
    }

    public void setMailW2To(String mailW2To) {
        this.mailW2To = mailW2To;
    }
}
