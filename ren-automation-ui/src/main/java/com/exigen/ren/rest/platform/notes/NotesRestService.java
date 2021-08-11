/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.platform.notes;

import com.exigen.ipb.eisa.base.application.impl.users.User;
import com.exigen.ipb.eisa.ws.rest.RestClient;
import com.exigen.ipb.eisa.ws.rest.conf.client.ConfigurationFactory;
import com.exigen.ipb.eisa.ws.rest.conf.client.JsonConfiguration;
import com.exigen.ipb.eisa.ws.rest.conf.metadata.InlineRequestContext;
import com.exigen.ipb.eisa.ws.rest.conf.metadata.TestDataRequestContext;
import com.exigen.ipb.eisa.ws.rest.util.RestUtil;
import com.exigen.istf.data.TestData;
import com.exigen.ren.rest.ResponseContainer;
import com.exigen.ren.rest.platform.notes.model.NoteModel;
import com.exigen.ren.rest.platform.notes.model.NotesCategoriesResponseModel;
import com.exigen.ren.rest.platform.notes.model.NotesResponseModel;
import com.fasterxml.jackson.databind.DeserializationFeature;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class NotesRestService {

    private RestClient client;
    private JsonConfiguration conf;

    public NotesRestService() {
        conf = ConfigurationFactory.get(JsonConfiguration.class);
        conf.getObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        client = new RestClient("notes-rs", conf);
    }

    public ResponseContainer<NotesResponseModel> postNotes(TestData data, User user) {
        return new ResponseContainer<>(client.processRequest("NOTES", RestClient.HttpMethod.POST,
                RestUtil.convert(data, NotesResponseModel.class, conf), InlineRequestContext.builder().user(user).build()), NotesResponseModel.class);
    }

    public List<NotesResponseModel> getNotesByTypeAndRefItem(String entityType, String entityRefNo) {
        return client.processRequest("NOTESBYTYPEANDREF.ITEM", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder()
                        .pathParam("entityType", entityType)
                        .pathParam("entityRefNo", entityRefNo).build())
                .readEntity(new GenericType<List<NotesResponseModel>>() {
                });
    }

    public List<NotesResponseModel> getNotesByTypeAndRefItem(TestData data) {
        return client.processRequest("NOTESBYTYPEANDREF.ITEM", RestClient.HttpMethod.GET, null,
                TestDataRequestContext.of(data)).readEntity(new GenericType<List<NotesResponseModel>>() {
        });
    }

    public List<NotesResponseModel> getNotesByTypeAndRefItem(String entityType, String entityRefNo, User user) {
        return client.processRequest("NOTESBYTYPEANDREF.ITEM", RestClient.HttpMethod.GET, null,
                InlineRequestContext.builder()
                        .pathParam("entityType", entityType)
                        .pathParam("entityRefNo", entityRefNo)
                        .user(user).build())
                .readEntity(new GenericType<List<NotesResponseModel>>() {
                });
    }

    public NotesResponseModel getNotesItem(String noteId) {
        return client.processRequest("NOTESBYTYPE.ITEM", RestClient.HttpMethod.GET,
                null, InlineRequestContext.builder()
                        .pathParam("noteId", noteId).build())
                .readEntity(NotesResponseModel.class);
    }

    public NotesResponseModel deleteNotesItem(String noteId, User user) {
        return client.processRequest("NOTESBYTYPE.ITEM", RestClient.HttpMethod.DELETE,
                null, InlineRequestContext.builder().user(user).pathParam("noteId", noteId).build()).readEntity(NotesResponseModel.class);
    }

    public NotesResponseModel getNotesItem(String noteId, User user) {
        return client.processRequest("NOTESBYTYPE.ITEM", RestClient.HttpMethod.GET,
                null, InlineRequestContext.builder()
                        .pathParam("noteId", noteId)
                        .user(user).build())
                .readEntity(NotesResponseModel.class);
    }

    /**
     * <b>Target:</b> /notes/{noteId}
     */
    public ResponseContainer<NotesResponseModel> putNotesItem(String noteId, TestData data, User user) {
        return new ResponseContainer<>(client.processRequest("NOTESBYTYPE.ITEM", RestClient.HttpMethod.PUT,
                RestUtil.convert(data, NotesResponseModel.class, conf), InlineRequestContext.builder()
                        .pathParam("noteId", noteId).user(user).build()), NotesResponseModel.class);
    }

    public NotesResponseModel putNotesItem(String noteId, TestData data) {
        return client.processRequest("NOTESBYTYPE.ITEM", RestClient.HttpMethod.PUT,
                RestUtil.convert(data, NoteModel.class),
                InlineRequestContext.builder().pathParam("noteId", noteId).build())
                .readEntity(NotesResponseModel.class);
    }

    public List<NotesCategoriesResponseModel> getNotesCategoriesItem(String entityType, User user){
        return client.processRequest("NOTES.CATEGORIES", RestClient.HttpMethod.GET,
                null,InlineRequestContext.builder()
                        .pathParam("entityType", entityType)
                        .user(new User(user.getLogin(),user.getPassword())).build())
                .readEntity(new GenericType<List<NotesCategoriesResponseModel>>(){});
    }

}
