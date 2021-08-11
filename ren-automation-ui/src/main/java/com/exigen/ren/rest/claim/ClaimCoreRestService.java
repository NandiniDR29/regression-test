/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.claim;

import com.exigen.ipb.eisa.ws.rest.RestClient;
import com.exigen.ipb.eisa.ws.rest.conf.client.ConfigurationFactory;
import com.exigen.ipb.eisa.ws.rest.conf.client.JsonConfiguration;
import com.exigen.ipb.eisa.ws.rest.conf.metadata.InlineRequestContext;
import com.exigen.ipb.eisa.ws.rest.util.RestUtil;
import com.exigen.istf.data.TestData;
import com.exigen.ren.common.EntityService;
import com.exigen.ren.rest.ResponseContainer;
import com.exigen.ren.rest.claim.model.claimintaketask.ClaimIntakeTaskModel;
import com.exigen.ren.rest.claim.model.common.claimbody.ClaimBodyModel;
import com.exigen.ren.rest.claim.model.common.claimbody.damages.DamageFeatureModel;
import com.exigen.ren.rest.claim.model.common.fnol.FNOLResponseModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;

import javax.ws.rs.core.GenericType;
import java.util.Arrays;
import java.util.List;

public class ClaimCoreRestService  implements EntityService {

    private RestClient client;
    private JsonConfiguration conf;

    public ClaimCoreRestService() {
        conf = ConfigurationFactory.get(JsonConfiguration.class);
        conf.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        conf.getObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        client = new RestClient("claims-rs", conf);
    }

    public List<String> getFinanceSubledgerByClaimNumber(String claimNumber) {
        return Arrays.asList(new ResponseContainer<>(client.processRequest("FINANCIAL.REP.SUBLEDGER.CLAIM",
                RestClient.HttpMethod.GET, null, InlineRequestContext.builder()
                        .pathParam("claimNumber", claimNumber).build()), String.class)
                .getResponse().readEntity(String.class).split("\\n"));
    }

    public ResponseContainer<FNOLResponseModel> postClaimFNOL(TestData data) {
        return new ResponseContainer<>(client.processRequest("CLAIMS.FNOL", RestClient.HttpMethod.POST,
                RestUtil.convert(data, ClaimBodyModel.class, conf)),
                FNOLResponseModel.class);
    }

    public ResponseContainer<ClaimBodyModel> getClaimImage(String claimNumber) {
        return new ResponseContainer<>(client.processRequest("CLAIMS.IMAGE", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().pathParam("claimNumber", claimNumber).build()),
                ClaimBodyModel.class);
    }

    public ResponseContainer<ClaimIntakeTaskModel> createClaimIntakeTask(String clearingHouseId, String transmissionId, String predeterminationNumber) {
        return new ResponseContainer<>(client.processRequest("CLAIMS.INTAKE.TASK", RestClient.HttpMethod.POST, null,
                InlineRequestContext.builder().queryParam("clearingHouseId", clearingHouseId)
                        .queryParam("transmissionId", transmissionId)
                        .queryParam("predeterminationNumber", predeterminationNumber).build()),
                ClaimIntakeTaskModel.class);
    }

    public ResponseContainer<List<DamageFeatureModel>> getClaimFeatures(String claimNumber) {
        return new ResponseContainer<>(client.processRequest("CLAIMS.FEATURES", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().pathParam("claimNumber", claimNumber).build()),
                new GenericType<List<DamageFeatureModel>>(){});
    }

    @Override
    public TestData defaultTestData() {
        throw new UnsupportedOperationException("Not supported");
    }
}
