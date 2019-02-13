package com.lemsst.bangsamoro.core.pom.withpagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page {

    @FindBy(name="userName")
    private WebElement userName;
    @FindBy(name="password")
    private WebElement password;
    @FindBy(name="login")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage typeUsername(String username) {
        userName.sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public FlightFinderPage clickSignIn() {
        signInButton.click();
        return new FlightFinderPage(driver);
    }

    public LoginPage clickSignInExpectingError() {
        signInButton.click();
        return new LoginPage(driver);
    }

    public FlightFinderPage signIn(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return clickSignIn();
    }

    @Override
    public boolean isPageLoaded() {
        WebDriverWait waiter = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
        WebElement element = waiter.until(ExpectedConditions.elementToBeClickable(signInButton));
        return signInButton.isDisplayed();
    }
}
