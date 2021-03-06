/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.gb_ac.actions;

import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.claim.common.actions.ClaimUpdateAction;
import com.exigen.ren.main.modules.claim.common.tabs.*;

public class GroupBenefitsAccHealthUpdateClaimAction extends ClaimUpdateAction {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(ReportingPartyAndClaimContactActionTab.class)
            .registerTab(PolicyInformationPolicyActionTab.class)
            .registerTab(PolicyInformationParticipantParticipantInformationActionTab.class)
            .registerTab(PolicyInformationParticipantParticipantCoverageActionTab.class)
            .registerTab(PolicyInformationDependentDependentInformationActionTab.class)
            .registerTab(PolicyInformationDependentDependentCoverageActionTab.class)
            .registerTab(PolicyInformationScheduledItemActionTab.class)
            .registerTab(PolicyInformationSponsorActionTab.class)
            .registerTab(EventInformationLossEventActionTab.class)
            .registerTab(EventInformationAuthorityReportActionTab.class)
            .registerTab(AdditionalPartiesWitnessActionTab.class)
            .registerTab(AdditionalPartiesAdditionalPartyActionTab.class)
            .registerTab(ClaimCoordinationAdditionalInsuranceActionTab.class)
            .registerTab(ClaimCoordinationRelatedClaimsActionTab.class)
            .registerTab(EAPServicesServiceRequestActionTab.class)
            .registerTab(ClaimHandlingClaimFileOwnerActionTab.class)
            .registerTab(ClaimHandlingSpecialHandlingActionTab.class)
            .build();

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

}
