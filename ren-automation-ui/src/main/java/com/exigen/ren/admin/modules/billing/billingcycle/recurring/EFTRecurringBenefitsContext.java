/* Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent. */
package com.exigen.ren.admin.modules.billing.billingcycle.recurring;

import com.exigen.istf.data.TestData;
import com.exigen.ren.common.AutomationContext;

import static com.exigen.ren.TestDataKey.DATA_GATHER;
import static com.exigen.ren.TestDataKey.DEFAULT_TEST_DATA_KEY;

public interface EFTRecurringBenefitsContext {
    EFTRecurringBenefits eFTRecurringBenefit = AutomationContext.getService(EFTRecurringBenefits.class);

    default TestData defaultEFTRecurringBenefitTestData() {
        return eFTRecurringBenefit.defaultTestData().getTestData(DATA_GATHER, DEFAULT_TEST_DATA_KEY);
    }
}