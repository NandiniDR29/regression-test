/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.gb_dn;

import com.exigen.ren.TestDataKey;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.main.modules.claim.common.tabs.*;
import com.exigen.ren.main.modules.claim.gb_dn.DentalClaim;
import com.exigen.ren.main.modules.claim.gb_dn.tabs.*;
import com.exigen.ren.rest.claim.ClaimDentalRestService;

public interface DentalClaimContext {
    DentalClaim dentalClaim = AutomationContext.getService(DentalClaim.class);
    ClaimDentalRestService dentalClaimRest = AutomationContext.getService(ClaimDentalRestService.class);

    PolicyInformationPolicyTab policyInformationPolicyTab = dentalClaim.getDefaultWorkspace().getTab(PolicyInformationPolicyTab.class);
    PolicyInformationInsurableRiskRiskPartyTab policyInformationInsurableRiskRiskPartyTab = dentalClaim.getDefaultWorkspace().getTab(PolicyInformationInsurableRiskRiskPartyTab.class);
    PolicyInformationPartiesInsuredTab policyInformationPartiesInsuredTab = dentalClaim.getDefaultWorkspace().getTab(PolicyInformationPartiesInsuredTab.class);
    TreatmentInformationTreatmentDetailsTab treatmentInformationTreatmentDetailsTab = dentalClaim.getDefaultWorkspace().getTab(TreatmentInformationTreatmentDetailsTab.class);
    TreatmentInformationServiceProviderTab treatmentInformationServiceProviderTab = dentalClaim.getDefaultWorkspace().getTab(TreatmentInformationServiceProviderTab.class);
    BenefitPatientTab benefitPatientTab = dentalClaim.getDefaultWorkspace().getTab(BenefitPatientTab.class);
    BenefitBenefitDetailsTab benefitBenefitDetailsTab = dentalClaim.getDefaultWorkspace().getTab(BenefitBenefitDetailsTab.class);
    ClaimHandlingClaimFileOwnerTab claimHandlingClaimFileOwnerTab = dentalClaim.getDefaultWorkspace().getTab(ClaimHandlingClaimFileOwnerTab.class);
    ClaimHandlingSpecialHandlingTab claimHandlingSpecialHandlingTab = dentalClaim.getDefaultWorkspace().getTab(ClaimHandlingSpecialHandlingTab.class);
    IntakeInformationTab intakeInformationTab = dentalClaim.getDefaultWorkspace().getTab(IntakeInformationTab.class);
    CompleteNotificationTab completeNotificationTab = dentalClaim.getDefaultWorkspace().getTab(CompleteNotificationTab.class);

    default void createDefaultGroupDentalClaimForMasterPolicy() {
        dentalClaim.create(dentalClaim.getDefaultTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY));
    }

    default void createDefaultGroupDentalClaimForCertificatePolicy() {
        dentalClaim.create(dentalClaim.getDefaultTestData("DataGatherCertificate", TestDataKey.DEFAULT_TEST_DATA_KEY));
    }
}
