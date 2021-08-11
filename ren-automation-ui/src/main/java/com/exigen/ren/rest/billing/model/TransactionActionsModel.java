/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.ren.rest.billing.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;

public class TransactionActionsModel extends Model {
    public String actionCd;

    public String getActionCd() {
        return actionCd;
    }

    public TransactionActionsModel setActionCd(String actionCd) {
        this.actionCd = actionCd;
        return this;
    }
}
