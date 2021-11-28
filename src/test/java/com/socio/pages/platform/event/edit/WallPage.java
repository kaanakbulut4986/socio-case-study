package com.socio.pages.platform.event.edit;

import com.socio.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WallPage extends BasePage {

    @FindBy(xpath = "//div[@class='panel-body']")
    private WebElement panel;

    public WallPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPostInTheList(String postContent) throws InterruptedException {

        waitForElementToBePresent(panel, 3000);

        WebElement listItem = driver.findElement(By.xpath("//span[@title='"+postContent+"']"));

        return listItem != null;
    }
}
