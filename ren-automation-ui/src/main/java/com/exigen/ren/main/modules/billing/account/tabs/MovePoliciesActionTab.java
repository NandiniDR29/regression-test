/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.billing.account.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.RadioButton;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.enums.PolicyConstants;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.modules.billing.account.metadata.MovePoliciesActionTabMetaData;
import org.openqa.selenium.By;

public class MovePoliciesActionTab extends ActionTab {
    public static final Table tablePolicies = new Table(By.id("policyMoveForm:policyResults"));
    public static final TableExtended<TableConstants.BillingNewInstallmentsSchedule> tableCurrentInstallment =
            new TableExtended<>("Current Installments", By.id("policyMoveForm:current_installments_table"));
    public static final TableExtended<TableConstants.BillingNewInstallmentsSchedule> tableNewInstallment =
            new TableExtended<>("New Installments", By.id("policyMoveForm:new_installments_table"));
    public static final RadioButton radioButtonAllInstallments = new RadioButton(By.id("policyMoveForm:overpaidOptionComponent_applyOverpaidAmount:1"));
    public static final RadioButton radioButtonNextInstallments = new RadioButton(By.id("policyMoveForm:overpaidOptionComponent_applyOverpaidAmount:0"));

    public MovePoliciesActionTab() {
        super(MovePoliciesActionTabMetaData.class);
    }

    @Override
    public Tab fillTab(TestData td) {

        String policiesLabel = MovePoliciesActionTabMetaData.POLICIES.getLabel();

        for (String policyNumber : td.getList(getMetaKey(), policiesLabel)) {
            tablePolicies.getRow(PolicyConstants.PoliciesTable.POLICY, policyNumber).getCell(1).controls.checkBoxes.getFirst().setValue(true);
        }

        return super.fillTab(td.mask(TestData.makeKeyPath(getMetaKey(), policiesLabel)));
    }
}
