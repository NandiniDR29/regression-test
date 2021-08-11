/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.policy.common;

import com.exigen.ipb.eisa.base.config.CustomTestProperties;
import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.data.TestData;
import com.exigen.istf.exceptions.IstfException;
import com.exigen.istf.rest.ResponseWrapper;
import com.exigen.istf.utils.meters.WaitMeters;
import com.exigen.ren.EntityLogger;
import com.exigen.ren.common.pages.MainPage;
import com.exigen.ren.main.modules.customer.Customer;
import com.exigen.ren.rest.JsonHelper;
import com.exigen.ren.rest.productfactory.ProductFactoryRestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.main.modules.policy.common.PolicyType.CREATION_METER;

/**
 * Interface for a specific entity type.
 * Modify this class if action set for a specific entity type has to be altered.
 * @category Generated
 */
public interface IPolicyRest extends IPolicy {
    Logger LOGGER = LoggerFactory.getLogger(IPolicy.class);

    /**
     *
     * @deprecated Should be removed during QAACC-430 implementation
     */
    @Deprecated
    default PolicyType getType(){
        throw new IstfException("Should not be used with new AutomationContext approach. Have to be refactored in a while");
    }

    default boolean isRestEnabled() {
        return PropertyProvider.getProperty(CustomTestProperties.REST_POLICY_SUPPORTED_TYPES, "")
                .contains(getType().getShortName());
    }

    default void create(TestData testData, String template) {
        assertThat(Customer.CustomerData.getCustomerNumber() != null).as("Customer number isn't set and can't be used in policy rest creation").isTrue();
        ResponseWrapper response =
                new ProductFactoryRestService().postProductOperation(
                        testData.getTestData("REST")
                                .adjust("customerNumber", Customer.CustomerData.getCustomerNumber()), template);
        int status = response.getResponse().getStatus();
        if (status != 200) {
            LOGGER.error("Error during rest policy creation. Response :\n" + response.getResponse().readEntity(String.class));
            throw new RuntimeException("Error during rest quote/policy creation.");
        }
        String policyNumber = JsonHelper.getValue("$..policyNumber", response);
        MainPage.QuickSearch.search(policyNumber);
        LOGGER.info("REST: Created quote/policy " + EntityLogger.getEntityHeader(EntityLogger.EntityType.POLICY));
    }

    default void createQuoteViaRest(TestData td) {
        LOGGER.info("REST: Starting quote creation");
        WaitMeters.activate(String.format(CREATION_METER, getType().getShortName(), "QUOTE", "REST"));
        create(td, String.format("%s_Quote", getType().getShortName()));
        WaitMeters.capture(String.format(CREATION_METER, getType().getShortName(), "QUOTE", "REST"));
    }

    default void createQuote(TestData td) {
        if (isRestEnabled()) {
            createQuoteViaRest(td);
        } else {
            createQuoteViaUI(td);
        }
    }

    default void createPolicy(TestData td) {
        if (isRestEnabled()) {
            createPolicyViaRest(td);
        } else {
            createPolicyViaUI(td);
        }
    }

    default void createPolicyViaRest(TestData td) {
        LOGGER.info("REST: Starting policy creation");
        WaitMeters.activate(String.format(CREATION_METER, getType().getShortName(), "POLICY", "REST"));
        create(td, String.format("%s_Policy", getType().getShortName()));
        WaitMeters.capture(String.format(CREATION_METER, getType().getShortName(), "POLICY", "REST"));
    }

    void createQuoteViaUI(TestData td);

    void createPolicyViaUI(TestData td);

}
