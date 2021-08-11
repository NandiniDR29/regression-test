/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.product.productfactory.policy.tabs;

import com.exigen.ipb.eisa.controls.productfactory.custom.PFButton;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.ren.admin.modules.product.productfactory.metadata.ProductMetaData;
import org.openqa.selenium.By;

public class NewProductTab {
    private PFButton btnSave = new PFButton(By.id("product:save"));
    private AssetList assetList;

    public NewProductTab() {
        assetList = new AssetList(By.id("product"), ProductMetaData.NewProductTab.class);
        assetList.applyConfiguration("NewProduct");
    }

    public NewProductTab fillTab(TestData testData) {
        assetList.fill(testData);
        return this;
    }

    public NewProductTab submitTab() {
        btnSave.click();
        return this;
    }
}
