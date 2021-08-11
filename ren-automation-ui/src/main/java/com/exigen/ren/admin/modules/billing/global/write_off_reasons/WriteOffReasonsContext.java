/* Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent. */
package com.exigen.ren.admin.modules.billing.global.write_off_reasons;

import com.exigen.ren.common.AutomationContext;

public interface WriteOffReasonsContext {
    WriteOffReasons writeOffReason = AutomationContext.getService(WriteOffReasons.class);
}