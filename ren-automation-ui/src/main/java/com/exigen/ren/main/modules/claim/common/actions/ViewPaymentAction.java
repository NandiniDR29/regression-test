/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.ren.main.modules.claim.common.actions;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.modules.claim.common.tabs.PaymentActionTab;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;

public class ViewPaymentAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(PaymentActionTab.class)
            .build();

    @Override
    public String getName() {
        return "View Payment";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action start() {
        throw new UnsupportedOperationException("start() method without parameters is not supported for this action. Use start(int rowNumber) instead.");
    }

    public Action start(int rowNumber) {
        NavigationPage.toSubTab(NavigationEnum.ClaimTab.PAYMENTS.get());
        ClaimSummaryPage.tableSummaryOfClaimPaymentsAndRecoveries
                .getRow(rowNumber).getCell(ClaimConstants.ClaimSummaryOfPaymentsAndRecoveriesTable.PAYMENT_NUMBER).controls.links.getFirst()
                .click();
        return this;
    }
}
