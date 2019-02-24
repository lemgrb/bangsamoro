package com.lemsst.bangsamoro.test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features={"src/test/resources/com.lemsst.bangsamoro.test/features"},
        glue={"com.lemsst.bangsamoro.steps"}
)
public class LoginTest extends AbstractTestNGCucumberTests {
}
