/* Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent. */
package com.exigen.ren.admin.modules.billing.billingcycle.recurring.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.ren.admin.modules.billing.billingcycle.recurring.metadata.EFTRecurringBenefitsGeneralMetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.Page;
import org.openqa.selenium.By;

public class EFTRecurringBenefitsTab extends DefaultTab {

    public static final Button buttonAdd = new Button(By.id("eftRecurringForm:addButton_footer"));
    public static final TableExtended<EFTRecurring> tableEFTRecurring = new TableExtended<>("Benefits table", By.id("eftRecurringForm:txSearchResult"));

    public EFTRecurringBenefitsTab() {
        super(EFTRecurringBenefitsGeneralMetaData.class);
        assetList = new MultiAssetList(By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER), metaDataClass) {
            @Override
            protected void addSection(int index, int size) {
                buttonAdd.click();
            }

            @Override
            protected void selectSection(int index) {
            }


            @Override
            protected void setSectionValue(int index, TestData value) {
                super.setSectionValue(index, value);
                buttonSave.click();
            }
        };
        assetList.setName(this.getClass().getSimpleName());
    }

    @Override
    public Tab submitTab() {
        return this;
    }

    public enum EFTRecurring implements Named {
        BROAD_LINE_OF_BUSINESS("Broad Line of Business"),
        PRODUCTS("Products"),
        BRANDS("Brands"),
        GEOGRAPHY("Geography"),
        PAYMENT_METHOD_TYPE("Payment Method Type"),
        CALENDAR("Calendar"),
        ACTIONS("Actions");

        private String name;

        EFTRecurring(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}