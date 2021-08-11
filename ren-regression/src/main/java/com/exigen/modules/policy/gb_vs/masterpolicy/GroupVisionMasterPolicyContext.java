/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.modules.policy.gb_vs.masterpolicy;

import com.exigen.TestDataKey;
import com.exigen.istf.data.TestData;
import com.exigen.modules.policy.gb_vs.masterpolicy.tabs.*;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Tab;

public interface GroupVisionMasterPolicyContext {

    GroupVisionMasterPolicy groupVisionMasterPolicy = AutomationContext.getService(GroupVisionMasterPolicy.class);

    PolicyInformationTab policyInformationTab = groupVisionMasterPolicy.getDefaultWorkspace().getTab(PolicyInformationTab.class);
    EnrollmentTab enrollmentTab = groupVisionMasterPolicy.getDefaultWorkspace().getTab(EnrollmentTab.class);
    PlanDefinitionTab planDefinitionTab = groupVisionMasterPolicy.getDefaultWorkspace().getTab(PlanDefinitionTab.class);
    ClassificationManagementTab classificationManagementMpTab = groupVisionMasterPolicy.getDefaultWorkspace().getTab(ClassificationManagementTab.class);
    PremiumSummaryTab premiumSummaryTab = groupVisionMasterPolicy.getDefaultWorkspace().getTab(PremiumSummaryTab.class);
    CaseInstallationTab caseInstallationTab = groupVisionMasterPolicy.getDefaultWorkspace().getTab(CaseInstallationTab.class);

    default TestData getDefaultVSMasterPolicyData() {
        return groupVisionMasterPolicy.getDefaultTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY)
                .adjust(groupVisionMasterPolicy.getDefaultTestData(TestDataKey.PROPOSE, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(groupVisionMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(groupVisionMasterPolicy.getDefaultTestData(TestDataKey.ISSUE, TestDataKey.DEFAULT_TEST_DATA_KEY));
    }

    default void createDefaultGroupVisionMasterPolicy() {
        groupVisionMasterPolicy.createPolicy(getDefaultVSMasterPolicyData());
    }

    default TestData getVSMasterPolicyissue(String dataGather, String testDataKey) {
        return groupVisionMasterPolicy.getDefaultTestData(dataGather,testDataKey)
                .adjust(groupVisionMasterPolicy.getDefaultTestData(TestDataKey.PROPOSE, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(groupVisionMasterPolicy.getDefaultTestData(dataGather,testDataKey));
    }
    default void quoteInitiateAndFillUpToTab(TestData testData, Class<? extends Tab> tabClass, boolean isFillTab) {
        groupVisionMasterPolicy.initiate(testData);
        groupVisionMasterPolicy.getDefaultWorkspace().fillUpTo(testData, tabClass, isFillTab);
    }
}
