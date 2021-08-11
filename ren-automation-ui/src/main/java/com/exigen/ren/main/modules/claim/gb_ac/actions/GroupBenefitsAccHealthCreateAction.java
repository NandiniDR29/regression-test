/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.gb_ac.actions;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.claim.common.tabs.*;
import com.exigen.ren.main.modules.claim.gb_ac.tabs.BenefitCoverageEvaluationTab;
import com.exigen.ren.main.modules.claim.gb_ac.tabs.BenefitPremiumWaiverIncidentTab;
import com.exigen.ren.main.modules.claim.gb_ac.tabs.BenefitPremiumWaiverInjuryPartyInformationTab;

public class GroupBenefitsAccHealthCreateAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(ReportingPartyAndClaimContactTab.class)
            .registerTab(PolicyInformationPolicyTab.class)
            .registerTab(PolicyInformationParticipantParticipantInformationTab.class)
            .registerTab(PolicyInformationParticipantParticipantCoverageTab.class)
            .registerTab(PolicyInformationDependentDependentInformationTab.class)
            .registerTab(PolicyInformationDependentDependentCoverageTab.class)
            .registerTab(PolicyInformationScheduledItemTab.class)
            .registerTab(PolicyInformationSponsorTab.class)
            .registerTab(EventInformationLossEventTab.class)
            .registerTab(EventInformationAuthorityReportTab.class)
            .registerTab(BenefitsBenefitSummaryTab.class)
            .registerTab(BenefitsAccidentalDeathDecedentTab.class)
            .registerTab(BenefitsAccidentalDeathIncidentTab.class)
            .registerTab(BenefitsAccidentalDeathDeathCertificateTab.class)
            .registerTab(BenefitsAccidentalDeathBeneficiaryTab.class)
            .registerTab(BenefitsAccidentalDismembermentInjuryPartyInformationTab.class)
            .registerTab(BenefitsAccidentalDismembermentIncidentTab.class)
            .registerTab(BenefitsCriticalIllnessInjuryPartyInformationTab.class)
            .registerTab(BenefitsCriticalIllnessIncidentTab.class)
            .registerTab(BenefitsDiagnosisAndTreatmentInjuryPartyInformationTab.class)
            .registerTab(BenefitsDiagnosisAndTreatmentIncidentTab.class)
            .registerTab(BenefitPremiumWaiverInjuryPartyInformationTab.class)
            .registerTab(BenefitPremiumWaiverIncidentTab.class)
            .registerTab(BenefitCoverageEvaluationTab.class)
            .registerTab(AdditionalPartiesWitnessTab.class)
            .registerTab(AdditionalPartiesAdditionalPartyTab.class)
            .registerTab(ClaimCoordinationAdditionalInsuranceTab.class)
            .registerTab(ClaimCoordinationRelatedClaimsTab.class)
            .registerTab(EAPServicesServiceRequestTab.class)
            .registerTab(ClaimHandlingClaimFileOwnerTab.class)
            .registerTab(ClaimHandlingSpecialHandlingTab.class)
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
