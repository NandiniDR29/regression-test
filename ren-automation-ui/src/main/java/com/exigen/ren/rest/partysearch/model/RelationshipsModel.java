/* Copyright © 2018 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.partysearch.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;

public class RelationshipsModel extends Model {

    private String relatedObjectId;
    private String relationshipRole;
    public void setRelatedObjectId(String relatedObjectId) {
        this.relatedObjectId = relatedObjectId;
    }
    public String getRelatedObjectId() {
        return relatedObjectId;
    }

    public void setRelationshipRole(String relationshipRole) {
        this.relationshipRole = relationshipRole;
    }
    public String getRelationshipRole() {
        return relationshipRole;
    }

}
