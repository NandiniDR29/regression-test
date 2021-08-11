package com.exigen.modules.policy.common.actions.common;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.istf.data.TestData;
import com.exigen.modules.caseprofile.tabs.ProposalActionTab;
import com.exigen.modules.caseprofile.tabs.QuotesSelectionActionTab;
import com.exigen.modules.policy.common.pages.CaseProfileSummaryPage;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import org.openqa.selenium.By;

import static com.exigen.ren.main.enums.CaseProfileConstants.CaseProfileTable.CASE_PROFILE_NAME;

public abstract class CommonProposeAction implements Action {
    public static final String SELECT_CASE_BY_NAME = "CaseName";

    protected Workspace workspace = new Workspace.Builder()
            .registerTab(QuotesSelectionActionTab.class)
            .registerTab(ProposalActionTab.class)
            .build();

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action start() {
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.CASE.get());
        if(CommonBaseTest.pName.equalsIgnoreCase("Accident")){
            CaseProfileSummaryPage.selectAccidentCase();
        }
        else if(CommonBaseTest.pName.equalsIgnoreCase("Stat")&&CommonBaseTest.groupNo.equalsIgnoreCase("Group10")){
            CaseProfileSummaryPage.selectStatCase();
        }
        else if(CommonBaseTest.pName.equalsIgnoreCase("STD")&&CommonBaseTest.groupNo.equalsIgnoreCase("Group4")){
            CaseProfileSummaryPage.selectSTDCase();
        }
        else if(CommonBaseTest.pName.equalsIgnoreCase("Dental")&&CommonBaseTest.groupNo.equalsIgnoreCase("Group6")){
            CaseProfileSummaryPage.selectSTDCase();
        }
        else{
        CaseProfileSummaryPage.tableSelectCaseProfile.getRow(1).getCell(CASE_PROFILE_NAME).controls.links.getFirst().click();}
        NavigationPage.toSubTab(NavigationEnum.CaseProfileTab.PROPOSALS.get());
        CaseProfileSummaryPage.buttonAddNewProposal.click();
        return this;
    }

    public Action start(TestData td) {
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.CASE.get());
        if(CommonBaseTest.pName.equalsIgnoreCase("Accident")){
            CaseProfileSummaryPage.selectAccidentCase();
        }
        else if(CommonBaseTest.pName.equalsIgnoreCase("Stat")&&CommonBaseTest.groupNo.equalsIgnoreCase("Group10")){
            CaseProfileSummaryPage.selectStatCase();
        }
        else if(CommonBaseTest.pName.equalsIgnoreCase("STD")&&CommonBaseTest.groupNo.equalsIgnoreCase("Group4")){
            CaseProfileSummaryPage.selectSTDCase();
        }
        else if(CommonBaseTest.pName.equalsIgnoreCase("Dental")&&CommonBaseTest.groupNo.equalsIgnoreCase("Group6")){
            CaseProfileSummaryPage.selectDentalCase();
        }
        else{
            CommonBaseTest.driver.findElement(By.xpath("//a[contains(text(),'CaseProfile')]")).click();
        }
        NavigationPage.toSubTab(NavigationEnum.CaseProfileTab.PROPOSALS.get());
        CaseProfileSummaryPage.buttonAddNewProposal.click();
        return this;
    }

    @Override
    public Action submit() {
        Tab.buttonOk.click();
        return this;
    }
}
