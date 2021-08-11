/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer;

import com.exigen.ren.common.AutomationContext;

public enum CustomerType {
    INDIVIDUAL("Individual", AutomationContext.getService(CustomerIndividual.class)),
    NON_INDIVIDUAL("Nonindividual", AutomationContext.getService(CustomerNonIndividual.class));

    private String customerType;
    private ICustomer product;

    CustomerType(String t, ICustomer p) {
        customerType = t;
        product = p;
    }

    public ICustomer get() {
        return product;
    }

    public String getName() {
        return customerType;
    }

    public String getKey() {
        return product.getClass().getSimpleName();
    }
}
