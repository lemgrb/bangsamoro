package com.lemsst.bangsamoro.core.pom.withpagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {

    private String url = "http://newtours.demoaut.com/";

    @FindBy(name="userName")
    private WebElement userName;
    @FindBy(name="password")
    private WebElement password;
    @FindBy(name="login")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        LOGGER.info("Inside LoginPage constructor");
    }

    public void signIn(String username, String password) {
        LOGGER.info("Inside LoginPage.signIn(username,password);");
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        signInButton.click();
    }

    @Override
    public boolean isPageLoaded() {
        LOGGER.info("Inside LoginPage.isPageLoaded();");
        return signInButton.isDisplayed();
    }
}
