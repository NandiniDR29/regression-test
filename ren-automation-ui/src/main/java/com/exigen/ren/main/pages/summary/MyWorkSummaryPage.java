/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.pages.summary;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.ipb.eisa.controls.dialog.DialogAssetList;
import com.exigen.ipb.eisa.controls.dialog.FilterDialogAssetList;
import com.exigen.istf.utils.datetime.DateTimeUtils;
import com.exigen.istf.webdriver.BrowserController;
import com.exigen.istf.webdriver.ByT;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.table.Row;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.MyWorkConstants;
import com.exigen.ren.main.modules.mywork.metadata.CreateQuickFilterMetaData;
import com.exigen.ren.main.modules.mywork.metadata.CreateTaskActionTabMetaData;
import com.exigen.ren.main.modules.mywork.metadata.FilterTaskActionTabMetaData;
import com.exigen.ren.main.modules.mywork.metadata.UpdateQuickFilterMetaData;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class MyWorkSummaryPage extends SummaryPage {

    //TODO, needs to be moved or tests that uses it needs to be updated
    public static AssetList assetListCreateTask = new AssetList(By.id("taskCreateForm"), CreateTaskActionTabMetaData.class);
    public static AssetList assetListFilterTask = new AssetList(By.id("filterContainerForm"), FilterTaskActionTabMetaData.class);

    public static DialogAssetList dialogCreateQuickFilter = new DialogAssetList(By.id("predefinedFilterPopup:createUpdateFilterPopup:addMyWorkFilterId"), CreateQuickFilterMetaData.class);
    public static DialogAssetList dialogUpdateQuickFilter = new FilterDialogAssetList(By.id("predefinedFilterPopup:createUpdateFilterPopup:addMyWorkFilterId"), UpdateQuickFilterMetaData.class);

    public static Table tableWorks = new Table(By.xpath("//form[@id='taskListForm']//table[@role='grid']"));
    public static Table tableBulletins = new Table(By.xpath("//div[@id='bulletinListForm:bulletinListPanel:bulletinDataTableResults']//table"));
    public static Table tableBulletinDetails = new Table(By.id("bulletinDetailsForm:body_bulletinInfo"));
    public static TableExtended<MyWorkConstants.MyWorkTasksTable> tableTasks = (TableExtended) new TableExtended<>("Tasks", By.xpath("//div[@id='taskListForm:customTaskTable:workTasks']//table"),
            By.xpath("//div[@id='taskListForm:customTaskTable:workTasks']//div[@id='taskListForm:customTaskTable:workTasks_paginator_bottom']")).applyConfiguration("NoRecordsFound");
    public static Table tableTaskDetails = new Table(By.xpath("//span[@id='taskListForm:customTaskTable']//table[@class='taskDetailsTable']"));

    public static Button buttonShowFilter = new Button(By.id("taskManagingForm:filterDisplayBtn"));
    public static Button buttonFilterGo = new Button(By.id("filterContainerForm:filterGoBtn"));
    public static Button buttonQuickFilterCompleted = new Button(By.xpath("//div[@id='predefinedFilterLabelsForm:predefinedFilterSelect']//span[.='Type COMPLETED']"));
    public static Button buttonCalendarView = new Button(By.id("taskControlsForm:switchView"));

    public static Button buttonAssign = new Button(By.id("taskListForm:bulkTaskAssign"));
    public static Button buttonComplete = new Button(By.xpath("//button[@id='taskListForm:bulkTaskComplete' or @id='taskDetailsCommandForm:completeTask_footer']"));
    public static Button buttonClear = new Button(By.id("filterContainerForm:filterClearBtn"));
    public static Button buttonCreateTask = new Button(By.xpath("//a[contains(@id,'createTask') and text()='Create Task']"));
    public static Button buttonGetMyNewTask = new Button(By.xpath("//a[.='Get My New Task']"));
    public static Button buttonCancel = new Button(By.id("topCancelLink"));

    public static ComboBox selectNumberOfViewTasks = new ComboBox(By.xpath("//select[@class='ui-paginator-rpp-options ui-widget ui-state-default ui-corner-left']"));
    public static Link linkShowDescriptionOfTasks = new Link(By.id("taskListForm:customTaskTable:workTasks:collapseDescriptions"));
    public static Button buttonMyProfile = new Button(By.id("taskManagingForm:userProfileLink"));

    public static Link linkChangeShowingTasksPrority = new Link(By.xpath("//th[@id=\"taskListForm:customTaskTable:workTasks:col_warningDate\"]/span[2]"));
    public static Link linkAllQueues = new Link(By.xpath("//a[@href='#taskViewContainerForm:taskViewTabs:allQueuesTasksViewService']"));
    public static Link linkMyInbox = new Link(By.xpath("//a[@href='#taskViewContainerForm:taskViewTabs:myInboxTasksViewService']"));

    public static StaticElement labelFilterCriteria = new StaticElement(By.id("taskManagingForm:filterCriteria"));

    private static String linkAssignTemplate = "taskListForm:customTaskTable:workTasks:%s:assignTask";
    private static String linkUpdateTemplate = "taskListForm:customTaskTable:workTasks:%s:updateTask";
    private static String linkCompleteTemplate = "taskListForm:customTaskTable:workTasks:%s:completeTask";
    private static String linkExpandTemplate = "//tbody[@id='taskListForm:customTaskTable:workTasks_data']/tr[%s]/td[2]/div[@class='ui-row-toggler ui-icon ui-icon-circle-triangle-e']";

    public static void selectTask(ImmutableMap<String, String> query) {
        tableTasks.getRowContains(query).getCell(1).controls.checkBoxes.getFirst().setValue(true);
    }

    public static void selectTask(int rowNumber) {
        tableTasks.getRow(rowNumber).getCell(1).controls.checkBoxes.getFirst().setValue(true);
    }

    public static void expandTask(int rowNumber) {
        new Link(ByT.xpath(linkExpandTemplate).format(rowNumber)).click();
    }

    public static void assignLink(int rowNumber) {
        getAssignLink(rowNumber).click();
    }

    public static void updateLink(int rowNumber) {
        getUpdateLink(rowNumber).click();
    }

    public static void completeLink(int rowNumber) {
        getCompleteLink(rowNumber).click();
    }

    public static Button getAssignLink(int rowNumber) {
        return new Button(ByT.id(linkAssignTemplate).format(rowNumber - 1));
    }

    public static Button getAssignLink(Row row) {
        return new Button(row, By.xpath("./following-sibling::tr[contains(@class, 'ui-expanded-row-content')]//button[contains(@id, 'assignTask')]"));
    }

    public static Button getUpdateLink(int rowNumber) {
        return new Button(ByT.id(linkUpdateTemplate).format(rowNumber - 1));
    }

    public static Button getUpdateLink(Row row) {
        return new Button(row, By.xpath("./following-sibling::tr[contains(@class, 'ui-expanded-row-content')]//button[contains(@id, 'updateTask')]"));
    }

    public static Button getCompleteLink(int rowNumber) {
        return new Button(ByT.id(linkCompleteTemplate).format(rowNumber - 1));
    }

    public static Button getCompleteLink(Row row) {
        return new Button(row, By.xpath("./following-sibling::tr[contains(@class, 'ui-expanded-row-content')]//button[contains(@id, 'completeTask')]"));
    }

    public static void openTaskDetails(String nameTask) {
        tableTasks.getRow(MyWorkConstants.MyWorkTasksTable.TASK_NAME.getName(), nameTask).getCell(MyWorkConstants.MyWorkTasksTable.TASK_ID.getName()).controls.links.getFirst().click();
    }

    public static void openTaskDetails(int rowNumber) {
        tableTasks.getRow(rowNumber).getCell(MyWorkConstants.MyWorkTasksTable.TASK_ID.getName()).controls.links.getFirst().click();
    }

    public static void openReferenceID(int rowNumber) {
        tableTasks.getRow(rowNumber).getCell(MyWorkConstants.MyWorkTasksTable.REFERENCE_ID.getName()).controls.links.getFirst().click();
    }

    public static void showFilter() {
        if (buttonShowFilter.getAttribute("class").contains("collapsable-collapsed")) {
            buttonShowFilter.click();
        }
    }

    public static Button getCustomQuickFilterButton(String filterName) {
        return new Button(By.xpath(String.format("//div[@id='predefinedFilterLabelsForm:predefinedFilterSelect']//span[.='%s']", filterName)));
    }

    public static void deleteQuickFilter(String filterName) {
        getCustomQuickFilterButton(filterName);
        new Button(By.id("cloneableEditBtnId")).click();
        new Button(By.id("predefinedFilterPopup:createUpdateFilterPopup:updateMyWorkFilterButtonDelete")).click();
        Page.dialogConfirmation.confirm();
    }

    public static void submitFilter() {
        buttonFilterGo.waitForAccessible(3000);
        buttonFilterGo.click();
    }

    public static void openAllQueuesSection() {
        linkAllQueues.click();
    }

    public static void openMyInboxSection() {
        linkMyInbox.click();
    }

    public static class CalendarView {
        public static Link linkCollapse = new Link(By.id("calendarView:calendarViewDetailsForm:calendarDetailsTab:taskScheduledCalendarTable:calendarTaskDetails:collapseDescriptions"));
        public static StaticElement thLinkCollapse = new StaticElement(By.xpath("//tr[th[@id='calendarView:calendarViewDetailsForm:calendarDetailsTab:taskScheduledCalendarTable:calendarTaskDetails:col_toggle']]"));
        public static StaticElement thLabelTaskId = new StaticElement(By.xpath("//tr[th[@id='calendarView:calendarViewDetailsForm:calendarDetailsTab:taskScheduledCalendarTable:calendarTaskDetails:col_taskId']]"));
        public static StaticElement formCalendarView = new StaticElement(By.xpath("//form[@id='calendarView:calendarViewForm']"));
        public static Button buttonMinusMonth = new Button(formCalendarView, By.xpath(".//span[contains(@class, 'fc-button fc-button-prev ui-state-default ui-corner-left')]"));
        public static Button buttonAddMonth = new Button(formCalendarView, By.xpath("//span[@class='fc-button fc-button-next ui-state-default ui-corner-right']"));
        public static Table tableCalendar = new Table(formCalendarView, By.xpath("//table[@class='fc-border-separate']"));

        public static Table tableScheduledTasks = new Table(By.xpath("//div[@id='calendarView:calendarViewDetailsForm:calendarDetailsTab:taskScheduledCalendarTable:calendarTaskDetails']//table"))
                .applyConfiguration("NoRecordsFound");
        public static Table tableUnscheduledTasks = new Table(By.xpath("//div[@id='calendarView:calendarViewDetailsForm:calendarDetailsTab:taskUnscheduledCalendarTable:calendarTaskDetails']//table"))
                .applyConfiguration("NoRecordsFound");

        public static void openScheduledTasks() {
            new Link(By.xpath(String.format("//a[.='Scheduled %s']", DateTimeUtils.getCurrentDateTime().format(DateTimeUtils.MM_DD_YYYY)))).click();
        }

        public static void openScheduledTasks(LocalDateTime date) {
            new Link(By.xpath(String.format("//a[.='Scheduled %s']", date.format(DateTimeUtils.MM_DD_YYYY)))).click();
        }

        public static void openUnscheduledTasks() {
            new Link(By.xpath("//a[.='Unscheduled']")).click();
        }

        /**
         * Click to the task link on Calendar view for the specific date
         *
         * @param date specific date
         */
        public static void selectTaskAtDate(LocalDateTime date) {
            selectMonth(date);
            WebElement taskLink = getCalendarTaskDetailsLink(date);
            BrowserController.get().executeScript("arguments[0].scrollIntoView();", taskLink);
            taskLink.click();
            Waiters.DEFAULT.go();
        }

        /**
         * Select calendar view to the specific date's month.
         *
         * @param date specific date
         */
        private static void selectMonth(LocalDateTime date) {
            resetCalendar();
            Period period = Period.between(DateTimeUtils.getCurrentDateTime().toLocalDate(), date.toLocalDate());
            int months = period.getMonths();

            if (months > 0) {
                IntStream.range(0, months).forEach(i -> buttonAddMonth.click());
            } else {
                IntStream.range(0, Math.abs(months)).forEach(i -> buttonMinusMonth.click());
            }
        }


        /**
         * Retrieve task link webElement for specific date
         *
         * @param date task due date
         * @return link to task details
         */
        private static WebElement getCalendarTaskDetailsLink(LocalDateTime date) {
            Point tablePoint = tableCalendar.getWebElement().getLocation();
            Point cellPoint = getCalendarDayWebElement(date).getLocation();
            Point cellOffset = new Point(cellPoint.getX() - tablePoint.getX(), cellPoint.getY() - tablePoint.getY());

            WebElement link = null;
            double minDistance = Double.MAX_VALUE;

            for (WebElement we : getCalendarTaskLinks()) {

                Point linkPoint = we.getLocation();
                Point linkOffset = new Point(linkPoint.getX() - tablePoint.getX(), linkPoint.getY() - tablePoint.getY());
                double distance = Math.hypot(linkOffset.getX() - cellOffset.getX(), linkOffset.getY() - cellOffset.getY());

                if (distance < minDistance) {
                    minDistance = distance;
                    link = we;
                }
            }
            return Optional.ofNullable(link).orElseThrow(() -> new IllegalStateException("No any link in Calendar"));
        }

        /**
         * Reset calendar to the current date view
         */
        public static void resetCalendar() {
            new Link(formCalendarView, By.xpath("//span[.='month']")).click();
        }

        /**
         * Drag and drop first record at the table to the specific date
         *
         * @param targetDate    task's changed date
         * @param scheduledTask shows if scheduled table must be selected
         */
        public static void changeTaskDueDate(LocalDateTime targetDate, boolean scheduledTask) {
            selectMonth(targetDate);

            Table table;
            if (!scheduledTask) {
                openUnscheduledTasks();
                table = tableUnscheduledTasks;
            } else {
                openScheduledTasks();
                table = tableScheduledTasks;
            }

            WebElement taskElement = table.getRow(1).getCell(1).getWebElement().findElement(By.xpath("./span"));
            WebElement targetElement = getCalendarDayWebElement(targetDate);

            int calendarTaskCount = getCalendarTaskCount();

            new Actions(BrowserController.get().driver()).dragAndDrop(taskElement, targetElement).perform();
            dialogConfirmation.confirm();

            WebDriverWait wait = new WebDriverWait(BrowserController.get().driver(), 5);
            wait.until((ExpectedCondition<Boolean>) driver -> getCalendarTaskCount() > calendarTaskCount);
        }

        /**
         * @param date Specific date
         * @return &lt;td&gt; WebElement with day equals to date's day
         */
        private static WebElement getCalendarDayWebElement(LocalDateTime date) {
            return new Link(By.xpath(String.format("//table[@class='fc-border-separate']//td[contains(.,'%s')][not(contains(@class,'fc-other-month'))]",
                    date.getDayOfMonth()))).getWebElement();
        }

        private static List<WebElement> getCalendarTaskLinks() {
            return BrowserController.get().driver().findElements(
                    By.xpath("//div[@class='fc-event fc-event-skin fc-event-hori fc-corner-left fc-corner-right']"));
        }

        private static int getCalendarTaskCount() {
            return getCalendarTaskLinks().stream().mapToInt(we ->
                    Integer.parseInt(we.findElement(By.xpath(".//span[@class='fc-event-title']"))
                            .getText().replaceAll("\\D", ""))).sum();
        }
    }
}
