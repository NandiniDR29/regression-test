/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.policy.gb_dn.masterpolicy.tabs;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.data.TestData;
import com.exigen.istf.verification.CustomAssertions;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.modules.policy.gb_dn.masterpolicy.metadata.PlanDefinitionTabMetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ActionConstants;
import com.exigen.ren.main.enums.PolicyConstants;
import com.exigen.ren.main.enums.TableConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.exigen.ren.common.enums.NavigationEnum.GroupBenefitsTab.PLAN_DEFINITION;

public class PlanDefinitionTab extends DefaultTab {

    public static final TableExtended<TableConstants.CoverageDefinition> planTable = new TableExtended<>("Plan Selection", By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListPreconfigGroupCoverageDefinition']/div/table"));
    public static final StaticElement TWO_ADDITIONAL_PERIO_MAINTENANCE_VISITS_INFO = new StaticElement(By.id("policyDataGatherForm:sedit_PreconfigGroupDentalPreventAndDiagnostic_twoAdditionalPerioMaintenanceVisits_helpText"));
    public PlanDefinitionTab() {
        super(PlanDefinitionTabMetaData.class);


        assetList = new MultiAssetList(By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER), metaDataClass) {


            @Override
            protected void addSection(int index, int size) {
            }

            @Override
            protected void selectSection(int index) {
            }

            @Override
            public void fill(TestData td) {
                if (td.containsKey(name)) {
                    fillSection(td);
                }
            }

            private void fillSection(TestData td) {
                for (TestData plan : td.getTestDataList(name)) {
                    if (plan.containsKey("PlanKey")) {
                        planTable.getRow(PolicyConstants.PolicyPlanTable.PLAN, plan.getValue("PlanKey")).getCell(6).controls.links.get(ActionConstants.CHANGE).click();
                    }
                    List<TestData> list = new ArrayList<>();
                    list.add(plan);
                    setValue(list);
                }
            }

        };
        assetList.setName(this.getClass().getSimpleName());
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.leftMenu(this.getTabName());
        return this;
    }

    @Override
    public String getTabName() {
        return PLAN_DEFINITION.get();
    }

    @Override
    public Tab submitTab() {
        buttonNext.click(doubleWaiter);
        return this;
    }

    public void selectTwoPlan(String datagether, String plan) {

    }
    public  void errorMessages(WebDriver driver, String ERROR_MESSAGE_Major, String ERROR_MESSAGE_Prosthodontics)
    {
        WebElement majorError = driver.findElement(By.xpath("//div[contains(@class,'error-container')]//span//span[@id='policyDataGatherForm:sedit_PreconfigGroupCoinsuranceBenefitsMajorViewOnly_proxiedComponents_PreconfigGroupCoinsuranceBenefitsComponent_oonMajorPct_error']"));
        WebElement prosthodonticsError = driver.findElement(By.xpath("//div[contains(@class,'error-container')]//span//span[@id='policyDataGatherForm:sedit_RenCoinsuranceBenefitsProsthodonticsViewOnly_proxiedComponents_PreconfigGroupCoinsuranceBenefitsComponent_oonProsthodonticsPct_error']"));
        CustomAssertions.assertThat(prosthodonticsError.getText()).isEqualTo(ERROR_MESSAGE_Prosthodontics);
        CommonBaseTest.reportLog("Expected error message :"+prosthodonticsError.getText(),1);
        CustomAssertions.assertThat(majorError.getText()).isEqualTo(ERROR_MESSAGE_Major);
        CommonBaseTest.reportLog("Expected error message :"+majorError.getText(),1);
        Tab.buttonSaveAndExit.click();
        CommonBaseTest.reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Saved For State Error Validation with status "+PolicySummaryPage.labelPolicyStatus.getValue(),1);

    }

}
