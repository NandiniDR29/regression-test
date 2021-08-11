package com.exigen.modules.claim.gb_dn.actions;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.claim.common.actions.ClearPaymentAction;
import com.exigen.ren.main.pages.summary.claim.ClaimPaymentsPage;
import org.openqa.selenium.By;

import static com.exigen.ren.main.enums.TableConstants.ClaimSummaryOfPaymentsAndRecoveriesTableExtended.PAYMENT_RECOVERY_NUMBER;
import static com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage.tableSummaryOfClaimPaymentsAndRecoveries;

public class DentalClaimClearPaymentAction extends ClearPaymentAction {

    @Override
    public Action start(int rowNumber) {
        NavigationPage.toSubTab(NavigationEnum.ClaimTab.FINANCIALS.get());
        tableSummaryOfClaimPaymentsAndRecoveries.getRow(rowNumber).getCell(PAYMENT_RECOVERY_NUMBER.getName()).controls.links.getFirst().click();
        ClaimPaymentsPage.buttonClearPayment.click();
        return this;
    }

    @Override
    public Action submit() {
        new Button(By.id("policyDataGatherForm:ok_ClaimsClearPaymentAction_footer")).click();
        return this;
    }

}
