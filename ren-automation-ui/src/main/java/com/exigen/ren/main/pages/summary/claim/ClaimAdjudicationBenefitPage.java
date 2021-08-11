/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.pages.summary.claim;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.main.pages.summary.SummaryPage;
import org.openqa.selenium.By;

public class ClaimAdjudicationBenefitPage extends SummaryPage {

    public static Table tableBenefitInfo = new Table(By.id("policyDataGatherForm:componentView_PrecClaimsBenefitView"));
    public static TableExtended<AllClaimBenefits> tableAllClaimBenefits = new TableExtended<>("All Claim Benefits", By.xpath("//div[@id='productConsolidatedViewForm:scolumn_ClaimsEvaluationConsolidatedDamage']//table"));
    public static Table tableBenefitParties = new Table(By.xpath("//div[@id='policyDataGatherForm:damagePartiesInfoTable_PrecClaimsBenefitPartyView']/div//table"));
    public static Table tableVendorsProviderServices = new Table(By.xpath("//div[@id='policyDataGatherForm:vendorsInfoTable_ClaimsVendorConsolidatedView']/div//table"));
    public static Table tableBenefitReserves = new Table(By.xpath("//div[@id='policyDataGatherForm:componentInstancesTable_ClaimsDamageReservesView']/div//table"));
    public static Table tableBenefitReserveHistory = new Table(By.xpath("//div[@id='policyDataGatherForm:componentInstancesTable_PrecClaimsDamageTransactionHistory']/div//table"));
    public static TableExtended<AllSingleBenefitCalculations> tableAllSingleBenefitCalculations = new TableExtended("All Single Benefit Calculations", By.xpath("//div[@id='productConsolidatedViewForm:scolumn_PrecEvaluationClaimFeature']//table"));
    public static TableExtended<SingleBenefitCalculationStatusHistory> tableSingleBenefitCalculationStatusHistory = new TableExtended("Single Benefit Calculation Status History", By.xpath("//div[@id='policyDataGatherForm:componentView_ClaimsFeatureStatusHistory']//table"));

    public static Link linkAddBenefitAccidentalDeath = new Link(By.id("productConsolidatedViewForm:addDamageAccidentalDeath"));
    public static Link linkAddBenefitAccidentalDismemberment = new Link(By.id("productConsolidatedViewForm:addDamageAccidentalDismemberment"));
    public static Link linkAddBenefitCriticalIllness = new Link(By.id("productConsolidatedViewForm:addDamageCriticalIllness"));
    public static Link linkAddBenefitDiagnosisAndTreatment = new Link(By.id("productConsolidatedViewForm:addDamageAccidentalInjury"));

    public static Link linkBenefitInquiry = new Link(By.id("policyDataGatherForm:damageActionLink_inquiryDamageAction"));
    public static Link linkBenefitUpdate = new Link(By.id("policyDataGatherForm:damageActionLink_updateDamageAction"));
    public static Link linkCalculateBenefitAmount = new Link(By.xpath("//*[@id='productConsolidatedViewForm:calculateSingleBenefitAmount' or @id='policyDataGatherForm:damageActionLink_addFeature']"));
    public static Link linkBenefitReserves = new Link(By.id("policyDataGatherForm:damageActionLink_updateDamageReservesAction"));

    public static Link linkAddBenefitSTD = new Link(By.id("productConsolidatedViewForm:addDamageShortTermDisability"));
    public static Link linkAddBenefitLTD = new Link(By.id("productConsolidatedViewForm:addDamageLongTermDisability"));
    public static Link linkAddBenefitStatutorySTD = new Link(By.id("productConsolidatedViewForm:addDamageStatutoryShortTermDisability"));

    public static Link linkAddBenefitDeath = new Link(By.id("productConsolidatedViewForm:addDamageDeath"));
    public static Link linkAddBenefitAcceleratedDeath = new Link(By.id("productConsolidatedViewForm:addDamageAcceleratedDeath"));
    public static Link linkAddBenefitPremiumWaiver = new Link(By.id("productConsolidatedViewForm:addDamagePremiumWaiver"));

    public enum AllClaimBenefits implements Named {
        BENEFIT_NUMBER("Benefit Number"),
        BENEFIT_TYPE("Benefit Type"),
        ASSOCIATED_PARTY("Associated Party");
        private String name;

        AllClaimBenefits(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum AllSingleBenefitCalculations implements Named {
        SINGLE_BENEFIT_NUMBER("Single Benefit Number"),
        FEATURE_ID("Single Benefit ID"),
        CLAIMANT("Claimant"),
        ASSOCIATED_INSURABLE_RISK("Associated Insurable Risk"),
        SINGLE_BENEFIT_PARTY("Single Benefit Party"),
        SINGLE_BENEFIT_STATUS("Single Benefit Status"),
        FEATURE_STATUS("Feature Status"),
        ACTIONS("");
        private String name;

        AllSingleBenefitCalculations(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum SingleBenefitCalculationStatusHistory implements Named {
        SINGLE_BENEFIT_CALCULATION_STATUS("Single Benefit Calculation Status"),
        SINGLE_BENEFIT_CALCULATION_STATUS_DATE("Single Benefit Calculation Status Date"),
        DESCRIPTION("Description");
        private String name;

        SingleBenefitCalculationStatusHistory(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }


}
