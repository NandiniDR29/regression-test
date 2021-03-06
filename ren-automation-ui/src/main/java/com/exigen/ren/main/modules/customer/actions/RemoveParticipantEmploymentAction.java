/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.actions;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.customer.tabs.SponsorParticipantRelationshipAssociationRemovalActionTab;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;
import org.openqa.selenium.By;

public class RemoveParticipantEmploymentAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(SponsorParticipantRelationshipAssociationRemovalActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Remove Relationship";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    public Action start(int rowNumber) {
        CustomerSummaryPage.tableEmploymentCensus.getColumn(1).getCell(rowNumber).controls.checkBoxes.getFirst().setValue(true);
        new ComboBox(By.id("EMP_crmForm:censusSelect")).setValue(getName());
        new Button(By.id("EMP_crmForm:Go")).click();
        return this;
    }

    public Action perform(TestData td, int rowNumber) {
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
        throw new UnsupportedOperationException("perform(TestData td) method without rowNumber is not supported for this action. Use perform(TestData td, int rowNumber) instead.");
    }

    @Override
    public Action submit() {
        return this;
    }
}
