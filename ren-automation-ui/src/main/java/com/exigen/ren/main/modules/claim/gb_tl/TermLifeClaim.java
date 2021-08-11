/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.gb_tl;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.claim.IClaim;
import com.exigen.ren.main.modules.claim.common.actions.PostRecoveryAction;
import com.exigen.ren.main.modules.claim.common.actions.UpdateRecoveryAction;
import com.exigen.ren.main.modules.claim.gb_tl.actions.*;
import com.exigen.ren.main.pages.summary.claim.ClaimAdjudicationSingleBenefitCalculationPage;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.exigen.istf.utils.datetime.DateTimeUtils.MM_DD_YYYY;
import static com.exigen.ren.main.pages.summary.claim.ClaimAdjudicationSingleBenefitCalculationPage.BenefitPeriod.BENEFIT_PERIOD_START_DATE;

public class TermLifeClaim implements IClaim {
    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/claim/gb_tl");

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }

    @Override
    public Workspace getDefaultWorkspace() {
        return AutomationContext.getAction(TermLifeClaimCreateAction.class).getWorkspace();
    }

    @Override
    public Action claimClose() {
        return AutomationContext.getAction(TermLifeClaimCloseAction.class);
    }

    @Override
    public TermLifeClaimAddBenefitAction addBenefit() {
        return AutomationContext.getAction(TermLifeClaimAddBenefitAction.class);
    }

    @Override
    public Action addPayment() {
        return AutomationContext.getAction(TermLifeClaimAddPaymentAction.class);
    }

    @Override
    public Action claimInquiry() {
        return AutomationContext.getAction(TermLifeClaimInquiryAction.class);
    }

    @Override
    public Action claimUpdate() {
        return AutomationContext.getAction(TermLifeClaimUpdateClaimAction.class);
    }

    @Override
    public Action inquiryBenefit() {
        return AutomationContext.getAction(TermLifeClaimInquiryBenefitAction.class);
    }

    @Override
    public TermLifeClaimUpdateBenefitAction updateBenefit() {
        return AutomationContext.getAction(TermLifeClaimUpdateBenefitAction.class);
    }

    @Override
    public Action viewBenefit() {
        return AutomationContext.getAction(TermLifeClaimViewBenefitAction.class);
    }

    @Override
    public Action claimNotification() {
        return AutomationContext.getAction(TermLifeClaimNotificationAction.class);
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
    public TermLifeClaimUpdatePaymentAction updatePayment() {
        return AutomationContext.getAction(TermLifeClaimUpdatePaymentAction.class);
    }

    public LocalDateTime getBenefitPeriodStartDate(int singleBenefitRowNumber) {
        viewSingleBenefitCalculation().perform(singleBenefitRowNumber);
        return LocalDate.parse(ClaimAdjudicationSingleBenefitCalculationPage.tableBenefitPeriod.getRow(1)
                .getCell(BENEFIT_PERIOD_START_DATE.getName()).getValue(), MM_DD_YYYY).atStartOfDay();
    }
}
