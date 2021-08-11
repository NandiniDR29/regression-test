/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.policy.common;

import com.exigen.istf.data.TestData;
import com.exigen.ren.EntityLogger;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.policy.common.actions.certificate.*;
import com.exigen.ren.main.modules.policy.common.actions.common.ArchiveTransactionAction;
import com.exigen.ren.main.modules.policy.common.actions.common.FaxBackPolicyInformationAction;
import com.exigen.ren.main.modules.policy.gb_ac.certificate.tabs.PremiumSummaryTab;
import com.exigen.ren.main.pages.summary.PolicySummaryPage;

public interface GroupBenefitsCertificatePolicy extends IPolicyRest {

    @Override
    default void initiate(TestData td) {
        PolicySummaryPage.buttonAddCertificatePolicy.click();
        System.out.println(" clicked");
    }

    @Override
    default void createQuoteViaUI(TestData td) {
        initiate(td);
        getDefaultWorkspace().fill(td);
        LOGGER.info("Created Quote " + EntityLogger.getEntityHeader(EntityLogger.EntityType.QUOTE));
    }

    @Override
    default void createPolicyViaUI(TestData td) {
        initiate(td);
        getDefaultWorkspace().fill(td);
        issue().perform(td);
        LOGGER.info("Created Policy " + EntityLogger.getEntityHeader(EntityLogger.EntityType.POLICY_CERTIFICATE));
    }

    @Override
    default void createRenewal(TestData td) {
        renew().perform(td);
        PolicySummaryPage.buttonRenewals.click();
        calculatePremium();
        PolicySummaryPage.buttonRenewals.click();
        issue().perform(td);
    }

    @Override
    default void createEndorsement(TestData td) {
        endorse().perform(td);
        PolicySummaryPage.buttonPendedEndorsement.click();
        dataGather().perform(td);
        PolicySummaryPage.buttonPendedEndorsement.click();
        issue().perform(td);
    }

    @Override
    default void calculatePremium() {
        dataGather().start();
        NavigationPage.toLeftMenuTab(NavigationEnum.GroupBenefitsTab.PREMIUM_SUMMARY.get());
        PremiumSummaryTab.buttonRate.click();
        PremiumSummaryTab.buttonSaveAndExit.click();
        LOGGER.info("Calculate Premium " + EntityLogger.getEntityHeader(EntityLogger.EntityType.POLICY));
    }

    @Override
    default void issue(TestData td) {
        issue().perform(td);
        LOGGER.info("Issue Quote " + EntityLogger.getEntityHeader(EntityLogger.EntityType.POLICY));
    }

    @Override
    default Action issue() {
        return AutomationContext.getAction(CertificatePolicyIssueAction.class);
    }

    @Override
    default Action dataGather() {
        return AutomationContext.getAction(CertificatePolicyDataGatherAction.class);
    }

    default CertificatePolicyRollOnAction rollOn() {
        return AutomationContext.getAction(CertificatePolicyRollOnAction.class);
    }

    default Action addPremiumWaiver() {
        return AutomationContext.getAction(CertificatePolicyAddPremiumWaiverAction.class);
    }

    default Action removePremiumWaiver() {
        return AutomationContext.getAction(CertificatePolicyRemovePremiumWaiverAction.class);
    }

    default ArchiveTransactionAction archiveTransaction() {
        return AutomationContext.getAction(ArchiveTransactionAction.class);
    }

    default FaxBackPolicyInformationAction faxBackPolicyInformation() {
        return AutomationContext.getAction(FaxBackPolicyInformationAction.class);
    }

    default ProcedureCodeSearchAction procedureCodeSearch() {
        return AutomationContext.getAction(ProcedureCodeSearchAction.class);
    }
}
