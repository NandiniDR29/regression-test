/* Copyright © 2018 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.platform.efolder.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubFoldersModel extends Model {
    private String folderId;

    private String folderName;

    private List<SubFoldersModel> subFolder;

    private ActionsModel actions;

    private DocumentTypesModel documentTypes;

    private List<AttachmentsModel> attachments;

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public String getFolderId() {
        return this.folderId;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getFolderName() {
        return this.folderName;
    }

    public void setSubFolder(List<SubFoldersModel> subFolder) {
        this.subFolder = subFolder;
    }

    public List<SubFoldersModel> getSubFolder() {
        return this.subFolder;
    }

    public void setActions(ActionsModel actions) {
        this.actions = actions;
    }

    public ActionsModel getActions() {
        return this.actions;
    }

    public void setDocumentTypes(DocumentTypesModel documentTypes) {
        this.documentTypes = documentTypes;
    }

    public DocumentTypesModel getDocumentTypes() {
        return this.documentTypes;
    }

    public void setAttachments(List<AttachmentsModel> attachments) {
        this.attachments = attachments;
    }

    public List<AttachmentsModel> getAttachments() {
        return this.attachments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        if (!super.equals(o)) {return false;}
        SubFoldersModel that = (SubFoldersModel) o;
        return Objects.equals(folderId, that.folderId) &&
                Objects.equals(folderName, that.folderName) &&
                Objects.equals(subFolder, that.subFolder) &&
                Objects.equals(actions, that.actions) &&
                Objects.equals(documentTypes, that.documentTypes) &&
                Objects.equals(attachments, that.attachments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), folderId, folderName, subFolder, actions, documentTypes, attachments);
    }
}
