package com.lemsst.bangsamoro.core.driver;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverManager {

    protected WebDriver driver;

    protected abstract void create();

    public void quit() {
        if(driver!=null) {
            driver.quit();
            // driver=null
        }
    }

    public WebDriver getDriver() {
        if(driver==null)
            create();
        return driver;
    }

}
