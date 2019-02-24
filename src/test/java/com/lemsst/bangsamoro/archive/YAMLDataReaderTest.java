package com.lemsst.bangsamoro.archive;

import com.lemsst.bangsamoro.core.data.TestScenario;
import com.lemsst.bangsamoro.core.data.YAMLDataManager;
import com.lemsst.bangsamoro.core.driver.DriverFactory;
import com.lemsst.bangsamoro.core.driver.DriverType;
import com.lemsst.bangsamoro.core.driver.WebDriverManager;
import com.lemsst.bangsamoro.core.pom.withpagefactory.FlightFinderPage;
import com.lemsst.bangsamoro.core.pom.withpagefactory.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class YAMLDataReaderTest {

    private static final Logger LOGGER = LogManager.getLogger(YAMLDataReaderTest.class.getName());
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

    @Test(testName = "Successful log in", dataProviderClass = YAMLDataManager.class, dataProvider = "dp")
    @TestScenario(name="SCENARIO_002")
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


}
