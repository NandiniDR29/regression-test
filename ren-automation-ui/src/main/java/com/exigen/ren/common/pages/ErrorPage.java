/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.common.pages;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import org.openqa.selenium.By;

public class ErrorPage extends MainPage {

    public static final TableExtended<TableError> tableError = new TableExtended<>("Errors", By.xpath("//table[@id='errorsForm:msgList' or contains(@id,'errorsForm') or @role='grid' and //tbody[@class='ui-datatable-data ui-widget-content']]"));
    public static final Table tableErrorInformation = new Table(By.xpath("//div[@class='ui-datatable-tablewrapper']/table"));

    public static final Button buttonCancel = new Button(By.id("errorsForm:back"));
    public static StaticElement provideLabelErrorMessage(String errorMessage) {
        return new StaticElement(By.xpath("//*[text()='" + errorMessage + "']"));
    }
    public static final Button buttonOverride = new Button(By.id("errorsForm:overrideRules"));
    public static final Button buttonBack = new Button(By.xpath("//*[@id='errorsForm:back' or contains(@id,'errorsForm:back')]"));
    public static final Button buttonReferForApproval = new Button(By.id("errorsForm:referForApproval"));

    public enum TableError implements Named {
        OVERRIDE("Override"),
        APPROVAL("Approval"),
        CODE("Code"),
        SEVERITY("Severity"),
        MESSAGE("Message"),
        DURATION("Duration"),
        REASON_FOR_OVERRIDE("Reason for override"),
        DESCRIPTION("Description");

        private String name;

        TableError(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
