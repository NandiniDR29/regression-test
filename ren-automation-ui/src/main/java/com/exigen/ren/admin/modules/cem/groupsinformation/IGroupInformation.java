/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.cem.groupsinformation;

import com.exigen.istf.data.TestData;
import com.exigen.ren.common.EntityService;
import com.exigen.ren.common.Workspace;

public interface IGroupInformation extends EntityService {

    Workspace getDefaultWorkspace();

    void create(TestData td);

    void initiate();

}
