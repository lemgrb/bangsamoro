package com.lemsst.bangsamoro.test;

import com.lemsst.bangsamoro.core.driver.DriverFactory;
import com.lemsst.bangsamoro.core.driver.DriverType;
import com.lemsst.bangsamoro.core.driver.WebDriverManager;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import org.apache.logging.log4j.Logger;

public class Stepdefs {

    private static final Logger log = LogManager.getLogger(Stepdefs.class);
    private static WebDriverManager driverManager;
    private static WebDriver driver;
    private static SoftAssert softAssert;
    private static String actual;

    public Stepdefs() {
        initClass();
        initMethod();
    }

    @BeforeClass
    public void initClass() {
        softAssert = new SoftAssert();
    }

    @BeforeMethod
    public void initMethod() {
        driverManager = DriverFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void cleanMethod() {
        driverManager.quit();
    }

    @Given("user visits the Homepage")
    public void user_visits_the_Homepage() {
        log.info("driver value is " + driver);
        driver.get("https://www.gov.ph/");
    }

    @When("I check the Page Title")
    public void i_check_the_Page_Title() {
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        WebElement element = waiter.until(ExpectedConditions.elementToBeClickable(By.id("portlet_ngpsearchcore")));
        actual = driver.getTitle();
    }

    @Then("I should see \"([^\"]*)\"$")
    public void i_should_see(String expected) {
        softAssert.assertEquals(driver.getTitle(), expected,"Verify the Page Title.");
        softAssert.assertAll();
    }

    @After()
    public void closeBrowser() {
        cleanMethod();
    }
}