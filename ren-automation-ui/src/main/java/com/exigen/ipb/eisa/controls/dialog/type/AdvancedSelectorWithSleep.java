package com.exigen.ipb.eisa.controls.dialog.type;

import com.exigen.ipb.eisa.controls.AdvancedSelector2;
import com.exigen.istf.webdriver.controls.BaseElement;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.waiters.Waiter;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Quotes;

import java.util.List;

public class AdvancedSelectorWithSleep extends AdvancedSelector2 {
    private StaticElement availableOptionsContainer = new StaticElement(actionControlsParent, By.xpath(".//div[contains(@id,'SourceItems')]"));

    public AdvancedSelectorWithSleep(By locator) {
        super(locator, Waiters.DEFAULT);
    }

    public AdvancedSelectorWithSleep(By locator, Waiter waitBy) {
        super(locator, waitBy);
    }

    public AdvancedSelectorWithSleep(BaseElement<?, ?> parent, By locator) {
        super(parent, locator, Waiters.DEFAULT);
    }

    public AdvancedSelectorWithSleep(BaseElement<?, ?> parent, By locator, Waiter waitBy) {
        super(parent, locator, waitBy);
    }

    @Override
    protected void addValue(List<String> value) {
        for (String v : value) {
            new Link(availableOptionsContainer, By.xpath(String.format("./div[.=%s]", Quotes.escape(v))), Waiters.SLEEP(5000)).click(Waiters.SLEEP(5000));
            buttonAdd.click();
        }
    }
}
