/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.webstudio.pages;

import com.exigen.istf.webdriver.controls.waiters.JSWaiter;
import com.exigen.istf.webdriver.controls.waiters.Waiter;

public abstract class WebStudioAbstractPage {
    protected static Waiter wsWaiter = new JSWaiter("return (document.getElementById('loadingPanel').getAttribute('style') ==='display: none;' || document.getElementById('loadingPanel').getAttribute('style') ==='display: none');");

}
