/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.reports.templates.pages;

import com.exigen.ipb.eisa.controls.dialog.DialogAssetList;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.FileUpload;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;

public class TemplatesSummaryPage {
    public static final Button buttonImport = new Button(By.id("actions:importBtn"));
    public static final Button buttonExport = new Button(By.id("actions:exportBtn"));
    public static final Button buttonValidate = new Button(By.id("actions:validateBtn"));

    public static final Table tableTemplatesList = new Table(By.id("templatesForm:metadataTable"));

    public static final DialogAssetList dialogImportTemplate = new DialogAssetList(DialogAssetList.getDefaultPopupParentLocator(), TemplateImportTab.TemplateImportFile.class);

    public static final StaticElement labelNoErrors = new StaticElement(By.xpath("//td[normalize-space(text()) = 'no errors']"));


    public static class TemplateImportTab extends MetaData {
        public static final AssetDescriptor<DialogAssetList> IMPORT_FILE = declare("Import File", DialogAssetList.class, TemplateImportFile.class);

        public static class TemplateImportFile extends MetaData {
            public static final AssetDescriptor<FileUpload> SELECT_FILE = declare("Select file", FileUpload.class, Waiters.SLEEP(1000), By.id("importTemplateForm:templateFileupload"));
        }
    }
}
