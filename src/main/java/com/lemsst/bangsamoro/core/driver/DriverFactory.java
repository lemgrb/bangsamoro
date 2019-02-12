package com.lemsst.bangsamoro.core.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static final Logger LOGGER = LogManager.getLogger(DriverFactory.class.getName());

    public static WebDriverManager getDriverManager(DriverType type) {

        LOGGER.info("getDriver("+type+") called.");

        WebDriverManager webDriverManager = null;
        switch(type) {
            case CHROME:
                webDriverManager = new ChromeDriverManager();
                break;
            default:
                webDriverManager = new HtmlUnitDriverManager();
        }
        return webDriverManager;
    }

}
