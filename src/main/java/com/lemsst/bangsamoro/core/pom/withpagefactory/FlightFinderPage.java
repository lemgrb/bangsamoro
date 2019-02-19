package com.lemsst.bangsamoro.core.pom.withpagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightFinderPage extends Page {

    private String path = "mercuryreservation.php";

    @FindBy(name="findFlights")
    private WebElement findFlightsButton;

    public FlightFinderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageLoaded() {
        WebDriverWait waiter = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
        WebElement element = waiter.until(ExpectedConditions.elementToBeClickable(findFlightsButton));
        return findFlightsButton.isDisplayed();
    }
}
