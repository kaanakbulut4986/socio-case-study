package com.socio.pages.platform.event;

import com.socio.pages.BasePage;
import com.socio.pages.platform.event.manage.MetricsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyEventsPage extends BasePage {

    @FindBy(xpath = "//div[h3[text()='Test Automation Assessment Event']]")
    private WebElement eventLink;

    public MyEventsPage(WebDriver driver) {
        super(driver);
    }

    public MetricsPage clickEvent() throws InterruptedException {

        waitForElementToBePresent(eventLink, 1000);
        eventLink.click();

        return new MetricsPage(driver);
    }
}
