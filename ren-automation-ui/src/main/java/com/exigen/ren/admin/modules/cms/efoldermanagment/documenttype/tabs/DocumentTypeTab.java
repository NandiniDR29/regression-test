/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.cms.efoldermanagment.documenttype.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.admin.modules.cms.efoldermanagment.documenttype.metadata.DocumentTypeMetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.Page;
import org.openqa.selenium.By;

public class DocumentTypeTab extends DefaultTab {
    public Button buttonUpdade = new Button(By.id("docTypeForm:updateBtn_footer"));

    public DocumentTypeTab() {
        super(DocumentTypeMetaData.class);
    }

    @Override
    public Tab submitTab() {
        if (buttonSave.isPresent()) {
            buttonSave.click();
        } else{
            buttonUpdade.click();
            Page.dialogConfirmation.confirm();
        }

        return this;
    }
}
