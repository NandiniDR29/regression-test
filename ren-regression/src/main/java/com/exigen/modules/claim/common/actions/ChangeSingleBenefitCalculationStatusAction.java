/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.modules.claim.common.actions;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.ActionConstants;
import com.exigen.ren.main.modules.claim.common.tabs.ChangeStatusActionTab;
import com.exigen.ren.main.pages.summary.claim.ClaimAdjudicationBenefitPage;
import org.openqa.selenium.By;

import static com.exigen.basetest.CommonBaseTest.reportLog;

public class ChangeSingleBenefitCalculationStatusAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(ChangeStatusActionTab.class)
            .build();
    public String getName() {
        return "Change Single Benefit Calculation Status";
    }


    public Workspace getWorkspace() {
        return workspace;
    }

    public Action start(int rowNumber) {
        reportLog("Navigate Adjudication section ", 1);
        NavigationPage.toSubTab(NavigationEnum.ClaimTab.ADJUDICATION.get());
        reportLog("SingleBenefitCalculations ", 1);
        ClaimAdjudicationBenefitPage.tableAllSingleBenefitCalculations.getRow(rowNumber).getCell(7).controls.links.get(ActionConstants.ACTIONS).click();
        return this;
    }
    public Action submit() {
        new Button(By.id("policyDataGatherForm:okProcessClaimsDamageActionBtn_ClaimsDamageStatusAction_footer")).click();
        return this;
    }
}
