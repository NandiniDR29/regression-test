/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.policy.gb_ac.masterpolicy;

import com.exigen.istf.data.TestData;
import com.exigen.modules.policy.common.GroupBenefitsMasterPolicy;
import com.exigen.modules.policy.gb_ac.masterpolicy.actions.AccidentMasterPolicyDataGatherAction;
import com.exigen.modules.policy.gb_ac.masterpolicy.tabs.PremiumSummaryTab;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum.GroupBenefitsTab;
import com.exigen.ren.common.pages.NavigationPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Concrete implementation for a specific entity type.
 * @category Generated
 */
public class AccidentMasterPolicy implements GroupBenefitsMasterPolicy {
    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/policy/gb_ac/master");
    protected static final Logger LOGGER = LoggerFactory.getLogger(AccidentMasterPolicy.class);

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
    public AccidentMasterPolicyDataGatherAction dataGather() {
        return AutomationContext.getAction(AccidentMasterPolicyDataGatherAction.class);
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }

    @Override
    public Action issue() {
        return AutomationContext.getAction(AccidentMasterPolicyIssueAction.class);
    }
}
