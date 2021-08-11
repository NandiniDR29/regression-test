/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer;

import com.exigen.ipb.eisa.base.config.CustomTestProperties;
import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.data.TestData;
import com.exigen.istf.exceptions.IstfException;
import com.exigen.ren.rest.customer.CustomerRestService;
import com.exigen.ren.rest.customer.model.CustomerModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Customer implements ICustomer {

    protected static final Logger LOGGER = LoggerFactory.getLogger(Customer.class);

    private static boolean isRestCustomerEnabled = PropertyProvider.getProperty(CustomTestProperties.REST_CUSTOMER_ENABLED, false);

    @Override
    public void create(TestData td) {
        if (isRestCustomerEnabled) {
            try {
                createViaREST(td);
            } catch (IstfException e) {
                LOGGER.info("REST customer creation failed: " + e);
                createViaUI(td);
            }
        } else {
            createViaUI(td);
        }
    }

    public void updateIndividualViaREST(String customerNumber, CustomerModel model) { //todo iguliam move to separate rest related interface
        try {
            new CustomerRestService().putIndividualCustomers(customerNumber, model);
        } catch (Exception e) {
            throw new IstfException(e);
        }
    }

    public void updateNonIndividualViaREST(String customerNumber, CustomerModel model) { //todo iguliam move to separate rest related interface
        try {
            new CustomerRestService().putNonIndividualCustomer(customerNumber, model);
        } catch (Exception e) {
            throw new IstfException(e);
        }
    }

    public static class CustomerData { // todo iguliam replace with TestEntitiesHolder

        private static ThreadLocal<String> customerNumber = new ThreadLocal<>();
        private static ThreadLocal<String> customerType = new ThreadLocal<>();

        public static String getCustomerNumber() {
            return customerNumber.get();
        }

        public static void setCustomerNumber(String customerNumber) {
            CustomerData.customerNumber.set(customerNumber);
        }

        public static String getCustomerType() {
            return customerType.get();
        }

        public static void setCustomerType(String customerType) {
            CustomerData.customerType.set(customerType);
        }
    }

}
