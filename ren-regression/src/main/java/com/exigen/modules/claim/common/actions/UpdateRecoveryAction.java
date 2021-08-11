/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.modules.claim.common.actions;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.modules.claim.common.actions.PostRecoveryAction;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.openqa.selenium.By;

public class UpdateRecoveryAction implements Action {

    @Override
    public String getName() {
        return "Update Recovery";
    }

    @Override
    public Workspace getWorkspace() {
        return AutomationContext.getAction(PostRecoveryAction.class).getWorkspace();
    }

    @Override
    public Action start() {
        throw new UnsupportedOperationException("start() method without parameters is not supported for this action. Use start(int rowNumber) instead.");
    }

    public Action start(int rowNumber) {
        NavigationPage.toSubTab(NavigationEnum.ClaimTab.PAYMENTS.get());
        ClaimSummaryPage.tableSummaryOfClaimPaymentsAndRecoveries.getRow(rowNumber).getCell(ClaimConstants.ClaimSummaryOfPaymentsAndRecoveriesTable.PAYMENT_NUMBER).controls.links.getFirst()
                .click();
        new Button(By.id("policyDataGatherForm:paymentActionLink_update")).click();
        return this;
    }

    @Override
    public Action submit() {
        new Button(By.id("policyDataGatherForm:postRecoveryBtn_ClaimsRecoveryUpdateAction")).click();
        if (Page.dialogConfirmation.isPresent()) {
            Page.dialogConfirmation.confirm();
        }
        return this;
    }

    @Override
    public Action perform(TestData td) {
        throw new UnsupportedOperationException("perform(TestData td) method without parameters is not supported for this action. Use perform(TestData td, int rowNumber) instead.");
    }

    public Action perform(TestData td, int rowNumber) {
        start(rowNumber);
        getWorkspace().fill(td);
        submit();
        return this;
    }
}
