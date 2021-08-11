package com.exigen.modules.claim.common.actions;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.modules.claim.common.tabs.RecalculatePaidPaymentActionTab;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.openqa.selenium.By;

public class RecalculatePaidPaymentAction implements Action {
    private Workspace workspace = new Workspace.Builder()
            .registerTab(RecalculatePaidPaymentActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Recalculate Paid Payment";
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
        new Button(By.id("policyDataGatherForm:paymentActionLink_recalculatePaidPayment")).click();
        return this;
    }

    public Action start(String paymentNumber) {
        NavigationPage.toSubTab(NavigationEnum.ClaimTab.PAYMENTS.get());
        ClaimSummaryPage.tableSummaryOfClaimPaymentsAndRecoveries
                .getRow(ClaimConstants.ClaimSummaryOfPaymentsAndRecoveriesTable.PAYMENT_NUMBER, paymentNumber)
                .getCell(ClaimConstants.ClaimSummaryOfPaymentsAndRecoveriesTable.PAYMENT_NUMBER).controls.links.getFirst().click();
        new Button(By.id("policyDataGatherForm:paymentActionLink_recalculatePaidPayment")).click();
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

    public Action perform(TestData td, String paymentNumber) {
        start(paymentNumber);
        getWorkspace().fill(td);
        submit();
        return this;
    }

    @Override
    public Action submit() {
        new Button(By.id("policyDataGatherForm:okBtn_ClaimsRecalculatePaidPaymentAction_footer")).click();
        Page.dialogConfirmation.buttonOk.click();
        return this;
    }
}