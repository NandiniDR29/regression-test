/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.billing.account.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.main.modules.billing.account.metadata.DeclinePaymentActionTabMetaData;
import org.openqa.selenium.By;

public class DeclinePaymentActionTab extends ActionTab {
    public static TableExtended<PaymentDetails> tablePaymentDetails = new TableExtended<>("Payment Details", By.xpath("//div[@id='declinePaymentReasonForm:billing_payments_active']//table"));

    public DeclinePaymentActionTab() {
        super(DeclinePaymentActionTabMetaData.class);
    }


    public enum PaymentDetails implements Named {

        PAYMENT_METHOD("Payment Method"),
        REFERENCE("Reference #"),
        AMOUNT("Amount"),
        INVOICE("Invoice");
        private String name;

        PaymentDetails(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
