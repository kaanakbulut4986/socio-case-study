package com.socio.pages.app;

import com.socio.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "password-input")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public OverviewPage loginWith(String password) throws InterruptedException {

        waitForElementToBePresent(passwordInput);
        passwordInput.sendKeys(password);

        waitForElementToBePresent(loginButton);
        loginButton.click();

        return new OverviewPage(driver);
    }
}
