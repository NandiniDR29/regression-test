/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.policy.gb_pfl.masterpolicy;

import com.exigen.istf.data.TestData;
import com.exigen.modules.policy.common.GroupBenefitsMasterPolicy;
import com.exigen.modules.policy.gb_dn.masterpolicy.actions.DentalMasterPolicyIssueAction;
import com.exigen.modules.policy.gb_pfl.masterpolicy.actions.PaidFamilyLeaveMasterPolicyDataGatherAction;
import com.exigen.modules.policy.gb_pfl.masterpolicy.tabs.PremiumSummaryTab;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaidFamilyLeaveMasterPolicy implements GroupBenefitsMasterPolicy {
    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/policy/gb_pfl/master");
    protected static final Logger LOGGER = LoggerFactory.getLogger(PaidFamilyLeaveMasterPolicy.class);
    @Override
    public Workspace getDefaultWorkspace() {
        return dataGather().getWorkspace();
    }

    @Override
    public void calculatePremium() {
        dataGather().start();
        NavigationPage.PolicyNavigation.leftMenu(NavigationEnum.GroupBenefitsTab.CLASSIFICATION_MANAGEMENT.get());
        NavigationPage.PolicyNavigation.leftMenu(NavigationEnum.GroupBenefitsTab.PREMIUM_SUMMARY.get(), Tab.doubleWaiter);
        PremiumSummaryTab.buttonRate.click();
        PremiumSummaryTab.buttonSaveAndExit.click();
    }

    @Override
    public PaidFamilyLeaveMasterPolicyDataGatherAction dataGather() {
        return AutomationContext.getAction(PaidFamilyLeaveMasterPolicyDataGatherAction.class);
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }


    @Override
    public DentalMasterPolicyIssueAction issue() {
        return AutomationContext.getAction(DentalMasterPolicyIssueAction.class);


    }

}
