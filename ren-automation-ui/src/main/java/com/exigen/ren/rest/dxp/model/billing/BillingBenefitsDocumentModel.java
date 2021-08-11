package com.exigen.ren.rest.dxp.model.billing;

import com.exigen.ren.rest.model.RestError;

import java.util.Objects;

public class BillingBenefitsDocumentModel extends RestError {
    private String docgenTicket;
    private String statusCd;
    private String documentName;
    private String documentId;

    public String getDocgenTicket() {
        return docgenTicket;
    }

    public void setDocgenTicket(String docgenTicket) {
        this.docgenTicket = docgenTicket;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        BillingBenefitsDocumentModel that = (BillingBenefitsDocumentModel) o;
        return Objects.equals(docgenTicket, that.docgenTicket) &&
                Objects.equals(statusCd, that.statusCd) &&
                Objects.equals(documentName, that.documentName) &&
                Objects.equals(documentId, that.documentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), docgenTicket, statusCd, documentName, documentId);
    }
}
