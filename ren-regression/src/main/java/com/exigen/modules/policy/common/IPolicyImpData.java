/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.policy.common;

import com.exigen.istf.data.TestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Interface for a specific entity type.
 * Modify this class if action set for a specific entity type has to be altered.
 * @category Generated
 */
public interface IPolicyImpData extends IPolicy {
    Logger LOGGER = LoggerFactory.getLogger(IPolicy.class);

    default void createQuote(TestData td) {

            createQuoteViaUI(td);

    }

    default void createPolicy(TestData td) {

            createPolicyViaUI(td);

    }

    void createQuoteViaUI(TestData td);

    void createPolicyViaUI(TestData td);

    void createEndorsement(TestData td);
}
