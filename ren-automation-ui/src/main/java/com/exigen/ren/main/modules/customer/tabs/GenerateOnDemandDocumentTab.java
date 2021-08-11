/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.customer.metadata.GenerateOnDemandDocumentTabMetaData;
import org.openqa.selenium.By;

public class GenerateOnDemandDocumentTab extends DefaultTab {
    public static final Table tableDocumentTemplates = new Table(By.xpath("//div[@id='manualDocGenTemplateForm:documentTemplates']//table"));

    public static final Button buttonGenerate = new Button(By.id("manualDocGenForm:btnGenerate_footer"));

    public GenerateOnDemandDocumentTab() {
        super(GenerateOnDemandDocumentTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        buttonGenerate.click();
        Page.dialogConfirmation.confirm();
        return this;
    }
}
