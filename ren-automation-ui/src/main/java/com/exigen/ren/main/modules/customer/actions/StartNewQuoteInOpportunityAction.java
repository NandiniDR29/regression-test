/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.actions;

import com.exigen.istf.data.TestData;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.customer.tabs.OpportunityActionTab;

public class StartNewQuoteInOpportunityAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(OpportunityActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Start new quote in Opportunity";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action start() {
        NavigationPage.toMainTab(NavigationEnum.CustomerSummaryTab.OPPORTUNITY);
        OpportunityActionTab.buttonCreateNewOpportunity.click();
        OpportunityActionTab.buttonAddOpportunity.click();
        return this;
    }

    @Override
    public Action perform(TestData td) {
        start();
        getWorkspace().fill(td);
        OpportunityActionTab.buttonStartNewQuoteForOpportunity.click();
        Page.dialogConfirmation.buttonYes.click();
        return submit();
    }

    @Override
    public Action submit() {
        return this;
    }
}
