/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.customer.metadata.EmployeeInfoTabMetaData;
import org.openqa.selenium.By;

public class EmployeeInfoTab extends ActionTab {
    public static final StaticElement labelEmployeeInformationExpanded = new StaticElement(By.id("crmForm:participantHeaderContentExpandedEmployeeInfo_0"));
    public static final StaticElement labelEmployeeInformationCollapsed = new StaticElement(By.id("crmForm:participantHeaderContentCollapsedEmployeeInfo_0"));
    public static final Button buttonRemoveRelationshipToSponsor = new Button(By.xpath("//a[text() = 'Remove Relationship to Sponsor']"));
    public static final Button buttonTimeline = new Button(By.xpath("//a[.='Timeline']"));
    public static final Link linkEmployeeRelationship = new Link(By.xpath("//span[contains(text(),'Employee Information for')]//a"));

    public EmployeeInfoTab() {
        super(EmployeeInfoTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        buttonDone.click();
        return this;
    }
}
