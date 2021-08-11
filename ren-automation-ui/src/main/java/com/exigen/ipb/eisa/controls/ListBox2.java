/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ipb.eisa.controls;

import com.exigen.ipb.eisa.controls.dialog.type.AbstractAdvancedSelector;
import com.exigen.istf.config.ClassConfigurator;
import com.exigen.istf.utils.meters.WaitMeters;
import com.exigen.istf.webdriver.BrowserController;
import com.exigen.istf.webdriver.ByT;
import com.exigen.istf.webdriver.controls.*;
import com.exigen.istf.webdriver.controls.waiters.Waiter;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ListBox2 extends ListBox {

    public ListBox2(By locator) {
        super(locator, Waiters.DEFAULT);
    }

    public ListBox2(By locator, Waiter waiter) {
        super(locator, waiter);
    }

    public ListBox2(BaseElement<?, ?> parent, By locator) {
        super(parent, locator, Waiters.DEFAULT);
    }

    public ListBox2(BaseElement<?, ?> parent, By locator, Waiter waiter) {
        super(parent, locator, waiter);
    }

    @Override
    protected void setRawValue(List<String> values) {
        Select select = this.getSelect();
        select.deselectAll();
        for(Iterator var2 = values.iterator(); var2.hasNext(); this.waitForPageUpdate()) {
            String value = (String)var2.next();
            select.selectByVisibleText(value);
        }

        WaitMeters.capture("PAGE_LOAD");
    }

}
