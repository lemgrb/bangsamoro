package com.lemsst.bangsamoro.core.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Textbox extends PageFactory {

    // https://www.infoq.com/articles/gui-automation-patterns
    // https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/pagefactory/ElementLocatorFactory.html
    // https://www.toolsqa.com/selenium-webdriver/page-object-pattern-model-page-factory/
    // TODO: Read http://www.testautomationguru.com/selenium-webdriver-design-patterns-in-test-automation-decorator-design-pattern/
    // TODO: Read https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/PageFactory.html
    // TODO: Read https://stackoverflow.com/questions/39178115/what-is-the-use-of-elementlocatorfactory-and-fielddecorator-in-page-factory
    // TODO: Read http://www.alechenninger.com/2014/07/a-case-study-of-javas-dynamic-proxies_14.html

    @FindBy
    private WebElement e;

    public Textbox() {

    }

}
