package com.socio.test.event;

import com.socio.pages.platform.HomePage;
import com.socio.pages.platform.event.edit.WallPage;
import com.socio.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


public class EventTests extends TestBase {

    @Test
    @Parameters({ "post-content", "email", "password" })
    public void userShouldCreatePostForEvent(String postContent, String email, String password) throws InterruptedException, IOException, UnsupportedFlavorException, AWTException {

        WallPage wallPage = new HomePage(getDriver())
                .goToHomePageAndRedirectToSignUp()
                .navigateToLogIn()
                .loginWith(email,password)
                .navigateToMyEvents()
                .clickEvent()
                .clickWebApp()
                .enableWebApp()
                .copyLink()
                .openLinkInNewWindow()
                .authWith(email)
                .loginWith(password)
                .clickToWall()
                .clickNewPostText()
                .writeNewPost(postContent)
                //TODO: Commented out due to unsupport Clipboard actions in BrowserStack
                //.clickAddImage()
                //.selectAndUploadImage()
                .sendPost()
                .closeWindow()
                .switchToWebAppWindow()
                .clickEditEvent()
                .clickWallFeatureEditButton();

        Assert.assertTrue(wallPage.isPostInTheList(postContent));

    }
}
