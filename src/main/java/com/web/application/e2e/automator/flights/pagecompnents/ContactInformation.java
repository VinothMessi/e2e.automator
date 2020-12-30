package com.web.application.e2e.automator.flights.pagecompnents;

import com.web.application.e2e.automator.annotations.Page;
import com.web.application.e2e.automator.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class ContactInformation extends BasePage {

    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(name = "phone")
    private WebElement phone;

    @FindBy(name = "userName")
    private WebElement email;

    public void fillContactInformations(String fName, String lName, String pHone, String eMail) {
        please(TYPE, fName, this.firstName);
        please(TYPE, lName, this.lastName);
        please(TYPE, pHone, this.phone);
        please(TYPE, eMail, this.email);
    }

    @Override
    public boolean hasItLoaded() {
        return verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.firstName) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.lastName) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.phone) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.email);
    }

}