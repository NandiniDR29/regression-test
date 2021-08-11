/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.general.bulletin.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.admin.modules.general.bulletin.metadata.BulletinMetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import org.openqa.selenium.By;

public class BulletinTab extends DefaultTab {
    public static Button buttonSubmit = new Button(By.xpath("//input[contains(@value, 'Submit') and not(@class = 'hidden') and not(contains(@style,'none'))]"));

    public BulletinTab() {
        super(BulletinMetaData.class);
    }

    @Override
    public Tab submitTab() {
        return this;
    }
}
