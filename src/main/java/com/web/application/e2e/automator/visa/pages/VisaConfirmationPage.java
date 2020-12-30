package com.web.application.e2e.automator.visa.pages;


import com.web.application.e2e.automator.annotations.Page;
import com.web.application.e2e.automator.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.*;

@Page
public class VisaConfirmationPage extends BasePage {

    @FindBy(id = "panel")
    private WebElement panel;

    @FindBy(id = "requestnumber")
    private WebElement reqNumber;

    @Override
    public boolean hasItLoaded() {
        await().atMost(5, TimeUnit.SECONDS).until(() -> verifyWhether(WE_CAN_SEE, reqNumber));
        return verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), panel) &&
                verifyWhether(WE_CAN_SEE.and(WE_CAN_CLICK), reqNumber);
    }

    public String getConfirmationMessage() {
        return fetch(TEXT_FROM, panel);
    }

    public String getRequestNumber() {
        return fetch(TEXT_FROM, reqNumber);
    }

}