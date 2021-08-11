/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.modules.claim.common.actions;

import com.exigen.istf.data.TestData;
import com.exigen.istf.exceptions.IstfException;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import org.openqa.selenium.By;

public class AddBenefitAction implements Action {

    @Override
    public String getName() {
        return "Add Benefit";
    }

    @Override
    public Workspace getWorkspace() {
        throw new IstfException("Default Add Benefit action for claim was called. Implement this action for specific claim type.");
    }

    public Action start(String damageType) {
        NavigationPage.toSubTab(NavigationEnum.ClaimTab.ADJUDICATION.get());
        new Button(By.xpath("//a[text()='Add Benefit: " + damageType + "']")).click();
        return this;
    }

    public Action perform(TestData td, String dt) {
        start(dt);
        getWorkspace().fill(td);
        return submit();
    }

    @Override
    public Action start() {
        NavigationPage.toSubTab(NavigationEnum.ClaimTab.ADJUDICATION.get());
        return this;
    }

    @Override
    public Action perform(TestData td) {
        start();
        getWorkspace().fill(td);
        return submit();
    }

    @Override
    public Action submit() {
        Tab.buttonSaveAndExit.click();
        Tab.buttonTopCancel.click();
        return this;
    }
}
