package com.exigen.modules.claim.common.actions;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.modules.claim.common.tabs.PaymentContinuePaymentSeriesActionTab;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.openqa.selenium.By;

import static com.exigen.ren.main.enums.CommonLocators.COMMON_LINK_WITH_TEXT_LOCATOR;

public class ContinuePaymentSeriesAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(PaymentContinuePaymentSeriesActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Continue Payment Series";
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
        ClaimSummaryPage.tableSummaryOfClaimPaymentSeries.getRow(rowNumber).getCell(ClaimConstants.ClaimSummaryOfPaymentSeriesTable.SERIES_NUMBER).controls.links.getFirst().click();
        new Button(COMMON_LINK_WITH_TEXT_LOCATOR.format(getName())).click();
        return this;
    }

    public Action perform(int rowNumber, TestData td) {
        start(rowNumber);
        getWorkspace().fill(td);
        return submit();
    }

    @Override
    public Action submit() {
        new Button(By.id("policyDataGatherForm:ok_ClaimsPaymentSeriesContinueAction_footer")).click();
        if (Page.dialogConfirmation.isPresent()) {
            Page.dialogConfirmation.confirm();
        }
        return this;
    }

}
