package com.exigen.modules.policy.gb_ac.masterpolicy.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioButton;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class PlanDefinitionIssueActionTabMetaData extends MetaData  {
//    PlanDefinitionIssueActionTabMetaData()
//    {
//        WebDriver driver = CommonBaseTest.driver;
//        driver.findElement(By.xpath("//input[@id='policyDataGatherForm:sedit_PreconfigGroupEligibility_minHourlyReq']")).sendKeys("40");
//      //  driver.findElement(By.xpath("//input[@id='policyDataGatherForm:sedit_PreconfigGroupEligibility_minHourlyReq']")).sendKeys("40");
//        Select select = new Select(driver.findElement(By.xpath("//select[@id='policyDataGatherForm:sedit_PreconfigGroupEligibility_waitingPeriod']")));
//        select.selectByValue("None");
//        driver.findElement(By.xpath("//input[@id='policyDataGatherForm:sedit_PreconfigGroupEligibility_waitingPeriodWaived:1']")).click();
//    }
    public static final AssetDescriptor<TextBox> MINIMUM_HOURLY_REQUIREMENT = declare("Minimum Hourly Requirement (hours per week)", TextBox.class);
    public static final AssetDescriptor<ComboBox> ELIGIBILITY_WAITING_PERIOD_DEFINITION = declare("Eligibility Waiting Period Definition", ComboBox.class);
    public static final AssetDescriptor<RadioButton> Waiting_Period_Waived_For_Current_Employees=declare("Waiting Period Waived For Current Employees?", RadioButton.class);
    public static final AssetDescriptor<ComboBox> WAITING_PERIOD_MODE = declare("Waiting Period Mode", ComboBox.class);
    public static final AssetDescriptor<TextBox> WAITING_PERIOD = declare("Waiting Period", TextBox.class);
    public static final AssetDescriptor<TextBox> WAITING_PERIOD_AMOUNT = declare("Waiting Period Amount", TextBox.class);

}
