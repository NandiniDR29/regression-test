package com.exigen.ren.main.pages.summary.claim;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.ren.main.pages.summary.SummaryPage;
import org.openqa.selenium.By;

public class ClaimFinancialsPage extends SummaryPage {

    public static final Button buttonBalance = new Button(By.id("productConsolidatedViewForm:updateBalanceClaimsDentalPaymentRoot"));
    public static final Button buttonPostRecovery = new Button(By.id("productConsolidatedViewForm:postRecoveryClaimsDentalPaymentRoot"));
}
