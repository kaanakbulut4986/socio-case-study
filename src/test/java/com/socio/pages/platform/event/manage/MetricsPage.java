package com.socio.pages.platform.event.manage;

import com.socio.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MetricsPage extends BasePage {

    @FindBy(xpath = "//li[a[text()='Web App']]")
    private WebElement webAppNavLink;

    public MetricsPage(WebDriver driver) {
        super(driver);
    }

    public WebAppPage clickWebApp() throws InterruptedException {

        waitForElementToBePresent(webAppNavLink, 1000);
        webAppNavLink.click();

        return new WebAppPage(driver);
    }
}
