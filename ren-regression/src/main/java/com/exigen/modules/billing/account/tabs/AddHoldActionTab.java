/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.billing.account.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.main.modules.billing.account.metadata.AddHoldActionTabMetaData;
import org.openqa.selenium.By;

public class AddHoldActionTab extends ActionTab {

    public static TableExtended<HoldHistory> tableHoldHistory = new TableExtended<>("Hold History", By.xpath("//div[@id='holdForm:holdHistoryTable']//table"));

    public AddHoldActionTab() {
        super(AddHoldActionTabMetaData.class);
    }

    public enum HoldHistory implements Named {

        HOLD_TYPE("Hold Type"),
        EFFECTIVE_DATE("Effective Date"),
        EXPIRATION_DATE("Expiration Date"),
        PERFORMER("Performer");
        private String name;

        HoldHistory(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}