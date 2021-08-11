/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.gb_ac;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.claim.gb_ac.AccidentHealthClaimContext;


public interface AccidentHealthClaimACContext extends AccidentHealthClaimContext {

    default void createDefaultGroupAccidentClaimForMasterPolicy() {
        accHealthClaim.create(accHealthClaim.getGbACTestData().getTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY));
    }

    default void createDefaultGroupAccidentClaimForCertificatePolicy() {
        accHealthClaim.create(accHealthClaim.getGbACTestData().getTestData("DataGatherCertificate", TestDataKey.DEFAULT_TEST_DATA_KEY));
    }

    default void createDefaultGroupAccidentClaimWithoutPolicy() {
        accHealthClaim.createWithoutPolicy(accHealthClaim.getGbACTestData().getTestData(TestDataKey.DATA_GATHER_WITHOUT_POLICY,
                TestDataKey.DEFAULT_TEST_DATA_KEY));
    }

    default void initiateClaimWithPolicyAndFillUpToTab(TestData testData, Class<? extends Tab> tabClass, boolean isFillTab) {
        accHealthClaim.initiate(testData);
        accHealthClaim.getDefaultWorkspace().fillUpTo(testData, tabClass, isFillTab);
    }
}
