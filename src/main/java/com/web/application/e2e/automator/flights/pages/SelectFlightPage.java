package com.web.application.e2e.automator.flights.pages;

import com.web.application.e2e.automator.annotations.Page;
import com.web.application.e2e.automator.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@Page
public class SelectFlightPage extends BasePage {

    @FindBy(xpath = "(//h1[contains(text(),'Select Flight')]/following-sibling::table/tbody)[1]")
    private WebElement departureFlightTable;

    @FindBy(xpath = "(//h1[contains(text(),'Select Flight')]/following-sibling::table/tbody)[2]")
    private WebElement arrivalFlightTable;

    @FindBy(id = "reserveFlights")
    private WebElement reserveFlights;

    public void goToBillingAddressPage() {
        just(CLICK_ON, this.reserveFlights);
    }

    @Override
    public boolean hasItLoaded() {
        await().atMost(5, TimeUnit.SECONDS).until(() -> verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.departureFlightTable));
        return verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.arrivalFlightTable);
    }

}