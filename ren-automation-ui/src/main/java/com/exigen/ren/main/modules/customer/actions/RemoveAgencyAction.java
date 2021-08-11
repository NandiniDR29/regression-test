/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.actions;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.ByT;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.customer.tabs.BusinessEntityTab;
import com.exigen.ren.main.modules.customer.tabs.GeneralTab;
import com.exigen.ren.main.modules.customer.tabs.RelationshipTab;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;

public class RemoveAgencyAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(GeneralTab.class)
            .registerTab(BusinessEntityTab.class)
            .registerTab(RelationshipTab.class)
            .build();

    @Override
    public String getName() {
        return "Remove Agency";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    public Action start(int rowNumber) {
        CustomerSummaryPage.buttonAddAgency.click();
        new Button(ByT.xpath("//a[@id='crmForm:removeAssignmentBtn_%s']").format(rowNumber)).click();
        return this;
    }

    public Action perform(int rowNumber, TestData td) {
        start(rowNumber);
        getWorkspace().fill(td);
        return submit();
    }

    @Override
    public Action start() {
        throw new UnsupportedOperationException("start() method without parameters is not supported for this action. Use start(int rowNumber) instead.");
    }

    @Override
    public Action perform(TestData td) {
        throw new UnsupportedOperationException("perform(TestData td) method without rowNumber is not supported for this action. Use perform(int rowNumber) instead.");
    }

    @Override
    public Action submit() {
        return this;
    }
}
