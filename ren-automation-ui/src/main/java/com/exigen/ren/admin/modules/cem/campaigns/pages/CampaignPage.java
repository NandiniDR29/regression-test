/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.cem.campaigns.pages;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.admin.modules.common.pages.AdminPage;
import org.openqa.selenium.By;

public class CampaignPage extends AdminPage {

    public static final AssetList assetListEndCampain = new AssetList(By.id("endCampaignModalPanel_container"), EndCampaignActionTab.class);

    public static final Button buttonCreateNewCampaign = new Button(By.id("createNewCampaign"));

    public static final Table tableCampaigns = new Table(By.id("searchForm:searchTable"));

    public static final class EndCampaignActionTab extends MetaData {
        public static final AssetDescriptor<ComboBox> CAMPAIGN_TERMINATION_REASON = declare("Campaign termination reason", ComboBox.class);
        public static final AssetDescriptor<TextBox> PLEASE_EXPLAIN = declare("Please Explain", TextBox.class);
    }

}
