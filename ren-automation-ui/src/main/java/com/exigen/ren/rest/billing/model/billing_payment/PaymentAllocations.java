/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.billing.model.billing_payment;

import com.exigen.ren.rest.model.RestError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentAllocations extends RestError {

    private String invoiceNumber;
    private String invoiceItemsAllocationAmount;
    private String unallocatedInvoicePremium;

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceItemsAllocationAmount() {
        return invoiceItemsAllocationAmount;
    }

    public void setInvoiceItemsAllocationAmount(String invoiceItemsAllocationAmount) {
        this.invoiceItemsAllocationAmount = invoiceItemsAllocationAmount;
    }

    public String getUnallocatedInvoicePremium() {
        return unallocatedInvoicePremium;
    }

    public void setUnallocatedInvoicePremium(String unallocatedInvoicePremium) {
        this.unallocatedInvoicePremium = unallocatedInvoicePremium;
    }
}
