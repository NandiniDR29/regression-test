/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.modules.policy.gb_pfl.masterpolicy.actions;

import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.policy.common.actions.common.InquiryAction;

public class PaidFamilyLeavePolicyMasterInquiryAction extends InquiryAction {

    @Override
    public Workspace getWorkspace() {
        return AutomationContext.getAction(PaidFamilyLeaveMasterPolicyDataGatherAction.class).getWorkspace();
    }

}
