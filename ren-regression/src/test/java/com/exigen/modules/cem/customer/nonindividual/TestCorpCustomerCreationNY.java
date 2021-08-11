package com.exigen.modules.cem.customer.nonindividual;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.helpers.SequenceCharcterAndExcelUpdateUtils;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
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
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import static com.exigen.basetest.Util.currentTime;
import static com.exigen.helpers.CommonGenericMethods.*;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.modules.customer.metadata.GeneralTabMetaData.*;

public class TestCorpCustomerCreationNY extends CustomerBaseTest {
    @Test(priority = 1)
    public void testCorpNYCustomerCreation() throws IOException {
        logger = extent.startTest(groupNo+" Corp NY Customer creation");
        prop.load(fileInput);
        String testData = CommonGenericMethods.testdataSelection(groupNo);
        reportLog("Application launched",0);
        reportLog("Navigate Customer CreationPage",1);
        MainPage.QuickSearch.buttonSearchPlus.click();
        reportLog("Select Customer Creation Button",1);
        SearchPage.buttonCreateCustomer.click();
        reportLog("Fill All Required Data",1);
        AutomationContext.getAction(AddCustomerAction.class).getWorkspace().fillUpTo(tdCustomerNonIndividual.getTestData("CorpDataGather", testData).adjust(TestData.makeKeyPath(GeneralTab.class.getSimpleName(), EIN.getLabel()), createEIN())
                .adjust(TestData.makeKeyPath(GeneralTab.class.getSimpleName(), NAME_LEGAL.getLabel()), prop.getProperty("CustomerName").concat( SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime())))).resolveLinks(), RelationshipTab.class);
        reportLog("customer Number: "+CustomerSummaryPage.labelCustomerNumber.getValue(),1);
        CommonGenericMethods.SaveCustomerNumberForNextValidation(CustomerSummaryPage.labelCustomerNumber.getValue(), groupNo);
        if(groupNo.equalsIgnoreCase("Group1")){
        NavigationPage.toSubTab(NavigationEnum.CustomerSummaryTab.CONTACTS_RELATIONSHIPS.get());
        CustomerSummaryPage.buttonAddAgency.click();
            new AgencyUpdate(driver).updateAgency(prop.getProperty("Agency_code"),1, driver);
            Tab.buttonSaveAndExit.click();
            Waiters.SLEEP(9000).go();
            SaveEINCustomerID(CustomerSummaryPage.labelCustomerNumber.getValue(),CustomerSummaryPage.labelEin.getValue());
            reportLog("Navigate Contact Relationship tab ",1);
            NavigationPage.toSubTab(NavigationEnum.CustomerSummaryTab.CONTACTS_RELATIONSHIPS.get());
            reportLog("Add Relationship contact",1);
            customerNonIndividual.addRelationshipContact().perform(tdCustomerNonIndividual.getTestData("CorpDataGather", "Adjustment_Relationship").adjust(TestData.makeKeyPath(RelationshipTab.class.getSimpleName(), SSN_TAX_IDENTIFICATION.getLabel()),createEIN())
                    .adjust(TestData.makeKeyPath(RelationshipTab.class.getSimpleName(), LAST_NAME.getLabel()),SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime()))).resolveLinks());
            storeRelationDetail();
        }
        NavigationPage.toSubTab(NavigationEnum.CustomerSummaryTab.ACCOUNT.get());
        reportLog("Agency: "+TestCorpCustomerCreationGA.agencySelected()+" selected",1);
        reportLog("==================================", 1);
    }

}
