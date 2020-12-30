package com.web.application.e2e.automator.flights.pagecompnents;

import com.web.application.e2e.automator.annotations.Page;
import com.web.application.e2e.automator.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class MailingInformation extends BasePage {

    @FindBy(name = "address1")
    private WebElement address;

    @FindBy(name = "city")
    private WebElement city;

    @FindBy(name = "state")
    private WebElement stateProvince;

    @FindBy(name = "postalCode")
    private WebElement postalCode;

    @FindBy(name = "country")
    private WebElement country;

    public void fillMailingInformations(String addRess, String cIty, String state, String pCode, String cOuntry) {
        please(TYPE, addRess, this.address);
        please(TYPE, cIty, this.city);
        please(TYPE, state, this.stateProvince);
        please(TYPE, pCode, this.postalCode);
        please(SELECT_THE_TEXT, cOuntry, this.country);
    }

    @Override
    public boolean hasItLoaded() {
        return verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.address) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.city) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.stateProvince) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.postalCode) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.country);
    }

}