package com.exigen.ren.main.modules.claim.common.actions;

import com.exigen.istf.config.ClassConfigurator;
import com.exigen.istf.config.HasConfiguration;
import com.exigen.istf.utils.meters.WaitMeters;
import com.exigen.istf.webdriver.controls.AbstractEditableStringElement;
import com.exigen.istf.webdriver.controls.BaseElement;
import com.exigen.istf.webdriver.controls.HighlightableElement;
import com.exigen.istf.webdriver.controls.strategies.TextInputStrategy;
import com.exigen.istf.webdriver.controls.strategies.impl.DefaultTextInputStrategy;
import com.exigen.istf.webdriver.controls.waiters.Waiter;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;

public class TextBoxtest extends AbstractEditableStringElement implements HighlightableElement, HasConfiguration {
    private ClassConfigurator config;
    @ClassConfigurator.Configurable(
            byClassName = true
    )
    private static TextInputStrategy textInputStrategyDefault = new DefaultTextInputStrategy();
    @ClassConfigurator.Configurable(
            byClassName = true
    )
    private TextInputStrategy textInputStrategy;

    public TextBoxtest(By locator) {
        this(locator, Waiters.DEFAULT);
    }

    public TextBoxtest(By locator, Waiter waiter) {
        this((BaseElement)null, locator, waiter);
    }

    public TextBoxtest(BaseElement<?, ?> parent, By locator) {
        this(parent, locator, Waiters.DEFAULT);
    }

    public TextBoxtest(BaseElement<?, ?> parent, By locator, Waiter waiter) {
        super(parent, locator, waiter);
        this.textInputStrategy = textInputStrategyDefault;
        this.config = new ClassConfigurator(this);
    }

    public com.exigen.istf.webdriver.controls.TextBox applyConfiguration(String configurationName) {
        return (com.exigen.istf.webdriver.controls.TextBox)this.config.applyConfiguration(configurationName);
    }

    protected void setRawValue(String value) {
        this.getTextInputStrategy().setValue(this, value);
        WaitMeters.capture("PAGE_LOAD");
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.waitForPageUpdate();
    }

    protected String getRawValue() {
        return this.getAttribute("value").trim();
    }

    protected TextInputStrategy getTextInputStrategy() {
        return this.textInputStrategy;
    }

    static {
        ClassConfigurator configurator = new ClassConfigurator(com.exigen.istf.webdriver.controls.TextBox.class);
        configurator.applyConfiguration();
    }
}

