/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.policy.gb_eap.masterpolicy;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum.GroupBenefitsTab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.policy.common.GroupBenefitsMasterPolicy;
import com.exigen.ren.main.modules.policy.common.GroupBenefitsMasterPolicyType;
import com.exigen.ren.main.modules.policy.gb_eap.masterpolicy.actions.EmployeeAssistanceProgramMasterInquiryAction;
import com.exigen.ren.main.modules.policy.gb_eap.masterpolicy.actions.EmployeeAssistanceProgramMasterPolicyDataGatherAction;
import com.exigen.ren.main.modules.policy.gb_eap.masterpolicy.actions.EmployeeAssistanceProgramMasterPolicyIssueAction;
import com.exigen.ren.main.modules.policy.gb_eap.masterpolicy.tabs.PremiumSummaryTab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Concrete implementation for a specific entity type.
 * @category Generated
 */
public class EmployeeAssistanceProgramMasterPolicy implements GroupBenefitsMasterPolicy {
    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/policy/gb_eap/master");
    protected static final Logger LOGGER = LoggerFactory.getLogger(EmployeeAssistanceProgramMasterPolicy.class);

    @Override
    public GroupBenefitsMasterPolicyType getType() {
        return GroupBenefitsMasterPolicyType.GB_EAP;
    }

    @Override
    public Workspace getDefaultWorkspace() {
        return dataGather().getWorkspace();
    }

    @Override
    public void calculatePremium() {
        dataGather().start();
        NavigationPage.PolicyNavigation.leftMenu(GroupBenefitsTab.PREMIUM_SUMMARY.get(), Tab.doubleWaiter);
        PremiumSummaryTab.buttonRate.click();
        PremiumSummaryTab.buttonSaveAndExit.click();
    }

    @Override
    public EmployeeAssistanceProgramMasterPolicyDataGatherAction dataGather() {
        return AutomationContext.getAction(EmployeeAssistanceProgramMasterPolicyDataGatherAction.class);
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }

    @Override
    public EmployeeAssistanceProgramMasterInquiryAction policyInquiry() {
        return AutomationContext.getAction(EmployeeAssistanceProgramMasterInquiryAction.class);
    }

    @Override
    public EmployeeAssistanceProgramMasterInquiryAction quoteInquiry() {
        return policyInquiry();
    }

    @Override
    public EmployeeAssistanceProgramMasterPolicyIssueAction issue() {
        return AutomationContext.getAction(EmployeeAssistanceProgramMasterPolicyIssueAction.class);
    }
}
