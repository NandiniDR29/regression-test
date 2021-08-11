/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.platform.providers;

import com.exigen.ipb.eisa.ws.rest.RestClient;
import com.exigen.ipb.eisa.ws.rest.conf.client.ConfigurationFactory;
import com.exigen.ipb.eisa.ws.rest.conf.client.JsonConfiguration;
import com.exigen.ipb.eisa.ws.rest.conf.metadata.InlineRequestContext;
import com.exigen.ipb.eisa.ws.rest.conf.metadata.TestDataRequestContext;
import com.exigen.ipb.eisa.ws.rest.util.RestUtil;
import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.common.EntityService;
import com.exigen.ren.rest.ResponseContainer;
import com.exigen.ren.rest.platform.providers.model.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

public class ProviderRestService implements EntityService {
    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/platform/providers");

    private RestClient clientThirdParty;
    private RestClient clientClaims;
    private JsonConfiguration conf;

    public ProviderRestService() {
        conf = ConfigurationFactory.get(JsonConfiguration.class);
        conf.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        conf.getObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        clientThirdParty = new RestClient("thirdparty-rs", conf);
        clientClaims = new RestClient("claims-rs", conf);
    }

    public ResponseContainer<ProviderModel> postProvider(TestData data) {
        return new ResponseContainer<>(clientThirdParty.processRequest("VENDORS", RestClient.HttpMethod.POST,
                RestUtil.convert(data, ProviderModel.class, conf)), ProviderModel.class);
    }

    public ResponseContainer<ProviderModel> postProviderVersion(TestData data) {
        return new ResponseContainer<>(clientThirdParty.processRequest("VENDORS.VERSION", RestClient.HttpMethod.POST,
                RestUtil.convert(data, ProviderModel.class, conf)), ProviderModel.class);
    }

    public ResponseContainer<ServiceFeeScheduleModel> postFeeScheduleVersion(TestData data) {
        return new ResponseContainer<>(clientClaims.processRequest("FEE.SCHEDULE.VERSION", RestClient.HttpMethod.POST,
                RestUtil.convert(data, ServiceFeeScheduleModel.class, conf)), ServiceFeeScheduleModel.class);
    }

    public List<ServiceFeeScheduleModel> getFeeScheduleVersion(String param, String value) {
        return clientClaims.processRequest("GET.FEE.SCHEDULE.VERSION.INFO",
                RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().queryParam(param, value).build()).
                readEntity(new GenericType<List<ServiceFeeScheduleModel>>() {
                });
    }

    public List<ServiceFeeScheduleModel> getFeeScheduleVersions(Map<String, String> searchValues) {
        return clientClaims.processRequest("GET.FEE.SCHEDULE.VERSION.INFO",
                RestClient.HttpMethod.GET, null, InlineRequestContext.builder()
                        .queryParams(searchValues).build())
                .readEntity(new GenericType<List<ServiceFeeScheduleModel>>() {
                });
    }

    public List<ServiceProviderModel> getServiceProviders(Map<String, String> searchValues) {
        return clientClaims.processRequest("VENDORS.SERVICE.PROVIDERS.SEARCH",
                RestClient.HttpMethod.GET, null, InlineRequestContext.builder()
                        .queryParams(searchValues).build())
                .readEntity(new GenericType<List<ServiceProviderModel>>() {
                });
    }

    public ResponseContainer<ProviderModel> putIdentity(String vendorOID, TestData data) {
        return new ResponseContainer<>(clientClaims.processRequest("VENDORS.IDENTITY-UPDATE", RestClient.HttpMethod.PUT,
                data, InlineRequestContext.builder().pathParam("vendorOID", vendorOID).build()), ProviderModel.class);
    }

    public ResponseContainer<FacilityModel> postFacility(TestData data) {
        return new ResponseContainer<>(clientClaims.processRequest("VENDORS.FACILITIES", RestClient.HttpMethod.POST,
                RestUtil.convert(data, FacilityModel.class, conf)), FacilityModel.class);
    }

    public List<FacilityModel> getFacilities() {
        return clientClaims.processRequest("GET.FACILITIES", RestClient.HttpMethod.GET, null).
                readEntity(new GenericType<List<FacilityModel>>() {
                });
    }

    public List<AssignmentInfoModel> getServiceProviderFacilitiesInfoFacilityByParam(String param, String value) {
        return clientClaims.processRequest("GET.SERVICE-PROVIDER-FACILITIES-INFO",
                RestClient.HttpMethod.GET, null, InlineRequestContext.builder()
                        .queryParam(param, value).build())
                .readEntity(new GenericType<List<AssignmentInfoModel>>() {
                });
    }

    public List<AssignmentInfoModel> getServiceProviderFacilitiesInfoFacilityByParams(Map<String, String> searchValues) {
        return clientClaims.processRequest("GET.SERVICE-PROVIDER-FACILITIES-INFO",
                RestClient.HttpMethod.GET, null, InlineRequestContext.builder()
                        .queryParams(searchValues).build())
                .readEntity(new GenericType<List<AssignmentInfoModel>>() {
                });
    }

    public List<AssignmentInfoModel> getServiceAgentAssignmentsInfoFacilityByParam(String param, String value) {
        return clientClaims.processRequest("GET.SERVICE-AGENT-ASSIGNMENTS-INFO",
                RestClient.HttpMethod.GET, null, InlineRequestContext.builder()
                        .queryParam(param, value).build())
                .readEntity(new GenericType<List<AssignmentInfoModel>>() {
                });
    }

    public List<AssignmentInfoModel> getServiceAgentAssignmentsInfoFacilityByParams(Map<String, String> params) {
        return clientClaims.processRequest("GET.SERVICE-AGENT-ASSIGNMENTS-INFO",
                RestClient.HttpMethod.GET, null, InlineRequestContext.builder()
                        .queryParams(params).build())
                .readEntity(new GenericType<List<AssignmentInfoModel>>() {
                });
    }

    public ResponseContainer<FacilityModel> postFacility(FacilityModel facilityModel) {
        return new ResponseContainer<>(clientClaims.processRequest("VENDORS.FACILITIES", RestClient.HttpMethod.POST,
                facilityModel), FacilityModel.class);
    }

    public ResponseContainer<AssignmentModel> postIndAssignment(TestData data) {
        return new ResponseContainer<>(clientClaims.processRequest("VENDORS.INDIVIDUAL.ASSIGNMENT", RestClient.HttpMethod.POST,
                RestUtil.convert(data, AssignmentModel.class, conf)), AssignmentModel.class);
    }

    public ResponseContainer<AssignmentModel> postNonIndAssignment(TestData data) {
        return new ResponseContainer<>(clientClaims.processRequest("VENDORS.NONINDIVIDUAL.ASSIGNMENT", RestClient.HttpMethod.POST,
                RestUtil.convert(data, AssignmentModel.class, conf)), AssignmentModel.class);
    }

    public ResponseContainer<AssignmentModel> postNonIndAssignment(AssignmentModel assignmentModel) {
        return new ResponseContainer<>(clientClaims.processRequest("VENDORS.NONINDIVIDUAL.ASSIGNMENT", RestClient.HttpMethod.POST,
                assignmentModel), AssignmentModel.class);
    }

    public ResponseContainer<FacilityModel> postFacilityVersion(TestData data) {
        return new ResponseContainer<>(clientClaims.processRequest("VENDORS.FACILITIES.VERSION", RestClient.HttpMethod.POST,
                RestUtil.convert(data, FacilityModel.class, conf)), FacilityModel.class);
    }

    public ResponseContainer<FinancialInfoModel> postFinancialInfo(TestData data) {
        return new ResponseContainer<>(clientClaims.processRequest("VENDORS.FINANCIAL", RestClient.HttpMethod.POST,
                RestUtil.convert(data, FinancialInfoModel.class, conf)), FinancialInfoModel.class);
    }

    public ResponseContainer<FinancialInfoModel> postFinancialInfoVersion(TestData data) {
        return new ResponseContainer<>(clientClaims.processRequest("VENDORS.FINANCIAL.VERSION", RestClient.HttpMethod.POST,
                RestUtil.convert(data, FinancialInfoModel.class, conf)), FinancialInfoModel.class);
    }

    public ResponseContainer<ServiceAgentAssignmentModel> postServiceAgentAssignment(TestData data) {
        return new ResponseContainer<>(clientClaims.processRequest("SERVICE.AGENT.ASSIGNMENT", RestClient.HttpMethod.POST,
                RestUtil.convert(data, ServiceAgentAssignmentModel.class, conf)), ServiceAgentAssignmentModel.class);
    }

    public List<ServiceAgentAssignmentModel> getServiceAgentAssignment(Map<String, String> searchValues) {

        return clientThirdParty.processRequest("SERVICE.AGENT.ASSIGNMENT.INFO",
                RestClient.HttpMethod.GET, null, InlineRequestContext.builder()
                        .queryParams(searchValues).build())
                .readEntity(new GenericType<List<ServiceAgentAssignmentModel>>() {
                });
    }

    public ServiceAgentAssignmentModel postServiceAgentAssignment(ServiceAgentAssignmentModel serviceAgentAssignmentModel) {
        return clientClaims.processRequest("SERVICE.AGENT.ASSIGNMENT", RestClient.HttpMethod.POST, serviceAgentAssignmentModel)
                .readEntity(ServiceAgentAssignmentModel.class);
    }

    public ResponseContainer<List<ServiceAgentAssignmentsModel>> getServiceAgentAssignments(TestData data) {
        return new ResponseContainer<>(clientThirdParty.processRequest("SERVICE.AGENT.ASSIGNMENT", RestClient.HttpMethod.GET, null,
                TestDataRequestContext.of(data)), new GenericType<List<ServiceAgentAssignmentsModel>>() {
        });
    }

    public Response getServiceAgentAssignment(TestData data) {
        return clientThirdParty.processRequest("SERVICE.AGENT.ASSIGNMENT", RestClient.HttpMethod.GET, null,
                TestDataRequestContext.of(data));
    }

    public List<ProviderModel> getProviders(Map<String, String> searchValues) {

        return clientThirdParty.processRequest("VENDORS",
                RestClient.HttpMethod.GET, null, InlineRequestContext.builder()
                        .queryParams(searchValues).build())
                .readEntity(new GenericType<List<ProviderModel>>() {
                });
    }

    public List<FacilityModel> getFacilities(String param, String value) {
        return clientClaims.processRequest("GET.FACILITIES", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().queryParam(param, value).build()).
                readEntity(new GenericType<List<FacilityModel>>() {
                });
    }

    public List<FacilityModel> getFacilities(Map<String, String> searchValues) {
        return clientClaims.processRequest("GET.FACILITIES", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().queryParams(searchValues).build()).
                readEntity(new GenericType<List<FacilityModel>>() {
                });
    }

    public List<AssignmentInfoModel> getServiceProviderFacilitiesInfo() {
        return clientClaims.processRequest("GET.SERVICE-PROVIDER-FACILITIES-INFO",
                RestClient.HttpMethod.GET, null)
                .readEntity(new GenericType<List<AssignmentInfoModel>>() {
                });
    }

    public List<FinancialInfoModel> getFinancialInfo(Map<String, String> searchValues) {
        return clientClaims.processRequest("GET.VENDORS.FINANCIAL", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().queryParams(searchValues).build())
                .readEntity(new GenericType<List<FinancialInfoModel>>() {
                });
    }

    public ResponseContainer<ServiceNetWorkModel> postServiceNetwork(TestData data) {
        return new ResponseContainer<>(clientClaims.processRequest("FEE.SERVICE.NETWORK", RestClient.HttpMethod.POST,
                RestUtil.convert(data, ServiceNetWorkModel.class, conf)), ServiceNetWorkModel.class);
    }

    public ResponseContainer<ServiceFeeSchedulesModel> postServiceFeeSchedules(TestData data) {
        return new ResponseContainer<>(clientClaims.processRequest("FEE.SERVICE.SCHEDULES", RestClient.HttpMethod.POST,
                RestUtil.convert(data, ServiceFeeSchedulesModel.class, conf)), ServiceFeeSchedulesModel.class);
    }

    public Response postNetworkJoinAgreements(TestData data) {
        return clientClaims.processRequest("FEE.NETWORK.JOIN.AGREEMENTS", RestClient.HttpMethod.POST,
                RestUtil.convert(data, FeeAgreementsModel.class, conf));
    }

    public ResponseContainer<NetworkJoinAgreementModel> postNetworkJoinAgreement(TestData data) {
        return new ResponseContainer<>(clientClaims.processRequest("FEE.NETWORK.JOIN.AGREEMENT", RestClient.HttpMethod.POST,
                RestUtil.convert(data, NetworkJoinAgreementModel.class, conf)), NetworkJoinAgreementModel.class);
    }

    public Response getNetworkJoinAgreement(Map<String, String> searchValues) {
        return clientClaims.processRequest("FEE.NETWORK.JOIN.AGREEMENT", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().queryParams(searchValues).build());
    }

    public ResponseContainer<FeeScheduleNetworkBindingModel> postFeeScheduleNetworkBinding(TestData data) {
        return new ResponseContainer<>(clientClaims.processRequest("FEE.SCHEDULE.NETWORK.BINDING", RestClient.HttpMethod.POST,
                RestUtil.convert(data, FeeScheduleNetworkBindingModel.class, conf)), FeeScheduleNetworkBindingModel.class);
    }

    public ResponseContainer<List<ZipApplicabilityRulesModel>> postZipApplicabilityRules(TestData data) {
        return new ResponseContainer<>(clientClaims.processRequest("ZIP.APPLICABILITY.RULES", RestClient.HttpMethod.POST,
                RestUtil.convert(data, ZipApplicabilityRulesModel.class, conf)), new GenericType<List<ZipApplicabilityRulesModel>>() {
        });
    }

    public ResponseContainer<List<OutOfNetWorkFeeRatesInfoModel>> getOutOfNetWorkFeeRatesInfo(Map<String, String> searchValues) {
        return new ResponseContainer<>(clientClaims.processRequest("OUT.FEE.RATES.INFO", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().queryParams(searchValues).build()), new GenericType<List<OutOfNetWorkFeeRatesInfoModel>>() {
        });
    }

    public ResponseContainer<List<AgreementInfoModel>> getNetworkJoinAgreementInfo(Map<String, String> searchValues) {
        return new ResponseContainer<>(clientClaims.processRequest("FEE.NETWORK.JOIN.AGREEMENT", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().queryParams(searchValues).build()), new GenericType<List<AgreementInfoModel>>() {
        });
    }

    public Response postServiceFeeAgreements(TestData data) {
        return clientClaims.processRequest("FEE.SERVICE.AGREEMENTS", RestClient.HttpMethod.POST,
                RestUtil.convert(data, FeeAgreementsModel.class, conf));
    }

    public ResponseContainer<ServiceFeeAgreementModel> postServiceFeeAgreement(TestData data) {
        return new ResponseContainer<>(clientClaims.processRequest("FEE.SERVICE.AGREEMENT", RestClient.HttpMethod.POST,
                RestUtil.convert(data, ServiceFeeAgreementModel.class, conf)), ServiceFeeAgreementModel.class);
    }

    public Response getServiceFeeAgreement(Map<String, String> searchValues) {
        return clientClaims.processRequest("FEE.SERVICE.AGREEMENT", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().queryParams(searchValues).build());
    }

    public ResponseContainer<List<AgreementInfoModel>> getServiceFeeAgreementInfo(Map<String, String> searchValues) {
        return new ResponseContainer<>(clientClaims.processRequest("FEE.SERVICE.AGREEMENT", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().queryParams(searchValues).build()), new GenericType<List<AgreementInfoModel>>() {
        });
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }
}
