/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.cms.templatemanagment.doctemplates.tabs;

import com.exigen.ren.admin.modules.cms.templatemanagment.doctemplates.metadata.RefreshTemplateMetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;

public class RefreshTemplateTab extends DefaultTab {
    public RefreshTemplateTab() {
        super(RefreshTemplateMetaData.class);
    }

    @Override
    public Tab submitTab() {
        return this;
    }
}
