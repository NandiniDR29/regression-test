package com.exigen.modules.policy.gb_vs.masterpolicy;

import com.exigen.TestDataProvider;
import com.exigen.istf.data.TestData;
import com.exigen.modules.policy.common.GroupBenefitsMasterPolicy;
import com.exigen.modules.policy.gb_vs.masterpolicy.actions.GroupVisionMasterPolicyDataGatherAction;
import com.exigen.modules.policy.gb_vs.masterpolicy.actions.GroupVisionMasterPolicyIssueAction;
import com.exigen.modules.policy.gb_vs.masterpolicy.tabs.PremiumSummaryTab;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GroupVisionMasterPolicy implements GroupBenefitsMasterPolicy {
    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/policy/gb_vs/master");
    protected static final Logger LOGGER = LoggerFactory.getLogger(GroupVisionMasterPolicy.class);

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
    public GroupVisionMasterPolicyIssueAction issue() {
        return AutomationContext.getAction(GroupVisionMasterPolicyIssueAction.class);
    }

}
