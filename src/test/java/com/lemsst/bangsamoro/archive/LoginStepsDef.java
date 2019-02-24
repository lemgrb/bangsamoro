package com.lemsst.bangsamoro.archive;

import com.lemsst.bangsamoro.core.driver.DriverFactory;
import com.lemsst.bangsamoro.core.driver.DriverType;
import com.lemsst.bangsamoro.core.driver.WebDriverManager;
import com.lemsst.bangsamoro.core.pom.withpagefactory.FlightFinderPage;
import com.lemsst.bangsamoro.core.pom.withpagefactory.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginStepsDef {

    private static final Logger LOGGER = LogManager.getLogger(LoginStepsDef.class.getName());
    private LoginPage loginPage;
    private FlightFinderPage flightFinderPage;
    private WebDriverManager driverManager;
    private WebDriver driver;
    private SoftAssert softAssert;
    private final String BASE_URL = "http://newtours.demoaut.com/";

    public LoginStepsDef() {
        softAssert = new SoftAssert();
        driverManager = DriverFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get(BASE_URL);
    }


    @After
    public void cleanMethod() {
        driverManager.quit();
    }


    @Given("Navigate to the {string}")
    public void navigate_to_the(String string) {
        LOGGER.info("Navigating to Page: " + string);
        // TODO: Implement navigation framework
        driver.get(BASE_URL);
    }

    @When("I sign in with {string} and {string}")
    public void i_sign_in_with_and(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        flightFinderPage = loginPage.typeUsername(username)
                .typePassword(password)
                .clickSignIn();
    }

    @Then("System navigate to {string}")
    public void system_navigate_to(String string) {
        LOGGER.info("Verify system navigates to: " + string);
        Assert.assertTrue(flightFinderPage.isPageLoaded());
    }

}
