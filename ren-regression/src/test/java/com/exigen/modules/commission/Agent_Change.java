package com.exigen.modules.commission;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.basetest.Util;
import com.exigen.modules.agent.AgencyUpdate;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class Agent_Change extends CommonBaseTest {
    @Test(priority = 131)
    public void agentChange() throws IOException, InterruptedException {
        logger = extent.startTest(groupNo + " Agent Creation for Group1");
        prop.load(fileInput);
        reportLog("Search customer: "+prop.getProperty("CustomerNumber"),0);
        search(prop.getProperty("CustomerNumber"));
        CommissionAgentChange ca=new CommissionAgentChange(driver,js);
        reportLog("Update agency in Customer page",1);
        NavigationPage.toSubTab(NavigationEnum.CustomerSummaryTab.CONTACTS_RELATIONSHIPS.get());
        CustomerSummaryPage.buttonAddAgency.click();
        new AgencyUpdate(driver).updateAgency("QA",2,driver);
        Tab.buttonSaveAndExit.click();
        reportLog("Update Agency in CaseProfile",1 );
        ca.CaseProfileupdate();
        reportLog("Search MP: "+prop.getProperty("MPNumber"),1);
        search(prop.getProperty("MPNumber"));
        reportLog("Update new Agency",0);
        ca.agentChanging();
        reportLog("Agent changed", 1);
        reportLog("-------------------------------------", 1);
    }
}
