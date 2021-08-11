/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.billing.account.tabs;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.ipb.eisa.utils.RetryService;
import com.exigen.istf.data.TestData;
import com.exigen.istf.exceptions.IstfException;
import com.exigen.istf.webdriver.BrowserController;
import com.exigen.istf.webdriver.controls.BaseElement;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.modules.billing.account.metadata.BillingAccountTabMetaData;
import com.exigen.modules.billing.setup_billing_groups.tabs.BillingAccountSetupTab;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.Page;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class BillingAccountTab extends DefaultTab {

    public static final Link linkManageInvocingCalendars = new Link(By.linkText("Manage Invoicing Calendars"));
    public static final Button billingAccountGeneralOptions = new Button(By.xpath("//*[@id='purchaseForm:billingAccountDetailsCollapsablePanel']/legend/span"));
    public static final Button buttonSave = new Button(By.id("purchaseForm:saveAccountTemplateBtn_footer"));
    public static final Button addToAll =  new Button(By.id("purchaseForm:addToAll"));
    public static final TableExtended<BillingAccountSetupTab.BillingGroups> tableBillingGroups = new TableExtended<>("Billing Groups", By.xpath("//div[@id = 'purchaseForm:newBillingGroupsListTable']//table"));
    public static final StaticElement accountNumber =  new StaticElement(By.xpath("//span[@id='purchaseForm:billingAccountTemplateDetails_billingAccountDetail_billingAccountNumber']"));


    public BillingAccountTab() {
        super(BillingAccountTabMetaData.class);
    }


    public static void expandBillingAccountGeneralOptions(){
        billingAccountGeneralOptions.waitForPageUpdate();
        billingAccountGeneralOptions.waitForAccessible(60000);
        if (new StaticElement(By.xpath("//*[@id='purchaseForm:billingAccountDetailsCollapsablePanel_collapsed']")).getAttribute("value").equals("true")) {
            billingAccountGeneralOptions.click();
        }
    }

    @Override
    public Tab fillTab(TestData td) {
        assetList = new MultiAssetList(By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER), metaDataClass) {

            @Override
            protected void selectSection(int index) {}

            @Override
            protected void setSectionValue(int index, TestData value) {
                if (td.getTestDataList(name).stream().anyMatch(testData -> testData.containsKey("Billing Group Name Key"))) {
                    for (TestData plan : td.getTestDataList(name)) {
                        if (plan.containsKey("Billing Group Name Key") && tableBillingGroups.isPresent()) {
                            tableBillingGroups.getRow(BillingAccountSetupTab.BillingGroups.BILLING_GROUP_NAME.getName(), plan.getValue("Billing Group Name Key")).getCell(1).click();
                        }
                        super.setSectionValue(index, value);
                        saveTab();
                    }
                }
                else {
                    BillingAccountSetupTab.tableBillingGroups.getRow(index + 1).getCell(BillingAccountSetupTab.BillingGroups.BILLING_GROUP.getName()).click();
                    super.setSectionValue(index, value);
                    saveTab();
                }
            }


            @Override
            protected void addSection(int index, int size) {

            }
        };

        assetList.setName(this.getClass().getSimpleName());
        try{
            assetList.fill(td);

        }catch (Exception e){}
        return this;
    }

    public static void saveTab() {
        if (!buttonSave.isPresent()) {
            try {
                RetryService.run(predicate -> buttonSave.isPresent(),
                        () -> {
                            BrowserController.get().driver().navigate().refresh();
                            return null;
                        }, StopStrategies.stopAfterAttempt(30), WaitStrategies.fixedWait(10, TimeUnit.SECONDS));
            } catch (RuntimeException e) {
                throw new IstfException("Save button is not displayed", e);
            }
        }
        buttonSave.click();
    }



    @Override
    public Tab submitTab() {
        CommonBaseTest.bANo="";
        Tab.buttonFinish.waitFor(20000, BaseElement::isPresent);
        if(!Tab.buttonFinish.isEnabled() && BillingAccountSetupTab.tableBillingGroups.getRowsCount() > 1) {
            addToAll.click();
        }
        else if(!Tab.buttonFinish.isEnabled()){
            saveTab();
        }
        CommonBaseTest.bANo=accountNumber.getValue();

        if(CommonBaseTest.bANo.equalsIgnoreCase("")){
            billingAccountGeneralOptions.click();
            CommonBaseTest.bANo=accountNumber.getValue();
        }
        CommonBaseTest.reportLog("Created Billing Account Number: "+ CommonBaseTest.bANo,1);
        Tab.buttonFinish.waitFor(20000,BaseElement::isEnabled);
        new Actions(CommonBaseTest.driver).pause(10000).build().perform();
        WebElement finish = CommonBaseTest.driver.findElement(By.id("purchaseForm:yesButton_footer"));
        CommonBaseTest.js.executeScript("arguments[0].scrollIntoView();", finish);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finish.click();
        return this;
    }
}
