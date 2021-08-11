/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.webstudio.pages;

import com.exigen.istf.webdriver.controls.Button;
import org.openqa.selenium.By;


public class WelcomePage extends WebStudioAbstractPage{
    private static final Button buttonConfirm = new Button(By.xpath("//input[@value='Start' or @value='Finish' or @value='Next']"), wsWaiter);

    public static void confirm() {
        while (buttonConfirm.isPresent()) {
            buttonConfirm.click();
        }
    }
}
