package com.socio.pages.platform;

import com.socio.pages.BasePage;
import com.socio.pages.platform.event.MyEventsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "event-app-nav")
    private WebElement eventAppNavLink;

    @FindBy(xpath = "//a[@title='My Events']")
    private WebElement myEventsNavLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SignupPage goToHomePageAndRedirectToSignUp() {
        driver.navigate().to("https://staging.platform.socio.events/");
        return new SignupPage(driver);
    }

    public MyEventsPage navigateToMyEvents() {
        waitForElementToBePresent(eventAppNavLink);
        eventAppNavLink.click();

        waitForElementToBePresent(myEventsNavLink);
        myEventsNavLink.click();

        return new MyEventsPage(driver);
    }

}
