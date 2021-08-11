/* Copyright © 2018 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.partysearch.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferencesModel extends Model {

    private EntityReferenceModel entityReference;
    private BobReferenceModel bobReference;
    private NavigationReferenceModel navigationReference;
    public void setEntityReference(EntityReferenceModel entityReference) {
        this.entityReference = entityReference;
    }
    public EntityReferenceModel getEntityReference() {
        return entityReference;
    }

    public void setBobReference(BobReferenceModel bobReference) {
        this.bobReference = bobReference;
    }
    public BobReferenceModel getBobReference() {
        return bobReference;
    }

    public void setNavigationReference(NavigationReferenceModel navigationReference) {
        this.navigationReference = navigationReference;
    }
    public NavigationReferenceModel getNavigationReference() {
        return navigationReference;
    }

}