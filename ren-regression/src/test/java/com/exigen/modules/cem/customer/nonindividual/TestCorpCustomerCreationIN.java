package com.exigen.modules.cem.customer.nonindividual;

import com.exigen.helpers.CommonGenericMethods;
import com.exigen.helpers.SequenceCharcterAndExcelUpdateUtils;
import com.exigen.istf.data.TestData;
import com.exigen.modules.cem.customer.CustomerBaseTest;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.MainPage;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.SearchPage;
import com.exigen.ren.main.modules.account.actions.AddCustomerAction;
import com.exigen.ren.main.modules.customer.tabs.GeneralTab;
import com.exigen.ren.main.modules.customer.tabs.RelationshipTab;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.basetest.Util.currentTime;
import static com.exigen.helpers.CommonGenericMethods.createEIN;
import static com.exigen.ren.main.modules.customer.metadata.GeneralTabMetaData.EIN;
import static com.exigen.ren.main.modules.customer.metadata.GeneralTabMetaData.NAME_LEGAL;

public class TestCorpCustomerCreationIN extends CustomerBaseTest {
    @Test(priority = 1)
    public void testCorpINCustomerCreation() throws IOException {
        logger = extent.startTest(groupNo+" Corp IN Customer creation");
        prop.load(fileInput);
        reportLog("Application launched",0);
        reportLog("Navigate Customer CreationPage",1);
        MainPage.QuickSearch.buttonSearchPlus.click();
        reportLog("Select Customer Creation Button",1);
        SearchPage.buttonCreateCustomer.click();
        reportLog("Fill All Required Data",1);
        if (groupNo.equalsIgnoreCase("Group10")) {
            AutomationContext.getAction(AddCustomerAction.class).getWorkspace().fillUpTo(tdCustomerNonIndividual.getTestData("CorpDataGather", "TestData_IN").adjust(TestData.makeKeyPath(GeneralTab.class.getSimpleName(), EIN.getLabel()), createEIN())
                    .adjust(TestData.makeKeyPath(GeneralTab.class.getSimpleName(), NAME_LEGAL.getLabel()), prop.getProperty("CustomerName").concat( SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime())))).resolveLinks(), RelationshipTab.class);
        }
        else {
            AutomationContext.getAction(AddCustomerAction.class).getWorkspace().fillUpTo(tdCustomerNonIndividual.getTestData("PEODataGather", "TestData_IN").adjust(TestData.makeKeyPath(GeneralTab.class.getSimpleName(), EIN.getLabel()), createEIN())
                    .adjust(TestData.makeKeyPath(GeneralTab.class.getSimpleName(), NAME_LEGAL.getLabel()), prop.getProperty("CustomerName").concat( SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime())))).resolveLinks(), RelationshipTab.class);

        }
        reportLog("customer Number: "+CustomerSummaryPage.labelCustomerNumber.getValue(),1);
        CommonGenericMethods.SaveCustomerNumberForNextValidation(CustomerSummaryPage.labelCustomerNumber.getValue(), groupNo);
        NavigationPage.toSubTab(NavigationEnum.CustomerSummaryTab.ACCOUNT.get());
        reportLog("Agency: "+TestCorpCustomerCreationGA.agencySelected()+" selected",1);
        reportLog("==================================", 1);

    }
}
