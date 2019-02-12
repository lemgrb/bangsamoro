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

    private static final Logger LOGGER = LogManager.getLogger(HomeTest.class.getName());
    private WebDriverManager driverManager;
    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeClass
    public void initClass() {
        LOGGER.info("Is now inside initClass()");

        softAssert = new SoftAssert();
        LOGGER.info("softAssert instantiated");

        driverManager = DriverFactory.getDriverManager(DriverType.CHROME);
        LOGGER.info("driverManager has been assigned to " + driverManager.toString());

        driver = driverManager.getDriver();
        LOGGER.info("driver has been assigned to " + driver.toString());
    }

    @AfterClass
    public void cleanMethod() {
        driverManager.quit();
        LOGGER.info("driverManager.quit() called");
    }

    @Test
    public void signInTest() {
        LOGGER.info("Inside signInTest()");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        LOGGER.info("Instantiate LoginPage");
        FlightFinderPage flightFinderPage = PageFactory.initElements(driver, FlightFinderPage.class);
        LOGGER.info("Instantiate FlightFinderPage");

        // Step 1: Visit the page and verify page is loaded
        loginPage.visit();
        softAssert.assertTrue(loginPage.isPageLoaded(),"Verify that the Login Page is displayed.");
        LOGGER.info("Step 1 completed");

        // Step 2: Enter username and password then click 'Sign In'
        loginPage.signIn("lmorningstar578","Password123");
        softAssert.assertTrue(flightFinderPage.isPageLoaded(), "Verify that the logged in page is displayed when correct log in credentials are used.");
        LOGGER.info("Step 2 completed");

        softAssert.assertAll();
    }



}
