/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.billing.account.actions;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.billing.account.metadata.OtherTransactionsActionTabMetaData;
import com.exigen.ren.main.modules.billing.account.tabs.OtherTransactionsActionTab;
import org.openqa.selenium.By;

public class OtherTransactionsAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(OtherTransactionsActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Other Transactions";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action start() {
        new Link(By.linkText("Other Transactions")).click();
        return this;
    }

    @Override
    public Action submit() {
        return this;
    }

    public Action perform(TestData td, String amount) {
        td.adjust(TestData.makeKeyPath(OtherTransactionsActionTab.class.getSimpleName(), OtherTransactionsActionTabMetaData.AMOUNT.getLabel()), amount);
        start();
        getWorkspace().fill(td);
        return submit();
    }

    @Override
    public Action perform(TestData td) {
        start();
        getWorkspace().fill(td);
        return submit();
    }





}
