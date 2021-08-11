/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.commission.commissiontemplate.pages;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.admin.modules.commission.common.metadata.CommissionSearchTabMetaData;
import com.exigen.ren.admin.modules.common.pages.AdminPage;
import org.openqa.selenium.By;

public class CommissionTemplatePage extends AdminPage {
    public static AssetList assetListSearchForm = new AssetList(By.id("templateForm"), CommissionSearchTabMetaData.class);
    public static Button buttonSearch = new Button(By.id("templateForm:searchBtn_footer"));
    public static Button buttonAddNewCommissionTemplate = new Button(By.id("templateForm:showAddTemplatePopup"));
    public static Button buttonOK = new Button(By.xpath("//input[contains(@id, 'addTemplateDialogForm_groupBenefits') and @value = 'OK']"));
    public static ComboBox comboboxCommissionTemplateType = new ComboBox(By.id("templateForm:templateTypeForAdd"));
    public static Table tableCommissionTemplate = new Table(By.xpath("//div[@id='templateForm:searchResultTable']//table[@class='table']"));

    public static void search(TestData td) {
        assetListSearchForm.fill(td);
        buttonSearch.click();
    }
}
