/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.pages;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.admin.modules.common.pages.AdminPage;
import org.openqa.selenium.By;

public class AgencyVendorSummaryPage extends AdminPage {
    public static Button buttonAddNewAgency = new Button(By.id("brokerManagementForm:addButton"));
    public static Table tableAgencies = new Table(By.id("brokerManagementForm:body_brokerInfoTable"));
    public static Button buttonAddTransfer = new Button(By.id("borManagementForm:addButton"));
}
