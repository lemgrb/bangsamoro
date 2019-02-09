package com.lemsst.bangsamoro.core.driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public static WebDriverManager getDriverManager(DriverType type) {
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
