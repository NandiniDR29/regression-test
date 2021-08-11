package com.exigen.ipb.eisa.controls.ratingreport;

import com.exigen.istf.webdriver.ByT;
import com.exigen.istf.webdriver.controls.*;
import com.exigen.istf.webdriver.controls.waiters.Waiter;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class ApplyTextBox extends TextBox {

    public ApplyTextBox(By locator) {
        this(locator, Waiters.DEFAULT);
    }

    public ApplyTextBox(By locator, Waiter waiter) {
        super(locator, waiter);
    }

    public ApplyTextBox(BaseElement<?, ?> parent, By locator, Waiter waiter) {
        super(parent, locator, waiter);
    }

    public void applyValue(String value) {
        setRawValue(value);
        getApplyLink().click();
    }

    public Link getApplyLink() {
        Link link;
        link = new Link(this, By.xpath("./following-sibling::a"), Waiters.DEFAULT);
        if (!link.isPresent()) {
            link = new Link(this, By.xpath("./parent::div//following-sibling::a"), Waiters.DEFAULT);
        }
        return link;
    }

}
