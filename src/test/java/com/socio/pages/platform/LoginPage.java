package com.socio.pages.platform;

import com.socio.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "*[data-testid='btnLogin']")
    private WebElement logInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage loginWith(String email, String password) {
        waitForElementToBePresent(emailInput);
        emailInput.sendKeys(email);

        waitForElementToBePresent(passwordInput);
        passwordInput.sendKeys(password);

        logInButton.click();

        return new HomePage(driver);
    }

}
