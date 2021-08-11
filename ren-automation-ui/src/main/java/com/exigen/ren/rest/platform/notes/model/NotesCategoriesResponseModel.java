/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.platform.notes.model;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotesCategoriesResponseModel extends RestError implements Comparable<NotesCategoriesResponseModel> {

    private String entityType;
    private String categoryCd;
    private String category;
    private String defaultTitle;
    private String defaultText;

    public NotesCategoriesResponseModel() {
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getCategoryCd() {
        return categoryCd;
    }

    public void setCategoryCd(String categoryCd) {
        this.categoryCd = categoryCd;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDefaultTitle() {
        return defaultTitle;
    }

    public void setDefaultTitle(String defaultTitle) {
        this.defaultTitle = defaultTitle;
    }

    public String getDefaultText() {
        return defaultText;
    }

    public void setDefaultText(String defaultText) {
        this.defaultText = defaultText;
    }

    @Override
    public String toString() {
        return "NotesCategoriesResponse{" +
                "entityType='" + entityType + '\'' +
                ", categoryCd='" + categoryCd + '\'' +
                ", category='" + category + '\'' +
                ", defaultTitle='" + defaultTitle + '\'' +
                ", defaultText='" + defaultText + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        if (!super.equals(o)) {return false;}

        NotesCategoriesResponseModel that = (NotesCategoriesResponseModel) o;

        if (!entityType.equals(that.entityType)) {return false;}
        if (!categoryCd.equals(that.categoryCd)) {return false;}
        if (!category.equals(that.category)) {return false;}
        if (!defaultTitle.equals(that.defaultTitle)) {return false;}
        return defaultText.equals(that.defaultText);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + entityType.hashCode();
        result = 31 * result + categoryCd.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + defaultTitle.hashCode();
        result = 31 * result + defaultText.hashCode();
        return result;
    }

    @Override
    public int compareTo(NotesCategoriesResponseModel o) {
        long currentId = null == this.getCategoryCd() ? 0 : Long.parseLong(this.getCategoryCd());
        long thatId = null == o.getCategoryCd() ? 0 : Long.parseLong(o.getCategoryCd());
        return (int) (currentId - thatId);
    }
}
