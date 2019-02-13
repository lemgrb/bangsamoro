package com.lemsst.bangsamoro.test;

import com.lemsst.bangsamoro.core.driver.DriverFactory;
import com.lemsst.bangsamoro.core.driver.DriverType;
import com.lemsst.bangsamoro.core.driver.WebDriverManager;
import com.lemsst.bangsamoro.core.pom.withpagefactory.FlightFinderPage;
import com.lemsst.bangsamoro.core.pom.withpagefactory.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class HomeTest {

    private static final Logger LOGGER = LogManager.getLogger("HomeTest");
    private WebDriverManager driverManager;
    private WebDriver driver;
    private SoftAssert softAssert;
    private final String BASE_URL = "http://newtours.demoaut.com/";

    @BeforeClass
    public void initClass() {
        softAssert = new SoftAssert();
        driverManager = DriverFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get(BASE_URL);
   }

    @AfterClass
    public void cleanMethod() {
        driverManager.quit();
    }

    @Test
    public void signInTestUsingPageFactory() {
        LoginPage loginPage = new LoginPage(driver);

        // Step 1: Enter username and password then click 'Sign In'
        FlightFinderPage flightFinderPage = loginPage.typeUsername("lmorningstar578")
                .typePassword("Password123").clickSignIn();
        LOGGER.info("Step 1 completed");

        // Step 2: Verify that Flight Finder Page is displayed
        softAssert.assertTrue(flightFinderPage.isPageLoaded(), "Verify Flight Finder page is displayed.");

        softAssert.assertAll();
    }

    @Test
    public void signInTestUsingBy() {
        com.lemsst.bangsamoro.core.pom.LoginPage loginPage = new  com.lemsst.bangsamoro.core.pom.LoginPage(driver);

        // Step 1: Enter username and password then click 'Sign In'
        com.lemsst.bangsamoro.core.pom.FlightFinderPage flightFinderPage = loginPage.typeUsername("lmorningstar578")
                .typePassword("Password123").clickSignIn();
        LOGGER.info("Step 1 completed");

        // Step 2: Verify that Flight Finder Page is displayed
        softAssert.assertTrue(flightFinderPage.isPageLoaded(), "Verify Flight Finder page is displayed.");

        softAssert.assertAll();
    }



}
