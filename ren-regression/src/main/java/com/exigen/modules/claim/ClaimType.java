/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.modules.claim;

import com.exigen.ren.main.modules.claim.IClaim;

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
        if (!com.exigen.ren.main.modules.claim.ClaimType.class.isAssignableFrom(anObject.getClass())) {
            return false;
        }
        if (!(anObject instanceof com.exigen.ren.main.modules.claim.ClaimType)) {
            return false;
        }
        com.exigen.ren.main.modules.claim.ClaimType claimType = (com.exigen.ren.main.modules.claim.ClaimType) anObject;
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