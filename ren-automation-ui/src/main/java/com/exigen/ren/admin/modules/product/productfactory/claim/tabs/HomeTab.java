/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.product.productfactory.claim.tabs;

import com.exigen.ipb.eisa.controls.productfactory.custom.PFButton;
import com.exigen.ren.admin.modules.product.productfactory.DefaultTab;
import org.openqa.selenium.By;

/**
 * @author ikisly
 */
public class HomeTab extends DefaultTab {

    public static final PFButton btnActivate = new PFButton(By.xpath("//button[@title='Activate']"));
    public static final PFButton btnDeactivate = new PFButton(By.xpath("//button[@title='Deactivate']"));
    public static final PFButton buttonActivateAnyWay = new PFButton(By.id("lookupErrorForm:deploy-anyway"));

    public HomeTab deactivateProduct() {
        open();
        if (btnDeactivate.isPresent() && btnDeactivate.isVisible()) {
            btnDeactivate.click();
        }
        return this;
    }

    public HomeTab activateProduct() {
        open();
        btnActivate.click();
        if (buttonActivateAnyWay.isPresent() && buttonActivateAnyWay.isVisible()) {
            buttonActivateAnyWay.click();
        }
        return this;
    }

    @Override
    protected String tabName() {
        return "Home";
    }
}
