package com.lemsst.bangsamoro.test;

import com.lemsst.bangsamoro.core.data.ExcelDataManager;
import com.lemsst.bangsamoro.core.data.TestScenarioData;
import com.lemsst.bangsamoro.core.data.YAMLTestDataManager;
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

public class HomeTest {

    private static final Logger LOGGER = LogManager.getLogger(HomeTest.class.getName());
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

    /**
     * One @Test is one test scenario
     */
    @Test(testName = "Successful log in", enabled = false)
    public void SCENARIO_001() {
        // Test Data
        TestScenarioData testData = YAMLTestDataManager.getScenarioTestData("TS001.yaml");

        LoginPage loginPage = new LoginPage(driver);

        // Step 1: Enter username and password then click 'Sign In'
        FlightFinderPage flightFinderPage = loginPage.typeUsername(testData.getData().get("username"))
                .typePassword(testData.getData().get("password")).clickSignIn();
        LOGGER.info("Step 1 completed");

        // Step 2: Verify that Flight Finder Page is displayed
        softAssert.assertTrue(flightFinderPage.isPageLoaded(), "Verify Flight Finder page is displayed.");

        softAssert.assertAll();
    }

    @Test(testName = "Successful log in", dataProviderClass = ExcelDataManager.class, dataProvider = "dp")
    public void SCENARIO_002(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);

        // Step 1: Enter username and password then click 'Sign In'
        FlightFinderPage flightFinderPage = loginPage.typeUsername(username)
                .typePassword(password).clickSignIn();
        LOGGER.info("Step 1 completed");

        // Step 2: Verify that Flight Finder Page is displayed
        softAssert.assertTrue(flightFinderPage.isPageLoaded(), "Verify Flight Finder page is displayed.");

        softAssert.assertAll();
    }


    @Test(testName = "Unsuccessful log in", enabled = false)
    public void SCENARIO_003() {
        // Test Data
        TestScenarioData testData = YAMLTestDataManager.getScenarioTestData("TS002.yaml");

        LoginPage loginPage = new LoginPage(driver);

        // Step 1: Enter username and password then click 'Sign In'. Login page should still be displayed
        LoginPage postLoginPage = loginPage.typeUsername(testData.getData().get("username"))
                .typePassword(testData.getData().get("password")).clickSignInExpectingError();
        LOGGER.info("Step 1 completed");

        // Step 2: Verify the error message
        softAssert.assertTrue(postLoginPage.isPageLoaded(), "Verify Flight Finder page is displayed.");

        softAssert.assertAll();
    }

    @Test(enabled = false)
    public void signInTestUsingBy() {
        // Test Data
        TestScenarioData testData = YAMLTestDataManager.getScenarioTestData("TS001.yaml");

        com.lemsst.bangsamoro.core.pom.LoginPage loginPage = new  com.lemsst.bangsamoro.core.pom.LoginPage(driver);

        // Step 1: Enter username and password then click 'Sign In'
        com.lemsst.bangsamoro.core.pom.FlightFinderPage flightFinderPage = loginPage.typeUsername(testData.getData().get("username"))
                .typePassword(testData.getData().get("password")).clickSignIn();
        LOGGER.info("Step 1 completed");

        // Step 2: Verify that Flight Finder Page is displayed
        softAssert.assertTrue(flightFinderPage.isPageLoaded(), "Verify Flight Finder page is displayed.");

        softAssert.assertAll();
    }



}
