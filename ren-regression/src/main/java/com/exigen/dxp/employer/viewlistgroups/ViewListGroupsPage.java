package com.exigen.dxp.employer.viewlistgroups;

import com.exigen.dxp.DXPBaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.exigen.dxp.DXPBaseTest.highLighterMethod;
import static com.exigen.dxp.DXPBaseTest.reportLog;
import static com.exigen.dxp.DxpCommonMethods.toFailScenarios;

public class ViewListGroupsPage {
    WebDriver driver;

    @FindBy(xpath = "//a[@class='logo_37V_-_y7']")
    private WebElement logo;

    @FindBy(xpath = "(//span)[6]")
    private WebElement groupNum;

    @FindBy(xpath = "//img[@alt='View Master Policies'][1]")
    private WebElement clickMP;

    @FindBy(xpath = "//tr[@class='row_3dW8Y_Hg']/td[1]")
    private List<WebElement> mps;

    @FindBy(xpath = "//tr[@class='row_3dW8Y_Hg']/td[2]")
    private List<WebElement> bills;

    @FindBy(xpath = "//a[@class='link_3qISTjRh sizeSmall_RvwMPdre']")
    private WebElement back;

    //View class
    @FindBy(xpath = "(//a[@class='actionButton_3AMp9Sxj'])[3]")
    private WebElement viewEnrolles;

    @FindBy(xpath = "(//a[@class='actionButton_3AMp9Sxj'])[3]")
    private WebElement viewProds;

    @FindBy(xpath = "(//div[@class='itemImage_2xfsTfJX'])[1]")
    private WebElement prodClick;

    @FindBy(xpath = "//a[@class='actionButton_3AMp9Sxj'][1]")
    private WebElement viewDetails;

    @FindBy(xpath = "(//a[@class='item_3LVDELaP'])[2]")
    private WebElement viewCoverages;

    @FindBy(xpath = "//a[@class='actionButton_3AMp9Sxj'][1]")
    private WebElement coveragesDetails;

    @FindBy(xpath = "//tbody[@class='body_gCX5UN3K']/tr[2]/td[1]")
    private WebElement classText;

    @FindBy(xpath = "//tbody[@class='body_gCX5UN3K']/tr[2]/td[2]")
    private WebElement classValue;

    @FindBy(xpath = "//a[@class='button_38Idm0Jo']")
    private WebElement close;

    @FindBy(xpath = "//h2")
    private WebElement headerTitle;

    @FindBy(xpath = "//h1")
    private WebElement coverageHeaderTitle;


    public ViewListGroupsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
    }

    public void clickOnRenLogo(){
        highLighterMethod(logo);
        logo.click();
    }

    public void getMasterPolicyDetails() throws InterruptedException, IOException {

        DXPBaseTest.highLighterMethod(clickMP);
        clickMP.click();

        Assert.assertEquals(headerTitle.getText(),"Master Policies");

        String str=groupNum.getText();
        String str1=str.substring(1);
        DXPBaseTest.reportLog("Group number : "+ str1 +" has below master policies",1);

        if(mps.size()>0) {
            for (int i = 0; i < mps.size(); i++) {
                DXPBaseTest.reportLog(mps.get(i).getText(), 1);
            }
        }else{
            toFailScenarios("Master policy numbers are not displayed ");
        }
    }

    public void getBillingAccountNumbers() throws IOException {
        String str=groupNum.getText();
        String str1=str.substring(1);

        back.click();

        Assert.assertEquals(headerTitle.getText(),"Groups");

        DXPBaseTest.reportLog("Group number : "+ str1 +" has below Billing accounts",1);
        if(bills.size()>0) {
            for (int i = 0; i < bills.size(); i++) {
                DXPBaseTest.reportLog(bills.get(i).getText(), 1);
            }
        }else{
            toFailScenarios("Billing account numbers are not displayed ");
        }
    }

    public void getClassName(){
        DXPBaseTest.highLighterMethod(viewEnrolles);
        viewEnrolles.click();

        DXPBaseTest.highLighterMethod(viewProds);
        viewProds.click();

        DXPBaseTest.highLighterMethod(prodClick);
        prodClick.click();

        DXPBaseTest.highLighterMethod(viewDetails);
        viewDetails.click();

        DXPBaseTest.highLighterMethod(viewCoverages);
        viewCoverages.click();

        DXPBaseTest.highLighterMethod(coveragesDetails);
        coveragesDetails.click();

        Assert.assertEquals(coverageHeaderTitle.getText(),"Coverage Information");

        reportLog(classText.getText()+" : "+ classValue.getText(),1);

        DXPBaseTest.highLighterMethod(close);
        close.click();
    }

}
