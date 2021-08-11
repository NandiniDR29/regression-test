/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.policy.gb_st.masterpolicy;

import com.exigen.istf.data.TestData;
import com.exigen.modules.policy.common.GroupBenefitsMasterPolicy;
import com.exigen.modules.policy.common.GroupBenefitsMasterPolicyType;
import com.exigen.modules.policy.gb_dn.masterpolicy.actions.DentalMasterPolicyIssueAction;
import com.exigen.modules.policy.gb_st.masterpolicy.actions.StatutoryDisabilityMasterPolicyDataGatherAction;
import com.exigen.modules.policy.gb_st.masterpolicy.tabs.ClassificationManagementTab;
import com.exigen.modules.policy.gb_st.masterpolicy.tabs.PremiumSummaryTab;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum.GroupBenefitsTab;
import com.exigen.ren.common.pages.NavigationPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.exigen.ren.main.enums.ActionConstants.CHANGE;

public class StatutoryDisabilityInsuranceMasterPolicy implements GroupBenefitsMasterPolicy {
    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/policy/gb_st/master");
    protected static final Logger LOGGER = LoggerFactory.getLogger(StatutoryDisabilityInsuranceMasterPolicy.class);


    public GroupBenefitsMasterPolicyType getType() {
        return GroupBenefitsMasterPolicyType.GB_ST;
    }

    @Override
    public Workspace getDefaultWorkspace() {
        return dataGather().getWorkspace();
    }

    @Override
    public void calculatePremium() {
        dataGather().start();
        NavigationPage.PolicyNavigation.leftMenu(GroupBenefitsTab.CLASSIFICATION_MANAGEMENT.get());
        if (ClassificationManagementTab.tableClassificationSubGroupsAndRatingInfo.isPresent()) {
            ClassificationManagementTab.tableClassificationSubGroupsAndRatingInfo.getRows().forEach(row -> row.getCell(8).controls.links.get(CHANGE).click());
        }
        NavigationPage.PolicyNavigation.leftMenu(GroupBenefitsTab.PREMIUM_SUMMARY.get(), Tab.doubleWaiter);
        PremiumSummaryTab.buttonRate.click();
        PremiumSummaryTab.buttonSaveAndExit.click();
    }

    @Override
    public StatutoryDisabilityMasterPolicyDataGatherAction dataGather() {
        return AutomationContext.getAction(StatutoryDisabilityMasterPolicyDataGatherAction.class);
    }
    @Override
    public DentalMasterPolicyIssueAction issue() {
        return AutomationContext.getAction(DentalMasterPolicyIssueAction.class);
    }
    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }
//
//    @Override
//    public StatutoryDisabilityMasterInquiryAction policyInquiry() {
//        return AutomationContext.getAction(StatutoryDisabilityMasterInquiryAction.class);
//    }
//
//    @Override
//    public StatutoryDisabilityMasterInquiryAction quoteInquiry() {
//        return policyInquiry();
//    }
}
