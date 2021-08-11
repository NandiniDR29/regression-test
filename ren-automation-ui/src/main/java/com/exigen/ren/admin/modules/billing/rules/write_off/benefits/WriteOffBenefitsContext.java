/* Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent. */
package com.exigen.ren.admin.modules.billing.rules.write_off.benefits;

import com.exigen.istf.data.TestData;
import com.exigen.ren.common.AutomationContext;

import static com.exigen.ren.TestDataKey.DATA_GATHER;
import static com.exigen.ren.TestDataKey.DEFAULT_TEST_DATA_KEY;

public interface WriteOffBenefitsContext {
    WriteOffBenefits writeOffBenefit = AutomationContext.getService(WriteOffBenefits.class);

    default TestData defaultWriteOffBenefitTestData(){
        return writeOffBenefit.defaultTestData().getTestData(DATA_GATHER, DEFAULT_TEST_DATA_KEY);
    }
}