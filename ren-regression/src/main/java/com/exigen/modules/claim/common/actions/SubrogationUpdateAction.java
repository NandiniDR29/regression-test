/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.modules.claim.common.actions;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.claim.common.tabs.SubrogationTab;
import org.openqa.selenium.By;

public class SubrogationUpdateAction implements Action {
    private Workspace workspace = new Workspace.Builder()
            .registerTab(SubrogationTab.class)
            .build();

    @Override
    public String getName() {
        return "Subrogation Update";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    public Action performWithoutStart(TestData td) {
        getWorkspace().fill(td);
        return submit();
    }

    @Override
    public Action start() {
        new Link(By.xpath("//a[text()='Subrogation Update']")).click();
        return this;
    }

    @Override
    public Action submit() {
        Tab.buttonSaveAndExit.click();
        return this;
    }
}
