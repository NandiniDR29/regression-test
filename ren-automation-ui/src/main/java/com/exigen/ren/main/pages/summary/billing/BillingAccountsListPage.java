/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.pages.summary.billing;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.ren.common.enums.NavigationEnum.AppMainTabs;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.pages.summary.SummaryPage;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;

import java.util.regex.Pattern;

public class BillingAccountsListPage extends SummaryPage {

    public static StaticElement labelBillingAccountName = new StaticElement(By.xpath("//*[@id='billingInfoForm']/div/table/tbody/tr[1]/td[1]//div[2]/span"));
    public static StaticElement labelBillingAccountStatus = new StaticElement(By.id("billingInfoForm:accountStatus"));
    public static StaticElement labelNoRecordsMessage = new StaticElement(By.id("billingAccountListForm:noRecordsMessage"));
    public static Link linkBillingAccountStatus = new Link(By.id("billingInfoForm:accountStatusLink"));
    public static TableExtended<TableConstants.BillingBenefitsAccounts> tableBenefitAccounts = new TableExtended<>("Benefits Accounts", By.xpath("//div[@id='billingAccountListForm:group_billing_account_list_table' or @id='billingInfoForm:header_panel']//table"));
    public static ComboBox comboBoxFilterByPolicy = new ComboBox(By.id("quoteForm:filterBillingAccountViews"));

    public static void open() {
        NavigationPage.toMainTab(AppMainTabs.BILLING);
    }

    public static String getAccountNumber() {
        String accountNumber = new StaticElement(By.xpath("//table[@id='billingInfoForm:grid']//span[@title]")).getValue();
        return Pattern.compile("(\\d{5})").matcher(accountNumber).matches() ? accountNumber :
                accountNumber.replaceFirst("(\\d{5})\\s\\/\\s(.*)", "$1");
    }

    public static void openAccountByName(String name) {
        BillingAccountsListPage.tableBenefitAccounts.getRow(ImmutableMap.of(TableConstants.BillingBenefitsAccounts.BILLING_ACCOUNT_NAME.getName(), name))
                .getCell(TableConstants.BillingBenefitsAccounts.BILLING_ACCOUNT.getName()).controls.links.getFirst().click();
    }

    public static void openAccountByNumber(String number) {
        BillingAccountsListPage.open();
        BillingAccountsListPage.tableBenefitAccounts.getRow(ImmutableMap.of(TableConstants.BillingBenefitsAccounts.BILLING_ACCOUNT.getName(), number))
                .getCell(TableConstants.BillingBenefitsAccounts.BILLING_ACCOUNT.getName()).controls.links.getFirst().click();
    }
}
