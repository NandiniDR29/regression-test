package com.exigen.ren.rest.claim;

import com.exigen.ipb.eisa.ws.rest.RestClient;
import com.exigen.ipb.eisa.ws.rest.conf.client.ConfigurationFactory;
import com.exigen.ipb.eisa.ws.rest.conf.client.JsonConfiguration;
import com.exigen.ipb.eisa.ws.rest.conf.metadata.InlineRequestContext;
import com.exigen.istf.data.TestData;
import com.exigen.ren.common.EntityService;
import com.exigen.ren.rest.ResponseContainer;
import com.exigen.ren.rest.claim.model.payments.PaymentModel;
import com.exigen.ren.rest.claim.model.recoveries.RecoveryModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class ClaimRENCoreRestService implements EntityService {

    private RestClient client;
    private JsonConfiguration conf;

    public ClaimRENCoreRestService() {
        conf = ConfigurationFactory.get(JsonConfiguration.class);
        conf.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        conf.getObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        client = new RestClient("ren-claims-rs", conf);
    }

    public ResponseContainer<List<RecoveryModel>> getRENClaimRecoveries(String claimNumber, String recoveryStatus, String checkNumber,
                                                                        String recoveryIssueDateFrom, String recoveryIssueDateTill,
                                                                        String sort, String offset, String limit) {
        return new ResponseContainer<>(client.processRequest("REN.CLAIMS.RECOVERIES", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().queryParam("claimNumber", claimNumber)
                        .queryParam("recoveryStatus", recoveryStatus)
                        .queryParam("checkNumber", checkNumber)
                        .queryParam("recoveryIssueDateFrom", recoveryIssueDateFrom)
                        .queryParam("recoveryIssueDateTill", recoveryIssueDateTill)
                        .queryParam("sort", sort)
                        .queryParam("offset", offset)
                        .queryParam("limit", limit).build()),
                new GenericType<List<RecoveryModel>>(){});
    }

    public ResponseContainer<List<PaymentModel>> getRENClaimPayments(String claimNumber, String paymentStatus, String checkNumber,
                                                                     String paymentIssueDateFrom, String paymentIssueDateTill,
                                                                     String sort, String offset, String limit) {
        return new ResponseContainer<>(client.processRequest("REN.CLAIMS.PAYMENTS", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().queryParam("claimNumber", claimNumber)
                        .queryParam("paymentStatus", paymentStatus)
                        .queryParam("checkNumber", checkNumber)
                        .queryParam("paymentIssueDateFrom", paymentIssueDateFrom)
                        .queryParam("paymentIssueDateTill", paymentIssueDateTill)
                        .queryParam("sort", sort)
                        .queryParam("offset", offset)
                        .queryParam("limit", limit).build()),
                new GenericType<List<PaymentModel>>(){});
    }

    @Override
    public TestData defaultTestData() {
        throw new UnsupportedOperationException("Not supported");
    }

}
