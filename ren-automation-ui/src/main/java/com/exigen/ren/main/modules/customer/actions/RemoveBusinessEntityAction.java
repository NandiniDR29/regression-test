/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.actions;

import com.exigen.istf.data.TestData;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.customer.tabs.BusinessEntityTab;
import com.exigen.ren.main.modules.customer.tabs.CustomerTypeTab;
import com.exigen.ren.main.modules.customer.tabs.RelationshipTab;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;

public class RemoveBusinessEntityAction implements Action {
    @Override
    public String getName() {
        return "Remove This Business Entity";
    }

    @Override
    public Workspace getWorkspace() {
        return AutomationContext.getAction(DeleteCustomerAction.class).getWorkspace();
    }

    @Override
    public Action start() {
        NavigationPage.setActionAndGo("Update");
        CustomerTypeTab.buttonNext.click();
        CustomerSummaryPage.linkRemoveThisBusinessEntity.click();
        BusinessEntityTab.buttonNext.click();
        return this;
    }

    @Override
    public Action perform() {
        start();
        return submit();
    }

    @Override
    public Action perform(TestData td) {
        throw new UnsupportedOperationException("perform(TestData td) method with testData is not supported for this action. Use perform() instead.");
    }

    @Override
    public Action submit() {
        RelationshipTab.buttonDone.click();
        return this;
    }
}
