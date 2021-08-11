/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.mywork.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.main.modules.mywork.metadata.UpdateTaskActionTabMetaData;
import org.openqa.selenium.By;

public class UpdateTaskActionTab extends ActionTab {

    public static final Button buttonUpdate = new Button(By.id("taskUpdateForm:submitUpdate_footer"));
    public static final Button buttonCancel = new Button(By.id("taskUpdateForm:navigateBack_footer"));

    public UpdateTaskActionTab() {
        super(UpdateTaskActionTabMetaData.class);
    }
}
