/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.general.note.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.admin.modules.general.note.metadata.NoteCategoryMetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import org.openqa.selenium.By;

public class NoteCategoryTab extends DefaultTab {
    public static Button buttonPreview = new Button(By.id("quickNoteForm:previewButton_footer"));
    public static Button buttonClose = new Button(By.id("previewDialogForm:closeButton"));

    public NoteCategoryTab() {
        super(NoteCategoryMetaData.class);
    }

    @Override
    public Tab submitTab() {
        return this;
    }
}
