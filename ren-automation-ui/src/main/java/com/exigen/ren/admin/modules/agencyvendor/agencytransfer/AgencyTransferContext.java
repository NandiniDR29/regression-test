/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.agencytransfer;

import com.exigen.ren.admin.modules.agencyvendor.agencytransfer.tabs.AgencyTransferTab;
import com.exigen.ren.common.AutomationContext;

public interface AgencyTransferContext {
    AgencyTransfer agencyTransfer = AutomationContext.getService(AgencyTransfer.class);
    AgencyTransferTab agencyTransferTab = agencyTransfer.getDefaultWorkspace().getTab(AgencyTransferTab.class);
}
