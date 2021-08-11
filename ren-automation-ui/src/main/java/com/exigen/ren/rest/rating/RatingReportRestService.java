package com.exigen.ren.rest.rating;

import com.exigen.ipb.eisa.ws.rest.RestClient;
import com.exigen.ipb.eisa.ws.rest.conf.client.ConfigurationFactory;
import com.exigen.ipb.eisa.ws.rest.conf.client.JsonConfiguration;
import com.exigen.ipb.eisa.ws.rest.conf.metadata.InlineRequestContext;
import com.exigen.ren.rest.ResponseContainer;
import com.exigen.ren.rest.rating.model.gb_dn.RatingReportDentalModel;
import com.exigen.ren.rest.rating.model.gb_vs.RatingReportVisionModel;
import com.fasterxml.jackson.databind.DeserializationFeature;

import javax.ws.rs.core.GenericType;

public class RatingReportRestService {

    private RestClient client;
    private JsonConfiguration conf;

    public RatingReportRestService() {
        conf = ConfigurationFactory.get(JsonConfiguration.class);
        conf.getObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        client = new RestClient("ren-rating-rs", conf);
    }

    public ResponseContainer<RatingReportVisionModel> getVisionRatingReport(String policyId) {
        return new ResponseContainer<>(client.processRequest("GBVISION.REPORT", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().pathParam("policyId", policyId).build()), new GenericType<RatingReportVisionModel>(){});
    }

    public ResponseContainer<RatingReportDentalModel> getDentalRatingReport(String policyId) {
        return new ResponseContainer<>(client.processRequest("GBDENTAL.REPORT", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder().pathParam("policyId", policyId).build()), new GenericType<RatingReportDentalModel>(){});
    }
}
