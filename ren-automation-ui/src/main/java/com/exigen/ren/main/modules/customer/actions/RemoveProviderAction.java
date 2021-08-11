/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.actions;

import com.exigen.istf.data.TestData;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.customer.tabs.GeneralTab;
import com.exigen.ren.main.modules.customer.tabs.ProviderTab;
import com.exigen.ren.main.modules.customer.tabs.SponsorParticipantRelationshipAssociationRemovalActionTab;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;

public class RemoveProviderAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(SponsorParticipantRelationshipAssociationRemovalActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Remove Relationship";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    public Action start(int rowNumber) {
        NavigationPage.setActionAndGo("Update");
        GeneralTab.buttonNext.click();
        CustomerSummaryPage.getRemoveProviderLink(rowNumber).click();
        return this;
    }

    public Action perform(int rowNumber) {
        start(rowNumber);
        return submit();
    }

    @Override
    public Action start() {
        throw new UnsupportedOperationException("start() method without parameters is not supported for this action. Use start(int rowNumber) instead.");
    }

    @Override
    public Action perform(TestData td) {
        throw new UnsupportedOperationException("perform(TestData td) method without rowNumber is not supported for this action. Use perform(TestData td, int rowNumber) instead.");
    }

    @Override
    public Action submit() {
        ProviderTab.buttonSaveAndExit.click();
        return this;
    }
}
