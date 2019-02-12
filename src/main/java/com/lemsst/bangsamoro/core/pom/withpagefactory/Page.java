package com.lemsst.bangsamoro.core.pom.withpagefactory;

import com.lemsst.bangsamoro.core.driver.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {

    protected static final Logger LOGGER = LogManager.getLogger(Page.class.getName());

    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected abstract boolean isPageLoaded();

    protected void waitForJQuery() {}

    protected void waitForJS() {}

}
