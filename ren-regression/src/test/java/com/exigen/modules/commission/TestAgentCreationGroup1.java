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
import static com.exigen.modules.agent.Agency.selectAgencyForUpdate;
import static com.exigen.ren.TestDataKey.DATA_GATHER;
import static com.exigen.ren.TestDataKey.DEFAULT_TEST_DATA_KEY;
import static com.exigen.ren.admin.modules.commission.commissiongroup.metadata.CommissionGroupMetaData.AGENCIES;
import static com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy.metadata.GBCommissionRuleMetaData.ADD_COMMISSION_RULE;
import static com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy.metadata.GBCommissionRuleMetaData.AddCommissionRule.SELECT_SALES_CHANNEL;
import static com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy.metadata.GBCommissionRuleMetaData.AddCommissionRule.SelectSalesChannel.COMMISSION_CHANNEL_GROUP_NAME;

public class TestAgentCreationGroup1 extends CommissionStrategyBaseTest {
    @Test(priority = 0)
    public void testAgentCreationGroup1() throws IOException {
        logger = extent.startTest(groupNo + " Agent Creation for Group1");
        prop.load(fileInput);
        reportLog("Navigate Admin Section",0);
        driver.findElement(By.id("logoutForm:switchToAdmin")).click();
        reportLog("Creating Agent",1);
        String agencyName = agency.createAgency(TestDataProvider.getDefaultTestDataProvider().get("modules/platform/admin/agencyvendor/agency", "DataGatherGroup1").getTestData(TestDataKey.DEFAULT_TEST_DATA_KEY));
        reportLog("Created Agent Name "+ agencyName,1);
        SaveAgencyCode(Agency.agencySearch(agencyName));
        profileAgency.initiate();
        Agency.profileCreation(prop.getProperty("Agency_code"));
        Tab.buttonNext.click();
        Tab.buttonSave.click();
        try{
            reportLog("Creating Commission Group",1);
            String channelCommissionGroupName = getCommissionGroupName(agencyName);
            System.out.println(channelCommissionGroupName);
            reportLog("Created/Update Commission Group "+ channelCommissionGroupName,1);
            TestData flatTestData = TestDataProvider.getDefaultTestDataProvider().get("/modules/commission/commissionstrategy", "CommissionStrategyGroup1").getTestData("Tiered_CommissionRule")
                    .adjust(TestData.makeKeyPath(ADD_COMMISSION_RULE.getLabel(), SELECT_SALES_CHANNEL.getLabel(), COMMISSION_CHANNEL_GROUP_NAME.getLabel()), channelCommissionGroupName).resolveLinks();
            reportLog("Add Strategy for pName",1);
            createCommissionStrategy(TestDataProvider.getDefaultTestDataProvider().get("/modules/commission/commissionstrategy", "CommissionStrategyGroup1").getTestData("TestDataAccident")
                    .adjust(gbCommissionRuleTab.getMetaKey(), ImmutableList.of(flatTestData)), false);

            reportLog("Add Strategy for Short Term Disability",1);
            createCommissionStrategy(TestDataProvider.getDefaultTestDataProvider().get("/modules/commission/commissionstrategy", "CommissionStrategyGroup1").getTestData("TestDataSTD")
                    .adjust(gbCommissionRuleTab.getMetaKey(), ImmutableList.of(flatTestData)), false);

            reportLog("Add Strategy for Long Term Disability",1);
            createCommissionStrategy(TestDataProvider.getDefaultTestDataProvider().get("/modules/commission/commissionstrategy", "CommissionStrategyGroup1").getTestData("TestDataLTD")
                    .adjust(gbCommissionRuleTab.getMetaKey(), ImmutableList.of(flatTestData)), false);

            reportLog("Add Strategy for Term Life",1);
            createCommissionStrategy(TestDataProvider.getDefaultTestDataProvider().get("/modules/commission/commissionstrategy", "CommissionStrategyGroup1").getTestData("TestDataLife")
                    .adjust(gbCommissionRuleTab.getMetaKey(), ImmutableList.of(flatTestData)), false);

            reportLog("Add Strategy for Dental",1);
            createCommissionStrategy(TestDataProvider.getDefaultTestDataProvider().get("/modules/commission/commissionstrategy", "CommissionStrategyGroup1").getTestData("TestDataDental")
                    .adjust(gbCommissionRuleTab.getMetaKey(), ImmutableList.of(flatTestData)), false);

            reportLog("Add Strategy for STAT",1);
            createCommissionStrategy(TestDataProvider.getDefaultTestDataProvider().get("/modules/commission/commissionstrategy", "CommissionStrategyGroup1").getTestData("TestDataSTAT")
                    .adjust(gbCommissionRuleTab.getMetaKey(), ImmutableList.of(flatTestData)), false);
            reportLog("Agent Name for Group1="+ agencyName, 1);}
        catch (Exception e){
            selectAgencyForUpdate(prop.getProperty("Agency_code"), prop.getProperty("GroupName1"));
        }

        reportLog("==========================================",1);
        driver.findElement(By.id("logoutForm:switchToApp")).click();
    }

    private String getCommissionGroupName(String agencyName) {
        ImmutableMap<String, String> channelCommissionGroup = commissionGroup.createGroup(commissionGroup.getDefaultTestData().getTestData(DATA_GATHER, DEFAULT_TEST_DATA_KEY)
                .adjust(TestData.makeKeyPath(CommissionGroupTab.class.getSimpleName(), AGENCIES.getLabel(), CommissionGroupMetaData.AddAgencies.AGENCY_NAME.getLabel()), agencyName));
        return channelCommissionGroup.get("Group Name");
    }

}
