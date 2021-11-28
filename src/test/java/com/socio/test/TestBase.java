package com.socio.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

    private static final String AUTOMATE_USERNAME = "";
    private static final String AUTOMATE_ACCESS_KEY = "";
    private static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }


    @BeforeSuite
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("project", "Create Post For Event");
        caps.setCapability("build", "Build 1.0");
        caps.setCapability("browserstack.local", "false");
        caps.setCapability("browserstack.selenium_version", "3.141.59");
        caps.setCapability("project", "Kaan Akbulut - Socio Case Study");
        caps.setCapability("name", "Case Study - Create Post For Event");

        //RemoteWebDriver
        driver.set(new RemoteWebDriver(new URL(URL), caps));

        //LocalWebDriver
        //TODO: Uncomment for using local web driver
        /*WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());*/

        getDriver().manage().window().maximize();

    }

    @AfterSuite
    public void TearDown(){
        driver.get().quit();
    }

}
