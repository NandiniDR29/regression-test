/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.cem.campaigns.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class EndCampaignMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> CAMPAIGN_TERMINATION_REASON = declare("Campaign termination reason", ComboBox.class);
    public static final AssetDescriptor<TextBox> PLEASE_EXPLAIN = declare("Please Explain", TextBox.class);
}
