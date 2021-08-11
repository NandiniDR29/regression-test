/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.ren.main.modules.claim;

import java.util.Objects;

public abstract class ClaimType {
    protected IClaim claim;
    protected String shortName;
    protected String fullName;

    public ClaimType(String shortName, String fullName, IClaim claim) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.claim = claim;
    }

    public String getName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getKey() {
        return claim.getClass().getSimpleName();
    }

    public IClaim get() {
        return claim;
    }


    @Override
    public boolean equals(Object anObject) {
        if (anObject == null) {
            return false;
        }
        if (!ClaimType.class.isAssignableFrom(anObject.getClass())) {
            return false;
        }
        if (!(anObject instanceof ClaimType)) {
            return false;
        }
        ClaimType claimType = (ClaimType) anObject;
        if ((this.shortName == null) ? (claimType.getShortName() != null) : !this.shortName.equals(claimType.getShortName())) {
            return false;
        }
        return (this.fullName == null) ? (claimType.getName() == null) : this.fullName.equals(claimType.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(claim, shortName, fullName);
    }
}