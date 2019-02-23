package com.lemsst.bangsamoro.test;

import com.lemsst.bangsamoro.core.data.ExcelDataManager;
import com.lemsst.bangsamoro.core.driver.DriverFactory;
import com.lemsst.bangsamoro.core.driver.DriverType;
import com.lemsst.bangsamoro.core.driver.WebDriverManager;
import com.lemsst.bangsamoro.core.pom.withpagefactory.FlightFinderPage;
import com.lemsst.bangsamoro.core.pom.withpagefactory.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

public class LoginTest {

    private static final Logger LOGGER = LogManager.getLogger(LoginTest.class.getName());
    private WebDriverManager driverManager;
    private WebDriver driver;
    private SoftAssert softAssert;
    private final String BASE_URL = "http://newtours.demoaut.com/";

    @BeforeClass
    public void initClass() {
        softAssert = new SoftAssert();
    }

    @BeforeMethod
    public void initBrowser() {
        driverManager = DriverFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void cleanMethod() {
        driverManager.quit();
    }


    @Test(description = "Log in successfully", dataProviderClass = ExcelDataManager.class, dataProvider = "dp")
    public void TS_001(HashMap<String,String> testData) {
        LoginPage loginPage = new LoginPage(driver);

        // Step 1: Enter username and password then click 'Sign In'
        FlightFinderPage flightFinderPage = loginPage.typeUsername(testData.get("USERNAME"))
                .typePassword(testData.get("PASSWORD")).clickSignIn();
        LOGGER.info("Step 1 completed");

        // Step 2: Verify that Flight Finder Page is displayed
        softAssert.assertTrue(flightFinderPage.isPageLoaded(), "Verify Flight Finder page is displayed.");

        softAssert.assertAll();
    }
}
