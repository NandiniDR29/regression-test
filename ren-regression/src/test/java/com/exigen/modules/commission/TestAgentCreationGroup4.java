package com.exigen.modules.commission;

import com.exigen.istf.data.TestData;
import com.exigen.modules.agent.Agency;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.commission.commissiongroup.metadata.CommissionGroupMetaData;
import com.exigen.ren.admin.modules.commission.commissiongroup.tabs.CommissionGroupTab;
import com.exigen.ren.common.Tab;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.helpers.CommonGenericMethods.SaveAgencyCode;
import static com.exigen.helpers.CommonGenericMethods.SaveAgencyCode2;
import static com.exigen.modules.agent.Agency.selectAgencyForUpdate;
import static com.exigen.ren.TestDataKey.DATA_GATHER;
import static com.exigen.ren.TestDataKey.DEFAULT_TEST_DATA_KEY;
import static com.exigen.ren.admin.modules.commission.commissiongroup.metadata.CommissionGroupMetaData.AGENCIES;
import static com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy.metadata.GBCommissionRuleMetaData.ADD_COMMISSION_RULE;
import static com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy.metadata.GBCommissionRuleMetaData.AddCommissionRule.SELECT_SALES_CHANNEL;
import static com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy.metadata.GBCommissionRuleMetaData.AddCommissionRule.SelectSalesChannel.COMMISSION_CHANNEL_GROUP_NAME;


public class TestAgentCreationGroup4 extends CommissionStrategyBaseTest {
    @Test(priority = 0)
    public void testAgentCreationGroup3() throws IOException {
        logger = extent.startTest(groupNo + " Agent Creation for Group3");
        prop.load(fileInput);
        reportLog("Navigate Admin Section",0);
        driver.findElement(By.id("logoutForm:switchToAdmin")).click();
        reportLog("Creating Agent",1);
        String agencyName = agency.createAgency(TestDataProvider.getDefaultTestDataProvider().get("modules/platform/admin/agencyvendor/agency", "DataGatherGroup4").getTestData(TestDataKey.TEST_DATA_KEY1));
        reportLog("Created Agent Name "+ agencyName,1);
        SaveAgencyCode(Agency.agencySearch(agencyName));
        profileAgency.initiate();
        Agency.profileCreation(prop.getProperty("Agency_code"));
        Tab.buttonNext.click();
        Tab.buttonSave.click();
        String agencyName2 = agency.createAgency(TestDataProvider.getDefaultTestDataProvider().get("modules/platform/admin/agencyvendor/agency", "DataGatherGroup4").getTestData(TestDataKey.TEST_DATA_KEY2));
        reportLog("Created Agent Name "+ agencyName2,1);
        SaveAgencyCode2(Agency.agencySearch(agencyName2));
        profileAgency.initiate();
        Agency.profileCreation(prop.getProperty("Agency_code2"));
        Tab.buttonNext.click();
        Tab.buttonSave.click();
        commonSteps(agencyName,prop.getProperty("Agency_code"),prop.getProperty("GroupName1"));
        commonSteps(agencyName2,prop.getProperty("Agency_code2"),prop.getProperty("GroupName2"));
        driver.findElement(By.id("logoutForm:switchToApp")).click();
        reportLog("==========================================",1);
    }

    private String getCommissionGroupName(String agencyName) {
        ImmutableMap<String, String> channelCommissionGroup = commissionGroup.createGroup(commissionGroup.getDefaultTestData().getTestData(DATA_GATHER, DEFAULT_TEST_DATA_KEY)
                .adjust(TestData.makeKeyPath(CommissionGroupTab.class.getSimpleName(), AGENCIES.getLabel(), CommissionGroupMetaData.AddAgencies.AGENCY_NAME.getLabel()), agencyName));
        return channelCommissionGroup.get("Group Name");
    }
    public void commonSteps(String agencyName,String agencyCode, String groupName){
        try{
            reportLog("Creating Commission Group",1);
            String channelCommissionGroupName = getCommissionGroupName(agencyName);
            System.out.println(channelCommissionGroupName);
            reportLog("Created Commission Group "+ channelCommissionGroupName,1);
            TestData flatTestData = TestDataProvider.getDefaultTestDataProvider().get("/modules/commission/commissionstrategy", "CommissionStrategyGroup4").getTestData("Flat_CommissionRule")
                    .adjust(TestData.makeKeyPath(ADD_COMMISSION_RULE.getLabel(), SELECT_SALES_CHANNEL.getLabel(), COMMISSION_CHANNEL_GROUP_NAME.getLabel()), channelCommissionGroupName).resolveLinks();
            reportLog("Add Strategy for Dental",1);
            createCommissionStrategy(TestDataProvider.getDefaultTestDataProvider().get("/modules/commission/commissionstrategy", "CommissionStrategyGroup4").getTestData("TestDataDental")
                    .adjust(gbCommissionRuleTab.getMetaKey(), ImmutableList.of(flatTestData)), false);

            reportLog("Add Strategy for Short Term Disability",1);
            createCommissionStrategy(TestDataProvider.getDefaultTestDataProvider().get("/modules/commission/commissionstrategy", "CommissionStrategyGroup4").getTestData("TestDataSTD")
                    .adjust(gbCommissionRuleTab.getMetaKey(), ImmutableList.of(flatTestData)), false);

            reportLog("Add Strategy for Vision",1);
            createCommissionStrategy(TestDataProvider.getDefaultTestDataProvider().get("/modules/commission/commissionstrategy", "CommissionStrategyGroup4").getTestData("TestDataVision")
                    .adjust(gbCommissionRuleTab.getMetaKey(), ImmutableList.of(flatTestData)), false);

            reportLog("Add Strategy for Term Life",1);
            createCommissionStrategy(TestDataProvider.getDefaultTestDataProvider().get("/modules/commission/commissionstrategy", "CommissionStrategyGroup4").getTestData("TestDataLife")
                    .adjust(gbCommissionRuleTab.getMetaKey(), ImmutableList.of(flatTestData)), false);}
        catch (Exception e) {
            selectAgencyForUpdate(agencyCode, groupName);
        }
    }
}
