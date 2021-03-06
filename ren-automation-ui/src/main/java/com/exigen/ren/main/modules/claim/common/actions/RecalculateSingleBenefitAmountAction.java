/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.ren.main.modules.claim.common.actions;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.modules.claim.common.tabs.FeatureFeatureHandlingFeatureOwnerActionTab;
import com.exigen.ren.main.pages.summary.claim.ClaimAdjudicationBenefitPage;
import org.openqa.selenium.By;

public class RecalculateSingleBenefitAmountAction implements Action {

    @Override
    public String getName() {
        return "Recalculate Single Benefit Amount";
    }

    @Override
    public Workspace getWorkspace() {
        return AutomationContext.getAction(CalculateSingleBenefitAmountAction.class).getWorkspace();
    }

    @Override
    public Action start() {
        throw new UnsupportedOperationException("start() method without parameters is not supported for this action. Use start(int rowNumber) instead.");
    }

    public Action start(int rowNumber) {
        NavigationPage.toSubTab(NavigationEnum.ClaimTab.ADJUDICATION.get());
        ClaimAdjudicationBenefitPage.tableAllSingleBenefitCalculations.getRow(rowNumber).getCell(ClaimConstants.ClaimAllSingleBenefitCalculationsTable.SINGLE_BENEFIT_NUMBER).controls.links.getFirst().click();
        new Button(By.xpath("//a[text()='Recalculate Single Benefit Amount']")).click();
        return this;
    }

    @Override
    public Action perform(TestData td) {
        throw new UnsupportedOperationException("perform(TestData td) method is not supported for this action. Use perform(TestData td, int rowNumber) instead.");
    }

    public Action perform(TestData td, int rowNumber) {
        start(rowNumber);
        getWorkspace().fill(td);
        return submit();
    }

    @Override
    public Action submit() {

        Tab.buttonSaveAndExit.click();

        //TODO Check and replace or delete
        if(FeatureFeatureHandlingFeatureOwnerActionTab.buttonPopupOk.isPresent()) {
            FeatureFeatureHandlingFeatureOwnerActionTab.buttonPopupOk.click();
        }

        Tab.buttonTopCancel.click();
        if(!ClaimAdjudicationBenefitPage.tableAllSingleBenefitCalculations.isPresent() && Tab.buttonTopCancel.isPresent()){
            Tab.buttonTopCancel.click();
        }
        return this;
    }
}
