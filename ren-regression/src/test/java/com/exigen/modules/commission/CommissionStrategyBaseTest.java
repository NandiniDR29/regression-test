package com.exigen.modules.commission;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.istf.data.TestData;
import com.exigen.istf.verification.ETCSCoreSoftAssertions;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.admin.modules.agencyvendor.agency.AgencyContext;
import com.exigen.ren.admin.modules.agencyvendor.agency.metadata.AgencyInfoMetaData;
import com.exigen.ren.admin.modules.commission.commissiongroup.CommissionGroupContext;
import com.exigen.ren.admin.modules.commission.commissiongroup.metadata.CommissionGroupMetaData;
import com.exigen.ren.admin.modules.commission.commissiongroup.tabs.CommissionGroupTab;
import com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy.GBCommissionStrategyContext;
import com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy.metadata.GBCommissionStrategyMetaData;
import com.exigen.ren.admin.modules.commission.commissiontrategy.pages.CommissionPage;
import com.exigen.ren.admin.modules.security.profile.ProfileContext;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import static com.exigen.ren.admin.modules.commission.commissiongroup.metadata.CommissionGroupMetaData.AGENCIES;
import static com.exigen.ren.admin.modules.commission.commissiongroup.metadata.CommissionGroupMetaData.DIRECT;
import static com.exigen.ren.admin.modules.commission.commissiontrategy.pages.CommissionPage.CommissionStrategies.COMMISSION_STRATEGY_FOR_PRODUCT;
import static com.exigen.ren.admin.modules.security.profile.metadata.GeneralProfileMetaData.*;
import static com.exigen.ren.admin.modules.security.profile.metadata.GeneralProfileMetaData.AddAgencyMetaData.AGENCY_NAME;
import static com.exigen.utils.CommonMethods.getRandomElementFromList;
import static org.assertj.core.api.Assertions.assertThat;

public class CommissionStrategyBaseTest extends CommonBaseTest implements AgencyContext, ProfileContext, CommissionGroupContext, GBCommissionStrategyContext {
    public TestData gbCommissionStrategyDefaultTestData = gbCommissionStrategy.getDefaultTestData();
    public TestData tdAgencyDefault = agency.defaultTestData().getTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY);
    protected static String AGENCY_NAME_QA_AGENCY_CALL_CENTER = "QA Agency - Call Center";

    public static final ImmutableList<String> commissionStrategyProducts = ImmutableList.of(
            "GB_DI_LTD - Long Term Disability",
            "GB_DI_STD - Short Term Disability",
            "GB_VS - Group Vision",
            "GB_AC - Group pName",
            "GB_PFL - Paid Family Leave",
            "GB_DN - Group Dental",
            "GB_ST - Statutory Disability Insurance",
            "GB_TL - Term Life Insurance");

    public ImmutableMap<String, String> createIndividualCommissionGroup(String userLastName) {
      //  LOGGER.info("Create Commission group (group type = Individual) Group2 and add User1. Effective date=System date");
        return commissionGroup.createGroup(commissionGroup.getDefaultTestData().getTestData(TestDataKey.DATA_GATHER, "TestData_Individual")
                .adjust(TestData.makeKeyPath(CommissionGroupTab.class.getSimpleName(), DIRECT.getLabel(), CommissionGroupMetaData.AddDirect.LAST_NAME.getLabel()), userLastName));
    }

    public ImmutableMap<String, String> createChannelCommissionGroup(String agencyName) {
       // LOGGER.info("Create Commission group (group type = Channel) Group1 and add Agency1. Effective date=System date");
        return commissionGroup.createGroup(commissionGroup.getDefaultTestData().getTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY)
                .adjust(TestData.makeKeyPath(CommissionGroupTab.class.getSimpleName(), AGENCIES.getLabel(), CommissionGroupMetaData.AddAgencies.AGENCY_NAME.getLabel()), agencyName));
    }

    public ImmutableMap<String, ImmutableMap<String, String>> createAgencyWithUserAndTwoCommissionGroups() {

        //LOGGER.info("Create Agency1");
        String agencyName = agency.createAgency(tdAgencyDefault);

       // LOGGER.info("Create User1 and assign to Agency1");
        ImmutableMap<String, String> profileInfo = profileAgency.createProfile(profileCorporate.defaultTestData().getTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY)
                .adjust(TestData.makeKeyPath(generalProfileTab.getMetaKey(), COMMISSIONABLE.getLabel()), "true")
                .adjust(TestData.makeKeyPath(generalProfileTab.getMetaKey(), AGENCY_LOCATIONS.getLabel(), AGENCY_NAME.getLabel()), agencyName)
                .adjust(TestData.makeKeyPath(generalProfileTab.getMetaKey(), AGENCY_LOCATIONS.getLabel(), CHANNEL.getLabel()),
                        tdAgencyDefault.getTestData(agencyInfoTab.getMetaKey()).getValue(AgencyInfoMetaData.CHANNEL.getLabel())));
        return ImmutableMap.of(
                "Channel Commission Group Info", createChannelCommissionGroup(agencyName),
                "Individual Commission Group Info", createIndividualCommissionGroup(profileInfo.get("Last Name")));
    }

    public String createDefaultCommissionStrategyWithRandomizeProduct() {
        return createCommissionStrategy(gbCommissionStrategyDefaultTestData.getTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY), true);
    }

    public String createDefaultCommissionStrategy() {
        return createCommissionStrategy(gbCommissionStrategyDefaultTestData.getTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY), false);
    }

    /**
     * 1. Expire commission strategy if exists.
     * 2. Create new commission strategy.
     * 3. Check if commission strategy was created.
     *
     * @param commissionStrategyTestData Commission Strategy TestData
     * @param randomizeProduct           Randomize product or select from commissionStrategyTestData
     * @return Product Code-Name
     */
    public synchronized String createCommissionStrategy(TestData commissionStrategyTestData, boolean randomizeProduct) {
        String productCodeName = (!randomizeProduct)
                ? commissionStrategyTestData.getTestData(gbCommissionStrategyTab.getMetaKey()).getValue(GBCommissionStrategyMetaData.PRODUCT_CODE_NAME.getLabel())
                : getRandomElementFromList(commissionStrategyProducts);
        if (gbCommissionStrategy.searched(gbCommissionStrategyDefaultTestData.getTestData("SearchData", TestDataKey.DEFAULT_TEST_DATA_KEY), productCodeName)) {
            expireCommissionStrategy(productCodeName);
        }
        gbCommissionStrategy.create(commissionStrategyTestData
                .adjust(TestData.makeKeyPath(gbCommissionStrategyTab.getMetaKey(), GBCommissionStrategyMetaData.PRODUCT_CODE_NAME.getLabel()), productCodeName));
        assertThat(gbCommissionStrategy.searched(gbCommissionStrategyDefaultTestData.getTestData("SearchData", TestDataKey.DEFAULT_TEST_DATA_KEY), productCodeName))
                        .as("Commission strategy was not found")
                        .isTrue();
        return productCodeName;
    }

    public void expireCommissionStrategy(String productCodeName) {
        String effectiveDate = CommissionPage.tableCommissionStrategies.getRow(COMMISSION_STRATEGY_FOR_PRODUCT.getName(), productCodeName).getCell(CommissionPage.CommissionStrategies.EFFECTIVE_DATE.getName()).getValue();
       // LOGGER.info("TEST: Expire strategy for {} with effDate {} for test {}", productCodeName, effectiveDate, getClass());
        gbCommissionStrategy.expire().perform(productCodeName, effectiveDate);
    }

    public void validateScheduleControl(ETCSCoreSoftAssertions softly, TextBox control, String sendData, String expData) {
        control.setValue(sendData);
        softly.assertThat(control).hasValue(expData).hasNoWarning();
    }
}