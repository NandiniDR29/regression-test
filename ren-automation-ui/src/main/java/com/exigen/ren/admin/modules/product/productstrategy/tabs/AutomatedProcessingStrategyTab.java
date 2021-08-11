/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.product.productstrategy.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.admin.modules.product.productstrategy.metadata.AutomatedProcessingStrategyMetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import org.openqa.selenium.By;

public class AutomatedProcessingStrategyTab extends DefaultTab {

    public static final Button submitButton = new Button(By.id("strategyInputForm:submit"));

    public AutomatedProcessingStrategyTab() {
        super(AutomatedProcessingStrategyMetaData.class);
    }

    @Override
    public Tab submitTab() {
        submitButton.click();
        return this;
    }
}
