package com.lemsst.bangsamoro.test;

import com.lemsst.bangsamoro.core.driver.DriverFactory;
import com.lemsst.bangsamoro.core.driver.DriverType;
import com.lemsst.bangsamoro.core.driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomeTest {

    private WebDriverManager driverManager;
    private WebDriver driver;
    private SoftAssert softAssert;


    @BeforeClass
    public void initClass() {
        softAssert = new SoftAssert();
    }

    @BeforeMethod
    public void initMethod() {
        driverManager = DriverFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getDriver();
    }

    @Test
    public void PROJECT_TC_01() {
        driver.get("https://www.gov.ph/");
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        WebElement element = waiter.until(ExpectedConditions.elementToBeClickable(By.id("portlet_ngpsearchcore")));
        String expected = "Home - GOV.P";
        softAssert.assertEquals(driver.getTitle(), expected,"Verify the Page Title.");
        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanMethod() {
        driverManager.quit();
    }

}
