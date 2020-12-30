package com.web.application.e2e.automator.flights.pages;

import com.web.application.e2e.automator.annotations.Page;
import com.web.application.e2e.automator.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.*;

@Page
public class FlightHomePage extends BasePage {

    @FindBy(id = "header_14")
    private WebElement pageHeader;

    @FindBy(className = "form-image")
    private WebElement logo;

    @FindBy(xpath = "//a[text()='SIGN-ON']")
    private WebElement signOnLink;

    @FindBy(xpath = "//a[text()='REGISTER']")
    private WebElement registerLink;

    @FindBy(xpath = "//a[text()='SUPPORT']")
    private WebElement supportLink;

    @FindBy(xpath = "//a[text()='CONTACT']")
    private WebElement contactLink;

    public void goTo(final String appUrl) {
        just(MAXIMIZE_THE_BROWSER);
        just(NAVIGATE_TO, appUrl);
    }

    public String getPageHeader() {
        return fetch(PAGE_TITLE);
    }

    @Override
    public boolean hasItLoaded() {
        await().atMost(5, TimeUnit.SECONDS).until(() -> verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.signOnLink));
        return verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.registerLink) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.supportLink) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), this.contactLink);
    }

    public void startRegistration() {
        just(CLICK_ON, this.registerLink);
    }

}