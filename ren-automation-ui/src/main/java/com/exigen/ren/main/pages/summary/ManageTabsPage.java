/* Copyright © 2018 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.pages.summary;

import com.exigen.istf.webdriver.ByT;
import com.exigen.istf.webdriver.controls.Button;

public class ManageTabsPage {

	private static final ByT CLOSE_TAB_BUTTON_TEMPLATE = ByT.id("actionForm_%1$d:closeBtn_%1$d");

	public static void closeTab(int tabNum) {
		new Button(CLOSE_TAB_BUTTON_TEMPLATE.format(tabNum-1)).click();
	}
}
