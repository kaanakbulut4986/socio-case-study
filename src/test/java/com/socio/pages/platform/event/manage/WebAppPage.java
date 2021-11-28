package com.socio.pages.platform.event.manage;

import com.socio.pages.BasePage;
import com.socio.pages.app.AuthPage;
import com.socio.pages.platform.event.edit.FeaturesPage;
import com.socio.utils.ClipboardUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Set;

public class WebAppPage extends BasePage {

    private static String currentWindowHandle;

    @FindBy(xpath = "//*[@id='rs-wrapper']/article/div/div/div[2]/div/div/div/div[1]/div/div/div[2]/div/div/div/div")
    private WebElement statusSwitch;

    @FindBy(xpath = "//h4[text()='Analytics Tracking Alert']")
    private WebElement analyticsTrackingAlert;

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//button[text()='Copy Link']")
    private WebElement copyLinkButton;

    @FindBy(xpath = "//li[a[contains(text(),'Edit')]]")
    private WebElement editEventNavLink;

    public WebAppPage(WebDriver driver) {
        super(driver);
    }

    public WebAppPage enableWebApp() throws InterruptedException {

        try {

            waitForElementToBePresent(analyticsTrackingAlert, 1000);

        }catch (Exception ex){

            waitForElementToBePresent(statusSwitch, 1000);
            statusSwitch.click();

            waitForElementToBePresent(saveButton, 1000);
            saveButton.click();

        }

        return new WebAppPage(driver);
    }

    public WebAppPage copyLink() throws InterruptedException {

        waitForElementToBePresent(copyLinkButton, 1000);
        copyLinkButton.click();

        return new WebAppPage(driver);
    }

    public AuthPage openLinkInNewWindow() throws IOException, UnsupportedFlavorException {

        currentWindowHandle = driver.getWindowHandle();

        //Open New Window
        Set<String> currentWindows = driver.getWindowHandles();
        ((JavascriptExecutor) driver).executeScript("window.open();");
        Set<String> appWindows = driver.getWindowHandles();
        appWindows.removeAll(currentWindows);
        String appWindowHandle = ((String) appWindows.toArray()[0]);
        driver.switchTo().window(appWindowHandle);

        //Navigate To Url
        //TODO: Commented out due to unsupport Clipboard actions in BrowserStack
        //driver.get(ClipboardUtils.readFromClipboard());
        driver.get("https://staging.app.socio.events/MjQ0Mjc%3D/overview");

        return new AuthPage(driver);
    }

    public WebAppPage switchToWebAppWindow(){

        driver.switchTo().window(currentWindowHandle);

        return new WebAppPage(driver);
    }

    public FeaturesPage clickEditEvent() {

        waitForElementToBePresent(editEventNavLink);
        editEventNavLink.click();

        return new FeaturesPage(driver);
    }
}
