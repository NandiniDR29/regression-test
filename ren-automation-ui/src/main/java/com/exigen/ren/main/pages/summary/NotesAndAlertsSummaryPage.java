/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.pages.summary;

import com.exigen.ipb.eisa.controls.ActivitiesAndUserNotes;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.table.Row;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.components.Dialog;
import com.exigen.ren.common.metadata.NotesAndAlertsMetaData;
import org.openqa.selenium.By;

public class NotesAndAlertsSummaryPage extends SummaryPage {

    public static StaticElement labelAlertContent = new StaticElement(By.id("alertArchiveForm:alerts:0:arhiveAlert_id"));
    public static AssetList assetListAddNoteOrAlert = new AssetList(By.xpath("//form[@id='createNote_form']"), NotesAndAlertsMetaData.NotesAndAlertsTab.class);
    public static AssetList assetListUpdateNote = new AssetList(By.xpath("//form[@id='updateNote_form']"), NotesAndAlertsMetaData.NotesAndAlertsTab.class);
    public static AssetList assetListUpdateAlert = new AssetList(By.xpath("//form[@id='updateAlert_form']"), NotesAndAlertsMetaData.NotesAndAlertsTab.class);
    public static AssetList assetListFilterNotesOrAlert = new AssetList(By.id("activityCommandsForm:activityFilterTableForm"), NotesAndAlertsMetaData.ActivitiesAndUserNotesTab.class);
    public static Table tableFilterNoteOrAlert = new Table(By.id("activityCommandsForm:activityFilterTableForm"));
    public static Table tableFilterResults = new Table(By.id("activityCommandsForm:body_userActivitiesFilterTable"));
    public static Link linkCloseAddNoteOrAlert = new Link(By.xpath("//div[@id='createNote_form:createNote_togglePanel:header']//div[@class='rf-cp-lbl-exp']"));
    public static Link linkOpenAddNoteOrAlert = new Link(By.xpath("//div[@id='createNote_form:createNote_togglePanel:header']//div[@class='rf-cp-lbl-colps']"));
    public static Link linkViewAlert = new Link(By.id("alertArchiveForm:alerts:0:arhiveAlertView"));

    public static Button buttonDeleteAlert = new Button(By.id("alertArchiveForm:archiveBtn"));

    public static Dialog dialogRemoveNote = new Dialog("//div[@id='activityCommandsForm:eliminateNoteConfirm']");
    public static Dialog dialogRemoveAlert = new Dialog("//div[@id='deleteAlertConfirmDialogDialog_container']");

    public static void add(TestData td) {
        initiateAddingNoteAlert();
        assetListAddNoteOrAlert.fill(td);
        Tab.buttonSave.click();
    }

    public static void filter(TestData td) {
        buttonNotesAlerts.click();
        assetListFilterNotesOrAlert.fill(td);
        Tab.buttonGo.click();
    }

    public static void updateNoteByRow(TestData td, int rowNumber) {
        updateNoteByRow(td, activitiesAndUserNotes.getRow(rowNumber));
    }

    public static void updateNoteByRow(TestData td, Row row) {
        row.getCell(1).controls.links.getFirst().click();
        assetListUpdateNote.fill(td);
        Tab.buttonSave.click();
    }

    public static void deleteNoteByRow(int rowNumber) {
        deleteNoteByRow(activitiesAndUserNotes.getRow(rowNumber));
    }

    public static void deleteNoteByRow(Row row) {
        row.getCell(5).controls.links.get("ELIMINATE").click();
        dialogRemoveNote.buttonYes.click();
    }

    public static void updateAlert(TestData td) {
        linkViewAlert.click();
        assetListUpdateAlert.fill(td);
        Tab.buttonSave.click();
    }

    public static void deleteAlert() {
        buttonDeleteAlert.click();
        dialogRemoveAlert.buttonYes.click();
    }

    public static void open() {
        buttonNotesAlerts.click();
    }

    public static void initiateAddingNoteAlert(){
        open();
        expandAddNoteOrAlert();
    }

    private static void expandAddNoteOrAlert() {
        if (linkOpenAddNoteOrAlert.isPresent()) {
            linkOpenAddNoteOrAlert.click();
        }
    }
}
