package com.exigen.dxp.employee.providertab;

import com.exigen.dxp.DxpCommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;

import static com.exigen.dxp.DXPBaseTest.driver;
import static com.exigen.dxp.DXPBaseTest.highLighterMethod;

public class FindProviderPage {
    String parentTab;
    @FindBy(xpath = "//a[text()='FIND PROVIDER']")
    private WebElement findProvider;

    public FindProviderPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    public void clickOnFindProvider(){
        highLighterMethod(findProvider);
        parentTab = driver.getWindowHandle();
        findProvider.click();
    }
    public void verifyPageTitle() throws IOException {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        tabs.remove(parentTab);
        for (String tab:tabs) {
            driver.switchTo().window(tab);
            String url = driver.getCurrentUrl();
            if (url.contains("https://www.myrenproviders.com/")){
                DxpCommonMethods.informationPrint("Navigated to : " +url);
            }
            else {
                DxpCommonMethods.toFailScenarios(url+"not Matching");
            }
            driver.close();
        }
        driver.switchTo().window(parentTab);
    }
}
