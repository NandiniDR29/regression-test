/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.ren.main.modules.policy.gb_dn.masterpolicy;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.enums.ProductConstants;
import com.exigen.ren.main.modules.policy.gb_dn.masterpolicy.metadata.PlanDefinitionTabMetaData;
import com.exigen.ren.main.modules.policy.gb_dn.masterpolicy.tabs.*;
import com.exigen.ren.main.pages.summary.PolicySummaryPage;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.TestDataKey.DEFAULT_TEST_DATA_KEY;

public interface GroupDentalMasterPolicyContext {

    GroupDentalMasterPolicy groupDentalMasterPolicy = AutomationContext.getService(GroupDentalMasterPolicy.class);
    ClassificationManagementTab classificationManagementMpTab = groupDentalMasterPolicy.getDefaultWorkspace().getTab(ClassificationManagementTab.class);
    EnrollmentTab enrollmentTab = groupDentalMasterPolicy.getDefaultWorkspace().getTab(EnrollmentTab.class);
    PlanDefinitionTab planDefinitionTab = groupDentalMasterPolicy.getDefaultWorkspace().getTab(PlanDefinitionTab.class);
    PolicyInformationTab policyInformationTab = groupDentalMasterPolicy.getDefaultWorkspace().getTab(PolicyInformationTab.class);
    PremiumSummaryTab premiumSummaryTab = groupDentalMasterPolicy.getDefaultWorkspace().getTab(PremiumSummaryTab.class);
    CaseInstallationIssueActionTab caseInstallationIssueActionTab = groupDentalMasterPolicy.issue().getWorkspace().getTab(CaseInstallationIssueActionTab.class);
    PlanDefinitionIssueActionTab planDefinitionIssueActionTab = groupDentalMasterPolicy.issue().getWorkspace().getTab(PlanDefinitionIssueActionTab.class);

    default void createDefaultGroupDentalMasterPolicy() {
        groupDentalMasterPolicy.createPolicy(getDefaultDNMasterPolicyData());
    }

    default void initiateQuoteAndFillUpToTab(TestData testData, Class<? extends Tab> tabClass, boolean isFillTab) {
        groupDentalMasterPolicy.initiate(testData);
        groupDentalMasterPolicy.getDefaultWorkspace().fillUpTo(testData, tabClass, isFillTab);
    }

    default TestData getDefaultDNMasterPolicyData() {
        return groupDentalMasterPolicy.getDefaultTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY)
                .adjust(groupDentalMasterPolicy.getDefaultTestData(TestDataKey.PROPOSE, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(groupDentalMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(groupDentalMasterPolicy.getDefaultTestData(TestDataKey.ISSUE, TestDataKey.DEFAULT_TEST_DATA_KEY));
    }

    default TestData getDefaultDNMasterPolicySelfAdminData() {
        return groupDentalMasterPolicy.getDefaultTestData(TestDataKey.DATA_GATHER_SELF_ADMIN, TestDataKey.DEFAULT_TEST_DATA_KEY)
                .adjust(groupDentalMasterPolicy.getDefaultTestData(TestDataKey.PROPOSE, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(groupDentalMasterPolicy.getDefaultTestData(TestDataKey.ACCEPT_CONTRACT, TestDataKey.DEFAULT_TEST_DATA_KEY))
                .adjust(groupDentalMasterPolicy.getDefaultTestData(TestDataKey.ISSUE, DEFAULT_TEST_DATA_KEY));
    }

    default void selectFirstPlanFromDNMasterPolicyDefaultTestData() {
        planDefinitionTab.getAssetList().getAsset(PlanDefinitionTabMetaData.PLAN).fill(getDefaultDNMasterPolicyData().getTestDataList(planDefinitionTab.getClass().getSimpleName()).get(0));

    }

    default void proposeAcceptContractIssueDNMasterPolicyWithDefaultTestData() {
        groupDentalMasterPolicy.propose().perform(getDefaultDNMasterPolicyData());
        assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.PROPOSED);

        groupDentalMasterPolicy.acceptContract().perform(getDefaultDNMasterPolicyData());
        assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.CUSTOMER_ACCEPTED);

        groupDentalMasterPolicy.issue().perform(getDefaultDNMasterPolicyData());
        assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.POLICY_ACTIVE);
    }
}
