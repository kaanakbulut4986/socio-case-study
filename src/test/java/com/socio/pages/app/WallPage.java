package com.socio.pages.app;

import com.socio.pages.BasePage;
import com.socio.pages.platform.event.manage.WebAppPage;
import com.socio.utils.ClipboardUtils;
import com.socio.utils.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

public class WallPage extends BasePage {

    @FindBy(css = "*[data-testid='new-post-text']")
    private WebElement newPostText;

    @FindBy(xpath = "//textarea[@placeholder='What’s on your mind, Test?']")
    private WebElement newPostTextArea;

    @FindBy(css = "*[data-testid='post-modal-add-image']")
    private WebElement addImageButton;

    @FindBy(xpath = "//div[contains(@class,'fsp-drop-area__title')]")
    private WebElement fileSelector;

    @FindBy(xpath = "//span[@title='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//span[@title='Upload']")
    private WebElement uploadButton;

    @FindBy(css = "*[data-testid='post-modal-send']")
    private WebElement sendButton;

    //@FindBy(xpath = "//div[@data-testid='post-list-item-detail'")
    @FindBy(css = "*[data-testid='post-list-item-detail']")
    private List<WebElement> postListItems;

    public WallPage(WebDriver driver) {
        super(driver);
    }

    public WallPage clickNewPostText() {
        waitForElementToBePresent(newPostText);
        newPostText.click();

        return new WallPage(driver);
    }

    public WallPage writeNewPost(String postContent) {
        waitForElementToBePresent(newPostTextArea);
        newPostTextArea.sendKeys(postContent);

        return new WallPage(driver);
    }

    public WallPage clickAddImage() throws InterruptedException {
        waitForElementToBePresent(addImageButton, 1000);
        addImageButton.click();

        return new WallPage(driver);
    }

    public WallPage selectAndUploadImage() throws InterruptedException, IOException, UnsupportedFlavorException, AWTException {

        waitForElementToBePresent(fileSelector);
        fileSelector.click();

        ClipboardUtils.writeToClipboard(FileUtils.getPostImageFileName());
        ClipboardUtils.pasteFromClipboard();


        waitForElementToBePresent(saveButton, 1000);
        saveButton.click();

        waitForElementToBePresent(uploadButton, 1000);
        uploadButton.click();

        return new WallPage(driver);
    }

    public WallPage sendPost() throws InterruptedException {

        waitForElementToBePresent(sendButton, 3000);
        sendButton.click();

        waitForElementsToBePresent(postListItems, 2000);

        return new WallPage(driver);
    }

    public WebAppPage closeWindow(){

        driver.close();

        return new WebAppPage(driver);
    }
}
