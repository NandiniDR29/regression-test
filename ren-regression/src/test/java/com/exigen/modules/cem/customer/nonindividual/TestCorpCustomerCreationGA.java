package com.exigen.modules.cem.customer.nonindividual;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.helpers.SequenceCharcterAndExcelUpdateUtils;
import com.exigen.istf.data.TestData;
import com.exigen.modules.agent.AgencyUpdate;
import com.exigen.modules.cem.customer.CustomerBaseTest;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.MainPage;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.SearchPage;
import com.exigen.ren.main.modules.account.actions.AddCustomerAction;
import com.exigen.ren.main.modules.customer.tabs.GeneralTab;
import com.exigen.ren.main.modules.customer.tabs.RelationshipTab;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static com.exigen.basetest.Util.currentTime;
import static com.exigen.helpers.CommonGenericMethods.createEIN;
import static com.exigen.ren.main.modules.customer.metadata.GeneralTabMetaData.EIN;
import static com.exigen.ren.main.modules.customer.metadata.GeneralTabMetaData.NAME_LEGAL;

public class TestCorpCustomerCreationGA extends CustomerBaseTest {
    @Test(priority = 1)
    public void testCorpGACustomerCreation() throws IOException {
        logger = extent.startTest(groupNo+" Corp GA Customer creation");
        prop.load(fileInput);
        reportLog("Application launch",0);
        reportLog("Navigate Customer CreationPage",1);
        MainPage.QuickSearch.buttonSearchPlus.click();
        reportLog("Select Customer Creation Button",1);
        SearchPage.buttonCreateCustomer.click();
        reportLog("Fill All Required Data",1);
        AutomationContext.getAction(AddCustomerAction.class).getWorkspace().fillUpTo(tdCustomerNonIndividual.getTestData("CorpDataGather", "TestData_GA").adjust(TestData.makeKeyPath(GeneralTab.class.getSimpleName(), EIN.getLabel()), createEIN())
                .adjust(TestData.makeKeyPath(GeneralTab.class.getSimpleName(), NAME_LEGAL.getLabel()), prop.getProperty("CustomerName").concat( SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime())))).resolveLinks(), RelationshipTab.class);
        reportLog("customer Number: "+CustomerSummaryPage.labelCustomerNumber.getValue(),1);
        CommonGenericMethods.SaveCustomerNumberForNextValidation(CustomerSummaryPage.labelCustomerNumber.getValue(), groupNo);
        NavigationPage.toSubTab(NavigationEnum.CustomerSummaryTab.CONTACTS_RELATIONSHIPS.get());
        CustomerSummaryPage.buttonAddAgency.click();
        new AgencyUpdate(driver).updateAgency(prop.getProperty("Agency_code"),1, driver);
        Tab.buttonSaveAndExit.click();
        NavigationPage.toSubTab(NavigationEnum.CustomerSummaryTab.CONTACTS_RELATIONSHIPS.get());
        CustomerSummaryPage.buttonAddAgency.click();
        new AgencyUpdate(driver).updateAgency(prop.getProperty("Agency_code2"),2, driver);
        Tab.buttonSaveAndExit.click();
        NavigationPage.toSubTab(NavigationEnum.CustomerSummaryTab.ACCOUNT.get());
        reportLog("Agency: "+TestCorpCustomerCreationGA.agencySelected()+" selected",1);
        reportLog("==================================", 1);

    }
    public static String agencySelected()
    {   CustomerSummaryPage.labelAccountNumber.waitForPageUpdate();
        String agencyName = "";
        List<WebElement> agencies = CommonBaseTest.driver.findElements(By.xpath("//tbody[@id='contactForm:brokers_data']//td//span[contains(@id,'brokerValue')]"));
        for (int i = 0; i < agencies.size(); i++) {
            agencyName= agencies.get(i).getText().concat(agencyName)+" ";
        }
        return agencyName;
    }

}
