/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.platform.bpm;

import com.exigen.ipb.eisa.base.application.impl.users.User;
import com.exigen.ipb.eisa.ws.rest.RestClient;
import com.exigen.ipb.eisa.ws.rest.RestClient.HttpMethod;
import com.exigen.ipb.eisa.ws.rest.conf.client.ConfigurationFactory;
import com.exigen.ipb.eisa.ws.rest.conf.client.JsonConfiguration;
import com.exigen.ipb.eisa.ws.rest.conf.metadata.InlineRequestContext;
import com.exigen.ipb.eisa.ws.rest.conf.metadata.TestDataRequestContext;
import com.exigen.ipb.eisa.ws.rest.entity.FreemarkerEntity;
import com.exigen.ipb.eisa.ws.rest.util.RestUtil;
import com.exigen.istf.data.DataProviderFactory;
import com.exigen.istf.data.TestData;
import com.exigen.ren.rest.ResponseContainer;
import com.exigen.ren.rest.model.RestError;
import com.exigen.ren.rest.platform.bpm.model.agencytransfer.AgencyTransferResponseModel;
import com.exigen.ren.rest.platform.bpm.model.tasks.*;
import com.exigen.ren.rest.platform.notes.model.NotesResponseModel;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.glassfish.jersey.client.ClientProperties;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

import static com.exigen.ipb.eisa.ws.rest.conf.metadata.TestDataRequestContext.QUERY_KEY;
import static java.util.Objects.isNull;

public class BPMRestService {
    private RestClient client;

    public BPMRestService() {
        this(null);
    }

    public BPMRestService(User user) {
        JsonConfiguration conf = isNull(user) ? ConfigurationFactory.get(JsonConfiguration.class) : ConfigurationFactory.get(JsonConfiguration.class, user);
        conf.getObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        conf.getConfig().property(ClientProperties.SUPPRESS_HTTP_COMPLIANCE_VALIDATION, true);
        client = new RestClient("bpm-rs", conf);
    }

    public List<TasksResponseModel> getTasks(TestData data) {
        return client.processRequest("TASKS", HttpMethod.GET, null,
                TestDataRequestContext.of(DataProviderFactory.emptyData().adjust(QUERY_KEY, data)))
                .readEntity(new GenericType<List<TasksResponseModel>>() {
                });
    }

    public List<TasksResponseModel> getTasks(TestData data, User user) {
        return client.processRequest("TASKS", HttpMethod.GET, null,
                TestDataRequestContext.of(DataProviderFactory.emptyData().adjust(QUERY_KEY, data), user))
                .readEntity(new GenericType<List<TasksResponseModel>>() {
                });
    }

    public Response getNamedFilters(User user) {
        return client.processRequest("NAMED.FILTERS", HttpMethod.GET, null,
                TestDataRequestContext.of(DataProviderFactory.emptyData(), user));
    }

    public List<TasksResponseModel> postTasks(TestData data) {
        return client.processRequest("TASKS", HttpMethod.POST,
                RestUtil.convert(data, TasksRequestModel.class))
                .readEntity(new GenericType<List<TasksResponseModel>>() {
                });
    }

    public List<TasksResponseModel> postTasks(TestData data, User user) {
        return client.processRequest("TASKS", HttpMethod.POST,
                RestUtil.convert(data, TasksRequestModel.class),
                InlineRequestContext.builder().user(user).build())
                .readEntity(new GenericType<List<TasksResponseModel>>() {
                });
    }

    public List<TasksResponseModel> putTask(String taskId, TestData data, User user) {
        return client.processRequest("PUTTASK", HttpMethod.PUT,
                RestUtil.convert(data, TasksRequestModel.class),
                InlineRequestContext.builder()
                        .pathParam("taskId", taskId)
                        .user(user).build())
                .readEntity(new GenericType<List<TasksResponseModel>>() {
                });
    }

    public List<TasksResponseModel> putTaskPartialValueNull(TestData data, User user, String taskId) {
        return client.processRequest("PUTTASK", HttpMethod.PUT,
                RestUtil.convert(data, TaskUpdateRequestModel.class),
                InlineRequestContext.builder()
                        .pathParam("taskId", taskId)
                        .user(user).build())
                .readEntity(new GenericType<List<TasksResponseModel>>() {
                });
    }

    public TasksResponseModel getTaskById(String taskId, User user) {
        return client.processRequest("TASKSBYID", HttpMethod.GET,
                null, InlineRequestContext.builder().pathParam("taskId", taskId).user(user).build())
                .readEntity(TasksResponseModel.class);
    }

    public TasksResponseModel getTaskCompletionById(String taskId, User user) {
        return client.processRequest("TASKCOMPLETION", HttpMethod.GET,
                null, InlineRequestContext.builder().pathParam("taskId", taskId).user(user).build())
                .readEntity(TasksResponseModel.class);
    }

    public TasksResponseModel postTaskCompletionById(String taskId, User user) {
        return client.processRequest("POSTTASKCOMPLETION", HttpMethod.POST,
                null, InlineRequestContext.builder().pathParam("taskId", taskId).user(user).build())
                .readEntity(TasksResponseModel.class);
    }

    public TasksResponseModel postTaskCompletionById(String taskId, CompletionModel completionModel) {
        return client.processRequest("POSTTASKCOMPLETION", HttpMethod.POST,
                completionModel, InlineRequestContext.builder().pathParam("taskId", taskId).build())
                .readEntity(TasksResponseModel.class);
    }

    public List<LinkDefinitionModel> getLinkDefinitionsById(String taskId) {
        return client.processRequest("LINKDEFINITION", HttpMethod.GET,
                null, InlineRequestContext.builder().pathParam("taskId", taskId).build())
                .readEntity(new GenericType<List<LinkDefinitionModel>>() {
                });
    }

    public AssignmentModel getTaskAssignmentById(String taskId, User user) {
        return client.processRequest("TASKASSIGNMENT", HttpMethod.GET,
                null, InlineRequestContext.builder().pathParam("taskId", taskId).user(user).build())
                .readEntity(AssignmentModel.class);
    }

    public List<NotesResponseModel> getTaskNotesByTaskId(String taskId, User user) {
        return client.processRequest("TASKNOTES", HttpMethod.GET,
                null, InlineRequestContext.builder().pathParam("taskId", taskId).user(user).build())
                .readEntity(new GenericType<List<NotesResponseModel>>() {
                });
    }

    public List<NotesResponseModel> getTaskNotesByTaskId(String taskId) {
        return client.processRequest("TASKNOTES", HttpMethod.GET,
                null, InlineRequestContext.builder().pathParam("taskId", taskId).build())
                .readEntity(new GenericType<List<NotesResponseModel>>() {
                });
    }

    public ResponseContainer<NotesResponseModel> postTaskNotesByTaskId(String taskId, TestData data) {
        return new ResponseContainer<>(client.processRequest("POSTTASKNOTES", HttpMethod.POST,
                RestUtil.convert(data, NotesResponseModel.class),
                InlineRequestContext.builder().pathParam("taskId", taskId).build()), NotesResponseModel.class);
    }

    public ResponseContainer<NotesResponseModel> postTaskNotesByTaskId(String taskId, TestData data, User user) {
        return new ResponseContainer<>(client.processRequest("POSTTASKNOTES", HttpMethod.POST,
                RestUtil.convert(data, NotesResponseModel.class),
                InlineRequestContext.builder().pathParam("taskId", taskId).user(user).build()), NotesResponseModel.class);
    }

    public ResponseContainer<NotesResponseModel> putTaskNotesByTaskId(TestData data, User user) {
        return new ResponseContainer<>(client.processRequest("PUTTASKNOTES", HttpMethod.PUT,
                RestUtil.convert(data, NotesResponseModel.class),
                InlineRequestContext.builder()
                        .pathParam("taskId", data.getValue("taskId"))
                        .pathParam("noteId", data.getValue("noteId"))
                        .user(user).build()
        ), NotesResponseModel.class);
    }

    public TaskAssignmentResponseModel putTaskAssignmentById(String taskId, User user) {
        return putTaskAssignmentById(taskId, null, user);
    }

    public TaskAssignmentResponseModel putTaskAssignmentById(String taskId, AssignmentModel assignmentModel) {
        return client.processRequest("PUTTASKASSIGNMENT", HttpMethod.PUT,
                assignmentModel, InlineRequestContext.builder().pathParam("taskId", taskId).build())
                .readEntity(TaskAssignmentResponseModel.class);
    }

    public TaskAssignmentResponseModel putTaskAssignmentById(String taskId, AssignmentModel assignmentModel, User user) {
        return client.processRequest("PUTTASKASSIGNMENT", HttpMethod.PUT,
                assignmentModel, InlineRequestContext.builder().pathParam("taskId", taskId).user(user).build())
                .readEntity(TaskAssignmentResponseModel.class);
    }

    public TasksResponseModel getTaskActivitiesById(String taskId, User user) {
        return getTaskActivitiesById(taskId, null, user);
    }

    public TasksResponseModel getTaskActivitiesById(String taskId, String notes, User user) {
        return client.processRequest("TASKACTIVITIES", HttpMethod.GET,
                null, InlineRequestContext.builder()
                        .pathParam("taskId", taskId)
                        .queryParam("notes", notes)
                        .user(user).build())
                .readEntity(TasksResponseModel.class);
    }

    public TasksResponseModel getTaskActionsHistory(String taskId, String actionType, String lastAction, User user) {
        return client.processRequest("TASKACTIONHISTORY", HttpMethod.GET,
                null, InlineRequestContext.builder()
                        .queryParam("taskId", taskId)
                        .queryParam("actionType", actionType)
                        .queryParam("lastAction", lastAction)
                        .user(user).build())
                .readEntity(TasksResponseModel.class);
    }

    public RestError getInbox(String offset, String limit, User user) {
        return client.processRequest("INBOX", HttpMethod.GET,
                null, InlineRequestContext.builder()
                        .queryParam("offset", offset)
                        .queryParam("limit", limit)
                        .user(user).build()).readEntity(RestError.class);
    }

    public RestError getProcDefinition(String procDefId, User user) {
        return client.processRequest("PROCDEFINITION", HttpMethod.GET,
                null, InlineRequestContext.builder()
                        .pathParam("procDefId", procDefId)
                        .user(user).build()).readEntity(RestError.class);
    }

    public RestError createWorkGroup(User user) {
        return client.processRequest("CREATEWORKGROUP", HttpMethod.POST,
                null, InlineRequestContext.builder().user(user).build()).readEntity(RestError.class);
    }

    public RestError getWorkGroup(String groupCode, User user) {
        return client.processRequest("GETWORKGROUP", HttpMethod.GET,
                null, InlineRequestContext.builder()
                        .pathParam("groupCode", groupCode)
                        .user(user).build()).readEntity(RestError.class);
    }

    public RestError deleteWorkGroup(String groupCode, User user) {
        return client.processRequest("DELETEWORKGROUP", HttpMethod.DELETE,
                null, InlineRequestContext.builder()
                        .pathParam("groupCode", groupCode)
                        .user(user).build()).readEntity(RestError.class);
    }

    public RestError updateWorkGroup(String groupCode, User user) {
        return client.processRequest("UPDATEWORKGROUP", HttpMethod.PUT,
                null, InlineRequestContext.builder()
                        .pathParam("groupCode", groupCode)
                        .user(user).build()).readEntity(RestError.class);
    }

    public RestError updloadDocument(TestData data, User user) {
        return client.processRequest("UPLOADDOCUMENT", HttpMethod.POST,
                null, TestDataRequestContext.of(data, user))
                .readEntity(RestError.class);
    }

    public RestError getProcessInstance(String pinId, User user) {
        return client.processRequest("PROCESSINSTANCE", HttpMethod.GET,
                null, InlineRequestContext.builder()
                        .pathParam("pinId", pinId)
                        .user(user).build()).readEntity(RestError.class);
    }

    public ResponseContainer<RestError> getManualTaskDefinition(String processKey, User user) {
        return new ResponseContainer<>(client.processRequest("MANUALTASKDEF", HttpMethod.GET,
                null, InlineRequestContext.builder()
                        .queryParam("processKey", processKey)
                        .user(user).build()), RestError.class);
    }

    public RestError deployManualTaskDefinition(String migration, User user) {
        return client.processRequest("MANUALTASKDEPLOY", HttpMethod.POST,
                null, InlineRequestContext.builder()
                        .pathParam("migration", migration)
                        .user(user).build()).readEntity(RestError.class);
    }

    public RestError postProcessDefinition(User user) {
        return client.processRequest("POSTPROCESSDEFINITION", HttpMethod.POST,
                null, InlineRequestContext.builder()
                        .user(user).build()).readEntity(RestError.class);
    }

    public RestError postProcessDefinitionBindEvent(User user) {
        return client.processRequest("POSTPROCESSDEFINITIONBINDEVENT", HttpMethod.POST,
                null, InlineRequestContext.builder()
                        .user(user).build()).readEntity(RestError.class);
    }

    public RestError getQueues(User user) {
        return client.processRequest("QUEUES", HttpMethod.GET,
                null, InlineRequestContext.builder()
                        .user(user).build()).readEntity(RestError.class);
    }

    public RestError deployQueues(User user) {
        return client.processRequest("QUEUESDEPLOY", HttpMethod.POST,
                null, InlineRequestContext.builder()
                        .user(user).build()).readEntity(RestError.class);
    }

    public RestError getQueuesExport(String subsystem, User user) {
        return client.processRequest("QUEUESEXPORT", HttpMethod.GET,
                null, InlineRequestContext.builder()
                        .queryParam("subsystem", subsystem)
                        .user(user).build()).readEntity(RestError.class);
    }

    public RestError getQueuesExportByFileName(String fileName, String subsystem, User user) {
        return client.processRequest("QUEUESEXPORTBYFN", HttpMethod.GET,
                null, InlineRequestContext.builder()
                        .pathParam("fileName", fileName)
                        .queryParam("subsystem", subsystem)
                        .user(user).build()).readEntity(RestError.class);
    }

    public RestError getEvents(User user) {
        return client.processRequest("EVENTS", HttpMethod.GET,
                null, InlineRequestContext.builder()
                        .user(user).build()).readEntity(RestError.class);
    }

    public RestError getUsersPermissions(User user) {
        return client.processRequest("PERMISSIONS", HttpMethod.GET,
                null, InlineRequestContext.builder()
                        .user(user).build()).readEntity(RestError.class);
    }

    public RestError postSearch(User user) {
        return client.processRequest("POSTSEARCH", HttpMethod.POST,
                null, InlineRequestContext.builder()
                        .user(user).build()).readEntity(RestError.class);
    }

    public RestError getSearch(TestData data, User user) {
        return client.processRequest("GETSEARCH", HttpMethod.GET,
                null, InlineRequestContext.builder()
                        .pathParam("lastName", data.getValue("lastName"))
                        .queryParam("firstName", data.getValue("firstName"))
                        .queryParam("location", data.getValue("location"))
                        .queryParam("availableForWork", data.getValue("availableForWork"))
                        .user(user).build()).readEntity(RestError.class);
    }


    public AgencyTransferResponseModel postAgencyTransfer(TestData data, User user) {
        return client.processRequest("AGENCYTRANSFER", HttpMethod.POST,
                RestUtil.convert(data, AgencyTransferResponseModel.class), InlineRequestContext.builder()
                        .user(user).build()).readEntity(AgencyTransferResponseModel.class);
    }

    public ResponseContainer<TasksResponseModel> postLinkedTaskBySourceTaskId(String sourceTaskId, TestData data, String subTask) {
        return new ResponseContainer<>(client.processRequest("POSTLINKEDTASK", HttpMethod.POST,
                FreemarkerEntity.from("bpm-rs/POSTLINKEDTASK.POST", data),
                InlineRequestContext.builder().pathParam("sourceTaskId", sourceTaskId).queryParam("linkTypeCd", subTask).build()), TasksResponseModel.class);
    }

    public List<TaskLinkModel> getLinksBySourceTaskId(String sourceTaskId) {
        return client.processRequest("LINKS", HttpMethod.GET,
                null,
                InlineRequestContext.builder().pathParam("sourceTaskId", sourceTaskId).build()).readEntity(new GenericType<List<TaskLinkModel>>() {
        });
    }

    public TaskLinkModel postLinksBySourceTaskId(String sourceTaskId, TaskLinkModel link) {
        return client.processRequest("LINKS", HttpMethod.POST,
                link,
                InlineRequestContext.builder().pathParam("sourceTaskId", sourceTaskId).build()).readEntity(TaskLinkModel.class);
    }

    public ResponseContainer<TaskLinkModel> deleteLinksBySourceTaskId(String sourceTaskId, TaskLinkModel link) {
        return new ResponseContainer<>(client.processRequest("LINKS", HttpMethod.DELETE,
                link,
                InlineRequestContext.builder().pathParam("sourceTaskId", sourceTaskId).build()), TaskLinkModel.class);
    }
}
