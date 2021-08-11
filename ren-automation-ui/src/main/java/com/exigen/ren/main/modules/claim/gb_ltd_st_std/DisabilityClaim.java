/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.gb_ltd_st_std;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.claim.IClaim;
import com.exigen.ren.main.modules.claim.common.actions.*;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.actions.*;
import com.exigen.ren.main.pages.summary.claim.ClaimAdjudicationSingleBenefitCalculationPage;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.exigen.istf.utils.datetime.DateTimeUtils.MM_DD_YYYY;
import static com.exigen.ren.main.pages.summary.claim.ClaimAdjudicationSingleBenefitCalculationPage.BenefitPeriod.BENEFIT_PERIOD_START_DATE;

public class DisabilityClaim implements IClaim {
    private TestData ltdTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/claim/gb_ltd");
    private TestData stTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/claim/gb_st");
    private TestData stdTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/claim/gb_std");
    private TestData pflTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/claim/gb_pfl");

    public TestData getLTDTestData() {
        return ltdTestData;
    }

    public TestData getSTTestData() {
        return stTestData;
    }

    public TestData getSTDTestData() {
        return stdTestData;
    }

    public TestData getPFLTestData() {
        return pflTestData;
    }

    @Override
    public Workspace getDefaultWorkspace() {
        return AutomationContext.getAction(DisabilityClaimCreateAction.class).getWorkspace();
    }

    @Override
    public Action claimClose() {
        return AutomationContext.getAction(DisabilityClaimCloseAction.class);
    }

    @Override
    public DisabilityClaimAddBenefitAction addBenefit() {
        return AutomationContext.getAction(DisabilityClaimAddBenefitAction.class);
    }

    @Override
    public Action addPayment() {
        return AutomationContext.getAction(DisabilityClaimAddPaymentAction.class);
    }

    @Override
    public Action claimInquiry() {
        return AutomationContext.getAction(DisabilityClaimInquiryAction.class);
    }

    @Override
    public Action claimUpdate() {
        return AutomationContext.getAction(DisabilityClaimUpdateClaimAction.class);
    }

    @Override
    public InquiryBenefitAction inquiryBenefit() {
        return AutomationContext.getAction(DisabilityClaimInquiryBenefitAction.class);
    }

    @Override
    public UpdateBenefitAction updateBenefit() {
        return AutomationContext.getAction(DisabilityClaimUpdateBenefitAction.class);
    }

    @Override
    public Action viewBenefit() {
        return AutomationContext.getAction(DisabilityClaimViewBenefitAction.class);
    }

    @Override
    public Action claimNotification() {
        return AutomationContext.getAction(DisabilityClaimNotificationAction.class);
    }

    @Override
    public PostRecoveryAction postRecovery() {
        return AutomationContext.getAction(PostRecoveryAction.class);
    }

    @Override
    public UpdateRecoveryAction updateRecovery() {
        return AutomationContext.getAction(UpdateRecoveryAction.class);
    }

    @Override
    public DisabilityClaimUpdatePaymentAction updatePayment() {
        return AutomationContext.getAction(DisabilityClaimUpdatePaymentAction.class);
    }

    public SetClaimSubStatusAction setClaimSubStatus() {
        return AutomationContext.getAction(DisabilityClaimSetClaimSubStatus.class);
    }

    public void initiatePaymentAndFillToTab(TestData testData, Class<? extends Tab> tabClass, boolean isFillTab) {
        addPayment().start();
        addPayment().getWorkspace().fillUpTo(testData, tabClass, isFillTab);
    }

    public LocalDateTime getBenefitPeriodStartDate(int singleBenefitRowNumber) {
        viewSingleBenefitCalculation().perform(singleBenefitRowNumber);
        return LocalDate.parse(ClaimAdjudicationSingleBenefitCalculationPage.tableBenefitPeriod.getRow(1)
                .getCell(BENEFIT_PERIOD_START_DATE.getName()).getValue(), MM_DD_YYYY).atStartOfDay();
    }
}