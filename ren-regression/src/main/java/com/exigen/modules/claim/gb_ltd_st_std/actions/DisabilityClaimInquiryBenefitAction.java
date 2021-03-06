/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.gb_ltd_st_std.actions;

import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.claim.common.actions.InquiryBenefitAction;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.actions.DisabilityClaimAddBenefitAction;

public class DisabilityClaimInquiryBenefitAction extends InquiryBenefitAction {
    @Override
    public Workspace getWorkspace() {
        return AutomationContext.getAction(DisabilityClaimAddBenefitAction.class).getWorkspace();
    }

}
