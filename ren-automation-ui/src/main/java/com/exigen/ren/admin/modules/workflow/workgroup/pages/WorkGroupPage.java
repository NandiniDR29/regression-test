/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.workflow.workgroup.pages;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.admin.modules.common.pages.AdminPage;
import org.openqa.selenium.By;

public class WorkGroupPage extends AdminPage {
    public static final Button buttonAddWorkGroup = new Button(By.id("workGroupsForm:createNewWorkGroup"));
    public static final Table tableAllWorkGroup = new Table(By.xpath("//div[@id='workGroupsForm:workGroupsTable']//table"));
    public static final AssetList assetListWorkGroup = new AssetList(By.xpath("//div[@id='workGroupEditForm:workGroupEditDialog']"), WorkGroupTab.class);
    public static final Button buttonSaveUpdate = new Button(By.id("workGroupEditForm:saveOrUpdateWorkGroupBtn"));

    public static class WorkGroupTab extends MetaData {
        public static final AssetDescriptor<TextBox> CODE = declare("Code", TextBox.class, By.xpath("//input[@id='workGroupEditForm:wgCode']"));
        public static final AssetDescriptor<TextBox> NAME = declare("Name", TextBox.class, By.xpath("//input[@id='workGroupEditForm:wgName']"));
        public static final AssetDescriptor<AdvancedSelector> USERS = declare("Users", AdvancedSelector.class);
        public static final AssetDescriptor<AdvancedSelector> FILTERS = declare("Filters", AdvancedSelector.class);
    }

    public static void fillDialog(TestData td) {
        assetListWorkGroup.fill(td);
    }

}
