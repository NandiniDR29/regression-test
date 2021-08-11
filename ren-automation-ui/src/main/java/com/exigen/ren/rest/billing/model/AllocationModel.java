/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.billing.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.List;

public class AllocationModel extends Model {

    private PolicyModel policy;
    private AmountModel amount;
    private List<AllocationAmountModel> allocationAmounts;

    public PolicyModel getPolicy() { return policy; }

    public void setPolicy(PolicyModel policy) { this.policy = policy; }

    public AmountModel getAmount() { return amount; }

    public void setAmount(AmountModel amount) { this.amount = amount; }

    public List<AllocationAmountModel> getAllocationAmounts() { return allocationAmounts; }

    public void setAllocationAmounts(List<AllocationAmountModel> allocationAmounts) { this.allocationAmounts = allocationAmounts; }
}
