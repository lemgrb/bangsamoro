package com.lemsst.bangsamoro.core.pom;

import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private String url = "http://newtours.demoaut.com/";

    private LoginPage(WebDriver driver) {
        this.driver = driver;
    }

}
