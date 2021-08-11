/* Copyright © 2018 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.reports.businessactivities.pages;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;

public class BusinessActivitiesSummaryPage {
    public static final Table tableActivityReportsForSelectedCriteria = new Table(By.id("activitySummaryForm:activitySummaryTable"));
    public static final Table tableActivities = new Table(By.xpath("//form[@id='bamTreeForm']/table"));

    public static final Button buttonChangeCriteria = new Button(By.id("bamReportsTopHeaderForm:changeCriteriaBtn"));
    public static final Button buttonSubmitQuery = new Button(By.id("bamReportsHiddenForm:resetSaveReportDialogState"));
    public static final Button buttonSaveReport = new Button(By.id("activitySummaryForm:saveReportBtn"));
    public static final Button buttonCancel = new Button(By.id("topCancelLink"), Waiters.SLEEP(10000));

    public static final Link linkGraph = new Link(By.id("activitySummaryForm:actSumGraphBtn"));

    public static final StaticElement imgCountOfActivities = new StaticElement(By.id("AUTOGENBOOKMARK_2"));
    public static final StaticElement imgDurationOfActivities = new StaticElement(By.id("AUTOGENBOOKMARK_3"));


}
