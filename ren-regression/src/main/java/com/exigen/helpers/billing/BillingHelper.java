/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.helpers.billing;

import com.exigen.ipb.eisa.utils.Currency;

public final class BillingHelper {
    public static final String ZERO = new Currency(0).toString();
    public static final Currency DZERO = new Currency(0);
    public static final Currency INSTALLMENT_FEE = new Currency(5);
    public static final Currency PAYMENT_DECLINE_FEE = new Currency(7);
    public static final Currency CANCEL_NOTICE_FEE = new Currency(10);
    public static final Currency CANCELLATION_FEE = new Currency(15);
    public static final Currency REINSTATEMENT_FEE_WITHOUT_LAPSE = new Currency(20);
    public static final Currency REINSTATEMENT_FEE_WITH_LAPSE = new Currency(25);
    public static final Currency OFFER_WITHOUT_LAPSE = new Currency(30);


    private BillingHelper() {
    }

}
