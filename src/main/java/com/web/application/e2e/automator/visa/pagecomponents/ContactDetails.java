package com.web.application.e2e.automator.visa.pagecomponents;

import com.web.application.e2e.automator.annotations.Page;
import com.web.application.e2e.automator.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class ContactDetails extends BasePage {

    @FindBy(id = "input_6")
    private WebElement userEmail;

    @FindBy(id = "input_27_area")
    private WebElement areaCode;

    @FindBy(id = "input_27_phone")
    private WebElement phoneNumber;

    @Override
    public boolean hasItLoaded() {
        return verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), userEmail);
    }

    public void fillContactDetails(String uEmail, String aCode, String pNumber) {
        please(TYPE, uEmail, userEmail);
        please(TYPE, aCode, areaCode);
        please(TYPE, pNumber, phoneNumber);
    }

}