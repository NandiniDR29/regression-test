/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.policy.gb_dn.masterpolicy.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.ipb.eisa.controls.ratingreport.RedistributionCalculatorComboBox;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.modules.policy.gb_dn.masterpolicy.metadata.PremiumSummaryTabMetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.components.Dialog;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.TableConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.exigen.ren.common.enums.NavigationEnum.GroupBenefitsTab.PREMIUM_SUMMARY;

public class PremiumSummaryTab extends DefaultTab {
    public static Button buttonRate = new Button(By.xpath("//input[@value = 'Rate' and not(@class = 'hidden') and not(contains(@style,'none'))]"), doubleWaiter);
    public static Button buttonOverrideAndRatePremium = new Button(By.xpath("//input[@value='Override Rate and Premium']"));
    public static Button buttonMaintainInForceRates = new Button(By.id("policyDataGatherForm:processMaintainInForceRateButton_callRateOverridePopup"));
    public static Button buttonViewRateHistory = new Button(By.id("policyDataGatherForm:callViewRateHistoryPopup"));

    public static Dialog dialogPremiumOverride = new Dialog("//div[@id='policyOverrideInfoForm:masterPolicyPremiumOverridePopup']");
    public static StaticElement labelFinalAnnualPremium = new StaticElement(By.xpath("//div[@id='policyOverrideInfoForm:masterPolicyPremiumOverridePopup']//tr[td[contains(., 'Final Annual Premium')]]/td[2]"));
    public static StaticElement labelTotalPremium = new StaticElement(By.xpath("//table[@id='policyDataGatherForm:totalPremiumAmt']//tr[td[contains(., 'Total Annual Premium')]]/td[2]"));
    public static final TableExtended<TableConstants.PremiumSummaryCoveragesTable> premiumSummaryCoveragesTable = new TableExtended<>("Premium Summary Coverages Table", By.xpath("//div[@id='policyDataGatherForm:coverageDefinitionPremiums']/div/table"));
    public static final TableExtended<TableConstants.PremiumSummaryCoveragesTable> premiumSummaryByPayorCoveragesTable = new TableExtended<>("Premium Summary by Payor", By.xpath("//div[@id='policyDataGatherForm:splitCoverageGroupPremiums']/div/table"));
    public static final TableExtended<TableConstants.PremiumSummaryASOFeeTable> premiumSummaryASOFeeTable = new TableExtended<>("Premium Summary ASO Fee Table", By.xpath("//*[@id='policyDataGatherForm:renAsoFeeBasis']/div/table"));
    public PremiumSummaryTab() {
        super(PremiumSummaryTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        rate();
        buttonNext.click();
        return this;
    }

    public void rate() {
        buttonRate.waitForAccessible(1000);
        buttonRate.click();
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.leftMenu(this.getTabName(), doubleWaiter);
        return this;
    }

    @Override
    public String getTabName() {
        return PREMIUM_SUMMARY.get();
    }

    public static void openOverrideAndRatePremiumPopUp() {
        Waiters.AJAX.go();
        buttonOverrideAndRatePremium.click();
    }

    public static class RatingReportView {

        public static final String RATING_REPORT_SECTION_LOCATOR = "//div[@id='ratingReportContent']";
        public static Link lnkAdminExpenses = new Link(By.xpath(String.format("%s//h2[text()='Admin Expenses']", RATING_REPORT_SECTION_LOCATOR)));
        public static Link lnkRatingDetails = new Link(By.xpath(String.format("%s//h2[text()='Rating Details - ']", RATING_REPORT_SECTION_LOCATOR)));
        public static Link lnkDemographic = new Link(By.xpath(String.format("%s//a[text()='Demographic']", RATING_REPORT_SECTION_LOCATOR)));
        public static Link lnkRedistributionCalculator = new Link(By.xpath(String.format("%s//a[text()='Redistribution Calculator']", RATING_REPORT_SECTION_LOCATOR)));
        public static Button btnApplyRates = new Button(By.xpath("//a[text()='APPLY RATES']"), doubleWaiter);
        public static RedistributionCalculatorComboBox cbxRatingDetailsSelectPlan = new RedistributionCalculatorComboBox
                (By.xpath("//h2[text()='Rating Details - ']//parent::div[1]//following-sibling::div//div[@class=' css-2b097c-container']"), doubleWaiter);

        //
        public static void expandRatingDetails() {
            if (!isRatingDetailsExpanded()) {
                lnkRatingDetails.click(Waiters.AJAX.then(Waiters.SLEEP(20000)));
            }
        }

        //
        public static void openRedistributionCalculatorSection() {
            expandRatingDetails();
            lnkRedistributionCalculator.click();
        }

        public static boolean isRatingDetailsExpanded() {
            return lnkDemographic.isPresent() && lnkDemographic.isVisible();
        }

        public static void fillNewRate(String currentRate, String ReNewalRates, String override, WebDriver driver) {
            new TextBox(By.xpath("(//div[contains(@class,'in-01')]//input)[1]")).setValue(override);
            WebElement Employee = driver.findElement(By.xpath("//*[@id='ratingReportContent']/div/div[2]/div[2]/div[2]/div/table/tr[2]/td[1]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", Employee);
            new  TextBox(By.xpath("//*[contains(text(),'Employee only')]/./following-sibling::td[4]//input")).setValue(currentRate, doubleWaiter);
            new  TextBox(By.xpath("//*[contains(text(),'Employee only')]/./following-sibling::td[5]//input")).setValue(ReNewalRates, doubleWaiter);
            new  TextBox(By.xpath("//*[contains(text(),'Employee + Spouse')]/./following-sibling::td[4]//input")).setValue(currentRate, doubleWaiter);
            new  TextBox(By.xpath("//*[contains(text(),'Employee + Spouse')]/./following-sibling::td[5]//input")).setValue(ReNewalRates, doubleWaiter);
            new  TextBox(By.xpath("//*[contains(text(),'Employee + Child(ren)')]/./following-sibling::td[4]//input")).setValue(currentRate, doubleWaiter);
            new  TextBox(By.xpath("//*[contains(text(),'Employee + Child(ren)')]/./following-sibling::td[5]//input")).setValue(ReNewalRates, doubleWaiter);
            new  TextBox(By.xpath("//*[contains(text(),'Employee + Family')]/./following-sibling::td[4]//input")).setValue(currentRate, doubleWaiter);
            new  TextBox(By.xpath("//*[contains(text(),'Employee + Family')]/./following-sibling::td[5]//input")).setValue(ReNewalRates, doubleWaiter);
        }

        //
        public static void reDistributeLink() {
            new Link(By.xpath("//*[contains(text(),'REDISTRIBUTE RATES')]")).click();
        }

        //
        public static void applyRates() {
            btnApplyRates.click();
        }

        //
        public static void applyAdjustLink() {
            new Link(By.xpath("//*[contains(text(),'APPLY ADJUSTMENTS')]")).click();
        }

    }}
