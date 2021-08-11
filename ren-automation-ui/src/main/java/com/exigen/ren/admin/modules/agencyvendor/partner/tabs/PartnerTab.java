/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.partner.tabs;

import com.exigen.ren.admin.modules.agencyvendor.AgencyVendorDefaultTab;
import com.exigen.ren.admin.modules.agencyvendor.partner.metadata.PartnerMetaData;
import com.exigen.ren.common.Tab;

public class PartnerTab extends AgencyVendorDefaultTab {
    public PartnerTab() {
        super(PartnerMetaData.class);
    }

    @Override
    public Tab submitTab() {
        buttonOk.click();
        return this;
    }
}
