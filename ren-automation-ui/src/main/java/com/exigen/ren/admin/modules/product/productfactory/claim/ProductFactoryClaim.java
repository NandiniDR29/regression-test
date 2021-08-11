/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.product.productfactory.claim;

import com.exigen.ipb.eisa.controls.dialog.DialogAssetList;
import com.exigen.ipb.eisa.controls.productfactory.custom.PFButton;
import com.exigen.ipb.eisa.controls.productfactory.custom.PFLink;
import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.product.productfactory.IProductFactory;
import com.exigen.ren.admin.modules.product.productfactory.ProductFactoryActions;
import com.exigen.ren.admin.modules.product.productfactory.metadata.ProductMetaData;
import com.exigen.ren.admin.modules.product.productfactory.pages.ProductProductFactoryPage;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import org.openqa.selenium.By;

public class ProductFactoryClaim implements IProductFactory {
    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/productfactory/claim");
    private DialogAssetList dialogAssetlistSelectProductType = new DialogAssetList(DialogAssetList.getDefaultPopupParentLocator(), ProductMetaData.ProductProductFactorySelectProductType.class);
    private DialogAssetList dialogAssetListExpireProduct = new DialogAssetList(DialogAssetList.getDefaultPopupParentLocator(), ProductMetaData.ProductProductFactoryExpire.class);
    private PFButton buttonMenuSwitcher = new PFButton(By.xpath("//div[@role='button' and @class='product-wrapper waves-effect']"));
    private PFLink linkNavigateBack = new PFLink(By.id("nav:back"));

    @Override
    public void initiate(TestData td) {
        navigate();
        ProductProductFactoryPage.buttonAddNewProduct.click();
        dialogAssetlistSelectProductType.fill(td);
    }

    @Override
    public void submit() {

    }

    @Override
    public void searchAndOpen(TestData td) {

    }

    @Override
    public void expire(TestData td) {

    }

    @Override
    public void importProduct(TestData td) {

    }

    @Override
    public ProductFactoryActions.Copy copy() {
        return null;
    }

    @Override
    public ProductFactoryActions.Update update() {
        return null;
    }

    @Override
    public ProductFactoryActions.Inquiry inquiry() {
        return null;
    }

    @Override
    public void search(TestData td) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public Workspace getDefaultWorkspace() {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void create(TestData td) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void navigate() {
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.PRODUCT);
        NavigationPage.toLeftMenuTab(NavigationEnum.ProductLeftMenu.PRODUCT_FACTORY);
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }
}
