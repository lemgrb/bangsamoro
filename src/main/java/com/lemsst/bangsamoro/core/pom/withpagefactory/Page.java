package com.lemsst.bangsamoro.core.pom.withpagefactory;

import com.lemsst.bangsamoro.core.driver.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {

    protected static final Logger LOGGER = LogManager.getLogger(Page.class.getName());

    private final String BASE_URL = "http://newtours.demoaut.com/";

    protected WebDriver driver;

    public Page(WebDriver driver) {
        LOGGER.info("Instantiating Page()");
        this.driver = driver;
        LOGGER.info("this.driver has been assigned with " + driver.toString());

    }

    public void visit() {
        LOGGER.info("inside Page.visit()");
        driver.get(BASE_URL);
    }

    protected abstract boolean isPageLoaded();

    protected void waitForJQuery() {

    }

    protected void waitForJS() {

    }

}
