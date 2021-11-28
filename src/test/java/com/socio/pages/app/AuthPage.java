package com.socio.pages.app;

import com.socio.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "continue-button")
    private WebElement continueButton;

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage authWith(String email) throws InterruptedException {

        waitForElementToBePresent(emailInput);
        emailInput.sendKeys(email);

        waitForElementToBePresent(continueButton);
        continueButton.click();

        return new LoginPage(driver);
    }
}
