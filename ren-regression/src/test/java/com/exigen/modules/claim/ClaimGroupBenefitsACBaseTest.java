/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.claim;

import com.exigen.ren.main.modules.claim.GroupBenefitsClaimType;
import com.exigen.ren.main.modules.claim.gb_ac.AccidentHealthClaimACContext;
import com.exigen.ren.main.modules.policy.gb_ac.certificate.GroupAccidentCertificatePolicyContext;
import com.exigen.ren.main.modules.policy.gb_ac.masterpolicy.GroupAccidentMasterPolicyContext;

public class ClaimGroupBenefitsACBaseTest extends ClaimGroupBenefitsBaseTest implements GroupAccidentMasterPolicyContext, GroupAccidentCertificatePolicyContext, AccidentHealthClaimACContext {

    protected GroupBenefitsClaimType getClaimType() {
        return GroupBenefitsClaimType.CLAIM_ACC_HEALTH_AC;
    }

}
