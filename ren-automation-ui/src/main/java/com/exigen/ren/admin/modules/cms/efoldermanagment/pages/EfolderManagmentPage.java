/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.cms.efoldermanagment.pages;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.admin.modules.common.pages.AdminPage;
import org.openqa.selenium.By;

public class EfolderManagmentPage extends AdminPage {
    public static final Link linkDocumentTypes = new Link(By.id("efolderMenuForm:efolderMenuItemsList:1:link"));

    public static final Table tableAvailableTypes = new Table(By.id("docTypeSelectForm:dt"));
    public static final Table tableDocumentTypeEntity = new Table(By.xpath("//td[@class='valignTop size100 noSurround']//table[@class='rf-dt table_style']"));
    public static final Table tableSupportFileList = new Table(By.id("fileListForm:listFiles"));

    public static final Button buttonAddNew = new Button(By.id("docTypeSelectForm:addBtn_footer"));
    public static final Button buttonAddSubfolder = new Button(By.xpath("//input[@value='Add Subfolder']"));
    public static final Button buttonEfolderTreeEntityRootFolder = new Button(By.xpath("//div[@class='rf-trn']/span"));
    public static final Button buttonSupportUpload = new Button(By.id("fileListForm:upload-new-file"));
}
