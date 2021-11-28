package com.socio.pages.app;

import com.socio.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends BasePage {

    @FindBy(xpath = "//span[text()='Wall']")
    private WebElement wallLink;

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public WallPage clickToWall(){

        waitForElementToBePresent(wallLink);
        wallLink.click();

        return  new WallPage(driver);

    }


}
