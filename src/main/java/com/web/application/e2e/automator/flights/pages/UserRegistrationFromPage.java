package com.web.application.e2e.automator.flights.pages;

import com.web.application.e2e.automator.annotations.Object;
import com.web.application.e2e.automator.annotations.Page;
import com.web.application.e2e.automator.basepage.BasePage;
import com.web.application.e2e.automator.flights.pagecompnents.ContactInformation;
import com.web.application.e2e.automator.flights.pagecompnents.MailingInformation;
import com.web.application.e2e.automator.flights.pagecompnents.UserInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.*;

@Page
public class UserRegistrationFromPage extends BasePage {

    @Object
    private ContactInformation contactInformation;

    @Object
    private MailingInformation mailingInformation;

    @Object
    private UserInformation userInformation;

    @FindBy(xpath = "(//div[@id='cid_37']//h1)[1]")
    private WebElement pageHeader;

    @FindBy(xpath = "(//div[@id='cid_37']//font)[1]")
    private WebElement pageDescription;

    @FindBy(name = "register")
    private WebElement submit;

    public String getPageHeader() {
        return fetch(TEXT_FROM, this.pageHeader);
    }

    public String getPageDescription() {
        return fetch(TEXT_FROM, this.pageDescription);
    }

    public void goToRegistrationConfirmationPage() {
        just(CLICK_ON, this.submit);
    }

    @Override
    public boolean hasItLoaded() {
        await().atMost(5, TimeUnit.SECONDS).until(() -> verifyWhether(WE_CAN_SEE, this.pageHeader));
        return verifyWhether(WE_CAN_SEE, this.pageDescription);
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public MailingInformation getMailingInformation() {
        return mailingInformation;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

}