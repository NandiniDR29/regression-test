package com.exigen.ren.main.modules.policy.common.actions.master;

import com.exigen.istf.data.TestData;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.policy.common.PolicyType;
import com.exigen.ren.main.modules.policy.common.tabs.master.StartRateGuaranteeRenewTab;

import static com.exigen.ren.common.Tab.doubleWaiter;

public class MasterPolicyRateGuaranteeRenew implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(StartRateGuaranteeRenewTab.class)
            .build();

    @Override
    public String getName() {
        return "Rate Guarantee Renew";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action submit() {
        Page.dialogConfirmation.confirm();

        NavigationPage.PolicyNavigation.leftMenu(NavigationEnum.GroupBenefitsTab.PREMIUM_SUMMARY.get(), doubleWaiter);
        Tab.buttonRate.click();
        Tab.buttonSaveAndExit.click();
        return this;
    }

    public static void startRateGuaranteeRenewForPolicy(PolicyType policyType, TestData td) {
        policyType.get().rateGuaranteeRenew().start();
        policyType.get().rateGuaranteeRenew().getWorkspace().fill(td);
        Page.dialogConfirmation.confirm();
    }
}
