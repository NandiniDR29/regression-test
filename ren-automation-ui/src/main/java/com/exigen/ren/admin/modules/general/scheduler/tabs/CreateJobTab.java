/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.general.scheduler.tabs;

import com.exigen.ipb.eisa.controls.ActivitiesAndUserNotes;
import com.exigen.ipb.eisa.controls.StaticElementExtended;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.*;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.ren.admin.modules.general.scheduler.metadata.CreateJobMetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import org.openqa.selenium.By;

public class CreateJobTab extends DefaultTab {

    public static final Button buttonAddJob = new Button(By.id("jobsForm:addJobButton"));
    public static final Button buttonJobSave = new Button(By.id("jobsForm:saveButton_footer"));
    public static final Button buttonEliminate = new Button(By.id("jobsForm:eliminateJobButton_0"));
    public static final Button buttonBack = new Button(By.id("jobsForm:backButton_footer"));
    public static final Button buttonLogsAndStatistics = new Button(By.id("jobsForm:logsAndStatistics"));
    public static final Button buttonAddTrigger = new Button(By.id("jobsForm:addTrigger"));

    private static final String ALL_TRIGGER_HEADERS_LOCATOR = "//div[@id='jobsForm:triggersTable']//td[@class='section_header']";
    private static final String BUTTON_TRIGGER_ELIMINATE_ID_LOCATOR = "jobsForm:eliminateTrigger_%d";
    private static final String COMBOBOX_TRIGGER_SCHEDULING_TYPE_ID_LOCATOR = "jobsForm:repeatingType_%d";
    private static final String TEXTBOX_TRIGGER_REPEAT_EVERY_NUMBER_ID_LOCATOR = "jobsForm:interval_%d";
    private static final String COMBOBOX_TRIGGER_REPEAT_EVERY_UNIT_ID_LOCATOR = "jobsForm:repeatingType2_%d";
    private static final String BUTTON_JOB_ELIMINATE_ID_LOCATOR = "jobsForm:eliminateJobButton_%d";

    public static final ActivitiesAndUserNotes activitiesAndUserNotes = new ActivitiesAndUserNotes();
    public static final StaticElement labelMsg = new StaticElement(By.xpath("//span[@title='If value is earlier than current Date&Time during creation/update it will be set to current Date&Time']"));
    public static final StaticElement batchErrorsLabel = new StaticElement(By.id("jobsForm:emptyJobsBls_error"));

    //Scheduling panel
    public static final CheckBox checkBoxSchedulingEnabled = new CheckBox(By.id("jobsForm:enableGroup"));
    public static final StaticElement labelEnabledSchedulingPanel = new StaticElement(By.id("jobsForm:enabledPanels"));
    public static final TextBox textBoxStart = new TextBox(By.id("jobsForm:startDateInputDate"));

    public static void eliminateTrigger(int index) {
        new Button(By.id(String.format(BUTTON_TRIGGER_ELIMINATE_ID_LOCATOR, index))).click();
    }

    public static void eliminateBatchJob(int index) {
        new Button(By.id(String.format(BUTTON_JOB_ELIMINATE_ID_LOCATOR, index))).click();
    }

    public CreateJobTab() {
        super(CreateJobMetaData.class);
    }

    @Override
    public Tab fillTab(TestData td) {
        super.fillTab(td);

        if (td.getTestData("CreateJobTab").containsKey("AdditionalJobs")) {
            for (TestData tdAdditionalJob : td.getTestDataList("CreateJobTab", "AdditionalJobs")) {
                buttonAddJob.click();
                ((AssetList) super.getAssetList()).setValue(tdAdditionalJob);
            }
        }
        return this;
    }

    @Override
    public Tab submitTab() {
        buttonJobSave.click();
        return this;
    }

    public static int getCountOfTriggers() {
        return new StaticElementExtended(By.xpath(ALL_TRIGGER_HEADERS_LOCATOR)).getCount();
    }

    public static String getTypeOfTrigger(int num) {
        return new ComboBox(By.id(String.format(COMBOBOX_TRIGGER_SCHEDULING_TYPE_ID_LOCATOR, num - 1))).getValue();
    }

    public static int getRepeatNumberOfTrigger(int num) {
        return Integer.parseInt(new TextBox(By.id(String.format(TEXTBOX_TRIGGER_REPEAT_EVERY_NUMBER_ID_LOCATOR, num - 1))).getValue());
    }

    public static String getRepeatUnitOfTrigger(int num) {
        return new ComboBox(By.id(String.format(COMBOBOX_TRIGGER_REPEAT_EVERY_UNIT_ID_LOCATOR, num - 1))).getValue();
    }
}
