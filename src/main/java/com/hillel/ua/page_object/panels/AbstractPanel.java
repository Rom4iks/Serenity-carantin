package com.hillel.ua.page_object.panels;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.webdriver.WebDriverAdaptor;
import lombok.Getter;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.locators.SmartElementLocatorFactory;
import net.thucydides.core.annotations.locators.SmartFieldDecorator;
import net.thucydides.core.webdriver.MobilePlatform;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@Getter
public abstract class AbstractPanel {

    private long waitForTimeoutInMilliseconds = 5000;
    private AbstractPage driverDelegate;
    private WebDriverAdaptor panelToWebDriver;

    public AbstractPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        initPanel(panelBaseLocation, driverDelegate);
    }

    private void initPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        this.driverDelegate = driverDelegate;
        waitForTimeoutInMilliseconds = driverDelegate.waitForTimeoutInMilliseconds();
        panelToWebDriver = new WebDriverAdaptor(panelBaseLocation, getDriver());
        final ElementLocatorFactory finder = new SmartElementLocatorFactory(panelToWebDriver, MobilePlatform.NONE);
        final FieldDecorator decorator = new SmartFieldDecorator(finder, getDriver(), driverDelegate);
        PageFactory.initElements(decorator, this);
    }

    public WebElementFacade findBy(final String locator) {
        return driverDelegate.findBy(locator);
    }

    public List<WebElementFacade> findAll(final String locator) {
        return driverDelegate.findAll(locator);
    }
}
