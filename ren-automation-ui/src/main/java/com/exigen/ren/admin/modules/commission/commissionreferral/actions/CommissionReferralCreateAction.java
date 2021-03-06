/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.commission.commissionreferral.actions;

import com.exigen.ren.admin.modules.commission.commissionreferral.tabs.CommissionReferralTab;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;

public class CommissionReferralCreateAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(CommissionReferralTab.class)
            .build();

    @Override
    public String getName() {
        return "Create Commission Referral";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }
}
