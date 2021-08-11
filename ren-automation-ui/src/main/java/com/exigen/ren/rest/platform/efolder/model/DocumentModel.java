/* Copyright © 2018 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.platform.efolder.model;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentModel extends RestError {
    private String documentId;
    private String fileName;
    private String creationDate;
    private String fileSize;
    private String comment;
    private String contentType;
    private String attachmentTypeCd;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getAttachmentTypeCd() {
        return attachmentTypeCd;
    }

    public void setAttachmentTypeCd(String attachmentTypeCd) {
        this.attachmentTypeCd = attachmentTypeCd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        if (!super.equals(o)) {return false;}
        DocumentModel that = (DocumentModel) o;
        return Objects.equals(documentId, that.documentId) &&
                Objects.equals(fileName, that.fileName) &&
                Objects.equals(creationDate, that.creationDate) &&
                Objects.equals(fileSize, that.fileSize) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(contentType, that.contentType) &&
                Objects.equals(attachmentTypeCd, that.attachmentTypeCd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), documentId, fileName, creationDate, fileSize, comment, contentType, attachmentTypeCd);
    }
}
