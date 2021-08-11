/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.policy.gb_tl.masterpolicy;

import com.exigen.istf.data.TestData;
import com.exigen.modules.policy.gb_tl.masterpolicy.tabs.*;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Tab;

import static com.exigen.ren.TestDataKey.DEFAULT_TEST_DATA_KEY;

public interface TermLifeInsuranceMasterPolicyContext {
    TermLifeInsuranceMasterPolicy termLifeInsuranceMasterPolicy = AutomationContext.getService(TermLifeInsuranceMasterPolicy.class);
    ClassificationManagementTab classificationManagementMpTab = termLifeInsuranceMasterPolicy.getDefaultWorkspace().getTab(ClassificationManagementTab.class);
    EnrollmentTab enrollmentTab = termLifeInsuranceMasterPolicy.getDefaultWorkspace().getTab(EnrollmentTab.class);
    PlanDefinitionTab planDefinitionTab = termLifeInsuranceMasterPolicy.getDefaultWorkspace().getTab(PlanDefinitionTab.class);
    PolicyInformationTab policyInformationTab = termLifeInsuranceMasterPolicy.getDefaultWorkspace().getTab(PolicyInformationTab.class);
    PremiumSummaryTab premiumSummaryTab = termLifeInsuranceMasterPolicy.getDefaultWorkspace().getTab(PremiumSummaryTab.class);

    default void createDefaultTermLifeInsuranceMasterPolicy() {
        termLifeInsuranceMasterPolicy.createPolicy(getDefaultTLMasterPolicyData());
    }

    default void createDefaultSelfAdminTermLifeInsuranceMasterPolicy() {
        termLifeInsuranceMasterPolicy.createPolicy(getDefaultTLMasterPolicySelfAdminData());
    }

    default TestData getDefaultTLMasterPolicyData() {
        return termLifeInsuranceMasterPolicy.getDefaultTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY)
                .adjust(termLifeInsuranceMasterPolicy.getDefaultTestData(TestDataKey.PROPOSE, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(termLifeInsuranceMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(termLifeInsuranceMasterPolicy.getDefaultTestData(TestDataKey.ISSUE, TestDataKey.DEFAULT_TEST_DATA_KEY));
    }
default TestData getTLMasterPolicyissue(String dataGather, String testDataKey)
{
    return termLifeInsuranceMasterPolicy.getDefaultTestData(dataGather,testDataKey)
            .adjust(termLifeInsuranceMasterPolicy.getDefaultTestData(dataGather,testDataKey))
          //  .adjust(termLifeInsuranceMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY))
            .adjust(termLifeInsuranceMasterPolicy.getDefaultTestData(dataGather,testDataKey));
}

    default TestData getDefaultTLMasterPolicySelfAdminData() {
        return termLifeInsuranceMasterPolicy.getDefaultTestData(TestDataKey.DATA_GATHER_SELF_ADMIN, TestDataKey.DEFAULT_TEST_DATA_KEY)
                .adjust(termLifeInsuranceMasterPolicy.getDefaultTestData(TestDataKey.PROPOSE, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(termLifeInsuranceMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(termLifeInsuranceMasterPolicy.getDefaultTestData(TestDataKey.ISSUE, DEFAULT_TEST_DATA_KEY));
    }

    default void createTermLifeInsuranceMasterPolicy(TestData td) {
        termLifeInsuranceMasterPolicy.createPolicy(td
                .adjust(termLifeInsuranceMasterPolicy.getDefaultTestData(TestDataKey.PROPOSE, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(termLifeInsuranceMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(termLifeInsuranceMasterPolicy.getDefaultTestData(TestDataKey.ISSUE, TestDataKey.DEFAULT_TEST_DATA_KEY)));
    }

    default void initiateTLQuoteAndFillToTab(TestData testData, Class<? extends Tab> tabClass, boolean isFillTab) {
        termLifeInsuranceMasterPolicy.initiate(testData);
        termLifeInsuranceMasterPolicy.getDefaultWorkspace().fillUpTo(testData, tabClass, isFillTab);
    }
}
