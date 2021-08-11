/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.common;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract DefaultTab class.
 */
public class DefaultTab extends Tab {

    protected static final Logger LOGGER = LoggerFactory.getLogger(DefaultTab.class);
    public static final StaticElement CANCEL_POPUP=new StaticElement(By.xpath("//div//div[@id='cancelConfirmDialogDialog_content']"));
    public static final Button NO=new Button(By.xpath("//input[@id='cancelConfirmDialogDialog_form:buttonNo']"));

    public DefaultTab(Class<? extends MetaData> mdClass) {
        super(mdClass);
    }

    @Override
    public Tab submitTab() {
        if (CANCEL_POPUP.isPresent()) {
            NO.click();
        }

        buttonNext.click();
        return this;
    }
}
