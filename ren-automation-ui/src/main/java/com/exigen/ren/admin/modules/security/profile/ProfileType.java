/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.security.profile;

public enum ProfileType {
    CORPORATE("Corporate"),
    AGENCY("Agency"),
    VENDOR("Vendor");

    private String channelType;

    ProfileType(String channelType) {
        this.channelType = channelType;
    }

    public String get() {
        return this.channelType;
    }

}
