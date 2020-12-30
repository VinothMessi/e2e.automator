package com.web.application.e2e.automator.flights.pages;

import com.web.application.e2e.automator.annotations.Page;
import com.web.application.e2e.automator.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@Page
public class BillingAddressPage extends BasePage {

    @FindBy(id = "input_53_addr_line1")
    private WebElement addressLine1;

    @FindBy(id = "input_53_addr_line2")
    private WebElement addressLine2;

    @FindBy(id = "input_53_city")
    private WebElement city;

    @FindBy(id = "input_53_state")
    private WebElement state;

    @FindBy(id = "input_53_postal")
    private WebElement postalCode;

    @FindBy(id = "buyFlights")
    private WebElement buyFlights;

    public void fillInBillingAddress(String addLine1, String addLine2, String cIty, String sTate, String pCode) {
        please(TYPE, addLine1, this.addressLine1);
        please(TYPE, addLine2, this.addressLine2);
        please(TYPE, cIty, this.city);
        please(TYPE, sTate, this.state);
        please(TYPE, pCode, this.postalCode);
    }

    public void goToItineraryPage() {
        just(CLICK_ON, this.buyFlights);
    }

    @Override
    public boolean hasItLoaded() {
        await().atMost(5, TimeUnit.SECONDS).until(() -> verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.addressLine1));
        return verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.addressLine2) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.city) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.state) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.postalCode) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.buyFlights);
    }

}