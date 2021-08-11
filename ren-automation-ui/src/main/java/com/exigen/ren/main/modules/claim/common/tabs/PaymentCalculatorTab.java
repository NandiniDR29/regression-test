/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.common.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.controls.BaseElement;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.claim.common.metadata.PaymentCalculatorActionTabMetaData;
import org.openqa.selenium.By;

import static com.exigen.ren.common.enums.NavigationEnum.ClaimPaymentsTab.CALCULATOR;

public class PaymentCalculatorTab extends DefaultTab {

    public static Button buttonAddTax = new Button(By.id("policyDataGatherForm:addClaimsPaymentTaxCalculator"));
    public static TableExtended<PaymentCalculatorPaymentAddition> tableListOfPaymentAddition = new TableExtended<>("List of Payment Addition",
            By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListClaimsPaymentCalculatorAddition']/div/table"));
    public static final TableExtended<ListOfPaymentReduction> tableListOfPaymentReduction = new TableExtended<>("List of Payment Reduction",
            By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListClaimsPaymentCalculatorReduction']//table"));
    public static final TableExtended<ListOfPaymentTax> tableListOfPaymentTax = new TableExtended<>("List of Payment Tax",
            By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListClaimsPaymentTaxCalculator']//table"));

    public PaymentCalculatorTab() {
        super(PaymentCalculatorActionTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        return this;
    }

    public enum PaymentCalculatorPaymentAddition implements Named {
        ADDITION_TYPE("Addition Type"),
        AMOUNT("Amount");

        private String name;

        PaymentCalculatorPaymentAddition(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.leftMenu(getTabName());
        return this;
    }

    @Override
    public String getTabName() {
        return CALCULATOR.get();
    }

    public enum ListOfPaymentReduction implements Named {
        REDUCTION_TYPE("Reduction Type"),
        BEGINNING_DATE("Beginning Date"),
        THROUGH_DATE("Through Date"),
        AMOUNT("Amount"),
        EXCLUDED("Excluded");

        private String name;

        ListOfPaymentReduction(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum ListOfPaymentTax implements Named {
        TAX_TYPE("Tax Type"),
        BEGINNING_DATE("Beginning Date"),
        THROUGH_DATE("Through Date"),
        AMOUNT("Amount");

        private String name;

        ListOfPaymentTax(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public static class PaymentTaxMultiAssetList extends MultiAssetList {
        public PaymentTaxMultiAssetList(By locator, Class<? extends MetaData> metaDataClass) {
            super(locator, metaDataClass);
        }

        public PaymentTaxMultiAssetList(BaseElement<?, ?> parent, By locator, Class<? extends MetaData> metaDataClass) {
            super(parent, locator, metaDataClass);
        }

        @Override
        protected void addSection(int index, int size) {
            buttonAddTax.click();
        }

        @Override
        protected void selectSection(int index) {

        }
    }

    public static class PaymentAdditionMultiAssetList extends MultiAssetList {
        public static final Button addPaymentAddition = new Button(By.id("policyDataGatherForm:addClaimsPaymentCalculatorAddition"));

        public PaymentAdditionMultiAssetList(BaseElement<?, ?> parent, By locator, Class<? extends MetaData> metaDataClass) {
            super(parent, locator, metaDataClass);
        }

        public PaymentAdditionMultiAssetList(By locator, Class<? extends MetaData> metaDataClass) {
            super(locator, metaDataClass);
        }

        @Override
        protected void addSection(int index, int size) {
            addPaymentAddition.click();
        }

        @Override
        protected void selectSection(int i) {
        }
    }
}
