/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package com.exigen.ren.rest.policy;

import com.exigen.istf.data.TestData;
import com.exigen.ren.rest.ResponseContainer;
import com.exigen.ren.rest.policy.model.PolicyInfoModel;
import com.exigen.ren.rest.policy.model.TransactionInfoModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.istf.verification.CustomSoftAssertions.assertSoftly;

public class PolicyRestServiceVerifier {

    public static void verifyPolicyInfoResponse(ResponseContainer<List<PolicyInfoModel>> response, PolicyInfoModel policyInfoModel, TestData td) {
        assertSoftly(softly -> {
            softly.assertThat(response.getResponse().getStatus()).isEqualTo(200);
            softly.assertThat(policyInfoModel.getPolicyNumber()).isEqualTo(td.getTestData("query").getValue("policyNumber"));
            softly.assertThat(policyInfoModel.getCustomerNumber().toString()).isEqualTo(td.getTestData("query").getValue("customerNumber"));
            softly.assertThat(policyInfoModel.getTransactionType()).isEqualTo(td.getTestData("query").getValue("transactionType"));
            softly.assertThat(policyInfoModel.getProductCode()).isEqualTo(td.getTestData("query").getValue("productCode"));
            softly.assertThat(policyInfoModel.getLobCd()).isEqualTo(td.getTestData("query").getValue("lobCd"));
            softly.assertThat(policyInfoModel.getPolicyStatusCd()).isEqualTo(td.getTestData("query").getValue("policyStatusCd"));
        });
    }

    public static void verifyTransactionsSortedCorrectlyByTransactionEffectiveDate(ResponseContainer<List<TransactionInfoModel>> response) {
        for (int i = 0; i < response.getModel().size() - 1; i++) {
            assertThat(response.getModel().get(i).getTransactionEffectiveDate()).isBeforeOrEqualTo(response.getModel().get(i + 1).getTransactionEffectiveDate());
        }
    }

    public static void verifyTransactionsSortedCorrectlyByPolicyEffectiveDate(ResponseContainer<List<TransactionInfoModel>> response) {
        List<Integer> policyNums = response.getModel().stream().map(TransactionInfoModel::getPolicyNumber).collect(Collectors.toList()).stream()
                .map(p -> Integer.valueOf(p.substring(5, p.length()))).collect(Collectors.toList());
        assertThat(policyNums.stream().sorted().collect(Collectors.toList()).equals(policyNums)).isTrue();
    }

    public static void verifyTransactionsSortedCorrectlyByPolicyExpirationDate(ResponseContainer<List<TransactionInfoModel>> response) {
        ArrayList<Integer> policyNums = (ArrayList<Integer>) response.getModel().stream().map(TransactionInfoModel::getPolicyNumber).collect(Collectors.toList()).stream()
                .map(p -> Integer.valueOf(p.substring(5, p.length()))).collect(Collectors.toList());
        for (int i = 0; i < policyNums.size() - 1; i++) {
            assertThat(policyNums.get(i) >= policyNums.get(i + 1));
        }
    }
}
