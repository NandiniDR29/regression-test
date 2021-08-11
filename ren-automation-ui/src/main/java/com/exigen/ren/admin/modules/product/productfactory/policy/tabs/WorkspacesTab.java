/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.product.productfactory.policy.tabs;

import com.exigen.ipb.eisa.controls.productfactory.custom.PFButton;
import com.exigen.ipb.eisa.controls.productfactory.custom.PFCheckBox;
import com.exigen.ipb.eisa.controls.productfactory.custom.PFLink;
import com.exigen.ipb.eisa.controls.productfactory.custom.PFTextBox;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.BrowserController;
import com.exigen.istf.webdriver.controls.BaseElement;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.istf.webdriver.controls.waiters.ElementWaiter;
import com.exigen.istf.webdriver.controls.waiters.LocatorWaiter;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.admin.modules.product.productfactory.DefaultTab;
import com.exigen.ren.admin.modules.product.productfactory.metadata.ProductMetaData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WorkspacesTab extends DefaultTab {
    //General assetlist for properties at the right part of view
    protected static final Logger LOGGER = LoggerFactory.getLogger(WorkspacesTab.class);

    private AssetList assetList = new AssetList(By.xpath("//*"), ProductMetaData.WorkspacesTab.class);

    //inner instances
    private AdvancedFilter advancedFilter = new AdvancedFilter();
    private Workspace workspace = new Workspace();
    private ManageActions manageAction = new ManageActions();
    private Tab tab = new Tab();

    // Workspace adding controls
    private PFButton btnCreateNewWorkspaceDone = new PFButton(By.id("ws-create:saveBtn"));
    private PFButton btnDeleteWorkspace = new PFButton(By.id("workspace-actions:rm-ws"));

    // Tab adding controls
    private PFButton btnAddNewTab = new PFButton(By.id("tree-bar-right:addTab"), new LocatorWaiter(By.id("tab-add:addBtn")).then(Waiters.SLEEP(1000)));
    private PFTextBox txtTabName = new PFTextBox(By.xpath("//input[@id='tab-add:name']"));
    private PFButton btnDone = new PFButton(By.id("tab-add:addBtn"));
    private PFButton btnSave = new PFButton(By.id("persistence:save"));
    // Assign component controls
    private PFTextBox txtComponentReferenceName = new PFTextBox(By.id("quick-search:quick-search-field"));
    private PFButton btnAssignComponent = new PFButton(By.id("quick-search:quick-add"));
    private PFButton btnRemove = new PFButton(By.id("tab-actions:rm-tab"));
    private PFButton btnConfirm = new PFButton(By.id("tab-remove:ok"));

    public WorkspacesTab() {
        txtTabName.setName("Tab Name");
        txtComponentReferenceName.setName("Assign Component Reference Name");
    }

    @Override
    public WorkspacesTab open() {
        return super.open();
    }

    public AssetList getAssetList() {
        return assetList;
    }

    /**
     * @return workspace object with access to different information required for tests
     */
    public Workspace workspace() {
        return workspace;
    }

    public ManageActions manageAction() {
        return manageAction;
    }

    public AdvancedFilter advancedFilter() {
        return advancedFilter;
    }

    public Tab tab() {
        return tab;
    }

    public WorkspacesTab deleteWorkspace() {
        PFButton btnRemoveConfirmation = new PFButton(By.id("ws-remove:ok"));
        btnDeleteWorkspace.click(new ElementWaiter(btnRemoveConfirmation));
        btnRemoveConfirmation.click();
        return submit();
    }

    public WorkspacesTab addTab(TestData td) {
        selectTabNode(td);
        btnAddNewTab.click();
        txtTabName.waitFor(BaseElement::isEnabled);
        txtTabName.fill(td);
        btnDone.click();
        return submit();
    }

    public WorkspacesTab addTabs(List<TestData> tdList) {
        tdList.forEach(this::addTab);
        return submit();
    }

    public WorkspacesTab addWorkspace(String name, boolean generateTabs) {
        new PFLink(By.xpath("//form[@id='tree-context']/button[@data-toggle='dropdown']")).click(Waiters.AJAX.then(Waiters.SLEEP(1000)));

        new PFLink(By.id("tree-context:new-ws")).click(Waiters.DEFAULT.then(new ElementWaiter(btnCreateNewWorkspaceDone)));
        new PFTextBox(By.id("ws-create:ws-name")).setValue(name, Waiters.DEFAULT);
        if (generateTabs) {
            new PFButton(By.xpath("//label[contains(.,'Generate tabs') and input[@type='checkbox' ]]/span")).click();
        }
        btnCreateNewWorkspaceDone.click();
        return submit();
    }

    public WorkspacesTab removeTabs(TestData td) {
        td.getTestDataList("removeTabs").forEach(this::removeTab);
        return submit();
    }

    private void removeTab(TestData td) {
        selectTabNode(td);
        btnRemove.click();
        btnConfirm.click();
    }

    public WorkspacesTab assignComponent(TestData td) {
        selectTabNode(td);
        txtComponentReferenceName.waitFor(120000, BaseElement::isPresent);
        txtComponentReferenceName.fill(td);
        btnAssignComponent.click();
        return submit();
    }

    public WorkspacesTab selectTabNode(TestData td) {
        if (td.containsKey("Path")) {
            List<String> path = td.getList("Path");
            new PFLink(By.xpath(String.format("//h3[normalize-space(.)='%s']", path.get(path.size() - 1)))).click();
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
    public WorkspacesTab submit() {
        btnSave.waitFor(BaseElement::isEnabled);
        btnSave.click();
        return this;
    }

    public class Tab {
        public List<String> getAssignedComponents() {
            return BrowserController.get().driver().findElements(By.xpath("//div[@class='pf-list-item item']//a[contains(@id,'assigned-component')]"))
                    .stream().map(WebElement::getText).collect(Collectors.toList());
        }
    }

    public class ManageActions {
        private static final String ACTION_LOCATOR_TMPL = "//form[@id='ws-assign']//h3[.='%s']/ancestor::div[@class='pf-list-item']//label[//input]";
        private PFButton btnOpenManageActions = new PFButton(By.id("ws-assign-actions:manage"));
        private PFButton btnSaveActions = new PFButton(By.xpath("//form[@id='ws-assign']//button[normalize-space(.)='Save']"));

        public ManageActions open() {
            btnOpenManageActions.click(Waiters.DEFAULT.then(new ElementWaiter(btnSaveActions)));
            return this;
        }

        public Map<String, Boolean> getActionsValue(List<TestData> tdList) {
            open();
            Map value = tdList.stream().collect(Collectors.toMap(td -> td.getValue("name"),
                    td -> new PFCheckBox(By.xpath(String.format(ACTION_LOCATOR_TMPL, td.getValue("name"))))
                            .getValue()));
            save();
            return value;
        }

        public WorkspacesTab setActions(List<TestData> testData) {
            open();
            testData.forEach(td ->
                    new PFCheckBox(By.xpath(String.format(ACTION_LOCATOR_TMPL, td.getValue("name"))))
                            .setValue(Boolean.parseBoolean(td.getValue("value")))
            );
            return save();
        }

        public WorkspacesTab save() {
            btnSaveActions.click();
            return WorkspacesTab.this;
        }
    }

    /**
     * Class for getting information about workspace entity
     */
    public class Workspace {
        public String getName() {
            return new StaticElement(By.className("workspaceName")).getValue();
        }

        /**
         * @return true if workspace can be deleted (Delete button is present)
         */
        public boolean isRemovable() {
            return btnDeleteWorkspace.isPresent();
        }

        /**
         * @return count of the expanded tabs at current workspace
         */
        public int getTabs() {
            return BrowserController.get().driver().findElements(By.xpath("//h3[@class='tabName']")).size();
        }

        /**
         * Return available workspace count
         *
         * @return count of workspaces
         */
        public int getWorkspaceCount() {
            BrowserController.get().driver().findElements(By.xpath("//form[@id='tree-context']//li[.='Workspaces']/following-sibling::li/a"))
                    .forEach(element -> LOGGER.info(element.getAttribute("text")));
            return BrowserController.get().driver().findElements(By.xpath("//form[@id='tree-context']//li[.='Workspaces']/following-sibling::li")).size();
        }

        public Workspace open(String workspace) {
            new PFLink(By.xpath("//form[@id='tree-context']/button[@data-toggle='dropdown']")).click(Waiters.AJAX.then(Waiters.SLEEP(1000)));
            new PFLink(By.xpath(String.format("//form[@id='tree-context']//a[normalize-space(.)='%s']", workspace))).click();
            return this;
        }
    }

    public class AdvancedFilter {
        private PFButton btnOpenFilter = new PFButton(By.id("quick-search:open-filter"));
        private PFButton btnCloseFilter = new PFButton(By.xpath("//div[@id='advanced-filter-modal']//button[normalize-space(.)='Close']"));
        private Table tableComponents = new Table(By.id("available-components:availableComponentsTable"));
        private PFTextBox txtFilter = new PFTextBox(By.id("filter:cmpFilter"));

        public AdvancedFilter open() {
            btnOpenFilter.click(new ElementWaiter(btnCloseFilter));
            return this;
        }

        public WorkspacesTab close() {
            btnCloseFilter.click();
            btnCloseFilter.waitForAccessible(1000, false);
            return WorkspacesTab.this;
        }

        public Table getTableComponents() {
            return tableComponents;
        }

        public AdvancedFilter setFilter(String filterValue) {
            txtFilter.setValue(filterValue);
            return this;
        }
    }

}
