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
import static com.exigen.helpers.CommonGenericMethods.testdataSelection;
import static com.exigen.ren.main.modules.customer.metadata.GeneralTabMetaData.EIN;
import static com.exigen.ren.main.modules.customer.metadata.GeneralTabMetaData.NAME_LEGAL;

public class TestCustomerCreationForDentalClaim extends CustomerBaseTest {
    @Test(priority = 1)
    public void testCorpCustomerCreation() throws IOException {
        logger = extent.startTest(groupNo+" TestCustomerCreationForDentalClaim");
        prop.load(fileInput);
        reportLog("Application launch",0);
        reportLog("Navigate Customer CreationPage",1);
        String testDatapoint = testdataSelection(groupNo);
        MainPage.QuickSearch.buttonSearchPlus.click();
        reportLog("Select Customer Creation Button",1);
        SearchPage.buttonCreateCustomer.click();
        reportLog("Fill All Required Data",1);
        AutomationContext.getAction(AddCustomerAction.class).getWorkspace().fillUpTo(tdCustomerNonIndividual.getTestData("ClaimDataGather", testDatapoint).adjust(TestData.makeKeyPath(GeneralTab.class.getSimpleName(), EIN.getLabel()), createEIN())
                .adjust(TestData.makeKeyPath(GeneralTab.class.getSimpleName(), NAME_LEGAL.getLabel()), prop.getProperty("CustomerName").concat( SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime())))).resolveLinks(), RelationshipTab.class);
        reportLog("customer Number: "+CustomerSummaryPage.labelCustomerNumber.getValue(),1);
        CommonGenericMethods.SaveCustomerNumberForNextValidation(CustomerSummaryPage.labelCustomerNumber.getValue(), groupNo);
        NavigationPage.toSubTab(NavigationEnum.CustomerSummaryTab.ACCOUNT.get());
        reportLog("Agency: "+TestCorpCustomerCreationGA.agencySelected()+" selected",1);
        reportLog("==================================", 1);

    }
}
