package com.exigen.modules.policy.gb_dn.certificatepolicy;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static com.exigen.helpers.CommonGenericMethods.createTaxId;

public class CertificatePolicyHelpers {
    public static String selfInsuredFirstName="John";
    public static String selfInsuredLastName="Smith";
    public static String selfOneSpouseInsuredFirstName="Brian";
    public static String selfOneSpouseInsuredLastName="Cox";
    public static String selfOneChildInsuredFirstName="Amy";
    public static String selfOneChildInsuredLastName="Hall";
    public static String spouseInsuredFirstName="James";
    public static String spouseInsuredLastName="Brown";
    public static String childInsuredFirstName="Richard";
    public static String childInsuredLastName="Davis";
    public static String familyInsuredFirstName="Mark";
    public static String familyInsuredLastName= "Lee";
    public  static void ssnValidation(WebDriver driver){
        List<WebElement> ssnError = driver.findElements(By.xpath("//div[@class='error-container']//span//span[@id='policyDataGatherForm:sedit_GroupCertificatePrimaryParticipantPersonInfoProxy_person_legalIdentification_error']"));
        Actions act = new Actions(driver);
        if(ssnError.size()>0){
            CommonGenericMethods.informationPrint("SSN Error Exists, Please Update New SSN");
            WebElement view;
            WebElement taxID = null;
            while (ssnError.size()>0){
             view = driver.findElement(By.xpath("//span[text()='View']"));
            if(ssnError.get(0).getText().equalsIgnoreCase("Subscriber SSN update should not be updated if new SSN belongs to other primary insured/customer.")){
                CommonBaseTest.js.executeScript("arguments[0].scrollIntoView();", view);
                view.click();
                taxID = driver.findElement(By.xpath("//input[@id='policyDataGatherForm:sedit_GroupCertificatePrimaryParticipantPersonInfoProxy_person_legalIdentification']"));
                act.pause(5000).perform();
                CommonGenericMethods.informationPrint("Error SSN is: "+taxID.getText());
                act.moveToElement(taxID).click().sendKeys(Keys.chord(Keys.CONTROL,"a")).perform();
                act.moveToElement(taxID).sendKeys(Keys.BACK_SPACE).perform();
                act.moveToElement(taxID).sendKeys(createTaxId()).perform();
                CommonBaseTest. js.executeScript("arguments[0].click();",  driver.findElement(By.xpath("//input[@id='policyDataGatherForm:next_footer']")));
                ssnError = driver.findElements(By.xpath("//div[@class='error-container']//span//span[@id='policyDataGatherForm:sedit_GroupCertificatePrimaryParticipantPersonInfoProxy_person_legalIdentification_error']"));
            }}
            CommonGenericMethods.informationPrint("Update SSN is "+taxID.getText());

        }
        else {
            CommonGenericMethods.informationPrint("SSN Error Not Exists, Proceed further");


        }
    }

}
