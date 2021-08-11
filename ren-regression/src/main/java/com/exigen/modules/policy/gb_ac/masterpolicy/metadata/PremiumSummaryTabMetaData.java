/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package com.exigen.modules.policy.gb_ac.masterpolicy.metadata;

import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class PremiumSummaryTabMetaData extends MetaData {

    public static final AssetDescriptor<AssetList> RATE_SECTION = declare("Rate", AssetList.class, com.exigen.ren.main.modules.policy.gb_eap.masterpolicy.metadata.PremiumSummaryTabMetaData.RateMetaData.class);

    public static final class RateMetaData extends MetaData {
        public static final AssetDescriptor<TextBox> RATE_REQUEST_DATE = declare("Rate Request Date", TextBox.class);
        public static final AssetDescriptor<TextBox> RATING_FORMULA = declare("Rating Formula", TextBox.class);
    }
}
