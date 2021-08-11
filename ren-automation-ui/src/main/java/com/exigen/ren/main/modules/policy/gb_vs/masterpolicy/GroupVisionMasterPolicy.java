/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.policy.gb_vs.masterpolicy;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.policy.common.GroupBenefitsMasterPolicy;
import com.exigen.ren.main.modules.policy.common.GroupBenefitsMasterPolicyType;
import com.exigen.ren.main.modules.policy.gb_vs.masterpolicy.actions.GroupVisionMasterPolicyDataGatherAction;
import com.exigen.ren.main.modules.policy.gb_vs.masterpolicy.actions.GroupVisionMasterPolicyIssueAction;
import com.exigen.ren.main.modules.policy.gb_vs.masterpolicy.actions.GroupVisionPolicyMasterInquiryAction;
import com.exigen.ren.main.modules.policy.gb_vs.masterpolicy.tabs.PremiumSummaryTab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GroupVisionMasterPolicy implements GroupBenefitsMasterPolicy {
    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/policy/gb_vs/master");
    protected static final Logger LOGGER = LoggerFactory.getLogger(GroupVisionMasterPolicy.class);

    @Override
    public GroupBenefitsMasterPolicyType getType() {
        return GroupBenefitsMasterPolicyType.GB_VS;
    }

    @Override
    public Workspace getDefaultWorkspace() {
        return dataGather().getWorkspace();
    }

    @Override
    public void calculatePremium() {
        dataGather().start();
        NavigationPage.PolicyNavigation.leftMenu(NavigationEnum.GroupBenefitsTab.PREMIUM_SUMMARY.get(), Tab.doubleWaiter);
        PremiumSummaryTab.buttonRate.click();
        PremiumSummaryTab.buttonSaveAndExit.click();
    }

    @Override
    public GroupVisionMasterPolicyDataGatherAction dataGather() {
        return AutomationContext.getAction(GroupVisionMasterPolicyDataGatherAction.class);
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }

    @Override
    public GroupVisionPolicyMasterInquiryAction policyInquiry() {
        return AutomationContext.getAction(GroupVisionPolicyMasterInquiryAction.class);
    }

    @Override
    public GroupVisionMasterPolicyIssueAction issue() {
        return AutomationContext.getAction(GroupVisionMasterPolicyIssueAction.class);
    }

}
