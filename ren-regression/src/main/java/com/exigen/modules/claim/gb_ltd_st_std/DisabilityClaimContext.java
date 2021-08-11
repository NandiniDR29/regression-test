/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.gb_ltd_st_std;

import com.exigen.istf.data.TestData;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.claim.common.tabs.*;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.DisabilityClaim;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.tabs.*;


public interface DisabilityClaimContext {
    DisabilityClaim disabilityClaim = AutomationContext.getService(DisabilityClaim.class);
    ReportingPartyAndClaimContactTab reportingPartyAndClaimContactTab = disabilityClaim.getDefaultWorkspace().getTab(ReportingPartyAndClaimContactTab.class);
    PolicyInformationPolicyTab policyInformationPolicyTab = disabilityClaim.getDefaultWorkspace().getTab(PolicyInformationPolicyTab.class);
    PolicyInformationParticipantParticipantInformationTab policyInformationParticipantParticipantInformationTab = disabilityClaim.getDefaultWorkspace().getTab(PolicyInformationParticipantParticipantInformationTab.class);
    PolicyInformationParticipantParticipantCoverageTab policyInformationParticipantParticipantCoverageTab = disabilityClaim.getDefaultWorkspace().getTab(PolicyInformationParticipantParticipantCoverageTab.class);
    PolicyInformationDependentDependentInformationTab policyInformationDependentDependentInformationTab = disabilityClaim.getDefaultWorkspace().getTab(PolicyInformationDependentDependentInformationTab.class);
    PolicyInformationDependentDependentCoverageTab policyInformationDependentDependentCoverageTab = disabilityClaim.getDefaultWorkspace().getTab(PolicyInformationDependentDependentCoverageTab.class);
    PolicyInformationScheduledItemTab policyInformationScheduledItemTab = disabilityClaim.getDefaultWorkspace().getTab(PolicyInformationScheduledItemTab.class);
    PolicyInformationSponsorTab policyInformationSponsorTab = disabilityClaim.getDefaultWorkspace().getTab(PolicyInformationSponsorTab.class);
    EventInformationLossEventTab eventInformationLossEventTab = disabilityClaim.getDefaultWorkspace().getTab(EventInformationLossEventTab.class);
    EventInformationAuthorityReportTab eventInformationAuthorityReportTab = disabilityClaim.getDefaultWorkspace().getTab(EventInformationAuthorityReportTab.class);
    BenefitsBenefitSummaryTab benefitsBenefitSummaryTab = disabilityClaim.getDefaultWorkspace().getTab(BenefitsBenefitSummaryTab.class);
    BenefitsLTDInjuryPartyInformationTab benefitsLTDInjuryPartyInformationTab = disabilityClaim.getDefaultWorkspace().getTab(BenefitsLTDInjuryPartyInformationTab.class);
    BenefitsLTDIncidentTab benefitsLTDIncidentTab = disabilityClaim.getDefaultWorkspace().getTab(BenefitsLTDIncidentTab.class);
    BenefitsSTDInjuryPartyInformationTab benefitsSTDInjuryPartyInformationTab = disabilityClaim.getDefaultWorkspace().getTab(BenefitsSTDInjuryPartyInformationTab.class);
    BenefitsSTDIncidentTab benefitsSTDIncidentTab = disabilityClaim.getDefaultWorkspace().getTab(BenefitsSTDIncidentTab.class);
    BenefitsStatutorySTDInjuryPartyInformationTab benefitsStatutorySTDInjuryPartyInformationTab = disabilityClaim.getDefaultWorkspace().getTab(BenefitsStatutorySTDInjuryPartyInformationTab.class);
    BenefitsStatutorySTDIncidentTab benefitsStatutorySTDIncidentTab = disabilityClaim.getDefaultWorkspace().getTab(BenefitsStatutorySTDIncidentTab.class);
    BenefitsPFLParticipantInformationTab benefitsPflParticipantInformationTab = disabilityClaim.getDefaultWorkspace().getTab(BenefitsPFLParticipantInformationTab.class);
    BenefitsPFLQualifyingEventTab benefitsPflQualifyingEventTab = disabilityClaim.getDefaultWorkspace().getTab(BenefitsPFLQualifyingEventTab.class);
    BenefitCoverageDeterminationTab benefitCoverageDeterminationTab = disabilityClaim.getDefaultWorkspace().getTab(BenefitCoverageDeterminationTab.class);
    AdditionalPartiesWitnessTab additionalPartiesWitnessTab = disabilityClaim.getDefaultWorkspace().getTab(AdditionalPartiesWitnessTab.class);
    AdditionalPartiesAdditionalPartyTab additionalPartiesAdditionalPartyTab = disabilityClaim.getDefaultWorkspace().getTab(AdditionalPartiesAdditionalPartyTab.class);
    ClaimCoordinationAdditionalInsuranceTab claimCoordinationAdditionalInsuranceTab = disabilityClaim.getDefaultWorkspace().getTab(ClaimCoordinationAdditionalInsuranceTab.class);
    ClaimCoordinationRelatedClaimsTab claimCoordinationRelatedClaimsTab = disabilityClaim.getDefaultWorkspace().getTab(ClaimCoordinationRelatedClaimsTab.class);
    EAPServicesServiceRequestTab eAPServicesServiceRequestTab = disabilityClaim.getDefaultWorkspace().getTab(EAPServicesServiceRequestTab.class);
    ClaimHandlingClaimFileOwnerTab claimHandlingClaimFileOwnerTab = disabilityClaim.getDefaultWorkspace().getTab(ClaimHandlingClaimFileOwnerTab.class);
    ClaimHandlingSpecialHandlingTab claimHandlingSpecialHandlingTab = disabilityClaim.getDefaultWorkspace().getTab(ClaimHandlingSpecialHandlingTab.class);
    CompleteNotificationTab completeNotificationTab = disabilityClaim.getDefaultWorkspace().getTab(CompleteNotificationTab.class);

    default void initiateClaimWithoutPolicyAndFillToTab(TestData testData, Class<? extends Tab> tabClass, boolean isFillTab) {
        disabilityClaim.initiateWithoutPolicy(testData);
        disabilityClaim.getDefaultWorkspace().fillUpTo(testData, tabClass, isFillTab);
    }

    default void initiateClaimWithPolicyAndFillToTab(TestData testData, Class<? extends Tab> tabClass, boolean isFillTab) {
        disabilityClaim.initiate(testData);
        disabilityClaim.getDefaultWorkspace().fillUpTo(testData, tabClass, isFillTab);
    }
}
