package com.socio.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 5, 1000);
        PageFactory.initElements(driver, this);
    }

    protected void waitForElementToBePresent(WebElement element, long millis) throws InterruptedException {
        Thread.sleep(millis);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToBePresent(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementsToBePresent(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    protected void waitForElementsToBePresent(List<WebElement> elements, long millis) throws InterruptedException {
        Thread.sleep(millis);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    protected void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

}
