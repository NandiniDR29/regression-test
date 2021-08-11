package com.exigen.modules.claim.gb_dn.actions;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.claim.common.actions.PaymentInquiryAction;
import com.exigen.ren.main.modules.claim.gb_dn.tabs.PaymentInquiryTab;
import com.exigen.ren.main.pages.summary.claim.ClaimPaymentsPage;

import static com.exigen.ren.common.enums.NavigationEnum.ClaimTab.FINANCIALS;
import static com.exigen.ren.main.enums.TableConstants.ClaimSummaryOfPaymentsAndRecoveriesTableExtended.PAYMENT_RECOVERY_NUMBER;
import static com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage.tableSummaryOfClaimPaymentsAndRecoveries;

public class DentalPaymentInquiryAction extends PaymentInquiryAction {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(PaymentInquiryTab.class)
            .build();

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action start(int rowNumber) {
        NavigationPage.toSubTab(FINANCIALS.get());
        tableSummaryOfClaimPaymentsAndRecoveries.getRow(rowNumber).getCell(PAYMENT_RECOVERY_NUMBER.getName()).controls.links.getFirst().click();
        ClaimPaymentsPage.buttonInquiryPayment.click();
        return this;
    }

}
