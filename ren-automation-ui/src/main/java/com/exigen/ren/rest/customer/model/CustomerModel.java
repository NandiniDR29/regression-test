/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.customer.model;

import com.exigen.istf.data.TestData;
import com.exigen.istf.utils.datetime.DateTimeUtils;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.helpers.rest.RestHelper;
import com.exigen.ren.main.modules.customer.CustomerIndividual;
import com.exigen.ren.main.modules.customer.metadata.CustomerTypeMetaData;
import com.exigen.ren.main.modules.customer.metadata.GeneralTabMetaData;
import com.exigen.ren.main.modules.customer.tabs.CustomerTypeTab;
import com.exigen.ren.main.modules.customer.tabs.EmploymentTab;
import com.exigen.ren.main.modules.customer.tabs.GeneralTab;
import com.exigen.ren.rest.customer.campaigns.model.CampaignModel;
import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.RandomStringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.exigen.ren.main.modules.customer.metadata.GeneralTabMetaData.SIC_CODE;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerModel extends RestError {

    @JsonIgnore
    private boolean individual;

    private String customerNumber;
    private String customerType;
    private String customerStatus = "QUALIFIED";
    private String accountNumber;
    private String sourceCd = "UNKNOWN";
    private String ratingCd = "UNKNOWN";
    private String displayValue;
    private String brandCd;
    private String preferredSpokenLanguageCd = "ENGLISH";
    private String preferredWrittenLanguageCd = "ENGLISH";
    private String preferredContactMethod;
    private Boolean paperless = Boolean.FALSE;
    private List<String> segments;
    private String registeredOnline;
    private String archived;
    private IndividualDetailsModel individualDetails;
    private BusinessDetailsModel businessDetails;
    private List<ContactMethodAddressModel> addresses;
    private List<ContactMethodChatModel> chats;
    private List<ContactMethodEmailModel> emails;
    private List<ContactMethodPhoneModel> phones;
    private List<ContactMethodSocialNetModel> socialNets;
    private List<ContactMethodWebAddressModel> webAddresses;
    private List<AgencyModel> agencies;
    private List<AdditionalNameModel> indCustomerAdditionalNames;
    private List<AdditionalNameModel> businessCustomerAdditionalNames;
    private List<EmploymentModel> customerEmployments;
    private List<RelationshipModel> genericRelationships;
    private List<NavigationLinkModel> navigationLinks;
    private List<CampaignModel> activeCampaigns;
    private ExtensionFieldsModel extensionFields;

    public CustomerModel() {
    }

    /**
     * Adapt UI testData for REST customer creation
     *
     * @param data UI testData
     */
    public CustomerModel(TestData data) {
        String customerTypeKey = ((CustomerIndividual) AutomationContext.getService(CustomerIndividual.class))
                .getDefaultWorkspace().getTab(CustomerTypeTab.class).getMetaKey();
        this.individual = data.getValue(customerTypeKey,
                CustomerTypeMetaData.CUSTOMER_TYPE.getLabel()).equals("Individual");

        setCustomerStatus(data);
        setCustomerType(data);
        setAddresses(data);
        setIndividualDetails(data);
        setBusinessDetails(data);
        setAgencies(data);
        setPhones(data);
        setChats(data);
        setEmails(data);
        setSocialNets(data);
        setWebAddresses(data);
        setCustomerEmployments(data);
        setIndCustomerAdditionalNames(data);
        setBusinessCustomerAdditionalNames(data);
        setExtensionFields(data);
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerType() {
        return customerType;
    }

    @JsonSetter("customerType")
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public void setCustomerType(TestData data) {
        if (individual) {
            this.customerType = "INDIVIDUAL_LEAD";
        } else {
            this.customerType = "BUSINESS_LEAD";
        }
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    /**
     * Implement an enum here when more complex logic is needed
     */
    @JsonGetter("customerStatus")
    public String getCustomerStatusForJson() {
        return customerStatus == null ? null : customerStatus.toUpperCase();
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    private void setCustomerStatus(TestData testData) {
        this.customerStatus = testData.getValue(GeneralTab.class.getSimpleName(), GeneralTabMetaData.LEAD_STATUS.getLabel());
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getSourceCd() {
        return sourceCd;
    }

    public void setSourceCd(String sourceCd) {
        this.sourceCd = sourceCd;
    }

    public String getRatingCd() {
        return ratingCd;
    }

    public void setRatingCd(String ratingCd) {
        this.ratingCd = ratingCd;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getBrandCd() {
        return brandCd;
    }

    public void setBrandCd(String brandCd) {
        this.brandCd = brandCd;
    }

    public String getPreferredSpokenLanguageCd() {
        return preferredSpokenLanguageCd;
    }

    public void setPreferredSpokenLanguageCd(String preferredSpokenLanguageCd) {
        this.preferredSpokenLanguageCd = preferredSpokenLanguageCd;
    }

    public String getPreferredWrittenLanguageCd() {
        return preferredWrittenLanguageCd;
    }

    public void setPreferredWrittenLanguageCd(String preferredWrittenLanguageCd) {
        this.preferredWrittenLanguageCd = preferredWrittenLanguageCd;
    }

    public Boolean getPaperless() {
        return paperless;
    }

    public void setPaperless(Boolean paperless) {
        this.paperless = paperless;
    }

    public List<String> getSegments() {
        return segments;
    }

    public void setSegments(List<String> segments) {
        this.segments = segments;
    }

    public String getRegisteredOnline() {
        return registeredOnline;
    }

    public void setRegisteredOnline(String registeredOnline) {
        this.registeredOnline = registeredOnline;
    }

    public String getArchived() {
        return archived;
    }

    public void setArchived(String archived) {
        this.archived = archived;
    }

    public IndividualDetailsModel getIndividualDetails() {
        return individualDetails;
    }

    @JsonSetter("individualDetails")
    public void setIndividualDetails(IndividualDetailsModel individualDetails) {
        this.individualDetails = individualDetails;
    }

    private void setIndividualDetails(TestData data) {
        if (individual) {
            TestData generalTab = data.getTestData(GeneralTab.class.getSimpleName());

            individualDetails = new IndividualDetailsModel();
            individualDetails.setFirstName("Rest" + generalTab.getValue("First Name"));
            individualDetails.setLastName("Rest" + generalTab.getValue("Last Name"));
            individualDetails.setTaxId(generalTab.getValue("SSN/Tax Identification"));
            individualDetails.setBirthDate(
                    LocalDate.parse(Optional.ofNullable(generalTab.getValue("Date of Birth"))
                            .orElse("10/10/1985"), DateTimeUtils.MM_DD_YYYY).format(DateTimeFormatter.ISO_DATE)
            );
            individualDetails.setAssociateBusinessEntity(generalTab.getValue("Associate Business Entities"));
        }
    }

    public BusinessDetailsModel getBusinessDetails() {
        return businessDetails;
    }

    @JsonSetter("businessDetails")
    public void setBusinessDetails(BusinessDetailsModel businessDetails) {
        this.businessDetails = businessDetails;
    }

    private void setBusinessDetails(TestData data) {
        if (!individual) {
            TestData generalTab = data.getTestData(GeneralTab.class.getSimpleName());

            businessDetails = new BusinessDetailsModel();
            businessDetails.setLegalName(
                    "Rest" + Optional.ofNullable(generalTab.getValue("Name - Legal"))
                            .orElse("Name11111")
            );
            businessDetails.setBusinessType("PRTN");
            businessDetails.setSicCode(Optional.ofNullable(generalTab.getValue(SIC_CODE.getLabel())).orElse("5411"));
            businessDetails.setLegalId(Optional.ofNullable(generalTab.getValue("EIN")).orElse("11-1111111")
            );
            businessDetails.setDateStarted(
                    LocalDate.parse(Optional.ofNullable(generalTab.getValue("Date business started"))
                            .orElse("01/06/2006"), DateTimeUtils.MM_DD_YYYY).format(DateTimeFormatter.ISO_DATE)
            );
            businessDetails.setTaxExemptInd(Boolean.FALSE);
            businessDetails.setGroupSponsorInd(Boolean.TRUE);
            businessDetails.setDbaName(generalTab.getValue("Name - DBA"));
        }
    }

    public List<ContactMethodAddressModel> getAddresses() {
        return addresses;
    }

    @JsonSetter("addresses")
    public void setAddresses(List<ContactMethodAddressModel> addresses) {
        this.addresses = addresses;
    }

    private void setAddresses(TestData data) {
        if (data.getTestData(GeneralTab.class.getSimpleName()).containsKey(GeneralTabMetaData.ADDRESS_DETAILS.getLabel())
                && !data.getTestDataList(GeneralTab.class.getSimpleName(), GeneralTabMetaData.ADDRESS_DETAILS.getLabel()).isEmpty()) {

            addresses = data.getTestDataList(GeneralTab.class.getSimpleName(), GeneralTabMetaData.ADDRESS_DETAILS.getLabel()).
                    stream().map(addressTestData -> new ContactMethodAddressModel(addressTestData, individual)).collect(Collectors.toList());
        }
    }


    public void setAgencies(TestData data) {
        if (data.getTestData(GeneralTab.class.getSimpleName()).containsKey(GeneralTabMetaData.AGENCY_ASSIGNMENT.getLabel())
                && !data.getTestDataList(GeneralTab.class.getSimpleName(), GeneralTabMetaData.AGENCY_ASSIGNMENT.getLabel()).isEmpty()) {

            agencies = data.getTestDataList(GeneralTab.class.getSimpleName(), GeneralTabMetaData.AGENCY_ASSIGNMENT.getLabel()).stream()
                    .map(agenciesTestData ->
                            new AgencyModel(agenciesTestData.getValue(GeneralTabMetaData.AddAgencyMetaData.AGENCY_PRODUCER.getLabel(),
                                    GeneralTabMetaData.AddAgencyMetaData.AGENCY_CODE.getLabel()))).
                            collect(Collectors.toList());
        }
    }

    public List<ContactMethodChatModel> getChats() {
        return chats;
    }

    private void setChats(TestData data) {
        if (data.getTestData(GeneralTab.class.getSimpleName()).containsKey(GeneralTabMetaData.CHAT_DETAILS.getLabel())
                && !data.getTestDataList(GeneralTab.class.getSimpleName(), GeneralTabMetaData.CHAT_DETAILS.getLabel()).isEmpty()) {

            chats = data.getTestDataList(GeneralTab.class.getSimpleName(), GeneralTabMetaData.CHAT_DETAILS.getLabel()).
                    stream().map(ContactMethodChatModel::new).collect(Collectors.toList());
        }
    }

    private void setEmails(TestData data) {
        if (data.getTestData(GeneralTab.class.getSimpleName()).containsKey(GeneralTabMetaData.EMAIl_DETAILS.getLabel())
                && !data.getTestDataList(GeneralTab.class.getSimpleName(), GeneralTabMetaData.EMAIl_DETAILS.getLabel()).isEmpty()) {

            emails = data.getTestDataList(GeneralTab.class.getSimpleName(), GeneralTabMetaData.EMAIl_DETAILS.getLabel()).
                    stream().map(ContactMethodEmailModel::new).collect(Collectors.toList());
        }
    }

    private void setWebAddresses(TestData data) {
        if (data.getTestData(GeneralTab.class.getSimpleName()).containsKey(GeneralTabMetaData.WEB_URL_DETAILS.getLabel())
                && !data.getTestDataList(GeneralTab.class.getSimpleName(), GeneralTabMetaData.WEB_URL_DETAILS.getLabel()).isEmpty()) {

            webAddresses = data.getTestDataList(GeneralTab.class.getSimpleName(), GeneralTabMetaData.WEB_URL_DETAILS.getLabel()).
                    stream().map(ContactMethodWebAddressModel::new).collect(Collectors.toList());
        }
    }

    private void setIndCustomerAdditionalNames(TestData data) {
        if (data.getTestData(GeneralTab.class.getSimpleName()).containsKey(GeneralTabMetaData.ADDITIONAL_NAMES.getLabel())
                && !data.getTestDataList(GeneralTab.class.getSimpleName(), GeneralTabMetaData.ADDITIONAL_NAMES.getLabel()).isEmpty()) {

            indCustomerAdditionalNames = data.getTestDataList(GeneralTab.class.getSimpleName(), GeneralTabMetaData.ADDITIONAL_NAMES.getLabel()).stream()
                    .filter(td -> td.getValue("Type").equals("Individual")).map(AdditionalNameModel::new).collect(Collectors.toList());
        }
    }

    private void setBusinessCustomerAdditionalNames(TestData data) {
        if (data.getTestData(GeneralTab.class.getSimpleName()).containsKey(GeneralTabMetaData.ADDITIONAL_NAMES.getLabel())
                && !data.getTestDataList(GeneralTab.class.getSimpleName(), GeneralTabMetaData.ADDITIONAL_NAMES.getLabel()).isEmpty()) {

            businessCustomerAdditionalNames = data.getTestDataList(GeneralTab.class.getSimpleName(), GeneralTabMetaData.ADDITIONAL_NAMES.getLabel()).stream()
                    .filter(td -> td.getValue("Type").equals("Business")).map(AdditionalNameModel::new).collect(Collectors.toList());
        }
    }

    private void setCustomerEmployments(TestData data) {
        if (data.containsKey(EmploymentTab.class.getSimpleName())
                && !data.getTestDataList(EmploymentTab.class.getSimpleName()).isEmpty()) {

            customerEmployments = data.getTestDataList(EmploymentTab.class.getSimpleName()).
                    stream().map(EmploymentModel::new).collect(Collectors.toList());
        }
    }

    public List<ContactMethodEmailModel> getEmails() {
        return emails;
    }

    @JsonSetter("emails")
    public void setEmails(List<ContactMethodEmailModel> emails) {
        this.emails = emails;
    }

    public List<ContactMethodPhoneModel> getPhones() {
        return phones;
    }

    @JsonSetter("phones")
    public void setPhones(List<ContactMethodPhoneModel> phones) {
        this.phones = phones;
    }

    @JsonSetter("chats")
    public void setChats(List<ContactMethodChatModel> chats) {
        this.chats = chats;
    }

    private void setPhones(TestData data) {
        if (data.getTestData(GeneralTab.class.getSimpleName()).containsKey(GeneralTabMetaData.PHONE_DETAILS.getLabel())
                && !data.getTestDataList(GeneralTab.class.getSimpleName(), GeneralTabMetaData.PHONE_DETAILS.getLabel()).isEmpty()) {

            phones = data.getTestDataList(GeneralTab.class.getSimpleName(), GeneralTabMetaData.PHONE_DETAILS.getLabel()).
                    stream().map(phoneTestData -> new ContactMethodPhoneModel(phoneTestData, individual)).collect(Collectors.toList());
        }
    }

    public List<ContactMethodSocialNetModel> getSocialNets() {
        return socialNets;
    }

    @JsonSetter("socialNets")
    public void setSocialNets(List<ContactMethodSocialNetModel> socialNets) {
        this.socialNets = socialNets;
    }

    private void setSocialNets(TestData data) {
        if (data.getTestData(GeneralTab.class.getSimpleName()).containsKey(GeneralTabMetaData.SOCIAL_NET_DETAILS.getLabel())
                && !data.getTestDataList(GeneralTab.class.getSimpleName(), GeneralTabMetaData.SOCIAL_NET_DETAILS.getLabel()).isEmpty()) {

            socialNets = data.getTestDataList(GeneralTab.class.getSimpleName(), GeneralTabMetaData.SOCIAL_NET_DETAILS.getLabel()).
                    stream().map(ContactMethodSocialNetModel::new).collect(Collectors.toList());
        }
    }

    public List<ContactMethodWebAddressModel> getWebAddresses() {
        return webAddresses;
    }

    @JsonSetter("webAddresses")
    public void setWebAddresses(List<ContactMethodWebAddressModel> webAddresses) {
        this.webAddresses = webAddresses;
    }

    public List<AgencyModel> getAgencies() {
        return agencies;
    }

    @JsonSetter("agencies")
    public void setAgencies(List<AgencyModel> agencies) {
        this.agencies = agencies;
    }

    public List<AdditionalNameModel> getIndCustomerAdditionalNames() {
        return indCustomerAdditionalNames;
    }

    @JsonSetter("indCustomerAdditionalNames")
    public void setIndCustomerAdditionalNames(List<AdditionalNameModel> indCustomerAdditionalNameModels) {
        this.indCustomerAdditionalNames = indCustomerAdditionalNameModels;
    }

    public List<AdditionalNameModel> getBusinessCustomerAdditionalNames() {
        return businessCustomerAdditionalNames;
    }

    @JsonSetter("businessCustomerAdditionalNames")
    public void setBusinessCustomerAdditionalNames(List<AdditionalNameModel> businessCustomerAdditionalNameModels) {
        this.businessCustomerAdditionalNames = businessCustomerAdditionalNameModels;
    }

    public List<EmploymentModel> getCustomerEmployments() {
        return customerEmployments;
    }

    @JsonSetter("customerEmployments")
    public void setCustomerEmployments(List<EmploymentModel> customerEmploymentModels) {
        this.customerEmployments = customerEmploymentModels;
    }

    public List<RelationshipModel> getGenericRelationships() {
        return genericRelationships;
    }

    public void setGenericRelationships(List<RelationshipModel> genericRelationships) {
        this.genericRelationships = genericRelationships;
    }

    public List<NavigationLinkModel> getNavigationLinks() {
        return navigationLinks;
    }

    public void setNavigationLinks(List<NavigationLinkModel> navigationLinks) {
        this.navigationLinks = navigationLinks;
    }

    public List<CampaignModel> getActiveCampaigns() {
        return activeCampaigns;
    }

    public void setActiveCampaigns(List<CampaignModel> activeCampaigns) {
        this.activeCampaigns = activeCampaigns;
    }

    public ExtensionFieldsModel getExtensionFields() {
        return extensionFields;
    }

    @JsonSetter("extensionFields")
    public void setExtensionFields(ExtensionFieldsModel extensionFields) {
        this.extensionFields = extensionFields;
    }

    private void setExtensionFields(TestData data) {
        if (data.getTestData(GeneralTab.class.getSimpleName()).containsKey(GeneralTabMetaData.SALES_REP_WORK_QUEUE.getLabel())
                && !data.getTestDataList(GeneralTab.class.getSimpleName(), GeneralTabMetaData.SALES_REP_WORK_QUEUE.getLabel()).isEmpty()) {

            OwnerModel owner = new OwnerModel();
            owner.setType("QUEUE");
            owner.setQueueName(data.getValue(GeneralTab.class.getSimpleName(), GeneralTabMetaData.SALES_REP_WORK_QUEUE.getLabel(),
                    GeneralTabMetaData.SalesRepWorkQueueMetaData.WORK_QUEUE.getLabel()));
            extensionFields = new ExtensionFieldsModel(owner);
            extensionFields.setMailCardsTo(data.getValue(GeneralTab.class.getSimpleName(), GeneralTabMetaData.MAIL_CARDS_TO.getLabel()) != null ? data.getValue(GeneralTab.class.getSimpleName(), GeneralTabMetaData.MAIL_CARDS_TO.getLabel()).toUpperCase() : null);
            extensionFields.setMailW2To(data.getValue(GeneralTab.class.getSimpleName(), GeneralTabMetaData.MAIL_W_2_TO.getLabel()) != null ? data.getValue(GeneralTab.class.getSimpleName(), GeneralTabMetaData.MAIL_W_2_TO.getLabel()).toUpperCase() : null);
            extensionFields.setElectronicSSAFiling(RestHelper.convertStringDataToRestBoolean(data.getValue(GeneralTab.class.getSimpleName(), GeneralTabMetaData.ELECTRONIC_SSA_FILING.getLabel())));
        }
    }

    public void resetAllCustomersIds() {
        setCustomerNumber(null);
        resetContactMethodsIds(getAddresses());
        resetContactMethodsIds(getPhones());
        resetContactMethodsIds(getEmails());
        resetContactMethodsIds(getChats());
        resetContactMethodsIds(getSocialNets());
        resetContactMethodsIds(getWebAddresses());
    }

    public void changeCustomersFieldsToAvoidDuplicatesForPerformanceTest() {
        if (null != this.getIndividualDetails()) {
            this.getIndividualDetails().setFirstName(String.format("Perf%1$s_FN %2$s", RandomStringUtils.randomAlphanumeric(5), RandomStringUtils.randomAlphanumeric(8)));
            this.getIndividualDetails().setLastName(String.format("Perf%1$s_LN %2$s", RandomStringUtils.randomAlphanumeric(5), RandomStringUtils.randomAlphanumeric(8)));
            this.setDisplayValue(String.format("%1$s %2$s", this.getIndividualDetails().getFirstName(), this.getIndividualDetails().getLastName()));
        }
        if (null != this.getBusinessDetails()) {
            this.getBusinessDetails().setLegalName(String.format("Perf%1$s_LN %2$s", RandomStringUtils.randomAlphanumeric(5), RandomStringUtils.randomAlphanumeric(8)));
            this.setDisplayValue(this.getBusinessDetails().getLegalName());
        }
        if (null != getAddresses()) {
            for (ContactMethodAddressModel contactMethod : getAddresses()) {
                contactMethod.setAddressLine1(String.format("Perf_%1$s Addr_%2$s", RandomStringUtils.randomAlphanumeric(5), RandomStringUtils.randomAlphanumeric(8)));
            }
        }
    }

    private void resetContactMethodsIds(List<? extends ContactMethodModel> contactMethods) {
        for (ContactMethodModel contactMethodModel : contactMethods) {
            contactMethodModel.setId(null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || !(o instanceof RestError)) {
            return false;
        }

        if (getErrorCode() != null) {
            return super.equals(o);
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        CustomerModel customer = (CustomerModel) o;

        if (customerType != null ? !customerType.equals(customer.customerType) : customer.customerType != null) {
            return false;
        }
        if (customerStatus != null ? !customerStatus.equals(customer.customerStatus) : customer.customerStatus != null) {
            return false;
        }
        if (sourceCd != null ? !sourceCd.equals(customer.sourceCd) : customer.sourceCd != null) {
            return false;
        }
        if (ratingCd != null ? !ratingCd.equals(customer.ratingCd) : customer.ratingCd != null) {
            return false;
        }
        if (displayValue != null ? !displayValue.equals(customer.displayValue) : customer.displayValue != null) {
            return false;
        }
        if (brandCd != null ? !brandCd.equals(customer.brandCd) : customer.brandCd != null) {
            return false;
        }
        if (preferredSpokenLanguageCd != null ? !preferredSpokenLanguageCd.equals(customer.preferredSpokenLanguageCd) : customer.preferredSpokenLanguageCd != null) {
            return false;
        }
        if (preferredWrittenLanguageCd != null ? !preferredWrittenLanguageCd.equals(customer.preferredWrittenLanguageCd) : customer.preferredWrittenLanguageCd != null) {
            return false;
        }
        if (preferredContactMethod != null ? !preferredContactMethod.equals(customer.preferredContactMethod) : customer.preferredContactMethod != null) {
            return false;
        }
        if (paperless != null ? !paperless.equals(customer.paperless) : customer.paperless != null) {
            return false;
        }
        if (segments != null ? !segments.equals(customer.segments) : customer.segments != null) {
            return false;
        }
        if (registeredOnline != null ? !registeredOnline.equals(customer.registeredOnline) : customer.registeredOnline != null) {
            return false;
        }
        if (archived != null ? !archived.equals(customer.archived) : customer.archived != null) {
            return false;
        }
        if (individualDetails != null ? !individualDetails.equals(customer.individualDetails) : customer.individualDetails != null) {
            return false;
        }
        if (businessDetails != null ? !businessDetails.equals(customer.businessDetails) : customer.businessDetails != null) {
            return false;
        }
        if (addresses != null ? !addresses.equals(customer.addresses) : customer.addresses != null) {
            return false;
        }
        if (chats != null ? !chats.equals(customer.chats) : customer.chats != null) {
            return false;
        }
        if (emails != null ? !emails.equals(customer.emails) : customer.emails != null) {
            return false;
        }
        if (phones != null ? !phones.equals(customer.phones) : customer.phones != null) {
            return false;
        }
        if (socialNets != null ? !socialNets.equals(customer.socialNets) : customer.socialNets != null) {
            return false;
        }
        if (webAddresses != null ? !webAddresses.equals(customer.webAddresses) : customer.webAddresses != null) {
            return false;
        }
        if (agencies != null ? !agencies.equals(customer.agencies) : customer.agencies != null) {
            return false;
        }
        if (indCustomerAdditionalNames != null ? !indCustomerAdditionalNames.equals(customer.indCustomerAdditionalNames) : customer.indCustomerAdditionalNames != null) {
            return false;
        }
        if (businessCustomerAdditionalNames != null ? !businessCustomerAdditionalNames.equals(customer.businessCustomerAdditionalNames) : customer.businessCustomerAdditionalNames != null) {
            return false;
        }
        if (customerEmployments != null ? !customerEmployments.equals(customer.customerEmployments) : customer.customerEmployments != null) {
            return false;
        }
        return genericRelationships != null ? genericRelationships.equals(customer.genericRelationships) : customer.genericRelationships == null;
    }

    @Override
    public int hashCode() {
        int result = customerType != null ? customerType.hashCode() : 0;
        result = 31 * result + (customerStatus != null ? customerStatus.hashCode() : 0);
        result = 31 * result + (sourceCd != null ? sourceCd.hashCode() : 0);
        result = 31 * result + (ratingCd != null ? ratingCd.hashCode() : 0);
        result = 31 * result + (displayValue != null ? displayValue.hashCode() : 0);
        result = 31 * result + (brandCd != null ? brandCd.hashCode() : 0);
        result = 31 * result + (preferredSpokenLanguageCd != null ? preferredSpokenLanguageCd.hashCode() : 0);
        result = 31 * result + (preferredWrittenLanguageCd != null ? preferredWrittenLanguageCd.hashCode() : 0);
        result = 31 * result + (preferredContactMethod != null ? preferredContactMethod.hashCode() : 0);
        result = 31 * result + (paperless != null ? paperless.hashCode() : 0);
        result = 31 * result + (segments != null ? segments.hashCode() : 0);
        result = 31 * result + (registeredOnline != null ? registeredOnline.hashCode() : 0);
        result = 31 * result + (archived != null ? archived.hashCode() : 0);
        result = 31 * result + (individualDetails != null ? individualDetails.hashCode() : 0);
        result = 31 * result + (businessDetails != null ? businessDetails.hashCode() : 0);
        result = 31 * result + (addresses != null ? addresses.hashCode() : 0);
        result = 31 * result + (chats != null ? chats.hashCode() : 0);
        result = 31 * result + (emails != null ? emails.hashCode() : 0);
        result = 31 * result + (phones != null ? phones.hashCode() : 0);
        result = 31 * result + (socialNets != null ? socialNets.hashCode() : 0);
        result = 31 * result + (webAddresses != null ? webAddresses.hashCode() : 0);
        result = 31 * result + (agencies != null ? agencies.hashCode() : 0);
        result = 31 * result + (indCustomerAdditionalNames != null ? indCustomerAdditionalNames.hashCode() : 0);
        result = 31 * result + (businessCustomerAdditionalNames != null ? businessCustomerAdditionalNames.hashCode() : 0);
        result = 31 * result + (customerEmployments != null ? customerEmployments.hashCode() : 0);
        result = 31 * result + (genericRelationships != null ? genericRelationships.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNumber(Excluded from equals)='" + customerNumber + '\'' +
                ", customerType='" + customerType + '\'' +
                ", customerStatus='" + customerStatus + '\'' +
                ", sourceCd='" + sourceCd + '\'' +
                ", ratingCd='" + ratingCd + '\'' +
                ", displayValue='" + displayValue + '\'' +
                ", brandCd='" + brandCd + '\'' +
                ", preferredSpokenLanguageCd='" + preferredSpokenLanguageCd + '\'' +
                ", preferredWrittenLanguageCd='" + preferredWrittenLanguageCd + '\'' +
                ", preferredContactMethod='" + preferredContactMethod + '\'' +
                ", paperless='" + paperless + '\'' +
                ", segments=" + segments +
                ", registeredOnline='" + registeredOnline + '\'' +
                ", archived='" + archived + '\'' +
                ", individualDetails=" + individualDetails +
                ", businessDetails=" + businessDetails +
                ", addresses=" + addresses +
                ", chats=" + chats +
                ", emails=" + emails +
                ", phones=" + phones +
                ", socialNets=" + socialNets +
                ", webAddresses=" + webAddresses +
                ", agencies=" + agencies +
                ", indCustomerAdditionalNames=" + indCustomerAdditionalNames +
                ", businessCustomerAdditionalNames=" + businessCustomerAdditionalNames +
                ", customerEmployments='" + customerEmployments + '\'' +
                ", genericRelationships=" + genericRelationships +
                '}';
    }

    public String getPreferredContactMethod() {
        return preferredContactMethod;
    }

    public void setPreferredContactMethod(String preferredContactMethod) {
        this.preferredContactMethod = preferredContactMethod;
    }
}