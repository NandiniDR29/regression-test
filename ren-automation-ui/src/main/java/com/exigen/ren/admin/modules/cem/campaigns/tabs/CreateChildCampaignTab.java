/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.cem.campaigns.tabs;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.ren.admin.modules.cem.campaigns.metadata.CreateChildCampaignMetaData;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import org.openqa.selenium.By;

public class CreateChildCampaignTab extends ActionTab {

    public static final Button buttonAddCampaignProducts = new Button(By.id("addProductButton"));
    public static final Button buttonAddMarketingChannels = new Button(By.id("addChannelButton"));

    public static final Link linkCampaignProductsCollapsed = new Link(By.xpath("//div[text()='Campaign Products' and contains(@class, 'colps')]"));
    public static final Link linkTargetCharacteristicsCollapsed = new Link(By.xpath("//div[text()='Target Characteristics' and contains(@class, 'colps')]"));
    public static final Link linkMarketingChannelsCollapsed = new Link(By.xpath("//div[text()='Marketing Channels' and contains(@class, 'colps')]"));
    public static final Link linkCampaignSchedulingCollapsed = new Link(By.xpath("//div[text()='Campaign Scheduling' and contains(@class, 'colps')]"));

    public static final StaticElement labelCampaignId = new StaticElement(By.id("campaignCard:campaignID"));
    public static final StaticElement labelCampaignName = new StaticElement(By.id("campaignCard:name"));

    public CreateChildCampaignTab() {
        super(CreateChildCampaignMetaData.class);
    }

    @Override
    public Tab fillTab(TestData td) {
        linkCampaignProductsCollapsed.click();
        linkTargetCharacteristicsCollapsed.click();
        linkMarketingChannelsCollapsed.click();
        linkCampaignSchedulingCollapsed.click();

        assetList.fill(td);

        buttonAddCampaignProducts.click();
        return this;
    }
}
