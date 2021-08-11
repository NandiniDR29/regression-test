/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.ren.main.modules.account.actions;

import com.exigen.istf.data.TestData;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.CustomerConstants;
import com.exigen.ren.main.modules.account.tabs.CommunicationActionTab;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;

public class RemoveCommunicationAction implements Action {
    private Workspace workspace = new Workspace.Builder()
            .registerTab(CommunicationActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Remove Communication";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    public Action start(int rowNumber) {
        if (!CommunicationActionTab.tableCommunications.isVisible()) {
            CustomerSummaryPage.linkRelatedCommunications.click();
        }
        CommunicationActionTab.tableCommunications.getRow(rowNumber).getCell(CustomerConstants.CustomerCommunicationsTable.ACTION).controls.buttons.get("Delete").click();
        Page.dialogConfirmation.confirm();
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
        throw new UnsupportedOperationException("perform(TestData td) method with testData is not supported for this action. Use perform(int rowNumber) instead.");
    }

    @Override
    public Action submit() {
        return this;
    }

}
