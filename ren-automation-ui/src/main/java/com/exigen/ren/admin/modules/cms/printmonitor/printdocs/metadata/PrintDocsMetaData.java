/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.cms.printmonitor.printdocs.metadata;

import com.exigen.ipb.eisa.controls.dialog.DialogAssetList;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import org.openqa.selenium.By;

public class PrintDocsMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> ENTITY_TYPE = declare("Entity Type", ComboBox.class, By.id("criteriaForm:entityType"));
    public static final AssetDescriptor<ComboBox> STATUS = declare("Status", ComboBox.class, By.id("criteriaForm:status"));
    public static final AssetDescriptor<TextBox> REQUEST_ID_FROM = declare("Request Id From", TextBox.class);
    public static final AssetDescriptor<DialogAssetList> RESCHEDULE_TIME = declare("Reschedule Selected", DialogAssetList.class, RescheduleTimeDialog.class);

    public static final class RescheduleTimeDialog extends MetaData{
        public static final AssetDescriptor<TextBox> TIME = declare("Time", TextBox.class);
    }
}
