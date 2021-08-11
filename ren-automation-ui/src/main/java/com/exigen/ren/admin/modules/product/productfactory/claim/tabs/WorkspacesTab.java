/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.product.productfactory.claim.tabs;

import com.exigen.ipb.eisa.controls.productfactory.custom.PFButton;
import com.exigen.ipb.eisa.controls.productfactory.custom.PFLink;
import com.exigen.ipb.eisa.controls.productfactory.custom.PFTextBox;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.waiters.LocatorWaiter;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.admin.modules.product.productfactory.DefaultTab;
import org.openqa.selenium.By;

import java.util.List;

public class WorkspacesTab extends DefaultTab {
    private static final String LINK_XPATH_TMPL = "//h3[.='%s']";
    // Tab adding controls
    public PFButton btnAddNewTab = new PFButton(By.id("tree-bar-right:addTab"), new LocatorWaiter(By.id("tab-add:addBtn")).then(Waiters.SLEEP(1000)));
    public PFTextBox txtTabName = new PFTextBox(By.xpath("//input[@id='tab-add:name']"));
    public PFButton btnDone = new PFButton(By.id("tab-add:addBtn"));
    public PFButton btnSave = new PFButton(By.id("persistence:save"));
    // Assign component controls
    public PFTextBox txtComponentReferenceName = new PFTextBox(By.id("quick-search:quick-search-field"));
    public PFButton btnAssignComponent = new PFButton(By.id("quick-search:quick-add"));

    public WorkspacesTab() {
        txtTabName.setName("Tab Name");
        txtComponentReferenceName.setName("Assign Component Reference Name");
    }

    public WorkspacesTab addTab(TestData td) {
        open();
        btnAddNewTab.click();
        txtTabName.fill(td);
        btnDone.click();
        return submit();
    }

    public WorkspacesTab assignComponent(TestData td) {
        open();
        selectTabNode(td);
        txtComponentReferenceName.fill(td);
        btnAssignComponent.click();
        return submit();
    }

    public WorkspacesTab selectTabNode(TestData td) {
        if (td.containsKey("Path")) {
            List<String> path = td.getList("Path");
            new PFLink(By.xpath(String.format(LINK_XPATH_TMPL, path.get(path.size() - 1)))).click();
        }
        return this;
    }

    @Override
    protected String tabName() {
        return "Workspaces";
    }

    /**
     * Save changes on the tab
     */
    private WorkspacesTab submit() {
        if (btnSave.isPresent()) {
            btnSave.click();
        }
        return this;
    }
}
