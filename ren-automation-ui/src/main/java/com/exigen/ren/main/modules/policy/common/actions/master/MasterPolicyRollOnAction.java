/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package com.exigen.ren.main.modules.policy.common.actions.master;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.policy.common.actions.common.RollOnAction;
import com.exigen.ren.main.modules.policy.gb_tl.masterpolicy.TermLifeInsuranceMasterPolicy;
import org.openqa.selenium.By;

public class MasterPolicyRollOnAction extends RollOnAction {
    public static Button buttonDataGather = new Button(By.id("comparisonTreeForm:dataGathering_footer"));

    @Override
    public Action perform(boolean isAutomatic, boolean setOldValues) {
        performBase(isAutomatic, setOldValues);
        return submit();
    }

    public Action perform(boolean isAutomatic, boolean setOldValues, TestData td) {
        performBase(isAutomatic, setOldValues);
        return dataGather(td);
    }

    @Override
    public Action submit() {
        buttonRollOnChanges.click();
        Page.dialogConfirmation.buttonYes.click();
        Tab.buttonFinish.click();
        return this;
    }

    public Action dataGather(TestData td) {
        buttonDataGather.click();
        new TermLifeInsuranceMasterPolicy().getDefaultWorkspace().fill(td);
        return this;
    }

    private void performBase(boolean isAutomatic, boolean setOldValues) {
        start();

        Table tableOosEndorsements = new Table(By.xpath("//table[@id='affectedEndoresmentForm:historyTable']"));
        int rowsCount = tableOosEndorsements.getRowsCount();
        int columnsCount = tableOosEndorsements.getColumnsCount();

        for (int i = 1; i <= rowsCount; i++) {
            Link link = tableOosEndorsements.getRow(i).getCell(columnsCount).controls.links.get(
                    isAutomatic ? 1 : 2);
            if (link.isPresent()) {
                link.click();
            }
        }

        if (!isAutomatic) {
            Table tableDifferences = new Table(By.xpath("//div[@id='comparisonTreeForm:comparisonTree']/table"));
            rowsCount = tableDifferences.getRowsCount();
            columnsCount = tableDifferences.getColumnsCount();

            //expand rows
            for (int i = 0; i < rowsCount; i++) {
                new Link(By.xpath("//div[@id='comparisonTreeForm:comparisonTree']//tr[@id='comparisonTreeForm:comparisonTree_node_" + i
                        + "']/td[1]/span[contains(@class, 'ui-treetable-toggler')]")).click();
            }

            //apply values
            Link linkSetValue;
            rowsCount = tableDifferences.getRowsCount();
            for (int i = 1; i <= rowsCount; i++) {
                linkSetValue = tableDifferences.getRow(i).getCell(columnsCount).controls.links.get(
                        setOldValues ? 2 : 1);

                if (linkSetValue.isPresent() && linkSetValue.isVisible()) {
                    linkSetValue.click();
                }
            }
        }
    }
}
