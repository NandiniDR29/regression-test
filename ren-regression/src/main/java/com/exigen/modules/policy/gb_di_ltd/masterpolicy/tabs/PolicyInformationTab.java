/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.policy.gb_di_ltd.masterpolicy.tabs;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.ByT;
import com.exigen.istf.webdriver.controls.BaseElement;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.assets.RepeatAssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.modules.policy.gb_di_ltd.masterpolicy.metadata.PolicyInformationTabMetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.TableConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.exigen.ren.common.enums.NavigationEnum.GroupBenefitsTab.POLICY_INFORMATION;
import static com.exigen.ren.main.modules.policy.gb_di_ltd.masterpolicy.metadata.PolicyInformationTabMetaData.SITUS_STATE;

public class PolicyInformationTab extends DefaultTab {

    public static final TableExtended<TableConstants.AgenciesProducersTable> agenciesProducersTable = new TableExtended<>("Plan", By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListGroupMasterPolicyMultiProducerInfo']/div/table"));
    public static final StaticElement helpTextGroupIsMemberCompany = new StaticElement(By.id("policyDataGatherForm:sedit_Policy_groupIsMemberCompany_helpText"));
    public static TableExtended<PolicyInformationTab.AssignedAgenciesTable> tableAssignedAgencies = new TableExtended<>("Assigned Agencies", By.xpath("//div[contains(@id, 'policyDataGatherForm:dataGatherView_ListGroupMasterPolicy')]/div/table"));


    public static Button buttonAddAssignment = new Button(By.xpath("//input[@value='Add Agency']"));

    public PolicyInformationTab() {
        super(PolicyInformationTabMetaData.class);
    }

    public static void assignAgencies() {
        buttonAddAssignment.waitForPageUpdate();
        WebElement firstAgeny = CommonBaseTest.driver.findElement(By.id("policyDataGatherForm:sedit_GroupMasterPolicyMultiProducerInfo_producerCd"));
        Select option = new Select(firstAgeny);
        option.selectByIndex(1);
        buttonAddAssignment.waitForPageUpdate();
        //CommonBaseTest.driver.findElement(By.id("policyDataGatherForm:sedit_GroupMasterPolicyMultiProducerInfo_primaryProducerInd:0")).click();
        buttonAddAssignment.waitForPageUpdate();
        WebElement splitRadioButton=CommonBaseTest.driver.findElement(By.id("policyDataGatherForm:sedit_GroupMasterPolicyMultiProducerInfo_commissionSplitInd:0"));
        // CommonBaseTest.ac.click(splitRadioButton).perform();
        CommonBaseTest.js.executeScript("arguments[0].click();", splitRadioButton);
        buttonAddAssignment.waitForPageUpdate();
        CommonBaseTest.driver.findElement(By.id("policyDataGatherForm:sedit_GroupMasterPolicyMultiProducerSplit_commissionSplitPercentage"));
        // CommonBaseTest.js.executeScript("arguments[0].scrollIntoView();", buttonAddAssignment);
        buttonAddAssignment.waitForPageUpdate();
        //buttonAddAssignment.click();
        buttonAddAssignment.waitForPageUpdate();
        WebElement secondAgency = CommonBaseTest.driver.findElement(By.xpath("//select[@id='policyDataGatherForm:sedit_GroupMasterPolicyMultiProducerInfo_producerCd']"));
        Select option2 = new Select(secondAgency);
        option2.selectByIndex(1);
        //CommonBaseTest.driver.findElement(By.id("policyDataGatherForm:sedit_GroupMasterPolicyMultiProducerSplit_commissionSplitPercentage")).sendKeys("40");
        // Tab.buttonNext.click();


    }

    public static class AssignedAgencies extends RepeatAssetList {

        public AssignedAgencies(By locatorTemplate, Class<? extends MetaData> metaDataClass) {
            super(ByT.xpath(Page.DEFAULT_ASSETLIST_CONTAINER), metaDataClass);
        }

        public AssignedAgencies(BaseElement<?, ?> parent, By locatorTemplate, Class<? extends MetaData> metaDataClass) {
            super(ByT.xpath(Page.DEFAULT_ASSETLIST_CONTAINER), metaDataClass);
        }

        @Override
        protected boolean sectionExists(int index) {
            return tableAssignedAgencies.getRow(index + 1).isPresent();
        }

        @Override
        protected void addSection(int index, int size) {
            buttonAddAssignment.click();
        }
    }

    public enum AssignedAgenciesTable implements Named {
        AGENCY_PRODUCER_NAME("Agency/Producer Name"),
        PRIMARY("Primary?"),
        COMMISSION_SPLIT("Commission Split?"),
        // System.out.prtinln("");
        SPLIT_PERCENT("Split %");
        //  System.out.println("");

        // AGENT_SUB_PRODUCER_NAME("Agent/Sub-Producer Name");
        private String name;

        AssignedAgenciesTable(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    @Override
    public String getTabName() {
        return POLICY_INFORMATION.get();
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.leftMenu(this.getTabName());
        return this;
    }

    public void changeSitusStateValue(String value) {
        navigateToTab();
        this.assetList.getAsset(SITUS_STATE).setValue(value);
    }

}
