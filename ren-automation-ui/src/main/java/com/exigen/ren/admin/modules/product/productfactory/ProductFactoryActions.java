/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.product.productfactory;

import com.exigen.ipb.eisa.controls.dialog.DialogAssetList;
import com.exigen.istf.data.TestData;
import com.exigen.ren.admin.modules.product.productfactory.metadata.ProductMetaData;
import com.exigen.ren.admin.modules.product.productfactory.pages.CommonProductFactoryPage;
import com.exigen.ren.admin.modules.product.productfactory.pages.ProductProductFactoryPage;
import com.exigen.ren.admin.modules.product.productfactory.policy.tabs.HomeTab;
import com.exigen.ren.common.AbstractAction;
import com.exigen.ren.main.enums.ProductConstants;

public class ProductFactoryActions {

    public abstract static class Copy extends AbstractAction {
        private static final Object lock = new Object();

        @Override
        public AbstractAction start() {
            throw new UnsupportedOperationException("start() method is not supported for this action. Use start(TestData testData) instead.");
        }

        public AbstractAction start(TestData td) {
            ProductProductFactoryPage.search(td);
            ProductProductFactoryPage.tableProducts.getRow(ProductConstants.ProductTable.PRODUCT_CODE, td.getValue(ProductMetaData.ProductProductFactorySearch.class.getSimpleName(), "Product Code")).getCell(
                    ProductConstants.ProductTable.COPY_PRODUCT).controls.links
                    .getFirst().click();
            new DialogAssetList(DialogAssetList.getDefaultPopupParentLocator(), ProductMetaData.ProductProductFactoryCopy.class).fill(td);
            return this;
        }

        @Override
        public AbstractAction perform(TestData td) {
            synchronized (lock) {
                start(td);
                submit();
                return this;
            }
        }

        @Override
        public AbstractAction submit() {
            CommonProductFactoryPage.activateNavigation();
            HomeTab homeTab = new HomeTab();
            homeTab.activateProduct();
            CommonProductFactoryPage.activateNavigation();
            homeTab.returnToSearch();
            return this;
        }
    }

    public abstract static class Update extends AbstractAction {

        @Override
        public AbstractAction start() {
            throw new UnsupportedOperationException("start() method is not supported for this action. Use start(TestData testData) instead.");
        }

        public AbstractAction start(TestData td) {
            ProductProductFactoryPage.search(td);
            ProductProductFactoryPage.tableProducts.getRow(ProductConstants.ProductTable.PRODUCT_CODE, td.getValue(ProductMetaData.ProductProductFactorySearch.class.getSimpleName(), "Product Code"))
                    .getCell(ProductConstants.ProductTable.PRODUCT_NAME).controls.links.getFirst().click();
            new DialogAssetList(DialogAssetList.getDefaultPopupParentLocator(), ProductMetaData.ProductProductFactoryCopy.class).fill(td);
            return this;
        }

        @Override
        public AbstractAction perform(TestData td) {
            throw new UnsupportedOperationException("Perform is not defined for PF. Please use direct Tabs methods to fill and view the data");
        }

        @Override
        public AbstractAction submit() {
            HomeTab homeTab = new HomeTab();
            homeTab.activateProduct();
            CommonProductFactoryPage.activateNavigation();
            homeTab.returnToSearch();
            return this;
        }
    }

    public abstract static class Inquiry extends AbstractAction {

        @Override
        public AbstractAction start() {
            throw new UnsupportedOperationException("start() method is not supported for this action. Use start(TestData testData) instead.");
        }

        public AbstractAction start(TestData td) {
            ProductProductFactoryPage.search(td);
            ProductProductFactoryPage.tableProducts.getRow(ProductConstants.ProductTable.PRODUCT_CODE, td.getValue(ProductMetaData.ProductProductFactorySearch.class.getSimpleName(), "Product Code"))
                    .getCell(ProductConstants.ProductTable.PRODUCT_NAME).controls.links.getFirst().click();
            return this;
        }

        @Override
        public AbstractAction perform(TestData td) {
            throw new UnsupportedOperationException("Perform is not defined for PF. Please use direct Tabs methods to fill and view the data");
        }

        @Override
        public AbstractAction submit() {
            CommonProductFactoryPage.activateNavigation();
            new HomeTab().returnToSearch();
            return this;
        }
    }
}


