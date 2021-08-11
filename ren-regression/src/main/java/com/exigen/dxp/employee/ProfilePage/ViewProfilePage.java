package com.exigen.dxp.employee.ProfilePage;

import com.exigen.dxp.DXPBaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.exigen.dxp.DXPBaseTest.highLighterMethod;
import static com.exigen.dxp.DXPBaseTest.reportLog;
import static com.exigen.dxp.DxpCommonMethods.toFailScenarios;

public class ViewProfilePage {
    WebDriver driver;

    @FindBy(xpath = "//a[@class='logo_37V_-_y7']")
    private WebElement logo;

    @FindBy(xpath = "//div[contains(@class,'userTitle_2zvaJ17E')]")
    private WebElement dropDown;

    @FindBy(xpath = "//a[contains(@class,'button_2X_Irl-V')]")
    private WebElement viewProfile;

    @FindBy(xpath = "//div[contains(@class,'tabs_3ZHPWkCh')]/a/span")
    private List<WebElement> profileHeader;

    @FindBy(xpath = "(//a[contains(@class,'item_3LVDELaP')])[1]")
    private WebElement personalInfo;

    @FindBy(xpath = "(//a[contains(@class,'item_3LVDELaP')])[2]")
    private WebElement salaryInfo;

    @FindBy(xpath = "(//a[contains(@class,'item_3LVDELaP')])[3]")
    private WebElement contactInfo;

    @FindBy(xpath = "(//a[contains(@class,'item_3LVDELaP')])[4]")
    private WebElement idCardInfo;

    @FindBy(xpath = "//span[contains(@class,'subtitle_GGgycJev')]")
    private WebElement subscriber;

    @FindBy(xpath = "//h3[contains(@class,'title_1tilYihX')]")
    private WebElement subscriberid;

    @FindBy(xpath = "//div[contains(@class,'inlineWrapper_3FpYDiXN')]/div/label")
    private List<WebElement> details;

    @FindBy(xpath = "//div[contains(@class,'inlineWrapper_2ml5KEVI')]/div/label")
    private List<WebElement> salaryHeader;

    @FindBy(xpath = "//div[contains(@class,'inlineWrapper_184osVB8')][1]/div/label")
    private List<WebElement> contactInformation1;

    @FindBy(xpath = "(//div[@class='inlineWrapper_184osVB8']/div/label)[4]")
    private WebElement city;

    @FindBy(xpath = "(//div[@class='childrenWrapper_1xEI7V3B']/input)[4]")
    private WebElement cityName;

    @FindBy(xpath = "(//div[@class='inlineWrapper_184osVB8']/div/label)[5]")
    private WebElement state;

    @FindBy(xpath = "(//div[@class='childrenWrapper_1xEI7V3B'])[5]/div/input")
    private WebElement stateCode;

    @FindBy(xpath = "(//div[@class='inlineWrapper_184osVB8']/div/label)[6]")
    private WebElement zipText;

    @FindBy(xpath = "(//div[@class='childrenWrapper_1xEI7V3B']/input)[5]")
    private WebElement zipCode;

    @FindBy(xpath = "(//div[@class='inlineWrapper_184osVB8']/div/label)[7]")
    private WebElement county;

    @FindBy(xpath = "(//div[@class='childrenWrapper_1xEI7V3B']/input)[6]")
    private WebElement countyValue;

    @FindBy(xpath = "//input[contains(@class,'text_1R34AydU')]")
    private List<WebElement> indetails;

    @FindBy(xpath = "//div[@class='inlineWrapper_2IST8r4t']/div/label")
    private List<WebElement> contactDetails;

    @FindBy(xpath = "//div[@class='inlineWrapper_2IST8r4t']//div[@class='childrenWrapper_1xEI7V3B']/input")
    private List<WebElement> contactDetailsVal;

    @FindBy(xpath = "//div[@class='radio_1oIKWEXY']")
    private List<WebElement> radioButtons;

    @FindBy(xpath = "(//button[@class='button_2X_Irl-V'])[2]")
    private WebElement printAll;

    @FindBy(xpath = "//h2")
    private WebElement headerTitle;

    public ViewProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickOnRenLogo(){
        highLighterMethod(logo);
        logo.click();
    }

    public void verifyProfile()
    {
        highLighterMethod(dropDown);
        dropDown.click();

        highLighterMethod(viewProfile);
        viewProfile.click();

        Assert.assertEquals(headerTitle.getText(),"My Profile");

        for (int i = 0; i < profileHeader.size(); i++)
        {
            reportLog(profileHeader.get(i).getText(), 1);
        }
        reportLog(subscriber.getText() + " : " + subscriberid.getText(), 1);
    }

    public void personalInformation()
    {

        //Printing personal information
        for (int i = 0; i < details.size(); i++) {
            details.get(i).getText();
            System.out.println(details.get(i).getText() + " : " + indetails.get(i).getAttribute("value"));
            reportLog(details.get(i).getText() + " : " + indetails.get(i).getAttribute("value"), 1);
        }
    }

    public void salaryInformation()
    {
        highLighterMethod(salaryInfo);
        salaryInfo.click();
        //Printing salary information
        for (int i = 0; i < salaryHeader.size(); i++) {
            salaryHeader.get(i).getText();
            System.out.println(salaryHeader.get(i).getText() + " : " + indetails.get(i).getAttribute("value"));
            reportLog(salaryHeader.get(i).getText() + " : " + indetails.get(i).getAttribute("value"), 1);
        }
    }

    public void addressInformation() throws IOException {
        highLighterMethod(contactInfo);
        contactInfo.click();
        //Printing address information
        for(int i = 0; i< contactInformation1.size(); i++){
            reportLog(contactInformation1.get(i).getText()+":"+indetails.get(i).getAttribute("value"),1);
        }
        //Printing City,State,Zipcode and County details
        reportLog(city.getText()+":"+ cityName.getAttribute("value"),1);
        reportLog(state.getText()+":"+ stateCode.getAttribute("value"),1);
        reportLog(zipText.getText()+":"+ zipCode.getAttribute("value"),1);
        reportLog(county.getText()+":"+ countyValue.getAttribute("value"),1);
        //printing Mail and Phone number
        for(int i = 0; i< contactDetails.size(); i++){
            reportLog(contactDetails.get(i).getText()+":"+ contactDetailsVal.get(i).getAttribute("value"),1);
        }

        ArrayList<Boolean> radiobutton=new ArrayList<Boolean>();
        //Validating of radio buttons
        for(int i = 0; i< radioButtons.size(); i++) {
            try {
                if (radioButtons.get(i).isDisplayed()) {
                    radiobutton.add(true);
                }
            }
            catch(Exception e)
            {
                radiobutton.add(false);
            }
        }
        if(radiobutton.contains(false))
            toFailScenarios("Contact prefrences radio buttons are not displayed");
        else
            reportLog("Contact prefrences radio buttons are displayed", 1);
    }

    public void printIdCard() throws InterruptedException {
        reportLog("Print Id cards",1);
        highLighterMethod(idCardInfo);
        idCardInfo.click();

        highLighterMethod(printAll);
        try {
            DXPBaseTest.js.executeScript("arguments[0].click();", printAll);
        }catch (Exception e){
            driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString()).navigate().refresh();
        }
    }
}
