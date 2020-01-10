package com.hillel.ua.page_object.pages;

import com.hillel.ua.page_object.panels.HeaderPanel;
import org.openqa.selenium.WebDriver;

public class SportchekMainPage extends AbstractPage {

    private static final String HEADER_LOCATOR = "//header[@class='page-header']";

    public SportchekMainPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public HeaderPanel getHeaderPanel() {
        return new HeaderPanel(findBy(HEADER_LOCATOR), this);
    }
}
