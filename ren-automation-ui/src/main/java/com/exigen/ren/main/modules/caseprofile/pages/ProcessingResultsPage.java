package com.exigen.ren.main.modules.caseprofile.pages;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.ren.common.pages.Page;
import org.openqa.selenium.By;

public class ProcessingResultsPage extends Page {

    private static final String SECTION_PATTERN_LOCATOR = "//td[@class='section_header' and text()='%s']/ancestor::table[1]//following-sibling::table[1]";
    private static final String LABEL_PATTERN_LOCATOR = "//label[text()='%s']//ancestor::td[1]//following-sibling::td[1]//input";
    private static final String RADIO_GROUP_PATTERN_LOCATOR = "//table[contains(@id, '%s') and not(contains(@id, 'error'))]";
    public static final TableExtended<ProcessedFiles> tableProcessedFiles = new TableExtended<>("Processed Files", By.xpath("//div[@id='caseForm:censusFilesTable']//table"));
    public static final TableExtended<RecordValidationResult> tableRecordValidationResult = new TableExtended<>("Record Validation Result",
            By.xpath("//div[@id='caseForm:censusFilesRecordsTable']//table"),
            By.id("caseForm:censusFilesRecordsTable_paginator_bottom"));

    public static TextBox getLabelFromSection(String sectionName, String labelName) {
        return new TextBox(By.xpath(String.format(SECTION_PATTERN_LOCATOR, sectionName) + String.format(LABEL_PATTERN_LOCATOR, labelName)));
    }

    public static RadioGroup getRadioButtonFromSection(String sectionName, String buttonName) {
        return new RadioGroup(By.xpath(String.format(SECTION_PATTERN_LOCATOR, sectionName) + String.format(RADIO_GROUP_PATTERN_LOCATOR, buttonName)));
    }

    public enum ProcessedFiles implements Named {
        FILE_NAME("File Name"),
        DATE_RECEIVED("Date Received"),
        RECORDS_PROCESSED("Records Processed"),
        RECORDS_TOTAL("Records Total"),
        RECORDS_WITH_ERRORS("Records with errors"),
        STATUS("Status");

        private String name;

        ProcessedFiles(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum RecordValidationResult implements Named {
        EMPLOYEE_NUMBER("Employee Number"),
        EMPLOYEE_GENDER("Employee Gender"),
        EMPLOYEE_DOB("Employee DOB"),
        EMPLOYEE_AGE("Employee Age"),
        SMOKER_INDICATOR("Smoker indicator"),
        OCCUPATION_TITLE("Occupation Title"),
        DATE_OF_HIRE("Date Of Hire");

        private String name;

        RecordValidationResult(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

}
