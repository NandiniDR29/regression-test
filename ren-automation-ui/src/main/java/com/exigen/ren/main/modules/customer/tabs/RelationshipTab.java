/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.tabs;

import com.exigen.ipb.eisa.utils.RetryService;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.BrowserController;
import com.exigen.istf.webdriver.ByT;
import com.exigen.istf.webdriver.controls.*;
import com.exigen.istf.webdriver.controls.composite.assets.RepeatAssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.composite.table.Row;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ActionConstants;
import com.exigen.ren.main.enums.SearchConstants;
import com.exigen.ren.main.modules.customer.metadata.RelationshipTabMetaData;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import org.openqa.selenium.By;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.exigen.ren.common.enums.NavigationEnum.CustomerTab.RELATIONSHIP;

public class RelationshipTab extends DefaultTab {
    public static final Button buttonAddRelationship = new Button(By.id("crmForm:addRelationshipBtn"));
    public static final Button buttonSearchPartyRelationship = new Button(By.xpath("//a[text()='Search Party Relationship']"));
    public static final ComboBox comboBoxRelationshipRole = new ComboBox(By.id("crmForm:generalInfoRight_0_relationshipRole"));
    public static final ComboBox comboBoxSelectContactMethod = new ComboBox(By.id("crmForm:contactMethod_0:contactMethodSelect"));
    public static final Link linkRelationshipsTogglePanel = new Link(By.xpath("//div[@id='crmForm:newRelationshipsTogglePanel_1:header']//div[@class='rf-cp-lbl-colps']"));
    public static final Button buttonAddNewContactDetails = new Button(By.xpath(".//a[@id='crmForm:contactMethod_0:addContactEvent']"));
    public static final Button buttonRemoveThisRelationship = new Button(By.xpath(".//a[@id='crmForm:removeRelationshipBtn_0']"));
    public static final Table tableRelationshipPartySearchResult = new Table(By.id("crmPartyForm:partyList"));


    public static final StaticElement labelTaxIdentification = new StaticElement(By.xpath(
            "//div[@id='crmForm:customerRelationshipsTogglePanel']//*[@class= 'rf-cp rf-tgp contactMethodContainer'][2]//span[contains(@id, 'crmForm:taxId')]"));
    public static final StaticElement labelBusinessStarted = new StaticElement(By.xpath(
            "//div[@id='crmForm:customerRelationshipsTogglePanel']//*[@class= 'rf-cp rf-tgp contactMethodContainer'][2]//span[contains(@id, 'crmForm:dateStarted')]"));

    private static final By ADD_NEW_CONTACT_DETAILS = By.xpath(".//a[contains(.,'Add New Contacts Details')]");
    private static final By SELECT_CONTACT_METHOD = By.xpath(".//select[contains(@id,'contactMethodSelect')]");
    private static final ByT SAVE_ALL = ByT.xpath("//div[contains(@id,'RelationshipsTogglePanel')]//input[@id='crmForm:saveButton_%s']");
    private static final ByT EDIT_RELATIONSHIP = ByT.id("crmForm:editRelationship_%s");
    private static final ByT REMOVE_RELATIONSHIP = ByT.id("crmForm:removeRelationshipBtn_%s");
    private static final ByT EDIT_CONTACT_DETAILS = ByT.xpath("//input[@id='crmForm:customerContactsTable%s:%s:editContact']");
    private static final ByT SEARCH_PARTY_RELATIONSHIP = ByT.id("crmForm:searchPartyRelationshipBtn_%s");
    private static final ByT NAME_LEGAL = ByT.id("crmForm:generalInfoLeft_%s_legalName");
    private static final ByT LINK_RELATIONSHIPS = ByT.xpath("//div[@id='crmForm:newRelationshipsTogglePanel_%s:header']//div[@class='rf-cp-lbl-colps']");
    private static final ByT REFERENCE = ByT.id("crmForm:referenceLink_%s");

    public RelationshipTab() {
        super(RelationshipTabMetaData.class);

        assetList = new RepeatAssetList(ByT.id("crmForm:newRelationshipsTogglePanel_%s"), metaDataClass) {

            @Override
            protected void setRawValue(List<TestData> value) {
                String keySearchParty = RelationshipTabMetaData.SEARCH_PARTY_RELATIONSHIP.getLabel();

                int size = value.size();
                for (int i = 0; i < size; i++) {
                    if (!value.get(i).getKeys().isEmpty()) {
                        if (!sectionExists(i)) {
                            addSection(i, size);
                        }
                        setSectionValue(i, value.get(i).mask(keySearchParty));

                        value.get(i).removeAdjustment(keySearchParty);
                        if (value.get(i).getKeys().contains(keySearchParty)) {
                            new Button(SEARCH_PARTY_RELATIONSHIP.format(i)).click();
                            CustomerSummaryPage.tableRelationshipPartySearchResult.getRow(1).getCell(11)
                                    .controls.links.get(ActionConstants.GET).click();
                        }
                        Button buttonSaveAllContacts = new Button(SAVE_ALL.format(i));

                        if (buttonSaveAllContacts.isPresent()) {
                            buttonSaveAllContacts.click();
                        }
                    }
                }
            }

            @Override
            protected void addSection(int index, int size) {
                buttonAddRelationship.click();
            }

            @Override
            public void selectSection(int i) {
                new Button(EDIT_RELATIONSHIP.format(i)).click();
            }

            @Override
            protected TestData getSectionValue(int index) {
                selectSection(index);
                return super.getSectionValue(index);
            }
        };
        this.assetList.setName(RelationshipTab.class.getSimpleName());
    }

    public static void editRelationship(int businessNum) {
        new Button(EDIT_RELATIONSHIP.format(businessNum - 1)).click();
    }

    public static void editContactDetails(int businessNum, int contactNum) {
        new Button(EDIT_CONTACT_DETAILS.format(businessNum - 1, contactNum - 1)).click();
    }

    public static void removeRelationship(int businessNum) {
        new Button(REMOVE_RELATIONSHIP.format(businessNum - 1)).click();
        Page.dialogConfirmation.confirm();
        Page.dialogConfirmation.confirm();
    }

    public static void searchAndGetPartyRelationshipNonIndByName(int businessNum, String customerName) {
        LOGGER.info(String.format("NonIndividual Party relationship selected with %s", customerName));
        Button searchRelationship = new Button(SEARCH_PARTY_RELATIONSHIP.format(businessNum - 1));
        TextBox txtNameLegal = new TextBox(NAME_LEGAL.format(businessNum - 1));

        RetryService.run(
                predicate -> searchRelationship.isPresent(),
                () -> {
                    BrowserController.get().driver().navigate().refresh();
                    txtNameLegal.setValue(customerName);
                    return null;
                },
                StopStrategies.stopAfterAttempt(5), WaitStrategies.fixedWait(5, TimeUnit.SECONDS));
        searchRelationship.click();

        RetryService.run(
                predicate -> RelationshipTab.tableRelationshipPartySearchResult.isPresent(),
                () -> {
                    Tab.buttonCancel.click();
                    searchRelationship.click();
                    return null;
                },
                StopStrategies.stopAfterAttempt(5), WaitStrategies.fixedWait(5, TimeUnit.SECONDS));

        RelationshipTab.tableRelationshipPartySearchResult.getRowContains(SearchConstants.SearchResultTable.NAME_LEGAL, customerName)
                .getCell(SearchConstants.SearchResultTable.ACTION).controls.links.get(ActionConstants.GET).click();
    }

    public static void searchAndGetPartyRelationshipIndByName(int businessNum, String customerName) {
        LOGGER.info(String.format("Individual Party relationship selected with %s", customerName));
        Button searchPartyRelationship = new Button(SEARCH_PARTY_RELATIONSHIP.format(businessNum - 1));
        searchPartyRelationship.click();
        Row rowWithResult = RelationshipTab.tableRelationshipPartySearchResult.getRowContains(SearchConstants.SearchResultTable.NAME, customerName);
        if (!RelationshipTab.tableRelationshipPartySearchResult.isPresent() && !rowWithResult.isPresent()) {
            RetryService.run(predicate -> RelationshipTab.tableRelationshipPartySearchResult.isPresent() && rowWithResult.isPresent(),
                    () -> {
                        Tab.buttonCancel.click();
                        searchPartyRelationship.click();
                        return null;
                    }, StopStrategies.stopAfterAttempt(5), WaitStrategies.fixedWait(3, TimeUnit.SECONDS));
        }
        rowWithResult.getCell(SearchConstants.SearchResultTable.ACTION).controls.links.get(ActionConstants.GET).click();
    }

    public static String getRelationShipCustomerReference(int businessNum) {
        new Button(LINK_RELATIONSHIPS.format(businessNum - 1)).click();
        return new Link(REFERENCE.format(businessNum - 1)).getValue();
    }

    public static void submitNewRelationship(int businessNum) {
        new Button(SAVE_ALL.format(businessNum - 1)).click();
    }

    public static class AddressDetailsRelationship extends ContactDetails {

        public AddressDetailsRelationship(By locatorTemplate, Class<? extends MetaData> metaDataClass) {
            super(ByT.xpath("//div[contains(@id,'crmForm:addressInfo') and contains(@id,'_%s') and .='Address Details']/.."), metaDataClass);
        }

        public AddressDetailsRelationship(BaseElement<?, ?> parent, By locatorTemplate, Class<? extends MetaData> metaDataClass) {
            super(ByT.xpath("//div[contains(@id,'crmForm:addressInfo') and contains(@id,'_%s') and .='Address Details']/.."), metaDataClass);
        }

        @Override
        protected String getContactType() {
            return "Address";
        }
    }

    public static class PhoneDetailsRelationship extends ContactDetails {

        public PhoneDetailsRelationship(By locatorTemplate, Class<? extends MetaData> metaDataClass) {
            super(ByT.xpath("//div[contains(@id,'crmForm:phoneInfo') and contains(@id,'_%s') and .='Phone Details' ]/.."), metaDataClass);
        }

        public PhoneDetailsRelationship(BaseElement<?, ?> parent, By locatorTemplate, Class<? extends MetaData> metaDataClass) {
            super(parent, ByT.xpath("//div[contains(@id,'crmForm:phoneInfo') and contains(@id,'_%s') and .='Phone Details']/.."), metaDataClass);
        }

        @Override
        protected String getContactType() {
            return "Phone";
        }
    }

    public static class EmailDetailsRelationship extends ContactDetails {

        public EmailDetailsRelationship(By locatorTemplate, Class<? extends MetaData> metaDataClass) {
            super(ByT.xpath("//div[contains(@id,'crmForm:emailInfo') and contains(@id,'_%s') and .='Email Details']/.."), metaDataClass);
        }

        public EmailDetailsRelationship(BaseElement<?, ?> parent, By locatorTemplate, Class<? extends MetaData> metaDataClass) {
            super(parent, ByT.xpath("//div[contains(@id,'crmForm:emailsInfo') and contains(@id,'_%s') and .='Email Details']/.."), metaDataClass);
        }

        @Override
        protected String getContactType() {
            return "Email";
        }
    }

    public static class ChatDetailsRelationship extends ContactDetails {

        public ChatDetailsRelationship(By locatorTemplate, Class<? extends MetaData> metaDataClass) {
            super(ByT.xpath("//div[contains(@id,'crmForm:chatInfo') and contains(@id,'_%s') and .='Chat Details']/.."), metaDataClass);
        }

        public ChatDetailsRelationship(BaseElement<?, ?> parent, By locatorTemplate, Class<? extends MetaData> metaDataClass) {
            super(parent, ByT.xpath("//div[contains(@id,'crmForm:chatInfo') and contains(@id,'_%s') and .='Chat Details']/.."), metaDataClass);
        }

        @Override
        protected String getContactType() {
            return "Chat";
        }
    }

    public static class WebUrlDetailsRelationship extends ContactDetails {

        public WebUrlDetailsRelationship(By locatorTemplate, Class<? extends MetaData> metaDataClass) {
            super(ByT.xpath("//div[contains(@id,'crmForm:webAddressInfo') and contains(@id,'_%s') and .='Web URL Details']/.."), metaDataClass);
        }

        public WebUrlDetailsRelationship(BaseElement<?, ?> parent, By locatorTemplate, Class<? extends MetaData> metaDataClass) {
            super(parent, ByT.xpath("//div[contains(@id,'crmForm:webAddressInfo') and contains(@id,'_%s') and .='Web URL Details']/.."), metaDataClass);
        }

        @Override
        protected String getContactType() {
            return "Web URL";
        }
    }

    public static class SocialNetDetailsRelationship extends ContactDetails {

        public SocialNetDetailsRelationship(By locatorTemplate, Class<? extends MetaData> metaDataClass) {
            super(ByT.xpath("//div[contains(@id,'crmForm:socialNetInfo') and contains(@id,'_%s') and .='Social Net Details']/.."), metaDataClass);
        }

        public SocialNetDetailsRelationship(BaseElement<?, ?> parent, By locatorTemplate, Class<? extends MetaData> metaDataClass) {
            super(parent, ByT.xpath("//div[contains(@id,'crmForm:socialNetInfo') and contains(@id,'_%s') and .='Social Net Details']/.."), metaDataClass);
        }

        @Override
        protected String getContactType() {
            return "Social Net";
        }
    }

    private abstract static class ContactDetails extends RepeatAssetList {

        public ContactDetails(ByT locatorTemplate1, Class<? extends MetaData> metaDataClass) {
            super(locatorTemplate1, metaDataClass);
        }

        public ContactDetails(BaseElement<?, ?> parent1, ByT locatorTemplate, Class<? extends MetaData> metaDataClass) {
            super(parent1, locatorTemplate, metaDataClass);
        }

        @Override
        protected void addSection(int index, int size) {
            new ComboBox(new StaticElement(container.get().getLocator()), SELECT_CONTACT_METHOD).setValue(getContactType());
            new Button(new StaticElement(container.get().getLocator()), ADD_NEW_CONTACT_DETAILS).click();
        }

        protected abstract String getContactType();
    }

    @Override
    public Tab submitTab() {
        if (buttonDone.isPresent()) {
            buttonDone.click();
        } else {
            buttonNext.click();
        }
        return this;
    }

    @Override
    public Tab navigateToTab() {
        if (!isTabSelected()) {
            navigate();
        }
        return this;
    }

    @Override
    public boolean isTabSelected() {
        return NavigationPage.isSubTabSelected(this.getTabName());
    }

    @Override
    public Tab navigate() {
        NavigationPage.toSubTab(this.getTabName());
        return this;
    }

    @Override
    public String getTabName() {
        return RELATIONSHIP.get();
    }
}
