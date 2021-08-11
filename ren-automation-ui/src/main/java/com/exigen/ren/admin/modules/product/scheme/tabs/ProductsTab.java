/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.product.scheme.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.admin.modules.product.scheme.metadata.ProductsMetaData;
import com.exigen.ren.common.Tab;
import org.openqa.selenium.By;

public class ProductsTab extends Tab {
    public Button buttonSaveAndExit = new Button(By.id("schemeManagementForm:saveAndExitAddSchemeHeader_footer"));

    public ProductsTab() {
        super(ProductsMetaData.class);
    }
}
