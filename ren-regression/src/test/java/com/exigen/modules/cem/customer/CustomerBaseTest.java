/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.cem.customer;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.istf.data.TestData;
import com.exigen.ren.main.modules.customer.CustomerContext;

public class CustomerBaseTest extends CommonBaseTest implements CustomerContext {

    protected TestData tdCustomerIndividual = customerIndividual.getDefaultTestData();
    protected TestData tdCustomerNonIndividual = customerNonIndividual.getDefaultTestData();
}
