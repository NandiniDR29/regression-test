/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ipb.eisa.controls;

import com.exigen.ipb.eisa.controls.dialog.type.AbstractAdvancedSelector;
import com.exigen.istf.config.ClassConfigurator;
import com.exigen.istf.webdriver.BrowserController;
import com.exigen.istf.webdriver.ByT;
import com.exigen.istf.webdriver.controls.BaseElement;
import com.exigen.istf.webdriver.controls.ListBox;
import com.exigen.istf.webdriver.controls.waiters.Waiter;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;

/**
 * Used when available and selected items are represented as select.
 *
 * @author ikisly
 */
public class AdvancedSelector extends AbstractAdvancedSelector {

    @ClassConfigurator.Configurable
    private static ByT availableItemsLocator = ByT.xpath(".//select[contains(@id,'available')]");
    @ClassConfigurator.Configurable
    private static ByT selectedItemsLocator = ByT.xpath(".//select[contains(@id,'exist')]");
    @ClassConfigurator.Configurable
    private static ByT firstListBoxOption = ByT.xpath("./option[1]");
    @ClassConfigurator.Configurable
    private static ByT lastListBoxOption = ByT.xpath("./option[last()]");

    public ListBox listBoxAvailableItems = new ListBox(actionControlsParent, availableItemsLocator.format());
    public ListBox listBoxSelectedItems = new ListBox(actionControlsParent, selectedItemsLocator.format());

    static {
        ClassConfigurator configurator = new ClassConfigurator(AbstractAdvancedSelector.class);
        configurator.applyConfiguration();
    }

    public AdvancedSelector(By locator) {
        super(locator, Waiters.DEFAULT);
    }

    public AdvancedSelector(By locator, Waiter waitBy) {
        super(locator, waitBy);
    }

    public AdvancedSelector(BaseElement<?, ?> parent, By locator) {
        super(parent, locator, Waiters.DEFAULT);
    }

    public AdvancedSelector(BaseElement<?, ?> parent, By locator, Waiter waitBy) {
        super(parent, locator, waitBy);
    }

    @Override
    protected void addAllOneByOne() {
        selectAllValues(listBoxAvailableItems);
        buttonAdd.click();
    }

    @Override
    protected void removeAllOneByOne() {
        selectAllValues(listBoxSelectedItems);
        buttonRemove.click();
    }

    @Override
    public void addValue(List<String> value) {
        if (!value.isEmpty()) {
            listBoxAvailableItems.setValue(value);
            buttonAdd.click();
        }
    }

    @Override
    public void removeValue(List<String> value) {
        listBoxSelectedItems.setValue(value);
        buttonRemove.click();
    }

    @Override
    public List<String> getAvailableItems() {
        return listBoxAvailableItems.getAllValues();
    }

    @Override
    public List<String> getSelectedItems() {
        return listBoxSelectedItems.getAllValues();
    }

    private void selectAllValues(ListBox select) {
        if (select.getAllValues().size() == 0) return; //If ALL values already selected do nothing
        if (select.getAllValues().size() == 1) {
            BrowserController.get().getActions().click(select.getWebElement().findElement(lastListBoxOption.format())).perform();
        } else {
            BrowserController.get().getActions().click(select.getWebElement().findElement(firstListBoxOption.format()))
                    .keyDown(Keys.SHIFT)
                    .click(select.getWebElement().findElement(lastListBoxOption.format()))
                    .keyUp(Keys.SHIFT).perform();
        }
    }
}
