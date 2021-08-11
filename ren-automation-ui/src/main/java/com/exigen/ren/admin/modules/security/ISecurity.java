/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.security;

import com.exigen.ren.admin.modules.IAdmin;
import com.exigen.ren.common.Action;

public interface ISecurity extends IAdmin {

    void initiate();

    Action update();
}
