package com.exigen.ren.rest.billing.model.billing_accounts_invoices;

public class BillingAccountsInvoicesDocuments {
    private String docgenTicket;
    private String statusCd;
    private String documentName;

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

    public String getRepositoryDocumentId() {
        return repositoryDocumentId;
    }

    public void setRepositoryDocumentId(String repositoryDocumentId) {
        this.repositoryDocumentId = repositoryDocumentId;
    }

    private String repositoryDocumentId;
}
