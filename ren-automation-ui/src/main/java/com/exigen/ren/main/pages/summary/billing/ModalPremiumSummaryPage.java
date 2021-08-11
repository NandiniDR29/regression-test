/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.pages.summary.billing;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.main.enums.BillingConstants;
import com.exigen.ren.main.pages.summary.SummaryPage;
import org.openqa.selenium.By;

public class ModalPremiumSummaryPage extends SummaryPage {

    public static TableExtended<ModalPremiums> tableModalPremium = new TableExtended<>("Modal Premium(s)", By.xpath("//div[@id='modalPremiumForm:billing_modal_premium']//table"));

    public static  TableExtended<BillingModalPremiumTable> getModalPremiumsTableByBillableCoverage(int rowNumber) {
        return new TableExtended<BillingModalPremiumTable>("Modal Premium(s) History", By.xpath(String.format("//div[@id='modalPremiumForm:billing_modal_premium:%s:modalPremiumHistoryTable']//table", rowNumber)));
    }

    /**
     * Use only when Coverage has ONLY one Payor
     * @param coverageName
     */
    public static void expandCoverageByName(String coverageName) {
        Link collapsedCoverage =
                tableModalPremium.getRow(BillingConstants.BillingModalPremiumTable.COVERAGE, coverageName).getCell(BillingConstants.BillingModalPremiumTable.COVERAGE).controls.links.getFirst();
        if (collapsedCoverage.isPresent()) {
            collapsedCoverage.click();
        }
    }

    public static void expandCoverageByRow(int rowNumber) {
        Link collapsedCoverage = tableModalPremium.getRow(rowNumber).getCell(BillingConstants.BillingModalPremiumTable.COVERAGE).controls.links.getFirst();
        if (collapsedCoverage.isPresent()) {
            collapsedCoverage.click();
        }
    }


    public enum ModalPremiums implements Named {
        COVERAGE("Coverage"),
        POLICY_PLAN("Policy Plan"),
        MODAL_PREMIUM_EFFECTIVE_DATE("Modal Premium Effective Date"),
        MASTER_POLICY_CERTIFICATE_NUMBER("Master Policy / Certificate Number"),
        BILLING_GROUP("Billing Group"),
        LOCATION("Location"),
        PAYOR("Payor"),
        TRANSACTION_TYPE_SUBTYPE_REASON("Transaction Type (Subtype / Reason)"),
        PAY_MODE("Pay Mode"),
        STATUS("Status"),
        AMOUNT("Amount");

        private String name;

        ModalPremiums(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum BillingModalPremiumTable implements Named {
        MODAL_PREMIUM_EFFECTIVE_DATE("Modal Premium Effective Date"),
        MASTER_POLICY_CERTIFICATE_NUMBER("Master Policy / Certificate Number"),
        BILLING_GROUP("Billing Group"),
        LOCATION("Location"),
        PAYOR("Payor"),
        TRANSACTION_TYPE_SUBTYPE_REASON("Transaction Type (Subtype / Reason)"),
        PAY_MODE("Pay Mode"),
        AMOUNT("Amount");

        private String name;

        BillingModalPremiumTable(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

}
