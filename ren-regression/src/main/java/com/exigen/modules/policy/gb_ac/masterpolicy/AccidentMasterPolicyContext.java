/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package com.exigen.modules.policy.gb_ac.masterpolicy;

import com.exigen.TestDataKey;
import com.exigen.istf.data.TestData;
import com.exigen.modules.policy.gb_ac.masterpolicy.tabs.*;
import com.exigen.ren.common.AutomationContext;

import static com.exigen.TestDataKey.DEFAULT_TEST_DATA_KEY;

public interface AccidentMasterPolicyContext {

    AccidentMasterPolicy groupACMasterPolicy = AutomationContext.getService(AccidentMasterPolicy.class);
    BasicBenefitsTab basicBenefitsTab = groupACMasterPolicy.getDefaultWorkspace().getTab(BasicBenefitsTab.class);
    EnhancedBenefitsAtoCTab enhancedBenefitsAtoCTab = groupACMasterPolicy.getDefaultWorkspace().getTab(EnhancedBenefitsAtoCTab.class);
    EnhancedBenefitsDtoFTab enhancedBenefitsDtoFTab = groupACMasterPolicy.getDefaultWorkspace().getTab(EnhancedBenefitsDtoFTab.class);
    EnhancedBenefitsHtoLTab enhancedBenefitsHtoLTab = groupACMasterPolicy.getDefaultWorkspace().getTab(EnhancedBenefitsHtoLTab.class);
    EnhancedBenefitsMtoTTab enhancedBenefitsMtoTTab = groupACMasterPolicy.getDefaultWorkspace().getTab(EnhancedBenefitsMtoTTab.class);
    ClassificationManagementTab classificationManagementMPTab = groupACMasterPolicy.getDefaultWorkspace().getTab(ClassificationManagementTab.class);
    EnrollmentTab enrollmentTab = groupACMasterPolicy.getDefaultWorkspace().getTab(EnrollmentTab.class);
    OptionalBenefitTab optionalBenefitTab = groupACMasterPolicy.getDefaultWorkspace().getTab(OptionalBenefitTab.class);
    PlanDefinitionTab planDefinitionTab = groupACMasterPolicy.getDefaultWorkspace().getTab(PlanDefinitionTab.class);
    PolicyInformationTab policyInformationTab = groupACMasterPolicy.getDefaultWorkspace().getTab(PolicyInformationTab.class);
    PremiumSummaryTab premiumSummaryTab = groupACMasterPolicy.getDefaultWorkspace().getTab(PremiumSummaryTab.class);

    default TestData getDefaultACMasterPolicyData() {
        return groupACMasterPolicy.getDefaultTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY)
                .adjust(groupACMasterPolicy.getDefaultTestData(TestDataKey.PROPOSE, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(groupACMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(groupACMasterPolicy.getDefaultTestData(TestDataKey.ISSUE, TestDataKey.DEFAULT_TEST_DATA_KEY));
    }

    default TestData getDefaultACMasterPolicyDataWithBasicBenefits() {
        return groupACMasterPolicy.getDefaultTestData(TestDataKey.DATA_GATHER, "TestDataWithBasicBenefitsTab")
                .adjust(groupACMasterPolicy.getDefaultTestData(TestDataKey.PROPOSE, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(groupACMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(groupACMasterPolicy.getDefaultTestData(TestDataKey.ISSUE, TestDataKey.DEFAULT_TEST_DATA_KEY));
    }

    default TestData getDefaultACMasterPolicySelfAdminData() {
        return groupACMasterPolicy.getDefaultTestData(TestDataKey.DATA_GATHER_SELF_ADMIN, TestDataKey.DEFAULT_TEST_DATA_KEY)
                .adjust(groupACMasterPolicy.getDefaultTestData(TestDataKey.PROPOSE, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(groupACMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(groupACMasterPolicy.getDefaultTestData(TestDataKey.ISSUE, DEFAULT_TEST_DATA_KEY));
    }
    default TestData getDefaultACMasterPolicyissue(String dataGather, String testDataKey) {
        return groupACMasterPolicy.getDefaultTestData(dataGather,testDataKey)
                .adjust(groupACMasterPolicy.getDefaultTestData(TestDataKey.PROPOSE, TestDataKey.DEFAULT_TEST_DATA_KEY))
             //   .adjust(groupACMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(groupACMasterPolicy.getDefaultTestData(dataGather,testDataKey));
    }

}
