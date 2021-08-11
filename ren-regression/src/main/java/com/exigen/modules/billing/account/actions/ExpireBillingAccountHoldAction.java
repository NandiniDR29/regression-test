package com.exigen.modules.billing.account.actions;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.billing.account.tabs.AddHoldActionTab;
import org.openqa.selenium.By;

public class ExpireBillingAccountHoldAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(AddHoldActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Expire Billing Account Hold";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action submit() {
        new Button(By.id("holdForm:expireButton_footer")).click();
        return this;
    }
}