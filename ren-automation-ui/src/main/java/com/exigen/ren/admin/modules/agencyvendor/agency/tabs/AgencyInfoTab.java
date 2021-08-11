/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.agency.tabs;

import com.exigen.ipb.eisa.controls.ActivitiesAndUserNotes;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.ren.admin.modules.agencyvendor.AgencyVendorDefaultTab;
import com.exigen.ren.admin.modules.agencyvendor.agency.metadata.AgencyInfoMetaData;
import org.openqa.selenium.By;

public class AgencyInfoTab extends AgencyVendorDefaultTab {
    public static final ActivitiesAndUserNotes activitiesAndUserNotes =
            new ActivitiesAndUserNotes();
    public StaticElement labelRelatedPrimaryAgency = new StaticElement(By.id("brokerAgencyInfoForm:primaryAgencyCd"));


    public AgencyInfoTab() {
        super(AgencyInfoMetaData.class);
    }
}
