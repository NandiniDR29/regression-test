/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.cem.groupsinformation.tabs;

import com.exigen.ren.admin.modules.cem.groupsinformation.metadata.GroupsInformationMetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;

public class GroupsInformationTab extends DefaultTab {

    public GroupsInformationTab() {
        super(GroupsInformationMetaData.class);
    }

    @Override
    public Tab submitTab() {
        return this;
    }
}
