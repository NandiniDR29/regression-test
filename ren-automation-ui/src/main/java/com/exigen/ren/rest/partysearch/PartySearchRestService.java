/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.partysearch;

import com.exigen.ipb.eisa.base.application.impl.users.User;
import com.exigen.ipb.eisa.ws.rest.RestClient;
import com.exigen.ipb.eisa.ws.rest.conf.client.ConfigurationFactory;
import com.exigen.ipb.eisa.ws.rest.conf.client.JsonConfiguration;
import com.exigen.ipb.eisa.ws.rest.conf.metadata.TestDataRequestContext;
import com.exigen.ipb.eisa.ws.rest.util.RestUtil;
import com.exigen.istf.data.TestData;
import com.exigen.ren.rest.ResponseContainer;
import com.exigen.ren.rest.partysearch.model.*;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

public class PartySearchRestService {
    private RestClient client = new RestClient("party-rs", ConfigurationFactory.get(JsonConfiguration.class));

    public List<Party> getParties(TestData data, User user) {
        return client.processRequest("PARTIES", RestClient.HttpMethod.GET, null,
                TestDataRequestContext.of(data, user))
                .readEntity(new GenericType<List<Party>>() {
                });
    }

    public Response postParties(TestData data) {
        return client.processRequest("PARTIES", RestClient.HttpMethod.POST,
                RestUtil.convert(data,PartyModel.class));
    }

    public ResponseContainer<List<PartiesIndividualsModel>> getPartiesIndividuals(TestData data) {
        return new ResponseContainer<>(client.processRequest("PARTIES.INDIVIDUALS", RestClient.HttpMethod.GET, null,
                TestDataRequestContext.of(data)), new GenericType<List<PartiesIndividualsModel>>() {
        });
    }

    public ResponseContainer<List<PartiesNonIndividualsModel>> getPartiesNonIndividuals(TestData data) {
        return new ResponseContainer<>(client.processRequest("PARTIES.NONINDIVIDUALS", RestClient.HttpMethod.GET, null,
                TestDataRequestContext.of(data)), new GenericType<List<PartiesNonIndividualsModel>>() {
        });
    }

    public ResponseContainer<List<PartiesLocationsModel>> getPartiesLocations(TestData data) {
        return new ResponseContainer<>(client.processRequest("PARTIES.LOCATIONS", RestClient.HttpMethod.GET, null,
                TestDataRequestContext.of(data)), new GenericType<List<PartiesLocationsModel>>() {
        });
    }

    public ResponseContainer<List<PartiesVehiclesModel>> getPartiesVehicles(TestData data) {
        return new ResponseContainer<>(client.processRequest("PARTIES.VEHICLES", RestClient.HttpMethod.GET, null,
                TestDataRequestContext.of(data)), new GenericType<List<PartiesVehiclesModel>>() {
        });
    }


    public ResponseContainer<List<PartiesIndividualsModel>> getPartiesTypePerson(TestData data) {
        return new ResponseContainer<>(client.processRequest("PARTIES", RestClient.HttpMethod.GET, null,
                TestDataRequestContext.of(setPartyType(data,"PersonParty"))), new GenericType<List<PartiesIndividualsModel>>() {
        });
    }

    public ResponseContainer<List<PartiesNonIndividualsModel>> getPartiesTypeNonPerson(TestData data) {
        return new ResponseContainer<>(client.processRequest("PARTIES", RestClient.HttpMethod.GET, null,
                TestDataRequestContext.of(setPartyType(data,"NonPersonParty"))), new GenericType<List<PartiesNonIndividualsModel>>() {
        });
    }

    public ResponseContainer<List<PartiesLocationsModel>> getPartiesTypeLocation(TestData data) {
        return new ResponseContainer<>(client.processRequest("PARTIES", RestClient.HttpMethod.GET, null,
                TestDataRequestContext.of(setPartyType(data,"LocationParty"))), new GenericType<List<PartiesLocationsModel>>() {
        });
    }

    public ResponseContainer<List<PartiesVehiclesModel>> getPartiesTypeVehicle(TestData data) {
        return new ResponseContainer<>(client.processRequest("PARTIES", RestClient.HttpMethod.GET, null,
                TestDataRequestContext.of(setPartyType(data,"VehicleParty"))), new GenericType<List<PartiesVehiclesModel>>() {
        });
    }

    private TestData setPartyType(TestData data,String partyType){
        return data.adjust(TestData.makeKeyPath("query", "partyType"), partyType);
    }
}