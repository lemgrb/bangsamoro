package com.lemsst.bangsamoro.core.driver;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverManager extends WebDriverManager {

    public void create() {

        driver = new HtmlUnitDriver();
    }

}
