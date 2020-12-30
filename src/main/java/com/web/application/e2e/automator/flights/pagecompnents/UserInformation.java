package com.web.application.e2e.automator.flights.pagecompnents;

import com.web.application.e2e.automator.annotations.Page;
import com.web.application.e2e.automator.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class UserInformation extends BasePage {

    @FindBy(name = "email")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPassword;

    public void fillUserInformations(String uName, String passWord, String conPassword) {
        please(TYPE, uName, this.userName);
        please(TYPE, passWord, this.password);
        please(TYPE, conPassword, this.confirmPassword);
    }

    @Override
    public boolean hasItLoaded() {
        return verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.userName) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.password) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.confirmPassword);
    }

}