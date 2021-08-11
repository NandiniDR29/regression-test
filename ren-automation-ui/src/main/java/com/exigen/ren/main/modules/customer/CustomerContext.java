/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.composite.assets.RepeatAssetList;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.MainPage;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.SearchPage;
import com.exigen.ren.main.modules.customer.metadata.RelationshipTabMetaData;
import com.exigen.ren.main.modules.customer.tabs.*;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;
import com.google.common.collect.ImmutableList;

import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.CustomerConstants.CustomerRelationshipServiceRole.*;
import static com.exigen.ren.main.enums.CustomerConstants.CustomerRelationshipToCustomer.SERVICE_ROLES;
import static com.exigen.ren.main.enums.CustomerConstants.INDIVIDUAL;
import static com.exigen.ren.main.modules.customer.metadata.RelationshipTabMetaData.*;
import static com.exigen.ren.main.modules.customer.tabs.RelationshipTab.searchAndGetPartyRelationshipIndByName;

public interface CustomerContext {

    CustomerIndividual customerIndividual = AutomationContext.getService(CustomerIndividual.class);
    CustomerNonIndividual customerNonIndividual = AutomationContext.getService(CustomerNonIndividual.class);
    GeneralTab generalTab = customerIndividual.getDefaultWorkspace().getTab(GeneralTab.class);
    RelationshipTab relationshipTab = customerIndividual.getDefaultWorkspace().getTab(RelationshipTab.class);
    SearchMergeCustomerActionTab searchMergeCustomerActionTab = customerIndividual.mergeCustomer().getWorkspace().getTab(SearchMergeCustomerActionTab.class);
    MergeCustomerActionTab mergeCustomerActionTab = customerIndividual.mergeCustomer().getWorkspace().getTab(MergeCustomerActionTab.class);
    ProviderTab providerTab = customerIndividual.getDefaultWorkspace().getTab(ProviderTab.class);
    ViewHistoryActionTab viewHistoryActionTab = customerIndividual.viewHistory().getWorkspace().getTab(ViewHistoryActionTab.class);
    ScheduledUpdateActionTab scheduledUpdateActionTab = customerIndividual.scheduledUpdate().getWorkspace().getTab(ScheduledUpdateActionTab.class);
    DivisionsTab divisionsTab = customerIndividual.associateDivisions().getWorkspace().getTab(DivisionsTab.class);
    SponsorParticipantRelationshipAssociationRemovalActionTab sponsorParticipantRelationshipAssociationRemovalActionTab = customerIndividual.removeParticipantMembership().getWorkspace().getTab(SponsorParticipantRelationshipAssociationRemovalActionTab.class);
    EmployeeInfoTab employeeInfoTab = customerIndividual.addParticipant().getWorkspace().getTab(EmployeeInfoTab.class);


    default TestData getDefaultCustomerIndividualTestData() {
        return customerIndividual.getDefaultTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY);
    }

    default TestData getDefaultCustomerNonIndividualTestData() {
        return customerNonIndividual.getDefaultTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY);
    }
    default void createDefaultIndividualCustomer() {
        customerIndividual.create(getDefaultCustomerIndividualTestData());
    }

    default void createDefaultNonIndividualCustomer() {
        customerNonIndividual.create(getDefaultCustomerNonIndividualTestData());
    }

    default void initiateCreateIndividualAndFillToTab(TestData testData, Class<? extends Tab> tabClass, boolean isFillTab) {
        MainPage.QuickSearch.buttonSearchPlus.click();
        SearchPage.buttonCreateCustomer.click();
        customerIndividual.getDefaultWorkspace().fillUpTo(testData, tabClass, isFillTab);
    }

    default void initiateCreateNonIndividualAndFillToTab(TestData testData, Class<? extends Tab> tabClass, boolean isFillTab) {
        MainPage.QuickSearch.buttonSearchPlus.click();
        SearchPage.buttonCreateCustomer.click();
        customerNonIndividual.getDefaultWorkspace().fillUpTo(testData, tabClass, isFillTab);
    }

    default void navigateToCustomer() {
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.CUSTOMER.get());
    }

    default String createDefaultNICWithIndividualRelationshipWithRoles(ImmutableList<String> roles) {
        createDefaultIndividualCustomer();
        String customerNumberAuthorize = CustomerSummaryPage.labelCustomerNumber.getValue();
        String customerFirstName = CustomerSummaryPage.getCustomerFirstName();
        String customerLastName = CustomerSummaryPage.getCustomerLastName();
        String customerDOB = CustomerSummaryPage.labelCustomerDOB.getValue();
        createDefaultNICWithRelationship(customerFirstName, customerLastName, customerDOB, roles);
        return customerNumberAuthorize;
    }

    default void createDefaultNICWithIndividualRelationshipWithRoles(String numberIC, ImmutableList<String> roles) {
        search(numberIC);
        String customerFirstName = CustomerSummaryPage.getCustomerFirstName();
        String customerLastName = CustomerSummaryPage.getCustomerLastName();
        String customerDOB = CustomerSummaryPage.labelCustomerDOB.getValue();
        createDefaultNICWithRelationship(customerFirstName, customerLastName, customerDOB, roles);
    }


    default void createDefaultNICWithRelationship(String customerFirstName, String customerLastName, String customerDOB, ImmutableList<String> roles) {
        customerNonIndividual.create(getDefaultCustomerNonIndividualTestData());
        customerNonIndividual.update().start();
        customerNonIndividual.update().getWorkspace().getTab(relationshipTab.getClass()).navigateToTab();
        RelationshipTab.buttonAddRelationship.click();
        RepeatAssetList assetListRelationshipTab = (RepeatAssetList) relationshipTab.getAssetList();
        assetListRelationshipTab.getAsset(RelationshipTabMetaData.TYPE).setValue(INDIVIDUAL);
        assetListRelationshipTab.getAsset(FIRST_NAME, 0).setValue(customerFirstName);
        assetListRelationshipTab.getAsset(LAST_NAME, 0).setValue(customerLastName);
        assetListRelationshipTab.getAsset(DATE_OF_BIRTH, 0).setValue(customerDOB);
        assetListRelationshipTab.getAsset(RelationshipTabMetaData.RELATIONSHIP_TO_CUSTOMER, 0).setValue(SERVICE_ROLES);
        searchAndGetPartyRelationshipIndByName(1, customerFirstName);
        assetListRelationshipTab.getAsset(SERVICE_ROLE).setValue(roles);
        RelationshipTab.submitNewRelationship(1);
        relationshipTab.submitTab();
    }

    default String createDefaultNICWithIndRelationshipDefaultRoles() {
        return createDefaultNICWithIndividualRelationshipWithRoles(ImmutableList.of(ADMINISTRATIVE.getUIName(), BILLING.getUIName(), CLAIMS.getUIName(), PORTAL_BENEFITS_ADMINISTRATOR.getUIName()));
    }
}
