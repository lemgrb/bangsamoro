package com.lemsst.bangsamoro.core.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightFinderPage extends Page {

    private By findFlightsButton = By.name("findFlights");

    public FlightFinderPage(WebDriver driver) {
        super(driver);
        // Unlike @FindBy, NullPointerException if put on Superclass
        if(!isPageLoaded())
            throw new IllegalStateException("Page has not loaded.");
    }

    /**
     * This method will throw TimeoutException
     * @return
     */
    @Override
    public boolean isPageLoaded() {
        // What a hideous implementation
        return waitFor(findFlightsButton) != null;
    }
}
