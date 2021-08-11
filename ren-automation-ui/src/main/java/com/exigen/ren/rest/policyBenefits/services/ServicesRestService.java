package com.exigen.ren.rest.policyBenefits.services;

import com.exigen.ipb.eisa.ws.rest.RestClient;
import com.exigen.ipb.eisa.ws.rest.conf.client.ConfigurationFactory;
import com.exigen.ipb.eisa.ws.rest.conf.client.JsonConfiguration;
import com.exigen.ipb.eisa.ws.rest.conf.metadata.InlineRequestContext;
import com.exigen.ren.rest.ResponseContainer;
import com.exigen.ren.rest.policyBenefits.services.models.UpdateSalaryResponseModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;

import javax.ws.rs.core.GenericType;

public class ServicesRestService {

    private RestClient client;
    private JsonConfiguration configuration;

    public ServicesRestService() {
        configuration = ConfigurationFactory.get(JsonConfiguration.class);
        configuration.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        configuration.getObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        client = new RestClient("ren-policy-group-rs", configuration);
    }

    public ResponseContainer<UpdateSalaryResponseModel> postEmployeesUpdateSalary(String insuredTaxId, String sponsorCustomerNumber,
                                                                                  String salaryAmount, String effectiveDate, String enrollmentType) {
        return new ResponseContainer<>(client.processRequest("EMPLOYEES.UPDATE.SALARY", RestClient.HttpMethod.POST, null,
                InlineRequestContext.builder()
                        .pathParam("insuredTaxId", insuredTaxId)
                        .queryParam("sponsorCustomerNumber", sponsorCustomerNumber)
                        .queryParam("salaryAmount", salaryAmount)
                        .queryParam("effectiveDate", effectiveDate)
                        .queryParam("enrollmentType", enrollmentType)
                        .build()),
                new GenericType<UpdateSalaryResponseModel>(){});
    }

}
