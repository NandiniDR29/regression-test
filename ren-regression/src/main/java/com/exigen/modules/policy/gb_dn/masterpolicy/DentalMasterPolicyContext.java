/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.modules.policy.gb_dn.masterpolicy;

import com.exigen.TestDataKey;
import com.exigen.istf.data.TestData;
import com.exigen.modules.policy.gb_dn.masterpolicy.tabs.*;
import com.exigen.ren.common.AutomationContext;

public interface DentalMasterPolicyContext {

    DentalMasterPolicy dentalMasterPolicy = AutomationContext.getService(DentalMasterPolicy.class);
    PolicyInformationTab policyInformationTab = dentalMasterPolicy.getDefaultWorkspace().getTab(PolicyInformationTab.class);
    EnrollmentTab enrollmentTab = dentalMasterPolicy.getDefaultWorkspace().getTab(EnrollmentTab.class);
    PlanDefinitionTab planDefinitionTab = dentalMasterPolicy.getDefaultWorkspace().getTab(PlanDefinitionTab.class);
    ClassificationManagementTab classificationManagementMpTab = dentalMasterPolicy.getDefaultWorkspace().getTab(ClassificationManagementTab.class);
    PremiumSummaryTab premiumSummaryTab = dentalMasterPolicy.getDefaultWorkspace().getTab(PremiumSummaryTab.class);
    CaseInstallationIssueActionTab caseInstallationIssueActionTab = dentalMasterPolicy.issue().getWorkspace().getTab(CaseInstallationIssueActionTab.class);
    PlanDefinitionIssueActionTab planDefinitionIssueActionTab = dentalMasterPolicy.issue().getWorkspace().getTab(PlanDefinitionIssueActionTab.class);

    default void createDefaultGroupDentalMasterPolicy() {
        dentalMasterPolicy.createPolicy(getDefaultDNMasterPolicyData());
    }

    default TestData getDefaultDNMasterPolicyData() {
        return dentalMasterPolicy.getDefaultTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY)
                .adjust(dentalMasterPolicy.getDefaultTestData(TestDataKey.PROPOSE, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(dentalMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(dentalMasterPolicy.getDefaultTestData(TestDataKey.ISSUE, TestDataKey.DEFAULT_TEST_DATA_KEY));
    }
    default TestData getDNMasterPolicyissue(String dataGather, String testDataKey) {
        return dentalMasterPolicy.getDefaultTestData(dataGather,testDataKey)
                .adjust(dentalMasterPolicy.getDefaultTestData(TestDataKey.PROPOSE, TestDataKey.DEFAULT_TEST_DATA_KEY))
                //.adjust(dentalMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(dentalMasterPolicy.getDefaultTestData(dataGather,testDataKey));
    }


}
