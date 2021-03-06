/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.policy.gb_tl.masterpolicy;

import com.exigen.TestDataProvider;
import com.exigen.istf.data.TestData;
import com.exigen.modules.policy.common.GroupBenefitsMasterPolicy;
import com.exigen.modules.policy.gb_tl.masterpolicy.actions.TermLifeInsuranceMasterPolicyDataGatherAction;
import com.exigen.modules.policy.gb_tl.masterpolicy.actions.TermLifeInsuranceMasterPolicyIssueAction;
import com.exigen.modules.policy.gb_tl.masterpolicy.tabs.PremiumSummaryTab;
import com.exigen.modules.policy.gb_vs.masterpolicy.tabs.ClassificationManagementTab;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TermLifeInsuranceMasterPolicy implements GroupBenefitsMasterPolicy {
    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/policy/gb_tl/master");
    protected static final Logger LOGGER = LoggerFactory.getLogger(TermLifeInsuranceMasterPolicy.class);

    @Override
    public Workspace getDefaultWorkspace() {
        return dataGather().getWorkspace();
    }

    @Override
    public void calculatePremium() {
        dataGather().start();
        NavigationPage.PolicyNavigation.leftMenu(NavigationEnum.GroupBenefitsTab.CLASSIFICATION_MANAGEMENT.get());
        ClassificationManagementTab.coveragesTable.getRows().forEach(row -> row.getCell(1).click());
        NavigationPage.PolicyNavigation.leftMenu(NavigationEnum.GroupBenefitsTab.PREMIUM_SUMMARY.get(), Tab.doubleWaiter);
        PremiumSummaryTab.buttonRate.click();
        PremiumSummaryTab.buttonSaveAndExit.click();
    }

    @Override
    public TermLifeInsuranceMasterPolicyDataGatherAction dataGather() {
        return AutomationContext.getAction(TermLifeInsuranceMasterPolicyDataGatherAction.class);
    }

//    @Override
//    public TermLifeInsuranceMasterPolicyAcceptContractAction acceptContract() {
//        return AutomationContext.getAction(TermLifeInsuranceMasterPolicyAcceptContractAction.class);
//    }

    @Override
    public TermLifeInsuranceMasterPolicyIssueAction issue() {
        return AutomationContext.getAction(TermLifeInsuranceMasterPolicyIssueAction.class);
    }

//    @Override
//    public TermLifeInsuranceMasterPolicyPremiumAdjustmentAction premiumAdjustment() {
//        return AutomationContext.getAction(TermLifeInsuranceMasterPolicyPremiumAdjustmentAction.class);
//    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }
//
//    @Override
//    public TermLifeInsuranceMasterInquiryAction policyInquiry() {
//        return AutomationContext.getAction(TermLifeInsuranceMasterInquiryAction.class);
//    }
//
//    @Override
//    public TermLifeInsuranceMasterInquiryAction quoteInquiry() {
//        return policyInquiry();
//    }
}
