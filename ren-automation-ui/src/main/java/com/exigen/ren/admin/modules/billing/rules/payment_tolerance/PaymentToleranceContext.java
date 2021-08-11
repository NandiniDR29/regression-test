/* Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent. */
package com.exigen.ren.admin.modules.billing.rules.payment_tolerance;

import com.exigen.ren.common.AutomationContext;

public interface PaymentToleranceContext {
    PaymentTolerance paymentTolerance = AutomationContext.getService(PaymentTolerance.class);
}