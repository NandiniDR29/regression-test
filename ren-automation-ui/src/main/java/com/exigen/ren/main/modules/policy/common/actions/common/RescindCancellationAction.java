/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.policy.common.actions.common;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.policy.common.tabs.common.RescindCancellationActionTab;
import org.openqa.selenium.By;

public class RescindCancellationAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(RescindCancellationActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Rescind Cancellation";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action perform(TestData td) {
        start();

        Waiters.SLEEP(3000).go();
        Button buttonValidate = new Button(By.id("policyDataGatherForm:yesBtn"));
        if (buttonValidate.isPresent() && buttonValidate.isVisible()) {
            buttonValidate.click();
        }

        getWorkspace().fill(td);
        return submit();
    }

}
