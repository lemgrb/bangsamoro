package com.lemsst.bangsamoro.core.driver;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends WebDriverManager {

    /**
     * Refer to https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver
     *
     * TODO: Improve the implementation. See "Controlling ChromeDriver's lifetime' on this page:
     * https://sites.google.com/a/chromium.org/chromedriver/getting-started
     */
    public void create() {

        System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");

        // ChromeOptions options = new ChromeOptions();

        driver = new ChromeDriver();
    }

}
