package com.exigen.ren.main.modules.policy.common.pages.certificate;

import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.ren.common.pages.MainPage;
import org.openqa.selenium.By;

public class CertificatePolicyPage extends MainPage {

    public static StaticElement labelEffectiveDate = new StaticElement(By.xpath("//span[@id='policyDataGatherForm:sedit_GroupCertificatePolicy_contractTerm_effectivePopup']/input"));
    public static StaticElement labelBillingLocation = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificatePolicy_policyDetail_billingLocation"));

}