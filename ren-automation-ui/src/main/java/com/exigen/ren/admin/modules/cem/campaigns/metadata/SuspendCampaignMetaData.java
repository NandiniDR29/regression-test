/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.cem.campaigns.metadata;

import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class SuspendCampaignMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> SUSPEND_FROM = declare("Suspend From", TextBox.class);
    public static final AssetDescriptor<TextBox> SUSPEND_TO = declare("Suspend To", TextBox.class);
}
