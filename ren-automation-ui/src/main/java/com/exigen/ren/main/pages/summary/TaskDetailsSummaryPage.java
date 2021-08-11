/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.pages.summary;

import com.exigen.ipb.eisa.controls.ActivitiesAndUserNotes;
import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import org.openqa.selenium.By;

public class TaskDetailsSummaryPage extends SummaryPage {

    public static Button buttonAssign = new Button(By.id("taskDetailsCommandForm:assignTask_footer"));
    public static Button buttonComplete = new Button(By.id("taskDetailsCommandForm:completeTask_footer"));
    public static Button buttonUpdate = new Button(By.id("taskDetailsCommandForm:updateTask_footer"));
    public static Button buttonCancel = new Button(By.id("taskDetailsCommandForm:navigateBack_footer"));

    //HEADER
    public static StaticElement taskName = new StaticElement(By.xpath("//span[@id='taskHeaderForm:taskName']"));
    public static Link referanceId = new Link(By.xpath("//a[@id='taskHeaderForm:showEntityDetails']"));

    public static Link customerName = new Link(By.xpath("//span[@id='taskHeaderForm:customerOutputGroup']"));
    public static StaticElement workflow = new StaticElement(By.id("taskHeaderForm:taskProcessInstanceId"));
    public static StaticElement type = new StaticElement(By.id("taskHeaderForm:entityTypeOutput"));
    public static StaticElement taskID = new StaticElement(By.id("taskHeaderForm:taskIdOutput"));
    public static StaticElement taskStatus = new StaticElement(By.id("taskHeaderForm:status"));
    public static StaticElement priority = new StaticElement(By.id("taskHeaderForm:priority"));
    public static StaticElement queueName = new StaticElement(By.id("taskHeaderForm:workQueue"));
    public static StaticElement creationDate = new StaticElement(By.id("taskHeaderForm:creationDate"));
    public static StaticElement warningDate = new StaticElement(By.id("taskHeaderForm:warnDate"));
    public static StaticElement dueDate = new StaticElement(By.id("taskHeaderForm:dueDate"));
    public static StaticElement lastPerformer = new StaticElement(By.id("taskHeaderForm:lastPerformer"));
    public static StaticElement createdBy = new StaticElement(By.id("taskHeaderForm:createUser"));
    public static StaticElement assignedTo = new StaticElement(By.id("taskHeaderForm:assignedTo"));
    public static StaticElement completedBy = new StaticElement(By.id("taskHeaderForm:workCompletedBy"));
    public static StaticElement labelTaskStatus = new StaticElement(By.id("taskHeaderForm:status"));
    public static Button buttonAddAttachment = new Button(By.xpath("//a[contains(@id,'addDocForm:addLink') and text()='Add Attachment']"));
    public static TableExtended<TaskAttachments> tableTaskAttachments = new TableExtended<>("Task Attachments",  By.xpath("//div[@id='taskAttachments_attachmentTable']//table"));

    public static Table tableSuspendInformation = new Table(By.id("taskSuspenseInfo"));

    public static ActivitiesAndUserNotes activitiesAndUserNotes = new ActivitiesAndUserNotes();

    //Process Notes
    public static ProcessNotes processNotes = new ProcessNotes(By.xpath("//div[@id='processNotesForm:processNotesTable']//table"));

    //Reference Information
    public static StaticElement taskDescription = new StaticElement(By.id("referenceInfoForm:taskReferenceInfo_1:0:taskDescription"));

    public static class ProcessNotes extends ActivitiesAndUserNotes {

        private Link linkOpen = new Link(By.xpath("//div[@id='processNotesForm:processNotesTogglePanel:header']//td[@class='rf-cp-lbl']"));

        public ProcessNotes(By locator) {
            super(locator);
        }

        @Override
        public void expand() {
            if (!isOpened()) {
                linkOpen.click();
            }
        }

        @Override
        public void collapse() {
            if (isOpened()) {
                linkOpen.click();
            }
        }

        @Override
        public boolean isOpened() {
            return this.isPresent() && this.isVisible();
        }
    }

    public enum TaskAttachments implements Named {
        FOLDER("Folder"),
        DOCUMENT_TYPE("Document Type"),
        DESCRIPTION("Description");

        private String name;

        TaskAttachments(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

}
