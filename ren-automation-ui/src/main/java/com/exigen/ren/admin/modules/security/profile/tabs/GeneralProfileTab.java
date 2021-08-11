/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.security.profile.tabs;

import com.exigen.ipb.eisa.controls.ActivitiesAndUserNotes;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.admin.modules.security.SecurityDefaultTab;
import com.exigen.ren.admin.modules.security.profile.metadata.GeneralProfileMetaData;
import org.openqa.selenium.By;

public class GeneralProfileTab extends SecurityDefaultTab {

    public static final Table tableAgencyLocation = new Table(By.id("userProfileForm:userAgencyLocations"));
    public static final Table tableAgencySearchResult = new Table(By.id("brokerSearchFromsearchBrokerCd:body_brokerSearchResultssearchBrokerCd"));
    public static final Table tableProfileSearchResults = new Table(By.id("profileSearchForm:usersSearchResult"));
    public static final Button buttonClear = new Button(By.xpath("//input[@value='Clear' and not(ancestor::div[contains(@style,'visibility: hidden')]) and not(contains(@style, 'none'))]"));
    public static final StaticElement labelSectionHeader = new StaticElement(By.xpath("//td[(@class = 'section_header')]"));
    public static final ActivitiesAndUserNotes activitiesAndUserNotes = new ActivitiesAndUserNotes();


    public static final StaticElement errorAgencyLocation = new StaticElement(By.id("userProfileForm:agency_code_for_bls_error"));
    public static final StaticElement errorMessage = new StaticElement(By.xpath("//span[@class='errorMessageGroup']/span[@class='error_message']"));

    public static final StaticElement labelAgencyNotFound = new StaticElement(
            By.xpath("//span[@id='brokerSearchFromsearchBrokerCd:brokerSearchMessagesearchBrokerCd']/table/tbody/tr/td[@class='section_header']"));
    public static final StaticElement labelAddedRoles = new StaticElement(By.id("userProfileForm:allowRoles"));
    public static final StaticElement labelAddedPARoles = new StaticElement(By.id("userProfileForm:parSelected"));
    public static final StaticElement labelAddedManagers = new StaticElement(By.xpath("//span[@id='userProfileForm:managers']"));
    public static final StaticElement labelAddedUserSubordinates = new StaticElement(By.xpath("//span[@id='userProfileForm:subordinates']"));
    public static final StaticElement labelUserNameInformation = new StaticElement(By.xpath("//*[@id='userProfileForm:j_id_24_d5-0']/td[1]/label/span"));
    public static final StaticElement labelUserLoginInformation = new StaticElement(By.xpath("//*[@id='userProfileForm:login_label']/span"));
    public static final StaticElement labelEmailWarning = new StaticElement(By.id("userProfileForm:emailAddress_error"));

    public static final Button buttonReturn = new Button(By.xpath("//input[@value = 'Return' and not(@class = 'hidden') and not(contains(@style,'none'))]"));
    public static final Button buttonUpdate = new Button(By.xpath("(//input[(@value = 'Update' or @value = 'UPDATE') and not(@class = 'hidden') and not(contains(@style,'none'))])[last()]"));

    public GeneralProfileTab() {
        super(GeneralProfileMetaData.class);
    }
}
