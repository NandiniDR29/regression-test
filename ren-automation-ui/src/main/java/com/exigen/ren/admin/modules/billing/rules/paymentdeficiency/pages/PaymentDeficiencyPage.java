/* Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent. */
package com.exigen.ren.admin.modules.billing.rules.paymentdeficiency.pages;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.CheckBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.admin.modules.common.pages.AdminPage;
import com.exigen.ren.main.enums.TableConstants;
import org.openqa.selenium.By;

public class PaymentDeficiencyPage extends AdminPage {
    private static AssetList assetListCreatePaymentDeficiency  = new AssetList(By.id("paymentDeficiencyForm"), PaymentDeficiencyTab.class);
    public static final TableExtended<TableConstants.BillingPaymentDeficiency> tableBillingPaymentDeficiency
            = new TableExtended<>("Billing Payment Deficiency", By.id("paymentDeficiencyResultForm:paymentDeficiencyTable"));
    public static final Button buttonAddUpdate = new Button(By.id("paymentDeficiencyForm:addUpdateBtn_footer"));

    public static void createPaymentDeficiency(TestData td) {
        assetListCreatePaymentDeficiency.fill(td);
    }

    public static class PaymentDeficiencyTab extends MetaData {
        public static final AssetDescriptor<CheckBox> DIRECT = declare("Direct", CheckBox.class, By.id("paymentDeficiencyForm:billType:0"));
        public static final AssetDescriptor<CheckBox> ENABLE_PAYMENT_DEFICIENCY = declare("Enable Payment Deficiency", CheckBox.class);
    }
}
