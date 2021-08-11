/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.gb_dn.actions;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.claim.common.tabs.*;
import com.exigen.ren.main.modules.claim.gb_dn.tabs.*;

public class IndBenefitsDentalCreateAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(PolicyInformationPolicyTab.class)
            .registerTab(PolicyInformationInsurableRiskRiskPartyTab.class)
            .registerTab(PolicyInformationPartiesInsuredTab.class)
            .registerTab(TreatmentInformationTreatmentDetailsTab.class)
            .registerTab(TreatmentInformationServiceProviderTab.class)
            .registerTab(BenefitPatientTab.class)
            .registerTab(BenefitBenefitDetailsTab.class)
            .registerTab(ClaimHandlingClaimFileOwnerTab.class)
            .registerTab(ClaimHandlingSpecialHandlingTab.class)
            .registerTab(IntakeInformationTab.class)
            .registerTab(CompleteNotificationTab.class)
            .build();

    @Override
    public String getName() {
        return "Data Gather";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

}
