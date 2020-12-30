package com.web.application.e2e.automator.flights.pages;

import com.web.application.e2e.automator.annotations.Page;
import com.web.application.e2e.automator.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@Page
public class FlightItineraryPage extends BasePage {

    @FindBy(xpath = "(//div[@id='cid_37']/table)[7]//font")
    private List<WebElement> itineraryDetails;

    @FindBy(xpath = "//font[text()='Flight Itinerary Page']")
    private WebElement pageHeader;

    public void getConfirmationMessages() {
        this.itineraryDetails.stream().forEach(e -> System.out.println(e.getText()));
    }

    public void shutDown() {
        just(CLOSE_CURRENT_BROWSER);
    }

    @Override
    public boolean hasItLoaded() {
        await().atMost(5, TimeUnit.SECONDS).until(() -> verifyWhether(WE_CAN_SEE, this.pageHeader));
        return verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.pageHeader);
    }

}