package com.exigen.modules.agent;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.SequenceCharcterAndExcelUpdateUtils;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.CheckBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.EntityLogger;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.agencyvendor.IAgencyVendor;
import com.exigen.ren.admin.modules.agencyvendor.agency.actions.AgencyCreateAction;
import com.exigen.ren.admin.modules.agencyvendor.agency.actions.AgencyUpdateAction;
import com.exigen.ren.admin.modules.agencyvendor.pages.AgencyVendorSummaryPage;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static com.exigen.basetest.Util.currentTime;

public class Agency implements IAgencyVendor {
    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/agency");

    private Workspace defaultView = AutomationContext.getAction(AgencyCreateAction.class).getWorkspace();

    @FindBy(xpath = "//*[@id='brokerManagementForm:addButton']")
    WebElement addAgency;

    @FindBy(xpath = "//*[@id=\"brokerManagementForm:searchCriteria_code\"]")
    WebElement addText;
    @Override
    public Workspace getDefaultWorkspace() {
        return defaultView;
    }

    public String createAgency(TestData td) {
        initiate();
        getDefaultWorkspace().fill(td);
        String entity = EntityLogger.getEntityHeader(EntityLogger.EntityType.AGENCY_NAME);
        new Button(By.xpath("//input[contains(@id,'saveButton_footer')]")).click();
        LOGGER.info("Created Agency with Name:" + entity);

        return entity;
    }

    @Override
    public void initiate() {
        navigate();
        AgencyVendorSummaryPage.buttonAddNewAgency.click();
    }

    @Override
    public void navigate() {
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.AGENCY_VENDOR);
        NavigationPage.toLeftMenuTab(NavigationEnum.AgencyVendorLeftMenu.AGENCY);
        Waiters.SLEEP(5000).go();
    }

    @Override
    public AgencyUpdateAction update() {
        return AutomationContext.getAction(AgencyUpdateAction.class);
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }

    public void AddAgencyButton()
    {
        // addText.click();
        System.out.println("working here");
        addAgency.click();
    }
    public static String agencySearch(String agencyName){
        String agencyCode = "";
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.AGENCY_VENDOR);
        NavigationPage.toLeftMenuTab(NavigationEnum.AgencyVendorLeftMenu.AGENCY);
        Waiters.SLEEP(5000).go();
        CommonBaseTest.driver.findElement(By.xpath("//input[@id='brokerManagementForm:searchCriteria_name']")).sendKeys(agencyName);
        CommonBaseTest.driver.findElement(By.xpath("//input[@id='brokerManagementForm:searchButton']")).click();
        agencyCode=CommonBaseTest.driver.findElement(By.xpath("//a[@id='brokerManagementForm:body_brokerInfoTable:0:brokerInfo_code']")).getText();
        return agencyCode;
    }
    public static void profileCreation(String agencyCode){
        new TextBox(By.xpath("//input[@id='userProfileForm:firstName']")).setValue(CommonBaseTest.prop.getProperty("FName").concat(SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime()))),Waiters.DEFAULT);
        new TextBox(By.xpath("//input[@id='userProfileForm:lastName']")).setValue(CommonBaseTest.prop.getProperty("LName").concat(SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime()))),Waiters.DEFAULT);
        new TextBox(By.xpath("//input[@id='userProfileForm:profileId']")).setValue(CommonBaseTest.prop.getProperty("FName").concat(SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime()))));
        new CheckBox(By.xpath("//input[@id='userProfileForm:commissionableCheckbox']")).setValue(true,Waiters.DEFAULT);
        CommonBaseTest.js.executeScript("arguments[0].scrollIntoView();", CommonBaseTest.driver.findElement(By.xpath("//input[@id='userProfileForm:commissionableCheckbox']")));
        new Button(By.xpath("//input[@id='userProfileForm:selectBroker']")).click();
        new TextBox(By.xpath("//input[@id='brokerSearchFromsearchBrokerCd:brokerSearchCriteria_code']")).setValue(agencyCode);
        new Button(By.xpath("//input[@id='brokerSearchFromsearchBrokerCd:searchBtn']")).click();
        new CheckBox(By.xpath("//input[@id='brokerSearchFromsearchBrokerCd:body_brokerSearchResultssearchBrokerCd:0:select']")).setValue(true,Waiters.DEFAULT);
        new Button(By.xpath("//input[@id='brokerSearchFromsearchBrokerCd:addBtn']")).click();
        new CheckBox(By.xpath("//input[@id='userProfileForm:userAgencyLocations:0:default']")).setValue(true,Waiters.DEFAULT);
        new TextBox(By.xpath("//input[@id='userProfileForm:profile_name']")).setValue(CommonBaseTest.prop.getProperty("UserName").concat(SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime()))));
        new TextBox(By.xpath("//input[@id='userProfileForm:profile_login']")).setValue(CommonBaseTest.prop.getProperty("UserName").concat(SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime()))));
        new TextBox(By.xpath("//input[@id='userProfileForm:new_password']")).setValue(CommonBaseTest.prop.getProperty("Password"));
        new TextBox(By.xpath("//input[@id='userProfileForm:confirm_password']")).setValue(CommonBaseTest.prop.getProperty("Password"));



    }
    public static void selectAgencyForUpdate(String agencyCode, String groupName){
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.AGENCY_VENDOR);
        NavigationPage.toLeftMenuTab(NavigationEnum.AgencyVendorLeftMenu.AGENCY);
        Waiters.SLEEP(5000).go();
        new TextBox(By.id("brokerManagementForm:searchCriteria_code")).setValue(agencyCode);
        new Button(By.xpath("//input[@id='brokerManagementForm:searchButton']")).click();
        new Button(By.id("brokerManagementForm:body_brokerInfoTable:0:brokerInfoChangeBtn"),Waiters.DEFAULT).click();
        new Button(By.id("brokerAgencyInfoForm:commissionGroupsSelect")).click();
        new TextBox(By.xpath("//input[@id='searchForm_commissionGroupSearch:searchTemplate_commissionGroupSearch']")).setValue(groupName);
        new  Button(By.xpath("//input[@id='searchForm_commissionGroupSearch:executeSearch_commissionGroupSearch']")).click();
        new Actions(CommonBaseTest.driver).moveToElement(CommonBaseTest.driver.findElement(By.xpath("//option[@title='"+groupName+"']"))).doubleClick().perform();
        new Actions(CommonBaseTest.driver).pause(Duration.ofSeconds(10)).perform();
        Tab.buttonUpdate.click();
        new Button(By.id("brokerAgencyInfoForm:brokerTopTabsList:3:linkLabel")).click();
        Tab.buttonDone.click();
    }
}
