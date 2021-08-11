/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.customer.campaigns.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelsModel extends Model {
    private String campaignChannelCd;
    private String campaignSubChannelCd;
    private String campaignMaterialCd;

    public void setCampaignChannelCd(String campaignChannelCd) {
        this.campaignChannelCd = campaignChannelCd;
    }

    public String getCampaignChannelCd() {
        return campaignChannelCd;
    }

    public void setCampaignSubChannelCd(String campaignSubChannelCd) {
        this.campaignSubChannelCd = campaignSubChannelCd;
    }

    public String getCampaignSubChannelCd() {
        return campaignSubChannelCd;
    }

    public void setCampaignMaterialCd(String campaignMaterialCd) {
        this.campaignMaterialCd = campaignMaterialCd;
    }

    public String getCampaignMaterialCd() {
        return campaignMaterialCd;
    }

}
