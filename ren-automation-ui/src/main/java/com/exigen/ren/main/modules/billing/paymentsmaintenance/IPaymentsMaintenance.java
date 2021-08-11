/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.billing.paymentsmaintenance;

import com.exigen.ren.common.EntityService;
import com.exigen.ren.main.modules.billing.paymentsmaintenance.actions.*;

public interface IPaymentsMaintenance extends EntityService {
    AddBulkPaymentAction addBulkPayment();

    AddSuspenseAction addSuspense();

    ClearSuspenseAction clearSuspense();

    ClearSuspenseGBAction clearSuspenseGB();

    AddPaymentBatchAction addPaymentBatch();

    ViewSuspenseAction viewSuspense();

}