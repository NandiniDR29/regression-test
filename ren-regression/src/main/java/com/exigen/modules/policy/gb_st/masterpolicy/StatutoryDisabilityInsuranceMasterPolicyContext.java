/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.policy.gb_st.masterpolicy;

import com.exigen.istf.data.TestData;
import com.exigen.modules.policy.gb_st.masterpolicy.tabs.*;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Tab;

public interface StatutoryDisabilityInsuranceMasterPolicyContext {
    StatutoryDisabilityInsuranceMasterPolicy statutoryDisabilityInsuranceMasterPolicy = AutomationContext.getService(StatutoryDisabilityInsuranceMasterPolicy.class);
    ClassificationManagementTab classificationManagementMpTab = statutoryDisabilityInsuranceMasterPolicy.getDefaultWorkspace().getTab(ClassificationManagementTab.class);
    EnrollmentTab enrollmentTab = statutoryDisabilityInsuranceMasterPolicy.getDefaultWorkspace().getTab(EnrollmentTab.class);
    PlanDefinitionTab planDefinitionTab = statutoryDisabilityInsuranceMasterPolicy.getDefaultWorkspace().getTab(PlanDefinitionTab.class);
    PolicyInformationTab policyInformationTab = statutoryDisabilityInsuranceMasterPolicy.getDefaultWorkspace().getTab(PolicyInformationTab.class);
    PremiumSummaryTab premiumSummaryTab = statutoryDisabilityInsuranceMasterPolicy.getDefaultWorkspace().getTab(PremiumSummaryTab.class);

    default void createDefaultStatutoryDisabilityInsuranceMasterPolicy() {
        statutoryDisabilityInsuranceMasterPolicy.createPolicy(getDefaultSTMasterPolicyData());
    }

    default TestData getDefaultSTMasterPolicyData() {
        return statutoryDisabilityInsuranceMasterPolicy.getDefaultTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY)
                .adjust(statutoryDisabilityInsuranceMasterPolicy.getDefaultTestData(TestDataKey.PROPOSE, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(statutoryDisabilityInsuranceMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(statutoryDisabilityInsuranceMasterPolicy.getDefaultTestData(TestDataKey.ISSUE, TestDataKey.DEFAULT_TEST_DATA_KEY));
    }

    default TestData getSTMasterPolicyIssueData(String dataGather, String testDataKey) {
        return statutoryDisabilityInsuranceMasterPolicy.getDefaultTestData(dataGather, testDataKey)
                .adjust(statutoryDisabilityInsuranceMasterPolicy.getDefaultTestData(TestDataKey.PROPOSE, TestDataKey.DEFAULT_TEST_DATA_KEY))
             //   .adjust(statutoryDisabilityInsuranceMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(statutoryDisabilityInsuranceMasterPolicy.getDefaultTestData(dataGather, testDataKey));
    }

    default void initiateSTQuoteAndFillUpToTab(TestData testData, Class<? extends Tab> tabClass, boolean isFillTab) {
        statutoryDisabilityInsuranceMasterPolicy.initiate(testData);
        statutoryDisabilityInsuranceMasterPolicy.getDefaultWorkspace().fillUpTo(testData, tabClass, isFillTab);
    }

}