/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.workflow.processmanagement.pages;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.*;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.admin.modules.common.pages.AdminPage;
import com.exigen.ren.common.components.Dialog;
import org.openqa.selenium.By;

public class ProcessManagementPage extends AdminPage {

    public static final AssetList assetListSearchForm = new AssetList(By.id("manualTaskDefinitionsFilterForm"), SearchProcessManagement.class);
    public static final Button buttonAddManualTaskDefinition = new Button(By.id("processDefinitionsForm:createNewTaskDefinitionBtn"));
    public static final Button buttonDeployProcessDefinition = new Button(By.id("processDefinitionsForm:deployProcessLinkID"));

    public static final Button buttonSave =
            new Button(By.xpath("//*[@id='manualTaskDefinitionCommandForm:submitSave_footer' or @id='manualTaskDefinitionCommandForm:submitUpdate_footer']"));
    public static final Button buttonSearch = new Button(By.id("manualTaskDefinitionsFilterForm:filterSearchBtn"));
    public static final Table tableSearchResults = new Table(By.xpath("//div[@id='processDefinitionsForm:deployedProcDef']//table"));
    public static final Dialog dialogDeployProcess = new Dialog("//div[@id='deployProcessDialog']");
    public static final StaticElement uploadStatusMsg = new StaticElement(By.xpath(ProcessManagementPage.dialogDeployProcess.getLocator() + "//span[@class='ui-messages-info-summary']"));

    public static void search(TestData td) {
        assetListSearchForm.fill(td);
        buttonSearch.click();
    }

    public static class SearchProcessManagement extends MetaData {
        public static final AssetDescriptor<ComboBox> ENTITY_TYPE = declare("Entity Type", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PROCESS_TYPE = declare("Process Type", ComboBox.class);
        public static final AssetDescriptor<TextBox> TASK_NAME = declare("Task name", TextBox.class);
        public static final AssetDescriptor<CheckBox> ACTIVE_ONLY = declare("Active only", CheckBox.class);
    }

}
