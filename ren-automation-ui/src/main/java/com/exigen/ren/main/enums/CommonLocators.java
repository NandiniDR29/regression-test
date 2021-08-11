package com.exigen.ren.main.enums;

import com.exigen.istf.webdriver.ByT;

public class CommonLocators {

    private CommonLocators() {
    }

    public static final ByT COMMON_LABEL_WITH_TEXT_LOCATOR = ByT.xpath("//*[normalize-space(text())=\"%s\"]");
    public static final ByT COMMON_LOCATOR_GET_VALUE_BY_LABEL = ByT.xpath("//label[text() = '%s']/parent::td/following-sibling::td");
    public static final ByT COMMON_LINK_WITH_TEXT_LOCATOR = ByT.xpath("//a[contains (text(), '%s')]");
}