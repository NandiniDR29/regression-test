/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.product.scheme.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.admin.modules.product.scheme.metadata.CloseSchemeMetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import org.openqa.selenium.By;

public class CloseSchemeTab extends DefaultTab {
    public static final Button buttonOk = new Button(By.id("schemeCloseForm:closeBtn"));
    public static final Button buttonCancel = new Button(By.id("schemeCloseForm:cancelBtn"));

    public CloseSchemeTab() {
        super(CloseSchemeMetaData.class);
    }

    @Override
    public Tab submitTab() {
        buttonOk.click();
        return this;
    }
}
