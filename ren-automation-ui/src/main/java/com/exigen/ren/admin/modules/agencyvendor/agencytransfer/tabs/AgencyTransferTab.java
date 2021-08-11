/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.agencytransfer.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.admin.modules.agencyvendor.AgencyVendorDefaultTab;
import com.exigen.ren.admin.modules.agencyvendor.agencytransfer.metadata.AgencyTransferMetaData;
import com.exigen.ren.common.Tab;
import org.openqa.selenium.By;

public class AgencyTransferTab extends AgencyVendorDefaultTab {
    public static final StaticElement labelTransferId = new StaticElement(By.id("borTransferManagementForm:transferNumber"));
    public static final Button buttonSubmit = new Button(By.xpath("//input[@value='Submit' and contains(@id, '_footer')]"));
    public static final Table transfersTable = new Table(By.id("borManagementForm:body_borInfoTable"));

    public AgencyTransferTab() {
        super(AgencyTransferMetaData.class);
    }

    @Override
    public Tab submitTab() {
        return this;
    }
}
