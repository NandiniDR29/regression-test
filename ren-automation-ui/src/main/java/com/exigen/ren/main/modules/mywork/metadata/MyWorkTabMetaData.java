/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.ren.main.modules.mywork.metadata;

import com.exigen.ipb.eisa.controls.ClickComboBox;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import org.openqa.selenium.By;

public class MyWorkTabMetaData extends MetaData {
    public static final AssetDescriptor<Link> MY_INBOX = declare("My Inbox", Link.class, By.xpath("//a[normalize-space(.)='My Inbox']"));
    public static final AssetDescriptor<Link> ALL_QUEUES = declare("All Queues", Link.class, By.xpath("//a[normalize-space(.)='All Queues']"));
    public static final AssetDescriptor<AssetList> MY_WORK_TASKS = declare("My Work Tasks", AssetList.class, MyWorkTasksMetaData.class, false, By.id("taskManagingForm"));

    public static final class MyWorkTasksMetaData extends MetaData {
        public static final AssetDescriptor<ClickComboBox> QUEUE = declare("Queue", ClickComboBox.class);
        public static final AssetDescriptor<ComboBox> ASSIGNEE = declare("Assignee", ComboBox.class);
    }

}
