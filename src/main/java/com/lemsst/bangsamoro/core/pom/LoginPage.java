package com.lemsst.bangsamoro.core.pom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page {

    protected static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());

    private By userName = By.name("userName");
    private By password = By.name("password");
    private By signInButton  = By.name("login");

    public LoginPage(WebDriver driver) {
        super(driver);
        // Unlike @FindBy, NullPointerException if put on Superclass
        if(!isPageLoaded())
            throw new IllegalStateException("Page has not loaded.");
    }

    public LoginPage typeUsername(String userName) {
        WebElement element = waitFor(this.userName);
        element.sendKeys(userName);
        return this;
    }

    public LoginPage typePassword(String password) {
        WebElement element = waitFor(this.password);
        element.sendKeys(password);
        return this;
    }

    public FlightFinderPage clickSignIn() {
        WebElement element = waitFor(signInButton);
        element.click();
        return new FlightFinderPage(driver);
    }

    public  LoginPage clickSignInExpectingError() {
        WebElement element = waitFor(signInButton);
        element.click();
        return this;
    }

    public FlightFinderPage signIn(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return clickSignIn();
    }

    /**
     * This method will throw TimeoutException
     * @return
     */
    @Override
    public boolean isPageLoaded() {
        // What a hideous implementation
        return waitFor(signInButton) != null;
    }

}
