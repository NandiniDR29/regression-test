/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.policy.common.tabs.master;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.modules.policy.common.metadata.master.IssueActionTabMetaData;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import org.openqa.selenium.By;

import static com.exigen.ren.common.enums.NavigationEnum.GroupBenefitsTab.ISSUE;

/**
 * Implementation of a specific tab in a workspace.
 * Tab classes from the default workspace are named <TAB LABEL>Tab, whereas all other tab classes - <TAB LABEL>ActionTab (to prevent duplication).
 * Modify this class if tab filling procedure has to be customized, extra asset list to be added, custom testdata key to be defined, etc.
 *
 * @category Generated
 */
public class IssueActionTab extends ActionTab {
    public static Button buttonPurchase = new Button(By.xpath("//input[@value = 'Purchase' and not(@class = 'hidden') and not(contains(@style,'none'))]"));

    public IssueActionTab() {
        super(IssueActionTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        IssueActionTab.buttonPurchase.click();
        Page.dialogConfirmation.confirm();
        return this;
    }

    @Override
    public String getTabName() {
        return ISSUE.get();
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.leftMenu(this.getTabName());
        return this;
    }
}
