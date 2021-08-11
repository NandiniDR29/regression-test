/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ipb.eisa.controls;

import com.exigen.istf.webdriver.BrowserController;
import com.exigen.istf.webdriver.controls.BaseElement;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.CheckBox;
import com.exigen.istf.webdriver.controls.ListBox;
import com.exigen.istf.webdriver.controls.waiters.Waiter;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ComboList extends ListBox {
    protected Button buttonSelect = new Button(this, By.xpath(".//a[@class='ui-selectcheckboxmenu-label-container']/label"));
    protected static final String OPTION_TEMPLATE =
            "//div[contains(@class, 'ui-selectcheckboxmenu-panel') and @style]//div[@class='ui-selectcheckboxmenu-items-wrapper']//li[.='%s']"
                    + "//div[contains(@class, 'ui-chkbox-box')]";
    protected static final String ADD_ALL = "ALL";
    protected static final By ADD_ALL_CHECK_BOX_LOCATOR = By.xpath("//div[contains(@class, 'ui-selectcheckboxmenu-panel')][contains(@style, 'display')]/div[contains(@class,'ui-selectcheckboxmenu-header')]//div[contains(@class,'ui-chkbox-box ui-widget')]");
    protected static final By All_VALUES_LOCATOR = By.xpath("//div[contains(@class, 'ui-selectcheckboxmenu-panel') and @style]//div[@class='ui-selectcheckboxmenu-items-wrapper']//li");

    public ComboList(BaseElement<?, ?> parent, By locator, Waiter waitBy) {
        super(parent, locator, waitBy);
    }

    @Override
    public List<String> getRawValue() {
        List<String> result = new ArrayList<>(Arrays.asList(getWebElement().getText().split("\r?\n")));
        result.remove(buttonSelect.getValue());
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void setRawValue(List<String> value) {
        Waiters.SLEEP(500).then(Waiters.AJAX).go();
        buttonSelect.click();
        List<String> selectedValues = getRawValue();
        if (!value.isEmpty()) {
            if(value.contains(ADD_ALL) && value.size() == 1) {
                CheckBox chb = new CheckBox(this, ADD_ALL_CHECK_BOX_LOCATOR);
                chb.setValue(!chb.getValue());
            }else {
                List<String> optionsToChangeStatus = value.stream()
                        .filter(entryToSelect -> !selectedValues.contains(entryToSelect))
                        .collect(Collectors.toList());
                for (String option : optionsToChangeStatus) {
                    CheckBox chb = new CheckBox(this, By.xpath(String.format(OPTION_TEMPLATE, option)));
                    chb.setValue(true);
                }
            }
        } else {
            for(String option : selectedValues) {
                CheckBox chb = new CheckBox(this, By.xpath(String.format(OPTION_TEMPLATE, option)));
                chb.setValue(true);
            }
        }
        buttonSelect.click(Waiters.SLEEP.then(Waiters.DEFAULT));
    }

    @Override
    public List<String> getAllValues() {
        List<String> values = new ArrayList<>();
        buttonSelect.click();
        for (WebElement element : BrowserController.get().driver().findElements(All_VALUES_LOCATOR)) {
            values.add(element.getText().trim());
        }
        buttonSelect.click(Waiters.SLEEP.then(Waiters.DEFAULT));
        return values;
    }

    @Override
    public List<String> getValue() {
        return getRawValue();
    }

    @Override
    public boolean isEnabled() {
        return super.isEnabled() && !getWebElement().findElement(By.xpath(".//div[contains(@class, 'ui-selectcheckboxmenu')]")).getAttribute("class").contains("ui-state-disabled");
    }
}
