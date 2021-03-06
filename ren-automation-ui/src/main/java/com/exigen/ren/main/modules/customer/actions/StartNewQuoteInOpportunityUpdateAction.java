/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/ /* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.actions;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.CustomerConstants;
import com.exigen.ren.main.modules.customer.tabs.OpportunityActionTab;
import org.openqa.selenium.By;

public class StartNewQuoteInOpportunityUpdateAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(OpportunityActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Start new quote in Opportunity update";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    public Action start(int rowNumber) {
        NavigationPage.toMainTab(NavigationEnum.CustomerSummaryTab.OPPORTUNITY);
        OpportunityActionTab.tableOpportunity.getRow(rowNumber).getCell(CustomerConstants.CustomerOpportunityTable.ID).controls.links.get(rowNumber).click();
        NavigationPage.setActionAndGo("Update");
        new Button(By.id("editOpportunity:QUOTEstartBtn")).click();
        Page.dialogConfirmation.buttonYes.click();
        return this;
    }

    public Action perform(int rowNumber) {
        start(rowNumber);
        return submit();
    }

    @Override
    public Action perform(TestData td) {
        throw new UnsupportedOperationException("perform(TestData td) method with testData is not supported for this action. Use perform(TestData td) instead.");
    }

    @Override
    public Action start() {
        throw new UnsupportedOperationException("start() method without parameters is not supported for this action. Use start(int rowNumber) instead.");
    }

    @Override
    public Action submit() {
        return this;
    }
}
