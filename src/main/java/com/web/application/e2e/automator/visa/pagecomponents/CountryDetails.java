package com.web.application.e2e.automator.visa.pagecomponents;

import com.web.application.e2e.automator.annotations.Page;
import com.web.application.e2e.automator.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class CountryDetails extends BasePage {

    @FindBy(id = "input_46")
    private WebElement fromCountry;

    @FindBy(id = "input_47")
    private WebElement toCountry;

    @Override
    public boolean hasItLoaded() {
        return verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), fromCountry);
    }

    public void fillCountryDetails(String fCountry, String tCountry) {
        please(SELECT_THE_VALUE, fCountry, fromCountry);
        please(SELECT_THE_VALUE, tCountry, toCountry);
    }

}