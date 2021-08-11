/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.policy.common.actions.common;

import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.data.TestData;
import com.exigen.modules.caseprofile.tabs.ProposalActionTab;
import com.exigen.modules.caseprofile.tabs.QuotesSelectionActionTab;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.MainPage;

public class ProposeAction extends CommonProposeAction {
    @Override
    public String getName() {
        return "Propose";
    }

    /**
     * Perform Proposal for  quote without any additional data
     */
    @Override
    public Action perform() {
        String policyNumber= CommonGenericMethods.returnMPNumber();
        start();
        QuotesSelectionActionTab.selectQuoteByNumber(policyNumber);
        QuotesSelectionActionTab.textBoxProposalName.setValue("ProposalName");
        Tab.buttonNext.click();
        getWorkspace().getTab(ProposalActionTab.class).submitTab();
        MainPage.QuickSearch.search(policyNumber);
        return this;
    }

    /**
     * Perform Proposal with custom data
     */
    @Override
    public Action perform(TestData td) {
        String policyNumber=CommonGenericMethods.returnMPNumber();
        start(td);
        getWorkspace().fill(td);
        MainPage.QuickSearch.search(policyNumber);
        return this;
    }
}
