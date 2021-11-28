package com.socio.pages.platform.event.edit;

import com.socio.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class FeaturesPage extends BasePage {

    @FindBy(xpath = "//div[h4[text()='Wall']]")
    private WebElement wallTile;

    @FindBy(css = "*[data-testid='buttonEditFeature']")
    private WebElement editFeatureButton;


    public FeaturesPage(WebDriver driver) {
        super(driver);
    }

    public WallPage clickWallFeatureEditButton() throws InterruptedException {

        waitForElementToBePresent(wallTile, 1000);

        Actions builder = new Actions(driver);
        builder.moveToElement(wallTile).perform();

        waitAndClick(editFeatureButton);

        return new WallPage(driver);
    }


}
