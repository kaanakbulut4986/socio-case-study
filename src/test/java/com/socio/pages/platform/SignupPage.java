package com.socio.pages.platform;

import com.socio.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage {

    @FindBy(css = "*[data-testid='linkLogin']")
    private WebElement logInLink;

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage navigateToLogIn() {
        logInLink.click();
        return new LoginPage(driver);
    }
}
