package com.exigen.ren.main.modules.policy.common.actions.common;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.MainPage;
import com.exigen.ren.main.modules.caseprofile.tabs.ProposalActionTab;
import com.exigen.ren.main.modules.caseprofile.tabs.QuotesSelectionActionTab;
import com.exigen.ren.main.pages.summary.CaseProfileSummaryPage;
import com.exigen.ren.main.pages.summary.PolicySummaryPage;
import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.RandomStringUtils;

import static com.exigen.istf.verification.CustomAssertions.assertThat;

public class RateGuaranteeRenewalProposeAction extends CommonProposeAction {

    @Override
    public String getName() {
        return "Rate Guarantee Renewal Propose";
    }

    @Override
    public Action perform() {
        String policyNumber = PolicySummaryPage.labelPolicyNumber.getValue();
        start();
        QuotesSelectionActionTab.textBoxProposalName.setValue(String.format("ProposalName%s", RandomStringUtils.randomNumeric(5)));
        QuotesSelectionActionTab.radioGroupProposalType.setValue("Rate Guarantee Renewal");
        QuotesSelectionActionTab.selectQuoteByNumber(ImmutableList.of(policyNumber));
        Tab.buttonNext.click();
        getWorkspace().getTab(ProposalActionTab.class).submitTab();
        assertThat(CaseProfileSummaryPage.tableProposal).as("Proposal action was not finished").isPresent();
        MainPage.QuickSearch.search(policyNumber);
        return this;
    }
}
