package com.web.application.e2e.automator.visa.pagecomponents;

import com.web.application.e2e.automator.annotations.Page;
import com.web.application.e2e.automator.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class UserDetails extends BasePage {

    @FindBy(id = "first_4")
    private WebElement firstName;

    @FindBy(id = "middle_4")
    private WebElement middleName;

    @FindBy(id = "last_4")
    private WebElement lastName;

    @Override
    public boolean hasItLoaded() {
        return verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), firstName);
    }

    public void fillUserDetails(String fName, String lName) {
        please(TYPE, fName, firstName);
        please(TYPE, lName, lastName);
    }

}