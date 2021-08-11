/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.product.productfactory.policy;

import com.exigen.ipb.eisa.controls.dialog.DialogAssetList;
import com.exigen.ipb.eisa.controls.productfactory.custom.PFButton;
import com.exigen.ipb.eisa.controls.productfactory.custom.PFLink;
import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.product.productfactory.IProductFactory;
import com.exigen.ren.admin.modules.product.productfactory.ProductFactoryActions.Copy;
import com.exigen.ren.admin.modules.product.productfactory.ProductFactoryActions.Update;
import com.exigen.ren.admin.modules.product.productfactory.metadata.ProductMetaData;
import com.exigen.ren.admin.modules.product.productfactory.pages.CommonProductFactoryPage;
import com.exigen.ren.admin.modules.product.productfactory.pages.ProductProductFactoryPage;
import com.exigen.ren.admin.modules.product.productfactory.policy.ProductFactoryPolicyActions.Inquiry;
import com.exigen.ren.admin.modules.product.productfactory.policy.tabs.HomeTab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import org.openqa.selenium.By;

public class ProductFactoryPolicy implements IProductFactory {

    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/productfactory/policy");

    private DialogAssetList dialogAssetListSelectProductType = new DialogAssetList(DialogAssetList.getDefaultPopupParentLocator(), ProductMetaData.ProductProductFactorySelectProductType.class);
    private DialogAssetList dialogAssetListExpireProduct = new DialogAssetList(DialogAssetList.getDefaultPopupParentLocator(), ProductMetaData.ProductProductFactoryExpire.class);
    private DialogAssetList dialogAssetListImportProduct = new DialogAssetList(DialogAssetList.getDefaultPopupParentLocator(), ProductMetaData.ProductProductFactoryImport.class);
    private PFButton buttonMenuSwitcher = new PFButton(By.xpath("//div[@role='button' and @class='product-wrapper waves-effect']"));
    private PFLink linkNavigateBack = new PFLink(By.id("nav:back"));

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
    public void initiate(TestData td) {
        navigate();
        ProductProductFactoryPage.buttonAddNewProduct.click();
        dialogAssetListSelectProductType.fill(td);
    }

    @Override
    public void submit() {
        CommonProductFactoryPage.activateNavigation();
        new HomeTab().activateProduct();
        CommonProductFactoryPage.activateNavigation();
        buttonMenuSwitcher.waitForAccessible(5000);
        buttonMenuSwitcher.click();
        linkNavigateBack.click();
    }

    @Override
    public void searchAndOpen(TestData td) {
        ProductProductFactoryPage.searchAndOpen(td);
    }

    @Override
    public void expire(TestData td) {
        ProductProductFactoryPage.expire(td);
        dialogAssetListExpireProduct.fill(td);
    }

    @Override
    public void importProduct(TestData td) {
        dialogAssetListImportProduct.fill(td);
        submit();
    }

    @Override
    public void search(TestData td) {
        ProductProductFactoryPage.search(td);
    }

    @Override
    public Copy copy() {
        return new ProductFactoryPolicyActions.Copy();
    }

    @Override
    public Update update() {
        return new ProductFactoryPolicyActions.Update();
    }

    @Override
    public Inquiry inquiry() {
        return new ProductFactoryPolicyActions.Inquiry();
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }
}
