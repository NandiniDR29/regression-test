/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.common.module.efolder.defaulttabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.module.efolder.metadata.RenameFileTabMetaData;
import org.openqa.selenium.By;

public class RenameFileTab extends Tab {
    public static final Button buttonOk = new Button(By.id("renameDocumentForm:okBtn"));

    public RenameFileTab() {
        super(RenameFileTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        buttonOk.click();
        return this;
    }
}
