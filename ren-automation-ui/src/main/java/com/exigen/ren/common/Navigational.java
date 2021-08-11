/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.common;

import com.exigen.istf.exceptions.IstfException;
import com.exigen.ren.common.pages.NavigationPage;

/**
 *Interface for navigation to tab.
 *Concrete realization of a Tab has to override methods navigate() and isTabSelected()
 */

public interface Navigational {

    default Tab navigate() {
        throw new IstfException(String.format("navigate() method was not implemented for [%1$s]", this.getClass().getSimpleName()));
    }

    default boolean isTabSelected() {
        return NavigationPage.PolicyNavigation.isLeftMenuTabSelected(this.getTabName());
    }

    default String getTabName() {
        throw new IstfException(String.format("getTabName() method was not implemented for [%1$s]", this.getClass().getSimpleName()));
    }
}
