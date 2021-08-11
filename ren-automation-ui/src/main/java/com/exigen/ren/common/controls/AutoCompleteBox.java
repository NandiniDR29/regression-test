package com.exigen.ren.common.controls;

import com.exigen.istf.config.ClassConfigurator;
import com.exigen.istf.config.ClassConfigurator.Configurable;
import com.exigen.istf.webdriver.ByT;
import com.exigen.istf.webdriver.controls.AbstractEditableStringElement;
import com.exigen.istf.webdriver.controls.BaseElement;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.waiters.Waiter;
import org.openqa.selenium.By;

public class AutoCompleteBox extends AbstractEditableStringElement {  // todo ddiachenko remove if isba>11.9
    @Configurable
    private static ByT autoCompleteFirstValueLocator = ByT.xpath("//div[not (contains(@style, 'display: none'))]//*[contains(@class, 'ui-autocomplete-item') and contains(@class, 'ui-state-highlight')]");
    @Configurable
    private static ByT templateAutoCompleteBoxFullValueLocatorXpath = ByT.xpath("//span[@id='taskCompleteForm:patientDisplay' and contains(text(), '%s')]");
    @Configurable
    private static ByT templateAutoCompleteBoxIndexValueLocator = ByT.xpath("//span[@id=taskCompleteForm:patientDisplay][%d]");
    @Configurable
    private static String innerTextBoxConfigurationFileName = "AutoCompleteBox";
    @Configurable
    private static int timeout = 10000;
    private TextBox innerTextBox;
    private Link linkAutoCompleteFirstValue;

    public AutoCompleteBox(BaseElement<?, ?> parent, By locator, Waiter waitBy) {
        super(parent, locator, waitBy);
        this.linkAutoCompleteFirstValue = new Link(autoCompleteFirstValueLocator.format(new Object[0]));
        this.innerTextBox = (new TextBox(parent, locator, waitBy)).applyConfiguration(innerTextBoxConfigurationFileName);
    }

    public AutoCompleteBox(By locator, Waiter waitBy) {
        super(locator, waitBy);
        this.linkAutoCompleteFirstValue = new Link(autoCompleteFirstValueLocator.format(new Object[0]));
        this.innerTextBox = (new TextBox(locator, waitBy)).applyConfiguration(innerTextBoxConfigurationFileName);
    }

    public void setRawValue(String value) {
        this.innerTextBox.setValue(value);
        if (!value.isEmpty()) {
            this.linkAutoCompleteFirstValue.waitFor(timeout, BaseElement::isPresent);
            this.linkAutoCompleteFirstValue.click();
        }
    }

    public void setRawValue(String value, String fullValue) {
        this.innerTextBox.setValue(value);
        Link valueToSelect = new Link(templateAutoCompleteBoxFullValueLocatorXpath.format(new Object[]{fullValue}));
        valueToSelect.waitFor(timeout, BaseElement::isPresent);
        valueToSelect.click();
    }

    public void setRawValue(String value, int index) {
        this.innerTextBox.setValue(value);
        Link valueToSelect = new Link(templateAutoCompleteBoxIndexValueLocator.format(new Object[]{index}));
        valueToSelect.waitFor(timeout, BaseElement::isPresent);
        valueToSelect.click();
    }

    public String getRawValue() {
        return (String) this.innerTextBox.getValue();
    }

    public TextBox getInnerTextBox() {
        return this.innerTextBox;
    }

    public Link getLinkAutoCompleteFirstValue() {
        return this.linkAutoCompleteFirstValue;
    }

    static {
        ClassConfigurator configurator = new ClassConfigurator(AutoCompleteBox.class);
        configurator.applyConfiguration();
    }
}