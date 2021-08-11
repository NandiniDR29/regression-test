package com.exigen.dxp.employee.providertab;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestFindProvider extends DXPBaseTest {
@Test(priority = 16)
    public void  testFindProvider() throws IOException {
    logger=  extent.startTest("TestFindProvider");
    FindProviderPage findProviderPage = new FindProviderPage(driver);
    reportLog("Select to Find Provider",0);
    findProviderPage.clickOnFindProvider();
    reportLog("Verify Url",1);
    findProviderPage.verifyPageTitle();
    reportLog("============",1);

}
}
