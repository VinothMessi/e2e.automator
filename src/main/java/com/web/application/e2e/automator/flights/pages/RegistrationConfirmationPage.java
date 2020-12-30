package com.web.application.e2e.automator.flights.pages;

import com.web.application.e2e.automator.annotations.Page;
import com.web.application.e2e.automator.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@Page
public class RegistrationConfirmationPage extends BasePage {

    @FindBy(xpath = "(//div[@id='cid_37']//h1)[2]")
    private WebElement pageHeader;

    @FindBy(xpath = "//a[text()=' sign-in ']")
    private WebElement signInLink;

    @FindBy(id = "flight-link")
    private WebElement flightsLink;

    public String getPageHeader() {
        return fetch(TEXT_FROM, this.pageHeader);
    }

    public void goToFlightDetailsPage() {
        just(CLICK_ON, this.flightsLink);
    }

    @Override
    public boolean hasItLoaded() {
        await().atMost(5, TimeUnit.SECONDS).until(() -> verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.pageHeader));
        return verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.signInLink) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.flightsLink);
    }

}