/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.policy.common;

import com.exigen.istf.data.TestData;
import com.exigen.modules.policy.common.actions.master.MasterPolicyAcceptContractAction;
import com.exigen.modules.policy.common.actions.master.MasterPolicyDataGatherAction;
import com.exigen.modules.policy.common.actions.master.MasterPolicyIssueAction;
import com.exigen.modules.policy.common.pages.QuoteSummaryPage;
import com.exigen.ren.EntityLogger;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.pages.summary.PolicySummaryPage;

public interface GroupBenefitsMasterPolicy extends IPolicyImpData {

    @Override
    default void initiate(TestData td) {
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.QUOTE);
        QuoteSummaryPage.buttonAddNewQuote.click();
        Page.dialogConfirmation.fillAssetList(td, "InitiniateDialog");
        Page.dialogConfirmation.buttonNext.click();
    }

    @Override
    default void createQuoteViaUI(TestData td) {
        initiate(td);
        getDefaultWorkspace().fill(td);
        LOGGER.info("Created Quote " + EntityLogger.getEntityHeader(EntityLogger.EntityType.QUOTE));
    }

    @Override
    default void createPolicyViaUI(TestData td) {
        initiate(td);
        getDefaultWorkspace().fill(td);
        LOGGER.info("Created Policy " + EntityLogger.getEntityHeader(EntityLogger.EntityType.POLICY));
    }
    @Override
    default void createEndorsement(TestData td) {
        endorse().perform(td);
        PolicySummaryPage.buttonPendedEndorsement.click();
        dataGather().perform(td);
        PolicySummaryPage.buttonPendedEndorsement.click();
        issue().perform(td);
    }


    @Override
    default Action issue(TestData td) {
        return AutomationContext.getAction(MasterPolicyIssueAction.class);
    }

    @Override
    default Action dataGather() {
        return AutomationContext.getAction(MasterPolicyDataGatherAction.class);
    }

    default Action acceptContract() {
        return AutomationContext.getAction(MasterPolicyAcceptContractAction.class);
    }

    default void initiateAndFillUpToTab(TestData testData, Class<? extends Tab> tabClass, boolean isFillTab) {
        initiate(testData);
        getDefaultWorkspace().fillUpTo(testData, tabClass, isFillTab);
    }
}
