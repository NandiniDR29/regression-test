/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.brand.pages;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.admin.modules.agencyvendor.brand.metadata.BrandMetaData;
import com.exigen.ren.admin.modules.common.pages.AdminPage;
import org.openqa.selenium.By;

public class BrandPage extends AdminPage {

    public static final Button buttonAddBrandType = new Button(By.id("brandTypeForm:addBrandType"));
    public static final AssetList assetListAddBrandType = new AssetList(By.id("brandTypeEditForm:brandTypeEditDialog"), BrandMetaData.AddBrandTypeDialog.class);
    public static final Table tableBrandType = new Table(By.xpath("//div[@id='brandTypeForm:brandsTypeTable']//table"));

    public static final Button buttonAddBrand = new Button(By.id("brandInfoForm:addBrand"));
    public static final AssetList assetListAddBrand = new AssetList(By.id("brandEditForm:brandEditDialog"), BrandMetaData.AddBrandDialog.class);
    public static final Table tableBrands = new Table(By.xpath("//div[@id='brandInfoForm:brandsTable']//table"));

    public static void expandBrandType() {
        Link collapsedBrandType = new Link(By.xpath("//div[text()='Brand Types' and contains(@class, 'colps')]"));
        if (collapsedBrandType.isPresent()) {
            collapsedBrandType.click();
        }
    }
}
