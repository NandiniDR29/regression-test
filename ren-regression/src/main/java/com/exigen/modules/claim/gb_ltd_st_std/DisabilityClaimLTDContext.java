/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.gb_ltd_st_std;

import com.exigen.ren.TestDataKey;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.DisabilityClaimContext;


public interface DisabilityClaimLTDContext extends DisabilityClaimContext {

    default void createDefaultLongTermDisabilityClaimForMasterPolicy() {
        disabilityClaim.create(disabilityClaim.getLTDTestData().getTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY));
    }

    default void createDefaultLongTermDisabilityClaimForCertificatePolicy() {
        disabilityClaim.create(disabilityClaim.getLTDTestData().getTestData("DataGatherCertificate", TestDataKey.DEFAULT_TEST_DATA_KEY));
    }
    default void createDefaultLTDClaimForCertificatePolicyWithoutBenefits() {
        disabilityClaim.create(disabilityClaim.getLTDTestData().getTestData("DataGatherCertificate", "TestData_Without_Benefits"));
    }


    default void createDefaultLongTermDisabilityClaimWithoutPolicy() {
        disabilityClaim.createWithoutPolicy(disabilityClaim.getLTDTestData().getTestData(TestDataKey.DATA_GATHER_WITHOUT_POLICY,
                TestDataKey.DEFAULT_TEST_DATA_KEY));
    }

}
