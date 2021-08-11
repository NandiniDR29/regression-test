/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.gb_ltd_st_std.actions;

import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.claim.common.actions.AddBenefitAction;
import com.exigen.ren.main.modules.claim.common.tabs.EAPServicesServiceRequestTab;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.tabs.*;

public class DisabilityClaimAddBenefitAction extends AddBenefitAction {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(BenefitSTDInjuryPartyInformationTab.class)
            .registerTab(BenefitSTDIncidentTab.class)
            .registerTab(BenefitLTDInjuryPartyInformationTab.class)
            .registerTab(BenefitLTDIncidentTab.class)
            .registerTab(BenefitStatutorySTDInjuryPartyInformationTab.class)
            .registerTab(BenefitStatutorySTDIncidentTab.class)
            .registerTab(BenefitsPFLParticipantInformationTab.class)
            .registerTab(BenefitsPFLQualifyingEventTab.class)
            .registerTab(BenefitCoverageDeterminationTab.class)
            .registerTab(BenefitCoverageEvaluationTab.class)
            .registerTab(EAPServicesServiceRequestTab.class)
            .build();

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }
}
