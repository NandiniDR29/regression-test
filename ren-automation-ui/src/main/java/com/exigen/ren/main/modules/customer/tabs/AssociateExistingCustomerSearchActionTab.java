/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.tabs;

import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.main.modules.customer.metadata.AssociateExistingCustomerSearchActionTabMetaData;
import org.openqa.selenium.By;

public class AssociateExistingCustomerSearchActionTab extends ActionTab {

    public static final Table tableSearchForGroups = new Table(By.id("customerSearchForGroupsFrom:searchResultTable"));

    public AssociateExistingCustomerSearchActionTab() {
        super(AssociateExistingCustomerSearchActionTabMetaData.class);
    }
}
