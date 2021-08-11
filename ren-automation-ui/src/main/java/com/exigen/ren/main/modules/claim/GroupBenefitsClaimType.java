/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.ren.main.modules.claim;

import com.exigen.ren.main.modules.claim.gb_ac.AccidentHealthClaim;
import com.exigen.ren.main.modules.claim.gb_dn.DentalClaim;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.DisabilityClaim;
import com.exigen.ren.main.modules.claim.gb_tl.TermLifeClaim;

public class GroupBenefitsClaimType extends ClaimType {
    public static final GroupBenefitsClaimType CLAIM_ACC_HEALTH_AC = new GroupBenefitsClaimType("GB_AC", "Accident & Health Claim", new AccidentHealthClaim());
    public static final GroupBenefitsClaimType CLAIM_DI_LTD = new GroupBenefitsClaimType("GB_LTD", "Disability Claim", new DisabilityClaim());
    public static final GroupBenefitsClaimType CLAIM_DI_STD = new GroupBenefitsClaimType("GB_STD", "Disability Claim", new DisabilityClaim());
    public static final GroupBenefitsClaimType CLAIM_DI_ST = new GroupBenefitsClaimType("GB_ST", "Disability Claim", new DisabilityClaim());
    public static final GroupBenefitsClaimType CLAIM_DI_PFL = new GroupBenefitsClaimType("GB_PFL", "Disability Claim", new DisabilityClaim());
    public static final GroupBenefitsClaimType CLAIM_TERM_LIFE = new GroupBenefitsClaimType("GB_TL", "Term Life Claim", new TermLifeClaim());
    public static final GroupBenefitsClaimType CLAIM_DENTAL = new GroupBenefitsClaimType("GB_DN", "Dental Claim", new DentalClaim());

    public GroupBenefitsClaimType(String shortName, String fullName, IClaim policy) {
        super(shortName, fullName, policy);
    }

    @Override
    public IClaim get() {
        return claim;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object anObject) {
        return super.equals(anObject);
    }
}
