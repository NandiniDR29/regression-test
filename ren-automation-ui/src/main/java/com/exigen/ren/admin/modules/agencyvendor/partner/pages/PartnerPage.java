/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.partner.pages;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.admin.modules.common.pages.AdminPage;
import org.openqa.selenium.By;

public class PartnerPage extends AdminPage {
    public static final Button buttonAddPartner = new Button(By.id("partnerSearchForm:addPartner"));
    public static final Button buttonSearch = new Button(By.id("partnerSearchForm:searchBtn"));

    public static Table tableSearchResult = new Table(By.id("partnerSearchForm:body_partnerSearchResultTable"));
}
