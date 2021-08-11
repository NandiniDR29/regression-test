/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.agency.tabs;

import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.admin.modules.agencyvendor.AgencyVendorDefaultTab;
import com.exigen.ren.admin.modules.agencyvendor.agency.metadata.SupportTeamMetaData;
import org.openqa.selenium.By;

public class SupportTeamTab extends AgencyVendorDefaultTab {

    public static final Table tableAddedSupportTeam = new Table(By.id("brokerUnderwritersForm:brokerAssignedUWsTable"));

    public SupportTeamTab() {
        super(SupportTeamMetaData.class);
    }
}
