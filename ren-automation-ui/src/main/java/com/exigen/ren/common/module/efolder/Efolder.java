/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.common.module.efolder;

import com.exigen.ipb.eisa.controls.StaticElementExtended;
import com.exigen.ipb.eisa.utils.RetryService;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.BrowserController;
import com.exigen.istf.webdriver.Downloads;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.EntityService;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.EfolderConstants;
import com.exigen.ren.common.module.efolder.actions.EfolderDefaultAction;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Efolder implements EntityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Efolder.class);

    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/efolder");

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }

    public Workspace getDefaultWorkspace() {
        return AutomationContext.getAction(EfolderDefaultAction.class).getWorkspace();
    }

    public static final Link linkOpenEFolder = new Link(By.id("slide_panel_open_ctrl"));
    public static final Link linkCloseEFolder = new Link(By.id("slide_panel_hide_ctrl"));

    public static boolean isDocumentExist(String path, String documentName) {
        if (!isTreeExpanded(path)) {
            expandFolder(path);
        }
        return new StaticElement(By.xpath(String.format("//form[@id='efForm']//span[@class='rf-trn-lbl']/span[.='%s']", documentName))).isPresent();
    }

    public static boolean isDocumentExist(String path, String documentName, int count) {
        if (!isTreeExpanded(path)) {
            expandFolder(path);
        }
        return new StaticElementExtended(By.xpath(String.format("//form[@id='efForm']//span[@class='rf-trn-lbl']/span[.='%s']", documentName))).getCount() == count;
    }

    public static boolean isDocumentExistContains(String path, String documentNameStarts, int count) {
        if (!isTreeExpanded(path)) {
            expandFolder(path);
        }

        StaticElementExtended document = new StaticElementExtended(By.xpath(String.format("//form[@id='efForm']//span[@class='rf-trn-lbl']/span[contains(text(), '%s')]", documentNameStarts)));
        try {
            RetryService.run(predicate -> document.getCount() == count, () -> {
                BrowserController.get().driver().navigate().refresh();
                expandFolder(path);
                return null;
            }, StopStrategies.stopAfterAttempt(5), WaitStrategies.fixedWait(5, TimeUnit.SECONDS));
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }

    public static boolean isDocumentExistStartsContains(String path, String documentNameStarts, String documentNameContains) {
        if (!isTreeExpanded(path)) {
            expandFolder(path);
        }

        StaticElement document = new StaticElement(By.xpath(String.format("//form[@id='efForm']//span[@class='rf-trn-lbl']/span[starts-with(text(), '%s') and contains(text(), '%s')]", documentNameStarts, documentNameContains)));
        try {
            RetryService.run(predicate -> document.isPresent(), () -> {
                BrowserController.get().driver().navigate().refresh();
                expandFolder(path);
                return null;
            }, StopStrategies.stopAfterAttempt(5), WaitStrategies.fixedWait(5, TimeUnit.SECONDS));
        } catch (RuntimeException e) {
            return false;
        }

        return true;
    }

    public static boolean subfolderExists(String parentFolder, String subfolder) {
        if (!isTreeExpanded(parentFolder)) {
            expandFolder(parentFolder);
        }
        return new StaticElement(By.xpath(String.format(
                "//div[contains(@class, 'rf-tr-nd rf-tr-nd-exp') and descendant::span[.='%s']]//span[@class='rf-trn-lbl']/span[.='%s']", parentFolder, subfolder))).isPresent();
    }

    public static boolean hasSubfolders(String folder) {
        if (!isTreeExpanded(folder)) {
            expandFolder(folder);
        }
        return new StaticElement(By.xpath(String.format(
                "//div[contains(@class, 'rf-tr-nd') and count(div) > 1]/div/span/span[@class='rf-trn-lbl']/span[.='%s']", folder))).isPresent();
    }

    public static boolean isDocumentExist(String documentName) {
        return new StaticElement(By.xpath(String.format("//form[@id='efForm']//span[@class='rf-trn-lbl']/span[.='%s']", documentName))).isPresent();
    }

    public static String getFileName(String path, String partialName) {
        expandFolder(path);
        StaticElement document = new StaticElement(By.xpath(String.format("//form[@id='efForm']//span[@class='rf-trn-lbl']/span[contains(text(), '%s')]", partialName)));
        RetryService.run(predicate -> document.isPresent(), () -> {
            BrowserController.get().driver().navigate().refresh();
            expandFolder(path);
            return null;
        }, StopStrategies.stopAfterAttempt(15), WaitStrategies.fixedWait(15, TimeUnit.SECONDS));
        return document.getValue();
    }

    public static String getFileName(String path, String partialName, int docNumber) {
        expandFolder(path);
        StaticElement document = new StaticElement(By.xpath(String.format("(//span[contains(text(), '%s')])[%s]", partialName, docNumber)));
        RetryService.run(predicate -> document.isPresent(), () -> {
            BrowserController.get().driver().navigate().refresh();
            expandFolder(path);
            return null;
        }, StopStrategies.stopAfterAttempt(15), WaitStrategies.fixedWait(15, TimeUnit.SECONDS));
        return document.getValue();
    }

    public static File downLoadFileByDescription(String path, String description) {
        if (!isTreeExpanded(path)) {
            expandFolder(path);
        }
        StaticElement document = new StaticElement(By.xpath(String.format("//dt[contains(text(), '%s')]//ancestor::span[@class='rf-trn-lbl']/span", description)));
        RetryService.run(predicate -> document.isPresent(), () -> {
            BrowserController.get().driver().navigate().refresh();
            return null;
        }, StopStrategies.stopAfterAttempt(15), WaitStrategies.fixedWait(15, TimeUnit.SECONDS));

        String fileName = document.getValue();
        new Link(By.xpath(String.format("//form[@id='efForm']//span[@class='rf-trn-lbl']/span[.='%s']", fileName))).doubleClick();

        AtomicReference<File> report = new AtomicReference<>();
        RetryService.run(fileExist -> !fileExist.equals(false), () -> report.getAndSet(Downloads.getFile(fileName).get()).exists(),
                StopStrategies.stopAfterAttempt(5), WaitStrategies.fixedWait(5, TimeUnit.SECONDS));
        return report.get();
    }

    public static void expandFolder(String path) {
        if (isNotOpened()) {
            linkOpenEFolder.click();
        }
        Arrays.asList(path.split("/")).stream().forEach(p ->
                new Link(By.xpath(String.format("//form[@id='efForm']//div[span/span/span[contains(@id, 'efForm:efTree') and .='%s']]/span[1]", p))).click());
    }

    public static void collapseFolder(String path) {
        Arrays.stream(path.split("/")).collect(Collectors.collectingAndThen(Collectors.toList(), list -> {Collections.reverse(list);return list;})).forEach(p ->
                new Link(By.xpath(String.format("//form[@id='efForm']//div[span/span/span[contains(@id, 'efForm:efTree') and .='%s']]/span[1]", p))).click());
        Efolder.linkCloseEFolder.click();
    }

    public static boolean isNotOpened() {
        return !(linkCloseEFolder.isPresent() && linkCloseEFolder.isVisible());
    }

    public static StaticElement getLabel(String label) {
        if (isNotOpened()) {
            linkOpenEFolder.click();
        }
        return new StaticElement(By.xpath(String.format("//div[@id='efForm:efTree']//span[@class='rf-trn-lbl']/span[.='%s']", label)));
    }

    public void addDocument(TestData testData, String path) {
        executeContextMenu(path, EfolderConstants.DocumentOparetions.ADD_DOCUMENT);
        getDefaultWorkspace().fill(testData);
    }

    public void addExtDocument(TestData testData, String path) {
        executeContextMenu(path, EfolderConstants.DocumentOparetions.ADD_EXT_DOCUMENT);
        getDefaultWorkspace().fill(testData);
    }

    public void renameFile(TestData testData, String path) {
        executeContextMenu(path, EfolderConstants.DocumentOparetions.RENAME);
        getDefaultWorkspace().fill(testData);
    }

    public static void executeContextMenu(String path, String operation) {
        if (!isTreeExpanded(path)) {
            expandFolder(path);
        }
        String[] pathParts = path.split("/");
        new Actions(BrowserController.get().driver()).contextClick(getLabel(pathParts[pathParts.length - 1]).getWebElement()).perform();
        BrowserController.get().executeScript("$('.rf-tt.ef-tree-node-tooltip').hide();");
        new Link(By.xpath(String.format("//div[@id='jqContextMenu']//li[.='%s']", operation))).click();
    }

    //TODO vskatulo:  functionality is not full, verify only one layer
    private static boolean isTreeExpanded(String path) {
        String[] pathParts = path.split("/");
        StaticElement lastFolder = new StaticElement(By.xpath(String.format("//form[@id='efForm']//div[span/span/span[contains(@id, 'efForm:efTree') and .='%s']]/span[1]",
                pathParts[pathParts.length - 1])));
        StaticElement expandButton = new StaticElement(By.xpath(String.format("//form[@id='efForm']//div[span/span/span[contains(@id, 'efForm:efTree') and .='%s']]/span[@class='rf-trn-hnd-colps rf-trn-hnd']",
                pathParts[pathParts.length - 1])));
        return lastFolder.isPresent() && !expandButton.isPresent();
    }

    public void reindexFile(TestData testData, String path) {
        executeContextMenu(path, EfolderConstants.DocumentOparetions.REINDEX);
        getDefaultWorkspace().fill(testData);
    }

    public static String makeKeyPath(String... keys) {
        return StringUtils.join(keys, "/");
    }

    public void retrieveFile(String path) {
        executeContextMenu(path, EfolderConstants.DocumentOparetions.RETRIEVE);
    }
}
