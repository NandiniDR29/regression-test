/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package com.exigen.ren.main.modules.policy.gb_tl.certificate.actions;

import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.policy.common.actions.certificate.CertificatePolicyDataGatherAction;
import com.exigen.ren.main.modules.policy.gb_tl.certificate.tabs.CertificatePolicyTab;
import com.exigen.ren.main.modules.policy.gb_tl.certificate.tabs.CoveragesTab;
import com.exigen.ren.main.modules.policy.gb_tl.certificate.tabs.InsuredTab;
import com.exigen.ren.main.modules.policy.gb_tl.certificate.tabs.PremiumSummaryTab;

public class TermLifeInsuranceCertificatePolicyDataGatherAction extends CertificatePolicyDataGatherAction {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(CertificatePolicyTab.class)
            .registerTab(InsuredTab.class)
            .registerTab(CoveragesTab.class)
            .registerTab(PremiumSummaryTab.class)
            .build();

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }
}
