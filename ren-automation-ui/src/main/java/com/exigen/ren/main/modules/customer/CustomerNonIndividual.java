/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer;

import com.exigen.ipb.eisa.utils.RetryService;
import com.exigen.istf.data.TestData;
import com.exigen.istf.exceptions.IstfException;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.MainPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.common.pages.SearchPage;
import com.exigen.ren.main.enums.CustomerConstants;
import com.exigen.ren.main.modules.customer.metadata.CustomerTypeMetaData;
import com.exigen.ren.main.modules.customer.tabs.CustomerTypeTab;
import com.exigen.ren.main.modules.customer.tabs.GeneralTab;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;

import java.util.concurrent.TimeUnit;

import static com.exigen.ren.main.modules.customer.CustomerContext.generalTab;
import static com.exigen.ren.main.modules.customer.metadata.GeneralTabMetaData.ENROLLMENT_FILE_DIALOG;
import static com.exigen.ren.main.modules.customer.metadata.GeneralTabMetaData.EnrollmentFileMetaData.*;
import static com.exigen.ren.main.modules.customer.metadata.GeneralTabMetaData.ISSUE_ENROLLMENT;

public class CustomerNonIndividual extends Customer {

    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/nonindividualcustomer");

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }

    public void initiate() {
        MainPage.QuickSearch.buttonSearchPlus.click();
        SearchPage.buttonCreateCustomer.click();
        getDefaultWorkspace().getTab(CustomerTypeTab.class).getAssetList().getAsset(CustomerTypeMetaData.CUSTOMER_TYPE).setValue(CustomerConstants.NON_INDIVIDUAL);
        getDefaultWorkspace().getTab(CustomerTypeTab.class).submitTab();
    }

    public void setSalesRep(String userFirstName, String userLastName) {
        update().perform(getDefaultTestData().getTestData("Update", "TestData_Add_Sales_Rep")
                .adjust(TestData.makeKeyPath(getDefaultWorkspace().getTab(GeneralTab.class).getMetaKey(), "Sales Rep Internal", "First Name"), userFirstName)
                .adjust(TestData.makeKeyPath(getDefaultWorkspace().getTab(GeneralTab.class).getMetaKey(), "Sales Rep Internal", "Last Name"), userLastName));
    }

    public void uploadIssueEnrollmentFile(String enrollmentFileType, String fileName) {
        LOGGER.info(String.format("Upload Issue Enrollment File: '%s'", fileName));
        inquiry().start();
        generalTab.getAssetList().getAsset(ISSUE_ENROLLMENT).click();
        switch (enrollmentFileType) {
            case "Initial": {
                generalTab.getAssetList().getAsset(ENROLLMENT_FILE_DIALOG).getAsset(ENROLLMENT_FILE_TYPE).setValue("Initial");
                break;
            }
            case "Maintenance": {
                generalTab.getAssetList().getAsset(ENROLLMENT_FILE_DIALOG).getAsset(ENROLLMENT_FILE_TYPE).setValue("Maintenance");
                break;
            }
            default:
                throw new IstfException(String.format("Enrollment File Type '%s' isn't correct", enrollmentFileType));
        }
        generalTab.getAssetList().getAsset(ENROLLMENT_FILE_DIALOG).getAsset(RETRIEVE).click();

        try {
            RetryService.run(predicate -> generalTab.getAssetList().getAsset(ENROLLMENT_FILE_DIALOG).getAsset(ENROLLMENT_FILE).getAllValues()
                            .stream().anyMatch(file -> file.contains(fileName)),
                    () -> {
                        generalTab.getAssetList().getAsset(ENROLLMENT_FILE_DIALOG).getAsset(RETRIEVE).click();
                        return null;
                    }, StopStrategies.stopAfterAttempt(30), WaitStrategies.fixedWait(30, TimeUnit.SECONDS));
        } catch (RuntimeException e) {
            throw new IstfException("Enrollment File is absent", e);
        }
        generalTab.getAssetList().getAsset(ENROLLMENT_FILE_DIALOG).getAsset(ENROLLMENT_FILE).setValueContains(fileName);
        generalTab.getAssetList().getAsset(ENROLLMENT_FILE_DIALOG).getAsset(SUBMIT_POPUP).click();
        Page.dialogConfirmation.confirm();
        Tab.buttonCancel.click();
    }
}